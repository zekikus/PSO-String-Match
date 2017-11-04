

public class PSO {
	
	private final int PARTICLE_SIZE = 150;
	private final int DIMENSION = 7;
	private Particle[] particles = new Particle[PARTICLE_SIZE];
	
	public PSO() {
		
		Swarm swarm = new Swarm(PARTICLE_SIZE);
		
		swarm.initSwarm();
		particles = swarm.getParticles();
		
        Particle gBest = particles[0];
        Particle currentGBest = null;
        Particle aParticle = null;
        int epoch = 0;
        boolean done = false;

        
        while(!done) {
        
            if(epoch < 1000){

                for(int i = 0; i < PARTICLE_SIZE; i++) {
                    aParticle = particles[i];
                    for(int j = 0; j < DIMENSION; j++) {
                        System.out.print((char) aParticle.getData(j));
                    }

                    System.out.print("= " + aParticle.getFitness()+ "\n");
                    if(aParticle.getFitness() == 0){
                        done = true;
                    }
                } 
                
            
                currentGBest = getGlobalBest();
                // if(any particle's pBest value is better than the gBest value, make it the new gBest value.
                if(currentGBest.getFitness() < gBest.getFitness()){
                    gBest = currentGBest;
                }
               // gBest = getGlobalBest();
                swarm.calculateVelocities(gBest);
                swarm.updateParticles(gBest);
                System.out.println("------------------------");
                System.out.println("Iteration : " + epoch + " Global Best:" + gBest.getFitness());
                System.out.println("------------------------");
                epoch++;

            }else{
                done = true;
            }
        }
	}
	
	
	public Particle getGlobalBest() {
		Particle gBest = particles[0];
		for (int i = 1; i < particles.length; i++) {
			if(particles[i] != gBest){
            	Particle currentParticle = particles[i];
                if(currentParticle.getFitness() < gBest.getFitness()){
                    gBest = particles[i];
                }
            }
		}
		return gBest;
	}
	
}
