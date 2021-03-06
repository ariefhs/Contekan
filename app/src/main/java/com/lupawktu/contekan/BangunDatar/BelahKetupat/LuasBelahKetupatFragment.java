package com.lupawktu.contekan.BangunDatar.BelahKetupat;

import android.app.AlertDialog;
import android.app.Fragment;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
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
public class LuasBelahKetupatFragment extends Fragment implements MainView, View.OnClickListener {
    @BindView(R.id.d1)
    EditText d1;
    @BindView(R.id.d2)
    EditText d2;
    @BindView(R.id.hitung)
    Button hitung;

    Presenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.luas_belah_ketupat, container, false);
        ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        hitung.setOnClickListener(this);
        presenter = new Presenter(this);
    }

    @Override
    public void tampilkanLuas(LuasModel luasModel) {
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Hasil Luas")
                .setMessage(String.format("%.2f",luasModel.getLuas()))
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create();
        dialog.show();
    }

    @Override
    public void tampilkanKeliling(KelilingModel kelilingModel) {

    }

    @Override
    public void onClick(View view) {
        if(d1.getText().length() > 0
                && d2.getText().length() > 0){
            double dd1 = Double.parseDouble(d1.getText().toString());
            double dd2 = Double.parseDouble(d2.getText().toString());
            presenter.hitungLuas(dd1,dd2);
        }else{
            alert("Semua inputan harus diisi.");
        }
    }

    private void alert(String s) {
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
                .setTitle("Pesan")
                .setMessage(s)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create();
        dialog.show();
    }
}
