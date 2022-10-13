--CRIAÇÃO DAS TABELAS 

CREATE TABLE Competencias(
	cod_competencia SERIAL PRIMARY KEY,
	nome_competencia VARCHAR(20) NOT NULL
);

CREATE TABLE Vagas(
	cod_vaga SERIAL PRIMARY KEY,
	nome_vaga VARCHAR(20) NOT NULL, 
	descricao_vaga TEXT NOT NULL,
	local_vaga VARCHAR(20) NOT NULL, 
	cod_competencia INT NOT NULL REFERENCES Competencias(cod_competencia)
);

CREATE TABLE Informacoes (
	cod_informacao SERIAL PRIMARY KEY,
	nome VARCHAR(20) NOT NULL, 
	email VARCHAR(30) NOT NULL, 
 pais VARCHAR NOT NULL,
 cep VARCHAR(9) NOT NULL,
 descricao TEXT NOT NULL,
 senha VARCHAR(10) NOT NULL
);

CREATE TABLE Candidatos(
	cod_candidato SERIAL PRIMARY KEY,
	informacao INT NOT NULL REFERENCES Informacoes(cod_informacao), 
	data_nascimento DATE NOT NULL, 
	cpf VARCHAR(11) NOT NULL, 
	competencias INT NOT NULL REFERENCES Competencias(cod_competencia)
);

CREATE TABLE Empresas(
	cod_empresa SERIAL PRIMARY KEY, 
	informacao INT NOT NULL REFERENCES Informacoes(cod_informacao),
	cnpj VARCHAR(14) NOT NULL, 
	vagas INT NOT NULL REFERENCES Vagas(cod_vaga)
);

CREATE TABLE MatchLink(
	cod_match SERIAL PRIMARY KEY, 
	empresa INT NOT NULL REFERENCES Empresas(cod_empresa), 
	candidato INT NOT NULL REFERENCES Candidatos(cod_candidato)
);

--INSERÇÃO DE DADOS 


--Competências
INSERT INTO Competencias (nome_competencia)
VALUES 
('Python'),
('Java'),
('Spring'),
('Angular'),
('Swift'),
('Kotlin');

--Vagas
INSERT INTO Vagas(nome_vaga, descricao_vaga, local_vaga, cod_competencia)
VALUES ('Desenvolvedor Júnior','Descrição referente a uma vaga de desenvolvedor júnior', 'Remoto', 5),
		 ('Estágio','Descrição referente a uma vaga de estágio de desenvolvimento', 'Remoto', 2),
		 ('Desenvolvedor Pleno','Descrição referente a uma vaga de desenvolvedor pleno', 'Presencial', 3),
	     ('Desenvolvedor Sênior','Descrição referente a uma vaga de desenvolvedor sênior', 'Presencial', 6),
		 ('Analista de BI','Descrição referente a uma vaga de analista de BI', 'Remoto', 1);

--Informações 
INSERT INTO Informacoes (nome, email, pais, cep, descricao, senha)
Inserindo as informações sobre as empresas
VALUES ('Apple','jobs@apple.com','USA','CEP','Breve descrição sobre a Apple', 'senha'),
	   ('ZG Soluções', 'jobs@zg.com','BR','CEP','Breve descrição sobre a ZG', 'senha2'), 
	   ('Amazon', 'jobs@amazon.com', 'USA', 'CEP', 'Breve desecrição sobre a Amazon', 'senha3'),
	   ('Roystar Royco', 'jobs@roystar.com','USA', 'CEP', 'Breve desecrição sobre a Amazon', 'senha4'),
	   ('Nubank', 'jobs@nubank.com','BR', 'CEP', 'Breve descrição sobre a Nubank', 'senha5');

--Inserindo as informações sobre os candidatos 
VALUES ('Alana Freitas', 'alanafreitas@gmail.com', 'BR', 'CEP', 'Breve descrição sobre a Alana', 'senha'),
	   ('Maria Eduarda', 'mariaeduarda@gmail.com', 'BR', 'CEP', 'Breve descrição sobre a Maria Eduarda', 'senha2'),
	   ('Paulo Ricardo', 'pr@gmail.com', 'BR', 'CEP', 'Breve descrição sobre o Paulo Ricardo', 'senha3'),
	   ('Mark Zukerberg', 'mark@gmail.com', 'BR', 'CEP', 'Breve descrição sobre o Mark Zukerberg', 'senha4'),
	   ('Gabriel Rezende', 'gabrielrezende@gmail.com', 'BR', 'CEP', 'Breve descrição sobre o Gabriel Rezende', 'senha5');
	   
--Empresas
INSERT INTO Empresas(informacao,cnpj,vagas)
VALUES (1,'00000000000000',1),
	   (2,'11111111111111',2),
	   (3,'22222222222222',3),
	   (4,'33333333333333',4),
	   (5,'44444444444444',5);
	   
--Candidatos
INSERT INTO Candidatos (informacao, data_nascimento, cpf, competencias)
VALUES (1,'2000-01-01','11111111111',1),
	   (2,'2000-01-01','22222222222',2),
	   (3,'2000-01-01','33333333333',3),
	   (4,'2000-01-01','44444444444',4),
	   (5,'2000-01-01','55555555555',5);


















