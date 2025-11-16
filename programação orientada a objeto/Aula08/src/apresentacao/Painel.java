package apresentacao;

import java.awt.Color;
import java.awt.Graphics;

import javax.swing.JPanel;

public class Painel extends JPanel {
	private static final long serialVersionUID = 1L;

	public void paintComponent(Graphics g) { // tela (800, 600)
		// Coluna, linha, largura, altura
		// Chão
		g.setColor(Color.green);
		g.fillRect(0, 400, 800, 200);
		
		// Céu
		g.setColor(Color.cyan);
		g.fillRect(0, 0 , 800, 400);
		
		// Sol
		g.setColor(Color.orange);
		g.fillOval(650, 50, 100, 100);
		g.setColor(Color.yellow);
		g.fillOval(660, 60, 80, 80);
		
		//  Frente da casa
		g.setColor(Color.red);
		g.drawRect(70, 350, 50, 100);
		
		// Telhado da frente da casa
		g.setColor(Color.red);
		g.drawLine(70, 350, 95, 300);
		g.drawLine(120, 350, 95, 300);
		
		// Lateral da casa
		g.setColor(Color.red);
		g.drawLine(120, 450, 250, 400);
		g.drawLine(250, 300, 250, 400);
		g.drawLine(120, 350, 250, 300);
		
		// Telhado da lateral da casa
		g.setColor(Color.red);
		g.drawLine(95, 300, 220, 260);
		g.drawLine(220, 260, 250, 300);
		
		// Boneco cabeçudo
		g.setColor(Color.black);
		g.fillOval(600, 350, 30, 30); // Cabeça
		g.drawLine(615, 380, 615, 430); // Tronco
		g.drawLine(590, 400, 640, 400 ); // Braços
		g.drawLine(615, 430, 600, 460); // Perna esquerda
		g.drawLine(615, 430, 630, 460); // Perna Direita
	}
}
