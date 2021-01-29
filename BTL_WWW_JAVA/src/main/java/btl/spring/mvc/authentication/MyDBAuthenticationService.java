package btl.spring.mvc.authentication;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import btl.spring.mvc.daos.TaiKhoanDAO;
import btl.spring.mvc.entities.TaiKhoan;

@Service
public class MyDBAuthenticationService implements UserDetailsService {

	@Autowired
	private TaiKhoanDAO taiKhoanDAO;

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		TaiKhoan taiKhoan = taiKhoanDAO.findTaiKhoanByUsername(username);
		System.out.println("Tai KHoan:" + taiKhoan);
		if (taiKhoan == null) {
			throw new UsernameNotFoundException("User " //
					+ username + " was not found in the database");
		}

		String role = taiKhoan.getLoaiTaiKhoan();

		List<GrantedAuthority> grantedAuthorities = new ArrayList<GrantedAuthority>();

		GrantedAuthority authority = new SimpleGrantedAuthority("ROLE_" + role);

		grantedAuthorities.add(authority);

		boolean enabled = taiKhoan.isTrangThai();
		boolean accountNonExpired = true;
		boolean credentialsNonExpired = true;
		boolean accountNonLocked = true;

		UserDetails userDetails =(UserDetails) new User(taiKhoan.getUsername(), taiKhoan.getPassword(), enabled, accountNonExpired,
				credentialsNonExpired, accountNonLocked, grantedAuthorities);

		return userDetails;
	}

}
