CREATE TABLE users (
    id SERIAL PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    role VARCHAR(20) NOT NULL,        
    password VARCHAR(100) NOT NULL,
    status VARCHAR(20) NOT NULL,      
    siteno INT UNIQUE
);

CREATE TABLE site (
    siteno INT PRIMARY KEY,
    type VARCHAR(50) NOT NULL, 
    len INT NOT NULL,
    breadth INT NOT NULL,
    is_occupied BOOLEAN NOT NULL
);
CREATE TABLE maintenance (
    siteno INT PRIMARY KEY,
    user_id INT NOT NULL,
    amount NUMERIC(10,2) NOT NULL,
    is_paid BOOLEAN NOT NULL DEFAULT FALSE,
    FOREIGN KEY (siteno) REFERENCES site(siteno),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

CREATE TABLE approval (
    id SERIAL PRIMARY KEY,
    siteno INT NOT NULL,
    user_id INT NOT NULL,
    status VARCHAR(20) NOT NULL,
    FOREIGN KEY (siteno) REFERENCES site(siteno),
    FOREIGN KEY (user_id) REFERENCES users(id)
);

INSERT INTO site (siteno, type, len, breadth, is_occupied) VALUES
(1, 'Open Site', 40, 60, FALSE),
(2, 'Villa', 40, 60, TRUE),
(3, 'Apartment', 40, 60, TRUE),
(4, 'Independent House', 40, 60, TRUE),
(5, 'Open Site', 40, 60, FALSE);

INSERT INTO site (siteno, type, len, breadth, is_occupied) VALUES
(11, 'Villa', 30, 50, TRUE),
(12, 'Apartment', 30, 50, TRUE),
(13, 'Open Site', 30, 50, FALSE),
(14, 'Independent House', 30, 50, TRUE),
(15, 'Open Site', 30, 50, FALSE);

INSERT INTO site (siteno, type, len, breadth, is_occupied) VALUES
(21, 'Villa', 30, 40, TRUE),
(22, 'Apartment', 30, 40, TRUE),
(23, 'Open Site', 30, 40, FALSE),
(24, 'Independent House', 30, 40, TRUE),
(25, 'Open Site', 30, 40, FALSE);

select * from site;

INSERT INTO users (name, role, password, status, siteno)
VALUES ('Admin', 'ADMIN', 'admin123', 'ACTIVE', NULL);

INSERT INTO users (name, role, password, status, siteno) VALUES
('Ravi', 'OWNER', 'ravi123', 'ACTIVE', 2),
('Sita', 'OWNER', 'sita123', 'ACTIVE', 3),
('Kiran', 'OWNER', 'kiran123', 'ACTIVE', 11),
('Anu', 'OWNER', 'anu123', 'ACTIVE', 21);


INSERT INTO maintenance (siteno, user_id, amount, is_paid) VALUES
(2, 2, 21600, FALSE),
(3, 3, 21600, TRUE);

INSERT INTO maintenance (siteno, user_id, amount, is_paid) VALUES
(11, 4, 13500, FALSE);

INSERT INTO maintenance (siteno, user_id, amount, is_paid) VALUES
(21, 5, 10800, TRUE);

INSERT INTO approval (siteno, user_id, status)
VALUES (2, 2, 'PENDING');

INSERT INTO approval (siteno, user_id, status)
VALUES (11, 4, 'PENDING');

select * from users;

