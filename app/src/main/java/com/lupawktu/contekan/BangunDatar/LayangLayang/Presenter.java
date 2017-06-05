package com.lupawktu.contekan.BangunDatar.LayangLayang;

import com.lupawktu.contekan.KelilingModel;
import com.lupawktu.contekan.LuasModel;
import com.lupawktu.contekan.BangunDatar.MainView;

/**
 * Created by Mind on 5/14/2017.
 */

public class Presenter {
    private MainView view;
    private LuasModel luasModel;
    private KelilingModel kelilingModel;

    public Presenter(MainView view){
        this.view = view;
    }

    public void hitungLuas(double dv, double dh) {
        double luas = luasLayang(dv,dh);
        luasModel = new LuasModel(luas);
        view.tampilkanLuas(luasModel);
    }

    private double luasLayang(double dv, double dh) {
        return 0.5 * (dv * dh);
    }

    public void hitungKeliling(double sv, double sh) {
        double keliling = kelilingLayang(sv, sh);
        kelilingModel = new KelilingModel(keliling);
        view.tampilkanKeliling(kelilingModel);
    }

    private double kelilingLayang(double sv, double sh) {
        return 2 * (sv + sh);
    }
}
