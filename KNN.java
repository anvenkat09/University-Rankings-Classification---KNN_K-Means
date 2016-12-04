import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

public class KNN {
	public static HashMap<String, Properties> map;
	
	public static void process() {
		map = new HashMap<String, Properties>();
		boolean flag = false;
		try {
			FileReader input = new FileReader("/Users/dougfoiles/Desktop/cwurData.csv");
			BufferedReader bufRead = new BufferedReader(input);
			String myLine = null;

			while((myLine = bufRead.readLine()) != null) {
				if(flag == true) {
					String[] arr = myLine.split(",");
					
					if(arr.length < 1) {
						System.out.println("Bad sized line.");
						return;
					}
					
				    Properties p = new Properties(arr[2], Integer.parseInt(arr[3]), 
							Integer.parseInt(arr[4]), Integer.parseInt(arr[5]), Integer.parseInt(arr[6]));
					map.put(arr[1], p);
				}
				flag = true;
				
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		process();
		Properties p = map.get("\"Harvard University\"");
		p.printProperties();
	}
}
