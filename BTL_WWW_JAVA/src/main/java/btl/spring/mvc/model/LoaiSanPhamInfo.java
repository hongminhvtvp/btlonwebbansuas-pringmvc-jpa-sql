package btl.spring.mvc.model;

import btl.spring.mvc.entities.LoaiSanPham;

public class LoaiSanPhamInfo {

	private int idLoaiSanPham;

	private String tenLoaiSanPham;

	public LoaiSanPhamInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public LoaiSanPhamInfo(LoaiSanPham loaiSanPham) {
		super();
		this.tenLoaiSanPham = loaiSanPham.getTenLoaiSanPham();
	}

	public LoaiSanPhamInfo(String tenLoaiSanPham) {
		super();
		this.tenLoaiSanPham = tenLoaiSanPham;
	}

	public int getIdLoaiSanPham() {
		return idLoaiSanPham;
	}

	public void setIdLoaiSanPham(int idLoaiSanPham) {
		this.idLoaiSanPham = idLoaiSanPham;
	}

	public String getTenLoaiSanPham() {
		return tenLoaiSanPham;
	}

	public void setTenLoaiSanPham(String tenLoaiSanPham) {
		this.tenLoaiSanPham = tenLoaiSanPham;
	}

}
