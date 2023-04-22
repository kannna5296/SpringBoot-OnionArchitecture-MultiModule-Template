CREATE TABLE book (
  id VARCHAR(255) NOT NULL,
  title VARCHAR(255) NOT NULL,
  author VARCHAR(255) NOT NULL,
  release_date TIMESTAMP,
  PRIMARY KEY (
    id
  )
);

CREATE TABLE rental (
  id VARCHAR(255) NOT NULL,
  user_id INT NOT NULL,
  book_id VARCHAR(255) NOT NULL,
  rental_date TIMESTAMP NOT NULL,
  return_deadline TIMESTAMP NOT NULL,
  PRIMARY KEY (
    id
  ),
  FOREIGN KEY (book_id) REFERENCES book(id)
);