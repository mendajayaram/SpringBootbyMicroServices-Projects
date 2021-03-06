package com.nt.jai.service;

import java.util.Optional;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import com.nt.jai.model.User;
import com.nt.jai.repo.UserRepository;

@Service
public class UserServiceImpl implements IUserService, UserDetailsService {
	@Autowired
	private UserRepository repo;

	@Autowired
	private BCryptPasswordEncoder encoder;

	@Override
	public Integer saveUser(User user) {
		String pwd = user.getUserPwd();
		String encode = encoder.encode(pwd);
		user.setUserPwd(encode);
		user = repo.save(user);

		return user.getId();
	}

	@Override
	public UserDetails loadUserByUsername(String username) 
			throws UsernameNotFoundException
	{
		//fetch user object based on emailId(username)
		Optional<User> opt = repo.findByUserName(username);

		//if user not exist 
		if(!opt.isPresent()) {
			throw new UsernameNotFoundException("Username not exist!");
		} else {
			//read model class user
			User user = opt.get();

			//read Roles(Set<String>) Convert to Set<GA>
			/*Set<String> roles = user.getUserRoles();

			Set<GrantedAuthority> authorities = new HashSet<>() ;
			for (String role : roles ) {
				authorities.add(new SimpleGrantedAuthority(role));
			}*/

			return new org.springframework.security.core.userdetails
					.User(
							username, 
							user.getUserPwd(), 
							user.getUserRoles()
							.stream()
							.map(role->new SimpleGrantedAuthority(role))
							.collect(Collectors.toSet())

							);
		}
	}



}
