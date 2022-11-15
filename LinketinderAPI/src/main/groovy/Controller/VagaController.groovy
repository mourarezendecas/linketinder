package Controller

import DatabaseConnection.ModelConnection
import Model.Classes.ModelVaga
import Model.DAO.DAOVaga
import groovy.sql.Sql

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = "/vagas")
class VagaController extends HttpServlet{
    ModelConnection modelConnection = new ModelConnection()
    ModelVaga modelVaga = new ModelVaga()
    DAOVaga daoVaga = new DAOVaga()

    //CREATE
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        modelVaga.nome_vaga = req.getParameter("nome_vaga")
        modelVaga.descricao_vaga = req.getParameter("descricao_vaga")
        modelVaga.modalidade_vaga = req.getParameter("modalidade_vaga")
        daoVaga.create(modelVaga)
    }

    //READ
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter()
        Sql sql = modelConnection.connect()
        sql.eachRow("SELECT * FROM vagas"){
            vagas ->
                writer.println("ID: " + vagas.id_vaga)
                writer.println("Nome: " + vagas.nome_vaga)
                writer.println("Descrição: " + vagas.descricao_vaga)
                writer.println("Modalidade: " + vagas.modalidade_vaga)
        }
        sql.close()
    }

    //UPDATE NOME
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = req.getParameter("id").toInteger()
        String novo_nome = req.getParameter("novo_nome")
        String nova_descricao = req.getParameter("nova_descricao")
        String nova_modalidade = req.getParameter("nova_modalidade")

        if(novo_nome!="null")
        {
            daoVaga.updateNome(id, novo_nome)
        }
        if(nova_descricao !="null")
        {
            daoVaga.updateDescricao(id, nova_descricao)
        }
        if(nova_modalidade !="null")
        {
            daoVaga.updateModalidade(id, nova_modalidade)
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = req.getParameter("id").toInteger()
        daoVaga.delete(id)
    }
}
