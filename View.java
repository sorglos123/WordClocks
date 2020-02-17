package cs18_1_clock;

import java.awt.*;

import javax.swing.*;

public class View extends JFrame {
	JSpinner counter;
	JPanel clock;
	JPanel p;
	JFrame f;

	public void initialise(Controller c) {

		f = new JFrame();
		f.setTitle("Weltzeituhr");
		f.setDefaultCloseOperation(EXIT_ON_CLOSE);

		JLabel jlPic = new JLabel();
		String image = "C:\\Users\\Sasch\\Documents\\OneDrive\\BA_Informatik\\eclipse_workspace_2020\\UI\\src\\cs18_1_clock\\uhr.jpeg";
		ImageIcon imgClock = new ImageIcon(image);

		jlPic.setIcon(imgClock);

		f.add(jlPic, BorderLayout.WEST);

		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 64);

		BorderLayout lm = new BorderLayout(); // HIer könnte ggf. was falls schein Aufgabe 2 a+b
		// BoxLayout boxl = new BoxLayout(f, MAXIMIZED_HORIZ); // HIer könnte ggf. was
		// falls schein Aufgabe 2 a+b

		counter = new JSpinner();
		SpinnerModel sm = new SpinnerNumberModel(0, 0, 5, 1);
		counter.setModel(sm);
		Dimension counterSize = new Dimension(400, 100);
		counter.setPreferredSize(counterSize);
		counter.setFont(font);
		counter.setToolTipText("Erzeugt oder löscht eine Uhr");
		counter.addChangeListener(c);

		p = new JPanel();
		p.setLayout(lm); // HIer könnte ggf. was falls schein Aufgabe 2 a+b
		clock = new JPanel();
		clock.setLayout(new BoxLayout(clock, BoxLayout.Y_AXIS)); // HIer könnte ggf. was falls schein Aufgabe 2 a+b

		p.add(counter, BorderLayout.SOUTH);
		p.add(clock);

		f.add(p, BorderLayout.EAST);

		f.pack(); // Autosize the window fitting for the elements
		f.setVisible(true);

	}

}
