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

    /**
	 * 
	 */
	private static final long serialVersionUID = 1L;
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

        panel.setBackground(new Color(230, 230, 250));

        panel.setBounds(0, 0, 784, 100);

        contentPane.add(panel);

        panel.setLayout(null);

       

        Panel panel_2 = new Panel();
       

        panel_2.setBackground(new Color(255, 255, 255));

        panel_2.setBounds(40, 20, 715, 60);

        panel.add(panel_2);
        panel_2.setLayout(null);
        
        JLabel lblNewLabel = new JLabel("CALCULADORAS");
        lblNewLabel.setFont(new Font("Candara", Font.BOLD, 46));
        panel_2.add(lblNewLabel);
        contentPane.setLayout(null);
        lblNewLabel.setBounds(211, 11, 356, 49);


      
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
        btnBasica.setBounds(36, 199, 319, 71);
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
        btnVector.setBounds(414, 199, 319, 71);
        contentPane.add(btnVector);
        

        JButton btnMatrices = new JButton("Matrices");
        btnMatrices.setFocusable(false);
        btnMatrices.setBackground(new Color(230, 230, 250));
        btnMatrices.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnMatrices.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra el frame actual
                Matriz matrizWindow = new Matriz(); // Crea una instancia de la ventana de Matriz
                matrizWindow.getFrame().setVisible(true); // Muestra la ventana de Matriz
            }
        });
        btnMatrices.setBounds(36, 398, 319, 71);
        contentPane.add(btnMatrices);
   

       
        JButton btnSistEcuaciones = new JButton("Sist. Ecua");
        btnSistEcuaciones.setFocusable(false);
        btnSistEcuaciones.setBackground(new Color(230, 230, 250));
        btnSistEcuaciones.setFont(new Font("Tahoma", Font.PLAIN, 18));
        btnSistEcuaciones.setBounds(414, 398, 319, 71);
        contentPane.add(btnSistEcuaciones);
        
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
    
   
    private void abrirPanelSistEcua() {
        SistEcuaciones miBasica = new SistEcuaciones();
        miBasica.setVisible(true);
    }
} /*ds*/
