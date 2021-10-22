package loginManager.service;

import java.util.Arrays;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import loginManager.domain.User;
import loginManager.domain.enumerator.Profile;
import loginManager.repository.UserRepository;

@Service
public class DBService {
	
	@Autowired
	private UserRepository userRepository;
	
	@Autowired
	private BCryptPasswordEncoder passwordEncoder;
	
	public void instantiateDatabase() {
		
		User u1 = new User(null, "anderkovaski@gmail.com", passwordEncoder.encode("123"));
		u1.getProfiles().add(Profile.ROLE_ADMIN);
		
		User u2 = new User(null, "anderkovaski@live.com", passwordEncoder.encode("456"));
		
		userRepository.saveAll(Arrays.asList(u1, u2));	
	}

}
