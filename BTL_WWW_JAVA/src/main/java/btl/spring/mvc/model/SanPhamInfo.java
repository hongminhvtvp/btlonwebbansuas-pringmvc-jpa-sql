package btl.spring.mvc.model;

import org.springframework.web.multipart.commons.CommonsMultipartFile;

import btl.spring.mvc.entities.LoaiSanPham;
import btl.spring.mvc.entities.NhaSanXuat;
import btl.spring.mvc.entities.SanPham;

public class SanPhamInfo {

	private String idSanPham;
	private String tenSanPham;
	private String moTa;
	private int soLuong;
	private double donGia;
	private String ngaySanXuat;
	private String hanSuDung;

	private boolean newSanPham = false;

	private CommonsMultipartFile fileData;

	private NhaSanXuat nhaSanXuat;
	private LoaiSanPham loaiSanPham;

	public SanPhamInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SanPhamInfo(SanPham sanPham) {
		this.idSanPham = sanPham.getIdSanPham();
		this.tenSanPham = sanPham.getTenSanPham();
		this.moTa = sanPham.getMoTa();
		this.soLuong = sanPham.getSoLuong();
		this.donGia = sanPham.getDonGia();
		this.ngaySanXuat = sanPham.getNgaySanXuat().toString();
		this.hanSuDung = sanPham.getHanSuDung().toString();
	}

	public SanPhamInfo(String idSanPham, String tenSanPham, String moTa, int soLuong, double donGia, String ngaySanXuat,
			String hanSuDung) {
		super();
		this.idSanPham = idSanPham;
		this.tenSanPham = tenSanPham;
		this.moTa = moTa;
		this.soLuong = soLuong;
		this.donGia = donGia;
		this.ngaySanXuat = ngaySanXuat;
		this.hanSuDung = hanSuDung;
	}

	public boolean isNewSanPham() {
		return newSanPham;
	}

	public void setNewSanPham(boolean newSanPhan) {
		this.newSanPham = newSanPhan;
	}

	public NhaSanXuat getNhaSanXuat() {
		return nhaSanXuat;
	}

	public void setNhaSanXuat(NhaSanXuat nhaSanXuat) {
		this.nhaSanXuat = nhaSanXuat;
	}

	public LoaiSanPham getLoaiSanPham() {
		return loaiSanPham;
	}

	public void setLoaiSanPham(LoaiSanPham loaiSanPham) {
		this.loaiSanPham = loaiSanPham;
	}

	public String getIdSanPham() {
		return idSanPham;
	}

	public void setIdSanPham(String idSanPham) {
		this.idSanPham = idSanPham;
	}

	public String getTenSanPham() {
		return tenSanPham;
	}

	public void setTenSanPham(String tenSanPham) {
		this.tenSanPham = tenSanPham;
	}

	public String getMoTa() {
		return moTa;
	}

	public void setMoTa(String moTa) {
		this.moTa = moTa;
	}

	public int getSoLuong() {
		return soLuong;
	}

	public void setSoLuong(int soLuong) {
		this.soLuong = soLuong;
	}

	public double getDonGia() {
		return donGia;
	}

	public void setDonGia(double donGia) {
		this.donGia = donGia;
	}

	public String getNgaySanXuat() {
		return ngaySanXuat;
	}

	public void setNgaySanXuat(String ngaySanXuat) {
		this.ngaySanXuat = ngaySanXuat;
	}

	public String getHanSuDung() {
		return hanSuDung;
	}

	public void setHanSuDung(String hanSuDung) {
		this.hanSuDung = hanSuDung;
	}

	public CommonsMultipartFile getFileData() {
		return fileData;
	}

	public void setFileData(CommonsMultipartFile fileData) {
		this.fileData = fileData;
	}

	@Override
	public String toString() {
		return "SanPhamInfo [idSanPham=" + idSanPham + ", tenSanPham=" + tenSanPham + ", moTa=" + moTa + ", soLuong="
				+ soLuong + ", donGia=" + donGia + ", ngaySanXuat=" + ngaySanXuat + ", hanSuDung=" + hanSuDung
				+ ", newSanPham=" + newSanPham + ", fileData=" + fileData + ", nhaSanXuat=" + nhaSanXuat
				+ ", loaiSanPham=" + loaiSanPham + "]";
	}

}
