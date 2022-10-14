package com.acelerazg.classes

class Candidato {
    String nome, email, CPF, estado, CEP, descPessoal
    int idade
    List competencias = []
    List empresasCurtidas = []

    @Override
    public String toString() {
        return """
                Candidato: $nome
                Idade: $idade
                e-mail: $email
                CPF: $CPF
                Estado: $estado
                CEP: $CEP
                Descrição: $descPessoal
                Competências: $competencias
                """
    }

    def curtida (Empresa empresa){
        empresasCurtidas.add(empresa)
    }

}
