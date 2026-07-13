# 📒 학습 기록 (LEARNING_LOG)

> Claude Code 세션 시작 시 이 파일을 읽고, 이전 학습 내용을 파악한 뒤 이어서 강의할 것.
> 세션 종료 시 학습 내용을 이 파일에 자동으로 업데이트할 것.

---

## 🧑‍💻 학습자 정보

- 이름: (김도완)
- 현재 수준: 🌿 초급~중급 (Python Flask+SQL 경험, Java 스코프까지)
- 목표: 백엔드 개발

---

## 🗓️ 전체 진도 현황

| 언어/기술 | 상태 | 진도 | 마지막 학습일 |
|-----------|------|------|---------------|
| Java | 🟡 진행 중 | 인터페이스/다형성까지 완료 | 2026-05-30 |
| Python | 🟡 진행 중 | FastAPI 블로그 프로젝트 완성 | 2026-05-30 |
| JavaScript | ⬜ 미시작 | - | - |
| HTML/CSS | 🟡 진행 중 | 기초 HTML (수업 중) | - |
| Spring | 🟡 진행 중 | IoC/DI 개념 이해, 다음 세션부터 본격 시작 | 2026-05-30 |

> 상태 이모지: ✅ 완료 / 🟡 진행 중 / ⬜ 미시작 / ⏸️ 일시중단

---

## 📌 현재 학습 중인 언어/기술

- **언어**: Python / Java
- **IDE**: PyCharm (Python), IntelliJ (Java)
- **현재 단계**: Python - DAO 패턴 이해 완료 / Java - 스코프 진행 중
- **다음에 배울 것**: Java - 스코프 마무리 → 메서드

---

## 📝 세션 기록

### 2026-04-02
- **언어/기술**: Python - DAO 패턴
- **학습 내용**:
  - DAO(Data Access Object) 개념 이해 — SQL 코드를 한 곳에 모은 전담 클래스
  - `__init__` — 객체 생성 시 자동 실행되는 생성자, DB 연결을 딱 한 번만
  - `self` — "나(객체) 자신의 것"을 가리키는 표시 (`self.cur` = 나의 SQL 실행 펜)
  - `conn` vs `cur` — conn(DB 연결/은행 입장) vs cur(SQL 실행 창구 직원)
  - `fetchall()` vs `fetchone()` — 결과 전부 vs 한 개만 가져오기
  - MariaDB 디버깅 — `Unknown database 'pdata'` 오류 해결
  - MariaDB에서 `pdata` DB + `member` 테이블 직접 생성
- **완료한 퀴즈**: self.cur 의미 맞히기, fetchall() 역할 맞히기
- **실습 프로젝트**: 2026/0124/p01.py (회원관리 콘솔 앱) 정상 실행 확인
- **다음 세션 이어서 할 것**: Java 스코프 마무리 → 메서드
- **기억에 남는 키워드**: `self.cur = 나의 SQL 실행 펜`
- **막혔던 부분**: `Unknown database 'pdata'` 오류 (MariaDB에 DB 없었음), self 개념, cursor 개념

### 2026-05-30
- **언어/기술**: Java 기본편 + 스프링 개념 입문
- **학습 내용**:
  - `super()` / `this()` — 생성자 체이닝, 안쪽부터 실행되는 원리
  - 업캐스팅 / 다운캐스팅 — 자식→부모(자동), 부모→자식(명시), instanceof
  - `@Override` — 부모 메서드 덮어쓰기, 컴파일러 안전장치
  - 추상 클래스 / 추상 메서드 — abstract 키워드, 자식 구현 강제
  - 인터페이스 — implements, 모든 메서드 추상, 다중 구현 가능
  - 다형성 — Animal 배열 + for-each, soundAnimal() 하나로 모든 동물 처리
  - ArrayList — 크기 고정 배열의 한계, 동적 크기 리스트
  - IoC/DI 개념 — 제어의 역전, 의존성 주입, @Autowired
  - 스프링에서 인터페이스 활용 — MemberRepository 패턴, 구현체 교체
