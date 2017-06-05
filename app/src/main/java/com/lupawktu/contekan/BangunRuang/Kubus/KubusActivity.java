package com.lupawktu.contekan.BangunRuang.Kubus;

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
 * Created by Mind on 5/15/2017.
 */

public class KubusActivity extends AppCompatActivity implements View.OnClickListener, MainView {
    @BindView(R.id.luas)
    Button luas;
    @BindView(R.id.keliling)
    Button keliling;
    @BindView(R.id.volume)
    Button volume;
    @BindView(R.id.sisi)
    EditText sisi;

    Presenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_kubus);
        ButterKnife.bind(this);
        presenter = new Presenter(this);
        keliling.setOnClickListener(this);
        luas.setOnClickListener(this);
        volume.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.keliling:
                if(sisi.getText().length() > 0){
                    double s = Double.parseDouble(sisi.getText().toString());
                    presenter.hitungKeliling(s);
                }else{
                    alert("Semua inputan harus diisi.");
                }
                break;
            case R.id.luas:
                if(sisi.getText().length() > 0){
                    double s = Double.parseDouble(sisi.getText().toString());
                    presenter.hitungLuas(s);
                }else{
                    alert("Semua inputan harus diisi.");
                }
                break;
            case R.id.volume:
                if(sisi.getText().length() > 0){
                    double s = Double.parseDouble(sisi.getText().toString());
                    presenter.hitungVolume(s);
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
        new AlertDialog.Builder(this)
                .setTitle("Hasil Volume")
                .setMessage(String.format("%.2f",volumeModel.getVolume()))
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create().show();
    }

    @Override
    public void tampilKeliling(KelilingModel kelilingModel) {
        new AlertDialog.Builder(this)
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
