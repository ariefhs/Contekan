package com.lupawktu.contekan.BangunRuang.Bola;

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

    public Presenter(MainView view) {
        this.view = view;
    }

    public void hitungLuas(double jari) {
        double luas = luasBola(jari);
        luasModel = new LuasModel(luas);
        view.tampilLuas(luasModel);
    }

    private double luasBola(double r) {
        return 4 * 3.14 * r * r;
    }

    public void hitungVolume(double r) {
        double volume = volumeBola(r);
        volumeModel = new VolumeModel(volume);
        view.tampilVolume(volumeModel);
    }

    private double volumeBola(double r) {
        double a = (double) 4 / 3;
        double b = 3.14 * r * r * r;
        return  a * b;
    }
}
