package com.lupawktu.contekan.BangunDatar.BelahKetupat;


import com.lupawktu.contekan.KelilingModel;
import com.lupawktu.contekan.LuasModel;
import com.lupawktu.contekan.BangunDatar.MainView;

/**
 * Created by Mind on 5/14/2017.
 */

public class Presenter{
    private MainView view;
    private LuasModel luasModel;
    private KelilingModel kelilingModel;
    public Presenter(MainView view){
        this.view = view;
    }

    public void hitungLuas(double dd1, double dd2) {
        double luas = luasbk(dd1, dd2);
        luasModel = new LuasModel(luas);
        view.tampilkanLuas(luasModel);
    }

    private double luasbk(double dd1, double dd2) {
        return 0.5 * dd1 * dd2;
    }

    public void hitungKeliling(double s) {
        double keliling = kelilingbk(s);
        kelilingModel = new KelilingModel(keliling);
        view.tampilkanKeliling(kelilingModel);
    }

    private double kelilingbk(double s) {
        return 4 * s;
    }
}
