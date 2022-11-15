package Controller

import DatabaseConnection.ModelConnection
import Model.Classes.ModelCompetencia
import Model.DAO.DAOCompetencia
import groovy.sql.Sql

import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet(urlPatterns = "/competencias")
class CompetenciaController extends HttpServlet{
    DAOCompetencia daoCompetencia = new DAOCompetencia()
    ModelConnection modelConnection = new ModelConnection()
    ModelCompetencia modelCompetencia = new ModelCompetencia()

    //CREATE
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        modelCompetencia.nome_competencia = req.getParameter("nome_competencia")
        daoCompetencia.create(modelCompetencia)
    }

    //READ
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter()
        Sql sql = modelConnection.connect()
        sql.eachRow("SELECT * FROM competencias"){
            competencia ->
                writer.println("ID: " + competencia.id_competencia)
                writer.println("Nome: " + competencia.nome_competencia)
        }
        sql.close()
    }

    //UPDATE
    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = req.getParameter("id").toInteger()
        String novoNome= req.getParameter("novo_nome")
        daoCompetencia.updateNome(id, novoNome)
    }

    //DELETE
    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = req.getParameter("id").toInteger()
        daoCompetencia.delete(id)
    }
}