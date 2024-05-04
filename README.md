# TODO
- 좋아요
- 조회수
- 알림
- 채팅

# 참고

## mongo replica set

- [Why replica set is mandatory for transactions in MongoDB?](https://www.mongodb.com/community/forums/t/why-replica-set-is-mandatory-for-transactions-in-mongodb/9533)
- [도커로 mongo replica set 구성](https://seoko.me/post/3)
- [도커로 mongo replica set 구성2 이게 더 간단한듯](https://devs0n.tistory.com/43)
- mongodb compass 로 접속할 때 권한있는 user 로 로그인 해야함

example.

```
  db.createUser(
  {
    user: "board",
    pwd:  "board",
    roles: [
      { "role" : "readWriteAnyDatabase", "db" : "admin" },
      { "role" : "userAdminAnyDatabase", "db" : "admin" },
      { "role" : "dbAdminAnyDatabase", "db" : "admin" },
      { "role" : "clusterAdmin", "db" : "admin" },
      { "role" : "restore", "db" : "admin" },
      { "role" : "backup", "db" : "admin" }
    ]
  }
  )

```