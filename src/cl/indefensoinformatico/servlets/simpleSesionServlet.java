package cl.indefensoinformatico.servlets;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class simpleSesionServlet
 */
public class simpleSesionServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public simpleSesionServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

    // Metodo para GET
    
    public void doGet(HttpServletRequest request, 
                      HttpServletResponse response) 
                   throws ServletException, IOException {
        response.setContentType("text/html");
        response.setHeader("Cache-Control", "no-cache");
         
        HttpSession sesion = request.getSession();
        PrintWriter out = response.getWriter();
 
        if (sesion.isNew()) {
            // Mostramos un mensaje de primera visita
 
            out.println ("<HTML>");           
            out.println ("<BODY>");           
            out.println ("Primera visita a la pagina");
            out.println ("<BR>");
            out.println ("</BODY>");          
            out.println ("</HTML>");          
             
            sesion.setAttribute("contador", new Integer(1));
             
        } else {
 
            // Mostramos el numero de visitas 
            // y actualizamos el contador
             
            int contador = ((Integer)
                (sesion.getAttribute("contador"))).intValue();
            contador++;
 
            out.println ("<HTML>");           
            out.println ("<BODY>");           
            out.println ("Visita numero " + 
                         contador + 
                         " a la pagina en esta sesion");
            out.println ("<BR>");
            out.println ("</BODY>");
            out.println ("</HTML>");
             
            sesion.setAttribute("contador", 
                                new Integer(contador));
    }       
   }    

}
