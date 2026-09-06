<#
    사용법

      .\run.ps1                전체 문제 실행
      .\run.ps1 B1             B1 문제만 실행 (A1 A2 A3 A4 A5 B1 B2 B3 B4 B5)
      .\run.ps1 tree           클래스 이름 일부로도 고를 수 있다
      .\run.ps1 -Solutions     내 코드 대신 정답 코드로 실행 (전부 통과해야 정상)

    실제 수업에서는 이 역할을 Gradle 이 한다.  gradle test 한 줄이면 끝난다.
    여기서는 설치 없이 돌리려고 javac / java 만 쓴다.
#>
param(
    [string]$Only = "",
    [switch]$Solutions
)

$ErrorActionPreference = "Stop"
[Console]::OutputEncoding = [System.Text.Encoding]::UTF8

$root = $PSScriptRoot
$out = Join-Path $root "out"

if (Test-Path $out) { Remove-Item -Recurse -Force $out }
New-Item -ItemType Directory -Force -Path $out | Out-Null

# ---- 컴파일할 소스 모으기 -------------------------------------------------

$sources = @()

if ($Solutions) {
    [Console]::WriteLine("[정답 모드] solutions/prep 의 코드로 실행합니다.")
    $sources += (Get-ChildItem -Path (Join-Path $root "solutions\prep") -Filter *.java).FullName
    # TreeNode 는 solutions 에 없으므로 원본에서 가져온다
    $sources += (Join-Path $root "src\main\java\prep\TreeNode.java")
}
else {
    $sources += (Get-ChildItem -Path (Join-Path $root "src\main") -Recurse -Filter *.java).FullName
}

$sources += (Get-ChildItem -Path (Join-Path $root "src\test") -Recurse -Filter *.java).FullName

# javac 의 @파일 안에서는 역슬래시가 이스케이프 문자로 해석된다. 슬래시로 바꿔 적는다.
$argfile = Join-Path $out "sources.txt"
$sources | ForEach-Object { $_.Replace('\', '/') } | Set-Content -Path $argfile -Encoding ascii

# ---- 컴파일 ---------------------------------------------------------------

& javac -encoding UTF-8 -d $out "@$argfile"
if ($LASTEXITCODE -ne 0) {
    [Console]::WriteLine("")
    [Console]::WriteLine("컴파일 실패. 위에 뜬 오류부터 고치세요.")
    [Console]::WriteLine("(자바는 컴파일이 되어야 테스트를 돌려볼 수 있다. 파이썬과 다른 점이다)")
    exit 1
}

# ---- 테스트 실행 ----------------------------------------------------------

& java "-Dfile.encoding=UTF-8" -cp $out mini.MiniRunner $Only
exit $LASTEXITCODE
