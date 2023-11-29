
use koreaitdb;

create table board(
id int not null auto_increment,
subject varchar(255) not null,
writer varchar(10) not null,
content text,
visit int,
regdate date,
orgName varchar(255),
savedFileName varchar(255),
savedFilePathName varchar(255),
savedFileSize bigint,
folderName varchar(10),
ext varchar(20),
grp int,
seq int,
depth int,
primary key(id)
);

-- 검색 : 조건(where)
-- subject
SELECT count(*) FROM board WHERE subject = '코리아아이티 게시판'
ORDER BY id DESC;

-- writer
SELECT count(*) FROM board WHERE writer = '관리자'
ORDER BY id DESC;

-- content 유사어 검색
SELECT count(*) FROM board WHERE content LIKE '%비서실%'
ORDER BY id DESC;


SELECT writer FROM board WHERE writer = '관리자';

WHERE content LIKE '%서비스%'

SELECT content FROM board WHERE content LIKE '%비서실%';



SELECT * FROM board WHERE content LIKE '%서비스%'
