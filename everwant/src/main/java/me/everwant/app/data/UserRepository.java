package me.everwant.app.data;

import static org.springframework.data.mongodb.core.query.Criteria.where;

import java.util.List;

import me.everwant.app.domain.User;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.stereotype.Repository;

@Repository
public class UserRepository {

	public static final String USER_COLLECTION = "users";

	@Autowired
	MongoTemplate mongoTemplate;

	public void add(User user) {
		mongoTemplate.save(user, USER_COLLECTION);
	}

	public User findByName(String username) {
		return mongoTemplate.findOne(new Query(where("name").is(username)),
				User.class, USER_COLLECTION);
	}

	public User findByEmail(String email) {
		return mongoTemplate.findOne(new Query(where("email").is(email)),
				User.class, USER_COLLECTION);
	}

	public List<User> findAll() {
		return mongoTemplate.findAll(User.class, USER_COLLECTION);
	}

	public void remove(String id) {
		mongoTemplate.remove(new Query(where("id").is(id)), USER_COLLECTION);
	}
}
