import javax.swing.*;

public class Scratch {
	public static void main(String[] args) {
		JFrame window = new JFrame("Test");

		window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		JLabel message = new JLabel("This is a label");

		window.add(message);
		window.setSize(600, 200);
		window.setVisible(true);

	}
}
