package controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.Usuario;
import model.UsuarioDAO;

/**
 * Servlet implementation class Controller
 */
@WebServlet(urlPatterns = { "/Controller", "/main" })
public class Controller extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String action = request.getServletPath();

		if (action.equals("/main")) {
			System.out.println(action);
			newUser(request, response);
		}
	}

	protected void newUser(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		System.out.println(request.getParameter("CPF"));
		System.out.println(request.getParameter("senha"));

		Usuario usuario = new Usuario();
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		usuario.setNome(request.getParameter("nome"));
		usuario.setCPF(request.getParameter("CPF"));
		usuario.setSenha(request.getParameter("senha"));

		usuarioDAO.saveUser(usuario);
		response.sendRedirect("pagina/login.html");
	}

}
