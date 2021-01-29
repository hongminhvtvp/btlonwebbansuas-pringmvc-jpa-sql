package btl.spring.mvc.daos;

import java.util.List;

import btl.spring.mvc.entities.ThanhToan;
import btl.spring.mvc.model.ThanhToanInfo;

public interface ThanhToanDAO {

	public ThanhToan addThanhToan(ThanhToanInfo thanhToanInfo);

	public List<ThanhToan> listThanhToans();
	
	public void update(ThanhToanInfo thanhToanInfo);
	
	public void delete(int id);
}
