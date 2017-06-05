package com.lupawktu.contekan.BangunDatar.Persegi;

import com.lupawktu.contekan.KelilingModel;
import com.lupawktu.contekan.LuasModel;
import com.lupawktu.contekan.BangunDatar.MainView;

/**
 * Created by Mind on 5/10/2017.
 */

public class Presenter {
    private MainView view;
    private LuasModel luasModel;
    private KelilingModel kelilingModel;

    public Presenter(MainView view){
        this.view = view;
    }

    public void hitungLuas(double sisi){
        double luas = luasPersegi(sisi);
        luasModel = new LuasModel(luas);
        view.tampilkanLuas(luasModel);
    }

    public void hitungKeliling(double sisi){
        double keliling = kelilingPersegi(sisi);
        kelilingModel = new KelilingModel(keliling);
        view.tampilkanKeliling(kelilingModel);
    }

    private double kelilingPersegi(double sisi) {
        return 4 * sisi;
    }

    private double luasPersegi(double sisi) {
        return sisi * sisi;
    }
}
