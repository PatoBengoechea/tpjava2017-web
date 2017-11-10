package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMCElemento;
import entities.Elemento;
import entities.TipoElemento;

/**
 * Servlet implementation class realizaModiElemento
 */
@WebServlet("/realizaModiElemento")
public class realizaModiElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public realizaModiElemento() {
        super();
        // TODO Auto-generated constructor stub
    }


	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		Elemento el = new Elemento();
		TipoElemento te = new TipoElemento();
		CtrlABMCElemento ctrl = new CtrlABMCElemento();
		el.setIdElemento(Integer.parseInt(request.getParameter("idehi").toString()));
		el.setUbicacion(request.getParameter("ubicaciontxt").toString());
		el.setCapacidad(Integer.parseInt(request.getParameter("capacidadtxt").toString()));
		el.setDescripcion(request.getParameter("descripciontxt").toString());
		int idtipo = Integer.parseInt((request.getParameter("tipElem").toString()));
		te.setIdTipo(idtipo);
		el.setTipo(te);
		ctrl.update(el);
		request.getRequestDispatcher("WEB-INF/lib/ABMElemento.jsp").forward(request, response);	
	}
}
