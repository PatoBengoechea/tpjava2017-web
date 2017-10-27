package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMCPersona;
import entities.Persona;

/**
 * Servlet implementation class Start
 */
@WebServlet({ "/Start", "/start" })
public class Start extends HttpServlet {
	private static final long serialVersionUID = 1L;

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
			
//			Persona pers =ctrl.buscarUsuario(per);
//			
//			if(pers.getUsuario().equals("vacio"))
//			{
//				PrintWriter out = response.getWriter(); 
//				response.setContentType("text/html"); 
//				out.println("<script> alert(USUARIO/PASSWORD INVALIDOS); </script>"); 
//			}
//			else{
//			request.getSession().setAttribute("user", pers);
			request.getRequestDispatcher("WEB-INF/lib/Menu.jsp").forward(request, response);
			//response.getWriter().append(user).append(" ").append(pass);
//			}
			
		} catch (Exception e) {
			e.printStackTrace();
		}
		//doGet(request, response);
	}

}
