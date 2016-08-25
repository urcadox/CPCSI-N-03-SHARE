package fr.imie;

import java.io.IOException;
import java.io.Writer;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CrowdFundingDetail
 */
@WebServlet("/CrowdFundingDetailView")
public class CrowdFundingDetailView extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CrowdFundingDetailView() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		//CrowdFundingDTO current = (CrowdFundingDTO) request.getSession().getAttribute("CrowdFundingCurrent");
		CrowdFundingDTO current = null;
		List<CrowdFundingDTO> CFList = (List<CrowdFundingDTO>) request.getSession().getAttribute("CrowdFundingList");
		for (CrowdFundingDTO crowdFundingDTO : CFList) {
			if (crowdFundingDTO.getName().compareTo(request.getParameter("name"))==0){
				current=crowdFundingDTO;
			}
		}
		
		
		Writer writer = response.getWriter();
		writer.append("<html>");
		writer.append("<body>");
		if(current==null){
			writer.append("crowdfunding non trouvé");
		}else{
			writer.append(current.getName()).append("</br>");
			writer.append(current.getGoal().toString()).append("</br>");
		}
		writer.append("</body>");
		writer.append("</html>");
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
