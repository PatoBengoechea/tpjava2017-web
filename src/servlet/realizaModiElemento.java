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
		Elemento el = new Elemento();
		CtrlABMCElemento ctrl = new CtrlABMCElemento();
		el.setIdElemento(Integer.parseInt(request.getAttribute("ide").toString()));
		el.setCapacidad(Integer.parseInt(request.getAttribute("capacidadtxt").toString()));
		el.setCapacidad(Integer.parseInt(request.getAttribute("capacidadtxt").toString()));
		el.getTipo().setIdTipo(Integer.parseInt(request.getAttribute("idTipo").toString()));
		ctrl.update(el);
		request.getRequestDispatcher("WEB-INF/lib/ABMElemento.jsp").forward(request, response);
		
		
	}

}
