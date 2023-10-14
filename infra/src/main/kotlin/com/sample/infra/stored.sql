ALTER PROCEDURE  dbo.MyProcedure
    -- 引数の定義
    @title nvarchar(100),
    @author nvarchar(100) OUTPUT -- 出力する項目
AS
BEGIN
    --処理
    SELECT @author = author
    FROM book
    WHERE book.title = @title

    RETURN; -- 0か-1かが返る(正常か異常か)
END

-- 戻り値返し方
--  - AS前に"OUTPUT"つける
--    - 数値文字列日付いける
--  - AS後でRETURNで返す
--    - 数値のみしか返せない 文字列返そうとするとfailed convert to data type int...とか言われる
