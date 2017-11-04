

public class Particle {
	
	static int dimension = 7;
	private int[] data;
	private int[] velocities;
	private int[] pbest;
	private int fitness = 0;
	
	public Particle() {
		data = new int[dimension];
		velocities = new int[dimension];
		pbest = new int[dimension];
	}
	
	/* Getter and Setters */
	
	public int size() {
		return dimension;
	}
	
	public double getFitness() {
		if(fitness == 0) {
			fitness = FitnessCalc.calcFitness(this);
		}
		return fitness;
	}
	
	public int[] getDatas() {
		return data;
	}
	
	public void setDatas(int[] data) {
		this.data = data;
	}
	
	public int getData(int index) {
		return data[index];
	}
	
	public void setData(int index, int value) {
		data[index] = value;
	}
	
	public int[] getVelocities() {
		return velocities;
	}
	
	public void setVelocities(int[] velocities) {
		this.velocities = velocities;
	}
	
	public int getVelocity(int index) {
		return velocities[index];
	}
	
	public void setPbest(int[] pbest) {
		this.pbest = pbest;
	}
	
	public int[] getPbest() {
		return pbest;
	}
	
	public double getPBestValue(int index) {
		return pbest[index];
	}
	
	public void setFitness(int fitness) {
		this.fitness = fitness;
	}
	
	public int getPBestFitness() {
		int fitness = 0;
		for (int i = 0; i < pbest.length; i++) {
			fitness += (int) Math.abs(pbest[i] - (int) FitnessCalc.solution[i]); 
		}
		return fitness;
	}
	
	/* Public Methods */
	
	public void generateParticle() {
		for (int i = 0; i < data.length; i++) {
			data[i] = generateRandomData();
			pbest[i] = data[i];
			velocities[i] = 0;
		}
	}
	
	public int generateRandomData() {
		return 97 + (int)(Math.random() * 26);
	}
	
	@Override
	public String toString() {
		String word = "";
		for (int i = 0; i < data.length; i++) {
			word += (char) data[i];
		}
		return word;
	}
	
}
