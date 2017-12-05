package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import controlers.CtrlABMCPersona;
import entities.Persona;

/**
 * Servlet implementation class realizaModiPersona
 */
@WebServlet("/realizaModiPersona")
public class realizaModiPersona extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public realizaModiPersona() {
        super();
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		CtrlABMCPersona tiposs = new CtrlABMCPersona();
		String ids = request.getParameter("idh").toString();
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
		int id = Integer.parseInt(ids);
		per.setIdPersona(id);
		per.setHabilitado(hab);
		try {
			tiposs.updatePersona(per);
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('"+ e.getMessage()+"');");
		    out.println("location='login.html';");
		    out.println("</script>");
		}
		HttpSession sesion = request.getSession();
		Persona per2 = (Persona)sesion.getAttribute("user");
		if(per2.isAdmin()){
		request.getRequestDispatcher("WEB-INF/lib/ABMPersona.jsp").forward(request, response);
		}
		else{
		request.getRequestDispatcher("WEB-INF/lib/MenuUser.jsp").forward(request, response);	
		}
		}

}
