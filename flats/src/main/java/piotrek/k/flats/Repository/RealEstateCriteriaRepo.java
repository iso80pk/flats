package piotrek.k.flats.Repository;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.persistence.EntityManager;
import javax.persistence.criteria.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import piotrek.k.flats.Model.RealEstate;
import piotrek.k.flats.Model.RealEstate_;

@Repository
public class RealEstateCriteriaRepo {

	@Autowired
	private EntityManager entityManager;

	private CriteriaBuilder criteriaBuilder;
	private CriteriaQuery<RealEstate> criteriaQuery;
	private Root<RealEstate> root;

	@PostConstruct
	private void init() {
		criteriaBuilder = entityManager.getCriteriaBuilder();
		criteriaQuery = criteriaBuilder.createQuery(RealEstate.class);
		root = criteriaQuery.from(entityManager.getMetamodel().entity(RealEstate.class));
	}

	public List<RealEstate> getRealEstatesExcludingGivenIDList(List<Long> ids) {
		Predicate[] predicates = new Predicate[ids.size()];
		for (int i = 0; i < ids.size(); i++) {
			predicates[i] = andNotEqual(ids.get(i));
		}
		criteriaQuery.where(predicates);
		return entityManager.createQuery(criteriaQuery.select(root)).setMaxResults(20).getResultList();
	}

	private Predicate andNotEqual(Long andNotEqualID) {
		Predicate notEqual = criteriaBuilder.notEqual(root.get(RealEstate_.realEstate_id), andNotEqualID);
		return criteriaBuilder.and(notEqual);
	}
}
