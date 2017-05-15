import java.awt.Dimension;
import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

public class JFenetre extends JFrame implements KeyListener,MouseListener{
	public JPanel content;
	public JFenetre(int dX, int dY) {
		// titre de la fenêtre
		super("Automate");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setResizable(false);
		content = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				// affichage du modèle du jeu
				system.affichage(g);
			}
		};
		// dimension de ce conteneur
		content.setPreferredSize(new Dimension(dX, dY));
		// ajouter le conteneur à la fenêtre
		setContentPane(content);
		// Créer un thread infini
		
		addKeyListener (this);
		addMouseListener(this);
	}
	public void start(){
		Thread thread = new Thread(new Runnable() {
			@Override
			public void run() {
				system.loop();
			}
		});
		// lancer le thread
		thread.start();
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		system.keyPressed(arg0);
		
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		system.keyReleased(arg0);
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		system.keyTyped(arg0);
	}
	@Override
	public void mouseClicked(MouseEvent arg0) {
		system.mouseClicked(arg0);
	}
	@Override
	public void mouseEntered(MouseEvent arg0) {
		system.mouseEntered(arg0);
		
	}
	@Override
	public void mouseExited(MouseEvent arg0) {
		system.mouseExited(arg0);
		
	}
	@Override
	public void mousePressed(MouseEvent arg0) {
		system.mousePressed(arg0);
	}
	@Override
	public void mouseReleased(MouseEvent arg0) {
		system.mouseReleased(arg0);
	}

}