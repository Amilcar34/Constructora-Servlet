package com.constructora.servlet.abm;

import java.io.IOException;
import java.util.ArrayList;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import com.constructora.controller.ConstructoraController;
import com.constructora.enteties.Empleado;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "modifica mediane usuario a un empleado", urlPatterns = { "/ModificacionEmpleado" })
public class ModificacionEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;

	public ModificacionEmpleado() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		ArrayList listaArea = ConstructoraController.retornaListaEmpleadosPorArea(request.getParameter("area"));
		request.setAttribute("listaEmpleadosPorArea", listaArea);
		request.setAttribute("unaModificasion", false);
		getServletConfig().getServletContext().getRequestDispatcher("/usuario_registro.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("empleadosModificar", ConstructoraController.listaEmpleadosPorArea);
		request.setAttribute("idEmpleado", request.getParameter("id"));
		request.setAttribute("unaModificasion", true);
		
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String area = request.getParameter("area");
		String name = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		Long id = Long.parseLong((String) request.getParameter("id"));

		Empleado modificaEmpleado = new Empleado(id, name, apellido, user, pass, area);

		if (ConstructoraController.validaUsuarioExistenteParaModificar(modificaEmpleado)) {
			request.setAttribute("exitosaModificacionEmpleado", false);
			RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("/modifica_empleado.jsp"); 
			rd.forward(request, response);
		}else {
			request.setAttribute("exitosaModificacionEmpleado", true);
			ConstructoraController.modificarEmpleado(modificaEmpleado);
			getServletConfig().getServletContext().getRequestDispatcher("/usuario_registro.jsp").forward(request, response);
		}
	}

	protected void doPut(HttpServletRequest request, HttpServletResponse response)throws ServletException, IOException {
		request.setAttribute("idEmpleado", request.getParameter("id"));
		request.setAttribute("empleadosModificar", ConstructoraController.listaEmpleadosPorArea);
		request.setAttribute("unaModificasion", false);
		RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("/modifica_empleado.jsp");
		rd.forward(request, response);

		// getServletConfig().getServletContext().getRequestDispatcher("/modifica_empleado.jsp").forward(request,
		// response);
	}

}
