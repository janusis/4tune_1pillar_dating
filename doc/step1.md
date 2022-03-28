## 1. 회원 가입

#### 기능명 : 회원 가입
#### 상세기능 설명 : 사주데이팅 홈페이지의 회원가입 서비스

![image](https://user-images.githubusercontent.com/43841476/159628185-50e6275d-b657-4022-80ea-a969310f7fa2.png)


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

#### 응답메시지 명세 (파라미터)
|항목명(영문)|항목명(국문)|샘플데이터|비고|
|---|---|---|---|
|id|유저 식별키| 1 |
|user_id|유저 아이디| example_id|
|name|유저 이름| 김조조|

## 2. 회원 조회

#### 기능명 : 회원 조회
#### 상세기능 설명 : 아이디 찾기, 비밀번호 찾기 등에 사용 될 회원 조회기능

![image](https://user-images.githubusercontent.com/43841476/159628185-50e6275d-b657-4022-80ea-a969310f7fa2.png)


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

#### 응답메시지 명세 (파라미터)
|항목명(영문)|항목명(국문)|샘플데이터|비고|
|---|---|---|---|
|id|유저 식별키| 1 |
|user_id|유저 아이디| example_id|
|name|유저 이름| 김조조|
