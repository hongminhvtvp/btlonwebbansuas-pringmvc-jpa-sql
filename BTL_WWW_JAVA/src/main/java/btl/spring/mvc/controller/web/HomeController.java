package btl.spring.mvc.controller.web;

import java.io.IOException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import btl.spring.mvc.daos.DonHangDAO;
import btl.spring.mvc.daos.KhachHangDAO;
import btl.spring.mvc.daos.SanPhamDAO;
import btl.spring.mvc.daos.TaiKhoanDAO;
import btl.spring.mvc.daos.ThanhToanDAO;
import btl.spring.mvc.entities.SanPham;
import btl.spring.mvc.entities.TaiKhoan;
import btl.spring.mvc.entities.ThanhToan;
import btl.spring.mvc.model.CartInfo;
import btl.spring.mvc.model.CartItemInfo;
import btl.spring.mvc.model.DonHangInfo;
import btl.spring.mvc.model.KhachHangInfo;
import btl.spring.mvc.model.TaiKhoanInfo;

@Controller(value = "homeCOntrollerOfWeb")
public class HomeController {

	@Autowired
	private SanPhamDAO sanPhamDAO;

	@Autowired
	private KhachHangDAO khachHangDAO;

	@Autowired
	private DonHangDAO donHangDAO;
	
	private CartInfo cartInfo;

	@Autowired
	private ThanhToanDAO thanhToanDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Autowired
	private TaiKhoanDAO taiKhoanDAO;

	@RequestMapping(value = { "/", "/trang-chu" })
	public ModelAndView home(@ModelAttribute(name = "cartItemInfo") CartItemInfo cartItemInfo) {
		List<SanPham> list=sanPhamDAO.listSanPhams();
		return new ModelAndView("web/home", "ds", list);
	}

