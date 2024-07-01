package matricesTp;



import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;

public class Matriz {

    private JFrame frame;
    private JComboBox<String> comboBox;
    private JButton btnOperar;
    private JButton btnRandom;
    private JButton btnVaciar;
    private JButton btnProductoEscalar;
    private JButton btnMatrizInversa;
    private JButton btnDeterminante;
    private JButton btnDivision;
    private JButton btnDeterminante2x2;
    private JTextField[][] textFields1;
    private JTextField[][] textFields2;
    private JTextField[][] textFieldsResultado;

    private int filas = 3;
    private int columnas = 3;

    private double[][] matriz1;
    private double[][] matriz2;
    private double[][] matrizResultado = new double[filas][columnas];

    public Matriz() {
        initialize();
    }

    public JFrame getFrame() {
        return frame;
    }

    private void initialize() {
        frame = new JFrame();
        frame.setBounds(50, 50, 497, 700);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().setLayout(null);

        JPanel panelSuperior = new JPanel();
        panelSuperior.setBounds(10, 10, 461, 225);
        panelSuperior.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        frame.getContentPane().add(panelSuperior);
        panelSuperior.setLayout(new GridLayout(filas, columnas));

        JPanel panelCentral = new JPanel();
        panelCentral.setBounds(10, 245, 461, 225);
        panelCentral.setLayout(new GridLayout(1, 2, 10, 0));
        frame.getContentPane().add(panelCentral);

        JPanel matriz1Panel = new JPanel();
        matriz1Panel.setBorder(BorderFactory.createTitledBorder("Matriz 1"));
        matriz1Panel.setLayout(new GridLayout(filas, columnas, 5, 5));
        panelCentral.add(matriz1Panel);

        textFields1 = new JTextField[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                textFields1[i][j] = createFormattedTextField();
                matriz1Panel.add(textFields1[i][j]);
            }
        }

        JPanel matriz2Panel = new JPanel();
        matriz2Panel.setBorder(BorderFactory.createTitledBorder("Matriz 2"));
        matriz2Panel.setLayout(new GridLayout(filas, columnas, 5, 5));
        panelCentral.add(matriz2Panel);

