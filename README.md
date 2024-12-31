# 메타버스 아카데미 최종 프로젝트
## Team.Walkers

## 프로젝트 소개
XR 기반의 스포츠 참여형 메타버스 플랫폼

스포츠를 통해 누구나 가볍게 즐기고 참여할 수 있는 스포츠 미션 챌린지를 제공합니다.

AI 동작 인식과 트래킹 기술을 활용하여 미션을 수행하고, 챌린지와 연관된 능력치를 성장시킴으로써 현실의 스포츠 활동이 경험치로 연동되는 새로운 경험을 선사합니다.
스포츠와 메타버스를 결합하여, 재미와 몰입감을 기반으로 스포츠 참여를 자연스럽게 유도합니다.

## 주요 기능

- **스포츠 미션 챌린지** : AI를 활용한 스포츠 동작 인식 및 다른 사람들과 기록을 비교할 수 있는 랭킹 시스템
- **아바타 성장 시스템** : 미션 챌린지 참여시 연관된 세부 능력치가 성장
- **나만의 챌린지** : 나만의 동작을 챌린지로 만들어 유저들과 공유, 챌린지 참여시 유사도 분석

## 기술 스택

### 백엔드 서버
![Java](https://img.shields.io/badge/Java-%23ED8B00.svg?style=for-the-badge&logo=openjdk&logoColor=fff)
![Spring Boot](https://img.shields.io/badge/springboot-6DB33F?style=for-the-badge&logo=springboot&logoColor=white)
![MYSQL](https://img.shields.io/badge/mysql-4479A1?style=for-the-badge&logo=mysql&logoColor=white)
![JPA](https://img.shields.io/badge/Spring_data_jpa-6DB33F?style=for-the-badge&logo=SpringSecurity&logoColor=white)

### 인프라 & 배포

![Docker](https://img.shields.io/badge/docker-%230db7ed.svg?style=for-the-badge&logo=docker&logoColor=white)
![GitHub Actions](https://img.shields.io/badge/github%20actions-%232671E5.svg?style=for-the-badge&logo=githubactions&logoColor=white)
![AWS](https://img.shields.io/badge/amazon%20aws-232F3E?style=for-the-badge&logo=amazonwebservices&logoColor=white)
![Amazon S3](https://img.shields.io/badge/amazon%20s3-569A31?style=for-the-badge&logo=amazons3&logoColor=white)
![Amazon RDS](https://img.shields.io/badge/amazon%20rds-527FFF?style=for-the-badge&logo=amazonrds&logoColor=white)


### 모니터링
![Grafana](https://img.shields.io/badge/grafana-%23F46800.svg?style=for-the-badge&logo=grafana&logoColor=white)
![Prometheus](https://img.shields.io/badge/Prometheus-E6522C?style=for-the-badge&logo=Prometheus&logoColor=white)

### 협업 툴
![GitHub](https://img.shields.io/badge/github-181717?style=for-the-badge&logo=github&logoColor=white)
![Discord](https://img.shields.io/badge/Discord-%235865F2.svg?style=for-the-badge&logo=discord&logoColor=white)

## 백엔드 아키텍쳐

![전체 아키텍쳐(본선)](https://github.com/user-attachments/assets/52b17a1d-d45b-4078-9a14-9ec97e99abb8)

## 구현 내용
- Unity와의 통신을 위한 Rest API 설계 및 Swagger 문서를 활용한 API 문서화
- 챌린지 기록 관리 및 랭킹 조회 기능 구현
- 유저 프로필, 능력치 관리 기능 구현
- 동작 유사도 분석을 위한 AI와 통신 기능 구현
- 나만의 챌린지 동작 저장을 위한 파일 업로드 구현 및 AWS S3 연동
- Git Action을 이용한 배포 파이프라인 자동화

