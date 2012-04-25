package me.everwant.app.service;

import java.util.List;

import me.everwant.app.domain.Stuff;

public interface StuffService {

	List<Stuff> listStuffs();
	
	void save(Stuff stuff);
}
