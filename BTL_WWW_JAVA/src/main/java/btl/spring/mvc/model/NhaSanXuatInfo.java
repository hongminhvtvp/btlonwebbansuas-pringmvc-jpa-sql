package btl.spring.mvc.model;

public class NhaSanXuatInfo {

	private int idNhaSanXuat;
	private String tenNhaSanXuat;

	public NhaSanXuatInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdNhaSanXuat() {
		return idNhaSanXuat;
	}

	public void setIdNhaSanXuat(int idNhaSanXuat) {
		this.idNhaSanXuat = idNhaSanXuat;
	}

	public NhaSanXuatInfo(String tenNhaSanXuat) {
		super();
		this.tenNhaSanXuat = tenNhaSanXuat;
	}

	public String getTenNhaSanXuat() {
		return tenNhaSanXuat;
	}

	public void setTenNhaSanXuat(String tenNhaSanXuat) {
		this.tenNhaSanXuat = tenNhaSanXuat;
	}

}
