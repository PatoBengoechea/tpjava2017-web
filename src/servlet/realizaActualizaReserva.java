package servlet;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Date;
import java.util.logging.Logger;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.Session;
import org.apache.logging.log4j.LogManager;

import controlers.CtrlABMCElemento;
import controlers.CtrlABMCPersona;
import controlers.CtrlABMCReserva;
import entities.Elemento;
import entities.Persona;
import entities.Reserva;
import util.AppDataException;

/**
 * Servlet implementation class realizaActualizaReserva
 */
@WebServlet("/realizaActualizaReserva")
public class realizaActualizaReserva extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private org.apache.logging.log4j.Logger logger;
       
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

		if(request.getParameter("elemento") == null){
		String idElemento = request.getParameter("tipoElemento").toString();
		request.setAttribute("idSel", idElemento);	
		request.getRequestDispatcher("WEB-INF/lib/Reservar.jsp").forward(request, response);
		}
		else{
	    CtrlABMCReserva controlador = new CtrlABMCReserva();
	    CtrlABMCElemento controladorElemento = new CtrlABMCElemento();
	    String fechaini = request.getParameter("anioini").toString() + "-" + request.getParameter("mesini").toString() + "-" + request.getParameter("diaini").toString();
	    String fechafin = request.getParameter("aniofin").toString() + "-" + request.getParameter("mesfin").toString() + "-" + request.getParameter("diafin").toString();
	    String diasanti = request.getParameter("diasanti").toString();
	    String diasres = request.getParameter("diasmax").toString();
	    String mailUser = "";
	    if(!(request.getParameter("mail") == null)){
	    mailUser = request.getParameter("mail").toString();
	    }
	    Reserva r = new Reserva();
	    Elemento e = new Elemento();
	    Persona p = (Persona)request.getSession().getAttribute("user");
	    p.setIdPersona(p.getIdPersona());
		String idElem = request.getParameter("elemento").toString();
		e.setIdElemento(idElem);
			try {
				r.setElemento(controladorElemento.buscarElemento(e));
			} catch (AppDataException ape) {		
				logger = LogManager.getLogger(getClass());
				logger.error(ape.getInnerException().getMessage());
				PrintWriter out = response.getWriter(); 
				out.println("<script type=\"text/javascript\">");
			    out.println("alert('"+ ape.getMessage() +"');");
			    out.println("location='login.html';");
			    out.println("</script>");
			}
		r.setPersona(p);
		try {
			Date fInicio = Date.valueOf(fechaini);
			Date fFin = Date.valueOf(fechafin);
			r.setFechaInicio(fInicio);
			r.setFechaFin(fFin);
		}
		catch(Exception exfecha)
		{
			PrintWriter out = response.getWriter(); 
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('Ha ingresado mal la fecha ');");
		    out.println("location='login.html';");
		    out.println("</script>");
		}
		
		int danti = Integer.parseInt(diasanti);
		int dres = Integer.parseInt(diasres);
		String message = "No se pudo realizar la Reserva";
		try {
		message = controlador.addReserva(r,dres,danti,mailUser);
		} catch (AppDataException ape) {
			logger = LogManager.getLogger(getClass());
			logger.error(ape.getInnerException().getMessage());
			PrintWriter out = response.getWriter(); 
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('"+ ape.getMessage() +"');");
		    out.println("location='login.html';");
		    out.println("</script>");
		}
		PrintWriter out = response.getWriter();
		out.println("<script type=\"text/javascript\">");
	    out.println("alert('"+ message +"');");
	    out.println("location='index.jsp';");
	    out.println("</script>");
	    out.println();
		if(p.isAdmin()){
		request.getRequestDispatcher("WEB-INF/lib/mostrarTodasReservas.jsp").forward(request, response);}
		else{
		request.getRequestDispatcher("WEB-INF/lib/mostrarReservas.jsp").forward(request, response);}
		}
	}

}
