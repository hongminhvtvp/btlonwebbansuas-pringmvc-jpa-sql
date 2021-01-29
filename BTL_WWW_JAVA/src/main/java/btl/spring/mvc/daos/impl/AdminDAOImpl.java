package btl.spring.mvc.daos.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import btl.spring.mvc.daos.AdminDAO;
import btl.spring.mvc.entities.Admin;

@Repository
@Transactional
public class AdminDAOImpl implements AdminDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public void addAdmin(Admin admin) {
		// TODO Auto-generated method stub
		em.persist(admin);
	}

}
