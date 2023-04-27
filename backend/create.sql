create table perfil (id int4 generated by default as identity, descricao varchar(255) not null, primary key (id));
create table tb_bond (developer_id int4 not null, project_id int4 not null);
create table tb_developers (id int4 generated by default as identity, birth_date timestamp not null, developer_name varchar(255) not null, email varchar(255) not null, salary float8 not null, workload int4 not null, primary key (id));
create table tb_projects (id int4 generated by default as identity, budget float8 not null, client_name varchar(255) not null, date date not null, deadline varchar(255) not null, project_name varchar(255) not null, primary key (id));
create table tb_role (id int8 generated by default as identity, authority varchar(255), primary key (id));
create table tb_user (id int8 generated by default as identity, email varchar(255) not null, senha varchar(255) not null, primary key (id));
create table usuario_perfil (perfil_id int4 not null, usuario_id int8 not null);
alter table if exists tb_bond add constraint FKmikk3bf577ola1o0md2906u3w foreign key (project_id) references tb_projects;
alter table if exists tb_bond add constraint FK5itwvlqeh68lqrr7rxjo7tvr5 foreign key (developer_id) references tb_developers;
alter table if exists usuario_perfil add constraint FKh3f2w64x92oav6b9gcfd2lhnh foreign key (usuario_id) references tb_user;
alter table if exists usuario_perfil add constraint FK22cgfn0obntlvqyfn33pyk24d foreign key (perfil_id) references perfil;
INSERT INTO tb_projects(project_name,client_name,date,deadline,budget) VALUES ('Streamer Nyghts','WillTub','2021-02-14','6 meses',6000.0);
INSERT INTO tb_projects(project_name,client_name,date,deadline,budget) VALUES ('Receitas da Tia','Restaurante Dinas','2011-08-20','10 meses',10000.0);
INSERT INTO tb_projects(project_name,client_name,date,deadline,budget) VALUES ('Cursos de Desenho','Iza Phandinha','2021-12-03','4 meses',4000.0);
INSERT INTO tb_projects(project_name,client_name,date,deadline,budget) VALUES ('Jogos Infantis','Thyago','2019-06-04','8 meses',8000.0);
INSERT INTO tb_projects(project_name,client_name,date,deadline,budget) VALUES ('Dr Tooth','Clinica Tooth','2022-02-14','12 meses',12000.0);
INSERT INTO tb_projects(project_name,client_name,date,deadline,budget) VALUES ('Maquinas Incriveis','Lab Machines','2022-07-13','5 meses',5000.0);
INSERT INTO tb_projects(project_name,client_name,date,deadline,budget) VALUES ('Truques Maneiros','Truques e Magicas','2015-02-12','7 meses',7000.0);
INSERT INTO tb_projects(project_name,client_name,date,deadline,budget) VALUES ('Carros Futuros','Future Motors','2020-04-08','9 meses',9000.0);
INSERT INTO tb_developers(developer_name,email,birth_date,salary,workload) VALUES ('Pedro Paulo','pedropaulo@gmail.com','2021-02-14',6000.0,8);
INSERT INTO tb_developers(developer_name,email,birth_date,salary,workload) VALUES ('Arwen Undomiel','arwen258@gmail.com','2011-08-20',10000.0,10);
INSERT INTO tb_developers(developer_name,email,birth_date,salary,workload) VALUES ('Legolas','legolasverdefolha@gmail.com','2021-12-03',4000.0,12);
INSERT INTO tb_developers(developer_name,email,birth_date,salary,workload) VALUES ('Galadriel','galadriel222@gmail.com','2019-06-04',8000.0,9);
INSERT INTO tb_developers(developer_name,email,birth_date,salary,workload) VALUES ('Finarfin','finarfin@gmail.com','2022-02-14',12000.0,6);
INSERT INTO tb_developers(developer_name,email,birth_date,salary,workload) VALUES ('Celebrimbor','celebrimbor@gmail.com','2022-07-13',5000.0,8);
INSERT INTO tb_bond (project_id, developer_id) VALUES (1 , 1);
INSERT INTO tb_bond (project_id, developer_id) VALUES (1 , 4);
INSERT INTO tb_bond (project_id, developer_id) VALUES (2 , 2);
INSERT INTO tb_bond (project_id, developer_id) VALUES (2 , 5);
INSERT INTO tb_bond (project_id, developer_id) VALUES (2 , 6);
INSERT INTO tb_bond (project_id, developer_id) VALUES (3 , 3);
INSERT INTO tb_bond (project_id, developer_id) VALUES (3 , 4);
INSERT INTO tb_bond (project_id, developer_id) VALUES (4 , 2);
INSERT INTO tb_bond (project_id, developer_id) VALUES (4 , 6);
INSERT INTO tb_bond (project_id, developer_id) VALUES (5 , 4);
INSERT INTO tb_bond (project_id, developer_id) VALUES (5 , 6);
INSERT INTO tb_bond (project_id, developer_id) VALUES (6 , 5);
INSERT INTO tb_bond (project_id, developer_id) VALUES (6 , 1);
INSERT INTO tb_bond (project_id, developer_id) VALUES (7 , 6);
INSERT INTO tb_bond (project_id, developer_id) VALUES (7 , 5);
INSERT INTO tb_bond (project_id, developer_id) VALUES (8 , 2);
INSERT INTO tb_bond (project_id, developer_id) VALUES (8 , 5);
INSERT INTO tb_bond (project_id, developer_id) VALUES (3 , 1);
INSERT INTO tb_bond (project_id, developer_id) VALUES (7 , 3);