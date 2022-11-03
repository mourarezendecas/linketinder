package com.acelerazg.Model

class ModelEmpresa extends Usuario{
    private String cnpj

    String getCnpj() {
        return cnpj
    }

    void setCnpj(String cnpj) {
        this.cnpj = cnpj
    }
}
