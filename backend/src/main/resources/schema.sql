CREATE TABLE IF NOT EXISTS customer
(
    id       IDENTITY PRIMARY KEY,
    username VARCHAR(100) NOT NULL,
    password VARCHAR(100) NOT NULL,
    email    VARCHAR(100) NOT NULL
);
--
CREATE TABLE IF NOT EXISTS role_table
(
    id        IDENTITY PRIMARY KEY,
    role_name VARCHAR(100) NOT NULL
);
--
CREATE TABLE IF NOT EXISTS CUSTOMER_ROLES
(
    customer_id INT,
    roles_id        INT,
    Constraint PK_Books_Authors Primary Key (customer_id, roles_id),
    FOREIGN KEY (customer_id) REFERENCES customer (id),
    FOREIGN KEY (roles_id) REFERENCES role_table (id)
);


-- );