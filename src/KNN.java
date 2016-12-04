import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;

public class KNN {
	public static HashMap<String, Properties> map;
	
	public static void process() {
		map = new HashMap<String, Properties>();
		boolean flag = false;
		try {
			FileReader input = new FileReader("excelData.csv");
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
	
	public static void findNearestNeighbors(TreeMap <Double, String> results, int kValue){
		int counter = -1;
		for(Map.Entry<Double, String> entry: results.entrySet()){
			if(counter < kValue){
				if(counter >= 0){
					System.out.print(entry.getValue() + "-----");
					System.out.println(entry.getKey());
				}
				counter++;
			}
		}
	}
	
	public static void userInput(){
		String univName = null;
		int kValue = 0;
		TreeMap<Double, String> results = new TreeMap<Double, String>();
		try{
			Scanner read = new Scanner(System.in);
			System.out.print("Enter University Name: ");
			univName =  read.nextLine();
			System.out.print("Enter number of nearest neighbors you want to find: ");
			kValue = read.nextInt();
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Properties userProperty = map.get(univName);
		
		for(Map.Entry<String, Properties> entry: map.entrySet()){
			Properties currValue = entry.getValue();

			//gets the distance between the single property entered and the others
			double dist = userProperty.distance(currValue);
			results.put(dist, entry.getKey());
		}
		
		findNearestNeighbors(results, kValue);
	}

	
	public static void main(String[] args) {
		process();
		//Properties p = map.get("Yale University");
	//	p.printProperties();
		userInput();
	}
}
