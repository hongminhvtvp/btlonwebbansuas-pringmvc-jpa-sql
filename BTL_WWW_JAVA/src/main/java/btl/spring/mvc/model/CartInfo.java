package btl.spring.mvc.model;

import java.util.ArrayList;
import java.util.List;

public class CartInfo {

	private double tongTien;
	private List<CartItemInfo> listAllCartItem = new ArrayList<CartItemInfo>();

	public int getLineItemCount() {
		return listAllCartItem.size();
	}
	
	public CartInfo() {
		super();
		// TODO Auto-generated constructor stub
	}

	public double getTongTien() {
		return tongTien;
	}

	public void setTongTien(double tongTien) {
		this.tongTien = tongTien;
	}

	public List<CartItemInfo> getListAllCartItem() {
		return listAllCartItem;
	}

	public void setListAllCartItem(List<CartItemInfo> listAllCartItem) {
		this.listAllCartItem = listAllCartItem;
	}

	public void calculateTongTien() {
		double dbTongTien = 0.0;
		for (int counter = 0; counter < listAllCartItem.size(); counter++) {
			CartItemInfo cartItemInfo = listAllCartItem.get(counter);
			dbTongTien += cartItemInfo.getThanhTien();
		}
		setTongTien(dbTongTien);
	}

	public void deleteCartItem(int itemIndex) {
		try {
			listAllCartItem.remove(itemIndex - 1);
			calculateTongTien();
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Error while delete cart item:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void updateCartItem(int itemIndex, int soLuong) {
		double dbThanhTien = 0.0;
		double dbDonGia = 0.0;
		CartItemInfo cartItemInfo = null;
		try {
			if (soLuong > 0) {
				cartItemInfo = listAllCartItem.get(itemIndex - 1);
				dbDonGia = cartItemInfo.getDonGia();
				dbThanhTien = soLuong * dbDonGia;
				cartItemInfo.setSoLuong(soLuong);
				cartItemInfo.setThanhTien(dbThanhTien);
				calculateTongTien();
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Error while update cart item:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public CartItemInfo getCartItemInfo(int itemIndex) {
		CartItemInfo cartItemInfo = null;
		if (listAllCartItem.size() > itemIndex) {
			cartItemInfo = listAllCartItem.get(itemIndex);
		}
		return cartItemInfo;
	}

	public void addCartItem(String strThongTin, String modelNo, String strSoLuong, String strDonGia) {
		double dbThaTien = 0.0;
		double dbDonGia = 0.0;
		int soLuong;
		CartItemInfo cartItemInfo = new CartItemInfo();
		try {
			dbDonGia = Double.parseDouble(strDonGia);
			soLuong = Integer.parseInt(strSoLuong);
			if (soLuong > 0) {
				dbThaTien = dbDonGia * soLuong;
				cartItemInfo.setPartNumber(modelNo);
				cartItemInfo.setThongTin(strThongTin);
				cartItemInfo.setDonGia(dbDonGia);
				cartItemInfo.setSoLuong(soLuong);
				cartItemInfo.setThanhTien(dbThaTien);
				listAllCartItem.add(cartItemInfo);
				calculateTongTien();
			}
		} catch (NumberFormatException e) {
			// TODO: handle exception
			System.out.println("Error while adding cart item:" + e.getMessage());
			e.printStackTrace();
		}
	}

	public void addCartItem(CartItemInfo cartItemInfo) {
		listAllCartItem.add(cartItemInfo);
		calculateTongTien();
	}

}
