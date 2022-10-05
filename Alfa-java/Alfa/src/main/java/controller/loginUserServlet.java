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
 * Servlet implementation class loginUserServlet
 */
@WebServlet(urlPatterns = { "/loginUserServlet" })
public class loginUserServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		
		System.out.println("VEIO PELO LOGINUSERSERVLET");
		response.sendRedirect("pagina/login.html");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		UsuarioDAO usuarioDAO = new UsuarioDAO();
		Usuario usuario = new Usuario();
		
		String CPF = request.getParameter("CPF");
		String senha = request.getParameter("Senha");
		
		usuario.setCPF(CPF);
		usuario.setSenha(senha);		
		
		Usuario userBD = usuarioDAO.getClientes(CPF);

		
		System.out.println("veio pelo form");
		System.out.println("LOGIN: ");
		System.out.println("CPF:"  + CPF);
		System.out.println( "SENHA: " + senha);
		
		System.out.println(userBD.getCPF());
		
		if(userBD.getCPF().equals(usuario.getCPF()) && userBD.getSenha().equals(usuario.getSenha())) {
			
			response.sendRedirect("pagina/dashboard.html");
			System.out.println("LOGIN EFETUADO COM SUCESSO");
			
		}else {
			response.sendRedirect("pagina/login.html");
		}
		
		
		
		
		
	}

}
