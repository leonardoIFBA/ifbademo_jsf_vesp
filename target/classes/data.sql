insert into departamentos (nome) values ('TECNOLOGIA DA INFORMAÇÃO');
insert into departamentos (nome) values ('RECURSOS HUMANOS');

insert into cargos (nome, id_departamento_fk) values ('PROGRAMADOR JAVA JUNIOR',1);
insert into cargos (nome, id_departamento_fk) values ('PROGRAMADOR JAVA SENIOR',1);
insert into cargos (nome, id_departamento_fk) values ('ENGENHEIRO DE SOFTWARE',1);
insert into cargos (nome, id_departamento_fk) values ('CONTADOR',2);
insert into cargos (nome, id_departamento_fk) values ('AUXILIAR ADMINISTRATIVO',2);

insert into enderecos (bairro, cep, cidade, complemento, logradouro, numero, uf) values ('bairro', '46100000', 'BRUMADO', 'CASA', 'RUA A', 10, 'BA');
insert into enderecos (bairro, cep, cidade, complemento, logradouro, numero, uf) values ('bairro', '46100000', 'BRUMADO', 'CASA', 'RUA B', 50, 'BA');

insert into funcionarios (nome, salario, data_entrada, data_saida, endereco_id_fk, cargo_id_fk) values ('JOAO', 1000.00, '2020.01.01', NULL, 1, 1);
insert into funcionarios (nome, salario, data_entrada, data_saida, endereco_id_fk, cargo_id_fk) values ('MARIA', 2000.00, '2020.01.01', NULL, 2, 2);
