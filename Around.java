//Hadjara Gado and Sam Kamau
//Cs201 final project


import java.applet.*;
import java.awt.*;
import java.awt.event.*;
import java.util.Random;
import java.util.Vector;
@SuppressWarnings("serial")

public class Around extends Applet implements ActionListener, Runnable {
	//instance variables
	boolean isCorrect; //check if the answer clicked is correct
	AroundCanvas A; //canvas that allows us to show image
	Button Button1, Button2 , Button3 , Button4; //buttons for the answer choices
	protected Label timer; //check and show the time to the player
	String chosenAnswer;// the button clicked by the player
	Thread t; //to set the time
	long starttime; //check the time the game started
	static Image map; //the image we want to show
	static Random rand = new Random();//import random
	static int index  = rand.nextInt(20) + 0;; //an index that will relate questions, choices and answers
	static String myquestion;//question that is chosen
	Vector checkIndex;//vector that keep track of all the questions asked
	int timeRemaining; //check the time remained
	int score; //calculate the score for the question
	static int scoreKeeper;//updates the total score
	static int highScore; //keeps track of the high score for the game
	

	//colors
	static final Color black = Color.black;
    static final Color white = Color.white;
    static final Color red = Color.red;
    static final Color blue = Color.blue;
    static final Color yellow = Color.yellow;
    static final Color orange = Color.orange;
    static final Color lblue = new Color(50, 200, 255);
    static final Color dred = new Color(160, 0, 100);
    static final Color dgreen = new Color(0, 120, 90);
    static final Color dblue = Color.blue.darker();

  //show the applet and set the for the player to play game
	public void init () {
		setFont(new Font("TimesRoman", Font.BOLD, 28));
		Panel p1 = new Panel(); //panel to display the time remaining
		p1.setLayout(new BorderLayout());
		p1.setBackground(lblue);
		timer = new Label("xxxxxxxxxxxx"); // leave enough room for the time
        timer.setBackground(lblue);
        timer.setAlignment(Label.CENTER);
		p1.add("Center", timer);
		setLayout(new BorderLayout());
		setBackground(lblue);
		setLayout(new BorderLayout());
		Button1 = new Button(displayChoice(index, 1));
		Button1.setBackground(Color.white);
		Button1.addActionListener(this);
		Button2 = new Button(displayChoice(index, 2));
		Button2.setBackground(Color.white);
		Button2.addActionListener(this);
		Button3 = new Button(displayChoice(index, 3));
		Button3.setBackground(Color.white);
		Button3.addActionListener(this);
		Button4 = new Button(displayChoice(index, 4));
		Button4.setBackground(Color.white);
		Button4.addActionListener(this);
		Panel p = new Panel();//takes the botton and the choices for questions
		p.setLayout(new GridLayout(2, 2, 10, 10));
		p.setBackground(lblue);
		p.add(Button1);
		p.add(Button2);
		p.add(Button3);
		p.add(Button4);
		add("South", p );
		map = getImage(getDocumentBase(), images[index] ); //the image related to the question
		myquestion = questions[index];
		A = new AroundCanvas(myquestion);// the canvas for the image and question to appear
		A.setBackground(lblue);
		A.addMouseListener(A);
		add("North", p1);
		add("Center", A);
		checkIndex = new Vector();
		checkIndex.add(index); //collect all the index previously chosen
	}
	//string of all the questions available
	String Q1 = "Which map of a country is this image above?";
	String Q2 = "In what city is this famous monument in?";
	String Q3 = "What is the name of these waterfalls between Zambia and Zimbabwe?";
	String Q4 = "What is this desert located in North Africa?";
	String Q5 = "What is this lake situated between Bolivia and Peru? ";
	String Q6 = "What is this tiny country located in Europe called?";
	String Q7 = "This country has nice beaches and was finalist at the "
			+ " FIFA world cup 2018.";
	String Q8 = "In what city in India can we visit the Taj Mahal?";
	String Q9 = "Where can you find this magnificent building?";
	String Q10 = "What is the name of this musuem located in Istanbul?";
	String Q11 = "In what state is Mount Rushmore located?";
	String Q12 = "What is the name of this musuem located in Amsterdam "
			+ " named  after a famous painter?";
	String Q13 = "What is this wonder of the world?";
	String Q14 = "What is the name of this pyramid?";
	String Q15 = "What is the name of this holy city in Islam?";
	String Q16 = "What is the nickname of the Great Bell of this clock located in London?";
	String Q17 = "What is the name of this city famous for its wine?";
	String Q18 = "In what city can we find the Colosseum?";
	String Q19 = "Where can we visit the Little Mermaid?";
	String Q20 = "What is the name of this tower in Dubai";


