package com.lupawktu.contekan.BangunDatar.Trapesium;

import com.lupawktu.contekan.KelilingModel;
import com.lupawktu.contekan.LuasModel;
import com.lupawktu.contekan.BangunDatar.MainView;

/**
 * Created by Mind on 5/12/2017.
 */

public class Presenter {
    private MainView view;
    private LuasModel luasModel;
    private KelilingModel kelilingModel;

    public Presenter(MainView view){
        this.view = view;
    }

    public void hitungKeliling(double a, double b, double c, double d) {
        double hasil = kelilingTrapesium(a, b, c, d);
        kelilingModel = new KelilingModel(hasil);
        view.tampilkanKeliling(kelilingModel);
    }

    private double kelilingTrapesium(double a, double b, double c, double d) {
        return a + b + c + d;
    }

    public void hitungLuas(double sa, double sb, double tinggi) {
        double hasil = luasTrapesium(sa, sb, tinggi);
        luasModel = new LuasModel(hasil);
        view.tampilkanLuas(luasModel);
    }

    private double luasTrapesium(double sa, double sb, double tinggi) {
        return 0.5 * (sa + sb) * tinggi;
    }
}
