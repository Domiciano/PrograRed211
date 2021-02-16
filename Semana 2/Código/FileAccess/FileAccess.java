import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class FileAccess {

	public static void main(String... args) {
		try {
			String path = "/Users/domicianorincon/Documents/Por enviar/video.mp4";
			String copypath = "/Users/domicianorincon/Documents/Por enviar/copy.mp4";
			FileInputStream fis = new FileInputStream(new File(path));
			FileOutputStream fos = new FileOutputStream(new File(copypath));
			
			byte[] buff = new byte[1024];
			int readBytes = 0;
			while((readBytes = fis.read(buff)) != -1) {
				fos.write(buff,0,readBytes);
			}
			fis.close();
			fos.close();
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
