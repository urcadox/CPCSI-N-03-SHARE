package fr.imie;

import java.sql.SQLException;
import java.util.List;

public interface ICrowdFundingDAO {
	public List<CrowdFundingDTO> getCrowdFundings() throws SQLException;

	CrowdFundingDTO addCrowdFundingDTO(CrowdFundingDTO crowdFundingDTO) throws SQLException ;
}
