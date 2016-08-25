package fr.imie;

import java.io.IOException;
import java.io.Writer;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class crouwndFoundingView
 */
@WebServlet("/CrowdFundingView")
public class CrowdFundingView extends HttpServlet {
	private static final long serialVersionUID = 1L;

	/**
	 * @see HttpServlet#HttpServlet()
	 */
	public CrowdFundingView() {
		super();
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		Writer writer = response.getWriter();
		
		writer.append(request.getAttribute("CrowdFundingName").toString()).append(" / ");
		writer.append(request.getAttribute("CrowdFundingGoal").toString()).append(" / ");
		Integer progress = (Integer)request.getAttribute("CrowdFundingGoal") - (Integer)request.getAttribute("CrowdFundingAim");
		writer.append("<meter min=\"0\" max=\""+request.getAttribute("CrowdFundingGoal").toString()+"\" value=\""+progress+"\")></meter>");

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
