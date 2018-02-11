<%@page import="org.apache.taglibs.standard.tag.common.xml.ForEachTag"%>
<%@page import="jdk.nashorn.internal.runtime.ListAdapter"%>
<%@page import="java.util.ArrayList"%>
<%@page import="com.constructora.enteties.Empleado"%>
<%@page import="jdk.nashorn.internal.runtime.ListAdapter"%>
<%@page import="com.constructora.enteties.Empleado"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="ISO-8859-1"%>
<%
	ArrayList<Empleado> listaEmpleadosPorArea = (ArrayList<Empleado>) request
			.getAttribute("empleadosModificar");
	int id = (int) Integer.parseInt((String) request.getAttribute("idEmpleado"));
	Empleado modificaEmpleado = null;
	for (Empleado tem : listaEmpleadosPorArea)
		if (tem.getId() == id)
			modificaEmpleado = tem;
%>
<head>
<meta charset="UTF-8">
<meta name="viewport"
	content="width=device-width, minimum-scale=1.0, initial-scale=1.0, maximum-scale=1.0">
<link rel="stylesheet" href="css/bootstrap.min.css">
<script src="js/jquery.min.js"></script>
<script src="js/bootstrap.min.js"></script>
</head>
<body>
	<div class="container">
		<table>
			<form class="form-signin" action="ModificaEmpleado" method="PUT">
				<h1 class="h3 mb-3 font-weight-normal">Modifica datos del
					Empleado</h1>
				<tr>
					<td><label for="nombre" class="btn btn-md">Usuario</label>

					<%
						out.print("<input type=\"text\" id=\"user\" class=\"btn btn-md\" placeholder=\"Usuario\" value=\""
								+ modificaEmpleado.getUsuario() + "\" required>");
					%></td>
				</tr>
				<tr>
					<td><label for="nombre" class="btn btn-md">Clave</label> 
					<%
						out.print("<input type=\"text\" id=\"pass\" class=\"btn btn-md\" placeholder=\"Clave\" value=\""
								+ modificaEmpleado.getClave() + "\" required>");
					%></td>
				</tr>
				<tr>
					<td><select id="area" name="area" class="form-control">
							<option value="RRHH">RRHH</option>
							<option value="Constructor">Constructor</option>
							<option value="Electricista">Electricista</option>
							<option value="Seguridad">Seguridad</option>
					</select></td>
				</tr>
				<tr>
					<td><label for="nombre" class="btn btn-md">Nombre</label>
					<%
						out.print("<input type=\"text\" id=\"nombre\" class=\"btn btn-md\" placeholder=\"Nombre\" value=\""
								+ modificaEmpleado.getNombre() + "\" required>");
					%></td>
				</tr>
				<tr>
					<td><label for="apellido" class="btn btn-md">Apellido</label>
					<%
						out.print("<input type=\"text\" id=\"apellido\" class=\"btn btn-md\" placeholder=\"Apellido\" value=\""
								+ modificaEmpleado.getApellido() + "\" required>");
					%></td>
				</tr>
				<button class="btn btn-lg btn-primary btn-block" type="submit">Modificar</button>
			</form>
		</table>
	</div>
</body>
</html>