        textFields2 = new JTextField[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                textFields2[i][j] = createFormattedTextField();
                matriz2Panel.add(textFields2[i][j]);
            }
        }

        JPanel panelInferior = new JPanel();
        panelInferior.setBounds(10, 480, 461, 170);
        panelInferior.setLayout(new GridLayout(2, 1, 0, 10));
        frame.getContentPane().add(panelInferior);

        JPanel operacionesPanel = new JPanel();
        operacionesPanel.setLayout(new GridLayout(2, 4, 5, 5));
        panelInferior.add(operacionesPanel);

        comboBox = new JComboBox<>();
        comboBox.addItem("+");
        comboBox.addItem("-");
        comboBox.addItem("*");
        operacionesPanel.add(comboBox);
        
        btnDivision = new JButton("División");
        btnDivision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obtenerMatricesDesdeCampos();

                double[][] matrizInversa = null;
                if (matriz2 != null) {
                    if (filas == 3 && columnas == 3) {
                        matrizInversa = calcularMatrizInversa3x3(matriz2);
                    } else if (filas == 2 && columnas == 2) {
                        matrizInversa = calcularMatrizInversa2x2(matriz2);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Solo se admite matriz 2x2 o 3x3 para inversa", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }
                } else {
                    JOptionPane.showMessageDialog(frame, "La Matriz 2 está vacía", "Error", JOptionPane.ERROR_MESSAGE);
                    return;
                }

                if (matrizInversa != null) {
                    double[][] matrizResultadoDivision = multiplicacionMatrices(matriz1, matrizInversa);
                    mostrarResultadoEnInterfaz(matrizResultadoDivision);
                }
            }
        });
        operacionesPanel.add(btnDivision);




        btnOperar = new JButton("Operar");
        btnOperar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                obtenerMatricesDesdeCampos();

                String operacion = (String) comboBox.getSelectedItem();
                switch (operacion) {
                    case "+":
                        matrizResultado = sumaMatrices(matriz1, matriz2);
                        break;
                    case "-":
                        matrizResultado = restaMatrices(matriz1, matriz2);
                        break;
                    case "*":
                        matrizResultado = multiplicacionMatrices(matriz1, matriz2);
                        break;
                    default:
                        JOptionPane.showMessageDialog(frame, "Operación no válida", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                }

                mostrarResultadoEnInterfaz(matrizResultado);
            }
        });
        operacionesPanel.add(btnOperar);

        btnRandom = new JButton("Random");
        btnRandom.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                llenarMatricesConRandom();
                reiniciarMatrizResultado();
            }
        });
        operacionesPanel.add(btnRandom);

        btnVaciar = new JButton("Vaciar");
        btnVaciar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                vaciarMatrices();
                reiniciarMatrizResultado();
            }
        });
        operacionesPanel.add(btnVaciar);

        btnProductoEscalar = new JButton("Producto Escalar");
        btnProductoEscalar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String opcion = (String) JOptionPane.showInputDialog(
                        frame,
                        "Seleccione la matriz para calcular el producto escalar:",
                        "Selección de Matriz",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        new String[]{"Matriz 1", "Matriz 2"},
                        "Matriz 1");

                if (opcion != null) {
                    double[][] matrizSeleccionada = opcion.equals("Matriz 1") ? matriz1 : matriz2;
                    double[][] resultado = productoEscalar(matrizSeleccionada);

                    matrizResultado = resultado;

                    mostrarResultadoEnInterfaz(matrizResultado);
                }
            }
        });
        operacionesPanel.add(btnProductoEscalar);

        btnMatrizInversa = new JButton("Matriz Inversa");
        btnMatrizInversa.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String opcion = (String) JOptionPane.showInputDialog(
                        frame,
                        "Seleccione la matriz para calcular la inversa:",
                        "Selección de Matriz",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        new String[]{"Matriz 1", "Matriz 2"},
                        "Matriz 1");

                if (opcion != null) {
                    double[][] matrizSeleccionada = opcion.equals("Matriz 1") ? matriz1 : matriz2;
                    double[][] matrizInversa = null;
                    if (filas == 3 && columnas == 3) {
                        matrizInversa = calcularMatrizInversa3x3(matrizSeleccionada);
                    } else if (filas == 2 && columnas == 2) {
                        matrizInversa = calcularMatrizInversa2x2(matrizSeleccionada);
                    } else {
                        JOptionPane.showMessageDialog(frame, "Solo se admite matriz 2x2 o 3x3 para inversa", "Error", JOptionPane.ERROR_MESSAGE);
                        return;
                    }

                    if (matrizInversa != null) {
                        mostrarResultadoEnInterfaz(matrizInversa);
                    }
                }
            }
        });
        operacionesPanel.add(btnMatrizInversa);
        
        btnDeterminante2x2 = new JButton("Det 2x2");
        btnDeterminante2x2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {

                String opcion = (String) JOptionPane.showInputDialog(
                        frame,
                        "Seleccione la matriz para calcular la determinante 2x2:",
                        "Selección de Matriz",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        new String[]{"Matriz 1", "Matriz 2"},
                        "Matriz 1");

                if (opcion != null) {
                    double determinante2x2;
                    if (opcion.equals("Matriz 1")) {
                        determinante2x2 = determinant2x2(matriz1);
                    } else {
                        determinante2x2 = determinant2x2(matriz2);
                    }

                    JOptionPane.showMessageDialog(frame,
                            "La determinante de la Matriz " + opcion + " (2x2) es: " + determinante2x2,
                            "Determinante 2x2",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        operacionesPanel.add(btnDeterminante2x2);

        btnDeterminante = new JButton("Det 3x3");
        btnDeterminante.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                String opcion = (String) JOptionPane.showInputDialog(
                        frame,
                        "Seleccione la matriz para calcular la determinante:",
                        "Selección de Matriz",
                        JOptionPane.PLAIN_MESSAGE,
                        null,
                        new String[]{"Matriz 1", "Matriz 2"},
                        "Matriz 1");

                if (opcion != null) {
                    double determinante;
                    if (opcion.equals("Matriz 1")) {
                        determinante = determinant(matriz1);
                    } else {
                        determinante = determinant(matriz2);
                    }

                    JOptionPane.showMessageDialog(frame,
                            "La determinante de la matriz seleccionada es: " + determinante,
                            "Determinante",
                            JOptionPane.INFORMATION_MESSAGE);
                }
            }
        });
        operacionesPanel.add(btnDeterminante);

        JPanel botonPanel = new JPanel();
        botonPanel.setLayout(new GridLayout(1, 3, 5, 5));
        panelInferior.add(botonPanel);

        JButton btn3x3 = new JButton("3x3");
        btn3x3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cambiarTamanioMatrices(3, 3);
            }
        });
        botonPanel.add(btn3x3);

        JButton btn2x2 = new JButton("2x2");
        btn2x2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                cambiarTamanioMatrices(2, 2);
            }
        });
        botonPanel.add(btn2x2);

        JButton btnSalir = new JButton("Salir");
        btnSalir.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        botonPanel.add(btnSalir);

        reiniciarMatrizResultado();
    }

    private JTextField createFormattedTextField() {
        JTextField textField = new JTextField();
        textField.setHorizontalAlignment(SwingConstants.CENTER);
        return textField;
    }

    private void obtenerMatricesDesdeCampos() {
        matriz1 = obtenerMatrizDesdeTextField(textFields1);
        matriz2 = obtenerMatrizDesdeTextField(textFields2);
    }

    private double[][] obtenerMatrizDesdeTextField(JTextField[][] textFields) {
        double[][] matriz = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                String valorTexto = textFields[i][j].getText();
                try {
                    matriz[i][j] = Double.parseDouble(valorTexto);
                } catch (NumberFormatException e) {
                    matriz[i][j] = 0.0; 
                }
            }
        }
        return matriz;
    }

    private void mostrarResultadoEnInterfaz(double[][] matrizResultado) {
        JPanel panelSuperior = (JPanel) frame.getContentPane().getComponent(0);
        panelSuperior.removeAll();
        panelSuperior.setLayout(new GridLayout(filas, columnas));

        textFieldsResultado = new JTextField[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                textFieldsResultado[i][j] = new JTextField();
                textFieldsResultado[i][j].setHorizontalAlignment(SwingConstants.CENTER);
                textFieldsResultado[i][j].setText(String.valueOf(matrizResultado[i][j]));
                panelSuperior.add(textFieldsResultado[i][j]);
            }
        }

        frame.validate();
        frame.repaint();
    }

    private void llenarMatricesConRandom() {
        Random random = new Random();
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                textFields1[i][j].setText(String.valueOf(random.nextInt(10)));
                textFields2[i][j].setText(String.valueOf(random.nextInt(10)));
            }
        }
    }

    private void vaciarMatrices() {
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                textFields1[i][j].setText("");
                textFields2[i][j].setText("");
            }
        }
    }

    private void cambiarTamanioMatrices(int nuevasFilas, int nuevasColumnas) {
        filas = nuevasFilas;
        columnas = nuevasColumnas;

        matriz1 = new double[filas][columnas];
        matriz2 = new double[filas][columnas];
        textFields1 = new JTextField[filas][columnas];
        textFields2 = new JTextField[filas][columnas];

        JPanel panelCentral = (JPanel) frame.getContentPane().getComponent(1);
        panelCentral.removeAll();

        JPanel matriz1Panel = new JPanel();
        matriz1Panel.setBorder(BorderFactory.createTitledBorder("Matriz 1"));
        matriz1Panel.setLayout(new GridLayout(filas, columnas, 5, 5));
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                textFields1[i][j] = createFormattedTextField();
                matriz1Panel.add(textFields1[i][j]);
            }
        }
        panelCentral.add(matriz1Panel);

        JPanel matriz2Panel = new JPanel();
        matriz2Panel.setBorder(BorderFactory.createTitledBorder("Matriz 2"));
        matriz2Panel.setLayout(new GridLayout(filas, columnas, 5, 5));
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                textFields2[i][j] = createFormattedTextField();
                matriz2Panel.add(textFields2[i][j]);
            }
        }
        panelCentral.add(matriz2Panel);

        frame.validate();
        frame.repaint();

        reiniciarMatrizResultado();
    }

    private void reiniciarMatrizResultado() {
        matrizResultado = new double[filas][columnas];
        mostrarResultadoEnInterfaz(matrizResultado);
    }

    private double[][] sumaMatrices(double[][] matriz1, double[][] matriz2) {
        double[][] resultado = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] + matriz2[i][j];
            }
        }
        return resultado;
    }

    private double[][] restaMatrices(double[][] matriz1, double[][] matriz2) {
        double[][] resultado = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz1[i][j] - matriz2[i][j];
            }
        }
        return resultado;
    }

    private double[][] multiplicacionMatrices(double[][] matriz1, double[][] matriz2) {
        double[][] resultado = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                for (int k = 0; k < columnas; k++) {
                    resultado[i][j] += matriz1[i][k] * matriz2[k][j];
                }
            }
        }
        return resultado;
    }

    private double[][] productoEscalar(double[][] matriz) {
        String escalarTexto = JOptionPane.showInputDialog(frame, "Ingrese el valor del escalar:", "Producto Escalar", JOptionPane.PLAIN_MESSAGE);
        if (escalarTexto == null || escalarTexto.isEmpty()) {
            return matriz; 
        }

        double escalar;
        try {
            escalar = Double.parseDouble(escalarTexto);
        } catch (NumberFormatException e) {
            JOptionPane.showMessageDialog(frame, "Valor de escalar no válido", "Error", JOptionPane.ERROR_MESSAGE);
            return matriz;
        }

        double[][] resultado = new double[filas][columnas];
        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                resultado[i][j] = matriz[i][j] * escalar;
            }
        }
        return resultado;
    }

    private double[][] calcularMatrizInversa3x3(double[][] matriz) {
        double determinante = determinant(matriz);
        if (determinante == 0) {
            JOptionPane.showMessageDialog(frame, "La matriz no tiene inversa (determinante es 0)", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        double[][] adjunta = adjunta(matriz);
        double[][] inversa = new double[filas][columnas];

        for (int i = 0; i < filas; i++) {
            for (int j = 0; j < columnas; j++) {
                inversa[j][i] = adjunta[i][j] / determinante;
            }
        }
        
        return inversa;
    }

    private double[][] calcularMatrizInversa2x2(double[][] matriz) {
        double det = determinant2x2(matriz);
        if (det == 0) {
            JOptionPane.showMessageDialog(frame, "La matriz no tiene inversa (determinante es 0)", "Error", JOptionPane.ERROR_MESSAGE);
            return null;
        }

        double[][] inversa = new double[2][2];
        inversa[0][0] = matriz[1][1] / det;
        inversa[0][1] = -matriz[0][1] / det;
        inversa[1][0] = -matriz[1][0] / det;
        inversa[1][1] = matriz[0][0] / det;

        return inversa;
    }


    private double determinant(double[][] matrix) {
        double determinant = 0;
        if (filas == 3 && columnas == 3) {
            determinant = matrix[0][0] * (matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1])
                    - matrix[0][1] * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0])
                    + matrix[0][2] * (matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0]);
        }
        return determinant;
    }

    private double determinant2x2(double[][] matrix) {
        if (matrix.length == 2 && matrix[0].length == 2) {
            return matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];
        } else {

            throw new IllegalArgumentException("La matriz no es 2x2");
        }
    }


    private double[][] adjunta(double[][] matrix) {
        double[][] adjunta = new double[filas][columnas];
        adjunta[0][0] = matrix[1][1] * matrix[2][2] - matrix[1][2] * matrix[2][1];
        adjunta[0][1] = -1 * (matrix[1][0] * matrix[2][2] - matrix[1][2] * matrix[2][0]);
        adjunta[0][2] = matrix[1][0] * matrix[2][1] - matrix[1][1] * matrix[2][0];

        adjunta[1][0] = -1 * (matrix[0][1] * matrix[2][2] - matrix[0][2] * matrix[2][1]);
        adjunta[1][1] = matrix[0][0] * matrix[2][2] - matrix[0][2] * matrix[2][0];
        adjunta[1][2] = -1 * (matrix[0][0] * matrix[2][1] - matrix[0][1] * matrix[2][0]);

        adjunta[2][0] = matrix[0][1] * matrix[1][2] - matrix[0][2] * matrix[1][1];
        adjunta[2][1] = -1 * (matrix[0][0] * matrix[1][2] - matrix[0][2] * matrix[1][0]);
        adjunta[2][2] = matrix[0][0] * matrix[1][1] - matrix[0][1] * matrix[1][0];

        return adjunta;
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Matriz window = new Matriz();
                    window.frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}