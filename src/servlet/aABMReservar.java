package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

/**
 * Servlet implementation class aABMReservar
 */
@WebServlet("/aABMReservar")
public class aABMReservar extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private Logger logger;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public aABMReservar() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			request.setAttribute("idSel", 0);
			request.getRequestDispatcher("WEB-INF/lib/Reservar.jsp").forward(request, response);
		} catch (Exception e) {
			
			logger = LogManager.getLogger(getClass());
			logger.error(e.getMessage());
			
			
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('"+ e.getMessage()+"');");
		    out.println("location='login.html';");
		    out.println("</script>");
		}
	}
}
