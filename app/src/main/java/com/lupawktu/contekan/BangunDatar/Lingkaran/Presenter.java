package com.lupawktu.contekan.BangunDatar.Lingkaran;

import com.lupawktu.contekan.KelilingModel;
import com.lupawktu.contekan.LuasModel;
import com.lupawktu.contekan.BangunDatar.MainView;

/**
 * Created by Mind on 5/13/2017.
 */

public class Presenter {
    private MainView view;
    private KelilingModel kelilingModel;
    private LuasModel luasModel;
    public Presenter(MainView view){
        this.view = view;
    }

    public void hitungLuas(double r){
        double luas = luasLingkarang(r);
        luasModel = new LuasModel(luas);
        view.tampilkanLuas(luasModel);
    }

    private double luasLingkarang(double r) {
        return 3.14 * (r * r);
    }

    public void hitungKeliling(double r) {
        double keliling = kelilingLingkaran(r);
        kelilingModel = new KelilingModel(keliling);
        view.tampilkanKeliling(kelilingModel);
    }

    private double kelilingLingkaran(double r) {
        return 3.14 * (2 * r);
    }
}