	@RequestMapping(value = "/sanPhamImage", method = RequestMethod.GET)
	public void sanPhamImage(HttpServletRequest request, HttpServletResponse response,
			@RequestParam("idSanPham") String id) {
		SanPham sanPham = null;
		if (id != null) {
			sanPham = sanPhamDAO.findSanPhamById(id);
		}
		response.setContentType("image/jpeg, image/jpg, image/png, image/gif");
		try {
			response.getOutputStream().write(sanPham.getImage());
			response.getOutputStream().close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@RequestMapping(value = "/shoppingCart", method = RequestMethod.GET)
	public ModelAndView shoppingCart(@ModelAttribute(name = "cartItemInfo") CartItemInfo cartItemInfo) {
		return new ModelAndView("web/shoppingCart");
	}	
	
	@RequestMapping(value = "/addToCart", method = RequestMethod.POST)
	public ModelAndView addShoppingCart(@ModelAttribute(name = "cartItemInfo") CartItemInfo cartItemInfo ,HttpServletRequest request) {
		addToCart(request, cartItemInfo);
		return new ModelAndView("redirect:/shoppingCart");
	}

	@RequestMapping(value = "/action",method = RequestMethod.POST)
	public ModelAndView cartAcction(@ModelAttribute(name = "cartItemInfo") CartItemInfo cartItemInfo,@RequestParam("action") String action,HttpServletRequest request,@RequestParam("itemIndex") int itemIndex) {
		if(action.equals("Remove")) {
			delete(request, cartItemInfo, itemIndex);
		}else if(action.equals("UpdateCart")) {
			updateCart(request, cartItemInfo, itemIndex);
		}
		return new ModelAndView("redirect:/shoppingCart");
	}
	
	@RequestMapping(value = "/checkOut", method = RequestMethod.GET)
	public ModelAndView checkOut(@ModelAttribute(name = "donHangInfo") DonHangInfo donHangInfo,Model model) {
		List<ThanhToan> list=thanhToanDAO.listThanhToans();
		model.addAttribute("ds", list);
		return new ModelAndView("web/checkOut");
	}	
	
	@RequestMapping(value = "/checkOut",method = RequestMethod.POST)
	public ModelAndView addDonHang(@ModelAttribute(name = "donHangInfo") DonHangInfo donHangInfo,HttpServletRequest request,@RequestParam("action") String action) {
		UserDetails userDetails = (UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		TaiKhoan taiKhoan=taiKhoanDAO.findTaiKhoanByUsername(userDetails.getUsername());
		donHangInfo.setKhachHang(taiKhoan.getKhachHang());
		if(action.equals("Save")) {
			buyDonHang(request,donHangInfo);
			removeCart(request);
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
	@RequestMapping(value = "/register",method = RequestMethod.GET)
	public ModelAndView displayFormRegister(@ModelAttribute(name = "khachHangInfo") KhachHangInfo khachHangInfo) {
		return new ModelAndView("web/register");
	}
	
	@RequestMapping(value = "/register",method=RequestMethod.POST)
	public ModelAndView register(@ModelAttribute(name = "khachHangInfo") KhachHangInfo khachHangInfo) {
		TaiKhoan taiKhoan = new TaiKhoan();
		taiKhoan.setUsername(khachHangInfo.getTaiKhoanInfo().getUsername());
		taiKhoan.setPassword(passwordEncoder.encode(khachHangInfo.getTaiKhoanInfo().getPassword()));
		taiKhoan.setLoaiTaiKhoan(KhachHangInfo.ROLE_KHACHHANG);
		taiKhoan.setTrangThai(true);
		khachHangInfo.setTaiKhoan(taiKhoan);
		khachHangDAO.addKhachHang(khachHangInfo);
		return new ModelAndView("redirect:/trang-chu");
	}
			
	@RequestMapping(value = "/login",method = RequestMethod.GET)
	public ModelAndView displayFormLogin(@ModelAttribute(name = "taiKhoanInfo") TaiKhoanInfo taiKhoanInfo) {
		return new ModelAndView("/login");
	}
	
	@RequestMapping(value = "/403",method = RequestMethod.GET)
	public ModelAndView error() {
		return new ModelAndView("web/403");
	}
	
	@RequestMapping(value = "/default",method=RequestMethod.GET)
	public ModelAndView defaultLogin(HttpServletRequest request,Model model) {
		UserDetails userDetails=(UserDetails) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		model.addAttribute("userDetails", userDetails);
		if(request.isUserInRole("ROLE_ADMIN")) {
			return new ModelAndView("redirect:/admin");
		}
		return new ModelAndView("redirect:/trang-chu");
	}
	
	
	private void addToCart(HttpServletRequest request, CartItemInfo cartItemInfo) {
		HttpSession session = request.getSession();
		Object objectCart = session.getAttribute("cart");
		if (objectCart != null) {
			cartInfo = (CartInfo) objectCart;
		} else {
			cartInfo = new CartInfo();
			session.setAttribute("cart", cartInfo);
		}
		double thanhTien = cartItemInfo.getSoLuong() * cartItemInfo.getDonGia();
		CartItemInfo cartItemInfo2 = new CartItemInfo(cartItemInfo.getPartNumber(), cartItemInfo.getThongTin(),
				cartItemInfo.getSoLuong(), cartItemInfo.getDonGia(), thanhTien);
		if (cartInfo.getListAllCartItem().size() == 0) {
			cartInfo.addCartItem(cartItemInfo2);
		} else {
			for (CartItemInfo cartItemInfo3 : cartInfo.getListAllCartItem()) {
				if (cartItemInfo3.getPartNumber().equals(cartItemInfo.getPartNumber())) {
					cartItemInfo3.setSoLuong(cartItemInfo.getSoLuong() + cartItemInfo3.getSoLuong());
					cartItemInfo3.setThanhTien(cartItemInfo3.getDonGia() * cartItemInfo3.getSoLuong());
					cartInfo.calculateTongTien();
					return;
				}
			}
			cartInfo.addCartItem(cartItemInfo2);
		}
	}

	private void delete(HttpServletRequest request, CartItemInfo cartItemInfo, int itemIndex) {
		HttpSession session = request.getSession();
		Object objCartInfo = session.getAttribute("cart");
		if (objCartInfo != null) {
			cartInfo = (CartInfo) objCartInfo;
		} else {
			cartInfo = new CartInfo();
		}
		cartInfo.deleteCartItem(itemIndex);
	}

	private void updateCart(HttpServletRequest request, CartItemInfo cartItemInfo, int itemIndex) {
		HttpSession session = request.getSession();
		Object objCartInfo = session.getAttribute("cart");
		if (objCartInfo != null) {
			cartInfo = (CartInfo) objCartInfo;
		} else {
			cartInfo = new CartInfo();
		}
		cartInfo.updateCartItem(itemIndex, cartItemInfo.getSoLuong());
	}

	private void buyDonHang(HttpServletRequest request, DonHangInfo donHangInfo) {
		if (cartInfo != null) {
			for (CartItemInfo cartItemInfo : cartInfo.getListAllCartItem()) {
				donHangDAO.buy(new SanPham(cartItemInfo.getPartNumber()), cartItemInfo.getSoLuong(),
						cartItemInfo.getDonGia(), cartItemInfo.getThanhTien());
			}
			donHangDAO.addDonHang(donHangInfo);
		}
	}

	private void removeCart(HttpServletRequest request) {
		HttpSession session = request.getSession();
		session.removeAttribute("cart");
	}
}
