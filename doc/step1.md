## 1. 회원 가입 (Create)

#### 기능명 : 회원 가입
#### 상세기능 설명 : 회원 가입 

#### 요청메시지 명세 (파라미터)

|항목명(영문)|항목명(국문)|필수여부|샘플데이터|비고|
|---|---|---|---|---|
|userId|유저 아이디|o|example_id|유저의 아이디|
|pw|패스워드|o|example123|유저의 패스워드|
|name|이름|o|김조조|이름|
|email|이메일|o|jojorollllll@kakao.com|이메일 주소|
|phone|휴대전화|o|010-0000-0000|휴대전화 번호|
|birthday|생일|o|1999-12-01|태어난 날|
|birthTime|태어난시간|x|자시|12간지 시|
|nickname|닉네임|o|jojojo|닉네임|
|gender|성별|x|MALE,FEMALE|성별|
|HomeLotNumAddress|지번주소|x|서울특별시 양천구 신월동 587 서울신남초등학교|동 주소|
|HomeRoadNameAddress|도로명주소|x|서울특별시 양천구 남부순환로83길 44(신월동)| 도로명 주소|
|HomeDetail_address|상세주소|x|xx동 xxx호|나머지 주소|
|HomeZipcode|우편번호|x|08069|우편번호|
|CompanyLotNumAddress|지번주소|x|서울특별시 양천구 신월동 587 서울신남초등학교|동 주소|
|CompanyRoadNameAddress|도로명주소|x|서울특별시 양천구 남부순환로83길 44(신월동)|도로명 주소|
|CompanyDetail_address|상세주소|x|xx동 xxx호|나머지 주소|
|CompanyZipcode|우편번호|x|08069|우편번호|


![image](https://user-images.githubusercontent.com/43841476/166876477-33fda49b-d9ad-479b-a76a-c1469c462d7f.png)




#### 응답메시지 명세 (파라미터)

|항목명(영문)|항목명(국문)|샘플데이터|비고|
|---|---|---|---|
|statusCode| http 상태 코드| 200 |
|responseMessage| 성공 여부 확인 메시지| 회원 가입 성공|
|data| 전송 받을 데이터(필요 시) | null |


![image](https://user-images.githubusercontent.com/43841476/166876817-26b1b93d-d665-438d-9265-9b65713fd893.png)






## 2. 회원 조회 (Read)

#### 기능명 : 회원 조회
#### 상세기능 설명 : 전체 회원 조회 서비스


#### 요청메시지 명세 (파라미터)

요청 파라미터가 필요 하지 않습니다.

![image](https://user-images.githubusercontent.com/43841476/166884416-dbb6d9d5-e1c1-4766-a8fd-96dc46b866c1.png)


#### 응답메시지 명세 (파라미터)

|항목명(영문)|항목명(국문)|샘플데이터|비고|
|---|---|---|---|
|statusCode| http 상태 코드 | 200 |
|responseMessage|성공 여부 확인 메시지| 회원 정보 조회 성공 |
| data| 전송 받을 데이터| [{"id": 1, "userId": "example_id5","nickName": "jojojo","name": "김조조"}, { "id": 2, "userId": "example_id1", "nickName": "jojojo", "name": "김조조" } ]|


![image](https://user-images.githubusercontent.com/43841476/166883492-cd8ce418-4a62-4211-91b8-a4b6c87cc91f.png)




## 3. 회원 정보 수정(Update)

#### 기능명 : 회원 정보 수정
#### 상세기능 설명 : 개인 회원 정보 수정 

#### 요청메시지 명세 예시 (파라미터)

![image](https://user-images.githubusercontent.com/43841476/166883754-f863df98-3c5d-40be-a439-4fd3abfdf44d.png)

#### 응답메시지 명세 예시 (파라미터)

![image](https://user-images.githubusercontent.com/43841476/166883908-8535feaa-8437-4074-935d-cd12c34e9b02.png)



## 3. 회원 정보 삭제(Update)

#### 기능명 : 회원 탈퇴
#### 상세기능 설명 : 개인 회원 정보 삭제 

#### 요청메시지 명세 예시 (파라미터)

요청 파라미터가 필요하지 않습니다.
![image](https://user-images.githubusercontent.com/43841476/166884811-19ffb8d6-9c2f-4b98-910d-969a05f4708b.png)

#### 응답메시지 명세 예시 (파라미터)
![image](https://user-images.githubusercontent.com/43841476/166884379-02b41c14-de06-49ab-b1ab-fd7475249c89.png)





