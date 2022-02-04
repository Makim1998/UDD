package ftn.udd.mapper;

import java.util.HashSet;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Transactional;

import ftn.udd.DTO.ProfileDTO;
import ftn.udd.model.Authority;
import ftn.udd.model.User;

@Component
public class UserMapper {
	
	@Autowired
	private PasswordEncoder passwordEncoder;
	
	@Transactional(readOnly = true)
	public User map(ProfileDTO profileDTO) {
		User user = new User();
		user.setEmail(profileDTO.getEmail());
		user.setPassword(this.passwordEncoder.encode(profileDTO.getPassword()));
		user.setFirstName(profileDTO.getFirstName());
		user.setLastName(profileDTO.getLastName());
		Authority authority = new Authority();
		authority.setId(2L);
		authority.setName("client");
		Set<Authority> authorities = new HashSet<Authority>();
		authorities.add(authority);
		user.setAuthorities(authorities);
		return user;
	}
	
	@Transactional
	public ProfileDTO map(User user) {
		ProfileDTO profile = new ProfileDTO();
		profile.setId(user.getId());
		profile.setFirstName(user.getFirstName());
		profile.setLastName(user.getLastName());
		profile.setEmail(user.getEmail());
		profile.setPassword(user.getPassword());
		return profile;
	}
	
}
