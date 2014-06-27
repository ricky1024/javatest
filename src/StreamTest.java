import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStream;
import java.io.OutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.io.Writer;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;

public class StreamTest {
	public static void main(String[] args) {
		try {
			File file = new File("d:"+File.separator+"SublimeText2_workspace"+File.separator+"test.txt");
			if(file.exists()) {
				System.out.println("Already exist!");
			} else {
				file.createNewFile();
				System.out.println("File created!");
			}	
			//Writer
			String s = new String("Hello world!");
			FileOutputStream fos = new FileOutputStream(file);
			OutputStreamWriter osw = new OutputStreamWriter(fos);
			BufferedWriter bw = new BufferedWriter(osw);
			bw.write(s);
			bw.close();
			osw.close();
			fos.close();
			//read
			BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(file)));
			String ss = br.readLine();
			System.out.println(ss);
			br.close();

		} catch(IOException e) {
			e.printStackTrace();
		}
	}
}