package com.lupawktu.contekan.BangunDatar.PersegiPanjang;

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

    public Presenter(PersegiPanjangActivity view){
        this.view = view;
    }

    public void hitungLuas(double panjang, double lebar){
        double luas = luasPersegiPanjang(panjang, lebar);
        luasModel = new LuasModel(luas);
        view.tampilkanLuas(luasModel);
    }

    public void hitungKeliling(double panjang, double lebar){
        double keliling = kelilingPersegiPanjang(panjang, lebar);
        kelilingModel = new KelilingModel(keliling);
        view.tampilkanKeliling(kelilingModel);
    }

    private double kelilingPersegiPanjang(double panjang, double lebar) {
        return (2 * panjang) + (2 * lebar);
    }

    private double luasPersegiPanjang(double panjang, double lebar) {
        return panjang *  lebar;
    }

}
