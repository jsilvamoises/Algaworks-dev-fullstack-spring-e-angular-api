CREATE TABLE IF NOT EXISTS lancamento(
     id BIGINT(20) PRIMARY KEY AUTO_INCREMENT,
     descricao VARCHAR(50) NOT NULL,
     data_vencimento DATE NOT NULL,
     data_pagamento DATE,
     valor DECIMAL(10,2) NOT NULL,
     observacao VARCHAR(120),
     tipo VARCHAR(20) NOT NULL,     
     categoria_id BIGINT(20) NOT NULL,
     pessoa_id BIGINT(20) NOT NULL,
     FOREIGN KEY (categoria_id) REFERENCES categoria(id),
     FOREIGN KEY (pessoa_id) REFERENCES pessoa(id)
     
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT INTO lancamento(descricao,data_vencimento,data_pagamento,valor,observacao,tipo,categoria_id,pessoa_id)
      VALUES
('Aluguel','2018-05-01',null,120.00,'sem observacao','DESPESA',1,1),
('Moto','2018-05-01','2018-04-01',20.00,'sem observacao','DESPESA',1,1),
('Natura','2018-06-01',null,1200.00,'sem observacao','RECEITA',1,1),
('Aluguel','2018-07-01',null,450.00,'sem observacao','DESPESA',1,2),
('Aluguel','2018-08-01',null,3620.00,'sem observacao','DESPESA',1,2),
('Aluguel','2018-09-01',null,1120.00,'sem observacao','DESPESA',1,3);