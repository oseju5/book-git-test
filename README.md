# Book Project

## 1. 프로젝트 개요
- **목적**: Git 및 GitHub 사용법 숙달 및 Spring Boot 환경 구성 실습
- **설명**: Spring Boot 2.7.x 마이그레이션 및 기본적인 웹 환경 구축 프로젝트

## 2. 개발 환경 (Environment)
- **Framework**: Spring Boot 2.7.18
- **Language**: Java 11
- **IDE**: STS 3 (Spring Tool Suite 3)
- **Build Tool**: Maven
- **Database**: MySQL 8.0

## 3. 사용 라이브러리 (Dependencies)
- **Spring Web**: MVC 패턴 기반의 웹 개발
- **Spring DevTools**: 코드 변경 시 자동 재시작 지원
- **Spring Data JPA**: 인터페이스 기반의 DB 연동 및 ORM 활용
- **MySQL Driver**: MySQL 데이터베이스 연결
- **Spring AOP**: 공통 관심 사항(로깅 등)의 관점 지향 프로그래밍
- **JUnit 5**: 단위 테스트 및 통합 테스트 수행
- **Thymeleaf**: html에서 java 데이터를 활용

## 4. API 및 접속 정보
- **기본 도메인**: `http://localhost:8080`
- **메인 페이지**: `/` (MainController 연결)

## 5. 데이터베이스 설정 (Database)
- **Schema명**: `book`
- **실행 전 필수 작업**:
  - MySQL에 접속하여 `book` 데이터베이스를 미리 생성해야 합니다.
  ```sql
  CREATE DATABASE book;