create table tb_worker (id int8 generated by default as identity, daily_income float8, name varchar(255), primary key (id));
INSERT INTO tb_worker (name, daily_Income) VALUES ('Rafael', 200.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Maria', 300.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Claudia', 250.0);
INSERT INTO tb_worker (name, daily_Income) VALUES ('Lara', 350.0);