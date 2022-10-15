--CRIAÇÃO DAS TABELAS 

CREATE TABLE competencias(
                             id_competencia SERIAL PRIMARY KEY,
                             nome_competencia VARCHAR(20) NOT NULL
)

CREATE TABLE vagas (
                       id_vaga SERIAL PRIMARY KEY,
                       nome_vaga TEXT NOT NULL,
                       descricao_vaga TEXT NOT NULL,
                       modalidade_vaga VARCHAR(10) NOT NULL
)

CREATE TABLE candidatos (
                            id_candidato SERIAL PRIMARY KEY,
                            nome_candidato VARCHAR(20) NOT NULL,
                            email_candidato VARCHAR(64) NOT NULL,
                            pais_candidato VARCHAR(56) NOT NULL,
                            cep_candidato VARCHAR(9) NOT NULL,
                            descricao_candidato TEXT NOT NULL,
                            senha_candidato VARCHAR(10) NOT NULL,
                            data_nascimento DATE NOT NULL,
                            cpf VARCHAR(11) NOT NULL
)

CREATE TABLE empresas (
                          id_empresa SERIAL PRIMARY KEY,
                          nome_empresa TEXT NOT NULL,
                          email_empresa VARCHAR(64) NOT NULL,
                          pais_empresa VARCHAR(56) NOT NULL,
                          cep_empresa VARCHAR(9) NOT NULL,
                          descricao_empresa TEXT NOT NULL,
                          senha_empresa VARCHAR(10) NOT NULL,
                          cnpj VARCHAR(14) NOT NULL
)

CREATE TABLE competenciasdoCandidato(
                                        id_cc SERIAL PRIMARY KEY,
                                        id_candidato INT NOT NULL REFERENCES candidatos(id_candidato),
                                        id_competencia INT NOT NULL REFERENCES competencias(id_competencia)
)

CREATE TABLE competenciasdoCandidato(
                                        id_cc SERIAL PRIMARY KEY,
                                        id_candidato INT NOT NULL REFERENCES candidatos(id_candidato),
                                        id_competencia INT NOT NULL REFERENCES competencias(id_competencia)
)

CREATE TABLE competenciasdaVaga(
                                   id_cv SERIAL PRIMARY KEY,
                                   id_vaga INT NOT NULL REFERENCES vagas(id_vaga),
                                   id_competencia INT NOT NULL REFERENCES competencias(id_competencia)
)

CREATE TABLE vagasdaEmpresa(
                               id_ve SERIAL PRIMARY KEY,
                               id_empresa INT NOT NULL REFERENCES empresas(id_empresa),
                               id_vaga INT NOT NULL REFERENCES vagas(id_vaga)
)
