/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

/**
 *
 * @author MSI Modern
 */    

import java.awt.Color;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class gui{
    private JFrame frame;
    private JTextField txtSisi, txtPanjang, txtLebar, txtJariJari, txtAlas, txtTinggi, txtGarisPelukis;
    private JTextArea txtHasil;
    private JComboBox<String> comboBangun;
    private JLabel lblSisi, lblPanjang, lblLebar, lblJariJari, lblAlas, lblTinggi, lblGarisPelukis;

    public gui() {
        //Frame Utama
        frame = new JFrame("Hitung Luas dan Keliling Bangun Datar");
        frame.setSize(400, 400); //set ukuran JFrame
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null); // null karena pakai posisi koordinat setBounds
        
        // Mengatur warna latar belakang JFrame
        frame.getContentPane().setBackground(Color.LIGHT_GRAY);

        // Pilihan Bangun Datar
        JLabel lblBangun = new JLabel("Pilih Bangun Datar :");
        lblBangun.setBounds(20, 20, 150, 25);
        frame.add(lblBangun);
        

        String[] bangunDatar = {"Persegi", "Lingkaran", "Persegi Panjang", "Segitiga"};
        comboBangun = new JComboBox<>(bangunDatar);
        comboBangun.setBounds(180, 20, 150, 25);
        frame.add(comboBangun);

        // Input Persegi=================================
        lblSisi = new JLabel("Masukkan Sisi :");
        lblSisi.setBounds(20, 60, 150, 25);
        frame.add(lblSisi);

        txtSisi = new JTextField();
        txtSisi.setBounds(180, 60, 150, 25);
        frame.add(txtSisi);

        // Input Lingkaran ==============================
        lblJariJari = new JLabel("Masukkan Jari-Jari :");
        lblJariJari.setBounds(20, 60, 200, 25);
        frame.add(lblJariJari);

        txtJariJari = new JTextField();
        txtJariJari.setBounds(180, 60, 150, 25);
        frame.add(txtJariJari);

        // Input Persegi Panjang ========================
        lblPanjang = new JLabel("Masukkan Panjang :");
        lblPanjang.setBounds(20, 60, 150, 25);
        frame.add(lblPanjang);

        txtPanjang = new JTextField();
        txtPanjang.setBounds(180, 60, 150, 25);
        frame.add(txtPanjang);

        lblLebar = new JLabel("Masukkan Lebar :");
        lblLebar.setBounds(20, 100, 200, 25);
        frame.add(lblLebar);

        txtLebar = new JTextField();
        txtLebar.setBounds(180, 100, 150, 25);
        frame.add(txtLebar);

        // Input Segitiga ================================
        lblAlas = new JLabel("Masukkan Alas :");
        lblAlas.setBounds(20, 60, 150, 25);
        frame.add(lblAlas);

        txtAlas = new JTextField();
        txtAlas.setBounds(180, 60, 150, 25); //teks box alas
        frame.add(txtAlas);

        lblTinggi = new JLabel("Masukkan Tinggi :");
        lblTinggi.setBounds(20, 100, 200, 25);
        frame.add(lblTinggi);

        txtTinggi = new JTextField();
        txtTinggi.setBounds(180, 100, 150, 25); //teks box tinggi
        frame.add(txtTinggi);
        
        lblGarisPelukis = new JLabel("Masukkan Garis Pelukis :");
        lblGarisPelukis.setBounds(20, 140, 200, 25);
        frame.add(lblGarisPelukis);

        txtGarisPelukis = new JTextField();
        txtGarisPelukis.setBounds(180, 140, 150, 25); //teks box sisi miring
        frame.add(txtGarisPelukis);

        // Tombol=========================================
        JButton btnHitung = new JButton("Hitung");
        btnHitung.setBounds(20, 300, 100, 25);
        frame.add(btnHitung);

        JButton btnReset = new JButton("Reset");
        btnReset.setBounds(130, 300, 100, 25);
        frame.add(btnReset);

        // Output
        txtHasil = new JTextArea();
        txtHasil.setEditable(false);
        JScrollPane scrollPane = new JScrollPane(txtHasil);
        scrollPane.setBounds(20, 170, 310, 100);
        frame.add(scrollPane);

        // Event Listeners
        comboBangun.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                updateInputFields();
            }
        });

        btnHitung.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                hitung();
            }
        });

        btnReset.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                resetFields();
            }
        });

        // Atur visibilitas awal
        updateInputFields();
        frame.setVisible(true);
    }

    private void updateInputFields() {
        String selectedBangun = (String) comboBangun.getSelectedItem();

        // Reset semua elemen
        ///Persegi
        lblSisi.setVisible(false);
        txtSisi.setVisible(false);

        //Lingkaran
        lblJariJari.setVisible(false);
        txtJariJari.setVisible(false);

        //Persegi Panjang
        lblPanjang.setVisible(false);
        txtPanjang.setVisible(false);
        lblLebar.setVisible(false);
        txtLebar.setVisible(false);

        //Segitiga
        lblAlas.setVisible(false);
        txtAlas.setVisible(false);
        lblTinggi.setVisible(false);
        txtTinggi.setVisible(false);
        lblGarisPelukis.setVisible(false);
        txtGarisPelukis.setVisible(false);

        // Tampilkan pilihan
        switch (selectedBangun) {
            case "Persegi":
                lblSisi.setVisible(true);
                txtSisi.setVisible(true);
                break;
            case "Lingkaran":
                lblJariJari.setVisible(true);
                txtJariJari.setVisible(true);
                break;
            case "Persegi Panjang":
                lblPanjang.setVisible(true);
                txtPanjang.setVisible(true);
                lblLebar.setVisible(true);
                txtLebar.setVisible(true);
                break;
            case "Segitiga":
                lblAlas.setVisible(true);
                txtAlas.setVisible(true);
                lblTinggi.setVisible(true);
                txtTinggi.setVisible(true);
                lblGarisPelukis.setVisible(true);
                txtGarisPelukis.setVisible(true);
                break;
        }
    }

    private void hitung() {
        try {
            String selectedBangun = (String) comboBangun.getSelectedItem();
            switch (selectedBangun) {
                case "Persegi":
                    double sisi = Double.parseDouble(txtSisi.getText());
                    txtHasil.setText("Luas: " + (sisi * sisi) + 
                                    "\nKeliling: " + (4 * sisi));
                    break;
                case "Lingkaran":
                    double jariJari = Double.parseDouble(txtJariJari.getText());
                    txtHasil.setText("Luas: " + (Math.PI * jariJari * jariJari) + 
                                    "\nKeliling: " + (2 * Math.PI * jariJari));
                    break;
                case "Persegi Panjang":
                    double panjang = Double.parseDouble(txtPanjang.getText());
                    double lebar = Double.parseDouble(txtLebar.getText());
                    txtHasil.setText("Luas : " + (panjang * lebar) + 
                                    "\nKeliling : " + (2 * (panjang + lebar)));
                    break;
                case "Segitiga":
                    double alas = Double.parseDouble(txtAlas.getText());
                    double tinggi = Double.parseDouble(txtTinggi.getText());
                    double garisPelukis = Double.parseDouble(txtGarisPelukis.getText());
                    txtHasil.setText("Luas: " + (0.5 * alas * tinggi) +
                                    "Keliling: " + (alas + tinggi + garisPelukis));
                    break;
            }
        } catch (NumberFormatException e) {
            txtHasil.setText("Input tidak valid. Masukkan angka.");
        }
    }

    private void resetFields() {
        txtSisi.setText("");
        txtJariJari.setText("");
        txtPanjang.setText("");
        txtLebar.setText("");
        txtAlas.setText("");
        txtTinggi.setText("");
        txtGarisPelukis.setText("");
        txtHasil.setText("");
        comboBangun.setSelectedIndex(0);
        updateInputFields();
    }

    public static void main(String[] args) {
        new gui();
    }
}