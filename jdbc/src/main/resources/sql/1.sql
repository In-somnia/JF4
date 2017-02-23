CREATE TABLE Books (
id NUMBER AUTO_INCREMENT PRIMARY KEY,
full_author_name VARCHAR(255) NOT NULL,
book_name VARCHAR(255) NOT NULL
);


INSERT INTO Books (id, full_author_name, book_name) VALUES
(NULL, 'Leo Tolstoy', 'War and Peace'),
(NULL, 'Feodor Dostoevskiy', 'Crime and Punishment'),
(NULL, 'Terry Pratchett', 'Good Omens'),
(NULL, 'Oscar Wild', 'The Picture of Dorian Grey'),
(NULL, 'Bernard Show', 'Pigmalion');



