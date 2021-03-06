package fr.imie;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;


@Dependent
@Default
@Stateless
@Regular
public class CrowdFundingService implements ICrowdFundingService {

	private @Inject ICrowdFundingDAO crowdFundingDAO;
	
	@Override
	public List<CrowdFundingEntity> getAllCrowdFunfingDTO() {
		try {
			return crowdFundingDAO.getCrowdFundings();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
