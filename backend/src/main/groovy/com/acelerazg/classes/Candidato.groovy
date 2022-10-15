package com.acelerazg.classes

class Candidato {
    String nome, email, pais, cep, descricao, senha, cpf, data_nasc


    @Override
    public String toString() {
        return "Candidato{" +
                "nome='" + nome + '\'' +
                ", email='" + email + '\'' +
                ", pais='" + pais + '\'' +
                ", cep='" + cep + '\'' +
                ", descricao='" + descricao + '\'' +
                ", senha='" + senha + '\'' +
                ", cpf='" + cpf + '\'' +
                ", data_nasc=" + data_nasc +
                '}';
    }
}
