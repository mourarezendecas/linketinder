package Controller

import DatabaseConnection.ModelConnection
import Model.Classes.ModelCandidato
import Model.DAO.DAOCandidato
import groovy.sql.Sql

import javax.servlet.Servlet
import javax.servlet.ServletException
import javax.servlet.annotation.WebServlet
import javax.servlet.http.HttpServlet
import javax.servlet.http.HttpServletRequest
import javax.servlet.http.HttpServletResponse

@WebServlet (urlPatterns = "/candidatos")
class CandidatoController extends HttpServlet{
    ModelConnection modelConnection = new ModelConnection()
    ModelCandidato modelCandidato = new ModelCandidato()
    DAOCandidato daoCandidato = new DAOCandidato()

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        modelCandidato.nome_candidato = req.getParameter("nome_candidato")
        modelCandidato.cpf = req.getParameter("cpf")
        modelCandidato.data_nascimento = req.getParameter("data_nascimento")
        modelCandidato.email_candidato = req.getParameter("email_candidato")
        modelCandidato.pais_candidato = req.getParameter("pais_candidato")
        modelCandidato.cep_candidato = req.getParameter("cep_candidato")
        modelCandidato.descricao_candidato = req.getParameter("descricao_candidato")
        modelCandidato.senha_candidato = req.getParameter("senha_candidato")

        daoCandidato.create(modelCandidato)
    }

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        PrintWriter writer = resp.getWriter()
        Sql sql = modelConnection.connect()
        sql.eachRow("SELECT * FROM candidatos"){
            candidato ->
                writer.println ("ID: " + candidato.id_candidato)
                writer.println ("NOME: " + candidato.nome_candidato)
                writer.println ("CPF: " +candidato.cpf)
                writer.println ("NASCIMENTO: " + candidato.data_nascimento)
                writer.println ("EMAIL: " + candidato.email_candidato)
                writer.println ("PAIS: " + candidato.pais_candidato)
                writer.println ("CEP: " + candidato.cep_candidato)
        }
        sql.close()
    }

    @Override
    protected void doPut(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = req.getParameter("id").toInteger()
        String nome_candidato = req.getParameter("novo_nome")
        String cpf = req.getParameter("novo_cpf")
        String data_nascimento = req.getParameter("nova_data")
        String email_candidato = req.getParameter("novo_email")
        String pais_candidato = req.getParameter("novo_pais")
        String cep_candidato = req.getParameter("novo_cep")
        String descricao_candidato = req.getParameter("nova_descricao")
        String senha_candidato = req.getParameter("nova_senha")
        if(nome_candidato!="null")
        {
            daoCandidato.updateNome(id,nome_candidato)
        }
        if(cpf!="null")
        {
            daoCandidato.updateCPF(id,cpf)
        }
        if(data_nascimento!="null")
        {
            daoCandidato.updateNascimento(id,data_nascimento)
        }
        if(email_candidato!="null")
        {
            daoCandidato.updateEmail(id,email_candidato)
        }
        if(pais_candidato!="null")
        {
            daoCandidato.updatePais(id,pais_candidato)
        }
        if(cep_candidato!="null")
        {
            daoCandidato.updateCEP(id, cep_candidato)
        }
        if(descricao_candidato!="null")
        {
            daoCandidato.updateDescricao(id, descricao_candidato)
        }
        if(senha_candidato!="null")
        {
            daoCandidato.updateSenha(id, senha_candidato)
        }
    }

    @Override
    protected void doDelete(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Integer id = req.getParameter("id").toInteger()
        daoCandidato.delete(id)
    }
}
