package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.*;
import entities.Persona;
import entities.TipoElemento;

/**
 * Servlet implementation class realizaAltaTipo
 */
@WebServlet({ "/realizaAltaPersona", "/realizaaltapersona" })
public class realizaAltaPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public realizaAltaPersona() {
        super();
        // TODO Auto-generated constructor stub
    }

	
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			CtrlABMCPersona tiposs = new CtrlABMCPersona();
			String dni = request.getParameter("dnitxt").toString();
			String nombre = request.getParameter("nombretxt").toString();
			String apellido = request.getParameter("apellidotxt").toString();
			boolean hab = false;
			if(request.getParameter("habchecbox") != null){
			hab = true;}
			String usuario = request.getParameter("usuariotxt").toString();
			String password = request.getParameter("passwordtxt").toString();
			Persona per = new Persona(nombre, apellido, dni, usuario, password);
			per.setHabilitado(hab);
			String Idtipo = ((String)request.getParameter("tipouser"));
			boolean adm;
			boolean enc;
			if(Idtipo.equals("1")){
				adm = false;
				enc = false;
			}
			else if (Idtipo.equals("2")){
				adm = true;
				enc = false;
			}
			else{
				adm = false;
				enc = true;
			}
			per.setAdmin(adm);
			per.setEncargado(enc);
			tiposs.addPersona(per);
			request.getRequestDispatcher("WEB-INF/lib/ABMPersona.jsp").forward(request, response);	
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('"+ e.getMessage()+"');");
		    out.println("location='login.html';");
		    out.println("</script>");
		}
	}

	/**
	 * @see HttpServlet#doPut(HttpServletRequest, HttpServletResponse)
	 */
	protected void doPut(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

	/**
	 * @see HttpServlet#doDelete(HttpServletRequest, HttpServletResponse)
	 */
	protected void doDelete(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
	}

}
