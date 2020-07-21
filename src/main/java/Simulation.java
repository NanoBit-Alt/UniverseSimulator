import java.awt.*;
import javax.swing.JPanel;
import javax.swing.JFrame;

public class Simulation{
    public static Universe milkway = new Universe();
    public static void main(String args[]) {
        milkway.addPlanet("Terra", 999999999, 100);
        milkway.addPlanet("Marte", 999999999, 80);
        milkway.addPlanet("Venus", 999999999, 70);
        JFrame frame = new JFrame("Simulador de Gravitação Universal");
        frame.setMinimumSize(new Dimension(500, 500));
        CorposCanvas canvas = new CorposCanvas();
        frame.getContentPane().add(canvas);
        frame.setVisible(true);
        gameLoop(canvas);
    }
    public static class CorposCanvas extends JPanel {
        public void paintComponent(Graphics g){
            super.paintComponent(g);
            g.setColor(Color.BLACK);
            for(int i=0; i<Universe.planets.size(); i++){
                g.drawArc(milkway.planets.get(i).getPosx()-(milkway.planets.get(i).getRaio()/2), milkway.planets.get(i).getPosy()-(milkway.planets.get(i).getRaio()/2), milkway.planets.get(i).getRaio(), milkway.planets.get(i).getRaio(), 0, 360);
                g.drawString(milkway.planets.get(i).getName(), milkway.planets.get(i).getPosx(), milkway.planets.get(i).getPosy());
                g.drawLine(0, 250, 500, 250);
                g.drawLine(250, 0, 250, 500);
                String force = (milkway.planets.get(i).getForces()+ " ");
            }
            for(int i=0; i<Universe.planets.size(); i++){
                for(int j=i+1; j<Universe.planets.size(); j++){
                    g.drawLine(milkway.planets.get(i).getPosx(), milkway.planets.get(i).getPosy(), milkway.planets.get(j).getPosx(), milkway.planets.get(j).getPosy());
                }
            }
        }
    }
    public static void calcUniverse(){
        milkway.gravitational();
        for(int i=0; i<milkway.planets.size(); i++) {
            milkway.planets.get(i).atForcex();
            milkway.planets.get(i).atForcey();
            milkway.planets.get(i).atPos(2);
            System.out.println(milkway.planets.get(i).getName() + ": Posx: " + milkway.planets.get(i).getPosx() + " Posy: " +  milkway.planets.get(i).getPosy() + " velocidades: " + milkway.planets.get(i).getVel());
        }
    }
    private static void gameLoop(CorposCanvas canvas){
        boolean running = true;
        calcUniverse();
        canvas.repaint();
        try { Thread.sleep (500); } catch (InterruptedException ex) {}
        if(running){
            gameLoop(canvas);
        }
    }
}