package com.lupawktu.contekan.BangunRuang.Tabung;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
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
 * Created by Mind on 5/17/2017.
 */

public class TabungActivity extends AppCompatActivity implements View.OnClickListener, MainView {
    @BindView(R.id.jari2)
    EditText r;
    @BindView(R.id.tinggi)
    EditText t;
    @BindView(R.id.luas)
    Button luas;
    @BindView(R.id.luas_permukaan)
    Button luas_permukaan;
    @BindView(R.id.volume)
    Button volume;

    Presenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tabung);
        ButterKnife.bind(this);
        presenter = new Presenter(this);
        luas.setOnClickListener(this);
        luas_permukaan.setOnClickListener(this);
        volume.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.luas:
                if(r.getText().length() > 0
                        && t.getText().length() > 0){
                    double jari2 = Double.parseDouble(r.getText().toString());
                    double tinggi = Double.parseDouble(t.getText().toString());
                    presenter.hitungLuasSelimut(jari2, tinggi);
                }else{
                    alert("Semua inputa harus diisi.");
                }
                break;
            case R.id.luas_permukaan:
                if(r.getText().length() > 0
                        && t.getText().length() > 0){
                    double jari2 = Double.parseDouble(r.getText().toString());
                    double tinggi = Double.parseDouble(t.getText().toString());
                    presenter.hitungLuasPermukaan(jari2, tinggi);
                }else{
                    alert("Semua inputan harus diisi.");
                }
                break;
            case R.id.volume:
                if(r.getText().length() > 0
                        && t.getText().length() > 0){
                    double jari2 = Double.parseDouble(r.getText().toString());
                    double tinggi = Double.parseDouble(t.getText().toString());
                    presenter.hitungVolume(jari2, tinggi);
                }else{
                    alert("Semua inputan harus diisi.");
                }
                break;
        }
    }

    private void alert(String s) {
        new AlertDialog.Builder(this)
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
    public void tampilLuas(LuasModel luasModel) {
        new AlertDialog.Builder(this)
                .setTitle("Hasil Luas")
                .setMessage(String.format("%.2f", luasModel.getLuas()))
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }

    @Override
    public void tampilVolume(VolumeModel volumeModel) {
        new AlertDialog.Builder(this)
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
}
