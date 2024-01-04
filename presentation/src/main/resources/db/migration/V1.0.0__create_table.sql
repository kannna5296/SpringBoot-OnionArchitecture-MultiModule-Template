CREATE TABLE book (
  id INT NOT NULL PRIMARY KEY,
  name NVARCHAR(255) NOT NULL,
  author NVARCHAR(255) NOT NULL,
  created_at DATETIME2 NOT NULL,
  updated_at DATETIME2 NOT NULL
);

CREATE TABLE rental_user (
  id INT NOT NULL PRIMARY KEY,
  name NVARCHAR(255) NOT NULL,
  phone VARCHAR(255),
  mail VARCHAR(255) NOT NULL,
  created_at DATETIME2 NOT NULL,
  updated_at DATETIME2 NOT NULL
);

CREATE TABLE rental (
  id INT NOT NULL PRIMARY KEY,
  book_id INT NOT NULL,
  user_id INT NOT NULL,
  deadline TIMESTAMP NOT NULL,
  is_returned BIT NOT NULL DEFAULT 0,
  created_at DATETIME2 NOT NULL,
  updated_at DATETIME2 NOT NULL,
  FOREIGN KEY (book_id) REFERENCES book(id),
  FOREIGN KEY (user_id) REFERENCES rental_user(id)
);