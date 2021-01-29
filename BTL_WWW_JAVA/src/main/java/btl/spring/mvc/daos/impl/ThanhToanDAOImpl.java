package btl.spring.mvc.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import btl.spring.mvc.daos.ThanhToanDAO;
import btl.spring.mvc.entities.ThanhToan;
import btl.spring.mvc.model.ThanhToanInfo;

@Repository
@Transactional
public class ThanhToanDAOImpl implements ThanhToanDAO{

	@PersistenceContext
	private EntityManager em;

	@Override
	public ThanhToan addThanhToan(ThanhToanInfo thanhToanInfo) {
		// TODO Auto-generated method stub
		ThanhToan thanhToan=new ThanhToan(thanhToanInfo.getHinhThucTT());
		em.persist(thanhToan);
		return thanhToan;
	}

	@Override
	public List<ThanhToan> listThanhToans() {
		// TODO Auto-generated method stub
		return em.createQuery("Select p from ThanhToan p", ThanhToan.class).getResultList();
	}

	@Override
	public void update(ThanhToanInfo thanhToanInfo) {
		// TODO Auto-generated method stub
		ThanhToan thanhToan=new ThanhToan();
		thanhToan.setIdThanhToan(thanhToanInfo.getIdThanhToan());
		thanhToan.setHinhThucTT(thanhToanInfo.getHinhThucTT());
		em.merge(thanhToan);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(ThanhToan.class, id));
	}

	
}