- **완료한 퀴즈**: 업캐스팅/다운캐스팅 위치 맞히기
- **실습 코드**: java-basic/src/poly/ex2, ex3, ex5, extends1/super2
- **다음 세션 이어서 할 것**: 스프링 부트 4 책으로 본격 스프링 시작
- **기억에 남는 키워드**: IoC/DI
- **막혔던 부분**: super2 생성자 체이닝 실행 순서 (this() 호출 시 대기 원리), for-each 문법

### 2026-06-08
- **언어/기술**: Spring Boot 4 — JPA 실습 + 테스트
- **학습 내용**:
  - **@DataJpaTest** — JPA만 가볍게 띄우는 테스트, 자동 롤백, H2 자동 설정
  - **@Sql** — 테스트 전 SQL 파일로 데이터 삽입
  - **Optional / .get()** — findById() 반환 타입, 값이 없으면 예외
  - **2L** — Long 타입 리터럴, findById()에 Long 전달
  - **1차 캐시** — 같은 트랜잭션 안에서 DB 안 가고 메모리에서 반환
  - **쓰기 지연** — SQL 모아뒀다가 커밋 시 한꺼번에 전송
  - **변경 감지(Dirty Checking)** — 값만 바꾸면 자동 UPDATE
  - **지연 로딩(Lazy Loading)** — 필요할 때만 DB 조회
  - **엔티티 매니저** — JPA의 핵심 도구, Python cursor와 유사
  - **스프링 데이터 JPA** — JpaRepository로 CRUD 자동 완성
  - **CRUD** — Create/Read/Update/Delete
  - **트랜잭션 커밋/롤백** — 전부 성공(커밋) or 전부 취소(롤백)
  - **동시성 문제** — 여러 사용자가 같은 데이터 동시 수정 시 충돌
  - **build.gradle 의존성** — spring-boot-data-jpa-test 추가, DataJpaTest 패키지 경로 수정
- **완료한 퀴즈**: 없음 (실습/디버깅 중심 세션)
- **실습**: MemberRepositoryTest — @DataJpaTest + @Sql + findAll() 테스트 성공
- **다음 세션 이어서 할 것**: 스프링 부트 4 책 이어서
- **기억에 남는 키워드**: `@DataJpaTest`, `Optional`
- **막혔던 부분**:
  - MemberRepositoryTest가 main 폴더에 잘못 생성됨 → 삭제
  - DataJpaTest import 경로 오류 (Spring Boot 4에서 패키지 변경됨)
  - test/resources 폴더 없어서 insert-members.sql 못 찾음

### 2026-06-01
- **언어/기술**: Spring Boot 4 + JPA 개념 입문
- **학습 내용**:
  - **IoC/DI 심화** — 구현체 직접 의존 → 인터페이스 분리 → 생성자 주입 → @Autowired 흐름
  - **빈(Bean)** — 스프링 컨테이너가 관리하는 객체, @Component로 등록
  - **@Component 패밀리** — @Service(비즈니스), @Repository(DB), @Controller(화면), @RestController(API)
  - **@Controller vs @RestController** — HTML 렌더링 vs 데이터(JSON/문자열) 반환
  - **@Transactional** — 전부 성공 or 전부 롤백, 은행 송금 비유
  - **@Entity** — 자바 클래스와 DB 테이블 연결, JPA의 시작점
  - **@Id / @GeneratedValue(IDENTITY)** — PK 지정, id 자동 증가를 DB에 위임
  - **GenerationType** — id 생성 전략 enum (IDENTITY, SEQUENCE, AUTO, TABLE)
  - **Java 문법** — instanceof, switch, case타입패턴매칭, formatted(), 파라미터, 파싱, Long vs String
- **완료한 퀴즈**: @Controller vs @RestController 차이 설명 (정답!)
- **다음 세션 이어서 할 것**: 스프링 부트 4 책 이어서 (JPA Repository, 연관관계 등)
- **기억에 남는 키워드**: `@RestController`
- **막혔던 부분**: 없음 (개념 질문 중심 세션)

