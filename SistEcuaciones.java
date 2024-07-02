package matricesTp;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.border.EmptyBorder;
import java.awt.FlowLayout;
import java.text.DecimalFormat;


public class SistEcuaciones extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JTextField textField;
    private JLabel lblNewLabel_5;
    private JButton btnNewButton_1;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;
    private JTextField textField_4;
    private JTextField textField_5;
    private JTextField textField_6;
    private JTextField textField_7;
    private JTextField textField_8;
    private JTextField textField_9;
    private JTextField textField_10;
    private JTextField textField_11;
    private JLabel lblNewLabel_3;
    private JLabel lblNewLabel_4;
    private JLabel lblNewLabel_6;
    private JLabel lblNewLabel_1;
    private JLabel lblNewLabel_2;
    private JLabel lblNewLabel_7;
    private JLabel lblNewLabel_8;
    private JLabel lblNewLabel_9;
    private JLabel lblNewLabel_10;
    private JButton btnX;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    SistEcuaciones frame = new SistEcuaciones();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public SistEcuaciones() {
    	setTitle("CalculadoraG7");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 20, 497, 700);

        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));
        panel.setBounds(10, 0, 464, 120);
        contentPane.add(panel);
        panel.setLayout(null);
        
        

        JPanel panel_2 = new JPanel();
        panel_2.setAutoscrolls(true);
        FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setVgap(25);
        flowLayout.setHgap(10);
        panel_2.setForeground(Color.BLACK);
        panel_2.setBackground(SystemColor.controlHighlight);
        panel_2.setBounds(10, 11, 444, 100);
        panel.add(panel_2);
        
  
        
        lblNewLabel_3 = new JLabel("");
        lblNewLabel_3.setAutoscrolls(true);
        lblNewLabel_3.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_3.setForeground(new Color(0, 0, 0));
        lblNewLabel_3.setFont(new Font("Tahoma", Font.BOLD, 20));
        panel_2.add(lblNewLabel_3);

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.control);
        panel_1.setBounds(10, 120, 464, 541);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        textField = new JTextField();
        textField.setFont(new Font("Dialog", Font.PLAIN, 16));
        textField.setForeground(new Color(65, 105, 225));
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        textField.setBounds(10, 106, 70, 40);
        panel_1.add(textField);
        textField.setColumns(10);
        

        JButton btnNewButton_1_1 = new JButton("Calcular");
        btnNewButton_1_1.setForeground(new Color(0, 0, 255));
        btnNewButton_1_1.setFocusable(false);
        btnNewButton_1_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_1_1.setBackground(new Color(230, 230, 250));
        btnNewButton_1_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	calcularSuma3x3(e);
            }
        });
        btnNewButton_1_1.setBounds(172, 414, 100, 50);
        panel_1.add(btnNewButton_1_1);
        

        JButton btnNewButton = new JButton("2 x 2");
        btnNewButton.setForeground(new Color(0, 0, 255));
        btnNewButton.setFocusable(false);
        btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton.setBackground(new Color(230, 230, 250));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField_2.setVisible(false);
                textField_4.setVisible(false);
                textField_6.setVisible(false);
                textField_7.setVisible(false);
                textField_8.setVisible(false);
                textField_11.setVisible(false);
                lblNewLabel_2.setVisible(false);
                lblNewLabel_4.setVisible(false);
                lblNewLabel_8.setVisible(false);
                lblNewLabel_9.setVisible(false);
				lblNewLabel_10.setVisible(false);
				btnNewButton_1_1.setVisible(false);
				
            }
        });
        btnNewButton.setBounds(83, 334, 100, 40);
        panel_1.add(btnNewButton);

        btnX = new JButton("3 x 3");
        btnX.setForeground(new Color(0, 0, 255));
        btnX.setFocusable(false);
        btnX.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnX.setBackground(new Color(230, 230, 250));
        btnX.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                textField_2.setVisible(true);
                textField_4.setVisible(true);
                textField_6.setVisible(true);
                textField_7.setVisible(true);
                textField_8.setVisible(true);
                textField_11.setVisible(true);
                lblNewLabel_2.setVisible(true);
                lblNewLabel_8.setVisible(true);
                lblNewLabel_4.setVisible(true);
                lblNewLabel_9.setVisible(true);
                lblNewLabel_10.setVisible(true);
                btnNewButton_1_1.setVisible(true);
                
            }
        });
        btnX.setBounds(258, 334, 100, 40);
        panel_1.add(btnX);
        
     
        

        lblNewLabel_5 = new JLabel("=");
        lblNewLabel_5.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_5.setForeground(new Color(65, 105, 225));
        lblNewLabel_5.setFont(new Font("Consolas", Font.PLAIN, 20));
        lblNewLabel_5.setBounds(306, 106, 70, 40);
        panel_1.add(lblNewLabel_5);

        btnNewButton_1 = new JButton("Calcular");
        btnNewButton_1.setForeground(new Color(0, 0, 255));
        btnNewButton_1.setFocusable(false);
        btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnNewButton_1.setBackground(new Color(230, 230, 250));
        btnNewButton_1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                calcularSuma(e);
            }
        });
        btnNewButton_1.setBounds(172, 415, 100, 50);
        panel_1.add(btnNewButton_1);



        textField_1 = new JTextField();
        textField_1.setFont(new Font("Dialog", Font.PLAIN, 16));
        textField_1.setForeground(new Color(65, 105, 225));
        textField_1.setHorizontalAlignment(SwingConstants.CENTER);
        textField_1.setColumns(10);
        textField_1.setBounds(128, 106, 70, 40);
        panel_1.add(textField_1);

        textField_2 = new JTextField();
        textField_2.setFont(new Font("Dialog", Font.PLAIN, 16));
        textField_2.setForeground(new Color(65, 105, 225));
        textField_2.setHorizontalAlignment(SwingConstants.CENTER);
        textField_2.setColumns(10);
        textField_2.setBounds(246, 106, 70, 40);
        panel_1.add(textField_2);

        textField_3 = new JTextField();
        textField_3.setFont(new Font("Dialog", Font.PLAIN, 16));
        textField_3.setForeground(new Color(65, 105, 225));
        textField_3.setHorizontalAlignment(SwingConstants.CENTER);
        textField_3.setColumns(10);
        textField_3.setBounds(10, 183, 70, 40);
        panel_1.add(textField_3);

        textField_4 = new JTextField();
        textField_4.setFont(new Font("Dialog", Font.PLAIN, 16));
        textField_4.setForeground(new Color(65, 105, 225));
        textField_4.setHorizontalAlignment(SwingConstants.CENTER);
        textField_4.setColumns(10);
        textField_4.setBounds(10, 255, 70, 40);
        panel_1.add(textField_4);

        textField_5 = new JTextField();
        textField_5.setFont(new Font("Dialog", Font.PLAIN, 16));
        textField_5.setForeground(new Color(65, 105, 225));
        textField_5.setHorizontalAlignment(SwingConstants.CENTER);
        textField_5.setColumns(10);
        textField_5.setBounds(128, 183, 70, 40);
        panel_1.add(textField_5);

        textField_6 = new JTextField();
        textField_6.setFont(new Font("Dialog", Font.PLAIN, 16));
        textField_6.setForeground(new Color(65, 105, 225));
        textField_6.setHorizontalAlignment(SwingConstants.CENTER);
        textField_6.setColumns(10);
        textField_6.setBounds(128, 255, 70, 40);
        panel_1.add(textField_6);

        textField_7 = new JTextField();
        textField_7.setFont(new Font("Dialog", Font.PLAIN, 16));
        textField_7.setForeground(new Color(65, 105, 225));
        textField_7.setHorizontalAlignment(SwingConstants.CENTER);
        textField_7.setColumns(10);
        textField_7.setBounds(246, 185, 70, 40);
        panel_1.add(textField_7);

        textField_8 = new JTextField();
        textField_8.setFont(new Font("Dialog", Font.PLAIN, 16));
        textField_8.setForeground(new Color(65, 105, 225));
        textField_8.setHorizontalAlignment(SwingConstants.CENTER);
        textField_8.setColumns(10);
        textField_8.setBounds(246, 255, 70, 40);
        panel_1.add(textField_8);

        textField_9 = new JTextField();
        textField_9.setForeground(new Color(65, 105, 225));
        textField_9.setFont(new Font("Dialog", Font.PLAIN, 16));
        textField_9.setHorizontalAlignment(SwingConstants.CENTER);
        textField_9.setColumns(10);
        textField_9.setBounds(365, 106, 70, 40);
        panel_1.add(textField_9);

        textField_10 = new JTextField();
        textField_10.setForeground(new Color(65, 105, 225));
        textField_10.setFont(new Font("Dialog", Font.PLAIN, 16));
        textField_10.setHorizontalAlignment(SwingConstants.CENTER);
        textField_10.setColumns(10);
        textField_10.setBounds(365, 183, 70, 40);
        panel_1.add(textField_10);

        textField_11 = new JTextField();
        textField_11.setForeground(new Color(65, 105, 225));
        textField_11.setFont(new Font("Dialog", Font.PLAIN, 16));
        textField_11.setHorizontalAlignment(SwingConstants.CENTER);
        textField_11.setColumns(10);
        textField_11.setBounds(365, 255, 70, 40);
        panel_1.add(textField_11);
        
        lblNewLabel_4 = new JLabel("+");
        lblNewLabel_4.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_4.setForeground(new Color(65, 105, 225));
        lblNewLabel_4.setFont(new Font("Consolas", Font.PLAIN, 20));
        lblNewLabel_4.setBounds(188, 106, 70, 40);
        panel_1.add(lblNewLabel_4);
        
        lblNewLabel_6 = new JLabel("+");
        lblNewLabel_6.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_6.setForeground(new Color(65, 105, 225));
        lblNewLabel_6.setFont(new Font("Consolas", Font.PLAIN, 20));
        lblNewLabel_6.setBounds(68, 106, 70, 40);
        panel_1.add(lblNewLabel_6);
        
        lblNewLabel_1 = new JLabel("=");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(65, 105, 225));
        lblNewLabel_1.setFont(new Font("Consolas", Font.PLAIN, 20));
        lblNewLabel_1.setBounds(306, 183, 70, 40);
        panel_1.add(lblNewLabel_1);
        
        lblNewLabel_2 = new JLabel("+");
        lblNewLabel_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_2.setForeground(new Color(65, 105, 225));
        lblNewLabel_2.setFont(new Font("Consolas", Font.PLAIN, 20));
        lblNewLabel_2.setBounds(186, 183, 70, 40);
        panel_1.add(lblNewLabel_2);
        
        lblNewLabel_7 = new JLabel("+");
        lblNewLabel_7.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_7.setForeground(new Color(65, 105, 225));
        lblNewLabel_7.setFont(new Font("Consolas", Font.PLAIN, 20));
        lblNewLabel_7.setBounds(66, 183, 70, 40);
        panel_1.add(lblNewLabel_7);
        
        lblNewLabel_8 = new JLabel("=");
        lblNewLabel_8.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_8.setForeground(new Color(65, 105, 225));
        lblNewLabel_8.setFont(new Font("Consolas", Font.PLAIN, 20));
        lblNewLabel_8.setBounds(306, 255, 70, 40);
        panel_1.add(lblNewLabel_8);
        
        lblNewLabel_9 = new JLabel("+");
        lblNewLabel_9.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_9.setForeground(new Color(65, 105, 225));
        lblNewLabel_9.setFont(new Font("Consolas", Font.PLAIN, 20));
        lblNewLabel_9.setBounds(188, 255, 70, 40);
        panel_1.add(lblNewLabel_9);
        
        lblNewLabel_10 = new JLabel("+");
        lblNewLabel_10.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_10.setForeground(new Color(65, 105, 225));
        lblNewLabel_10.setFont(new Font("Consolas", Font.PLAIN, 20));
        lblNewLabel_10.setBounds(68, 255, 70, 40);
        panel_1.add(lblNewLabel_10);
        
        JButton btnNewButton_4 = new JButton("Limpiar");
        btnNewButton_4.setFocusable(false);
        btnNewButton_4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarCampos();
            }
        });
        btnNewButton_4.setBackground(new Color(204, 0, 0));
        btnNewButton_4.setForeground(Color.WHITE);
        btnNewButton_4.setFont(new Font("Tahoma", Font.BOLD, 16));
        btnNewButton_4.setBounds(335, 13, 99, 50);
        panel_1.add(btnNewButton_4);

        


        JButton btnNewButton_2 = new JButton("Volver");
        btnNewButton_2.setFocusable(false);
        btnNewButton_2.setBounds(10, 11, 73, 54);
        panel_1.add(btnNewButton_2);
        btnNewButton_2.setBackground(new Color(230, 230, 250));
        btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 14));
        btnNewButton_2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose();
                abrirPanelPrincipal();
            }
        });
        
        
        
    }

    private void abrirPanelPrincipal() {
        PanelPrincipal miBasica = new PanelPrincipal();
        miBasica.setVisible(true);
    }

    private void calcularSuma(ActionEvent evt) {
        float a = Float.parseFloat(textField.getText());
        float b = Float.parseFloat(textField_1.getText());
        float c = Float.parseFloat(textField_9.getText());

        float d = Float.parseFloat(textField_3.getText());
        float e = Float.parseFloat(textField_5.getText());
        float f = Float.parseFloat(textField_10.getText());

        double determinante = a * e - b * d;

        if (determinante == 0) {
            lblNewLabel_3.setText("No tiene solución única.");
        } else {
            double x = (c * e - b * f) / determinante;
            double y = (a * f - c * d) / determinante;
            
            // Formatear los resultados a dos decimales
            DecimalFormat df = new DecimalFormat("#.##");
            lblNewLabel_3.setText("X = " + df.format(x) + "   Y = " + df.format(y));
        }
    }

    
    private void calcularSuma3x3(java.awt.event.ActionEvent evt) {
        try {
            // Extracción de coeficientes
            float a = Float.parseFloat(textField.getText());
            float b = Float.parseFloat(textField_1.getText());
            float c = Float.parseFloat(textField_2.getText());

            float d = Float.parseFloat(textField_3.getText());
            float e = Float.parseFloat(textField_5.getText());
            float f = Float.parseFloat(textField_7.getText());

            float g = Float.parseFloat(textField_4.getText());
            float h = Float.parseFloat(textField_6.getText());
            float i = Float.parseFloat(textField_8.getText());

            // Términos independientes
            float R1 = Float.parseFloat(textField_9.getText());
            float R2 = Float.parseFloat(textField_10.getText());
            float R3 = Float.parseFloat(textField_11.getText());

            // Cálculo del determinante
            double determinante = a * (e * i - h * f) - b * (d * i - g * f) + c * (d * h - g * e);

            // Verificación de la solución
            if (determinante == 0) {
                lblNewLabel_3.setText("No tiene solución única.");
            } else {
                // Cálculo de X, Y y Z usando regla de Cramer
                double x = (R1 * (e * i - h * f) - b * (R2 * i - R3 * f) + c * (R2 * h - R3 * e)) / determinante;
                double y = (a * (R2 * i - R3 * f) - R1 * (d * i - g * f) + c * (d * R3 - g * R2)) / determinante;
                double z = (a * (e * R3 - h * R2) - b * (d * R3 - g * R2) + R1 * (d * h - g * e)) / determinante;

                // Formatear los resultados a dos decimales
                DecimalFormat df = new DecimalFormat("#.##");
                lblNewLabel_3.setText("X = " + df.format(x) + ", Y = " + df.format(y) + ", Z = " + df.format(z));
            }
        } catch (NumberFormatException e) {
            lblNewLabel_3.setText("Error: Ingrese valores numéricos válidos");
            e.printStackTrace();
        }
    }
 
        private void limpiarCampos() {

            textField.setText("");
            textField_1.setText("");
            textField_2.setText("");
            textField_3.setText("");
            textField_4.setText("");
            textField_5.setText("");
            textField_6.setText("");
            textField_7.setText("");
            textField_8.setText("");
            textField_9.setText("");
            textField_10.setText("");
            textField_11.setText("");
            lblNewLabel_3.setText("");
        
        }
}
