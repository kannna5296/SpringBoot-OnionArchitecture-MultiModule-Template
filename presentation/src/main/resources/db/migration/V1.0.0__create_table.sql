CREATE TABLE book (
  id VARCHAR(255) NOT NULL,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  release_date DATETIME,
  PRIMARY KEY CLUSTERED (
    id ASC
  )
);

CREATE TABLE rental (
  id VARCHAR(255) NOT NULL,
  user_id INT NOT NULL,
  book_id VARCHAR(255) NOT NULL,
  rental_date DATETIME NOT NULL,
  return_deadline DATETIME NOT NULL,
  PRIMARY KEY CLUSTERED (
    id ASC
  )
);

ALTER TABLE rental ADD CONSTRAINT [fk_rental_book_id] FOREIGN KEY([book_id])
REFERENCES book([id])