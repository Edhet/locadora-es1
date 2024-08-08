CREATE TABLE clientes (
	id 			varchar (36) 	PRIMARY KEY, 
	cpf 		long 			NOT NULL UNIQUE, 
	nome 		varchar (80) 	NOT NULL, 
	datanasc 	text 			NOT NULL, 
	logradouro 	varchar (80) 	NOT NULL, 
	numero 		varchar (10) 	NOT NULL, 
	complemento varchar (20) 	NOT NULL, 
	bairro 		varchar (40) 	NOT NULL, 
	cidade 		varchar (40) 	NOT NULL, 
	uf 			char (2) 		NOT NULL, 
	cep 		integer 		NOT NULL, 
	ddd 		integer 		NOT NULL, 
	telefone 	integer 		NOT NULL
);