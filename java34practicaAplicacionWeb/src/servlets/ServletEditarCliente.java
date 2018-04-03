package servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;
import modelo.Cliente;

@WebServlet("/ServletEditarCliente")
public class ServletEditarCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("admin") == null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		int id = Integer.parseInt(request.getParameter("id"));
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		Cliente clienteAEditar = clientesDAO.obtenerClientePorId(id);
		
		request.setAttribute("clienteAEditar", clienteAEditar);
		request.getRequestDispatcher("editarCliente.jsp").forward(request, response);

	}

}
