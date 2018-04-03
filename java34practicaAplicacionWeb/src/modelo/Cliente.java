package modelo;

public class Cliente {
	
	String nombre;
	String calle;
	int numero;
	int codigoPostal;
	String poblacion;
	String telefono;
	String email;
	String particularEmpresa;
	int id;
	
	public Cliente() {
		
	}

	public Cliente(String nombre, String calle, int numero,
			int codigoPostal, String poblacion, String telefono,
			String email, String particularEmpresa) {
		this.nombre = nombre;
		this.calle = calle;
		this.numero = numero;
		this.codigoPostal = codigoPostal;
		this.poblacion = poblacion;
		this.telefono = telefono;
		this.email = email;
		this.particularEmpresa = particularEmpresa;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public int getNumero() {
		return numero;
	}

	public void setNumero(int numero) {
		this.numero = numero;
	}

	public int getCodigoPostal() {
		return codigoPostal;
	}

	public void setCodigoPostal(int codigoPostal) {
		this.codigoPostal = codigoPostal;
	}

	public String getPoblacion() {
		return poblacion;
	}

	public void setPoblacion(String poblacion) {
		this.poblacion = poblacion;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getParticularEmpresa() {
		return particularEmpresa;
	}

	public void setParticularEmpresa(String particularEmpresa) {
		this.particularEmpresa = particularEmpresa;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Cliente [nombre=" + nombre + ", calle=" + calle + ", número="
				+ numero + ", código postal=" + codigoPostal + ", población="
				+ poblacion + ", teléfono=" + telefono + ", correo electrónico=" + email
				+ ", particular o empresa=" + particularEmpresa + ", id=" + id
				+ "]";
	}

	
	
	
	
	
}
