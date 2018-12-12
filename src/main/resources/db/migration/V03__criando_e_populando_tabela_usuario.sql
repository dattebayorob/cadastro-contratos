CREATE TABLE usuario(
	id BIGSERIAL PRIMARY KEY,
	nome VARCHAR(255),
	login VARCHAR(255) NOT NULL,
	senha VARCHAR(255) NOT NULL,
	permissao VARCHAR(255) NOT NULL
);
INSERT INTO usuario (nome,login,senha,permissao) VALUES
	('Usuario Com Moral','admin','$2a$10$baLUeE1MN2LYZtvnBHNr9OMH/wcgHWjZ/BwRkV3mhPtekLSnzxZtm','ROLE_ADMIN'),
	('Usuario Sem Moral','user','$2a$10$X8Mh8s8r1n0gk5jr3M5r9eB0rU8QebBG.Yrg214U9Osih7wse4Jeq','ROLE_USUARIO');