package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.catalina.Session;

import controlers.CtrlABMCElemento;
import controlers.CtrlABMCPersona;
import controlers.CtrlABMCReserva;
import entities.Elemento;
import entities.Persona;
import entities.Reserva;

/**
 * Servlet implementation class realizaActualizaReserva
 */
@WebServlet("/realizaActualizaReserva")
public class realizaActualizaReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public realizaActualizaReserva() {
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
		String idElemento = request.getParameter("tipoElemento").toString();
		request.setAttribute("idSel", idElemento);
		if(request.getParameter("elemento") == null){
		request.getRequestDispatcher("WEB-INF/lib/Reservar.jsp").forward(request, response);
		}
		else{
	    CtrlABMCReserva controlador = new CtrlABMCReserva();
	    CtrlABMCElemento controladorElemento = new CtrlABMCElemento();
	    CtrlABMCPersona controladorPersona = new CtrlABMCPersona();
	    String fechaini = request.getParameter("fechaini").toString();
	    String fechafin = request.getParameter("fechafin").toString();
	    String diasanti = request.getParameter("diasanti").toString();
	    String diasres = request.getParameter("diasmax").toString();
	    Reserva r = new Reserva();
	    Elemento e = new Elemento();
	    Persona p = (Persona)request.getSession().getAttribute("user");
	    p.setIdPersona(p.getIdPersona());
		String idElem = request.getParameter("elemento").toString();
		e.setIdElemento(idElem);
		r.setElemento(controladorElemento.buscarElemento(e));
		r.setPersona(p);
		Date fInicio = Date.valueOf(fechaini);
		Date fFin = Date.valueOf(fechafin);
		r.setFechaInicio(fInicio);
		r.setFechaFin(fFin);
		int danti = Integer.parseInt(diasanti);
		int dres = Integer.parseInt(diasres);
		String message = controlador.addReserva(r,dres,danti);
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
	    out.println("alert('"+ message +"');");
	    out.println("location='WEB-INF/lib/Reservar.jsp';");
	    out.println("</script>");
		//request.getRequestDispatcher("WEB-INF/lib/mostrarReservas.jsp").forward(request, response);
		}
	}

}
