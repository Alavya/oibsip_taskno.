import java.awt.*;  
import java.awt.event.*;  
import javax.swing.*;

class OnlineExam extends JFrame implements ActionListener {
	JButton btnNext, btnBookmark;
	JLabel label;
	ButtonGroup bg;
	int m[] = new int[10];
	JRadioButton radioButton[] = new JRadioButton[5];
	int current = 0,count = 0, x = 1, y = 1, now = 0;

	OnlineExam(String s) {
		super(s);
		label = new JLabel();
		add(label);
		bg = new ButtonGroup();
		
		for (int i = 0; i < 5; i++) {
			radioButton[i] = new JRadioButton();
			add(radioButton[i]);
			bg.add(radioButton[i]);
		}
		
		btnNext = new JButton("Next Question");
		btnBookmark = new JButton("Bookmark Question");
		btnNext.addActionListener(this);
		btnBookmark.addActionListener(this);
		add(btnNext);
		add(btnBookmark);
		set();
		label.setBounds(30, 40, 450, 20);
		radioButton[0].setBounds(50, 80, 450, 20);
		radioButton[1].setBounds(50, 110, 200, 20);
		radioButton[2].setBounds(50, 140, 200, 20);
		radioButton[3].setBounds(50, 170, 200, 20);
		btnNext.setBounds(100, 240, 150, 30);
		btnBookmark.setBounds(270, 240, 200, 30);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLayout(null);
		setLocation(250, 100);
		setVisible(true);
		setSize(700,600); 
		Color c = new Color(255,150,0);
		getContentPane().setBackground(c); 
	}


	/* handle all event */
	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == btnNext) {
			if (qcheck())
				count = count + 1;
			current++;
			set();
			if (current == 14) {
				btnNext.setEnabled(false);
				btnBookmark.setText("Result");
			}
		}
		
		if (e.getActionCommand().equals("Bookmark Question")) {
			JButton bk = new JButton("Bookmark " + x);
			bk.setBounds(480, 20 + 30 * x, 150, 30);
			add(bk);
			bk.addActionListener(this);
			m[x] = current;
			x++;
			current++;
			set();
			if (current == 10)
				btnBookmark.setText("Score");
			setVisible(false);
			setVisible(true);
		}
		
		for (int i = 0, y = 1; i < x; i++, y++) {
			if (e.getActionCommand().equals("Bookmark" + y)) {
				if (qcheck())
					count = count + 1;
				now = current;
				current = m[y];
				set();
				((JButton) e.getSource()).setEnabled(false);
				current = now;
			}
		}

		if (e.getActionCommand().equals("Result")) {
			if (qcheck())
				count = count + 1;
			current++;
			JOptionPane.showMessageDialog(this,"You have answered " + count + " Questions correctly" );
			System.exit(0);
		}
	}


	/* SET Questions with options */
	void set() {
		radioButton[4].setSelected(true);
		if (current == 0) {
			label.setText("1)Who is known as father of Java Programming Language?");
			radioButton[0].setText("James Gosling");
			radioButton[1].setText("M.P Java");
			radioButton[2].setText("Charel Babbage");
			radioButton[3].setText("Blais Pascal");
		}
		if (current == 1) {
			label.setText("2)In java control statements break, continue, return, try-catch-finally and assert belongs to?");
			radioButton[0].setText("Selection statements");
			radioButton[1].setText("Loop Statements");
			radioButton[2].setText("Transfer statements");
			radioButton[3].setText(" Pause Statement");
		}
		if (current == 2) {
			label.setText("3)Which provides runtime environment for java byte code to be executed?");
			radioButton[0].setText("JDK");
			radioButton[1].setText("JVM");
			radioButton[2].setText("JRE");
			radioButton[3].setText("JAVAC");
		}
		if (current == 3) {
			label.setText("4)What is byte code in Java?");
			radioButton[0].setText("Code generated by a Java compiler");
			radioButton[1].setText("Code generated by a Java Virtual Machine");
			radioButton[2].setText("Name of Java source code file");
			radioButton[3].setText("Block of code written inside a class");
		}
		if (current == 4) {
			label.setText("5)Which of the following are not Java keywords ?");
			radioButton[0].setText("double");
			radioButton[1].setText("switch");
			radioButton[2].setText("then");
			radioButton[3].setText("instanceof");
		}
		if (current == 5) {
			label.setText("6)Which of these have highest precedence?");
			radioButton[0].setText("()");
			radioButton[1].setText("++");
			radioButton[2].setText("*");
			radioButton[3].setText(">>");
		}
		if (current == 6) {
			label.setText("7)Which of these is returned by operator '&'?");
			radioButton[0].setText("Integer");
			radioButton[1].setText("Character");
			radioButton[2].setText("Boolean");
			radioButton[3].setText("Float");
		}
		if (current == 7) {
			label.setText("8)Data type long literals are appended by _____");
			radioButton[0].setText("Uppercase L");
			radioButton[1].setText("Lowercase L");
			radioButton[2].setText("Long");
			radioButton[3].setText("Both A and B");
		}
		if (current == 8) {
			label.setText("9)Which variables are created when an object is created with the use of the keyword 'new' and destroyed when the object is destroyed?");
			radioButton[0].setText("Local variables");
			radioButton[1].setText("Instance variables");
			radioButton[2].setText("Class Variables");
			radioButton[3].setText("Static variables");
		}
		if (current == 9) {
			label.setText("10)Java language was initially called as ________");
			radioButton[0].setText("Sumatra");
			radioButton[1].setText("J++");
			radioButton[2].setText("Oak");
			radioButton[3].setText("Pine");
		}

		label.setBounds(30, 40, 450, 20);
		for (int i = 0, j = 0; i <= 90; i += 30, j++)
			radioButton[j].setBounds(50, 80 + i, 200, 20);
	}

	/* declare right answers. */
	boolean qcheck() {
		if (current == 0)
			return (radioButton[0].isSelected());
		if (current == 1)
			return (radioButton[2].isSelected());
		if (current == 2)
			return (radioButton[1].isSelected());
		if (current == 3)
			return (radioButton[0].isSelected());
		if (current == 4)
			return (radioButton[2].isSelected());
		if (current == 5)
			return (radioButton[0].isSelected());
		if (current == 6)
			return (radioButton[1].isSelected());
		if (current == 7)
			return (radioButton[3].isSelected());
		if (current == 8)
			return (radioButton[1].isSelected());
		if (current == 9)
			return (radioButton[2].isSelected());                 
		return false; 
	}

	public static void main(String s[]) {
		new OnlineExam("Online Examination");
	}
}