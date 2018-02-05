<%@page import="jdk.nashorn.internal.runtime.ListAdapter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.constructora.enteties.Empleado"%>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>


<%
	ArrayList<Empleado> usuarios = (ArrayList<Empleado>) request.getAttribute("listaUsuarios");

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
</head>
<body>
        <!-- Example row of columns -->
        <div class="row">
        	<div class="col-md-5">
        		<h2>Añadir un nuevo empleado</h2>
				<form action="AltaEmpleado" method="POST">
					<div class="form-label-group">
						<label for="usuario">Usuario</label> 
						<input type="text" id="usuario"name="user" class="form-control" placeholder="Usuario" requiredautofocus>
					</div>
					<div class="form-label-group">
						<label for="password">Contraseña</label> 
						<input type="password"
							id="password" name="pass" class="form-control"
							placeholder="Contraseña" required>
					</div>
					<div class="form-label-group">
						<select id="area" name="area" class="form-control form-control-lg">
							<option value="RRHH">RRHH</option>
							<option value="Constructor">Constructor</option>
							<option value="Electricista">Electricista</option>
							<option value="Seguridad">Seguridad</option>
						</select>
					</div>
					<div class="form-label-group">
						<label for="nombre">Nombre</label>
						<input type="text" id="nombre" name="nombre" class="form-control" placeholder="Nombre" required>
					</div>
					<div class="form-label-group">
						<label for="apellido">Apellido</label>
						<input type="text" id="apellido" name="apellido" class="form-control" placeholder="Apellido" required>
					</div>
					<button class="btn btn-lg btn-primary btn-block" type="submit">Registrar
						empleado</button>
				</form>
			</div>
			
			
			<div class="col-md-5">
				<h2>Busqueda de empleados</h2>
				<form action="ModificacionEmpleado" method="get">					
					<div class="form-label-group">
						<select id="area" name="area" class="form-control form-control-lg">
							<option value="RRHH">RRHH</option>
							<option value="Constructor">Constructor</option>
							<option value="Electricista">Electricista</option>
							<option value="Seguridad">Seguridad</option>
						</select>
					</div>

					<button class="btn btn-lg btn-primary btn-block" type="submit">Buscar empleados por área</button>
					
				</form>
				
			</div>
			<div class="col-md-2">
				<%
					if(usuarios != null)
						for(Empleado tem: usuarios)
							out.print("<h5>" + tem.getNombre() + "</h5><br>");
			
				%>
			</div>

		<p class="mt-5 mb-3 text-muted text-center">&copy; Construtora 2018</p>
		</div>
		
		
		
		
		<c:forEach var="usuarios" items="${usuarios}">
			${usuarios} <br>
		</c:forEach>

	
	<c:forEach var="usuarios" items="${usuarios}">
		${usuarios} <br>
	</c:forEach>
</body>
</html>