package com.lupawktu.contekan.BangunDatar.BelahKetupat;

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

import com.lupawktu.contekan.KelilingModel;
import com.lupawktu.contekan.LuasModel;
import com.lupawktu.contekan.BangunDatar.MainView;
import com.lupawktu.contekan.R;
import com.lupawktu.contekan.VolumeModel;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mind on 5/14/2017.
 */
public class KelilingBelahKetupatFragment extends Fragment implements View.OnClickListener, MainView {
    @BindView(R.id.sisi)
    EditText sisi;
    @BindView(R.id.hitung)
    Button hitung;

    Presenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.keliling_belah_ketupat, container, false);
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
    public void onClick(View view) {
        if(sisi.getText().length() > 0){
            double s = Double.parseDouble(sisi.getText().toString());
            presenter.hitungKeliling(s);
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

    @Override
    public void tampilkanLuas(LuasModel luasModel) {

    }

    @Override
    public void tampilkanKeliling(KelilingModel kelilingModel) {
        new AlertDialog.Builder(getActivity())
                .setTitle("Hasil Keliling")
                .setMessage(String.format("%.2f",kelilingModel.getKeliling()))
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }
}
