package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import controlers.CtrlABMCElemento;
import entities.Elemento;

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
		CtrlABMCElemento ctrl = new CtrlABMCElemento();
		el.setIdElemento(Integer.parseInt((String)request.getAttribute("idehi")));
		el.setUbicacion(request.getAttribute("ubicaciontxt").toString());
		el.setCapacidad(Integer.parseInt(request.getAttribute("capacidadtxt").toString()));
		el.setDescripcion(request.getAttribute("descripciontxt").toString());
		el.getTipo().setIdTipo(Integer.parseInt(request.getAttribute("tipoElemento").toString()));
		ctrl.update(el);
		request.getRequestDispatcher("WEB-INF/lib/ABMElemento.jsp").forward(request, response);	
	}
}
