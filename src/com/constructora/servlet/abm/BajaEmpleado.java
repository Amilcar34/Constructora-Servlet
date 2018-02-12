package com.constructora.servlet.abm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.constructora.controller.ConstructoraController;

@WebServlet(description = "Elimina de forma directa los empleados", urlPatterns = { "/BajaEmpleado" })
public class BajaEmpleado extends HttpServlet {
	
	private static final long serialVersionUID = 1L;
       
    public BajaEmpleado() {
        super();
    }


	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		String user = request.getParameter("usuario");
	}


	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}


	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}

	public void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		ConstructoraController.eliminarEmpleado(Long.parseLong(request.getParameter("id")));
	}

}
