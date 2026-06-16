# 프로젝트 소개
🏋️ Personal GYM : 운동 정보 공유와 사용자 간 소통을 지원하는 커뮤니티 웹 애플리케이션

## 프로젝트 개요
- Spring MVC 아키텍처를 적용하여 회원 관리, 게시판, 댓글, 파일 업로드 기능을 구현하였으며,  
MyBatis 기반 데이터 매핑 처리, Spring Security를 활용한 인증 및 인가 기능을 적용하였습니다.
------------------------------------------------------------------------------------------------
## 기술 스택
### Backend
| 구분      | 기술 |
|-----------|------|
| Language  | Java 8 |
| Framework | Spring Framework 5.2.11 |
| Security  | Spring Security 5.3.6 |
| ORM       | MyBatis 3.5.6 |

### Database / Infra
| 구분            | 기술 |
|-----------------|------|
| Database        | Oracle Database |
| Connection Pool | HikariCP |
| Server          | Apache Tomcat |

### Frontend
| 구분      | 기술 |
|-----------|------|
| View      | JSP |
| Markup    | HTML5 |
| Style     | CSS3 |
| Script    | JavaScript, jQuery |

### Build / Library
| 구분       | 기술 |
|------------|------|
| Build Tool | Maven |
| Library    | Lombok, Jackson, Gson, Thumbnailator, JCodec |
------------------------------------------------------------------------------------------------
## 주요 기능
### 회원
- 로그인 / 로그아웃
- 회원 CRUD
- Spring Security 기반 인증 처리
- 사용자 권한 제어

### 게시판
- 게시글 등록, 조회, 수정, 삭제
- 해시태그 추출
- 첨부파일 연동

### 댓글
- 댓글 및 대댓글 CRUD

### 파일 업로드
- 첨부파일 CRUD
- 첨부파일 다운로드
- 이미지 썸네일 자동 생성
- 게시글과 첨부파일 연계 관리
------------------------------------------------------------------------------------------------
## 프로젝트 아키텍처
Client
  ↓
Controller (Spring MVC)
  ↓
Service
  ↓
DAO (MyBatis Mapper)
  ↓
Oracle Database
------------------------------------------------------------------------------------------------
## 실행 방법
### 1. 프로젝트 클론
git clone https://github.com/ztoacej-personal/PersonalGYM.git

### 2. Oracle Database 설정
DB 생성 후 SQL 스크립트 실행

### 3. 프로젝트 Import
Eclipse → Existing Maven Project

### 4. Maven Build
mvn clean install

### 5. Tomcat 서버 실행
Apache Tomcat 9 이상

### 6. 접속
http://localhost:8080/
------------------------------------------------------------------------------------------------
## 프로젝트 상세 소개 첨부
- 01_PersonalGYM_Portfolio (개발 과정 중심 ppt - 프로젝트 기획, 설계, 구현 과정)
- 02_PersonalGYM_Service Demo (서비스 기능 중심 ppt - 주요 기능 시연 및 서비스 소개)
