import java.util.Random;
// to change
import java.io.*;

public class Voyage {

	String[] tabCity;
	int[][] tabCoordinate;
	int[][] distances; 	
	int[][] population;
	int nbCity;

	final int NUMBER_LINE_MAX = 100;

	Random rand = new Random(System.currentTimeMillis());
	String[] nomsVilles = {"Paris","Londres","NY","Tokyo","Madrid"};

	// launcher ...
	public static void main(String []args) {
		Voyage v = new Voyage();
		v.initialisation("villes.dat");
		v.display();
	}

    /** 
     * 
     * @param filename name of the file
     */
	public void initialisation(String filename) {
		BufferedReader reader = null;

		// list of city 
		tabCity = new String[NUMBER_LINE_MAX];
		tabCoordinate = new int[NUMBER_LINE_MAX][NUMBER_LINE_MAX];

		try {
			// connect stream
			InputStream ips = new FileInputStream(filename);
			InputStreamReader ipsr = new InputStreamReader(ips);
			reader = new BufferedReader(ipsr);

			String line;
			String[] myContent;
			int itr = 0;

			// for each line of the file we retrieve content
			while ((line = reader.readLine()) != null && itr < NUMBER_LINE_MAX) {

				myContent = line.split(" ");

				// if the tab is not consistent we ignore
				if (myContent.length != 3) {
					System.err.println("ERROR myContent 3 != "+myContent.length);
					continue;
				}

				tabCoordinate[itr][0] = Integer.parseInt(myContent[0]);
				tabCoordinate[itr][1] = Integer.parseInt(myContent[1]);
				tabCity[itr] = myContent[2];

				itr++;
			}

			nbCity = itr;
			reader.close();
		}
		catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		catch (IOException e) {
			e.printStackTrace();
		}
		catch (NumberFormatException e) {
			e.printStackTrace();
		}
	}
	
	public void display() {

		for (int i=0; i < nbCity; i++) {
			System.out.println(
					tabCoordinate[i][0]+", "+
					tabCoordinate[i][1]+", "+
					tabCity[i]);
		}
	}


}
