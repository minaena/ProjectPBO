/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MSI Modern
 */
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui2 {
    public static void main(String[] args) {
        // Frame Utama
        JFrame frame = new JFrame("Aplikasi Bangun Ruang");
        frame.setSize(400, 400);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new GridLayout(0, 1));

        // Label dan Dropdown Menu
        JLabel label = new JLabel("Pilih Bangun Ruang:");
        String[] bangunRuang = {"Balok", "Kubus", "Bola"};
        JComboBox<String> dropdown = new JComboBox<>(bangunRuang);
        
        // Tombol Submit
        JButton hitungButton = new JButton("Hitung");

        // Hasil
        JTextArea output = new JTextArea();
        output.setEditable(false);

        // Menambahkan Komponen ke Frame
        frame.add(label);
        frame.add(dropdown);
        frame.add(hitungButton);
        frame.add(new JScrollPane(output));

        // ActionListener Tombol
        hitungButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                String pilihan = (String) dropdown.getSelectedItem();
                output.setText(""); // Reset Output
                
                switch (pilihan) {
                    case "Balok":
                        int p = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Panjang Balok:"));
                        int l = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Lebar Balok:"));
                        int t = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Tinggi Balok:"));
                        Balok balok = new Balok(p, l, t);
                        output.append("Volume Balok: " + balok.getVolume() + "\n");
                        output.append("Luas Permukaan Balok: " + balok.getLuasPermukaan());
                        break;

                    case "Kubus":
                        int sisi = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Sisi Kubus:"));
                        Kubus kubus = new Kubus(sisi);
                        output.append("Volume Kubus: " + kubus.getVolume() + "\n");
                        output.append("Luas Permukaan Kubus: " + kubus.getLuasPermukaan());
                        break;

                    case "Bola":
                        int r = Integer.parseInt(JOptionPane.showInputDialog("Masukkan Jari-Jari Bola:"));
                        Bola bola = new Bola(r);
                        output.append("Volume Bola: " + bola.getVolume() + "\n");
                        output.append("Luas Permukaan Bola: " + bola.getLuasPermukaan());
                        break;

                    default:
                        output.append("Bangun Ruang Tidak Dikenali.");
                        break;
                }
            }
        });

        // Menampilkan Frame
        frame.setVisible(true);
    }
}
