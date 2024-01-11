# 구름톤 트레이닝 실습 과제 1

---


### Dockerfile 단일 수행 시
**Spring**에서 데이터베이스 연결이 필요하기 때문에 **Dockerfile 단일로 수행 시**, **DB** 연결이 필요합니다.

#### 1. DB(Postgres)
데이터베이스 이미지 실행
```bash
$ docker run --name postgres --env-file ./.env -d postgres:16
```
#### 2. Spring Back App
도커 파일로 실행하는 경우
```bash
$ docker run --name practice1-spring -p 80:80 --env-file ./.env -d goorm/practice1-spring
```







