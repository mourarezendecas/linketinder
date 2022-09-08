package com.acelera.classes

//Nome, E-mail Corporativo, CNPJ, País, Estado, CEP e Descrição da empresa;

class Empresa {
    String nome, email, CNPJ, pais, estado, CEP, descricao;
    List competencias = []
    List cadidatosCurtidos = []

    @Override
     String toString() {
        return """
                \n
                Empresa: $nome
                e-mail: $email
                CNPJ: $CNPJ
                País: $pais
                Estado: $estado
                CEP: $CEP
                Descrição: $descricao
                Competências esperadas: $competencias
                \n
                """
    }

    def curtida (Candidato candidato){
        cadidatosCurtidos.add(candidato)
    }

    String getNome(){
        return nome
    }

    List getCadidatosCurtidos() {
        return cadidatosCurtidos
    }
}
