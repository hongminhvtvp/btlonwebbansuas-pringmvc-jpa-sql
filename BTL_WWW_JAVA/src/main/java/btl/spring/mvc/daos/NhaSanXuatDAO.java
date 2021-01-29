package btl.spring.mvc.daos;

import java.util.List;

import btl.spring.mvc.entities.NhaSanXuat;
import btl.spring.mvc.model.NhaSanXuatInfo;

public interface NhaSanXuatDAO {

	public NhaSanXuat addNhaSanXuat(NhaSanXuatInfo nhaSanXuatInfo);

	public List<NhaSanXuat> listNhaSanXuats();
	
	public void update(NhaSanXuatInfo nhaSanXuatInfo);
	
	public void delete(int id);
}
