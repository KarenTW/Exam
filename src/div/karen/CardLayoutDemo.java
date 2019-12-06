package div.karen;
import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class CardLayoutDemo implements ItemListener {
	JPanel cards; // a panel that uses CardLayout
	final static String[] TESTPANEL = {"Test 1", "Test 2", "Test 3", "Test 4", "Test 5"};
	final static String[] Question = { "Q1. Write a function that takes a string as input and returns the string reversed.", 
			"Q2. Given a positive integer num, write a function which returns True if num is a perfect square else False. ", 
			"Q3. Given a set of non-overlapping intervals, insert a new interval into the intervals (merge if necessary). ", 
			"Q4. Given a 2D board and a word, find if the word exists in the grid. ", 
			"Q5. Calculate the sum of two integers a and b, but you are not allowed to use the operator + and" };
	
	JPanel output = new JPanel(new BorderLayout());
	JLabel outputLabel = new JLabel("Output : ");
	final JLabel outputResult = new JLabel("");

	public void addComponentToPane(Container pane) {

		// Put the JComboBox in a JPanel to get a nicer look.
		JPanel comboBoxPane = new JPanel(); // use FlowLayout
		String comboBoxItems[] = { TESTPANEL[0], TESTPANEL[1], TESTPANEL[2], TESTPANEL[3], TESTPANEL[4] };
		JComboBox cb = new JComboBox(comboBoxItems);
		cb.setEditable(false);
		cb.addItemListener(this);
		comboBoxPane.add(cb);

		// Test 1 layout
		JPanel card1 = new JPanel(new BorderLayout());
		JLabel q1Descriptin = new JLabel(Question[0]);
		final JTextField q1Input01 = new JTextField("HelloRakuten");
		JLabel q1InputLabel = new JLabel("Input : ");
		JButton q1Submit = new JButton("Submit");
		card1.add(q1Descriptin, BorderLayout.PAGE_START);
		card1.add(q1InputLabel, BorderLayout.WEST);
		card1.add(q1Input01, BorderLayout.CENTER);
		card1.add(q1Submit, BorderLayout.PAGE_END);

		// Test 2 layout
		JPanel card2 = new JPanel(new BorderLayout());
		JLabel q2Descriptin = new JLabel(Question[1]);
		final JTextField q2Input01 = new JTextField("16");
		JLabel q2InputLabel = new JLabel("Input : ");
		JButton q2Submit = new JButton("Submit");
		card2.add(q2Descriptin, BorderLayout.PAGE_START);
		card2.add(q2InputLabel, BorderLayout.WEST);
		card2.add(q2Input01, BorderLayout.CENTER);
		card2.add(q2Submit, BorderLayout.PAGE_END);

		// Test 3 layout
		final List<Interval> input = new ArrayList<>();
		input.add(new Interval(1, 2));
		input.add(new Interval(3, 5));
		input.add(new Interval(6, 7));
		input.add(new Interval(8, 10));
		input.add(new Interval(12, 16));
		String intervals = "";
		for (Interval orin : input) {
			intervals += ("[" + orin.getStart() + ", " + orin.getEnd() + "] ");
		}
		JPanel card3 = new JPanel(new BorderLayout());
		JLabel q3Descriptin = new JLabel(Question[2]);
		final JTextField q3Input01S = new JTextField("1");
		final JTextField q3Input01E = new JTextField("4");
		JLabel startLabel = new JLabel("Start : ");
		JLabel endLabel = new JLabel("End : ");
		JLabel q3InputLabel = new JLabel("Input : ");
		JTextArea q3Input02 = new JTextArea(intervals);
		JButton q3Submit = new JButton("Submit");
		card3.add(q3Descriptin, BorderLayout.PAGE_START);
		card3.add(q3InputLabel, BorderLayout.WEST);
		JPanel inner03 = new JPanel(null);
		startLabel.setBounds(250, 30, 80, 30);
		endLabel.setBounds(250, 80, 80, 30);
		q3Input01S.setBounds(300, 30, 100, 30);
		q3Input01E.setBounds(300, 80, 100, 30);
		q3Input02.setBounds(0, 0, 200, 150);
		inner03.add(startLabel);
		inner03.add(endLabel);
		inner03.add(q3Input01S);
		inner03.add(q3Input01E);
		inner03.add(q3Input02);
		card3.add(inner03, BorderLayout.CENTER);
		card3.add(q3Submit, BorderLayout.PAGE_END);

		// Test 4 layout
		String board = "";
		int rows = 8;
		int cols = 8;
		char[][] arrayBoard = new char[rows][cols];
		for (int i = 0; i < rows; i++) {
			board += ("[ ");
			for (int j = 0; j < cols; j++) {
				Random r = new Random();
				char c = (char) (r.nextInt(26) + 'a');
				arrayBoard[i][j] = c;
				board += (arrayBoard[i][j] + " ");
			}
			board += ("]\n");
		}
		final char[][] finalBoard = arrayBoard;
		JPanel card4 = new JPanel(new BorderLayout());
		JLabel q4Descriptin = new JLabel(Question[3]);
		final JTextField q4Input01 = new JTextField("abc");
		JLabel q4InputLabel = new JLabel("Input : ");
		JButton q4Submit = new JButton("Submit");

		JTextArea q4Input02 = new JTextArea("" + board);
		q4Input02.setEditable(false);
		card4.add(q4Descriptin, BorderLayout.PAGE_START);
		card4.add(q4InputLabel, BorderLayout.WEST);
		card4.add(q4Input01, BorderLayout.CENTER);
		JPanel inner04 = new JPanel(null);
		JLabel wordLabel = new JLabel("word : ");
		wordLabel.setBounds(250, 30, 50, 30);
		q4Input01.setBounds(300, 30, 100, 30);
		q4Input02.setBounds(0, 0, 150, 150);
		inner04.add(wordLabel);
		inner04.add(q4Input01);
		inner04.add(q4Input02);
		card4.add(inner04, BorderLayout.CENTER);
		card4.add(q4Submit, BorderLayout.PAGE_END);

		// Test 5 layout
		JPanel card5 = new JPanel(new BorderLayout());
		JLabel q5Descriptin = new JLabel(Question[4]);
		final JTextField q5Input01 = new JTextField("16");
		final JTextField q5Input02 = new JTextField("15");
		JLabel q5InputLabel = new JLabel("Input : ");
		JButton q5Submit = new JButton("Submit");
		JLabel aLabel = new JLabel("a : ");
		JLabel bLabel = new JLabel("b : ");
		card5.add(q5Descriptin, BorderLayout.PAGE_START);
		card5.add(q5InputLabel, BorderLayout.WEST);
		JPanel inner05 = new JPanel(null);
		aLabel.setBounds(50, 30, 50, 30);
		bLabel.setBounds(50, 80, 50, 30);
		q5Input01.setBounds(100, 30, 100, 30);
		q5Input02.setBounds(100, 80, 100, 30);
		inner05.add(aLabel);
		inner05.add(bLabel);
		inner05.add(q5Input01);
		inner05.add(q5Input02);
		card5.add(inner05, BorderLayout.CENTER);
		card5.add(q5Submit, BorderLayout.PAGE_END);

		// Create the panel that contains the "cards".
		cards = new JPanel(new CardLayout());
		cards.add(card1, TESTPANEL[0]);
		cards.add(card2, TESTPANEL[1]);
		cards.add(card3, TESTPANEL[2]);
		cards.add(card4, TESTPANEL[3]);
		cards.add(card5, TESTPANEL[4]);

		// create the output panel
		output.add(outputLabel, BorderLayout.WEST);
		output.add(outputResult, BorderLayout.CENTER);

		pane.add(comboBoxPane, BorderLayout.PAGE_START);
		pane.add(cards, BorderLayout.CENTER);
		pane.add(output, BorderLayout.PAGE_END);

		q1Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ReverseString sb = new ReverseString();
				String result = sb.reverse(q1Input01.getText());
				outputResult.setText(result);

			}
		});

		q2Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				PerfectSquareInteger ps = new PerfectSquareInteger();
				boolean result = ps.PerfectSquare(Integer.parseInt(q2Input01.getText()));
				outputResult.setText("" + result);

			}
		});

		q3Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				NonOverlappingInterval no = new NonOverlappingInterval();
				System.out.println(q3Input01S.getText() + " " + q3Input01E.getText());
				Interval newOne = new Interval(Integer.parseInt(q3Input01S.getText()), Integer.parseInt(q3Input01E.getText()));
				List<Interval> result = no.reverse(input, newOne);
				String resultR = "";
				for (Interval in : result) {
					resultR += ("[" + in.getStart() + ", " + in.getEnd() + "] ");
				}
				outputResult.setText("" + resultR);

			}
		});

		q4Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				ExistsWordinBoard ps = new ExistsWordinBoard();
				boolean result = ps.exist(finalBoard, q4Input01.getText());
				outputResult.setText("" + result);

			}
		});

		q5Submit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				CalculateSumWithoutOperator cs = new CalculateSumWithoutOperator();
				int result = cs.getSum(Integer.parseInt(q5Input01.getText()), Integer.parseInt(q5Input02.getText()));
				outputResult.setText("" + result);

			}
		});
	}

	public void itemStateChanged(ItemEvent evt) {
		outputResult.setText("");
		CardLayout cl = (CardLayout) (cards.getLayout());
		cl.show(cards, (String) evt.getItem());
	}

	static void createAndShowGUI() {
		// Create and set up the window.
		JFrame frame = new JFrame("Karen");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CardLayoutDemo demo = new CardLayoutDemo();
		demo.addComponentToPane(frame.getContentPane());

		// Display the window.
		frame.setSize(800, 300);
		frame.setVisible(true);

	}

	public static void main(String[] args) {

		javax.swing.SwingUtilities.invokeLater(new Runnable() {
			public void run() {
				createAndShowGUI();
			}
		});
	}
}