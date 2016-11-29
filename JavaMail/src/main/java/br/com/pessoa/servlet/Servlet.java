package br.com.pessoa.servlet;

import br.com.pessoa.dao.DaoEmail;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(name = "Servlet", urlPatterns = {"/Servlet"})
public class Servlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {

        request.setCharacterEncoding("UTF-8");

        String nome = request.getParameter("nome");
        String email = request.getParameter("email");
        String assunto = request.getParameter("assunto");
        String descricao = request.getParameter("descricao");

        System.out.println(nome + email + assunto + descricao);

        String mensagem = "Nome: " + nome + "\nEmail: " + email + "\nMensagem: " + descricao;
        DaoEmail ctrlEmail = new DaoEmail();
        for (int i = 0; i < 20; i++) {
            ctrlEmail.sendMail("xmakitaxxx@gmail.com", "xmakitaxxx@gmail.com", assunto, mensagem);
        }

        response.sendRedirect("Ok.html");
        response.sendError(0);
    }
}
