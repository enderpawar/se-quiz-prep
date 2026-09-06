# 소프트웨어공학 팀장 선정 퀴즈 대비

2026-09-08(화) 퀴즈 대비용 자바 실습. 준비 기간은 일·월 이틀.

## 왜 이 문제들인가

작년(2025) 퀴즈는 GitHub Classroom으로 배포된 **자동채점 자바 과제**였다.
교수님 본인 제출본이 공개되어 있어서 실제 내용을 확인할 수 있었다.

> [seoultech-se-course/seoultech-se-2025-github-practice-github-and-gradle-practice-Jindae](https://github.com/seoultech-se-course/seoultech-se-2025-github-practice-github-and-gradle-practice-Jindae)
>
> `MathFunction.java` 의 `max` / `fact` / `fib` 세 함수 + JUnit 5 테스트,
> `classroom.yml` 에서 테스트당 10점씩 자동채점.

여기서 알 수 있는 것 두 가지.

1. **난이도가 높지 않다.** `max`/`fact`/`fib` 수준이다. 겁먹을 필요 없다.
2. **명세는 테스트 코드가 정의한다.** 교수님이 준 원본 `fib` 는 일부러 고장나 있었다.
   `fib(0) = -1` 로 두면 `fib(2) = fib(1) + fib(0) = 0` 이 되어 테스트를 통과하지 못한다.
   즉 "짜는 문제"가 아니라 **"테스트를 읽고 고치는 문제"**였다.
   → **A1 이 그 문제 그대로다.**

올해는 eclass 온라인 단답형·객관식이라 형식은 다르지만, 재는 능력은 같다.
파이썬으로는 아는 것을 **자바 문법으로 정확히 표현**할 수 있는지가 승부처다.

## 실행법

```powershell
.\run.ps1                # 전체 실행
.\run.ps1 B1             # B1 문제만
.\run.ps1 tree           # 클래스 이름 일부로도 가능
.\run.ps1 -Solutions     # 정답 코드로 실행 (46/46 통과해야 정상)
```

실행이 막히면:

```powershell
powershell -ExecutionPolicy Bypass -File .\run.ps1
```

JDK만 있으면 된다 (이 PC는 JDK 17 확인됨). Gradle·JUnit 설치 불필요 —
`src/test/java/mini/` 에 JUnit과 같은 모양의 초소형 러너를 넣어 두었다.
실제 수업에서는 이 자리를 `gradle test` 가 대신한다.

## 문제 구성 (총 46개 테스트)

### A. 문법 되살리기 — 파이썬 → 자바 번역

| # | 클래스 | 다루는 것 |
|---|---|---|
| A1 | `MathFunction` | **2025년 실제 문제.** 삼항 연산자, 재귀, 테스트를 명세로 읽기 |
| A2 | `ArrayOps` | `arr.length` vs `s.length()` vs `list.size()`, `Arrays.sort/fill/copyOf`, 2차원 배열 |
| A3 | `StringOps` | `charAt`, `substring`, `split`(정규식!), `StringBuilder` |
| A4 | `CollectionOps` | `HashMap.getOrDefault/merge`, `HashSet`, `Comparator`, `PriorityQueue` |
| A5 | `EqualityTrap` | `==` vs `.equals()`, Integer 캐시, 정수 나눗셈, 오버플로 |

### B. 트리·그래프 — 이미 아는 알고리즘을 자바로

| # | 클래스 | 다루는 것 |
|---|---|---|
| B1 | `TreeTraversal` | 전위·중위·후위 순회 (단답형 1순위) |
| B2 | `LevelOrder` | BFS 레벨 순회, 최대 깊이, **LeetCode 199 우측면도** |
| B3 | `BstOps` | BST 삽입·탐색, **중위순회 = 정렬**, 유효성 검사 함정 |
| B4 | `GraphSearch` | 인접 리스트, BFS/DFS 방문 순서, 연결 요소 |
| B5 | `GridBfs` | 격자 최단거리, 섬 개수 |

## 푸는 순서

`src/main/java/prep/` 안의 `throw new UnsupportedOperationException("TODO");` 를
지우고 채우면 된다. 테스트 파일(`src/test/java/prep/`)은 **읽기만 하고 고치지 않는다.**
그게 명세다.

각 스켈레톤 주석에 대응하는 파이썬 코드를 적어 두었으니 그것부터 보면 된다.

### 오늘 (일)

1. 치트시트 1·2번 섹션 정독 (30분)
2. **A1 → A5** 풀기 (2시간)
3. 치트시트 함정 섹션 재확인 (20분)

### 내일 (월)

4. **B1 → B5** 풀기 (1.5시간)
5. 트리 순회 방문 순서를 **손으로 그려서** 써 보기 (30분) — 단답형 대비
6. 치트시트 OOP·Git·JUnit 섹션 암기 (1시간)
7. [테트리스 참고 코드](https://github.com/Jindae/SeoulTech-SE-Tetris-Ref) 30분 훑기
   — 퀴즈 대비 겸, 팀장 되면 바로 쓸 코드

## 막혔을 때

`solutions/prep/` 에 정답이 주석과 함께 들어 있다.

다만 **답을 본 문제는 파일을 닫고 처음부터 다시 타이핑할 것.**
읽어서 이해한 것과 손이 기억하는 것은 다르다. 화요일에 필요한 건 후자다.

## 참고: 이 과목이 어떻게 굴러가는가

- **팀 프로젝트 = Java Swing 테트리스.** 작년 팀 저장소는 9월 18일에 일괄 생성됐다.
  ([참고 코드](https://github.com/Jindae/SeoulTech-SE-Tetris-Ref) · [작년 팀 예시](https://github.com/eagleda/se-tetris-team6))
- **1주차는 Git/GitHub 실습.** fork → clone → branch → commit → merge → push → PR → Issue → mention
  ([se-practice](https://github.com/Jindae/se-practice))
- **채점이 테스트 중심.** 작년 요구사항에 "확률을 확인할 수 있는 단위 테스트가 존재해야 함" 같은 항목이 있었다.
  교수님 연구분야가 결함 위치 추정·자동 프로그램 수정·테스팅이다.
- 퀴즈 점수로 순위를 내고 그 순서로 팀을 짠다. **높게 받을수록 좋다.**
