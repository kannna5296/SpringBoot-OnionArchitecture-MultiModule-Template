CREATE OR ALTER FUNCTION get_rental_user
(
    @name NVARCHAR(50),
    @phone NVARCHAR(50)
)
RETURNS @UserInfo TABLE
(
    user_id INT,
    user_name VARCHAR(100)
)
AS
BEGIN
    DECLARE @user_id INT
    DECLARE @user_name VARCHAR(100)

    SELECT
        @user_id = id,
        @user_name = name
    FROM rental_user
    WHERE phone = @phone OR name = @name

    INSERT INTO @UserInfo (user_id, user_name)
    VALUES (@user_id, @user_name)
    RETURN
END