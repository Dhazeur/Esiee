import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.MouseEvent;

public class system {

	/**
	 * @param args
	 */
	private static JFenetre fenetre;
	private static int x, y; // coordonée du perso
	private static int mouvX = 0, mouvY = 0; // pour modif la direction du perso

	public static void main(String[] args) {
		x = 10;
		y = 10;
		fenetre = new JFenetre(200, 200);
		// dimensionnement de la fenêre "au plus juste" suivant
		// la taille des composants qu'elle contient
		fenetre.pack();
		// centrage sur l'écran
		fenetre.setLocationRelativeTo(null);
		// affichage
		fenetre.setVisible(true);
		fenetre.start();//on lance le thread qui va appeler la fonction loop
		
	}

	public static void loop() {
		int temps = (int) (System.currentTimeMillis());
		int deltaTemps=temps;
		while (true) {
			x+=mouvX;
			y+=mouvY;
			if(x<0)
				x=0;
			if(y<0)
				y=0;
			if(x>189)
				x=189;
			if(y>189)
				y=189;
			
			deltaTemps=(int) (System.currentTimeMillis());
			
			if(deltaTemps-temps<1000/60){
				temps=deltaTemps;
				dessin();//calibrer pour afficher du 60fps
			}
			
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void affichage(Graphics g) {
		g.setColor(Color.blue);
		g.drawRect(1, 1, 197, 197);
		g.drawOval(x, y, 10, 10);
	}

	public static void keyPressed(KeyEvent arg0) {
		char c = arg0.getKeyChar();
		System.out.print("Pressed "+c+"\n");
		switch (c) {
		case 'z':
			mouvY--;
			break;
		case 's':
			mouvY++;
			break;
		case 'd':
			mouvX++;
			break;
		case 'q':
			mouvX--;
			break;
		}
	}

	public static void keyReleased(KeyEvent arg0) {
		char c = arg0.getKeyChar();
		System.out.print("Released "+c+"\n");
		switch (c) {
		case 'z':
			mouvY++;
			break;
		case 's':
			mouvY--;
			break;
		case 'd':
			mouvX--;
			break;
		case 'q':
			mouvX++;
			break;
		}
	}

	public static void keyTyped(KeyEvent arg0) {
		char c = arg0.getKeyChar();
		System.out.print("Typed "+c+"\n");
	}

	public static void mouseClicked(MouseEvent arg0) {
	}

	public static void mouseEntered(MouseEvent arg0) {

	}

	public static void mouseExited(MouseEvent arg0) {

	}

	public static void mousePressed(MouseEvent arg0) {
	}

	public static void mouseReleased(MouseEvent arg0) {
	}
	
	private static void dessin() {
		
		fenetre.content.repaint(); // on appelle dessin depuis System
		//dessin appelle la fonction repaint de fenetre
		//fenetre va alors appeler affichage de system en lui donnant le Graphics
	}
}
