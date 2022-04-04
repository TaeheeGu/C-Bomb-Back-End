> ### URL 리스트
> 1. GET https://www.c-bomb.com/ : 메인페이지
> 2. POST https://www.c-bomb.com/login : 로그인
> 3. GET https://www.c-bomb.com/login/kakao : OAuth kakao 로그인
> 4. GET https://www.c-bomb.com/login/naver : OAuth naver 로그인
> 5. GET https://www.c-bomb.com/login/google : OAuth google 로그인
> 6. GET https://www.c-bomb.com/register : 회원가입 페이지
> 10. POST https://www.c-bomb.com/register : 회원가입하기
> 7. GET https://www.c-bomb.com/register/kakao : OAuth kakao 회원가입
> 8. GET https://www.c-bomb.com/register/naver : OAuth naver 회원가입
> 9. GET https://www.c-bomb.com/register/google : OAuth google 회원가입
> 11. GET https://www.c-bomb.com/movie-list : 특정 영화관에서 상영중인 모든 영화정보 json으로 반환(API)
> 12. GET https://www.c-bomb.com/rooms : 해당 상영영화에 대한 채팅방 정보
> 16. POST https://www.c-bomb.com/rooms : 채팅방 생성
> 13. GET https://www.c-bomb.com/rooms/room-page-data/{room-page} : 해당 페이지의 채팅방 list를 반환(API)
> 14. GET https://www.c-bomb.com/rooms/{room-number} : 해당 채팅방에 대한 정보 json으로 반환(API)
> 15. POST https://www.c-bomb.com/rooms/{room-number} : 채팅방 참여

## 🔗URL 맵핑 정보

- GET https://www.c-bomb.com/
  > index 페이지
- POST https://www.c-bomb.com/login
    - id
    - password
  > id와 비밀번호로 로그인을 한다.
- GET https://www.c-bomb.com/login/kakao
  > kakao를 통해 로그인한다.
- GET https://www.c-bomb.com/login/naver
  > naver를 통해 로그인한다.
- GET https://www.c-bomb.com/login/google
  > google을 통해 로그인 한다.
- GET https://www.c-bomb.com/register
  > 회원가입화면을 띄워준다.
- GET https://www.c-bomb.com/register/kakao
  > kakao를 통해 로그인한다.
- GET https://www.c-bomb.com/register/naver
  > naver를 통해 로그인한다.
- GET https://www.c-bomb.com/register/google
  > google을 통해 로그인 한다.
- POST https://www.c-bomb.com/register
    - id
    - password
    - 이름
    - 나이
    - 지역
    - 성별
  > 회원가입을 완료한다.
- GET https://www.c-bomb.com/movie-list
    - 영화관 ID
  > 해당 영화관에 상영중인 영화와 시간을 json으로 응답한다.
- GET https://www.c-bomb.com/rooms
    - 상영 영화 ID
  > 해당 영화에 대해 개설된 채팅방 목록 표시(화면)
- GET https://www.c-bomb.com/rooms/room-page-data/{room-page}
  > 해당 페이지 채팅방에 대한 정보를 json으로 보내줌
- GET https://www.c-bomb.com/rooms/{room-number}
  > room-number에 해당하는 data를 json으로 보내줌
- POST https://www.c-bomb.com/rooms/{room-number}
  > 사용자가 room-number에 해당하는 채팅방에 참여
- POST https://www.c-bomb.com/rooms
    - max_number
    - 상영영화 id
  > 새로운 채팅방을 만듬
