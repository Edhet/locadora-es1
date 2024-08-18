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

-- TODO: Criar veículo e locação
CREATE TABLE veiculo (
    id varchar (36) PRIMARY KEY,
    placa varchar(7) NOT NULL,
    modelo varchar(30) NOT NULL,
    ano integer NOT NULL,
    diaria double NOT NULL,
    quilometragem integer NOT NULL
);

CREATE TABLE locacao(
    id varchar (36) PRIMARY KEY,
    cpf long NOT NULL UNIQUE,
    nome varchar (80) NOT NULL,
    placa varchar(7) NOT NULL,
    modelo varchar(30) NOT NULL,
    data_hora datetime NOT NULL
);
