package btl.spring.mvc.daos.impl;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.transaction.Transactional;

import org.springframework.stereotype.Repository;

import btl.spring.mvc.daos.SanPhamDAO;
import btl.spring.mvc.entities.SanPham;
import btl.spring.mvc.model.SanPhamInfo;

@Repository
@Transactional
public class SanPhamDAOImpl implements SanPhamDAO {

	@PersistenceContext
	private EntityManager em;

	@Override
	public SanPham addSanPham(SanPhamInfo sanPhamInfo) {
		// TODO Auto-generated method stub
		String id = sanPhamInfo.getIdSanPham();
		SanPham sanPham = null;
		boolean isNew = false;
		if (id != null) {
			sanPham = this.findSanPhamById(id);
		}
		if (sanPham == null) {
			isNew = true;
			sanPham = new SanPham();
		}
		sanPham.setIdSanPham(sanPhamInfo.getIdSanPham());
		sanPham.setTenSanPham(sanPhamInfo.getTenSanPham());
		sanPham.setMoTa(sanPhamInfo.getMoTa());
		sanPham.setSoLuong(sanPhamInfo.getSoLuong());
		sanPham.setDonGia(sanPhamInfo.getDonGia());
		LocalDate ngaySX = LocalDate.parse(sanPhamInfo.getNgaySanXuat());
		sanPham.setNgaySanXuat(ngaySX);
		LocalDate hanSD = LocalDate.parse(sanPhamInfo.getHanSuDung());
		sanPham.setHanSuDung(hanSD);
		sanPham.setLoaiSanPham(sanPhamInfo.getLoaiSanPham());
		sanPham.setNhaSanXuat(sanPhamInfo.getNhaSanXuat());
		
		if (sanPhamInfo.getFileData() != null) {
			byte[] image = sanPhamInfo.getFileData().getBytes();
			if (image != null && image.length > 0) {
				sanPham.setImage(image);
			}
		}
		if (isNew) {
			em.persist(sanPham);
		}
		this.em.flush();
		return sanPham;
	}

	@Override
	public SanPham findSanPhamById(String strId) {
		// TODO Auto-generated method stub
		return em.find(SanPham.class, strId);
	}

	@Override
	public List<SanPham> listSanPhams() {
		// TODO Auto-generated method stub
		return em.createQuery("Select p from SanPham p", SanPham.class).getResultList();
	}

	@Override
	public void delete(String id) {
		// TODO Auto-generated method stub
		em.remove(em.find(SanPham.class, id));
	}

	@Override
	public void update(SanPhamInfo sanPhamInfo) {
		// TODO Auto-generated method stub
		SanPham sanPham=new SanPham();
		sanPham.setIdSanPham(sanPhamInfo.getIdSanPham());
		sanPham.setTenSanPham(sanPhamInfo.getTenSanPham());
		sanPham.setMoTa(sanPhamInfo.getMoTa());
		sanPham.setSoLuong(sanPhamInfo.getSoLuong());
		sanPham.setDonGia(sanPhamInfo.getDonGia());
		sanPham.setNgaySanXuat(LocalDate.parse(sanPhamInfo.getNgaySanXuat()));
		sanPham.setHanSuDung(LocalDate.parse(sanPhamInfo.getHanSuDung()));
		sanPham.setLoaiSanPham(sanPhamInfo.getLoaiSanPham());
		sanPham.setNhaSanXuat(sanPhamInfo.getNhaSanXuat());
		
		if (sanPhamInfo.getFileData() != null) {
			byte[] image = sanPhamInfo.getFileData().getBytes();
			if (image != null && image.length > 0) {
				sanPham.setImage(image);
			}
		}
		em.merge(sanPham);
	}
	
}
