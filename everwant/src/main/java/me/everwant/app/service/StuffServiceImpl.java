package me.everwant.app.service;

import java.util.List;

import me.everwant.app.domain.Stuff;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

@Service
public class StuffServiceImpl implements StuffService {

	private static final Logger logger = LoggerFactory
			.getLogger(StuffServiceImpl.class);

	@Autowired(required = false)
	MongoTemplate mongoTemplate;

	public List<Stuff> listStuffs() {

		return mongoTemplate.findAll(Stuff.class);

	}

	@Override
	public void save(Stuff stuff) {
		mongoTemplate.save(stuff);		
	}

}
