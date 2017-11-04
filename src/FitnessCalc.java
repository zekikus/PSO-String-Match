

public class FitnessCalc {
	
	static char[] solution = new char[Particle.dimension];
	
	public static void setSolution(char[] candidateSolution) {
		solution = candidateSolution;
	}
	
	public static void setSolution(String candidateSolution) {
		solution = candidateSolution.toCharArray();
	}	
	
	public static int calcFitness(Particle particle) {
		int fitness = 0;
		for (int i = 0; i < particle.size(); i++) {
			fitness += (int) Math.abs(particle.getData(i) - (int) solution[i]); 
		}
		return fitness;
	}
}
