/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package newpackage;

import gnu.io.CommPortIdentifier;
import gnu.io.SerialPort;
import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.FileDescriptor;
import java.io.OutputStream;
import java.util.Enumeration;
import java.util.LinkedList;
import javax.swing.JButton;
import javax.swing.JFrame;
import static javax.swing.JFrame.EXIT_ON_CLOSE;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

/**
 *
 * @author CesarMoreno
 */
public class Interfaces extends JFrame {

    private JButton derecha, izquierda, cerrar, abrir, abajoCodo, abajoHombro, arribaCodo, arribaHombro, generar, automatico,borrar;
    private JPanel panel;
    // private String der, izq, cer, abri, abC, abH, arC, arH;
    private OutputStream ouput;
    SerialPort serialport;
    private String puerto;
    private int time, dataRate;
    private boolean con, gem;
    String sec;
    LinkedList<Lista> lista = new LinkedList<>();

    public Interfaces() {
        super("Control");
        gem = false;
        sec = "";
        setLayout(null);
        puerto = "COM5";
        time = 2000;
        con = false;
        dataRate = 9600;
        ouput = null;
        panel = new JPanel(null);
        borrar = new JButton("Borrar secuencia");
        derecha = new JButton("Derecha");
        generar = new JButton("Generar secuencia");
        izquierda = new JButton("Izquierda");
        arribaHombro = new JButton("Subir Hombro");
        arribaCodo = new JButton("Subir Codo");
        abajoCodo = new JButton("Bajar codo");
        abajoHombro = new JButton("Bajar Hombro");
        cerrar = new JButton("Cerrar pinzas");
        abrir = new JButton("Abrir pinzas");
        automatico = new JButton("Automatico");
        borrar.setBackground(Color.lightGray);
        derecha.setBackground(Color.lightGray);
        izquierda.setBackground(Color.lightGray);
        arribaHombro.setBackground(Color.lightGray);
        arribaCodo.setBackground(Color.lightGray);
        abajoCodo.setBackground(Color.lightGray);
        abajoHombro.setBackground(Color.lightGray);
        cerrar.setBackground(Color.lightGray);
        abrir.setBackground(Color.lightGray);
        automatico.setBackground(Color.lightGray);
        generar.setBackground(Color.lightGray);
        derecha.setBounds(250, 150, 150, 50);
        izquierda.setBounds(50, 150, 150, 50);
        arribaHombro.setBounds(50, 75, 150, 50);
        arribaCodo.setBounds(250, 75, 150, 50);
        abajoHombro.setBounds(50, 225, 150, 50);
        abajoCodo.setBounds(250, 225, 150, 50);
        abrir.setBounds(50, 300, 150, 50);
        cerrar.setBounds(250, 300, 150, 50);
        automatico.setBounds(50, 15, 150, 50);
        generar.setBounds(250, 15, 150, 50);
        borrar.setBounds(175, 400, 150, 50);
        add(derecha);
        add(izquierda);
        add(arribaCodo);
        add(arribaHombro);
        add(abajoCodo);
        add(abajoHombro);
        add(abrir);
        add(cerrar);
        add(panel);
        add(automatico);
        add(generar);
        add(borrar);
        Conection();
        arribaHombro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gem == true) {
                    sec = "1";
                    enviarDatos("1");
                    lista.add(new Lista(sec));
                } else {
                    enviarDatos("1");
                }
            }
        });
        abajoHombro.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gem == true) {
                    sec = "2";
                    lista.add(new Lista(sec));
                    enviarDatos("2");
                } else {
                    enviarDatos("2");
                }

            }
        });
        izquierda.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gem == true) {
                    sec = "4";
                    lista.add(new Lista(sec));
                    enviarDatos("4");
                } else {
                    enviarDatos("4");
                }
            }
        });
        derecha.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gem == true) {
                    sec = "3";
                    lista.add(new Lista(sec));
                     enviarDatos("3");
                } else {
                    enviarDatos("3");
                }
            }
        });
        arribaCodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gem == true) {
                    sec = "5";
                    lista.add(new Lista(sec));
                    enviarDatos("5");
                } else {
                    enviarDatos("5");
                }
            }
        });
        abajoCodo.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gem == true) {
                    sec = "6";
                    lista.add(new Lista(sec));
                    enviarDatos("6");
                } else {
                    enviarDatos("6");
                }
            }
        });
        abrir.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gem == true) {
                    sec = "7";
                    lista.add(new Lista(sec));
                    enviarDatos("7");
                } else {
                    enviarDatos("7");
                }
            }
        });
        cerrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gem == true) {
                    sec = "8";
                    lista.add(new Lista(sec));
                    enviarDatos("8");
                } else {
                    enviarDatos("8");
                }
            }
        });
        automatico.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (gem == true) {
                    enviarDatos("9");
                    for (int i = 0; i < lista.size(); i++) {
                        System.out.println(lista.get(i).secuencia);
                        enviarDatos(lista.get(i).secuencia);
                        
                    }
                  
                } else {
                    enviarDatos("9");
                }
            }
        });
        generar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gem = true;
                JOptionPane.showMessageDialog(null, "Presione los botones para generar secuencia");
            }
        });
        borrar.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                gem = false;
                lista.clear();
            }
        });
    }

    public boolean Conection() {

        CommPortIdentifier puertoId = null;
        Enumeration puertoEnum = CommPortIdentifier.getPortIdentifiers();
        while (puertoEnum.hasMoreElements()) {
            CommPortIdentifier ActualPuerto = (CommPortIdentifier) puertoEnum
                    .nextElement();
            if (puerto.equals(ActualPuerto.getName())) {
                puertoId = ActualPuerto;
                break;
            }
        }
        if (puertoId == null) {
            mostrarError("No se puede conectar ");
            System.exit(ERROR);
        }
        try {
            serialport = (SerialPort) puertoId.open(this.getClass().getName(), time);
            //parametros puerto serie
            serialport.setSerialPortParams(dataRate, SerialPort.DATABITS_8, SerialPort.STOPBITS_1, SerialPort.PARITY_NONE);
            ouput = serialport.getOutputStream();
        } catch (Exception e) {
            mostrarError(e.getMessage());
            System.exit(ERROR);
        }

        return con;
    }

    private void enviarDatos(String Datos) {
        try {
            ouput.write(Datos.getBytes());
        } catch (Exception e) {
            mostrarError("Error");
            System.exit(ERROR);
        }
    }

    public void mostrarError(String err) {
        JOptionPane.showMessageDialog(this, err, "ERROR", JOptionPane.ERROR_MESSAGE);
    }

    public static void main(String[] args) {
        Interfaces obj = new Interfaces();
        obj.setDefaultCloseOperation(EXIT_ON_CLOSE);
        obj.setSize(450, 600);
        obj.setLocation(450, 250);
        obj.setResizable(false);
        obj.setVisible(true);
    }
}
