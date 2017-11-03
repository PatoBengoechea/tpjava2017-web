package servlet;

import java.io.IOException;
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
@WebServlet({ "/realizaAltaTipo", "/realizaaltaTipo" })
public class realizaAltaTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public realizaAltaTipo() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		try {
			TipoElemento tipo = new TipoElemento();
			CtrlABMCTipoElemento tiposs = new CtrlABMCTipoElemento();
			String desc = request.getParameter("desctxt").toString();
			String cant = request.getParameter("canttxt").toString();
			int cantidad = Integer.parseInt(cant);
			tipo.setDescTipo(desc);
			tipo.setCantdiasMax(cantidad);
			tiposs.Add(tipo);
			request.getRequestDispatcher("WEB-INF/lib/ABMTipoElemento.jsp").forward(request, response);
		} catch (Exception e) {
			e.printStackTrace();
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
