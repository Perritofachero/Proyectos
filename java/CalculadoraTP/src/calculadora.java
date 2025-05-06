import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Panel;
import java.awt.Color;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JCheckBox;

public class calculadora extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                	calculadora frame = new calculadora();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public calculadora() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(100, 100, 349, 489);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        contentPane.setLayout(null);

        Panel panel = new Panel();
        panel.setBackground(new Color(41, 41, 41));
        panel.setBounds(0, 0, 333, 100);
        contentPane.add(panel);
        panel.setLayout(null);
        
        Panel panel_2 = new Panel();
        panel_2.setBackground(new Color(40, 106, 0));
        panel_2.setBounds(10, 10, 313, 80);
        panel.add(panel_2);
        
                JLabel lblNewLabel = new JLabel("");
                panel_2.add(lblNewLabel);
                lblNewLabel.setForeground(new Color(255, 255, 255));
                lblNewLabel.setBackground(new Color(240, 240, 240));

        Panel panel_1 = new Panel();
        panel_1.setBackground(new Color(0, 128, 192));
        panel_1.setBounds(0, 100, 333, 350);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JButton btnNewButton = new JButton("Suma");
        btnNewButton.setBackground(new Color(240, 240, 240));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero: "));
                int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero: "));
                lblNewLabel.setText(String.valueOf(a + b));
            }
        });
        btnNewButton.setBounds(10, 11, 80, 80);
        panel_1.add(btnNewButton);
        
        JButton btnResta = new JButton("Resta");
        btnResta.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero: "));
                 int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero: "));
                 lblNewLabel.setText(String.valueOf(a - b));
        	}
        });
        btnResta.setBounds(128, 11, 80, 80);
        panel_1.add(btnResta);
        
        JButton btnMultiplicacion = new JButton("Multiplicacion");
        btnMultiplicacion.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero: "));
                 int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero: "));
                 lblNewLabel.setText(String.valueOf(a * b));
        	}
        });
        btnMultiplicacion.setBounds(243, 11, 80, 80);
        panel_1.add(btnMultiplicacion);
        
        JButton btnDivision = new JButton("Division");
        btnDivision.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		 int a = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el primer numero: "));
                 int b = Integer.parseInt(JOptionPane.showInputDialog("Ingrese el segundo numero: "));
                 lblNewLabel.setText(String.valueOf(a / b));
        	}
        });
        btnDivision.setBounds(10, 112, 80, 80);
        panel_1.add(btnDivision);
        
        JButton btnPotencia = new JButton("Potencia");
        btnPotencia.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		double base = Double.parseDouble(JOptionPane.showInputDialog("Ingrese la base: "));
                double exponente = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el exponente: "));
                double resultado = Math.pow(base, exponente);
                lblNewLabel.setText(Double.toString(resultado));
        	}
        });
        btnPotencia.setBounds(128, 112, 80, 80);
        panel_1.add(btnPotencia);
        
        JButton btnRaiz = new JButton("Raiz");
        btnRaiz.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		
        		double numero = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el número: "));
                double n = Double.parseDouble(JOptionPane.showInputDialog("Ingrese el grado de la raíz: "));
                double resultado = Math.pow(numero, 1.0 / n);
                lblNewLabel.setText(Double.toString(resultado));
        	}
        });
        btnRaiz.setBounds(243, 112, 80, 80);
        panel_1.add(btnRaiz);
        
        JButton btnNewButton_4 = new JButton(".");
        btnNewButton_4.setBounds(10, 203, 80, 80);
        panel_1.add(btnNewButton_4);
        
        JButton btnNewButton_5 = new JButton(".");
        btnNewButton_5.setBounds(128, 203, 80, 80);
        panel_1.add(btnNewButton_5);
        
        JButton btnNewButton_6 = new JButton(".");
        btnNewButton_6.setBounds(243, 203, 80, 80);
        panel_1.add(btnNewButton_6);

    }
}
