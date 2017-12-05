package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import entities.Persona;

/**
 * Servlet implementation class editarPer
 */
@WebServlet("/editarPer")
public class editarPer extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public editarPer() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession sesion = request.getSession();
		Persona per2 = (Persona)sesion.getAttribute("user");
		if(per2.isAdmin()){
		String id = (String)request.getParameter("idPer");
		int ide = Integer.parseInt(id);
		request.setAttribute("idPer2", ide);
		request.getRequestDispatcher("WEB-INF/lib/editarPersona.jsp").forward(request, response);}
		else{
		int ide2 = per2.getIdPersona();
		request.setAttribute("idPer2", ide2);
		request.getRequestDispatcher("WEB-INF/lib/editarPersona.jsp").forward(request, response);
		}
	}

}
