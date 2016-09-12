package fr.imie.TPServlet;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebInitParam;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class crowdFoundingHandle
 */
@WebServlet(
		urlPatterns = "/CrowdFundingHandle",
		initParams = @WebInitParam(name = "discount", value = "40")
)
public class CrowdFundingHandle extends HttpServlet {

	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrowdFundingHandle() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		Integer Goal = (Integer) request.getAttribute("CrowdFundingGoal");
		String discountParam = this.getServletConfig().getInitParameter("discount");
		Integer discountParamValue = Integer.parseInt(discountParam);
		Integer Donations = Goal*discountParamValue/100;
		Integer Aim = Goal - Donations;
		request.setAttribute("CrowdFundingAim", Aim);
		request.getRequestDispatcher("/CrowdFundingView").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse
	 *      response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
