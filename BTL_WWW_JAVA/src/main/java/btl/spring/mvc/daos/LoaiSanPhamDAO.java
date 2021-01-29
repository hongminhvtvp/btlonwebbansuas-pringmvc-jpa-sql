package btl.spring.mvc.daos;

import java.util.List;

import btl.spring.mvc.entities.LoaiSanPham;
import btl.spring.mvc.model.LoaiSanPhamInfo;

public interface LoaiSanPhamDAO {

	public LoaiSanPham addLoaiSanPham(LoaiSanPhamInfo loaiSanPhamInfo);

	public List<LoaiSanPham> listLoaiSanPham();

	public void update(LoaiSanPhamInfo loaiSanPhamInfo);

	public void delete(int id);
}
