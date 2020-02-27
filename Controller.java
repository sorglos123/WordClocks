package cs18_1_clock;

import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class Controller implements ChangeListener {

	View view;

	public void initialise(View v) {
		this.view = v;
	}

	public void stateChanged(ChangeEvent arg0) {
		int clockValue = (int) this.view.counter.getValue();
		int componentcount = this.view.clock.getComponentCount();
		int diff = clockValue - componentcount;

		if (diff < 0) { // Mehr clocks als counter value
			diff = Math.abs(diff);
			for (int i = 0; i < diff; i++) {
				this.view.clock.remove(i);

			}

			// Nutzen Sie im anderen Fall ebenfalls eine Zählschleife, um die geforderte
			// Anzahl
			// vorhandener „Display“-Objekte aus der „clocks“-Uhrenkachel der View zu
			// löschen (remove)!

		} else if (diff > 0) { // höherer counter value

			for (int i = 0; i < diff; i++) {

				Display display = new Display();
				this.view.clock.add(display);
			//	System.out.println("es sollte eine box erscheinen");

			}

			// Nutzen Sie im einen Fall eine Zählschleife, um entsprechend viele
			// „Display“-Objekte neu zu
			// erstellen und der „clocks“-Uhrenkachel der View hinzuzufügen! [2]

		}
		this.view.f.pack();

		this.view.f.repaint();

	}

}
