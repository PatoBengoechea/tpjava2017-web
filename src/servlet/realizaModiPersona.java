package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

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
		boolean hab = true;
		String usuario = request.getParameter("usuariotxt").toString();
		String password = request.getParameter("passwordtxt").toString();
		Persona per = new Persona(nombre, apellido, dni, usuario, password);
		int id = Integer.parseInt(ids);
		per.setIdPersona(id);
		per.setHabilitado(hab);
		tiposs.updatePersona(per);
		request.getRequestDispatcher("WEB-INF/lib/ABMPersona.jsp").forward(request, response);
	}

}
