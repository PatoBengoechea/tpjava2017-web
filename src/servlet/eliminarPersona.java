package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMCPersona;

/**
 * Servlet implementation class eliminarPersona
 */
@WebServlet("/eliminarPersona")
public class eliminarPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eliminarPersona() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CtrlABMCPersona ctrlPer = new CtrlABMCPersona();
		int id =  Integer.parseInt((String)request.getParameter("idPersona"));
		try {
			ctrlPer.eliminoPer(id);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('"+ e.getMessage()+"');");
		    out.println("location='login.html';");
		    out.println("</script>");
		}
		request.getRequestDispatcher("WEB-INF/lib/ABMPersona.jsp").forward(request, response);
	}

}
