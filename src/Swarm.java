

public class Swarm {
	
	private int PARTICLE_SIZE;
	private Particle[] particles;
	
	public Swarm(int particle_size) {
		PARTICLE_SIZE = particle_size;
		particles = new Particle[PARTICLE_SIZE];
	}
	
	// Create swarm
	public void initSwarm() {
		for (int i = 0; i < particles.length; i++) {
			Particle newParticle = new Particle();
			newParticle.generateParticle();
			particles[i] = newParticle;
		}
	}
	
	public void calculateVelocities(Particle gBest) {
		for (int i = 0; i < particles.length; i++) {
			Functions.calculateVelocities(particles[i], gBest);
		}
	}

	public void updateParticles(Particle gBest) {
		for (int i = 0; i < particles.length; i++) {
			Functions.updateParticles(particles[i], gBest);
		}
	}
	
	
	/* Getters and Setters */
	public Particle[] getParticles() {
		return particles;
	}
}
