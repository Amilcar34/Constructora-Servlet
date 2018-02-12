package com.constructora.servlet.abm;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@WebServlet(description = "esto sera solo de prueba", urlPatterns = { "/ServletAccesible" })
public class ServletAccesible extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
  
    public ServletAccesible() {
    }

	
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {		
		if (request.getParameter("modifica")!=null) {
			new ModificacionEmpleado().doPut(request, response);
		}
		else if (request.getParameter("elimina")!=null) {
			new BajaEmpleado().doDelete(request, response);
		}
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	}
}
