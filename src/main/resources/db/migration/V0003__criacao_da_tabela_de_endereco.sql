CREATE TABLE if not exists endereco(
     id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
     logradouro VARCHAR(120) NOT NULL,
     numero varchar(20) NOT NULL,
     complemento VARCHAR(200),
     bairro VARCHAR(80) NOT NULL,
     cep VARCHAR(10) NOT NULL,
     cidade VARCHAR(90) NOT NULL,
     estado VARCHAR(60) NOT NULL,
     pessoa_id BIGINT(20),
     CONSTRAINT `fk_end_pessoa` FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)

)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO endereco(logradouro,numero,bairro,cep,cidade,estado,pessoa_id)
values
('Rua Bertioga','128','Valencia','13.221-600','Varzea Paulista','Sao Paulo',1),
('Rua Bertioga','128','Jardim Am´erica I','13.221-300','Jarinu','Sao Paulo',2),
('Rua Manduri','1020','Jardim Primavera','13.221-300','Campo Limpo Paulista','Sao Paulo',3),
('Rua Sapo','02','Jardim Am´erica I','13.221-300','Varzea Paulista','Sao Paulo',4),
('Rua Balconistas','126','Jardim Am´erica I','13.221-300','Santo Andre','Sao Paulo',3),
('Rua Saracura','10','Jardim Am´erica I','13.221-300','Campinas','Sao Paulo',2),
('Rua Bertioga','96','Jardim Am´erica I','13.221-300','Jundia´i','Sao Paulo',1);