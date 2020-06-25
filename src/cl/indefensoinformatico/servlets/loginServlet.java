package cl.indefensoinformatico.servlets;

import java.io.IOException;
import java.io.PrintWriter;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class loginServlet
 */
public class loginServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public loginServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    /*
    @Override
	protected void doGet(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = solicitud.getParameter("usuario");
		String contrasena = solicitud.getParameter("contrasena");
		if ("indefensoInformatico".equals(usuario) && "0023Do".equals(contrasena)) {
			response(respuesta, "logeo pulento!");
		} else {
			response(respuesta, "logue penca!");
		}
	}
    */
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
    @Override
	protected void doPost(HttpServletRequest solicitud, HttpServletResponse respuesta) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String usuario = solicitud.getParameter("usuario");
		String contrasena = solicitud.getParameter("contrasena");
		if ("indefensoInformatico".equals(usuario) && "0023Do".equals(contrasena)) {
			response(respuesta, "logeo pulento!");
		} else {
			response(respuesta, "logue penca!");
		}
	}
    
	private void response(HttpServletResponse response, String mensaje) throws IOException {
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("<t1>" + mensaje + "</t1>");
		out.println("</body>");
		out.println("</html>");
	}

}
