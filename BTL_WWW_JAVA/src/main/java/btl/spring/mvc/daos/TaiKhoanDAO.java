package btl.spring.mvc.daos;

import btl.spring.mvc.entities.TaiKhoan;

public interface TaiKhoanDAO {

	public TaiKhoan findTaiKhoanByUsername(String username);
	
}
