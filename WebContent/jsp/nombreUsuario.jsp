<%-- 
    Ejemplo de formulario con validación simple en JSP utilizando scriptlets
--%>

<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>Nombre de usuario con JSP</title>
    </head>
    <body>
        <%=(request.getParameter("nombre") != null ? request.getParameter("nombre") : "")%>

        <% String nombre = request.getParameter("nombre");
            if (nombre == null) {
                nombre = "";
            }
        %>
        <%if (nombre != "") {   //Mostramos nombre de usuario%>
        <h1>Holi <%=nombre%></h1>

        <%} else {    // Mostramos formulario%>
        <h1>Su nombre</h1>
        <form method="POST">
            <input type="text" name="nombre" value="<%=nombre%>" placeholder="Su nombre" >
            <input type="submit" name="Enviar" value="Guardar">
        </form>
        <%};%>
    </body>
</html>