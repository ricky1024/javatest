import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Map;

public class TestMap1 {
	public static void main(String[] args) {
		String txt = new String(
				"hello world one two two one world three one one hello test map"
						+ "problem task appliction, nihao.");
		File f = new File("d:" + File.separator + "UB" + File.separator
				+ "testMap.txt");
		if (!f.exists()) {
			System.out.println("Begin to create file...");
			try {
				f.createNewFile();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			System.out.println("File created!");
		} else {
			System.out.println("File is ready.");
			try {
				/*FileOutputStream fos = new FileOutputStream(f);
				BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(fos));
				bw.write(txt); 
				System.out.println("Written done!");
				bw.close();
				fos.close();*/
				FileInputStream fis = new FileInputStream(f);
				BufferedReader br = new BufferedReader(new InputStreamReader(fis));
				String line = "";
				String all = "";
				while((line=br.readLine())!=null) {
					line+='\n';
					all+=line;
				}
				System.out.println(all);
				String[] arr = all.split("[^a-zA-Z0-9]+");
				/*for(int i = 0;i<arr.length;i++) {
					System.out.print(arr[i] + "   ");
				}*/
				Map<String, Integer> m = new HashMap<String, Integer>();
				for(int i = 0;i<arr.length;i++) {
					if(m.get(arr[i])==null) {
						m.put(arr[i], 1);
					} else {
						m.put(arr[i],m.get(arr[i])+1);
					}
				}
				System.out.println(m);
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}
}