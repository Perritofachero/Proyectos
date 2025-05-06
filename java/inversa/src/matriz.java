import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import java.awt.Color;

public class matriz {

    private JFrame frame;
    private JTextField[][] matrizSuperior;
    private JTextField[][] matrizInferior;

    /**
     * Launch the application.
     */
    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    matriz window = new matriz();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    /**
     * Create the application.
     */
    public matriz() {
        initialize();
    }

    /**
     * Initialize the contents of the frame.
     */
    private void initialize() {
        frame = new JFrame();
        frame.setBounds(50, 50, 580, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        // Initialize matrices
        matrizSuperior = new JTextField[3][3];
        matrizInferior = new JTextField[3][3];

        // Create text fields for the upper matrix
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrizSuperior[i][j] = new JTextField();
                matrizSuperior[i][j].setColumns(10);
                matrizSuperior[i][j].setBounds(10 + j * 75, 60 + i * 75, 65, 65);
                frame.getContentPane().add(matrizSuperior[i][j]);
            }
        }

        // Create text fields for the lower matrix (result matrix)
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                matrizInferior[i][j] = new JTextField();
                matrizInferior[i][j].setColumns(10);
                matrizInferior[i][j].setEditable(false); // Make it non-editable
                matrizInferior[i][j].setBounds(10 + j * 75, 356 + i * 75, 65, 65);
                frame.getContentPane().add(matrizInferior[i][j]);
            }
        }

        // Button to perform operations
        JButton btnOperacion = new JButton("Realizar Operacion");
        btnOperacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                // Perform operation here (for example, sumar matrices)
                sumarMatrices();
            }
        });
        btnOperacion.setBounds(235, 212, 150, 36);
        frame.getContentPane().add(btnOperacion);

        JPanel panel_18 = new JPanel();
        panel_18.setBackground(new Color(0, 128, 64));
        panel_18.setBounds(0, 11, 564, 286);
        frame.getContentPane().add(panel_18);
        panel_18.setLayout(null);
    }

    // Example method to sum two matrices
    private void sumarMatrices() {
        // Assuming both matrices are of size 3x3 for simplicity
        int[][] resultado = new int[3][3];
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                try {
                    int num1 = Integer.parseInt(matrizSuperior[i][j].getText());
                    int num2 = Integer.parseInt(matrizSuperior[i][j].getText());
                    resultado[i][j] = num1 + num2;
                    matrizInferior[i][j].setText(String.valueOf(resultado[i][j]));
                } catch (NumberFormatException e) {
                    // Handle invalid input
                    matrizInferior[i][j].setText("Error");
                }
            }
        }
    }
}
