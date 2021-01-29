package btl.spring.mvc.daos.impl;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import btl.spring.mvc.daos.LoaiSanPhamDAO;
import btl.spring.mvc.entities.LoaiSanPham;
import btl.spring.mvc.model.LoaiSanPhamInfo;

@Repository
@Transactional
public class LoaiSanPhamDAOImpl implements LoaiSanPhamDAO{

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public LoaiSanPham addLoaiSanPham(LoaiSanPhamInfo loaiSanPhamInfo) {
		// TODO Auto-generated method stub
		LoaiSanPham loaiSanPham=new LoaiSanPham(loaiSanPhamInfo.getTenLoaiSanPham());
		em.persist(loaiSanPham);
		return loaiSanPham;
	}

	@Override
	public List<LoaiSanPham> listLoaiSanPham() {
		// TODO Auto-generated method stub
		return em.createQuery("Select p from LoaiSanPham p", LoaiSanPham.class).getResultList();
	}

	@Override
	public void update(LoaiSanPhamInfo loaiSanPhamInfo) {
		// TODO Auto-generated method stub
		LoaiSanPham loaiSanPham=new LoaiSanPham();
		loaiSanPham.setIdLoaiSanPham(loaiSanPhamInfo.getIdLoaiSanPham());
		loaiSanPham.setTenLoaiSanPham(loaiSanPhamInfo.getTenLoaiSanPham());
		em.merge(loaiSanPham);
	}

	@Override
	public void delete(int id) {
		// TODO Auto-generated method stub
		em.remove(em.find(LoaiSanPham.class, id));
	}
	
	
}
