package com.lupawktu.contekan.BangunRuang.Limas;

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
public class VolumeLimasFragment extends Fragment implements MainView, View.OnClickListener {
    @BindView(R.id.hitung)
    Button hitung;
    @BindView(R.id.la)
    EditText luasalas;
    @BindView(R.id.tinggi)
    EditText tinggi;

    Presenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.volume_limas, container, false);
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

    }

    @Override
    public void tampilVolume(VolumeModel volumeModel) {
        new AlertDialog.Builder(getActivity())
                .setTitle("Hasil Volume")
                .setMessage(String.format("%.2f", volumeModel.getVolume()))
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }

    @Override
    public void tampilKeliling(KelilingModel kelilingModel) {

    }

    @Override
    public void onClick(View view) {
        if(luasalas.getText().length() > 0
                && tinggi.getText().length() > 0){
            double la = Double.parseDouble(luasalas.getText().toString());
            double t = Double.parseDouble(tinggi.getText().toString());
            presenter.hitungVolume(la, t);
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
