-- Crear la base de datos
CREATE DATABASE IF NOT EXISTS library_db;
USE library_db;

-- Tabla: Author (Autores)
CREATE TABLE Author (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    birth_date DATE,
    nationality VARCHAR(255)
);

-- Tabla: Book (Libros)
CREATE TABLE Book (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    title VARCHAR(255) NOT NULL,
    isbn VARCHAR(50) UNIQUE NOT NULL,
    publication_year INT,
    author_id BIGINT,
    FOREIGN KEY (author_id) REFERENCES Author(id) ON DELETE SET NULL
);

-- Tabla: Category (Categorías)
CREATE TABLE Category (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL
);

-- Tabla: Book_Category (Relación muchos a muchos entre libros y categorías)
CREATE TABLE Book_Category (
    book_id BIGINT,
    category_id BIGINT,
    PRIMARY KEY (book_id, category_id),
    FOREIGN KEY (book_id) REFERENCES Book(id) ON DELETE CASCADE,
    FOREIGN KEY (category_id) REFERENCES Category(id) ON DELETE CASCADE
);

-- Tabla: User (Usuarios)
CREATE TABLE User (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    type ENUM('STUDENT', 'TEACHER', 'EMPLOYEE') NOT NULL
);

-- Tabla: Loan (Préstamos)
CREATE TABLE Loan (
    id BIGINT PRIMARY KEY AUTO_INCREMENT,
    user_id BIGINT,
    book_id BIGINT,
    loan_date DATE NOT NULL,
    return_date DATE,
    FOREIGN KEY (user_id) REFERENCES User(id) ON DELETE SET NULL,
    FOREIGN KEY (book_id) REFERENCES Book(id) ON DELETE SET NULL
);

-- Insertar datos iniciales

-- Autores
INSERT INTO Author (name, birth_date, nationality) VALUES
('Gabriel García Márquez', '1927-03-06', 'Colombian'),
('J.K. Rowling', '1965-07-31', 'British'),
('George Orwell', '1903-06-25', 'British');

-- Libros
INSERT INTO Book (title, isbn, publication_year, author_id) VALUES
('Cien años de soledad', '978-0060883287', 1967, 1),
('Harry Potter and the Philosopher''s Stone', '978-0747532743', 1997, 2),
('1984', '978-0451524935', 1949, 3);

-- Categorías
INSERT INTO Category (name) VALUES
('Novel'),
('Fantasy'),
('Classic'),
('Science Fiction');

-- Relación Libro-Categoría
INSERT INTO Book_Category (book_id, category_id) VALUES
(1, 1), -- Cien años de soledad -> Novel
(1, 3), -- Cien años de soledad -> Classic
(2, 1), -- Harry Potter -> Novel
(2, 2), -- Harry Potter -> Fantasy
(3, 1), -- 1984 -> Novel
(3, 4); -- 1984 -> Science Fiction

-- Usuarios
INSERT INTO User (name, email, type) VALUES
('Alice Johnson', 'alice@example.com', 'STUDENT'),
('Bob Smith', 'bob@example.com', 'TEACHER'),
('Charlie Brown', 'charlie@example.com', 'EMPLOYEE');

-- Préstamos
INSERT INTO Loan (user_id, book_id, loan_date, return_date) VALUES
(1, 1, '2023-01-15', '2023-02-15'), -- Alice prestó "Cien años de soledad"
(2, 2, '2023-03-01', NULL),         -- Bob prestó "Harry Potter" (aún no devuelto)
(3, 3, '2023-04-10', '2023-05-10'); -- Charlie prestó "1984"