package fr.imie;

import java.sql.SQLException;
import java.util.List;

import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;

@Regular
@RequestScoped
public class CrowdFundingService implements ICrowdFundingService {

	private @Inject ICrowdFundingDAO crowdFundingDAO;
	
	@Override
	public List<CrowdFundingDTO> getAllCrowdFunfingDTO() {
		try {
			return crowdFundingDAO.getCrowdFundings();
		} catch (SQLException e) {
			throw new RuntimeException(e.getMessage());
		}
	}

}
