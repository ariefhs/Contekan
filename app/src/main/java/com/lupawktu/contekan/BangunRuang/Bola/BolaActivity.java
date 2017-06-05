package com.lupawktu.contekan.BangunRuang.Bola;

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

public class BolaActivity extends AppCompatActivity implements MainView, View.OnClickListener {
    @BindView(R.id.r)
    EditText r;
    @BindView(R.id.luas)
    Button luas;
    @BindView(R.id.volume)
    Button volume;

    Presenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bola);
        ButterKnife.bind(this);

        presenter = new Presenter(this);
        luas.setOnClickListener(this);
        volume.setOnClickListener(this);
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

    }

    @Override
    public void onClick(View view) {
        switch(view.getId()){
            case R.id.luas:
                if(r.getText().length() > 0){
                    double jari = Double.parseDouble(r.getText().toString());
                    presenter.hitungLuas(jari);
                }else{
                    alert("Semua inputan harus diiisi");
                }
                break;
            case R.id.volume:
                if(r.getText().length() > 0){
                    double jari = Double.parseDouble(r.getText().toString());
                    presenter.hitungVolume(jari);
                }else{
                    alert("Semua inputan harus diiisi");
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
}
