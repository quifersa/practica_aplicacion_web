package daosImpl;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

import daos.ConstantesSQL;
import daos.GenericDAO;
import daos.UsuariosDAO;

public class UsuariosDAOImpl extends GenericDAO implements UsuariosDAO{

	@Override
	public boolean identificarUsuario(String nombreUsuario, String pass) {
		boolean admin = false;
		conectar();
		PreparedStatement ps;
		try {
			ps = miConexion.prepareStatement(ConstantesSQL.IDENTIFICACION_USUARIO);
			ps.setString(1,nombreUsuario);
			ps.setString(2, pass);
			ResultSet rs = ps.executeQuery();
			if (rs.next()) {
				admin = true;
			}
			ps.close();
		} catch (SQLException e) {
			System.out.println("sql de identificación tiene problemas");
			System.out.println("e.getMessage()");
			e.printStackTrace();
		}
		desconectar();
		return admin;
	}

		
	
}
