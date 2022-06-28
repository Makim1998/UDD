package ftn.udd.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import ftn.udd.model.User;
import ftn.udd.repository.UserRepository;

@Service
@Transactional(readOnly = true)
public class UserService implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
		
	
	@Override
	@Transactional(readOnly = true)
	public UserDetails loadUserByUsername(String username) {
		return this.userRepository.findByEmail(username);
		
	}
	
	@Transactional(readOnly = false)
	public User save(User user) {
		return this.userRepository.save(user);
	}
							
	@Transactional(readOnly = true)
	public User currentUser() {
		try {
			return (User) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		}
		catch(Exception e) {
			return null;
		}
	}

	@Transactional(readOnly = true)
	public User findUserById(Long id) {
		System.out.println(id);
		if(this.userRepository.findById(id).isPresent()){
			System.out.println("ima");
			return this.userRepository.findById(id).get();
		}
		System.out.println("nema");
		return null;
	}
	
}
