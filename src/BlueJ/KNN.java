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
    //public static HashMap<String, University> map;

    //global arraylist of University
    public static ArrayList<University> listOfUni = new ArrayList<University>();
    public static ArrayList<University> oldCentroids = new ArrayList<University>();
    public static ArrayList<University> newCentroids = new ArrayList<University>();
    public static HashMap<University, ArrayList<University>> clusters = new HashMap();

    /**
     * processes the data of universities and attributes into a list of University
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
                    University p = new University(arr[1], arr[2], Integer.parseInt(arr[3]), Integer.parseInt(arr[4]), Integer.parseInt(arr[5]));
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

        for(int i = 0; i < listOfUni.size(); i++){
        listOfUni.get(i).printUniversity();
        }*/
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

    public static University findMin(University current) {
        double res = 0;
        double min = 10000;
        int i, index = 0;
        for(i = 0; i < oldCentroids.size(); i++ ) {
            res = oldCentroids.get(i).distance(current);
            if(res < min && res != 0 ) {
                min = res;
                index = i;
            }

        }

        return oldCentroids.get(index);
    }

    public static void processClusters(){
        University target = null;
        ArrayList<University> temp = new ArrayList();
        for(University cur : listOfUni) {
            target = findMin(cur);	
            for(Map.Entry<University, ArrayList<University>> cluster: clusters.entrySet()){
                if(target.equals(cluster.getKey())){
                    temp = cluster.getValue();
                    temp.add(cur);
                    clusters.put(cluster.getKey(),temp);

                }
            }
        }

    }

    public static void initializeClusters() {
        oldCentroids.add(new University("Harvard University", "USA", 1, 1, 1));
        oldCentroids.add(new University("Maastricht University", "Netherlands", 8, 355, 478));
        oldCentroids.add(new University("Otto-von-Guericke University Magdeburg", "Germany", 40, 355, 478));
        oldCentroids.add(new University("Paul Valí©ry University Montpellier III", "France", 35, 355, 478));
        oldCentroids.add(new University("Yanbian University", "China", 84, 355, 478));

        /*-----------------------------------------*/
        clusters.put(oldCentroids.get(0), new ArrayList<University>());
        clusters.put(oldCentroids.get(1), new ArrayList<University>());
        clusters.put(oldCentroids.get(2), new ArrayList<University>());        
        clusters.put(oldCentroids.get(3), new ArrayList<University>());
        clusters.put(oldCentroids.get(4), new ArrayList<University>());

    }

    public static void main(String[] args) {
        process(); // adds the data into the hashmap
        initializeClusters();
        processClusters();

        System.out.print("Cluster1 ==> ");
        oldCentroids.get(0).printUniversity();
        System.out.print(" ---- ");
        System.out.println(clusters.get(oldCentroids.get(0)).size());
        System.out.print("Cluster2 ==> ");
        oldCentroids.get(1).printUniversity();
        System.out.print(" ---- ");
        System.out.println(clusters.get(oldCentroids.get(1)).size());
        System.out.print("Cluster3 ==> ");
        oldCentroids.get(2).printUniversity();
        System.out.print(" ---- ");
        System.out.println(clusters.get(oldCentroids.get(2)).size());
        System.out.print("Cluster4 ==> ");
        oldCentroids.get(3).printUniversity();
        System.out.print(" ---- ");
        System.out.println(clusters.get(oldCentroids.get(3)).size());
        System.out.print("Cluster5 ==> ");
        oldCentroids.get(4).printUniversity();
        System.out.print(" ---- ");
        System.out.println(clusters.get(oldCentroids.get(4)).size());

    }
}
