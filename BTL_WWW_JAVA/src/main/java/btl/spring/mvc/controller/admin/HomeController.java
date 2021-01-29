package btl.spring.mvc.controller.admin;

import java.time.LocalDate;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import btl.spring.mvc.daos.AdminDAO;
import btl.spring.mvc.daos.LoaiSanPhamDAO;
import btl.spring.mvc.daos.NhaSanXuatDAO;
import btl.spring.mvc.daos.SanPhamDAO;
import btl.spring.mvc.daos.ThanhToanDAO;
import btl.spring.mvc.entities.Admin;
import btl.spring.mvc.entities.LoaiSanPham;
import btl.spring.mvc.entities.NhaSanXuat;
import btl.spring.mvc.entities.SanPham;
import btl.spring.mvc.entities.TaiKhoan;
import btl.spring.mvc.entities.ThanhToan;
import btl.spring.mvc.model.LoaiSanPhamInfo;
import btl.spring.mvc.model.NhaSanXuatInfo;
import btl.spring.mvc.model.SanPhamInfo;
import btl.spring.mvc.model.ThanhToanInfo;

@Controller(value = "homeCOntrollerOfAdmin")
public class HomeController {

	@Autowired
	private SanPhamDAO sanPhamDAO;
	
	@Autowired
	private LoaiSanPhamDAO loaiSanPhamDAO;
	
	@Autowired
	private NhaSanXuatDAO nhaSanXuatDAO;
	
	@Autowired
	private ThanhToanDAO thanhTOanDAO;
	
	@Autowired
	private AdminDAO adminDAO;
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@RequestMapping(value = "/admin",method = RequestMethod.GET)
	public ModelAndView homePage(@ModelAttribute(name = "sanPhamInfo") SanPhamInfo sanPhamInfo) {
		List<SanPham> list=sanPhamDAO.listSanPhams();
		return new ModelAndView("admin/home","ds",list);
	}
	
	@RequestMapping(value = "/admin-themSanPham",method = RequestMethod.GET)
	public ModelAndView displayFormSanPham(@ModelAttribute(name = "sanPhamInfo") SanPhamInfo sanPhamInfo,Model model) {
		List<LoaiSanPham> loaiSanPhams=loaiSanPhamDAO.listLoaiSanPham();
		List<NhaSanXuat> nhaSanXuats=nhaSanXuatDAO.listNhaSanXuats();
		model.addAttribute("dsNhaSX", nhaSanXuats);
		model.addAttribute("dsLoaiSP", loaiSanPhams);
		return new ModelAndView("admin/themSanPham");
	}
	
	@RequestMapping(value = "/admin-addSanPham",method = RequestMethod.POST)
	public ModelAndView addSanPham(@ModelAttribute(name = "sanPhamInfo") SanPhamInfo sanPhamInfo) {
		sanPhamDAO.addSanPham(sanPhamInfo);
		List<SanPham> list=sanPhamDAO.listSanPhams();
		return new ModelAndView("redirect:/admin", "ds", list);
	}
	
	@RequestMapping(value = "/admin-loaiSanPham",method = RequestMethod.GET)
	public ModelAndView displayformLoaiSP(@ModelAttribute (name = "loaiSanPhamInfo") LoaiSanPhamInfo loaiSanPhamInfo) {
		List<LoaiSanPham> list=loaiSanPhamDAO.listLoaiSanPham();
		return new ModelAndView("admin/loaiSanPham", "ds", list);
	}
	
	@RequestMapping(value = "/admin-addLoaiSanPham",method = RequestMethod.POST)
	public ModelAndView addLoaiSanPham(@ModelAttribute(name = "loaiSanPhamInfo") LoaiSanPhamInfo loaiSanPhamInfo) {
		loaiSanPhamDAO.addLoaiSanPham(loaiSanPhamInfo);
		return new ModelAndView("redirect:/admin-loaiSanPham");
	}
	
	@RequestMapping(value = "/admin-updateSP",method = RequestMethod.POST)
	public ModelAndView updateSanPham(@ModelAttribute(name = "sanPhamInfo") SanPhamInfo sanPhamInfo) {
		LoaiSanPham loaiSanPham=new LoaiSanPham(sanPhamInfo.getLoaiSanPham().getIdLoaiSanPham());
		NhaSanXuat nhaSanXuat=new NhaSanXuat(sanPhamInfo.getNhaSanXuat().getIdNhaSanXuat());
		sanPhamInfo.setLoaiSanPham(loaiSanPham);
		sanPhamInfo.setNhaSanXuat(nhaSanXuat);
		sanPhamDAO.update(sanPhamInfo);
		return new ModelAndView("redirect:/admin");
	}
	
	@RequestMapping(value = "/admin-deleteSP",method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute(name = "sanPhamInfo")SanPhamInfo sanPhamInfo) {
		sanPhamDAO.delete(sanPhamInfo.getIdSanPham());
		return new ModelAndView("redirect:/admin");
	}
	
	@RequestMapping(value = "/admin-nhaSanXuat",method = RequestMethod.GET)
	public ModelAndView displayFormNhaSanXuat(@ModelAttribute(name = "nhaSanXuatInfo") NhaSanXuatInfo nhaSanXuatInfo) {
		List<NhaSanXuat> list=nhaSanXuatDAO.listNhaSanXuats();
		return new ModelAndView("admin/nhaSanXuat", "ds", list);
	}
	
