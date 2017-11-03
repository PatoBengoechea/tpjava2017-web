package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMCTipoElemento;
import entities.TipoElemento;

/**
 * Servlet implementation class realizaModiTipo
 */
@WebServlet("/realizaModiTipo")
public class realizaModiTipo extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public realizaModiTipo() {
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
		TipoElemento tipo = new TipoElemento();
		CtrlABMCTipoElemento tiposs = new CtrlABMCTipoElemento();
		String id = request.getParameter("idhi").toString();
		String desc = request.getParameter("desctxt").toString();
		String cant = request.getParameter("canttxt").toString();
		int cantidad = Integer.parseInt(cant);
		int idTipo = Integer.parseInt(id);
		tipo.setIdTipo(idTipo);
		tipo.setDescTipo(desc);
		tipo.setCantdiasMax(cantidad);
		tiposs.editar(tipo);
		request.getRequestDispatcher("WEB-INF/lib/ABMTipoElemento.jsp").forward(request, response);
	}

}
