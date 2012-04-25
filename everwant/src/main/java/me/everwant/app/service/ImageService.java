package me.everwant.app.service;

import java.io.InputStream;

public interface ImageService {

	String saveImage(InputStream in);

	InputStream loadImage(String imageName);
}
