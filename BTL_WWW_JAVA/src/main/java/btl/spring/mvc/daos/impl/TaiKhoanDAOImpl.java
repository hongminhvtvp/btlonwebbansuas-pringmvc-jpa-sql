package btl.spring.mvc.daos.impl;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import btl.spring.mvc.daos.TaiKhoanDAO;
import btl.spring.mvc.entities.TaiKhoan;

@Repository
@Transactional
public class TaiKhoanDAOImpl implements TaiKhoanDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public TaiKhoan findTaiKhoanByUsername(String username) {
		// TODO Auto-generated method stub
		return em.find(TaiKhoan.class, username);
	}

}
