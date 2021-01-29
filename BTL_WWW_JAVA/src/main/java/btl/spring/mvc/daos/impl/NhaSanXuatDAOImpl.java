package btl.spring.mvc.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import btl.spring.mvc.daos.NhaSanXuatDAO;
import btl.spring.mvc.entities.NhaSanXuat;
import btl.spring.mvc.model.NhaSanXuatInfo;

@Repository
@Transactional
public class NhaSanXuatDAOImpl implements NhaSanXuatDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public NhaSanXuat addNhaSanXuat(NhaSanXuatInfo nhaSanXuatInfo) {
		// TODO Auto-generated method stub
		NhaSanXuat nhaSanXuat=new NhaSanXuat(nhaSanXuatInfo.getTenNhaSanXuat());
		em.persist(nhaSanXuat);
		return nhaSanXuat;
	}

	@Override
	public List<NhaSanXuat> listNhaSanXuats() {
		// TODO Auto-generated method stub
		return em.createQuery("Select p from NhaSanXuat p", NhaSanXuat.class).getResultList();
	}

	@Override
	public void update(NhaSanXuatInfo nhaSanXuatInfo) {
		// TODO Auto-generated method stub
		NhaSanXuat nhaSanXuat=new NhaSanXuat();
		nhaSanXuat.setIdNhaSanXuat(nhaSanXuatInfo.getIdNhaSanXuat());
		nhaSanXuat.setTenNhaSanXuat(nhaSanXuatInfo.getTenNhaSanXuat());
		em.merge(nhaSanXuat);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(NhaSanXuat.class, id));
	}
	
}
