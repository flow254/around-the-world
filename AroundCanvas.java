//Hadjara Gado and Sam Kamau
//cs201 final project
import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;

@SuppressWarnings("serial")

class AroundCanvas extends Canvas implements MouseListener{
	//intance variables
	static boolean gameOver; //check if the game is over
	public AroundCanvas(String question) {
		// TODO Auto-generated constructor stub
		question = Around.myquestion; //write the appropriate question in the canvas



	}
	public void paint (Graphics g) {
		Dimension d = getSize();
		int width = d.width;
		int pointsLeft = 300 - Around.scoreKeeper;
		int questions = pointsLeft/15;
		if (gameOver == true) { //check if the game is over
		g.setColor(Color.white);
		g.setFont(new Font ("TimesRoman", Font.PLAIN, 100));
		g.drawString("Game Over!", width/4, 300 );
		g.drawString("Your score: ", width/5, 400);
		g.drawString(Integer.toString(Around.scoreKeeper), width/5 + 500, 400);
				if (pointsLeft < 50){
					g.drawString("You only need", width/5, 500);
					g.drawString(Integer.toString(questions) + " Questions", width/5 + 650, 500);
					g.drawString("To be in the top 1% of players!", width/5, 600);
				}
				else if (pointsLeft <=100) {
					g.drawString("Good try :)", width/5 + 100, 500);
					g.drawString("Try again to make it to the top 5% of players!", width/5 - 400, 600);
				}
				else {
					
					g.drawString("Better luck next time. Thanks for traveling!", width/5-300, 500);
					
				}
		}
		else {
		g.setColor(Color.black);
		int size = 400; //all images are 400X400
		int border = 60;
		g.drawImage(Around.map, size, border, this);//show the image
		g.setFont(new Font ("TimesRoman", Font.PLAIN, 30));
		g.drawString(Around.myquestion, width/4, 500 );//write the question
		}
	}

	//repaint the canvas
	public void nextQuestion() {
		repaint();
	}
	public void mouseReleased(MouseEvent event) { }
    public void mouseClicked(MouseEvent event) { }
    public void mouseEntered(MouseEvent event) { }
    public void mouseExited(MouseEvent event) { }
    public void mousePressed(MouseEvent event) { }
}
