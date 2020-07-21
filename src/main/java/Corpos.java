import java.util.ArrayList;

public class Corpos {
    private float mass, raio;
    private String name;
    private ArrayList<Double> forcex = new ArrayList();
    private ArrayList<Double> forcey = new ArrayList();
    private double forcexres;
    private double acelx, acely, velx, vely = 0;
    private double posx, posy;
    private double forceyres;
    public Corpos(String name, float mass, double posx, double posy, float raio){
        this.name = name;
        this.mass = mass;
        this.posx = posx;
        this.posy = posy;
        this.raio = raio;
    }
    public ArrayList<Double> getForcexArray(){
        return forcex;
    }
    public ArrayList<Double> getForceyArray(){
        return forcey;
    }
    public void atForcex() {
        double n = 0;
        for(int i=0; i<forcex.size(); i++){
            n=n+forcex.get(i);
        }
        forcex.clear();
        forcexres = n;
    }
    public void setForcex(int index, Double force) {
        this.forcex.add(index, force);
    }
    public void atForcey() {
        double n = 0;
        for(int i=0; i<forcey.size(); i++){
            n = n+forcey.get(i);
        }
        forcey.clear();
        forceyres = n;
    }
    public void setForcey(int index, Double force) {
        this.forcey.add(index, force);
    }
    public int getPosx() {
        int posxint = (int) posx;
        return posxint;
    }
    public int getPosy() {
        int posyint = (int) posy;
        return posyint;
    }
    public float getMass() {
        return mass;
    }
    public int getRaio() {
        int raioint = (int) raio;
        return raioint;
    }
    public String getName(){
        return name;
    }
    public ArrayList<Double> getForces(){
        ArrayList<Double> forces = new ArrayList<Double>();
        forces.add(forcexres);
        forces.add(forceyres);
        return forces;
    }
    public void atPos(int fps){
        acelx = forcexres/mass;
        acely = forceyres/mass;
        velx = velx + (acelx/fps);
        vely = vely + (acely/fps);
        posx += velx;
        posy += vely;
    }
    public ArrayList<Double> getVel(){
        ArrayList<Double> velocidades = new ArrayList<Double>();
        velocidades.add(velx);
        velocidades.add(vely);
        return velocidades;
    }
}