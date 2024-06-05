# 01. 자바 프로젝트 준비하기

## 학습목표

- Gradle 빌드 도구를 사용하여 자바 프로젝트 폴더를 구성할 수 있다.
- Gradle 빌드 스크립트 파일에서 실행할 클래스를 설정할 수 있다.
- Gradle 빌드 도구를 사용하여 애플리케이션을 실행할 수 있다.
- 콘솔로 값을 출력할 수 있다.
- IntelliJ IDE에서 Gradle 프로젝트를 실행할 수 있다.

## 요구사항 

- myapp 폴더를 만들고 자바 프로젝트 폴더로 구성
- IntelliJ IDE로 프로젝트 가져온 후 실행 

## 실행 결과

```
[팀 프로젝트 관리 시스템]
```

## 작업

- 1) myapp 폴더 생성
```
$ mkdir myapp
$ cd myapp
```

- 2) 자바 프로젝트 폴더 구성
```
$ gradle init
Select type of build to generate:
  1: Application
  2: Library
  3: Gradle plugin
  4: Basic (build structure only)
Enter selection (default: Application) [1..4] 1

Select implementation language:
  1: Java
  2: Kotlin
  3: Groovy
  4: Scala
  5: C++
  6: Swift
Enter selection (default: Java) [1..6] 1

Enter target Java version (min: 7, default: 21): 그냥 엔터

Project name (default: myapp): 그냥 엔트

Select application structure:
  1: Single application project
  2: Application and library project
Enter selection (default: Single application project) [1..2] 1

Select build script DSL:
  1: Kotlin
  2: Groovy
Enter selection (default: Kotlin) [1..2] 2

Select test framework:
  1: JUnit 4
  2: TestNG
  3: Spock
  4: JUnit Jupiter
Enter selection (default: JUnit Jupiter) [1..4] 그냥 엔터

Generate build using new APIs and behavior (some features may change in the next minor release)? (default: no) [yes, no]  그냥 엔터

```

- 3) 애플리케이션 실행
```
$ gradle run

> Task :app:run
Hello World!

BUILD SUCCESSFUL in 2s
2 actionable tasks: 2 executed

```

- 4) IntelliJ IDE 로 프로젝트 가져오기
    - 프로젝트 열기: myapp/settings.gradle 선택 > 프로젝트 열기
- 5) 애플리케이션 제목을 출력: App.main()
- 6) 애플리케이션 실행
    - Gradle 도구: myapp/Tasks/application/run 실행 


## 변경한 파일

- build.gradle
```
application {
    mainClass = 'bitcamp.myapp.App'
}
```
- App.java

# 02. 리터럴과 변수를 사용해서 문자열 출력하기

## 학습목표

- 문자열 및 숫자 등을 리터럴로 표현할 수 있다.
- 변수를 사용하여 값을 다룰 수 있다.
- 출력문을 사용하여 값을 콘솔로 출력할 수 있다.

## 요구사항 

- 애플리케이션의 제목과 기본 메뉴 출력

## 실행 결과

```
----------------------------------------------
[팀 프로젝트 관리 시스템]

1. 회원
2. 팀
3. 프로젝트
4. 게시판
5. 도움말
6. 종료
----------------------------------------------
```

## 작업

- 1) 제목을 저장할 변수 선언 및 초기화: App.main()
- 2) 구분선을 저장할 변수 선언 및 초기화: App.main()
- 3) 메뉴를 저장할 변수 선언 및 초기화: App.main()
- 3) 제목, 구분선, 메뉴를 출력할 문장 작성: App.main()

## 소스 파일

- App.java

# 03. ANSI 이스케이프 코드를 사용하여 출력 문자열 꾸미기

## 학습목표

- ANSI 이스케이프 문자를 다룰 수 있다.
- Gradle 빌드 도구의 옵션을 이용하여 콘솔 출력을 제어할 수 있다.
- 코드 정리 기법 중 '설명하는 변수'를 활용할 수 있다.

## 요구사항 

- 애플리케이션 제목을 볼드체로 출력
- 위, 아래 구분선을 볼드체로 출력
- '6. 종료' 메뉴를 빨강색 + 볼드체로 출력
- Gradle 디버깅 출력은 제거

## 실행 결과

```
----------------------------------------------   <== 볼드체
[팀 프로젝트 관리 시스템]   <== 볼드체

1. 회원
2. 팀
3. 프로젝트
4. 게시판
5. 도움말
6. 종료   <== 빨강색 + 볼드체
----------------------------------------------   <== 볼드체
```

## 작업

- 1) 구분선, 제목, 종료 메뉴에 ANSI 이스케이프 문자를 적용: App.main()
- 2) 코드 정리 기법 '설명하는 변수'를 적용하여 ANSI 이스케이프 문자를 변수를 사용하여 출력 제어: App.main()
- 3) Gradle 콘솔 출력 제어: 실행 / 구성편집 / 실행 옵션 추가(--quiet)
    - `run --quiet`

## 소스 파일

- App.java

# 04. 키보드 입력 다루기

## 학습목표

- 키보드 입력을 다룰 수 있다.
- 조건문을 사용하여 실행을 분기할 수 있다.
- 반복문을 사용하여 특정 명령문을 반복해서 실행할 수 있다.
- Gradle로 run 태스크를 실행할 때 키보드를 표준 입력으로 사용할 수 있게 설정할 수 있다. 

## 요구사항 

- 사용자로부터 메뉴 번호를 입력 받기
- 메뉴 번호에 해당하는 메뉴 이름을 출력
- 종료 메뉴 번호를 입력하면 실행을 종료

## 실행 결과

```
----------------------------------------------  
[팀 프로젝트 관리 시스템]  

1. 회원
2. 팀
3. 프로젝트
4. 게시판
5. 도움말
6. 종료  
----------------------------------------------  
> 1
회원
> 3
프로젝트
> 9
메뉴 번호가 옳지 않습니다.
> 6
종료합니다.
```

## 작업

- 1) 프롬프트를 통해 입력 받는 기능을 구현: App.main()
  - java.util.Scanner, System.in 사용
- 2) 반복문을 이용하여 메뉴 입력을 반복해서 처리: App.main()
  - do ~ while 문 사용
- 3) 메뉴 번호에 따라 출력 문구를 변경하는 조건을 처리: App.main()
  - switch 문 사용

## 소스 파일

- build.gradle
```
run {
    standardInput = System.in // 기본 값은 empty stream 이다.
}
```
- App.java

