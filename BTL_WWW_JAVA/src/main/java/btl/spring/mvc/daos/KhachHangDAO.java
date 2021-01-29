package btl.spring.mvc.daos;

import java.util.List;

import btl.spring.mvc.entities.KhachHang;
import btl.spring.mvc.model.KhachHangInfo;

public interface KhachHangDAO {

	public KhachHang findKhachHangById(String id);

	public KhachHang addKhachHang(KhachHangInfo khachHangInfo);

	public List<KhachHang> listKhachHangs();
}
