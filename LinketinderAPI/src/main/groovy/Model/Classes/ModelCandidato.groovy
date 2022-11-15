package Model.Classes

class ModelCandidato {
    String nome_candidato
    String email_candidato
    String pais_candidato
    String cep_candidato
    String descricao_candidato
    String senha_candidato
    String data_nascimento
    String cpf


    @Override
    public String toString() {
        return "ModelCandidato{" +
                "nome_candidato='" + nome_candidato + '\'' +
                ", email_candidato='" + email_candidato + '\'' +
                ", pais_candidato='" + pais_candidato + '\'' +
                ", cep_candidato='" + cep_candidato + '\'' +
                ", descricao_candidato='" + descricao_candidato + '\'' +
                ", senha_candidato='" + senha_candidato + '\'' +
                ", data_nascimento='" + data_nascimento + '\'' +
                ", cpf='" + cpf + '\'' +
                '}';
    }
}
