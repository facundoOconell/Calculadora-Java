package matricesTp;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.util.Arrays;

public class Vector extends JFrame {
    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JPanel vector1Panel;
    private JPanel vector2Panel;
    private JTextField scalarField;
    private JLabel resultLabel;
    private int vectorSize = 3; // Tamaño inicial de los vectores

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Vector frame = new Vector();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Vector() {
        setTitle("Calculadora de Vectores");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setBounds(400, 20, 497, 700);
        contentPane = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);

        // Función para agregar campos de texto a los vectores
        agregarCamposVector();

        // Etiqueta y campo para el escalar
        JLabel lblEscalar = new JLabel("Escalar:");
        lblEscalar.setBounds(32, 544, 54, 30);
        contentPane.add(lblEscalar);

        scalarField = new JTextField(10);
        scalarField.setBounds(96, 544, 100, 30);
        scalarField.setHorizontalAlignment(JTextField.CENTER);
        contentPane.add(scalarField);

        JPanel panel = new JPanel();
        panel.setBackground(new Color(245, 245, 245));
        panel.setBounds(10, 0, 464, 120);
        contentPane.add(panel);
        panel.setLayout(null);

        resultLabel = new JLabel("");
        resultLabel.setBounds(10, 11, 444, 100);
        panel.add(resultLabel);
        resultLabel.setHorizontalAlignment(SwingConstants.CENTER);

        // Botones de operaciones
        JButton btnSuma = new JButton("Suma");
        btnSuma.setBounds(82, 452, 119, 30);
        btnSuma.setBackground(new Color(230, 230, 250));
        contentPane.add(btnSuma);

        JButton btnResta = new JButton("Resta");
        btnResta.setBounds(274, 452, 119, 30);
        btnResta.setBackground(new Color(230, 230, 250));
        contentPane.add(btnResta);

        JButton btnMultiEscalar = new JButton("Multiplicación Escalar");
        btnMultiEscalar.setBounds(217, 544, 131, 30);
        btnMultiEscalar.setBackground(new Color(230, 230, 250));
        contentPane.add(btnMultiEscalar);

        JButton btnProEscalar = new JButton("Producto Escalar");
        btnProEscalar.setBounds(82, 493, 140, 30);
        btnProEscalar.setBackground(new Color(230, 230, 250));
        contentPane.add(btnProEscalar);

        JButton btnProVectorial = new JButton("Producto Vectorial");
        btnProVectorial.setBounds(253, 493, 140, 30);
        btnProVectorial.setBackground(new Color(230, 230, 250));
        contentPane.add(btnProVectorial);

        JButton btnCambiarTamaño = new JButton("Cambiar Tamaño");
        btnCambiarTamaño.setBounds(82, 363, 141, 30);
        btnCambiarTamaño.setBackground(new Color(230, 230, 250));
        contentPane.add(btnCambiarTamaño);

        JButton btnVaciarVectores = new JButton("Vaciar Vectores");
        btnVaciarVectores.setBounds(253, 363, 140, 30);
        btnVaciarVectores.setBackground(new Color(230, 230, 250));
        contentPane.add(btnVaciarVectores);

        // Botón para volver al panel principal
        JButton btnVolver = new JButton("Volver al Panel Principal");
        btnVolver.setBounds(170, 620, 200, 30);
        btnVolver.setBackground(new Color(230, 230, 250));
        contentPane.add(btnVolver);

