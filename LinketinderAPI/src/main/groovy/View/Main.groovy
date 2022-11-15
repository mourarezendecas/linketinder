package View

import Model.Classes.ModelEmpresa
import Model.DAO.DAOCandidato
import Model.DAO.DAOEmpresa

class Main {
    static void main(String[] args) {
        ModelEmpresa empresa = new ModelEmpresa()
        DAOEmpresa daoEmpresa = new DAOEmpresa()

        empresa.nome_empresa = "ZG Solucoes"
        empresa.cnpj = "CNPJ"
        empresa.email_empresa = "jobs@zg.com"
        empresa.pais_empresa = "Brasil"
        empresa.cep_empresa = "7400000"
        empresa.descricao_empresa = "Venha conciliar"
        empresa.senha_empresa = "senha123"

        //daoEmpresa.create(empresa)

    }
}
