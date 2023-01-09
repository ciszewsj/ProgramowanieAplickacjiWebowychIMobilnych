INSERT INTO role_table (role_name)
VALUES ('ROLE_user');
INSERT INTO role_table (role_name)
VALUES ('ROLE_admin');

-- password : password
INSERT INTO customer (username, password)
VALUES ('user', '$2a$10$tcQm6cAvllaaSYbEZf./F.uhz73ptznRh0GcNKVL2tn/26qqeIrKW');
INSERT INTO customer (username, password)
VALUES ('admin', '$2a$10$tcQm6cAvllaaSYbEZf./F.uhz73ptznRh0GcNKVL2tn/26qqeIrKW');

INSERT INTO CUSTOMER_ROLES (customer_id, roles_id)
VALUES (1, 1);
INSERT INTO CUSTOMER_ROLES (customer_id, roles_id)
VALUES (2, 2);


