CREATE TABLE if not exists pessoa(
    id BIGINT(20) AUTO_INCREMENT PRIMARY KEY,
    nome VARCHAR(80) NOT NULL,
    ativo BOOL DEFAULT TRUE
)ENGINE=InnoDB DEFAULT CHARSET=UTF8;

INSERT  INTO pessoa(nome) values('MOIS´ES JUVENAL DA SILVA'),('SANDRA SILVA'),('MARIA OLIVEIRA'),('ANDRE SILVA');