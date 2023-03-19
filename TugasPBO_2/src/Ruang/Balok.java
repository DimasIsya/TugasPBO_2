package Ruang;

import Bidang.PersegiPanjang;

public class Balok extends PersegiPanjang implements MenghitungRuang{
    private double tinggi;
    private double panjang;
    private double lebar;

    public Balok(double panjang, double lebar, double tinggi) {
        super(panjang, lebar);
        this.tinggi = tinggi;
    }

    @Override
    public double hitungVolume() {
        return hitungLuas() * tinggi;
    }

    @Override
    public double hitungLuasPermukaan() {
        return 2 * (hitungLuas() + (panjang * tinggi) + (lebar * tinggi) + (panjang * lebar));
    }
}