        // Acción para el botón de cambiar tamaño
        btnCambiarTamaño.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String input = JOptionPane.showInputDialog("Ingrese el nuevo tamaño para los vectores:");
                try {
                    int newSize = Integer.parseInt(input);
                    if (newSize > 0) {
                        vectorSize = newSize;
                        contentPane.removeAll();
                        agregarCamposVector();
                        contentPane.add(lblEscalar);
                        contentPane.add(scalarField);
                        contentPane.add(btnSuma);
                        contentPane.add(btnResta);
                        contentPane.add(btnMultiEscalar);
                        contentPane.add(btnProEscalar);
                        contentPane.add(btnProVectorial);
                        contentPane.add(btnCambiarTamaño);
                        contentPane.add(btnVaciarVectores);
                        contentPane.add(btnVolver);
                        contentPane.add(panel);
                        contentPane.revalidate();
                        contentPane.repaint();
                    } else {
                        JOptionPane.showMessageDialog(null, "El tamaño debe ser mayor que cero.");
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingrese un número válido.");
                }
            }
        });

        // Acción para el botón de vaciar vectores
        btnVaciarVectores.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                limpiarPanel(vector1Panel);
                limpiarPanel(vector2Panel);
                resultLabel.setText("Vectores vaciados.");
            }
        });

        // Acción para sumar vectores y guardar el resultado en vector1Field
        btnSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double[] v1 = obtenerVector(vector1Panel);
                double[] v2 = obtenerVector(vector2Panel);
                if (v1 != null && v2 != null) {
                    double[] resultado = sumarVectores(v1, v2);
                    actualizarPanel(vector1Panel, resultado);
                    resultLabel.setText("Resultado Suma: " + Arrays.toString(resultado));
                    limpiarPanel(vector2Panel);
                }
            }
        });

        // Acción para restar vectores y guardar el resultado en vector1Field
        btnResta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double[] v1 = obtenerVector(vector1Panel);
                double[] v2 = obtenerVector(vector2Panel);
                if (v1 != null && v2 != null) {
                    double[] resultado = restarVectores(v1, v2);
                    actualizarPanel(vector1Panel, resultado);
                    resultLabel.setText("Resultado Resta: " + Arrays.toString(resultado));
                    limpiarPanel(vector2Panel);
                }
            }
        });

        // Acción para multiplicar un vector por un escalar y guardar el resultado en vector1Field
        btnMultiEscalar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double escalar = Double.parseDouble(scalarField.getText());
                    double[] v1 = obtenerVector(vector1Panel);
                    if (v1 != null) {
                        double[] resultado = multiplicarEscalar(escalar, v1);
                        actualizarPanel(vector1Panel, resultado);
                        resultLabel.setText("Resultado Multiplicación Escalar: " + Arrays.toString(resultado));
                        limpiarPanel(vector2Panel);
                    }
                } catch (NumberFormatException ex) {
                    JOptionPane.showMessageDialog(null, "Por favor, ingresa un número válido para el escalar.");
                }
            }
        });

        // Acción para calcular el producto escalar y mostrar el resultado en resultLabel
        btnProEscalar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double[] v1 = obtenerVector(vector1Panel);
                double[] v2 = obtenerVector(vector2Panel);
                if (v1 != null && v2 != null) {
                    double prodEscalar = productoEscalar(v1, v2);
                    resultLabel.setText("Resultado Producto Escalar: " + prodEscalar);
                    limpiarPanel(vector2Panel);
                }
            }
        });

        // Acción para calcular el producto vectorial y mostrar el resultado en resultLabel
        btnProVectorial.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                double[] v1 = obtenerVector(vector1Panel);
                double[] v2 = obtenerVector(vector2Panel);
                if (v1 != null && v2 != null) {
                    if (v1.length == 3 && v2.length == 3) {
                        double[] prodVectorial = productoVectorial(v1, v2);
                        resultLabel.setText("Resultado Producto Vectorial: " + Arrays.toString(prodVectorial));
                        limpiarPanel(vector2Panel);
                    } else {
                        JOptionPane.showMessageDialog(null, "El producto vectorial está definido solo para vectores tridimensionales.");
                    }
                }
            }
        });

        // Acción para el botón de volver al panel principal
        btnVolver.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                dispose(); // Cierra la ventana actual de vectores
                PanelPrincipal.main(null); // Abre la ventana principal PanelPrincipal.java
            }
        });
    }

    // Método para agregar campos de texto a los vectores en el panel
    private void agregarCamposVector() {
        vector1Panel = new JPanel();
        vector1Panel.setBorder(BorderFactory.createTitledBorder("Vector 1"));
        vector1Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); // Centra los campos horizontalmente

        vector2Panel = new JPanel();
        vector2Panel.setBorder(BorderFactory.createTitledBorder("Vector 2"));
        vector2Panel.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5)); // Centra los campos horizontalmente

        JScrollPane vector1ScrollPane = new JScrollPane(vector1Panel);
        vector1ScrollPane.setBounds(20, 141, 438, 70); // Ajusta el tamaño vertical para acomodar los campos
        vector1ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        vector1ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Desactiva el scroll vertical

        JScrollPane vector2ScrollPane = new JScrollPane(vector2Panel);
        vector2ScrollPane.setBounds(20, 252, 438, 70); // Ajusta el tamaño vertical para acomodar los campos
        vector2ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_NEVER);
        vector2ScrollPane.setVerticalScrollBarPolicy(JScrollPane.VERTICAL_SCROLLBAR_NEVER); // Desactiva el scroll vertical

        contentPane.add(vector1ScrollPane);
        contentPane.add(vector2ScrollPane);

        int maxCampos = 20; // Máximo número de campos antes de activar el scroll horizontal

        for (int i = 0; i < vectorSize; i++) {
            JTextField textField1 = new JTextField();
            textField1.setPreferredSize(new Dimension(50, 30)); // Ajusta el tamaño de los campos de texto
            textField1.setHorizontalAlignment(JTextField.CENTER); // Centra el texto horizontalmente
            vector1Panel.add(textField1);

            JTextField textField2 = new JTextField();
            textField2.setPreferredSize(new Dimension(50, 30)); // Ajusta el tamaño de los campos de texto
            textField2.setHorizontalAlignment(JTextField.CENTER); // Centra el texto horizontalmente
            vector2Panel.add(textField2);

            // Verificar si hay más de 20 campos para activar el scroll horizontal
            if (i >= maxCampos) {
                vector1ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
                vector2ScrollPane.setHorizontalScrollBarPolicy(JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
            }
        }

        // Ajustar el tamaño del panel de scroll si hay menos de 20 campos
        int preferredWidth = 50 * Math.min(vectorSize, maxCampos);
        vector1ScrollPane.setPreferredSize(new Dimension(preferredWidth, 70));
        vector2ScrollPane.setPreferredSize(new Dimension(preferredWidth, 70));
    }

    // Método para obtener los valores de un vector desde el panel de campos de texto
    private double[] obtenerVector(JPanel panel) {
        Component[] components = panel.getComponents();
        double[] vector = new double[vectorSize];
        try {
            for (int i = 0; i < vectorSize; i++) {
                JTextField textField = (JTextField) components[i];
                vector[i] = Double.parseDouble(textField.getText());
            }
            return vector;
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(null, "Por favor, ingrese números válidos en todos los campos.");
            return null;
        }
    }

    // Método para actualizar el panel de campos de texto con un nuevo vector
    private void actualizarPanel(JPanel panel, double[] vector) {
        Component[] components = panel.getComponents();
        for (int i = 0; i < vectorSize; i++) {
            JTextField textField = (JTextField) components[i];
            textField.setText(String.valueOf(vector[i]));
        }
    }

    // Método para limpiar todos los campos de texto en un panel
    private void limpiarPanel(JPanel panel) {
        Component[] components = panel.getComponents();
        for (Component component : components) {
            if (component instanceof JTextField) {
                JTextField textField = (JTextField) component;
                textField.setText("");
            }
        }
    }

    // Métodos para operaciones con vectores
    private double[] sumarVectores(double[] v1, double[] v2) {
        double[] resultado = new double[vectorSize];
        for (int i = 0; i < vectorSize; i++) {
            resultado[i] = v1[i] + v2[i];
        }
        return resultado;
    }

    private double[] restarVectores(double[] v1, double[] v2) {
        double[] resultado = new double[vectorSize];
        for (int i = 0; i < vectorSize; i++) {
            resultado[i] = v1[i] - v2[i];
        }
        return resultado;
    }

    private double[] multiplicarEscalar(double escalar, double[] v) {
        double[] resultado = new double[vectorSize];
        for (int i = 0; i < vectorSize; i++) {
            resultado[i] = escalar * v[i];
        }
        return resultado;
    }

    private double productoEscalar(double[] v1, double[] v2) {
        double resultado = 0;
        for (int i = 0; i < vectorSize; i++) {
            resultado += v1[i] * v2[i];
        }
        return resultado;
    }

    private double[] productoVectorial(double[] v1, double[] v2) {
        double[] resultado = new double[3];
        resultado[0] = v1[1] * v2[2] - v1[2] * v2[1];
        resultado[1] = -(v1[0] * v2[2] - v1[2] * v2[0]);
        resultado[2] = v1[0] * v2[1] - v1[1] * v2[0];
        return resultado;
    }
}
