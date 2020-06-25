package cl.indefensoinformatico.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

//Para pobar escriba en su navegado
//http://localhost:8080/suProyecto/galletaServlet
//en mi caso fue:
//http://localhost:8080/OlaKAse/galletaServlet

/**
 * Servlet implementation class galletaServlet
 */
public class galletaServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public galletaServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    // Metodo para GET
    
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) 
                   throws ServletException, IOException {
     response.setContentType("text/html");
     response.setHeader("Cache-Control", "no-cache");
      
     Cookie[] cookies = request.getCookies();
     Cookie contador = buscaCookie("contador", cookies);
      
     if (contador == null)
     {
        // Creamos la cookie con el contador
              
        Cookie cookie = new Cookie ("contador", "1");
        cookie.setMaxAge(180);
        response.addCookie(cookie);
  
        // Mostramos el mensaje de primera visita
  
        PrintWriter out = response.getWriter();
        out.println ("<HTML>");            
        out.println ("<BODY>");            
        out.println ("Primera visita"); 
        out.println ("<BR>");
        out.println ("</BODY>");
        out.println ("</HTML>");
  
     } else {
      
        // Obtenemos el valor actual del contador
              
        int cont = Integer.parseInt(contador.getValue());
        cont++;
          
        // Modificamos el valor de la cookie 
        // incrementando el contador
              
        Cookie cookie = new Cookie ("contador", "" + cont);
        cookie.setMaxAge(180);
        response.addCookie(cookie);
  
        // Mostramos el numero de visitas
  
        PrintWriter out = response.getWriter();
        out.println ("<HTML>");
        out.println ("<BODY>");
        out.println ("Visita numero " + cont);
        out.println ("<BR>");
        out.println ("</BODY>");
        out.println ("</HTML>");
     }       
    }    
  
    // Busca la cookie 'nombre' 
    // en el array de cookies indicado. 
    // Devuelve null si no esta
      
    private Cookie buscaCookie(String nombre, 
                               Cookie[] cookies)
    {
     if (cookies == null)
        return null;
      
     for (int i = 0; i < cookies.length; i++)
        if (cookies[i].getName().equals(nombre))
         return cookies[i];
      
     return null;
    }

}
