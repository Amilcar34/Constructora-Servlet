package com.constructora.controller;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.constructora.dao.IConnection;
import com.constructora.enteties.Empleado;

public final class ConstructoraController {

	public static ArrayList<Empleado> listaEmpleadosPorArea;

	public static Empleado validaIngresoUsuario(String user, String pass) {

		Connection con = null;
		con = new IConnection() {
		}.getConnection();
		Empleado edo = null;
		try {
			String arg0 = "SELECT * FROM users WHERE user=? AND pass=?";
			PreparedStatement ps = con.prepareStatement(arg0);
			ps.setString(1, user);
			ps.setString(2, pass);

			ResultSet rs = ps.executeQuery();

			if (rs.absolute(1)) {
				edo = new Empleado(rs.getString("nombre"), rs.getString("apellido"), rs.getString("area"));
				cargaIngresoEmpleado(edo);
			}
		} catch (Exception e) {
			System.out.println("El error esta en el try de ConstructoraController.validaIngresoUsuario");
		}
		return edo;
	}

	private static void cargaIngresoEmpleado(Empleado empleado) {

		try {
			Connection con = new IConnection() {
			}.getConnection();

			String sql = "INSERT INTO empleados(nombres, apellidos, fecha_y_hora_ingreso) VALUES (?,?,?)";
			PreparedStatement ps = con.prepareStatement(sql);
			ps.setString(1, empleado.getNombre());
			ps.setString(2, empleado.getApellido());
			ps.setString(3, new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date()).toString());
			ps.execute();
			ps.close();

		} catch (Exception e0) {
			System.out.println("El error esta en el try de ConstructoraController.cargaIngresoEmpleado");;
		}
	}

	public static boolean validaUsuarioExistenteParaAlta(Empleado nuevoEmpleado) {

		boolean ok = false;
		Connection con = null;
		con = new IConnection() {
		}.getConnection();

		try {
			String arg0 = "SELECT * FROM users WHERE user=?";
			PreparedStatement ps = con.prepareStatement(arg0);
			ps.setString(1, nuevoEmpleado.getUsuario());

			ResultSet rs = ps.executeQuery();

			if (rs.absolute(1))
				ok = true;
			else
				cargaDeNuevoEmpleado(nuevoEmpleado);

		} catch (Exception e) {
			System.out.println("Error en el try de ConstructoraController.validaUsuarioExistente");
		}
		return ok;
	}

	private static void cargaDeNuevoEmpleado(Empleado nuevoEmpleado) {
		Connection con;
		con = new IConnection() {
		}.getConnection();

		try {
			String arg0 = "INSERT INTO users (user, pass, area, nombre, apellido) VALUES (?, ?, ?, ?, ?)";
			PreparedStatement ps = con.prepareStatement(arg0);
			ps.setString(1, nuevoEmpleado.getUsuario());
			ps.setString(2, nuevoEmpleado.getClave());
			ps.setString(3, nuevoEmpleado.getArea());
			ps.setString(4, nuevoEmpleado.getNombre());
			ps.setString(5, nuevoEmpleado.getApellido());
			ps.execute();
			ps.close();

		} catch (Exception e) {
			System.out.println("Error en el try de ConstructoraController.cargaDeNuevoEmpleado");		}
	}

	public static ArrayList<Empleado> retornaListaEmpleadosPorArea(String parameter) {

		ArrayList<Empleado> listaEmpleadoPorArea = new ArrayList<>();

		try {
			Connection con = new IConnection() {
			}.getConnection();

			if (con != null) {
				String sql = "SELECT * FROM users WHERE area=?";
				PreparedStatement ps = con.prepareStatement(sql);
				ps.setString(1, parameter);
				ResultSet rs = ps.executeQuery();
				

				while (rs.next()) {
					listaEmpleadoPorArea.add(new Empleado(rs.getLong("id"), rs.getString("nombre"), rs.getString("apellido"), rs.getString("user"), rs.getString("pass"), rs.getString("area")));
				}
				listaEmpleadosPorArea = listaEmpleadoPorArea;
			}
		} catch (Exception e) {
			System.out.println("Error en el try de ConstructoraController.retornaListaEmpleadosPorArea");
		}
		return listaEmpleadoPorArea;
	}

	public static boolean eliminarEmpleado(Long id) {
		boolean delete = false;
		try {
			Connection con = new IConnection() {
			}.getConnection();

			if (con != null) {
				PreparedStatement ps = null;
				String sql = "DELETE FROM users WHERE id=?";
				ps = con.prepareStatement(sql);
				ps.setLong(1, id);
				ps.execute();
				ps.close();
				delete = true;
				
			}
		} catch (Exception e) {
			System.out.println("Error en el try de ConstructoraController.eliminarEmpleado");
		}
		
		return delete;
	}

	public static boolean validaUsuarioExistenteParaModificar(Empleado usuarioEmpleado) {
		boolean ok = false;
		Connection con = null;
		con = new IConnection() {
		}.getConnection();

		try {
			String arg0 = "SELECT * FROM users WHERE user=? AND id!=?";
			PreparedStatement ps = con.prepareStatement(arg0);
			ps.setString(1, usuarioEmpleado.getUsuario());
			ps.setLong(2, usuarioEmpleado.getId());
			ResultSet rs = ps.executeQuery();

			if (rs.absolute(1))
				ok = true;
			else
				modificarEmpleado(usuarioEmpleado);

		} catch (Exception e) {
			System.out.println("Error en el try de ConstructoraController.validaUsuarioExistenteParaModificar");
		}
		return ok;
	}
	
	public static boolean modificarEmpleado(Empleado modificaEmpleado) {
		boolean cambioRealizado = false;
		
		try {
			IConnection ic = new IConnection(){};
			Connection con = ic.getConnection();
			
			if(con != null){
				PreparedStatement ps = null;
				String sql = "UPDATE users SET user=?, pass=?, area=?, nombre=?, apellido=? WHERE id=?";
				ps = con.prepareStatement(sql);
				ps.setString(1, modificaEmpleado.getUsuario());
				ps.setString(2, modificaEmpleado.getClave());
				ps.setString(3, modificaEmpleado.getArea());
				ps.setString(4, modificaEmpleado.getNombre());
				ps.setString(5, modificaEmpleado.getApellido());
				ps.setLong(6, modificaEmpleado.getId());
				ps.execute();
				ps.close();
				cambioRealizado = true;
			}else{
				System.err.println("No se realizo la coneccion a la DB");
				cambioRealizado = false;
			}
				
		} catch (Exception e) {
			System.err.println("Unable to connect");
			e.printStackTrace();
		}
		
		return cambioRealizado;
	}

}
