<%@page import="jdk.nashorn.internal.runtime.ListAdapter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.constructora.enteties.Empleado"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%
	ArrayList<Empleado> listaEmpleadosPorArea = (ArrayList<Empleado>) request.getAttribute("listaEmpleadosPorArea");
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, initial-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
<link href="css/floating-labels.css" rel="stylesheet">
<link href="css/signin.css" rel="stylesheet">
</head>
<body>
	<div class="container">
        <div class="row">
        	<div class="col-md-6">
       			<jsp:include page="carga_nuevo_empleado.html"></jsp:include>
			</div>
			<div class="col-md-6">
			<h2>Busqueda de empleados</h2>
				<form action="ModificacionEmpleado" method="get">					
						<select id="area" name="area" class="form-control">
							<option value="RRHH">RRHH</option>
							<option value="Constructor">Constructor</option>
							<option value="Electricista">Electricista</option>
							<option value="Seguridad">Seguridad</option>
						</select>
					<input class="btn btn-lg btn-primary btn-block" type="submit" value="Buscar empleados por área"/>
				</form>
				<br>
					<form action="ServletAccesible" method="POST">
										
						<div class="form-label-group">
							<%
								if(listaEmpleadosPorArea != null){		
									out.print("<select name=\"id\"class=\"form-control form-control-lg\">");
										for(Empleado tem: listaEmpleadosPorArea){
											out.print("<option value=\""+tem.getId()+"\">"+tem.getNombre()+" "+tem.getApellido()+"</option>");
										}
										
									out.print("</select>");
									//out.print("<input type=\"text\" id=\"test\" value=\""+usuarios.get(1).getApellido()+"\"");
								}
							%>	
						</div>
						<%
							if(listaEmpleadosPorArea != null){
								out.print("<input style=\"background:red\" name=\"elimina\" class=\"btn btn-lg btn-primary\" type=\"submit\" value=\"Eliminar Empleado\"/>");
								out.print("<input style=\"background:blue\" name=\"modifica\" class=\"btn btn-lg btn-primary\" type=\"submit\" value=\"Modificar Empleado\"/>");							
							}
					out.print("</form>");
						%>
			</div>
			
		</div>
	<p class="mt-5 mb-3 text-muted text-center">&copy; Construtora 2018</p>
	</div>
</body>
</html>

<!--  


-->