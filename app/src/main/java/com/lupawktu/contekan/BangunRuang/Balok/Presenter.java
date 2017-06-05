package com.lupawktu.contekan.BangunRuang.Balok;

import com.lupawktu.contekan.BangunRuang.MainView;
import com.lupawktu.contekan.KelilingModel;
import com.lupawktu.contekan.LuasModel;
import com.lupawktu.contekan.VolumeModel;

/**
 * Created by Mind on 5/15/2017.
 */
public class Presenter {
    private MainView view;
    private LuasModel luasModel;
    private KelilingModel kelilingModel;
    private VolumeModel volumeModel;
    public Presenter(MainView view){
        this.view = view;
    }

    public void hitungLuas(double p, double l, double t) {
        double luas = luasBalok(p, l, t);
        luasModel = new LuasModel(luas);
        view.tampilLuas(luasModel);
    }

    private double luasBalok(double p, double l, double t) {
        return (double) 2 * ((p * l) + (p * t) + (l * t));
    }

    public void hitungKeliling(double p, double l, double t) {
        double keliling = kelilingBalok(p, l, t);
        kelilingModel = new KelilingModel(keliling);
        view.tampilKeliling(kelilingModel);
    }

    private double kelilingBalok(double p, double l, double t) {
        return (double) 4 * (p + l + t);
    }

    public void hitungVolume(double p, double l, double t) {
        double volume = volumeBalok(p, l, t);
        volumeModel = new VolumeModel(volume);
        view.tampilVolume(volumeModel);
    }

    private double volumeBalok(double p, double l, double t) {
        return p * l * t;
    }
}
