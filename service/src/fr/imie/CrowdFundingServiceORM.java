package fr.imie;

import java.sql.SQLException;
import java.util.List;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.enterprise.context.Dependent;
import javax.enterprise.context.RequestScoped;
import javax.enterprise.inject.Default;
import javax.inject.Inject;
import javax.persistence.EntityManager;

@Dependent
@Default
@Stateless
@Regular
public class CrowdFundingServiceORM implements ICrowdFundingService {

	private @Inject EntityManager entityManager;

	@Override
	public List<CrowdFundingDTO> getAllCrowdFunfingDTO() {

		return entityManager.createNamedQuery("CrowdFundingDTO.findAll").getResultList();

	}

}
