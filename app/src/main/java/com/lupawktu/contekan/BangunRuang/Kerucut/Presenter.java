package com.lupawktu.contekan.BangunRuang.Kerucut;

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

    public void hitungLuas(double r, double s) {
        double luas = luasKerucut(r, s);
        luasModel = new LuasModel(luas);
        view.tampilLuas(luasModel);
    }

    private double luasKerucut(double r, double s) {
        return 3.14 * r * (s + r);
    }

    public void hitungVolume(double jari2, double tinggi) {
        double volume = volumeKerucut(jari2, tinggi);
        volumeModel = new VolumeModel(volume);
        view.tampilVolume(volumeModel);
    }

    private double volumeKerucut(double jari2, double tinggi) {
        return (double) (1 / 3) * 3.14 * (jari2 * jari2) * tinggi;
    }
}
