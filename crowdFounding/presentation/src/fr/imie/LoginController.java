package fr.imie;

import java.io.IOException;
import java.util.List;

import javax.ejb.EJB;
import javax.enterprise.context.SessionScoped;
import javax.inject.Inject;
import javax.inject.Named;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import fr.imie.IUserService;

/**
 * Servlet implementation class LoginController
 */
@WebServlet("/LoginController")
public class LoginController extends HttpServlet {
	private static final long serialVersionUID = 1L;
	
	@EJB(beanName="UserService") private IUserService userService;
	@Inject private IUserConnectedManagement userConnectedManagement;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LoginController() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		request.getRequestDispatcher("/WEB-INF/Login.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		String login = request.getParameter("login");
		String password = request.getParameter("passw");
		//List<UserDTO> userDTOs = (List<UserDTO>)request.getSession().getAttribute("UserList");
		List<UserEntity> userDTOs = userService.getAllUsers();
		Boolean authentificationSucced = false;
		for (UserEntity userDTO : userDTOs) {
			if(userDTO.getLogin().compareTo(login)==0 && userDTO.getPassw().compareTo(password)==0){
				authentificationSucced=true;
				userConnectedManagement.setUserDTO(userDTO);
				
			}
		}
		if(authentificationSucced==false){
			doGet(request, response);
		}else{
			String oldUrl = userConnectedManagement.getAimUrl();
			response.sendRedirect(oldUrl);
		}
	}

}
