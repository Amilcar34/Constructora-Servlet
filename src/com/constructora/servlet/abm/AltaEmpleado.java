package com.constructora.servlet.abm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.constructora.controller.ConstructoraController;
import com.constructora.enteties.Empleado;

@WebServlet("/AltaEmpleado")
public class AltaEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
    
    public AltaEmpleado() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		String name = request.getParameter("nombre");
		String apellido = request.getParameter("apellido");
		String user = request.getParameter("user");
		String pass = request.getParameter("pass");
		String area = request.getParameter("area");

		Empleado nuevoEmpleado = new Empleado(name, apellido, user, pass, area);	
		
		if(ConstructoraController.validaNuevoEmpleado(nuevoEmpleado))
			getServletConfig().getServletContext().getRequestDispatcher("/error_usuario_existente.jsp").forward(request, response);
		else
			getServletConfig().getServletContext().getRequestDispatcher("/usuario_registro.html").forward(request, response);
	}

}
