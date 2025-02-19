import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class App {
    private Date fecha = new Date();
    private JFrame frame = new JFrame("Calendario");
    private JLabel labelFecha = new JLabel("Fecha: " + fecha.toFechaAbreviadaString());
    private JTextField txtDia = new JTextField(2);
    private JTextField txtMes = new JTextField(2);
    private JTextField txtAnio = new JTextField(4);
    
    public App() {
        frame.setSize(300, 200);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        
        frame.add(labelFecha);
        frame.add(new JLabel("Día:")); frame.add(txtDia);
        frame.add(new JLabel("Mes:")); frame.add(txtMes);
        frame.add(new JLabel("Año:")); frame.add(txtAnio);
        
        JButton btnSetFecha = new JButton("Establecer Fecha");
        btnSetFecha.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                int dia = Integer.parseInt(txtDia.getText());
                int mes = Integer.parseInt(txtMes.getText());
                int anio = Integer.parseInt(txtAnio.getText());
                
                if (mes == 2 && dia > 29) {
                    JOptionPane.showMessageDialog(frame, "Febrero no puede tener más de 29 días.");
                    return;
                }
                
                fecha.setDia(dia);
                fecha.setMes(mes);
                fecha.setAnio(anio);
                labelFecha.setText("Fecha: " + fecha.toFechaAbreviadaString());
            }
        });
        frame.add(btnSetFecha);
        
        JButton btnAgregarDia = new JButton("Agregar Día");
        btnAgregarDia.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fecha.incrementarDia();
                labelFecha.setText("Fecha: " + fecha.toFechaAbreviadaString());
            }
        });
        frame.add(btnAgregarDia);
        
        JButton btnAgregarMes = new JButton("Agregar Mes");
        btnAgregarMes.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
                fecha.incrementarMes();
                labelFecha.setText("Fecha: " + fecha.toFechaAbreviadaString());
            }
        });
        frame.add(btnAgregarMes);
        
        frame.setVisible(true);
    }
    
}
