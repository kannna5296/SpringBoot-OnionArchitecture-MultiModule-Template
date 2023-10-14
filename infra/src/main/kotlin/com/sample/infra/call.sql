DECLARE @result as NVARCHAR(100);
EXEC dbo.MyProcedure 'hoge1', @author = @result OUTPUT;
PRINT @result;