	@RequestMapping(value = "/admin-addNhaSX",method = RequestMethod.POST)
	public ModelAndView addNhaSanXuat(@ModelAttribute(name = "nhaSanXuatInfo") NhaSanXuatInfo nhaSanXuatInfo) {
		nhaSanXuatDAO.addNhaSanXuat(nhaSanXuatInfo);
		return new ModelAndView("redirect:/admin-nhaSanXuat");
	}
	
	@RequestMapping(value = "/admin-editSP",method = RequestMethod.GET)
	public ModelAndView displayFormEdit(@ModelAttribute(name = "sanPhamInfo") SanPhamInfo sanPhamInfo,Model model,@RequestParam("idSanPham") String id) {
		List<LoaiSanPham> loaiSanPhams=loaiSanPhamDAO.listLoaiSanPham();
		List<NhaSanXuat> nhaSanXuats=nhaSanXuatDAO.listNhaSanXuats();
		SanPham sanPham=sanPhamDAO.findSanPhamById(id);
		sanPhamInfo=new SanPhamInfo(sanPham);
		model.addAttribute("dsNhaSX", nhaSanXuats);
		model.addAttribute("dsLoaiSP", loaiSanPhams);
		return new ModelAndView("admin/editSP", "sp", sanPhamInfo);
	}
	
	@RequestMapping(value = "/admin-updateLoaiSP",method = RequestMethod.POST)
	public ModelAndView editLoaiSP(@ModelAttribute(name = "loaiSanPhamInfo") LoaiSanPhamInfo loaiSanPhamInfo) {
		loaiSanPhamDAO.update(loaiSanPhamInfo);
		return new ModelAndView("redirect:/admin-loaiSanPham");
	}
	
	@RequestMapping(value = "/admin-deleteLoaiSP",method = RequestMethod.POST)
	public ModelAndView deleteLoaiSP(@ModelAttribute(name = "loaiSanPhamInfo") LoaiSanPhamInfo loaiSanPhamInfo) {
		loaiSanPhamDAO.delete(loaiSanPhamInfo.getIdLoaiSanPham());
		return new ModelAndView("redirect:/admin-loaiSanPham");
	}
	
	@RequestMapping(value = "/admin-updateNhaSX",method = RequestMethod.POST)
	public ModelAndView editNhaSX(@ModelAttribute(name = "nhaSanXuatInfo") NhaSanXuatInfo nhaSanXuatInfo) {
		nhaSanXuatDAO.update(nhaSanXuatInfo);
		return new ModelAndView("redirect:/admin-nhaSanXuat");
	}
	
	@RequestMapping(value = "/admin-deleteNhaSX",method=RequestMethod.POST)
	public ModelAndView deleteNhaSX(@ModelAttribute(name = "nhaSanXuatInfo")NhaSanXuatInfo nhaSanXuatInfo) {
		nhaSanXuatDAO.delete(nhaSanXuatInfo.getIdNhaSanXuat());
		return new ModelAndView("redirect:/admin-nhaSanXuat");
	}
	
	@RequestMapping(value = "/admin-thanhToan",method = RequestMethod.GET)
	public ModelAndView displayFormThanhToan(@ModelAttribute(name = "thanhToanInfo") ThanhToanInfo thanhToanInfo) {
		List<ThanhToan>list=thanhTOanDAO.listThanhToans();
		return new ModelAndView("admin/thanhToan", "ds", list);
	}
	
	@RequestMapping(value = "/admin-addThanhToan",method = RequestMethod.POST)
	public ModelAndView addThanhToan(@ModelAttribute(name = "thanhToanInfo")ThanhToanInfo thanhToanInfo) {
		thanhTOanDAO.addThanhToan(thanhToanInfo);
		return new ModelAndView("redirect:/admin-thanhToan");
	}
	
	@RequestMapping(value = "/admin-updateThanhToan",method=RequestMethod.POST)
	public ModelAndView editThanhToan(@ModelAttribute(name = "thanhToanInfo") ThanhToanInfo thanhToanInfo) {
		thanhTOanDAO.update(thanhToanInfo);
		return new ModelAndView("redirect:/admin-thanhToan");
	}
	
	@RequestMapping(value = "/admin-deleteThanhToan",method=RequestMethod.POST)
	public ModelAndView delete(@ModelAttribute(name = "thanhToanInfo") ThanhToanInfo thanhToanInfo) {
		thanhTOanDAO.delete(thanhToanInfo.getIdThanhToan());
		return new ModelAndView("redirect:/admin-thanhToan");
	}

	@RequestMapping(value = "add-admin",method = RequestMethod.GET)
	public ModelAndView registerAdmin() {
		Admin admin=new Admin("Admin", "AAA", "Nam", "09215446", "aad@gamil.com", LocalDate.now());
		admin.setTaiKhoan(new TaiKhoan("ADMIN", true, "admin", passwordEncoder.encode("admin")));
		adminDAO.addAdmin(admin);
		return new ModelAndView("redirect:/admin");
	}
}
