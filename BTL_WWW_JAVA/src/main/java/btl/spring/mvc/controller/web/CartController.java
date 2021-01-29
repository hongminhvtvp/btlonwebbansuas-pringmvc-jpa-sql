package btl.spring.mvc.controller.web;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import btl.spring.mvc.daos.DonHangDAO;
import btl.spring.mvc.daos.ThanhToanDAO;
import btl.spring.mvc.entities.KhachHang;
import btl.spring.mvc.entities.SanPham;
import btl.spring.mvc.entities.ThanhToan;
import btl.spring.mvc.model.CartInfo;
import btl.spring.mvc.model.CartItemInfo;
import btl.spring.mvc.model.DonHangInfo;

@Controller
@RequestMapping(value = "/cart")
public class CartController {
	
	private CartInfo cartInfo;
	
	@Autowired
	private ThanhToanDAO thanhToanDAO;
	
	@Autowired
	private DonHangDAO donHangDAO;
	
	
	  @RequestMapping(value = "/addToCart",method = RequestMethod.POST) public
	  ModelAndView addToCart(@ModelAttribute(name = "cartItemInfo") CartItemInfo
	  cartItemInfo,@RequestParam("action") String action,HttpServletRequest
	  request) { addToCart(request, cartItemInfo); return new
	  ModelAndView("shoppingCart"); }
	 
	
	@RequestMapping(value = "/action",method = RequestMethod.POST)
	public ModelAndView cartAcction(@ModelAttribute(name = "cartItemInfo") CartItemInfo cartItemInfo,@RequestParam("action") String action,HttpServletRequest request,@RequestParam("itemIndex") int itemIndex) {
		if(action.equals("Remove")) {
			delete(request, cartItemInfo, itemIndex);
		}else if(action.equals("UpdateCart")) {
			updateCart(request, cartItemInfo, itemIndex);
		}
		return new ModelAndView("shoppingCart");
	}
	
	@RequestMapping(value = "/checkOut",method = RequestMethod.GET)
	public ModelAndView displayCheckOut(@ModelAttribute(name = "donHangInfo") DonHangInfo donHangInfo,Model model) {
		List<ThanhToan> list=thanhToanDAO.listThanhToans();
		model.addAttribute("ds", list);
		return new ModelAndView("checkOut");
	}
	
	@RequestMapping(value = "/checkOut",method = RequestMethod.POST)
	public ModelAndView addDonHang(@ModelAttribute(name = "donHangInfo") DonHangInfo donHangInfo,HttpServletRequest request) {
		donHangInfo.setKhachHang(new KhachHang(1));
		buyDonHang(request,donHangInfo);
		removeCart(request);
		return new ModelAndView("home");
	}
	
	private void addToCart(HttpServletRequest request,CartItemInfo cartItemInfo) {
		HttpSession session=request.getSession();
		Object objectCart=session.getAttribute("cart");
		if(objectCart!=null) {
			cartInfo =(CartInfo) objectCart; 
		}else {
			cartInfo =new CartInfo();
			session.setAttribute("cart", cartInfo);
		}
		double thanhTien=cartItemInfo.getSoLuong()*cartItemInfo.getDonGia();
		CartItemInfo cartItemInfo2=new CartItemInfo(cartItemInfo.getPartNumber(), cartItemInfo.getThongTin(), cartItemInfo.getSoLuong(), cartItemInfo.getDonGia(), thanhTien);
		if(cartInfo.getListAllCartItem().size()==0) {
			cartInfo.addCartItem(cartItemInfo2);
		}else {
			for(CartItemInfo cartItemInfo3:cartInfo.getListAllCartItem()) {
				if(cartItemInfo3.getPartNumber().equals(cartItemInfo.getPartNumber())) {
					cartItemInfo3.setSoLuong(cartItemInfo.getSoLuong()+cartItemInfo3.getSoLuong());
					cartItemInfo3.setThanhTien(cartItemInfo3.getDonGia()*cartItemInfo3.getSoLuong());
					cartInfo.calculateTongTien(); 
					return;
				}
			}
			cartInfo.addCartItem(cartItemInfo2);
		}
	}
	
	private void delete(HttpServletRequest request,CartItemInfo cartItemInfo,int itemIndex) {
		HttpSession session=request.getSession();
		Object objCartInfo = session.getAttribute("cart");
		if(objCartInfo!=null) {
			cartInfo=(CartInfo) objCartInfo;
		}else {
			cartInfo=new CartInfo();
		}
		cartInfo.deleteCartItem(itemIndex);
	}
	
	private void updateCart(HttpServletRequest request,CartItemInfo cartItemInfo,int itemIndex) {
		HttpSession session=request.getSession();
		Object objCartInfo=session.getAttribute("cart");
		if(objCartInfo!=null) {
			cartInfo=(CartInfo) objCartInfo;
		}else {
			cartInfo=new CartInfo();
		}
		cartInfo.updateCartItem(itemIndex, cartItemInfo.getSoLuong());
	}
	
	private void buyDonHang(HttpServletRequest request,DonHangInfo donHangInfo) {
		if(cartInfo !=null) {
			for(CartItemInfo cartItemInfo : cartInfo.getListAllCartItem()) {
				donHangDAO.buy(new SanPham(cartItemInfo.getPartNumber()), cartItemInfo.getSoLuong(), cartItemInfo.getDonGia(), cartItemInfo.getThanhTien());
			}
			donHangDAO.addDonHang(donHangInfo);
		}
	}
	
	private void removeCart(HttpServletRequest request) {
		HttpSession session=request.getSession();
		session.removeAttribute("cart");
	}
}
