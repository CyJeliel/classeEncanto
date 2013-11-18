package br.com.classeencanto.transformer;

import java.io.IOException;

import org.springframework.stereotype.Component;
import org.springframework.web.multipart.MultipartFile;

@Component
public class ImageTransformer {

	public byte[] fileToByte(MultipartFile file) throws IOException {

		return file.getBytes();
	}
}
