package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.UsuariosDAO;
import daosImpl.UsuariosDAOImpl;

@WebServlet("/ServletIdentificacionUsuario")
public class ServletIdentificacionUsuario extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
				
		String nombreUsuario = request.getParameter("campoNombreUsuario");
		String pass = request.getParameter("campoPass");
		
		System.out.println("Voy a identificar a: " + nombreUsuario + " " + pass);
		UsuariosDAO usuariosDAO = new UsuariosDAOImpl();
		
		if (usuariosDAO.identificarUsuario(nombreUsuario, pass)) {
			request.getSession().setAttribute("admin", "ok");
			request.getRequestDispatcher("loginOK.jsp").forward(request, response);
		} else{
			request.setAttribute("mensajeErrorEntrar", "Usuario y/o contraseña inválido");
			request.getRequestDispatcher("login.jsp").forward(request, response);
		}
	}

}
