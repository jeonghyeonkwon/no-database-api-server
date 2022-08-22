### CRUD 연습용 서버

기본주소 : http://localhost:8080/api

| 주소        | Method | header                        | body                                      | 설명      |
|-----------|--------|-------------------------------|-------------------------------------------|---------|
| /user     | GET    |                               |                                           | 유저 리스트  |
| /register | POST   |                               | {username : "유저 아이디", password : "비밀번호" } | 회원가입    |
| /login    | POST   |                               | {username : "유저 아이디", password : "비밀번호" } | 로그인     |
| /board    | GET    |                               |                                           | 게시판 리스트 |
| /board    | POST   | {Authorization : "로그인 토큰 값" } | {title : "게시글 제목", content : "게시글 내용" }   | 게시글 쓰기  |
