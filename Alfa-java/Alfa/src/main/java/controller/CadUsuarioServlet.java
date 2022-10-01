package controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioDAO;

/**
 * Servlet implementation class CadUsuarioServlet
 */
@WebServlet(urlPatterns = {"/CadUsuarioServlet"})
public class CadUsuarioServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// response.getWriter().append("Served at: ").append(request.getContextPath());
		System.out.println("Chegou aqui no servlet pelo cadusuario");

		response.sendRedirect("pagina/cadastro.jsp");

	}
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		
		String CPF = request.getParameter("CPF");
		System.out.println(request.getParameter("senha"));

		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuario.setNome(request.getParameter("nome"));
		usuario.setCPF(request.getParameter("CPF"));
		usuario.setSenha(request.getParameter("senha"));

		Usuario userBD = usuarioDAO.getClientes(CPF);

		boolean cadSucess = false;
		
		if(userBD == null) {
			System.out.println("ESSE CPF NÃO EXISTE NO BANCO");
			usuarioDAO.saveUser(usuario);
			response.sendRedirect("pagina/CadSucess.jsp");
		}
		else if (userBD.getCPF().equals(CPF)) {
			System.out.println("ESSE CPF JÁ EXISTE NO BANCO");	
			//RequestDispatcher rd = request.getRequestDispatcher("pagina/cadastro.jsp");
			//rd.forward(request, response);
			response.sendRedirect("pagina/cadastro.jsp");
		}
	}

}
