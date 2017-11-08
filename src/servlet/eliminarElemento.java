package servlet;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import entities.Elemento;
import controlers.CtrlABMCElemento;

/**
 * Servlet implementation class eliminarElemento
 */
@WebServlet("/eliminarElemento")
public class eliminarElemento extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public eliminarElemento() {
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
		// TODO Auto-generated method stub
		CtrlABMCElemento ctrl = new CtrlABMCElemento();
		Elemento elem = new Elemento();
		elem.setIdElemento(Integer.parseInt(request.getParameter("idElemento")));
		ctrl.deleteElemento(elem);
		request.getRequestDispatcher("WEB-INF/lib/ABMElemento.jsp").forward(request, response);
		
		
	}

}
