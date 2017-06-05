package com.lupawktu.contekan.BangunDatar.JajarGenjang;

import com.lupawktu.contekan.KelilingModel;
import com.lupawktu.contekan.LuasModel;
import com.lupawktu.contekan.BangunDatar.MainView;

/**
 * Created by Mind on 5/14/2017.
 */
public class Presenter {
    private MainView view;
    private LuasModel luasModel;
    private KelilingModel  kelilingModel;

    public Presenter(MainView view){
        this.view = view;
    }

    public void hitungLuas(double a, double t) {
        double luas = luasJajarGenjang(a,t);
        luasModel = new LuasModel(luas);
        view.tampilkanLuas(luasModel);
    }

    private double luasJajarGenjang(double a, double t) {
        return a * t;
    }

    public void hitungKeliling(double a, double b) {
        double keliling = kelilingJajarGenjang(a, b);
        kelilingModel = new KelilingModel(keliling);
        view.tampilkanKeliling(kelilingModel);
    }

    private double kelilingJajarGenjang(double a, double b) {
        return 2 * (a + b);
    }
}
