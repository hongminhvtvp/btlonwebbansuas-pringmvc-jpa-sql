package btl.spring.mvc.daos.impl;

import java.time.LocalDateTime;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import btl.spring.mvc.daos.DonHangDAO;
import btl.spring.mvc.entities.DonHang;
import btl.spring.mvc.entities.SanPham;
import btl.spring.mvc.model.DonHangInfo;

@Repository
@Transactional
public class DonHangDAOImpl implements DonHangDAO{

	@PersistenceContext
	private EntityManager em;
	
	DonHang donHang;
	
	@Override
	public DonHang addDonHang(DonHangInfo donHangInfo) {
		// TODO Auto-generated method stub
		donHang.setThoiGian(LocalDateTime.now());
		donHang.setDiaChiGiao(donHangInfo.getDiaChiGiao());
		donHang.setTongTien(donHangInfo.getTongTien());
		donHang.setKhachHang(donHangInfo.getKhachHang());
		donHang.setThanhToan(donHangInfo.getThanhToan());
		
		System.out.println("Don hang:"+donHang);
		
		em.persist(donHang);
		
		em.flush(); 
		donHang=null;
		return donHang;
	}

	@Override
	public List<DonHang> listDonHangs() {
		// TODO Auto-generated method stub
		return em.createQuery("Select p from DonHang p", DonHang.class).getResultList();
	}

	@Override
	public void buy(SanPham sanPham, int soLuong, double donGia, double thanhTien) {
		// TODO Auto-generated method stub
		if(donHang==null) {
			donHang=new DonHang();
		}
		donHang.addPurchases(sanPham, soLuong, donGia, thanhTien);
	}

	@Override
	public DonHang getDonHang() {
		// TODO Auto-generated method stub
		return donHang;
	}

	
}
