package tp;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;

public class Calculadora {

	private JFrame frmCalculadora;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Calculadora window = new Calculadora();
					window.frmCalculadora.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Calculadora() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmCalculadora = new JFrame();
		frmCalculadora.setTitle("Calculadora");
		frmCalculadora.setBounds(100, 100, 450, 300);
		frmCalculadora.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCalculadora.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("1");
		btnNewButton.setBounds(38, 38, 89, 23);
		frmCalculadora.getContentPane().add(btnNewButton);
	}
}
