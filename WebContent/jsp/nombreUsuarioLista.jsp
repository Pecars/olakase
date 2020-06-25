<%-- 
    Ejemplo de formulario con validación simple y JSTL
--%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Lista nombre de usuario con JSP</title>
    </head>
    <body>
        <%-- Mostramos resultado --%>
        <c:if test="${not empty param.nombre}"> <%--and fn:length(param.nombre)<=0}">--%>
        	<h1>Holi ${param.nombre}</h1>
        </c:if>
        <%-- Mostramos formulario --%>
        <c:if test="${empty param.nombre or fn:length(param.nombre)>50}">
        <h1>Su nombre</h1>
        <form method="POST">
            <input type="text" name="nombre" value="nombre" placeholder="Su nombre" >
            ${fn:length(param.nombre)>50?"La longitud no puede ser mayor que 50":""}
            <input type="submit" name="Enviar" value="Guardar">
        </form>
        </c:if>
    </body>
</html>