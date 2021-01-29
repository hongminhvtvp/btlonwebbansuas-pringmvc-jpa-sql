package btl.spring.mvc.model;

import btl.spring.mvc.entities.ThanhToan;

public class ThanhToanInfo {

	private int idThanhToan;
	private String hinhThucTT;

	public ThanhToanInfo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public int getIdThanhToan() {
		return idThanhToan;
	}

	public void setIdThanhToan(int idThanhToan) {
		this.idThanhToan = idThanhToan;
	}

	public ThanhToanInfo(ThanhToan thanhToan) {
		this.hinhThucTT=thanhToan.getHinhThucTT();
	}
	
	public ThanhToanInfo(String kieuThanToan) {
		super();
		this.hinhThucTT = kieuThanToan;
	}

	public String getHinhThucTT() {
		return hinhThucTT;
	}

	public void setHinhThucTT(String kieuThanToan) {
		this.hinhThucTT = kieuThanToan;
	}
	
	
}
