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
<title>Insert title here</title>
</head>
<body>


<!-- Declaración -->

<!-- Scriptlet -->
<%
/*
ACA SE PUEDE PROBAR QUE FUNCIONE LA DB
Seguro seg = new Seguro(3,"holiwis",2,54.65,21.25);
SeguroNegocioImpl sn =new SeguroNegocioImpl();

if(sn.insert(seg))
{
System.out.print("holis");	
}*/
%>
<a href="#"> Inicio </a>
<a href="#"> Agregar seguro </a>
<a href="#"> Listar Seguros </a>
<h1>Agregar Seguros</h1>

<form method="get" action="Agregar.jsp">
 <label for="txtIdSeguro">Id Seguro:</label><br>
 <input type="text" name="txtIdSeguro"><br>
 <label for="txtDescripcion">Descrición:</label><br>
 <input type="text" name="txtDescripcion"><br>
 <label for="txtTipoSeguro">Tipo de Seguro:</label><br>
 <input type="text" name="txtTipoSeguro"><br>
 <label for="txtCostoContratacion">Costo de Contratación:</label><br>
 <input type="text" name="txtCostoContratacion"><br>
 <label for="txtCostoAsegurado">Costo máximo asegurado: </label><br>
 <input type="text" name="txtCostoAsegurado"><br><br>
 <input type="submit" value="Agregar">
</form>

<p></p>
<p></p>
<p></p>
<p></p>
</body>
</html>