package servlets;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import daos.ClientesDAO;
import daosImpl.ClientesDAOImpl;
import modelo.Cliente;

@WebServlet("/ServletRegistroCliente")
public class ServletRegistroCliente extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response) 
			throws ServletException, IOException {
		
		if(request.getSession().getAttribute("admin") == null){
			request.getRequestDispatcher("login.jsp").forward(request, response);
			return;
		}
		
		String nombre = request.getParameter("campoNombre");
		String calle = request.getParameter("campoCalle");
		String numero = request.getParameter("campoNumero");
		String codigoPostal = request.getParameter("campoCodigoPostal");
		String poblacion = request.getParameter("campoPoblacion");
		String telefono = request.getParameter("campoTelefono");
		String email = request.getParameter("campoEmail");
		String particularEmpresa = request.getParameter("campoParticularEmpresa");
		
		// Validamos los datos
		String expresionRegularNombre = "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄¸‹Ò—Á«\\s]{1,50}";
		Pattern pattern1 = Pattern.compile(expresionRegularNombre);
		Matcher matcher1 = pattern1.matcher(nombre);
		if(matcher1.matches()){
			System.out.println("Nombre v·lido");
		} else{
			System.out.println("Nombre no v·lido");
			request.setAttribute("mensajeErrorNombre", "Nombre no v·lido");
			request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
			return;
		}
		
		String expresionRegularCalle = "[a-zA-Z0-9·ÈÌÛ˙¡…Õ”⁄¸‹Ò—Á«\\s]{3,70}";
		Pattern pattern2 = Pattern.compile(expresionRegularCalle);
		Matcher matcher2 = pattern2.matcher(calle);
		if(matcher2.matches()){
			System.out.println("Calle v·lida");
		} else{
			System.out.println("Calle no v·lida");
			request.setAttribute("mensajeErrorCalle", "Calle no v·lida");
			request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
			return;
		}
		
		String expresionRegularNumero = "[0-9-]{1,6}";
		Pattern pattern3 = Pattern.compile(expresionRegularNumero);
		Matcher matcher3 = pattern3.matcher(numero);
		if(matcher3.matches()){
			System.out.println("N˙mero v·lido");
		} else{
			System.out.println("N˙mero no v·lido");
			request.setAttribute("mensajeErrorNumero", "N˙mero no v·lido");
			request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
			return;
		}
		
		String expresionRegularCodigoPostal = "[0-9]{5,9}";
		Pattern pattern4 = Pattern.compile(expresionRegularCodigoPostal);
		Matcher matcher4 = pattern4.matcher(codigoPostal);
		if(matcher4.matches()){
			System.out.println("CÛdigo postal v·lido");
		} else{
			System.out.println("CÛdigo postal no v·lido");
			request.setAttribute("mensajeErrorCodigoPostal", "CÛdigo postal no v·lido");
			request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
			return;
		}
		
		String expresionRegularPoblacion = "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄¸‹Ò—Á«\\s]{3,30}";
		Pattern pattern5 = Pattern.compile(expresionRegularPoblacion);
		Matcher matcher5 = pattern5.matcher(poblacion);
		if(matcher5.matches()){
			System.out.println("PoblaciÛn v·lida");
		} else{
			System.out.println("PoblaciÛn no v·lida");
			request.setAttribute("mensajeErrorPoblacion", "PoblaciÛn no v·lida");
			request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
			return;
		}
		
		String expresionRegularTelefono = "[0-9+]{9,30}";
		Pattern pattern6 = Pattern.compile(expresionRegularTelefono);
		Matcher matcher6 = pattern6.matcher(telefono);
		if(matcher6.matches()){
			System.out.println("TelÈfono v·lido");
		} else{
			System.out.println("TelÈfono no v·lido");
			request.setAttribute("mensajeErrorTelefono", "TelÈfono no v·lido");
			request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
			return;
		}
		
		String expresionRegularEmail= "[a-zA-Z·ÈÌÛ˙¡…Õ”⁄Ò—¸‹Á«0-9._+-]{1,70}@"
				+ "[a-zA-Z0-9]{1,30}\\.[a-zA-Z.]{2,20}";
		Pattern pattern7 = Pattern.compile(expresionRegularEmail);
		Matcher matcher7 = pattern7.matcher(email);
		if(matcher7.matches()){
			System.out.println("Correo electrÛnico v·lido");
		} else{
			System.out.println("Correo electrÛnico no v·lido");
			request.setAttribute("mensajeErrorEmail", "Correo electrÛnico no v·lido");
			request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
			return;
		}
		
		String expresionRegularParticularEmpresa = "[PpEe]{1}[a-zA-Z]{5,8}[raRA]{1}";
		Pattern pattern8 = Pattern.compile(expresionRegularParticularEmpresa);
		Matcher matcher8 = pattern8.matcher(particularEmpresa);
		if(matcher8.matches()){
			System.out.println("Particular o empresa v·lido");
		} else{
			System.out.println("Particular o empresa no v·lido");
			request.setAttribute("mensajeErrorParticularEmpresa", 
					"Particular o empresa no v·lido");
			request.getRequestDispatcher("registrarCliente.jsp").forward(request, response);
			return;
		}
		
		
		
		// Fin validaciÛn
		
		Cliente nuevoCliente = new Cliente(nombre, calle, Integer.parseInt(numero), 
				Integer.parseInt(codigoPostal), poblacion, telefono, email, particularEmpresa);
		System.out.println("Vamos a registrar: " + nuevoCliente.toString());
		
		ClientesDAO clientesDAO = new ClientesDAOImpl();
		clientesDAO.registrarCliente(nuevoCliente);
		
		request.getRequestDispatcher("registroClienteOK.jsp").forward(request, response);
	}

}
