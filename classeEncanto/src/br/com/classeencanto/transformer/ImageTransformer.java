package br.com.classeencanto.transformer;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;

public class ImageTransformer {

	public byte[] fileToByte(File file) {

		byte[] byteImage = new byte[(int) file.length()];

		try {

			FileInputStream fileInputStream = new FileInputStream(file);

			fileInputStream.read(byteImage);

			fileInputStream.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return byteImage;
	}

	public File byteToFile(byte[] byteImage) {
		// TODO FAZER MÉTODO

		//sFile file = new File(pathname);
		
		try {
			
			FileOutputStream fos = new FileOutputStream("C:\\test.gif");

			fos.write(byteImage);

			fos.close();

		} catch (Exception e) {

			e.printStackTrace();
		}

		return null;
	}

}