### 2026-05-30 (2)
- **언어/기술**: Python - FastAPI 블로그 프로젝트
- **학습 내용**:
  - **FastAPI 라우터 구조** — APIRouter로 posts / comments / auth 분리
  - **JWT 인증** — `python-jose`로 토큰 생성, 쿠키에 저장, `get_current_user` Depends로 주입
  - **bcrypt 비밀번호 해싱** — `passlib[bcrypt]`로 해싱/검증, bcrypt 버전 호환 이슈 해결 (4.0.1 고정)
  - **PRG 패턴** — POST 후 RedirectResponse(303)로 새로고침 중복 제출 방지
  - **pymysql + DictCursor** — ORM 없이 raw SQL, 결과를 dict로 받기
  - **Jinja2 템플릿** — `{% if %}`, `{% for %}`, `{{ var | safe }}`, `{% extends %}` 상속 구조
  - **마크다운 렌더링** — `markdown` 라이브러리, fenced_code / codehilite / tables 확장
  - **댓글 소유권 체크** — `current_user.get("sub") == comment["username"]` 비교로 본인 댓글만 수정/삭제
  - **정적 파일 구조** — `static/css/style.css`, `static/js/main.js` 분리
  - **다크모드 / 애니메이션** — CSS `data-theme` 속성, `@keyframes fadeUp`, localStorage로 테마 유지
  - **Cloudflare Tunnel** — 계정 없이 임시 공개 URL 발급 (`cloudflared tunnel --url`)
  - **네트워크 기초** — `0.0.0.0` vs `127.0.0.1` 차이, 로컬 IP 확인 (`ipconfig getifaddr en0`)
  - **패키지 버전 호환** — starlette 0.41.3 + fastapi 0.115.12 고정, bcrypt 4.0.1 고정
- **완료한 퀴즈**: 없음 (프로젝트 실습 중심 세션)
- **실습 프로젝트**: `/Users/dg3w04/Code_Study/blog` — FastAPI 개인 블로그 (GitHub: dowan2010/Blog)
  - 기능: 게시글 CRUD, 댓글 CRUD, JWT 로그인/회원가입, 마크다운 렌더링, 다크모드, 검색
- **다음 세션 이어서 할 것**: 장기 배포 결정 (Render + Supabase 또는 Railway), 페이지네이션 추가
- **기억에 남는 키워드**: `PRG 패턴`, `JWT`, `bcrypt 버전 호환`
- **막혔던 부분**:
  - bcrypt 4.x와 passlib 호환 안 됨 → `bcrypt==4.0.1`로 다운그레이드
  - starlette 1.x 설치되어 `unhashable type: 'dict'` 오류 → 버전 고정으로 해결
  - venv 위치 혼동 (`/Code_Study/.venv` vs `/Code_Study/blog/.venv`)
  - 댓글 수정 폼이 기본으로 펼쳐지던 문제 → `style="display:none"` + JS 토글로 해결

---

## 🏆 완료한 개념 목록

### ☕ Java
- [ ] 변수 / 자료형
- [ ] 조건문 / 반복문
- [ ] 배열 / ArrayList
- [ ] 메서드
- [x] 클래스 / 객체
- [x] 생성자
- [x] 상속
- [x] 인터페이스 / 다형성
- [ ] 예외처리
- [ ] Collections (List, Map, Set)
- [ ] Stream API
- [ ] Spring 컨테이너 / DI
- [ ] Spring MVC1
- [ ] JPA / ORM

### 🐍 Python
- [x] 변수 / 자료형
- [x] 조건문 / 반복문
- [x] 함수
- [x] 리스트 / 딕셔너리
- [ ] 클래스 / 객체 (기초 수준 이해, 심화 필요)
- [ ] 파일 입출력
- [ ] 예외처리
- [x] Flask 기초
- [x] DB 연동 (pymysql + DAO 패턴)
- [x] FastAPI — 라우터, Depends, Form, RedirectResponse
- [x] JWT 인증 — 토큰 생성/검증, 쿠키 저장
- [x] 비밀번호 해싱 — bcrypt / passlib
- [x] Jinja2 템플릿 엔진
- [x] 마크다운 렌더링

### 🌐 JavaScript
- [ ] 변수 / 자료형
- [ ] 함수 / 화살표 함수
- [ ] DOM 조작
- [ ] 이벤트 처리
- [ ] fetch API / 비동기
- [ ] Promise / async-await

---

## 🐛 자주 막혔던 오류 모음

| 날짜 | 언어 | 오류 | 해결 방법 |
|------|------|------|-----------|
| - | - | - | - |

---

## 💡 나만의 메모

> 헷갈리는 개념, 나중에 다시 볼 것들을 자유롭게 적으세요.

-