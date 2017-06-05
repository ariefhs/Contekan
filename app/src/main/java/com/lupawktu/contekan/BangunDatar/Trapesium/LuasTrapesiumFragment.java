package com.lupawktu.contekan.BangunDatar.Trapesium;

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
 * Created by Mind on 5/12/2017.
 */
public class LuasTrapesiumFragment extends Fragment implements View.OnClickListener, MainView {

    @BindView(R.id.sisiAtas)
    EditText sisiAtas;
    @BindView(R.id.sisiBawah)
    EditText sisiBawah;
    @BindView(R.id.tinggi)
    EditText tinggi;
    @BindView(R.id.hitung)
    Button hitung;

    Presenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.luas_trapesium, container, false);
        ButterKnife.bind(this, view);
        presenter = new Presenter(this);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hitung.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (sisiAtas.getText().length() > 0
                && sisiBawah.getText().length() > 0
                && tinggi.getText().length() > 0){
            double sa = Double.parseDouble(sisiAtas.getText().toString());
            double sb = Double.parseDouble(sisiBawah.getText().toString());
            double t = Double.parseDouble(tinggi.getText().toString());
            presenter.hitungLuas(sa, sb, t);
        } else {
            alertPesan("Semua inputan harus diisi.");
        }
    }

    private void alertPesan(String s) {
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
}
