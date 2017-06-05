package com.lupawktu.contekan.BangunRuang.Limas;

import com.lupawktu.contekan.BangunRuang.MainView;
import com.lupawktu.contekan.LuasModel;
import com.lupawktu.contekan.VolumeModel;

/**
 * Created by Mind on 5/18/2017.
 */
public class Presenter {
    private MainView view;
    private LuasModel luasModel;
    private VolumeModel volumeModel;

    public Presenter(MainView view){
        this.view = view;
    }

    public void hitungLuas(double la, double ls) {
        double luas = luasLimas(la, ls);
        luasModel = new LuasModel(luas);
        view.tampilLuas(luasModel);
    }

    private double luasLimas(double la, double ls) {
        return la + ls;
    }

    public void hitungVolume(double la, double t) {
        double volume = volumeLimas(la, t);
        volumeModel = new VolumeModel(volume);
        view.tampilVolume(volumeModel);
    }

    private double volumeLimas(double la, double t) {
        return (double) (1 / 3) * la * t;
    }
}
