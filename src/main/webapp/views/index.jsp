<%--
  Created by IntelliJ IDEA.
  User: posei
  Date: 25/08/2021
  Time: 10:19 a. m.
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<c:set var="context" value="${pageContext.request.contextPath}" />
<html>
<head>
    <title>Productos</title>
    <link rel="stylesheet" href="${context}/assets/plugins/bootstrap/css/bootstrap.min.css">
    <link rel="stylesheet" href="${context}/assets/dist/css/styles.css">
    <link href="https://use.fontawesome.com/releases/v5.0.6/css/all.css" rel="stylesheet">
</head>
<body>
<form action="${context}/updateAparatos" method="POST">
<div class="container">
    <label for="">Nombre del componente:</label>
    <input type="text" id="nombre" class="form-control">
    <br>
    <label for="">Direccion:</label>
    <select  id="direccion" class="form-control">
        <option value="0" selected> Direccion del proveedor</option>
        <option value="1">Gigabyte Mexico</option>
        <option value="2">Xbox Mexico</option>
    </select>
    <br>
    <label for="">Fecha de Lanzamiento:</label>
    <input type="date" id="fechaDeRegistro" class="form-control">
    <br>
    <div class="card">
    <input type="hidden" id="index">
    <button id="register" type="submit" onclick="create()" class="btn btn-success">Registrar</button>
    <button id="update" type="submit" onclick="update()" class="btn btn-info">Actualizar</button>
        </div>
</div>
<div>
<table id="container" class="table table-hover">
    <thead class="table-dark">
    <tr>
        <th>#</th>
        <th>Nombre</th>
        <th>Dirección del Fabricante</th>
        <th>Fecha de Registro</th>
        <th>Estado</th>
        <th>Acciones</th>
    </tr>
    </thead>
    <tbody></tbody>
</table>
</div>

<script src="${context}/assets/plugins/bootstrap/js/bootstrap.min.js"></script>
<script src="https://code.jquery.com/jquery-3.6.0.js" integrity="sha256-H+K7U5CnXl1h5ywQfKtSj8PCmoN9aaq30gDh27Xc0jk=" crossorigin="anonymous"></script>
<script src="${context}/assets/dist/js/main.js"></script>
</body>
</html>
