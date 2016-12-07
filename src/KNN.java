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
	//public static HashMap<String, Properties> map;
	
	//global arraylist of properties
	public static ArrayList<Properties> listOfUni = new ArrayList<Properties>();
	
	public static ArrayList<Properties> oldCentroids = new ArrayList<Properties>();
	public static ArrayList<Properties> newCentroids = new ArrayList<Properties>();
	
	/**
	 * clusters
	 */
	public static HashMap<String, Properties> c1 = new HashMap<String, Properties>();
	public static HashMap<String, Properties> c2 = new HashMap<String, Properties>();
	public static HashMap<String, Properties> c3 = new HashMap<String, Properties>();
	public static HashMap<String, Properties> c4 = new HashMap<String, Properties>();
	public static HashMap<String, Properties> c5 = new HashMap<String, Properties>();
	
	/**
	 * arraylist of clusters
	 */
	public static ArrayList<HashMap<String, Properties>> clusters = new ArrayList<HashMap<String,Properties>>();
	

	/**
	 * processes the data of universities and attributes into a list of Properties
	 */
	public static void process() {
		boolean flag = false;
		try {
			FileReader input = new FileReader("uniData.csv");
			BufferedReader bufRead = new BufferedReader(input);
			String myLine = null;

			while((myLine = bufRead.readLine()) != null) {
				if(flag == true) {
					String[] arr = myLine.split(",");
					
					if(arr.length < 1) {
						System.out.println("Bad sized line.");
						return;
					}
				    Properties p = new Properties(arr[1], (arr[2]), Integer.parseInt(arr[3]), Integer.parseInt(arr[4]));
				    listOfUni.add(p);
				}
				flag = true;	
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		/**
		 * prints the list
		 */
		for(int i = 0; i < listOfUni.size(); i++){
			listOfUni.get(i).printProperties();
		}
	}
	
	/**
	 * searches for k nearest neighbors (distance formula already applied)
	 * @param results
	 * @param kValue
	 */
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
	
	/**
	 * gets user input and finds vector distances between all schools and stores them into hashmap
	 */
	/*public static void userInput(){
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
	}*/
	
/*	public static void cluster(){
		int i = 0;
		TreeMap<String, Double> temp = new TreeMap();
		for(HashMap<String, Properties> cluster : clusters){
			for(Map.Entry<String, Properties> entry: map.entrySet()){
				if (!entry.getValue().equals(oldCentroids.get(i))){
					temp.put(entry.getKey(), oldCentroids.get(i).distance(entry.getValue()));
				}
			}
		}
	}
*/
	
	public static void main(String[] args) {
		process(); // adds the data into the hashmap
		
		/**
		 * starting centroid values
		 */
	/*	oldCentroids.add(new Properties("USA", 1, 1, 1,	1));
		oldCentroids.add(new Properties("Netherlands", 8, 355, 478, 210));
		oldCentroids.add(new Properties("Germany", 40, 355, 478, 210));
		oldCentroids.add(new Properties("France", 35, 355, 478, 210));
		oldCentroids.add(new Properties("China", 84, 355, 478, 210));
		*/
		/**
		 * adds all clusters to the hashmap
		 */
		clusters.add(c1);
		clusters.add(c2);
		clusters.add(c3);
		clusters.add(c4);
		clusters.add(c5);
		
	}
}
