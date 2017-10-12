package com.jpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import com.jpa.entity.Address;

@Repository
@Transactional
public class AddressDAO implements IAddressDAO {
	
	@PersistenceContext
	private EntityManager entityManager;

	@SuppressWarnings("unchecked")
	@Override
	public List<Address> getAllAddresses() {
		 return entityManager.createQuery("from Address order by id").getResultList();
	}

	@Override
	public Address getAddress(int id) {
		return entityManager.find(Address.class, Integer.valueOf(id));
	}

	@Override
	public void addAddress(Address address) {
		entityManager.persist(address);
	}

	@Override
	public boolean existsAddress(String zipCode, String settlement, String publicplace, String publicplaceType,
			String houseNumber, String addressOtherField) {
		boolean ppT = publicplaceType != null && !"".equals(publicplaceType);
		boolean hNum = houseNumber != null && !"".equals(houseNumber);
		boolean aOther = addressOtherField != null && !"".equals(addressOtherField);
		StringBuilder hqlBuilder = new StringBuilder("from Address where ")
				.append("zipCode = ? and ")
				.append("settlement = ? and ")
				.append("publicPlace = ?");
		if (ppT) {
			hqlBuilder.append(" and publicPlacetype = ?");
		}
		if (hNum) {
			hqlBuilder.append(" and houseNumber = ?");
		}
		if (aOther) {
			hqlBuilder.append(" and addressOtherField = ?");
		}
		int paramCounter = 1;
		Query query = entityManager.createQuery(hqlBuilder.toString())
			.setParameter(paramCounter++,  zipCode)
			.setParameter(paramCounter++, settlement)
			.setParameter(paramCounter++,  publicplace);
		if (ppT) {
			query.setParameter(paramCounter++, publicplaceType);
		}
		if (hNum) {
			query.setParameter(paramCounter++, houseNumber);
		}
		if (aOther) {
			query.setParameter(paramCounter++, addressOtherField);
		}
		return !query.getResultList().isEmpty();
	}

}
