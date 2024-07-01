package matricesTp;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;
import javax.swing.border.EmptyBorder;

public class Calco extends JFrame {

    private static final long serialVersionUID = 1L;
    private JPanel contentPane;
    private JLabel lblNewLabel;
    private StringBuilder expresion = new StringBuilder();
    private int desplazamiento = 0;
    private boolean esperandoRadicando = false; // Nuevo estado para manejar si estamos esperando el radicando

    public static void main(String[] args) {
        EventQueue.invokeLater(new Runnable() {
            public void run() {
                try {
                    Calco frame = new Calco();
                    frame.setVisible(true);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    public Calco() {
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
        FlowLayout flowLayout = (FlowLayout) panel_2.getLayout();
        flowLayout.setAlignment(FlowLayout.LEFT);
        flowLayout.setVgap(25);
        flowLayout.setHgap(10);
        panel_2.setForeground(Color.BLACK);
        panel_2.setBackground(SystemColor.controlHighlight);
        panel_2.setBounds(10, 11, 444, 100);
        panel.add(panel_2);

        lblNewLabel = new JLabel("");
        lblNewLabel.setHorizontalAlignment(SwingConstants.LEFT);
        panel_2.add(lblNewLabel);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 45));
        lblNewLabel.setForeground(Color.BLACK);
        lblNewLabel.setBackground(Color.BLACK);
        lblNewLabel.setFont(new Font("Arial", Font.BOLD, 40));

        JPanel panel_1 = new JPanel();
        panel_1.setBackground(SystemColor.control);
        panel_1.setBounds(10, 120, 464, 541);
        contentPane.add(panel_1);
        panel_1.setLayout(null);

        JButton btnNewButton = new JButton("7");
        btnNewButton.setForeground(new Color(65, 105, 225));
        btnNewButton.setFocusable(false);
        btnNewButton.setBackground(new Color(230, 230, 250));
        btnNewButton.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (esperandoRadicando) {
                    expresion.insert(desplazamiento++, "7");
                    esperandoRadicando = false;
                } else {
                    expresion.insert(desplazamiento++, "7");
                }
                actualizarVisor();
            }
        });
        btnNewButton.setBounds(20, 81, 80, 80);
        btnNewButton.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btnNewButton);

