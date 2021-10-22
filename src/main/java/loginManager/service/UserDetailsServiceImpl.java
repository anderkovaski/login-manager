package loginManager.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import loginManager.domain.User;
import loginManager.repository.UserRepository;
import loginManager.security.UserDetailsImpl;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

	@Autowired
	private UserRepository userRepository;
	
	@Override
	public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
		
		User user = userRepository.findByEmail(email);
		
		if (user == null) {
			throw new UsernameNotFoundException(email + " not found");
		}
		
		return new UserDetailsImpl(user.getId(), user.getEmail(), user.getPassword(), user.getProfiles());
	}

}
