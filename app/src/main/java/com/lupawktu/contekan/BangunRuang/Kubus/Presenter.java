package com.lupawktu.contekan.BangunRuang.Kubus;

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

    public void hitungKeliling(double s) {
        double keliling = kelilingKubus(s);
        kelilingModel = new KelilingModel(keliling);
        view.tampilKeliling(kelilingModel);
    }

    private double kelilingKubus(double s) {
        return 12 * s;
    }

    public void hitungLuas(double s) {
        double luas = luasKubus(s);
        luasModel = new LuasModel(luas);
        view.tampilLuas(luasModel);
        }

    private double luasKubus(double s) {
        return 6 * (s * s);
    }

    public void hitungVolume(double s) {
        double volume = volumeKubus(s);
        volumeModel = new VolumeModel(volume);
        view.tampilVolume(volumeModel);
    }

    private double volumeKubus(double s) {
        return s * s * s;
    }
}