        JButton btn8 = new JButton("8");
        btn8.setForeground(new Color(65, 105, 225));
        btn8.setFocusable(false);
        btn8.setBackground(new Color(230, 230, 250));
        btn8.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (esperandoRadicando) {
                    expresion.insert(desplazamiento++, "8");
                    esperandoRadicando = false;
                } else {
                    expresion.insert(desplazamiento++, "8");
                }
                actualizarVisor();
            }
        });
        btn8.setBounds(110, 81, 80, 80);
        btn8.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btn8);

        JButton btn9 = new JButton("9");
        btn9.setForeground(new Color(65, 105, 225));
        btn9.setFocusable(false);
        btn9.setBackground(new Color(230, 230, 250));
        btn9.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (esperandoRadicando) {
                    expresion.insert(desplazamiento++, "9");
                    esperandoRadicando = false;
                } else {
                    expresion.insert(desplazamiento++, "9");
                }
                actualizarVisor();
            }
        });
        btn9.setBounds(200, 81, 80, 80);
        btn9.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btn9);

        JButton btnSuma = new JButton("+");
        btnSuma.setForeground(new Color(65, 105, 225));
        btnSuma.setFocusable(false);
        btnSuma.setBackground(new Color(230, 230, 250));
        btnSuma.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                expresion.insert(desplazamiento++, "+");
                actualizarVisor();
            }
        });
        btnSuma.setBounds(290, 263, 80, 171);
        btnSuma.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btnSuma);

        JButton btn4 = new JButton("4");
        btn4.setForeground(new Color(65, 105, 225));
        btn4.setFocusable(false);
        btn4.setBackground(new Color(230, 230, 250));
        btn4.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (esperandoRadicando) {
                    expresion.insert(desplazamiento++, "4");
                    esperandoRadicando = false;
                } else {
                    expresion.insert(desplazamiento++, "4");
                }
                actualizarVisor();
            }
        });
        btn4.setBounds(20, 172, 80, 80);
        btn4.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btn4);

        JButton btn5 = new JButton("5");
        btn5.setForeground(new Color(65, 105, 225));
        btn5.setFocusable(false);
        btn5.setBackground(new Color(230, 230, 250));
        btn5.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (esperandoRadicando) {
                    expresion.insert(desplazamiento++, "5");
                    esperandoRadicando = false;
                } else {
                    expresion.insert(desplazamiento++, "5");
                }
                actualizarVisor();
            }
        });
        btn5.setBounds(110, 172, 80, 80);
        btn5.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btn5);

        JButton btn6 = new JButton("6");
        btn6.setForeground(new Color(65, 105, 225));
        btn6.setFocusable(false);
        btn6.setBackground(new Color(230, 230, 250));
        btn6.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (esperandoRadicando) {
                    expresion.insert(desplazamiento++, "6");
                    esperandoRadicando = false;
                } else {
                    expresion.insert(desplazamiento++, "6");
                }
                actualizarVisor();
            }
        });
        btn6.setBounds(200, 172, 80, 80);
        btn6.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btn6);

        JButton btnResta = new JButton("-");
        btnResta.setForeground(new Color(65, 105, 225));
        btnResta.setFocusable(false);
        btnResta.setBackground(new Color(230, 230, 250));
        btnResta.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                expresion.insert(desplazamiento++, "-");
                actualizarVisor();
            }
        });
        btnResta.setBounds(380, 263, 80, 171);
        btnResta.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btnResta);

        JButton btn1 = new JButton("1");
        btn1.setForeground(new Color(65, 105, 225));
        btn1.setFocusable(false);
        btn1.setBackground(new Color(230, 230, 250));
        btn1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (esperandoRadicando) {
                    expresion.insert(desplazamiento++, "1");
                    esperandoRadicando = false;
                } else {
                    expresion.insert(desplazamiento++, "1");
                }
                actualizarVisor();
            }
        });
        btn1.setBounds(20, 263, 80, 80);
        btn1.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btn1);

        JButton btn2 = new JButton("2");
        btn2.setForeground(new Color(65, 105, 225));
        btn2.setFocusable(false);
        btn2.setBackground(new Color(230, 230, 250));
        btn2.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (esperandoRadicando) {
                    expresion.insert(desplazamiento++, "2");
                    esperandoRadicando = false;
                } else {
                    expresion.insert(desplazamiento++, "2");
                }
                actualizarVisor();
            }
        });
        btn2.setBounds(110, 263, 80, 80);
        btn2.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btn2);

        JButton btn3 = new JButton("3");
        btn3.setForeground(new Color(65, 105, 225));
        btn3.setFocusable(false);
        btn3.setBackground(new Color(230, 230, 250));
        btn3.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (esperandoRadicando) {
                    expresion.insert(desplazamiento++, "3");
                    esperandoRadicando = false;
                } else {
                    expresion.insert(desplazamiento++, "3");
                }
                actualizarVisor();
            }
        });
        btn3.setBounds(200, 263, 80, 80);
        btn3.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btn3);

        JButton btnMultiplicacion = new JButton("*");
        btnMultiplicacion.setForeground(new Color(65, 105, 225));
        btnMultiplicacion.setFocusable(false);
        btnMultiplicacion.setBackground(new Color(230, 230, 250));
        btnMultiplicacion.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                expresion.insert(desplazamiento++, "*");
                actualizarVisor();
            }
        });
        btnMultiplicacion.setBounds(290, 172, 80, 80);
        btnMultiplicacion.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btnMultiplicacion);

        JButton btn0 = new JButton("0");
        btn0.setForeground(new Color(65, 105, 225));
        btn0.setFocusable(false);
        btn0.setBackground(new Color(230, 230, 250));
        btn0.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (esperandoRadicando) {
                    expresion.insert(desplazamiento++, "0");
                    esperandoRadicando = false;
                } else {
                    expresion.insert(desplazamiento++, "0");
                }
                actualizarVisor();
            }
        });
        btn0.setBounds(110, 354, 170, 80);
        btn0.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btn0);

        JButton btnDel = new JButton("DEL");
        btnDel.setForeground(new Color(245, 245, 245));
        btnDel.setFocusable(false);
        btnDel.setBackground(new Color(178, 34, 34));
        btnDel.setToolTipText("Borrar última acción");
        btnDel.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (desplazamiento > 0) {
                    expresion.deleteCharAt(--desplazamiento);
                    actualizarVisor();
                }
            }
        });
        btnDel.setBounds(110, 445, 170, 80);
        btnDel.setFont(new Font("Arial", Font.BOLD, 32));
        panel_1.add(btnDel);

        JButton btnIzquierda = new JButton("<");
        btnIzquierda.setFocusable(false);
        btnIzquierda.setBackground(new Color(230, 230, 250));
        btnIzquierda.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (desplazamiento > 0) {
                    desplazamiento--;
                    actualizarVisor();
                }
            }
        });
        btnIzquierda.setBounds(139, 18, 80, 37);
        btnIzquierda.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btnIzquierda);

        JButton btnDerecha = new JButton(">");
        btnDerecha.setFocusable(false);
        btnDerecha.setBackground(new Color(230, 230, 250));
        btnDerecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                if (desplazamiento < expresion.length()) {
                    desplazamiento++;
                    actualizarVisor();
                }
            }
        });
        btnDerecha.setBounds(253, 18, 80, 37);
        btnDerecha.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btnDerecha);

        JButton btnIgual = new JButton("=");
        btnIgual.setFocusable(false);
        btnIgual.setBackground(new Color(153, 204, 255));
        btnIgual.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                try {
                    double resultado = evaluarExpresion(expresion.toString());
                    lblNewLabel.setText(Double.toString(resultado));
                    expresion.setLength(0);
                    desplazamiento = 0;
                } catch (Exception ex) {
                    lblNewLabel.setText("Error");
                }
            }
        });
        btnIgual.setBounds(290, 445, 170, 80);
        btnIgual.setFont(new Font("Arial", Font.PLAIN, 48));
        panel_1.add(btnIgual);

        JButton btnDivision = new JButton("/");
        btnDivision.setForeground(new Color(65, 105, 225));
        btnDivision.setFocusable(false);
        btnDivision.setBackground(new Color(230, 230, 250));
        btnDivision.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                expresion.insert(desplazamiento++, "/");
                actualizarVisor();
            }
        });
        btnDivision.setBounds(290, 81, 80, 80);
        btnDivision.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btnDivision);

        JButton btnPotencia = new JButton("^");
        btnPotencia.setForeground(new Color(65, 105, 225));
        btnPotencia.setFocusable(false);
        btnPotencia.setBackground(new Color(230, 230, 250));
        btnPotencia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                expresion.insert(desplazamiento++, "^");
                actualizarVisor();
            }
        });
        btnPotencia.setBounds(380, 81, 80, 80);
        btnPotencia.setFont(new Font("Arial", Font.BOLD, 24));
        panel_1.add(btnPotencia);

        JButton btnRaiz = new JButton("√");
        btnRaiz.setForeground(new Color(65, 105, 225));
        btnRaiz.setFocusable(false);
        btnRaiz.setBackground(new Color(230, 230, 250));
        btnRaiz.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                expresion.insert(desplazamiento++, "√");
                esperandoRadicando = true; // Indicamos que el siguiente número será el radicando
                actualizarVisor();
            }
        });
        btnRaiz.setBounds(380, 174, 80, 80);
        btnRaiz.setFont(new Font("Arial", Font.BOLD, 18));
        panel_1.add(btnRaiz);

        JButton btnBorrar = new JButton("AC");
        btnBorrar.setForeground(new Color(245, 245, 245));
        btnBorrar.setFocusable(false);
        btnBorrar.setBackground(new Color(178, 34, 34));
        btnBorrar.setToolTipText("Borrar Visor");
        btnBorrar.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                expresion.setLength(0);
                actualizarVisor();
                desplazamiento = 0;
            }
        });
        btnBorrar.setBounds(20, 354, 80, 173);
        btnBorrar.setFont(new Font("Arial", Font.BOLD, 32));
        panel_1.add(btnBorrar);
        
        JButton btnNewButton_2 = new JButton("Volver");
        btnNewButton_2.setFocusable(false);
        btnNewButton_2.setBounds(20, 11, 73, 54);
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

    private void actualizarVisor() {
        int maxCaracteres = 15;
        String texto = expresion.toString();
        if (texto.length() > maxCaracteres) {
            texto = texto.substring(desplazamiento, desplazamiento + maxCaracteres);
        }
        lblNewLabel.setText(texto);
    }

    private void abrirPanelPrincipal() {
        PanelPrincipal miBasica = new PanelPrincipal();
        miBasica.setVisible(true);
    }

    private double evaluarExpresion(String expresion) {
        String[] partes = expresion.split("(?<=[-+*/^√])|(?=[-+*/^√])");
        double resultado = 0;

        try {
            resultado = Double.parseDouble(partes[0]);

            for (int i = 1; i < partes.length; i += 2) {
                String operador = partes[i];
                double operando = Double.parseDouble(partes[i + 1]);

                switch (operador) {
                    case "+":
                        resultado += operando;
                        break;
                    case "-":
                        resultado -= operando;
                        break;
                    case "*":
                        resultado *= operando;
                        break;
                    case "/":
                        resultado /= operando;
                        break;
                    case "^":
                        resultado = Math.pow(resultado, operando);
                        break;
                    case "√":
                        if (i + 1 < partes.length) {
                            double radicando = Double.parseDouble(partes[i + 1]);
                            resultado = Math.pow(radicando, 1 / resultado);
                            i += 1; // Avanzamos el índice para omitir el radicando ya procesado
                        } else {
                            throw new IllegalArgumentException("Falta el radicando para la raíz");
                        }
                        break;
                    default:
                        throw new IllegalArgumentException("Operador no reconocido: " + operador);
                }
            }
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Error al convertir a número: " + e.getMessage());
        }

        return resultado;
    }
}
