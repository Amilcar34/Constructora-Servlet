package com.constructora.servlet;

import java.io.IOException;

import javax.servlet.FilterChain;
import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;

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
		int q = ConstructoraController.validaIngresoUsuario(user, pass);

		if (q == 5) {
			RequestDispatcher rd = request.getRequestDispatcher("/usuario_registro.jsp");
			rd.forward(request, response);
		} else if (q == 1) {
			RequestDispatcher rd = request.getRequestDispatcher("/buen_ingreso_de_datos.jsp");
			rd.forward(request, response);
		} else if (q == 0) {
			getServletConfig().getServletContext().getRequestDispatcher("/error_ingreso_de_datos.jsp").forward(request,
					response);
		}
	}
}