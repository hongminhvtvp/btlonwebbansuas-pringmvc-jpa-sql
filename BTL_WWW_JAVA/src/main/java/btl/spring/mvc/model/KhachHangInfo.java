package btl.spring.mvc.model;

import btl.spring.mvc.entities.TaiKhoan;

public class KhachHangInfo {

	public final static String ROLE_KHACHHANG = "KHACHHANG";
	public final static String ROLE_ADMIN = "ADMIN";

	private String nameKhachHang;
	private String diaChi;
	private String sdt;
	private String gioiTinh;
	private String email;
	private String ngaySinh;

	private TaiKhoan taiKhoan;

	private TaiKhoanInfo taiKhoanInfo;

	public KhachHangInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public KhachHangInfo(String nameKhachHang, String diaChi, String sdt, String gioiTinh, String email,
			String ngaySinh) {
		super();
		this.nameKhachHang = nameKhachHang;
		this.diaChi = diaChi;
		this.sdt = sdt;
		this.gioiTinh = gioiTinh;
		this.email = email;
		this.ngaySinh = ngaySinh;
	}

	public TaiKhoanInfo getTaiKhoanInfo() {
		return taiKhoanInfo;
	}

	public void setTaiKhoanInfo(TaiKhoanInfo taiKhoanInfo) {
		this.taiKhoanInfo = taiKhoanInfo;
	}

	public String getNameKhachHang() {
		return nameKhachHang;
	}

	public void setNameKhachHang(String nameKhachHang) {
		this.nameKhachHang = nameKhachHang;
	}

	public String getDiaChi() {
		return diaChi;
	}

	public void setDiaChi(String diaChi) {
		this.diaChi = diaChi;
	}

	public String getSdt() {
		return sdt;
	}

	public void setSdt(String sdt) {
		this.sdt = sdt;
	}

	public String getGioiTinh() {
		return gioiTinh;
	}

	public void setGioiTinh(String gioiTinh) {
		this.gioiTinh = gioiTinh;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getNgaySinh() {
		return ngaySinh;
	}

	public void setNgaySinh(String ngaySinh) {
		this.ngaySinh = ngaySinh;
	}

	public TaiKhoan getTaiKhoan() {
		return taiKhoan;
	}

	public void setTaiKhoan(TaiKhoan taiKhoan) {
		this.taiKhoan = taiKhoan;
	}

	@Override
	public String toString() {
		return "KhachHangInfo [nameKhachHang=" + nameKhachHang + ", diaChi=" + diaChi + ", sdt=" + sdt + ", gioiTinh="
				+ gioiTinh + ", email=" + email + ", ngaySinh=" + ngaySinh + ", taiKhoan=" + taiKhoan + "]";
	}

}
