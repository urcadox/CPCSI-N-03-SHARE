package fr.imie;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateful;
import javax.enterprise.context.SessionScoped;
import javax.enterprise.inject.Alternative;
import javax.inject.Named;

import fr.imie.CrowdFundingDTO;
import java.io.Serializable;

@SessionScoped
@Alternative
@Stateful
@Mock
public class CrowdfundingServiceSession implements Serializable, ICrowdFundingService  {

	/**
	 * 
	 */
	private static final long serialVersionUID = -6030133929842166127L;
	
	List<CrowdFundingDTO> crowdFundings = new ArrayList<CrowdFundingDTO>();
	
	@Override
	public List<CrowdFundingDTO> getAllCrowdFunfingDTO() {
		return crowdFundings;
	}
	
	@PostConstruct
	private void init(){
		CrowdFundingDTO CF1 = new CrowdFundingDTO();
		CF1.setName("barmad");
		CF1.setGoal(100000);
		CF1.setAim(100000);
		CF1.setId(1);
		crowdFundings.add(CF1);
		CrowdFundingDTO CF2 = new CrowdFundingDTO();
		CF2.setName("BYOS");
		CF2.setGoal(1200000);
		CF2.setAim(198000);
		CF2.setId(2);
		crowdFundings.add(CF2);
		CrowdFundingDTO CF3 = new CrowdFundingDTO();
		CF3.setName("FCN");
		CF3.setGoal(35000000);
		CF3.setAim(32000000);
		CF3.setId(3);
		crowdFundings.add(CF3);
	}

}
