INSERT INTO tb_user (name, email, password) VALUES ('Lara de Luca', 'laradeluca@gmail.com', '$2a$10$atI00UU1A2qRCWhmubumPeDbyxfkiCX11Tg4YfRjDSlcBICkPHAme');
INSERT INTO tb_user (name, email, password) VALUES ('Rafael de Luca', 'rafaeldeluca@gmail.com', '$2a$10$atI00UU1A2qRCWhmubumPeDbyxfkiCX11Tg4YfRjDSlcBICkPHAme');

INSERT INTO tb_role (role_name) VALUES ('ROLE_CLIENT');
INSERT INTO tb_role (role_name) VALUES ('ROLE_ADMIN');

INSERT INTO tb_user_role (user_id, role_id) VALUES (1, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 1);
INSERT INTO tb_user_role (user_id, role_id) VALUES (2, 2);


