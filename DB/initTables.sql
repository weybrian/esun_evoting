--建立資料庫
DROP DATABASE IF EXISTS esun;
CREATE DATABASE esun;

--新增資料表>投票項目
DROP TABLE IF EXISTS esun..VOTE_ITEM;
CREATE TABLE esun..VOTE_ITEM(
ID INT IDENTITY PRIMARY KEY,
ITEM_ID INT,
NAME NVARCHAR(10)
);

--新增投票項目資料
INSERT INTO esun..VOTE_ITEM values(1, N'電腦'), (2, N'滑鼠')

--新增資料表>投票紀錄
DROP TABLE IF EXISTS esun..VOTE_RECORD;
CREATE TABLE esun..VOTE_RECORD(
ID INT IDENTITY PRIMARY KEY,
PERSON_NAME NVARCHAR(10),
ITEM_ID INT
);

--新增投票紀錄資料
INSERT INTO esun..VOTE_RECORD values('Leo', 1), ('Sandy', 1), ('Sandy', 2), ('Randy', 2), ('RSY', 2)
