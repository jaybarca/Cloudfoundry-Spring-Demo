package me.everwant.app.service;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.ArrayList;
import java.util.List;

import me.everwant.app.data.UserRepository;
import me.everwant.app.domain.User;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

public class MongoDBUserService implements UserDetailsService {

	private static final Logger logger = LoggerFactory
			.getLogger(MongoDBUserService.class);

	private MongoTemplate mongoTemplate;

	@Override
	public UserDetails loadUserByUsername(String userName)
			throws UsernameNotFoundException {

		logger.info("userName:  " + userName);

		final User user = mongoTemplate.findOne(
				new Query(where("name").is(userName)), User.class,
				UserRepository.USER_COLLECTION);

		if (user == null) {
			logger.error("User not found, userName:  " + userName);
			return null;
		}

		logger.info("user found:  " + user);

		List<GrantedAuthority> listOfAuthorities = new ArrayList<GrantedAuthority>();
		listOfAuthorities.add(new SimpleGrantedAuthority("ROLE_USER"));

		return new org.springframework.security.core.userdetails.User(
				user.getName(), user.getPassword(), listOfAuthorities);

	}

	public MongoTemplate getMongoTemplate() {
		return mongoTemplate;
	}

	public void setMongoTemplate(MongoTemplate mongoTemplate) {
		this.mongoTemplate = mongoTemplate;
	}

}
