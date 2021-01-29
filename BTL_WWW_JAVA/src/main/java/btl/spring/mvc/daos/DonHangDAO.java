package btl.spring.mvc.daos;

import java.util.List;

import btl.spring.mvc.entities.DonHang;
import btl.spring.mvc.entities.SanPham;
import btl.spring.mvc.model.DonHangInfo;

public interface DonHangDAO {

	public DonHang addDonHang(DonHangInfo donHangInfo);

	public List<DonHang> listDonHangs();
	
	public void buy(SanPham sanPham,int soLuong,double donGia,double thanhTien);
	
	public DonHang getDonHang();
}
