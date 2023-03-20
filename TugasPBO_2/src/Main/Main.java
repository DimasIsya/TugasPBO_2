package Main;

import Ruang.Balok;
import java.awt.event.*;
import java.awt.*;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JFrame;
import javax.swing.JLabel;




public class Main extends JFrame implements ActionListener {
    
    //Deklarasi Label
    JLabel lTitle,lPanjang,lLebar,lTinggi,lHasil,lLuas,lKeliling,lVolume,lLuasPermukaan;
    //Deklarasi Teks
    JTextField PanjangTeks, LebarTeks,TinggiTeks;
    //Deklarasi Button
    JButton hitungButton,resetButton;
    
    /**
     *
     */
    public Main(){

        lTitle = new JLabel("Cuboid Calculator");
        lPanjang = new JLabel("Panjang");
        lLebar = new JLabel("Lebar");
        lTinggi = new JLabel("Tinggi");
        lHasil = new JLabel("Hasil :");
        lLuas = new JLabel();
        lKeliling = new JLabel();
        lVolume = new JLabel();
        lLuasPermukaan = new JLabel();
        
        lTitle.setBounds(220,30,200,30);
        lTitle.setFont(new Font(null, Font.BOLD, 16));
        
        lPanjang.setBounds(80, 110, 100, 40);
        lPanjang.setFont(new Font(null, Font.BOLD, 16));

        lLebar.setBounds(80, 175, 100, 40);
        lLebar.setFont(new Font(null, Font.BOLD, 16));
        
        lTinggi.setBounds(80, 240, 100, 40);
        lTinggi.setFont(new Font(null, Font.BOLD, 16));
        
        lHasil.setBounds(207, 275, 100, 40);
        lHasil.setFont(new Font(null, Font.BOLD, 16));

        lLuas.setBounds(80, 325, 400, 40);
        lLuas.setFont(new Font(null, Font.BOLD, 14));
        
        lKeliling.setBounds(80, 370,400, 40);
        lKeliling.setFont(new Font(null, Font.BOLD, 14));

        lVolume.setBounds(80, 413, 400, 40);
        lVolume.setFont(new Font(null, Font.BOLD, 14));

        lLuasPermukaan.setBounds(80, 455, 400, 40);
        lLuasPermukaan.setFont(new Font(null, Font.BOLD, 14));
        
        //Pengaturan Teks
        PanjangTeks = new JTextField();
        LebarTeks = new JTextField();
        TinggiTeks = new JTextField();

        PanjangTeks.setBounds(200,120,240,25);
        LebarTeks.setBounds(200,183,240,25);
        TinggiTeks.setBounds(200,250,240,25);
        
        //Button
        hitungButton = new JButton("Hitung");
        resetButton = new JButton("Reset");

        hitungButton.setBounds(185,540,100,23);
        resetButton.setBounds(295,540,100,23);
        
        
        //Setting JFrame
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
        setResizable(false);
        setSize(570,610);
        setLocationRelativeTo(null);
        setLayout(null);

        add(lTitle);
        add(lPanjang);
        add(lLebar);
        add(lTinggi);
        add(lLuas);
        add(lKeliling);
        add(lVolume);
        add(lLuasPermukaan);
        add(PanjangTeks);
        add(LebarTeks);
        add(TinggiTeks);
        add(lHasil);
        add(hitungButton);
        add(resetButton);

        //Event Handling (Button)
        hitungButton.addActionListener(this);
        resetButton.addActionListener(this);
    }
    @Override
    public void actionPerformed(ActionEvent ae) {
        if(ae.getSource() == hitungButton){
            try {
                double l =  Double.parseDouble(PanjangTeks.getText());
                double w =  Double.parseDouble(LebarTeks.getText());
                double h =  Double.parseDouble(TinggiTeks.getText());
                
                Balok balok = new Balok (l, w, h);

                lLuas.setText(String.format("Luas Persegi Panjang          : %.2f",balok.hitungLuas()));
                lKeliling.setText(String.format("Keliling Persegi Panjang  : %.2f", balok.hitungKeliling()));
                lVolume.setText(String.format("Volume Balok                : %.2f", balok.hitungVolume()));
                lLuasPermukaan.setText(String.format("Luas Permukaan Balok : %.2f", balok.hitungLuasPermukaan()));
                
            } catch (NumberFormatException nfe) {
                JOptionPane.showMessageDialog(null, nfe.getMessage(), "Message", JOptionPane.INFORMATION_MESSAGE);
            } catch (Exception e){
                JOptionPane.showMessageDialog(null, "Terjadi Error, Masukkan Input Yang Benar", "Error", JOptionPane.ERROR_MESSAGE);
            }
        }
        
        if(ae.getSource() == resetButton){
            PanjangTeks.setText(null);
            LebarTeks.setText(null);
            TinggiTeks.setText(null);
            lLuas.setText(null);
            lKeliling.setText(null);
            lVolume.setText(null);
            lLuasPermukaan.setText(null);
        }

    }
    
    public static void main(String[] args) {
        new Main();

    }
}
