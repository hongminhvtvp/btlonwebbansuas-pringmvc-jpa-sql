package btl.spring.mvc.model;

import java.time.LocalDateTime;
import java.util.List;

import btl.spring.mvc.entities.CTDonHang;
import btl.spring.mvc.entities.KhachHang;
import btl.spring.mvc.entities.ThanhToan;

public class DonHangInfo {

	private LocalDateTime thoiGian;
	private double tongTien;
	private String diaChiGiao;

	private KhachHang khachHang;

	private ThanhToan thanhToan;

	private List<CTDonHang> listCtDonHangs;

	public DonHangInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public DonHangInfo(LocalDateTime thoiGian, double tongTien, String diaChiGiao) {
		super();
		this.thoiGian = thoiGian;
		this.tongTien = tongTien;
		this.diaChiGiao = diaChiGiao;
	}

	public String getDiaChiGiao() {
		return diaChiGiao;
	}

	public void setDiaChiGiao(String diaChiGiao) {
		this.diaChiGiao = diaChiGiao;
	}

	public LocalDateTime getThoiGian() {
		return thoiGian;
	}

	public void setThoiGian(LocalDateTime thoiGian) {
		this.thoiGian = thoiGian;
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public KhachHang getKhachHang() {
		return khachHang;
	}

	public void setKhachHang(KhachHang khachHang) {
		this.khachHang = khachHang;
	}

	public ThanhToan getThanhToan() {
		return thanhToan;
	}

	public void setThanhToan(ThanhToan thanhToan) {
		this.thanhToan = thanhToan;
	}

	public List<CTDonHang> getListCtDonHangs() {
		return listCtDonHangs;
	}

	public void setListCtDonHangs(List<CTDonHang> listCtDonHangs) {
		this.listCtDonHangs = listCtDonHangs;
	}

	@Override
	public String toString() {
		return "DonHangInfo [thoiGian=" + thoiGian + ", tongTien=" + tongTien + ", diaChiGiao=" + diaChiGiao
				+ ", khachHang=" + khachHang + ", thanhToan=" + thanhToan + ", listCtDonHangs=" + listCtDonHangs + "]";
	}

}
