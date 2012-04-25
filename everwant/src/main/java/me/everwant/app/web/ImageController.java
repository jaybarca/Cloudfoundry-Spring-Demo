package me.everwant.app.web;

import java.io.IOException;

import javax.inject.Inject;

import me.everwant.app.service.ImageService;

import org.apache.commons.io.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/image")
public class ImageController {

	@Inject
	private ImageService imageService;

	@RequestMapping(value = "/{img}.jpg", method = RequestMethod.GET)
	public ResponseEntity<byte[]> getImage(@PathVariable String img) {

		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.IMAGE_JPEG);

		try {
			return new ResponseEntity<byte[]>(IOUtils.toByteArray(imageService
					.loadImage(img)), headers, HttpStatus.OK);
		} catch (IOException e) {
			return null;
		}

	}

}
