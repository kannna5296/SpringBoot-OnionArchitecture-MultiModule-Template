INSERT INTO rental_user (name, phone, mail, created_at, updated_at)
  VALUES
('tom', '000-0000', 'example1@gmail.com', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
('jerry', '000-0001', 'example2@gmail.com', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO book (name, author, created_at, updated_at)
  VALUES
('hoge1', 'author1', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
('hoge2', 'author2', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
('hoge3', 'author3', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
('hoge4', 'author4', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP()),
('hoge5', 'author5', CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

INSERT INTO rental (book_id, user_id, deadline, is_returned, created_at, updated_at)
 VALUES
(1, 1, '2024-01-08', 1, '2024-01-01', '2024-01-01'),-- 返却ずみ
(2, 1, '2024-01-09', 0, '2024-01-02', '2024-01-02'),-- 未返却
(3, 1, '2024-01-10', 0, '2024-01-03', '2024-01-03');-- 未返却
--(4, 2, DATEADD('DAY', 1, CURRENT_DATE), 0, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());
--(5, 2, DATEADD('DAY', 1, CURRENT_DATE), 0, CURRENT_TIMESTAMP(), CURRENT_TIMESTAMP());

