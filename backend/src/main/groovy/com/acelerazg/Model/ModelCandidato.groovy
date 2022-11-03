package com.acelerazg.Model

class ModelCandidato extends Usuario{
    private String cpf
    private String data_nasc

    String getCpf() {
        return cpf
    }

    void setCpf(String cpf) {
        this.cpf = cpf
    }

    String getData_nasc() {
        return data_nasc
    }

    void setData_nasc(String data_nasc) {
        this.data_nasc = data_nasc
    }
}
