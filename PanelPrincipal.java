package matricesTp;

import java.awt.EventQueue;
import java.awt.Panel;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JSeparator;

public class PanelPrincipal extends JFrame {

    private JPanel contentPane;

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    PanelPrincipal frame = new PanelPrincipal();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public PanelPrincipal() {
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(300, 50, 800, 600);
        contentPane = new JPanel();
        contentPane.setBackground(new Color(245, 245, 245));
        contentPane.setForeground(Color.WHITE);
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));

        setContentPane(contentPane);
        
        
        
        
        Panel panel = new Panel();

        panel.setBackground(new Color(41, 41, 41));

        panel.setBounds(0, 0, 784, 100);

        contentPane.add(panel);

        panel.setLayout(null);

       

        Panel panel_2 = new Panel();
       

        panel_2.setBackground(new Color(255, 255, 255));

        panel_2.setBounds(40, 20, 715, 60);

        panel.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("CALCULADORAS");
        lblNewLabel.setFont(new Font("Castellar", Font.BOLD | Font.ITALIC, 20));
        panel_2.add(lblNewLabel);
        contentPane.setLayout(null);
        lblNewLabel.setBounds(252, 11, 204, 24);


      
        JButton btnBasica = new JButton("Basica");
        btnBasica.setFocusable(false);
        btnBasica.setBackground(new Color(230, 230, 250));
        btnBasica.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnBasica.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
            	dispose();
                abrirPanelBasica();
            }
        });
        contentPane.setLayout(null);
        btnBasica.setBounds(183, 195, 120, 71);
        contentPane.add(btnBasica);

        
        JButton btnVector = new JButton("Vector");
        btnVector.setFocusable(false);
        btnVector.setBackground(new Color(230, 230, 250));
        btnVector.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnVector.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		abrirPanelVector();
        	}
        });
        contentPane.setLayout(null);
        btnVector.setBounds(463, 195, 120, 71);
        contentPane.add(btnVector);
        

        JButton btnMatrices = new JButton("Matrices");
        btnMatrices.setFocusable(false);
        btnMatrices.setBackground(new Color(230, 230, 250));
        btnMatrices.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnMatrices.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		abrirPanelMatriz();
        	}
        });
        btnMatrices.setBounds(183, 375, 120, 71);
        contentPane.add(btnMatrices);

       
        JButton btnSistEcuaciones = new JButton("Sist. Ecua");
        btnSistEcuaciones.setFocusable(false);
        btnSistEcuaciones.setBackground(new Color(230, 230, 250));
        btnSistEcuaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnSistEcuaciones.setBounds(463, 375, 120, 71);
        contentPane.add(btnSistEcuaciones);
        
        JLabel lblNewLabel_1 = new JLabel("<html><div style='text-align: center;'> Suma <br> Resta <br> Multiplicacion <br> Division <br> Raiz <br> Potencia </div></html>");
        lblNewLabel_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1.setForeground(new Color(0, 0, 0));
        lblNewLabel_1.setFont(new Font("Dialog", Font.PLAIN, 13));
        lblNewLabel_1.setBounds(59, 171, 78, 110);
        contentPane.add(lblNewLabel_1);
        
        JLabel lblNewLabel_1_1 = new JLabel("<html><div style='text-align: center;'> Suma y Resta <br> Multiplicaciones<br> Determinante <br>Inversa <br> Division </div></html>");
        lblNewLabel_1_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_1.setForeground(Color.BLACK);
        lblNewLabel_1_1.setFont(new Font("Dialog", Font.PLAIN, 13));
        lblNewLabel_1_1.setBounds(42, 359, 104, 110);
        contentPane.add(lblNewLabel_1_1);
        
        JLabel lblNewLabel_1_2 = new JLabel("<html><div style='text-align: center;'> Suma <br> Resta <br> Multiplicacion <br> Producto Escalar<br> Producto Vectorial </div></html>");
        lblNewLabel_1_2.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_2.setForeground(Color.BLACK);
        lblNewLabel_1_2.setFont(new Font("Dialog", Font.PLAIN, 13));
        lblNewLabel_1_2.setBounds(619, 171, 120, 110);
        contentPane.add(lblNewLabel_1_2);
        
        JLabel lblNewLabel_1_2_1 = new JLabel("<html><div style='text-align: center;'> 2 x 2 <br> 3 x 3 </div></html>");
        lblNewLabel_1_2_1.setHorizontalAlignment(SwingConstants.CENTER);
        lblNewLabel_1_2_1.setForeground(Color.BLACK);
        lblNewLabel_1_2_1.setFont(new Font("Dialog", Font.PLAIN, 13));
        lblNewLabel_1_2_1.setBounds(621, 375, 92, 77);
        contentPane.add(lblNewLabel_1_2_1);
        
        JSeparator separator = new JSeparator();
        separator.setBackground(new Color(255, 255, 255));
        separator.setOrientation(SwingConstants.VERTICAL);
        separator.setBounds(385, 141, 2, 373);
        contentPane.add(separator);
        
        JSeparator separator_1 = new JSeparator();
        separator_1.setBounds(42, 324, 691, 2);
        contentPane.add(separator_1);
        btnSistEcuaciones.addActionListener(new ActionListener() {
        	public void actionPerformed(ActionEvent e) {
        		dispose();
        		abrirPanelSistEcua();
        	}
        });
    }

    private void abrirPanelBasica() {
        Calco miBasica = new Calco();
        miBasica.setVisible(true);
    }
    
    private void abrirPanelVector() {
        Vector miBasica = new Vector();
        miBasica.setVisible(true);
    }
    
    private void abrirPanelMatriz() {
        Matriz miBasica = new Matriz();
        miBasica.setVisible(true);
    }
    
    private void abrirPanelSistEcua() {
        SistEcuaciones miBasica = new SistEcuaciones();
        miBasica.setVisible(true);
    }
}