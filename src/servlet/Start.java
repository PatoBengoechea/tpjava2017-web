package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.Servlet;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import controlers.CtrlABMCPersona;
import entities.Persona;
import util.AppDataException;

/**
 * {@link Servlet} implementation class Start
 */
@WebServlet({ "/Start", "/start" })
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger;

    /**
     * Default constructor. 
     */
    public Start() {
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		response.getWriter().append("Served at: ").append(request.getContextPath());
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			String user=request.getParameter("user");
			String pass=request.getParameter("pass");
			
			Persona per=new Persona();
			per.setUsuario(user);
			per.setPassword(pass);
			
			CtrlABMCPersona ctrl= new CtrlABMCPersona();
		
			Persona pers = new Persona();;
			try {
				pers = ctrl.buscarUsuario(per);
			} catch (AppDataException ape) {
				logger = LogManager.getLogger(getClass());
				logger.error(ape.getInnerException().getMessage());
				PrintWriter out = response.getWriter(); 
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('"+ ape.getMessage() +"');");
			    out.println("location='login.html';");
			    out.println("</script>");
				
			}
			
			
			if(pers.getUsuario().equals("vacio"))
			{	
				PrintWriter out = response.getWriter(); 
				 out.println("<script type=\"text/javascript\">");
				 out.println("alert('Usuario o Contraseņa incorrecto');");
				 out.println("location='login.html';");
				 out.println("</script>");
			}
			else{
			request.getSession().setAttribute("user", pers);
			request.getSession().setAttribute("idPersona", pers.getIdPersona());
			if(pers.isAdmin()){
			request.getRequestDispatcher("WEB-INF/lib/MenuAdmin.jsp").forward(request, response);	
			}
			else{
			request.getRequestDispatcher("WEB-INF/lib/MenuUser.jsp").forward(request, response);
			}
			}		
		} catch (Exception e) {
			logger = LogManager.getLogger(getClass());
			logger.error(e.getMessage());
			PrintWriter out = response.getWriter(); 
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Intentelo mas tarde');");
		    out.println("location='login.html';");
		    out.println("</script>");
		}
		
	}

}
