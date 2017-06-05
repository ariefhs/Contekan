package com.lupawktu.contekan.BangunRuang.Prisma;

import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import com.lupawktu.contekan.BangunRuang.MainView;
import com.lupawktu.contekan.KelilingModel;
import com.lupawktu.contekan.LuasModel;
import com.lupawktu.contekan.R;
import com.lupawktu.contekan.VolumeModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mind on 5/18/2017.
 */
public class LuasPrismaFragment extends Fragment implements MainView, View.OnClickListener {
    @BindView(R.id.la)
    EditText la;
    @BindView(R.id.ls)
    EditText ls;
    @BindView(R.id.hitung)
    Button hitung;
    Presenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.luas_prisma, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        presenter = new Presenter(this);
        hitung.setOnClickListener(this);
    }

    @Override
    public void tampilLuas(LuasModel luasModel) {
        new AlertDialog.Builder(getActivity())
                .setTitle("Hasil Luas")
                .setMessage(String.format("%.2f",luasModel.getLuas()))
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }

    @Override
    public void tampilVolume(VolumeModel volumeModel) {

    }

    @Override
    public void tampilKeliling(KelilingModel kelilingModel) {

    }

    @Override
    public void onClick(View view) {
        if(la.getText().length() > 0
                && ls.getText().length() > 0){
            double luasalas = Double.parseDouble(la.getText().toString());
            double luasselimut = Double.parseDouble(ls.getText().toString());
            presenter.hitungLuas(luasalas, luasselimut);
        }else{
            alert("Semua inputan harus diisi.");
        }
    }

    private void alert(String s) {
        new AlertDialog.Builder(getActivity())
                .setTitle("Pesan")
                .setMessage(s)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }
}
