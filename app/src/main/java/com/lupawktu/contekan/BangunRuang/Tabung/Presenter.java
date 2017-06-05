package com.lupawktu.contekan.BangunRuang.Tabung;

import com.lupawktu.contekan.BangunRuang.MainView;
import com.lupawktu.contekan.LuasModel;
import com.lupawktu.contekan.VolumeModel;

/**
 * Created by Mind on 5/17/2017.
 */
public class Presenter {
    private MainView view;
    private LuasModel luasModel;
    private VolumeModel volumeModel;

    public Presenter(MainView view){
        this.view = view;
    }

    public void hitungLuasSelimut(double jari2, double tinggi) {
        double luas = luasTabungSelimut(jari2, tinggi);
        luasModel = new LuasModel(luas);
        view.tampilLuas(luasModel);
    }

    private double luasTabungSelimut(double jari2, double tinggi) {
        return 2 * 3.14 * jari2 * (jari2 + tinggi);
    }

    public void hitungLuasPermukaan(double jari2, double tinggi) {
        double lp = luasTabungPermukaan(jari2, tinggi);
        luasModel = new LuasModel(lp);
        view.tampilLuas(luasModel);
    }

    private double luasTabungPermukaan(double jari2, double tinggi) {
        return (double) 2 * 3.14 * jari2 * tinggi;
    }

    public void hitungVolume(double jari2, double tinggi) {
        double v = volumeTabung(jari2, tinggi);
        volumeModel = new VolumeModel(v);
        view.tampilVolume(volumeModel);
    }

    private double volumeTabung(double jari2, double tinggi) {
        return 3.14 * (jari2 * jari2) * tinggi;
    }
}
