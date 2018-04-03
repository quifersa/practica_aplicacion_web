package daos;

public class ConstantesSQL {
	
	public static final String IDENTIFICACION_USUARIO = 
			"select nombre_usuario from tabla_usuarios where nombre_usuario = ? and pass = ?";
	
	public static final String INSERTAR_CLIENTE = 
			"insert into tabla_clientes (nombre,calle,numero,codigo_postal,poblacion,telefono,"
			+ "email,particular_empresa) values (?,?,?,?,?,?,?,?)";
	
	public static final String INSERTAR_PROVEEDOR = 
		   "insert into tabla_proveedores (nombre_empresa,direccion,telefono,email,web,"
		   + "nombre_representante,telefono_representante,ambito_actividad,"
		   + "certificado_ministerio_industria,estructura_juridica) values (?,?,?,?,?,?,?,?,?,?)";
	
	public static final String SELECCIONAR_CLIENTES = "select * from tabla_clientes";
	
	public static final String SELECCIONAR_PROVEEDORES = "select * from tabla_proveedores";

	public static final String BORRAR_CLIENTE = "delete from tabla_clientes where id = ?";
	
	public static final String BORRAR_PROVEEDOR = "delete from tabla_proveedores where id = ?";

	public static final String OBTENER_CLIENTE_POR_ID = 
			"select * from tabla_clientes where id = ?";
	
	public static final String OBTENER_PROVEEDOR_POR_ID = 
			"select * from tabla_proveedores where id = ?";

	public static final String GUARDAR_CAMBIOS_CLIENTE = 
			"update tabla_clientes set nombre = ?, calle = ?, numero = ?, codigo_postal = ?, "
			+ "poblacion = ?, telefono = ?, email = ?, particular_empresa = ? where id = ?";
	
	public static final String GUARDAR_CAMBIOS_PROVEEDOR = 
			"update tabla_proveedores set nombre_empresa=?, direccion=?, telefono=?, email=?, "
			+ "web=?, nombre_representante=?, telefono_representante=?, ambito_actividad=?, "
			+ "certificado_ministerio_industria=?, estructura_juridica=? where id=?";

}
