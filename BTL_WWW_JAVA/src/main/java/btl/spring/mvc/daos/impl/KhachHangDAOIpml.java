package btl.spring.mvc.daos.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import btl.spring.mvc.daos.KhachHangDAO;
import btl.spring.mvc.entities.KhachHang;
import btl.spring.mvc.model.KhachHangInfo;

@Repository
@Transactional
public class KhachHangDAOIpml implements KhachHangDAO {

	@PersistenceContext
	private EntityManager em;
	
	@Override
	public KhachHang findKhachHangById(String id) {
		// TODO Auto-generated method stub
		return em.createQuery("Select p from KhachHang p where p.idKhachHang= :id", KhachHang.class)
				.setParameter("id", id).getSingleResult();
	}

	@Override
	public KhachHang addKhachHang(KhachHangInfo khachHangInfo) {
		// TODO Auto-generated method stub
		KhachHang khachHang = new KhachHang();
		khachHang.setNameKhachHang(khachHangInfo.getNameKhachHang());
		khachHang.setDiaChi(khachHangInfo.getDiaChi());
		khachHang.setSdt(khachHangInfo.getSdt());
		khachHang.setEmail(khachHangInfo.getEmail());
		khachHang.setGioiTinh(khachHangInfo.getGioiTinh());
		khachHang.setTaiKhoan(khachHangInfo.getTaiKhoan());
		khachHang.setNgaySinh(LocalDate.parse(khachHangInfo.getNgaySinh()));
		em.persist(khachHang);
		
		em.flush();
		
		return khachHang;
	}

	@Override
	public List<KhachHang> listKhachHangs() {
		// TODO Auto-generated method stub
		return em.createQuery("Select p from KhachHang p", KhachHang.class).getResultList();
	}

}
