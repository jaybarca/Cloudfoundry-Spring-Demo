package me.everwant.app.service;

import java.io.InputStream;
import java.io.OutputStream;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Service;

import com.mongodb.DB;
import com.mongodb.gridfs.GridFS;
import com.mongodb.gridfs.GridFSDBFile;
import com.mongodb.gridfs.GridFSInputFile;

@Service
public class ImageServiceImpl implements ImageService {

	@Autowired(required = false)
	MongoTemplate mongoTemplate;

	private static final Logger logger = LoggerFactory
			.getLogger(ImageServiceImpl.class);

	@Override
	public String saveImage(InputStream in) {

		DB db = mongoTemplate.getDb();
		GridFS gridFS = new GridFS(db, "fs");

		GridFSInputFile file = gridFS.createFile(in);
		String fileName = java.util.UUID.randomUUID().toString();
		file.setFilename(fileName);
		file.save();

		logger.info("file saved: " + fileName);

		return fileName;

	}

	@Override
	public InputStream loadImage(String imageName) {
		DB db = mongoTemplate.getDb();
		GridFS gridFS = new GridFS(db, "fs");

		GridFSDBFile fileOut = gridFS.findOne(imageName);

		return fileOut == null ? null : fileOut.getInputStream();

	}

}
