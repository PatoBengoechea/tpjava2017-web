package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMCReserva;
import entities.Reserva;

/**
 * Servlet implementation class eliminarRes
 */
@WebServlet("/eliminarRes")
public class eliminarRes extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eliminarRes() {
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
		// TODO Auto-generated method stub
		Reserva res = new Reserva();
		CtrlABMCReserva ctrl = new CtrlABMCReserva();
		int id = Integer.parseInt(request.getParameter("idRes").toString());
		res.setIdReserva(id);
		try {
			ctrl.delete(res);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('"+ e.getMessage()+"');");
		    out.println("location='login.html';");
		    out.println("</script>");
		}
		request.getRequestDispatcher("WEB-INF/lib/mostrarTodasReservas.jsp").forward(request, response);
	}

}
