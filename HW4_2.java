package HW4_2;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.regex.Matcher;
import java.util.regex.Pattern;


public class HW4_2 {

	public static void main(String[] args) {
		Path filePath = Path.of("\\Users\\User\\Desktop\\HW4-2\\HW4_2\\bin\\HW4_2\\demo.txt"); 
		try {
			String content = Files.readString(filePath);
			//System.out.println(content);
			
			Pattern pattern = Pattern.compile("01AF0055\\/\\d{6}[a-z]\\.HRV\\.jpg\\?HRV\\.bpp");
			Matcher matcher = pattern.matcher(content);
			
			while(matcher.find()) {
				System.out.println(matcher.group());
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
