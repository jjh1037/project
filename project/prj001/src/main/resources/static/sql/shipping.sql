CREATE DATABASES project;

USE project;

국내 post code, 상세주소
해외 address1, address2, city, country, postcode

CREATE TABLE shipping(
id int not null auto_increment, -- primary key
domestic boolean not null, -- 국내/해외 국내: 1, 해외: 0
name varchar(50) not null, -- 배송사 이름
comNum varchar(30) not null, -- 회사 전화번호
faxNum varchar(30), -- 회사 팩스번호
address1 varchar(100) not null, -- 회사 사업장 주소1, ex)부산광역시 부산진구 중앙대로 668
address2 varchar(100), -- 회사 사업장 주소2, 상세주소 ex) 에이원프라자 4층
city varchar(50) not null, -- 회사 사업장 도시
country varchar(50) not null, -- 회사 사업장 나라
postcode varchar(30) not null, -- 회사 사업장 우편번호
email varchar(50) not null, -- 회사 이메일
regdate date, -- 회원가입일자
orgName varchar(255),
savedFileName varchar(255),
savedFilePathName varchar(255),
savedFileSize bigint,
folderName varchar(10),
ext varchar(20),
primary key(id)
);

ex)
INSERT INTO shipping VALUES(NULL, 'name', true, 'com_num', 'tel_num', 'add1', 'add2', 'city', 'country', 'postcode', 'email', now(), 'orgName', 'savedFileName', 'savedFilePathName', 'savedFileSize', 'folderName', 'ext');
INSERT INTO shipping VALUES(NULL, true, '배송사1', '051-123-4567', '051-789-4561', '부산진구 중앙대로 668', '에이원프라자 4층', '부산광역시', '대한민국', '456789', 'email@email.com', now(), null, null, null, null, null, null);
INSERT INTO shipping VALUES(NULL, false, 'delivery1', '+1 456786874', '+1 727498521', 'swiss courtage finchely ave 130', 'taplow flat 3', 'LONDON', 'united kingdom', 'ew33ny', 'email2@email.com', now(), null, null, null, null, null, null);