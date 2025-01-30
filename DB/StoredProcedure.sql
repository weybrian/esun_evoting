--後台
--新增
Create PROCEDURE dbo.spInsertItem
       @NAME                         NVARCHAR(10)      = NULL
AS 
BEGIN 
     SET NOCOUNT ON 

     INSERT INTO dbo.Item
          (                    
            NAME             
          ) 
     VALUES 
          ( 
            @NAME
          ) 
END 

EXEC dbo.spInsertItem
    @NAME   = N'鍵盤';
   
--查詢全部
CREATE PROCEDURE dbo.spGetAllItem /*注意: 名稱不能是sp_開頭!("sp_"是預留給系統的))*/
AS
BEGIN
 /*從這邊開始輸入要預存的SQL指令*/
 SELECT * FROM dbo.Item; 
END;

EXEC dbo.spGetAllItem

--更新
create PROCEDURE dbo.spPutItem
       @item_id                  int  = NULL,
       @New_name                     NVARCHAR(10)  = NULL
AS 
BEGIN 
     SET NOCOUNT ON 

     update dbo.Item set NAME = @New_name
     where item_id = @item_id; 
END 

EXEC dbo.spPutItem 
@item_id = 3,
@New_name = N'青軸';

--刪除
create PROCEDURE dbo.spDeleteItem
       @item_id                  int  = NULL
AS 
BEGIN 
     SET NOCOUNT ON 

     delete from dbo.Item where item_id = @item_id; 
END 

EXEC dbo.spDeleteItem 
@item_id = 3;

--前台
--查詢票數
alter PROCEDURE dbo.spGetVotes /*注意: 名稱不能是sp_開頭!("sp_"是預留給系統的))*/
AS
BEGIN
 /*從這邊開始輸入要預存的SQL指令*/
 SELECT i.name, count(r.person_name) num, i.item_id FROM dbo.Item i
 left join dbo.record r on i.item_id = r.item_id
 group by i.name, i.item_id; 
END;

EXEC dbo.spGetVotes

--新增投票
Create PROCEDURE dbo.spPostRecord
       @PERSON_NAME NVARCHAR(10) = NULL,
       @ITEM_ID int  = NULL
AS 
BEGIN 
     SET NOCOUNT ON 

     INSERT INTO dbo.RECORD 
          (                    
            PERSON_NAME, ITEM_ID             
          ) 
     VALUES 
          ( 
            @PERSON_NAME, @ITEM_ID
          ) 
END 

EXEC dbo.spPostRecord
    @PERSON_NAME   = 'Leo',
    @ITEM_ID = 3;
    
   select * from RECORD r 