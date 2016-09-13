package fr.imie;

import java.util.List;

import javax.ejb.Local;

import fr.imie.CrowdFundingDTO;

@Local
public interface ICrowdFundingService {
	public List<CrowdFundingDTO> getAllCrowdFunfingDTO();
	
}