	String[] questions = {Q1, Q2, Q3, Q4, Q5, Q6, Q7, Q8, Q9, Q10,Q11,
			Q12, Q13, Q14, Q15, Q16, Q17, Q18, Q19, Q20 };





	//string of all the images available
	String im1 = "US.jpg";
	String im2 = "eiffel.jpg";
	String im3 = "victoria.jpg";
	String im4 = "Sahara.jpg";
	String im5 = "mytiticaca.jpg";
	String im6 = "andor.png";
	String im7 = "croatia.jpg";
	String im8 = "Taj.jpg";
	String im9 = "SydneyOpera.jpg";
	String im10 = "HagiaSophia.jpg";
	String im11 = "Mount.jpg";
	String im12 = "Van.jpg";
	String im13 = "Great.jpg";
	String im14 = "Giza.jpg";
	String im15 = "Mecca.jpg";
	String im16 = "BigBen.jpg";
	String im17 = "Bordeaux.jpg";
	String im18 = "Col.jpg";
	String im19 = "Mermaid.jpg";
	String im20 = "Burj.jpg";
	String[] images = {im1, im2, im3, im4, im5, im6, im7, im8, im9,
			im10,im11, im12, im13, im14, im15, im16, im17, im18, im19, im20};

	//string of all the answers available
	 	String A1 = "United States";
		String A2 = "Paris";
		String A3 = "Victoria";
		String A4 = "Sahara";
		String A5 = "Titicaca";
		String A6 = "Andorra";
		String A7 = "Croatia";
		String A8 = "Agra";
		String A9 = "Sydney";
		String A10 = "Hagia Sophia";
		String A11 = "South Dakota";
		String A12 = "Van Gogh";
		String A13 = "Great Wall of China";
		String A14 = "Giza";
		String A15 = "Mecca";
		String A16 = "Big Ben";
		String A17 = "Bordeaux";
		String A18 = "Rome";
		String A19 = "Copenhagen";
		String A20 = "Burj Al Arab";
		String[] answers = {A1, A2, A3, A4, A5, A6, A7, A8, A9, A10, A11, A12, A13,
				A14, A15, A16, A17, A18, A19, A20};


		//string of all possible choices
		String [] choices1 = {"United States", "Canada", "China", "Australia"};
		String [] choices2 = {"London", "Paris", "Tokyo", "New York"};
		String [] choices3 = {"Zambezi", "Niagara", "Victoria", "Congo"};
		String [] choices4 = {"Kalahari", "Sahara", "Syrian", "Arabian"};
		String [] choices5 = {"Titicaca", "Chad","Maracaibo", "Baikal"};
		String [] choices6 = {"Andorra", "Liechtenstein", "Vatican", "Monaco"};
		String [] choices7 = {"France", "Nigeria","Croatia", "Germany"};
		String [] choices8 = { "Mumbai", "Pune", "Agra","Kolkata"};
		String [] choices9 = {"Melbourne", "Sydney", "Auckland", "Berlin"};
		String [] choices10 = {"Hagia Sophia", "Sultan Ahmet", "St. Eirene", "Reims cathedral"};
		String [] choices11 = { "North Carolina", "South Dakota","Arizona", "Missouri"};
		String [] choices12 = { "Da Vinci", "Van Gogh","Picasso", "MichelAngelo"};
		String [] choices13 = {"Great Wall of China", "Mayan ruins", "Great Zimbabwe", "Machu Pichu"};
		String [] choices14 = { "Khafre", "Menkaure", "Giza", "Bent"};
		String [] choices15 = {"Jerusalem", "Medina", "Mecca", "Vatican"};
		String [] choices16 = {"Big Ben", "Space Niddle", "Canton tower", "Macau tower"};
		String [] choices17 = { "Tuscany", "Barcelona", "Bordeaux","Marseille"};
		String [] choices18 = {"Venice", "Rome", "Athens", "Vienna"};
		String [] choices19 = { "Oslo", "Stockholm", "Helsinki", "Copenhagen"};
		String [] choices20 = {"Burj Khalifa", "Burj Al Arab", "Abraj Al Bait", "Kingdom Centre"};

		String [] [] masterchoice = {choices1, choices2, choices3, choices4, choices5, choices6, choices7,
				    choices8, choices9, choices10, choices11, choices12, choices13, choices14, choices15, choices16,
				    choices17, choices18, choices19, choices20};





		//display choices in the different buttons
	public String displayChoice(int question, int number) {

		return masterchoice[question][number - 1];
	}
	//check if the answer clicked is the correct answer to the question
	public boolean checkCorrect(String answerPicked , String actualAnswer) {
		return answerPicked == actualAnswer;

			}


