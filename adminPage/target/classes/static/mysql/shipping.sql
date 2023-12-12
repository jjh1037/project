CREATE DATABASES project;

USE project;

국내 post code, 상세주소
해외 address1, address2, city, country, postcode

-- 운송사 db
CREATE TABLE shipping(
id int not null auto_increment, -- primary key
domestic boolean not null, -- 국내/해외 국내: 1, 해외: 0
name varchar(50) not null, -- 배송사 이름
com_num varchar(30) not null, -- 회사 전화번호
fax_num varchar(30), -- 회사 팩스번호
address1 varchar(100) not null, -- 회사 사업장 주소1, ex)부산광역시 부산진구 중앙대로 668
address2 varchar(100), -- 회사 사업장 상세주소 ex) 에이원프라자 4층
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
INSERT INTO shipping VALUES(NULL, true, 'name', 'com_num', 'fax_num', 'add1', 'add2', 'city', 'country', 'postcode', 'email', now(), 'orgName', 'savedFileName', 'savedFilePathName', 'savedFileSize', 'folderName', 'ext');
INSERT INTO shipping VALUES(NULL, true, '배송사1', '051-123-4567', '051-789-4561', '부산진구 중앙대로 668', '에이원프라자 4층', '부산광역시', '대한민국', '456789', 'email@email.com', now(), null, null, null, null, null, null);
INSERT INTO shipping VALUES(NULL, false, 'delivery1', '+1 456786874', '+1 727498521', 'swiss courtage finchely ave 130', 'taplow flat 3', 'LONDON', 'united kingdom', 'ew33ny', 'email2@email.com', now(), null, null, null, null, null, null);

-- 담당자 db
CREATE TABLE manager (
m_id int not null auto_increment, -- 담당자 id
m_email varchar(50), -- 담당자 email
m_com_num varchar(30), -- 담당자 유선전화
m_tel_num varchar(30), -- 담당자 휴대전화
id int not null, -- 부모 외래키
primary key(m_id),
foreign key(id) references shipping(id)
ON UPDATE CASCADE
ON DELETE restrict
);

-- 견적 db
CREATE TABLE request(
request_id int not null auto_increment,
request_name varchar(30),
request_num varchar(50),
request_email varchar(50),
request_export_country varchar(50),
request_export_city varchar(50),
request_export_date varchar(50),
request_import_country varchar(50),
request_import_city varchar(50),
request_import_date varchar(50),
request_product int,
request_content text,
id int not null, -- 부모 외래키
primary key(request_id),
foreign key(id) references shipping(id)
ON UPDATE CASCADE
ON DELETE restrict
);



