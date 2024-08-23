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

CREATE TABLE veiculo (
    id varchar (36) PRIMARY KEY,
    placa varchar(7) NOT NULL UNIQUE,
    modelo varchar(30) NOT NULL,
    ano integer NOT NULL,
    diaria double NOT NULL,
    quilometragem integer NOT NULL
);

CREATE TABLE locacao(
    id varchar (36) PRIMARY KEY,
    cpf_cliente long NOT NULL UNIQUE ,
    placa_veiculo varchar(7) NOT NULL UNIQUE,
    data_hora  datetime NOT NULL,
    CONSTRAINT fk_locacao_cliente
        FOREIGN KEY (cpf_cliente) REFERENCES clientes(cpf),
    CONSTRAINT fk_locacao_veiculo
        FOREIGN KEY (placa_veiculo) REFERENCES veiculo(placa)
);