import java.util.Random;

public class Voyageur{

	private static Random random = new Random(System.currentTimeMillis());
	private static String[] nomsVilles = {"Paris","Londres","NY","Tokyo","Madrid"};
	private static int nbVille = 100;
	private static int[][] coordonnees;
	private static int[][] distances;
	private static int[][] population;
	
	public static void main(String[] args){
	
		nbVille = 5;
		int start = (int)System.currentTimeMillis();
		genese(10);
		int end = (int)System.currentTimeMillis();
		for (int i=0;i<10;i++){
			for(int j=0;j<5;j++){
				System.out.print(population[i][j] + "	");
			}
			System.out.println("");
		}
		System.out.println(end-start);
		
	}

	/**
	*	Method consisting to generate random routes passing through all the cities
	*	@param pop - Number of routes
	*/
	public static void genese(int pop){
		population = new int[pop][nbVille];
		int[] cities = new int[nbVille];		// Array containing cities indexes
		
		for(int k=0;k<nbVille;k++){
			cities[k]=k;
		}
		
		for(int i=0;i<pop;i++){
			// Creation of a random route
			for(int j=0;j<nbVille;j++){
				int r = random.nextInt(nbVille-j);
				population[i][j] = cities[r];
				// Put the random choosen variable at the end
				int tmp = cities[r];
				cities[r] = cities[nbVille-j-1];
				cities[nbVille-j-1] = tmp;
			}
		}
	}
	


}