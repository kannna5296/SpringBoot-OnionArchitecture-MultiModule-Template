CREATE FUNCTION get_rental_user
(
    @name NVARCHAR(50),
    @phone NVARCHAR(50)
)
RETURNS TABLE
AS
RETURN
(
    SELECT *
    FROM rental_user
    WHERE phone = @phone OR name = @name
)