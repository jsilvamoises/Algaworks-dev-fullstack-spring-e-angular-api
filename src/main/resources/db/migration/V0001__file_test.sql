CREATE TABLE categoria(
     id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
     nome VARCHAR(50) NOT NULL,
     categoria_pai_id BIGINT(20),
     CONSTRAINT `FK_CAT_PAI_ID` FOREIGN KEY (categoria_pai_id) REFERENCES categoria(id) 
)ENGINE=InnoDB DEFAULT CHARSET=utf8;

INSERT INTO categoria(nome) values('Laser'),('Alimentaçao'),('Supermercado'),('Farmacia'),('Outros');