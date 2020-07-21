import java.util.ArrayList;
import java.util.Random;

public class Universe {
    Random rand = new Random();
    public static ArrayList<Corpos> planets = new ArrayList();
    public Universe(){
    }
    public ArrayList<Corpos> getPlanets(){
        return planets;
    }
    public void addPlanet(String name, float mass, int radius){
        double x = Math.random()*400;
        double y = Math.random()*400;
        planets.add(new Corpos(name, mass, x, y, radius));
    }
    public double calcDist(Corpos planet, Corpos planeto){
        double x = Math.pow(planet.getPosx() - planeto.getPosx(), 2);
        double y = Math.pow(planet.getPosy() - planeto.getPosy(), 2);
        return Math.sqrt(x+y);
    }
    public double calcGrav(Corpos planet, Corpos planeto){
        double dist = calcDist(planet, planeto);
        double G = 6.67*(Math.pow(10, -11));
        double force = ((G*planet.getMass()*planeto.getMass())/Math.pow(dist, 2));
        return force;
    }
    public void gravitational(){
        double G = 6.67*(Math.pow(10, -11));
        for (int i=0; i<planets.size(); i++){
            for (int j=i+1;j<planets.size(); j++){
                double distx = Math.pow(planets.get(i).getPosx() - planets.get(j).getPosx(), 2);
                double disty = Math.pow(planets.get(i).getPosy() - planets.get(j).getPosy(), 2);
                double forcex = ((G*planets.get(i).getMass()*planets.get(j).getMass())/distx);
                double forcey = ((G*planets.get(i).getMass()*planets.get(j).getMass())/disty);
                if(planets.get(j).getPosx() > planets.get(i).getPosx()){
                    planets.get(i).setForcex(i, forcex);
                    planets.get(j).setForcex(i, forcex*-1);
                }else{
                    planets.get(j).setForcex(i, forcex);
                    planets.get(i).setForcex(i, forcex*-1);
                }
                if(planets.get(j).getPosy() > planets.get(i).getPosy()){
                    planets.get(i).setForcey(i, forcey);
                    planets.get(j).setForcey(i, forcey*-1);
                }else{
                    planets.get(i).setForcey(i, forcey*-1);
                    planets.get(j).setForcey(i, forcey);
                }
            }
        }
    }
}
