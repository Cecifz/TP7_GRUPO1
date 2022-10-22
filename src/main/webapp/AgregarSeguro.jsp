<%@ page import="daoImpl.Conexion"%>
<%@ page import="daoImpl.SeguroDaoImpl"%>
<%@ page import="dao.SeguroDao"%>
<%@ page import="entidad.Seguro"%>
<%@ page import="negocio.SeguroNegocio"%>
<%@ page import="negocioImpl.SeguroNegocioImpl"%>
<%@ page import=  "java.sql.Connection" %>
<%@ page import=  "java.sql.DriverManager" %>
<%@ page import=  "java.sql.PreparedStatement" %>
<%@ page import=  "java.util.Properties" %>
<%@ page import=  "java.sql.SQLException" %>
<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="ISO-8859-1">
<title>Agregar Seguro</title>
</head>
<body>


<!-- Declaraci�n -->
<%! int idSeguro = Seguro.proximoNroID(); %>


<a href="Inicio.jsp"> Inicio </a>
<a href="#"> Agregar seguro </a>
<a href="#"> Listar Seguros </a>
<h1>Agregar Seguros</h1>

<form method="get" action="servletSeguro">
 <label for="txtIdSeguro">Id Seguro:</label><br>
 <input type="text" name="txtIdSeguro" disabled value=<%=idSeguro %>> <br>
 <label for="txtDescripcion">Descrici�n:</label><br>
 <input type="text" name="txtDescripcion"><br>
 <label for="txtTipoSeguro">Tipo de Seguro:</label><br>
 <input type="text" name="txtTipoSeguro"><br>
 <label for="txtCostoContratacion">Costo de Contrataci�n:</label><br>
 <input type="text" name="txtCostoContratacion"><br>
 <label for="txtCostoAsegurado">Costo m�ximo asegurado: </label><br>
 <input type="text" name="txtCostoAsegurado"><br><br>
 <input type="submit" value="Agregar" name="btnAgregar">
</form>

<%
    boolean agregado = false;
	if(request.getAttribute("cantFilas")!=null)
		agregado= (boolean)request.getAttribute("cantFilas");
	if(agregado == true) { 
%>
<p>Seguro agregado con �xito</p>
<% }  %>

<p></p>
<p></p>
<p></p>
<p></p>
</body>
</html>