package daos;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public abstract class GenericDAO {
	
	protected Connection miConexion = null;
	
	// Carga del driver de conexi�n con jdbc:
	static{

		try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			System.out.println("No encuentro el driver (librer�a de mysql)");
			System.out.println("e.getMessage()");
			e.printStackTrace();
		}
	}
	
	protected void conectar(){
		try {
			miConexion = DriverManager.getConnection(
					"jdbc:mysql://localhost:3306/practica_web","root", "jeveris");
		} catch (SQLException e) {
			System.out.println("No pude conectarme a la base de datos");
			System.out.println("Comprobar ruta de la base de datos");
			System.out.println("Comprobar nombre de usuario y contrase�a");
			System.out.println("e.getMessage()");
			e.printStackTrace();
		}
	}
	
	protected void desconectar(){
		try {
			miConexion.close();
		} catch (SQLException e) {
			System.out.println("No pude realizar la desconexi�n");
			System.out.println("e.getMessage()");
			e.printStackTrace();
		}
		
	}
	
}
