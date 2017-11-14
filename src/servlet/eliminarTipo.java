package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMCPersona;
import controlers.CtrlABMCTipoElemento;
import entities.TipoElemento;
import util.AppDataException;

/**
 * Servlet implementation class eliminarTipo
 */
@WebServlet("/eliminarTipo")
public class eliminarTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eliminarTipo() {
        super();
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
			CtrlABMCTipoElemento ctrlPer = new CtrlABMCTipoElemento();
			TipoElemento tipo = new TipoElemento();
			int id =  Integer.parseInt((String)request.getParameter("idTipo"));
			tipo.setIdTipo(id);
			ctrlPer.eliminoTip(tipo);
			request.getRequestDispatcher("WEB-INF/lib/ABMTipoElemento.jsp").forward(request, response);
			}
		catch(Exception e)
		{
			PrintWriter out = response.getWriter(); 
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('"+ e.getMessage() +"');");
		    out.println("</script>");
		    response.sendRedirect("WEB-INF/lib/ABMTipoElemento.jsp");
		}
		
	}

}
