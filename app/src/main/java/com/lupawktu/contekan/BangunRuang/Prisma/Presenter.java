package com.lupawktu.contekan.BangunRuang.Prisma;

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

    public void hitungLuas(double la, double ls) {
        double luas = luasPrisma(la, ls);
        luasModel = new LuasModel(luas);
        view.tampilLuas(luasModel);
    }

    private double luasPrisma(double la, double ls) {
        return ((double) 2 * la) + ls;
    }

    public void hitungVolume(double la, double t) {
        double volume = volumePrisma(la, t);
        volumeModel = new VolumeModel(volume);
        view.tampilVolume(volumeModel);
    }

    private double volumePrisma(double la, double t) {
        return la * t;
    }
}
