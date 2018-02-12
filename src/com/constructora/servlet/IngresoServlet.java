package com.constructora.servlet;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.constructora.controller.ConstructoraController;

@WebServlet(description = "Toma los datos del index", urlPatterns = { "/IngresoServlet" })
public final class IngresoServlet extends HttpServlet {

	private static final long serialVersionUID = 1L;

	public IngresoServlet() {
		super();
	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {

		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		com.constructora.enteties.Empleado q = ConstructoraController.validaIngresoUsuario(user, pass);
		request.setAttribute("unaModificasion", false);

		if (q.getArea().equals("RRHH")) 
			getServletConfig().getServletContext().getRequestDispatcher("/usuario_registro.jsp").forward(request, response);
		else 
			getServletConfig().getServletContext().getRequestDispatcher("/buen_ingreso_de_datos.jsp").forward(request, response);

		if (q == null) 
			getServletConfig().getServletContext().getRequestDispatcher("/error_ingreso_de_datos.jsp").forward(request, response);
		
	}
}