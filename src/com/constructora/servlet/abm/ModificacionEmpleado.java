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

/**
 * Servlet implementation class ModificacionEmpleado
 */
@WebServlet(description = "modifica mediane usuario a un empleado", urlPatterns = { "/ModificacionEmpleado" })
public class ModificacionEmpleado extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
    public ModificacionEmpleado() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ArrayList listaArea = ConstructoraController.retornaListaEmpleadosPorArea(request.getParameter("area"));
		request.setAttribute("listaEmpleadosPorArea", listaArea);
		getServletConfig().getServletContext().getRequestDispatcher("/usuario_registro.jsp").forward(request, response);		
	}

	
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.setAttribute("idEmpleado", request.getParameter("id"));
		request.setAttribute("empleadosModificar", ConstructoraController.listaEmpleadosPorArea);
		RequestDispatcher rd = (RequestDispatcher) request.getRequestDispatcher("/modifica_empleado.jsp");
		System.out.println(request.getAttribute("idEmpleado"));
		rd.forward(request, response);
		//getServletConfig().getServletContext().getRequestDispatcher("/modifica_empleado.jsp").forward(request, response);
	}

	
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		
	}

}
