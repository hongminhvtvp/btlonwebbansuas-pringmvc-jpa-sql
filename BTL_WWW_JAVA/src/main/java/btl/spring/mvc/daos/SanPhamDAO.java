package btl.spring.mvc.daos;

import java.util.List;

import btl.spring.mvc.entities.SanPham;
import btl.spring.mvc.model.SanPhamInfo;

public interface SanPhamDAO {

	public SanPham addSanPham(SanPhamInfo sanPhamInfo);

	public SanPham findSanPhamById(String strId);

	public List<SanPham> listSanPhams();
	
	public void update(SanPhamInfo phamInfo);

	public void delete (String id);
}
