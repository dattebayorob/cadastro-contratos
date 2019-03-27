CREATE TABLE condominio(
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	endereco VARCHAR(255) NOT NULL,
	numero VARCHAR(255) NOT NULL,
	cep VARCHAR(255) NOT NULL,
	bairro VARCHAR(255) NOT NULL,
	cidade VARCHAR(255) NOT NULL,
	estado VARCHAR(255) NOT NULL
);
INSERT INTO condominio(nome,endereco,numero,cep,bairro,cidade,estado)
	VALUES('José de Alencar','Rua B Conj Res dos Escritores ','255','60000000','Paupina','Fortaleza','Ceará');
CREATE TABLE contrato(
	id BIGSERIAL PRIMARY KEY,
	contrato VARCHAR(255) NOT NULL UNIQUE,
	dia_vencimento INTEGER
);
CREATE TABLE pessoa(
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(255) NOT NULL,
	referencia VARCHAR(255),
	cpf VARCHAR(255),
	data_nascimento DATE,
	id_contrato BIGINT REFERENCES contrato(id),
	id_condominio BIGINT REFERENCES condominio(id),
	bloco VARCHAR(255),
	apartamento VARCHAR(255)
);
INSERT INTO contrato(contrato,dia_vencimento)
	VALUES('777777722333','27');
INSERT INTO pessoa(nome,referencia,cpf,data_nascimento,id_contrato,id_condominio,apartamento,bloco)
	VALUES('Carinha que mora logo ali','Carinha que mora logo ali passa 1 dolar','00000000000','1993-11-18','1','1','104','27');