	//check for each button if the button clicked is correct or not
	public void actionPerformed(ActionEvent e) {

        if (e.getSource() == Button1 ) {
            chosenAnswer = Button1.getActionCommand();
            isCorrect = checkCorrect(chosenAnswer, answers[index]);
            showCorrect(Button1);//show related color
            checkScore ();

          }
        else if (e.getSource() == Button2) {
                chosenAnswer = Button2.getActionCommand();
                isCorrect = checkCorrect(chosenAnswer, answers[index]);
                showCorrect(Button2); //show related color
                checkScore ();
        }
        else if (e.getSource() == Button3 ) {
                chosenAnswer = Button3.getActionCommand();
                isCorrect = checkCorrect(chosenAnswer, answers[index]);
                showCorrect(Button3); //show related color
                checkScore ();
        }
        else if (e.getSource() == Button4) {
                chosenAnswer = Button4.getActionCommand();
                isCorrect = checkCorrect(chosenAnswer, answers[index]);
                showCorrect(Button4);//show related color
                checkScore ();
        }

      //show correct answer in green

        	try {
        		Thread.sleep(1000); // pause for 1 sec
        	} 	catch (InterruptedException f) {
        	}

        	if (Button1.getActionCommand() == answers[index]) {
        		isCorrect = true;
        		showCorrect(Button1);
        	}
        	else if (Button2.getActionCommand() == answers[index]) {
        		isCorrect = true;
        		showCorrect(Button2);
        	}
        	else if (Button3.getActionCommand() == answers[index]) {
        		isCorrect = true;
        		showCorrect(Button3);
        	}
        	else if (Button4.getActionCommand() == answers[index]) {
        		isCorrect = true;
        		showCorrect(Button4);
        	}
        	try {
        		Thread.sleep(1000); //sleep for 1 sec
        	} catch (InterruptedException f) {
        	}
        	 //restart timer
        	start();
        	resetColors();
        	newQuestion();
	}

      //keep track of the time since the start of the game
	public void start() {
        t = new Thread(this);
        t.start();
        starttime = System.currentTimeMillis(); // record start time to reset timer

    }
	//check the score of the game
	public void checkScore () {
		if(isCorrect == true) {
			score = timeRemaining *2;
			scoreKeeper += score;
				}
			}

//check the time and displays the time remaining
    public void run() {
        Thread currentThread = Thread.currentThread();
        while (currentThread == t) {
            try {
                Thread.sleep(200); // wait 0.2 sec
            } catch (InterruptedException e) { // do nothing
            }
            double timeElapsed = ((System.currentTimeMillis() - starttime)/ 1000); //time since game started
            timeRemaining = 15 - (int)timeElapsed; //how many time is remained for each question
            if (timeRemaining >= 0) {
            timer.setText("Time remaining: " + timeRemaining );//display the time to player
            }
            else if (timeRemaining <= 0){
            	timer.setText("Time's up!"); //show if the time is up
            	resetColors();
            	newQuestion();
                starttime = System.currentTimeMillis(); // record start time to reset timer
            }
        }
    }
	//show if the answer is correct and display green if it is and red if not
	public void showCorrect (Button a) {
		if (isCorrect == true) {
			a.setBackground(Color.green);

		}
		else  {
			a.setBackground(red);

		}

	}
	//keep track of every index chosen so that the same question does not appear
	//multiple times
	public void checkmyIndex() {
		if (checkIndex.size() < 10) {// each game round is limited to 10 questions
			while (checkIndex.contains(index) == true) {

				index = rand.nextInt(20) + 0; //choose a new number that was not chosen
				//max is 20 and the minimum is 0
			}
			checkIndex.add(index);
		}
		else {//if 10 questions are asked stop the game
			AroundCanvas.gameOver = true; //write Game Over on canvas
			A.nextQuestion(); //repaint the canvas
			remove(1);//remove the time that was being displayed
			remove(0);//remove the panel that displayed choices

		}

		}


	// change the image to the one corresponding to the next question
	public void changeImage() {
	map = getImage(getDocumentBase(), images[index] );

	}
	//change the to the appropriate one correlated to the image
	public void changeQuestion( ) {
		myquestion = questions[index];

	}
	//change the choices to the one related to the questions
	public void changeChoices() {
		Button1.setLabel(displayChoice(index, 1));
		Button2.setLabel(displayChoice(index, 2));
		Button3.setLabel(displayChoice(index, 3));
		Button4.setLabel(displayChoice(index, 4));

	}
	//reset the colors of the buttons after showing if the answer is correct or not
	public void resetColors() {
		Button1.setBackground(Color.white);
		Button2.setBackground(Color.white);
		Button3.setBackground(Color.white);
		Button4.setBackground(Color.white);
	}
    //go the next question if a button is clicked or the time is up
	public void newQuestion() {
		checkmyIndex();
		changeImage();
        changeQuestion();
        changeChoices();
        A.nextQuestion();//repaint the canvas
	}



}
