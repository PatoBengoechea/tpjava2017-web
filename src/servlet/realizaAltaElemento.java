package servlet;

import java.io.IOException;
import java.io.PrintWriter;

import javax.print.attribute.standard.DocumentName;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMCElemento;
import controlers.CtrlABMCTipoElemento;
import entities.Elemento;
import entities.TipoElemento;

/**
 * Servlet implementation class realizaAltaElemento
 */
@WebServlet("/realizaAltaElemento")
public class realizaAltaElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public realizaAltaElemento() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			Elemento tipo = new Elemento();
			CtrlABMCElemento tiposs = new CtrlABMCElemento();
			CtrlABMCTipoElemento tipos2 = new CtrlABMCTipoElemento();
			String ubi = request.getParameter("ubictxt").toString();
			String desc = request.getParameter("desctxt").toString();
			String cap = request.getParameter("capactxt").toString();
			String Idtipo = ((String)request.getParameter("tipoElemento"));
			int capacidad = Integer.parseInt(cap);
			tipo.setDescripcion(desc);
			tipo.setUbicacion(ubi);
			tipo.setCapacidad(capacidad);
			TipoElemento tipito = new TipoElemento();
			TipoElemento tipoElemento2 = new TipoElemento();
			tipito.setIdTipo(Integer.parseInt(Idtipo));
			tipoElemento2 = tipos2.buscarTipoElemento(tipito);
			tipo.setTipo(tipoElemento2);
			tiposs.Add(tipo);
			request.getRequestDispatcher("WEB-INF/lib/ABMElemento.jsp").forward(request, response);			
		} catch (Exception e) {
			PrintWriter out = response.getWriter();
			out.println("<script type=\"text/javascript\">");
		    out.println("alert('"+ e.getMessage()+"');");
		    out.println("location='login.html';");
		    out.println("</script>");
		}
	}

}
