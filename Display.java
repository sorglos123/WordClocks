package cs18_1_clock;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.beans.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;

import java.util.TimeZone;

import javax.swing.*;
import javax.swing.border.Border;

public class Display extends JPanel implements java.io.Serializable, PropertyChangeListener, ActionListener {

	// Automatic serialization, implemented by the Serializable interface. The Java
	// serialization software serializes the entire object, except transient and
	// static fields.
	// Customized serialization. Selectively exclude fields you do not want
	// serialized by marking with the transient (or static) modifier.
	// Customized file format, implemented by the Externalizable interface and its
	// two methods. Beans are written in a specific file format.

	transient SimpleDateFormat formatter;
	String date;
	JLabel label;
	transient javax.swing.Timer timer;

	public Display() {

		formatter = new SimpleDateFormat("dd.MM.yy HH:mm:ss");
		timer = new Timer(100,  this);
		timer.start();

		Font font = new Font(Font.SANS_SERIF, Font.BOLD, 48);

		String comboBox[] = { "Asia/Bangkok", "Asia/Beirut", "Asia/Damascus", "Asia/Istanbul", "Asia/Jakarta",
				"Asia/Shanghai", "Asia/Tokyo", "Europe/Berlin", "Europe/Lisbon", "Europe/Moscow" }; // auf .txt
																									// verweisen lassen

		JComboBox zonen = new JComboBox<String>(comboBox);
		zonen.setSelectedIndex(7);
		zonen.addPropertyChangeListener(this);

		label = new JLabel();
		label.setForeground(Color.RED);
		label.setFont(font);
		label.setText(date);

		Dimension preferredSize = new Dimension(600, 120);

		this.setPreferredSize(preferredSize);
		this.setBackground(Color.LIGHT_GRAY);

		Border greenline = BorderFactory.createLineBorder(Color.GREEN, 5);

		this.setBorder(greenline);
		this.setLayout(new BorderLayout());
		this.add(zonen, BorderLayout.SOUTH);
		this.add(label);
	}

	@Override
	public void propertyChange(PropertyChangeEvent evt) {
		// TODO Auto-generated method stub

	}

	public String getTimeZone() {
		TimeZone c = formatter.getTimeZone();
		String zeitZoneKette = c.getDisplayName();

		return zeitZoneKette;
	}

	public void setTimeZone(String s) {
		
		formatter.setTimeZone(TimeZone.getTimeZone(s));

	}

	public String getDate() {
		DateFormat df;
		//df.parse
		return date;
		
		/*Erzeugen Sie in der „get“-Methode zum Datum via statischer Methode der Klasse
		„DateFormat“ zunächst eine Instanz! Nutzen Sie dann deren „parse“-Methode! Übergeben Sie
		ihr den aktuellen Wert des „date“-Attributes der „Display“-Klasse! Verwenden Sie das somit
		bestimmte Datum als Rückgabewert! [2]*/
	}

	public void setDate(String date) {
		this.date = date;
	}

	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		
	}

}
