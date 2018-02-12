package com.constructora.enteties;

public class Empleado {
	
	private Long id;
	private String nombre;
	private String apellido;
	private String usuario;
	private String clave;
	private String horaFechaDeIngreso;
	private String horaFechaDeEgreso;
	private String area;
	
	
	
	public Empleado(String nombre, String apellido, String area) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.area = area;
	}

	public Empleado(Long id, String nombre, String apellido, String usuario, String clave, String area) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.area = area;
	}

	public Empleado(String nombre, String apellido, String usuario, String clave, String area) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.area = area;
	}



	public Empleado(long id, String nombre, String apellido, String usuario, String clave, String area) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.usuario = usuario;
		this.clave = clave;
		this.area = area;
	}



	public String getNombre() {
		return nombre;
	}
	public void setNombre(String nombre) {
		this.nombre = nombre;
	}
	public String getApellido() {
		return apellido;
	}
	public void setApellido(String apellido) {
		this.apellido = apellido;
	}
	public String getUsuario() {
		return usuario;
	}
	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}
	public String getClave() {
		return clave;
	}
	public void setClave(String clave) {
		this.clave = clave;
	}
	public String getHoraFechaDeIngreso() {
		return horaFechaDeIngreso;
	}
	public void setHoraFechaDeIngreso(String horaFechaDeIngreso) {
		this.horaFechaDeIngreso = horaFechaDeIngreso;
	}
	public String getHoraFechaDeEgreso() {
		return horaFechaDeEgreso;
	}
	public void setHoraFechaDeEgreso(String horaFechaDeEgreso) {
		this.horaFechaDeEgreso = horaFechaDeEgreso;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	@Override
	public String toString() {
		return "Empleado [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + ", usuario=" + usuario
				+ ", clave=" + clave + ", horaFechaDeIngreso=" + horaFechaDeIngreso + ", horaFechaDeEgreso="
				+ horaFechaDeEgreso + ", area=" + area + "]";
	}
}
