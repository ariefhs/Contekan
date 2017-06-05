package com.lupawktu.contekan.BangunDatar.JajarGenjang;

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

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mind on 5/14/2017.
 */
public class LuasJajarGenjangFragment extends Fragment implements MainView, View.OnClickListener {
    @BindView(R.id.alas)
    EditText alas;
    @BindView(R.id.tinggi)
    EditText tinggi;
    @BindView(R.id.hitung)
    Button hitung;

    Presenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.luas_jajargenjang, container, false);
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
    public void tampilkanLuas(LuasModel luasModel) {
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Hasil Luas")
                .setMessage(String.format("%.2f",luasModel.getLuas()))
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
        dialog.show();
    }

    @Override
    public void tampilkanKeliling(KelilingModel kelilingModel) {

    }

    @Override
    public void onClick(View view) {
        if(alas.getText().length() > 0
                && tinggi.getText().length() > 0){
            double a = Double.parseDouble(alas.getText().toString());
            double t = Double.parseDouble(tinggi.getText().toString());
            presenter.hitungLuas(a,t);
        }else{
            alert("Semua inputan harus diisi.");
        }
    }

    private void alert(String s) {
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Pesan")
                .setMessage(s)
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                })
                .create();
        dialog.show();
    }
}
