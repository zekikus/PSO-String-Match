

public class Functions {
	
	private static final int V_MAX = 10;
	
	public static void calculateVelocities(Particle particle, Particle gBest) {
		
		double c1 = 2.0, c2 = 2.0;
		
		int[] velocity = particle.getVelocities();

 		for (int i = 0; i < particle.size(); i++) {
 			double rand1 = Math.random();
 			double rand2 = Math.random();
 			double temp1 = c1 * rand1;
			double temp2 = particle.getPBestValue(i) - particle.getData(i);
			double temp3 = c2 * rand2;
			double temp4 = gBest.getData(i) - particle.getData(i);
			int result =  (int) ((0.71829 * velocity[i]) + temp1  - (temp2) + temp3 - (temp4));
			
		    if(result > V_MAX){
                velocity[i] = (V_MAX);
            }else if(result < -V_MAX){
                velocity[i] = (-V_MAX);
            }else{
                velocity[i] = (result);
            }
		}
 		
 		particle.setVelocities(velocity);
	}
	
	public static void updateParticles(Particle particle, Particle gBest) {
		
		int[] data = particle.getDatas();
		for (int i = 0; i < particle.size(); i++) {
			if(data[i] != gBest.getData(i)) {
				int result = (data[i]) + particle.getVelocity(i);
				if (result > 96 && result < 130) {
					data[i] = result;
				} else {
					data[i] = 97 + (int) (Math.random() * 26);
				}
			}
		}
		
		// Check pBest value.
		particle.setFitness(0);
		double fitness = particle.getFitness();
		if(fitness < particle.getPBestFitness()) {
			particle.setPbest(data);
		}
		
	}
	
}
