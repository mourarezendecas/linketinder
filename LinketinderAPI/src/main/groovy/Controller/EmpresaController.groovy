package Controller

import DatabaseConnection.ModelConnection
import Model.Classes.ModelEmpresa
import Model.DAO.DAOEmpresa
import groovy.sql.Sql

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet (urlPatterns = "/empresas")
class EmpresaController extends HttpServlet{
    DAOEmpresa daoEmpresa = new DAOEmpresa()
    ModelConnection modelConnection = new ModelConnection()
    ModelEmpresa modelEmpresa = new ModelEmpresa()

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        modelEmpresa.nome_empresa = req.getParameter("nome_empresa")
        modelEmpresa.cnpj = req.getParameter("cnpj")
        modelEmpresa.email_empresa = req.getParameter("email_empresa")
        modelEmpresa.pais_empresa = req.getParameter("pais_empresa")
        modelEmpresa.cep_empresa = req.getParameter("cep_empresa")
        modelEmpresa.descricao_empresa = req.getParameter("descricao_empresa")
        modelEmpresa.senha_empresa = req.getParameter("senha_empresa")

        daoEmpresa.create(modelEmpresa)
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter()
        Sql sql = modelConnection.connect()
        sql.eachRow("SELECT * FROM empresas"){
            empresa->
                writer.println ("==EMPRESA==")
                writer.println ("ID: " + empresa.id_empresa)
                writer.println ("NOME: " + empresa.nome_empresa)
                writer.println ("CNPJ: " + empresa.cnpj)
                writer.println ("EMAIL: " + empresa.email_empresa)
                writer.println ("PAIS: " + empresa.pais_empresa)
                writer.println ("CEP: " + empresa.cep_empresa)
                writer.println ("DESCRICAO: " + empresa.descricao_empresa)
        }
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = req.getParameter("id").toInteger()
        String nome_empresa = req.getParameter("nome_empresa")
        String cnpj = req.getParameter("cnpj")
        String email_empresa = req.getParameter("email_empresa")
        String pais_empresa = req.getParameter("pais_empresa")
        String cep_empresa = req.getParameter("cep_empresa")
        String descricao_empresa = req.getParameter("descricao_empresa")
        String senha_empresa = req.getParameter("senha_empresa")

        if(nome_empresa!="null")
        {
            daoEmpresa.updateNome(id,nome_empresa)
        }
        if(cnpj!="null")
        {
            daoEmpresa.updateCNPJ(id,cnpj)
        }
        if(email_empresa!="null")
        {
            daoEmpresa.updateEmail(id,email_empresa)
        }
        if(pais_empresa!="null")
        {
            daoEmpresa.updatePais(id,pais_empresa)
        }
        if(cep_empresa!="null")
        {
            daoEmpresa.updateCEP(id, cep_empresa)
        }
        if(descricao_empresa!="null")
        {
            daoEmpresa.updateDescricao(id, descricao_empresa)
        }
        if(senha_empresa!="null")
        {
            daoEmpresa.updateSenha(id, senha_empresa)
        }
    }
}
