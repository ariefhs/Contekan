package com.lupawktu.contekan.BangunDatar.Segitiga;

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

    public void hitungLuas(double alas, double tinggi){
        double luas = luasSegitiga(alas, tinggi);
        luasModel = new LuasModel(luas);
        view.tampilkanLuas(luasModel);
    }

    public void hitungKeliling(double ab, double bc, double ac){
        double keliling = kelilingSegitiga(ab, bc, ac);
        kelilingModel = new KelilingModel(keliling);
        view.tampilkanKeliling(kelilingModel);
    }

    private double kelilingSegitiga(double ab, double bc, double ac) {
        return ab + ac + bc;
    }

    private double luasSegitiga(double alas, double tinggi) {
        return 0.5 * (alas * tinggi);
    }
}
