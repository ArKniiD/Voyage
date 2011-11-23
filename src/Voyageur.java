import java.util.Random;

public class Voyageur{

	private static Random rand = new Random(System.currentTimeMillis());
	private static String[] nomsVilles = {"Paris","Londres","NY","Tokyo","Madrid"};
	private static int nbVille;
	private static int[][] coordonnees;
	private static int[][] distances;
	private static int[][] population;
	
	public static void main(String[] args){
		nbVille = 50;//nomsVilles.length;
		int start = (int)System.currentTimeMillis();
		genese(100);
		int end = (int)System.currentTimeMillis();
		// for(int i=0;i<1000;i++){
			// for(int j=0;j<nbVille;j++){
				//System.out.print(population[i][j] + "	");
			// }
			// System.out.println("");
		// }
		System.out.println(end-start);
		
	}

	public static void genese(int pop){
		population = new int[pop][nbVille];
		int[] cities = new int[nbVille];
		
		for(int i=0;i<pop;i++){
			for(int k=0;k<nbVille;k++){
				cities[k]=k;
			}
			for(int j=0;j<nbVille;j++){
				int r = rand.nextInt(nbVille-j);
				int city = cities[r];
				population[i][j] = city;
				for(int k=r+1;k<nbVille-j;k++){
					cities[k-1]=cities[k];
				}
			}
		}
	}
	


}