package fr.imie;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.annotation.WebListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

/**
 * Application Lifecycle Listener implementation class SessionLoadingListener
 *
 */
@WebListener
public class SessionLoadingListener implements HttpSessionListener {

	/**
	 * Default constructor.
	 */
	public SessionLoadingListener() {
		// TODO Auto-generated constructor stub
	}

	/**
	 * @see HttpSessionListener#sessionCreated(HttpSessionEvent)
	 */
	public void sessionCreated(HttpSessionEvent sessionEvent) {
		// début commentaire archi : ce bloc devrait être une classe
		// métier/business et aucun objet ne devrait être en session
		List<CrowdFundingDTO> CFList = new ArrayList<CrowdFundingDTO>();
		CrowdFundingDTO CF1 = new CrowdFundingDTO();
		CF1.setName("barmad");
		CF1.setGoal(100000);
		CF1.setAim(100000);
		CFList.add(CF1);
		CrowdFundingDTO CF2 = new CrowdFundingDTO();
		CF2.setName("BYOS");
		CF2.setGoal(1200000);
		CF2.setAim(198000);
		CFList.add(CF2);
		CrowdFundingDTO CF3 = new CrowdFundingDTO();
		CF3.setName("FCN");
		CF3.setGoal(35000000);
		CF3.setAim(32000000);
		CFList.add(CF3);
		sessionEvent.getSession().setAttribute("CrowdFundingList", CFList);
		
		List<UserDTO> userDTOs = new ArrayList<UserDTO>();
		UserDTO userDTO1 = new UserDTO();
		userDTO1.setLogin("admin");
		userDTO1.setPassw("admin");
		userDTOs.add(userDTO1);
		UserDTO userDTO2 = new UserDTO();
		userDTO2.setLogin("raymond");
		userDTO2.setPassw("1234");
		userDTOs.add(userDTO2);
		sessionEvent.getSession().setAttribute("UserList", userDTOs);
		
		
		// fin commentaire archi
	}

	/**
	 * @see HttpSessionListener#sessionDestroyed(HttpSessionEvent)
	 */
	public void sessionDestroyed(HttpSessionEvent arg0) {
		// TODO Auto-generated method stub
	}

}
