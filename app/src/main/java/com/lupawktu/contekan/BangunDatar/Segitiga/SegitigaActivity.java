package com.lupawktu.contekan.BangunDatar.Segitiga;

import android.content.DialogInterface;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import com.lupawktu.contekan.BangunDatar.DetailPresenter;
import com.lupawktu.contekan.BangunDatar.ModelDetail;
import com.lupawktu.contekan.BangunDatar.ViewDetail;
import com.lupawktu.contekan.KelilingModel;
import com.lupawktu.contekan.LuasModel;
import com.lupawktu.contekan.BangunDatar.MainView;
import com.lupawktu.contekan.R;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mind on 5/11/2017.
 */

public class SegitigaActivity extends AppCompatActivity implements View.OnClickListener, MainView, ViewDetail {
    @BindView(R.id.alas)
    EditText alas;
    @BindView(R.id.tinggi)
    EditText tinggi;
    @BindView(R.id.sisi)
    EditText sisi;

    @BindView(R.id.deskripsi)
    TextView deskripsi;
    @BindView(R.id.websifat)
    TextView websifat;

    @BindView(R.id.rumusLuas)
    TextView rLuas;
    @BindView(R.id.rumusKeliling)
    TextView rKeliling;

    @BindView(R.id.ket)
    TextView ket;

    @BindView(R.id.showLuas)
    Button showLuas;
    @BindView(R.id.showKeliling)
    Button showKeliling;

    @BindView(R.id.hitung)
    Button hitung;
    Presenter presenter;
    DetailPresenter detailPresenter = new DetailPresenter(this);
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_segitiga);
        ButterKnife.bind(this);

        String namafile = "segitiga.json";
        detailPresenter.loadData(namafile);
        presenter = new Presenter(this);
        sisi.setVisibility(View.GONE);
        hitung.setOnClickListener(this);
        showLuas.setOnClickListener(this);
        showKeliling.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.hitung:
                if(sisi.getVisibility() == View.GONE){
                    // hitung luas
                    if(alas.getText().length() != 0
                            && tinggi.getText().length() != 0) {
                        double a = Double.parseDouble(alas.getText().toString());
                        double t = Double.parseDouble(tinggi.getText().toString());
                        presenter.hitungLuas(a, t);
                    }else{
                        alertPesan("Anda belum menginputkan nilai alas / tinggi");
                    }
                }else{
                    // hitung keliling
                    if(alas.getText().length() > 0
                            && tinggi.getText().length() > 0
                            && sisi.getText().length() > 0) {
                        double a = Double.parseDouble(alas.getText().toString());
                        double t = Double.parseDouble(tinggi.getText().toString());
                        double s = Double.parseDouble(sisi.getText().toString());
                        presenter.hitungKeliling(a, t, s);
                    }else{
                        alertPesan("Anda belum menginputkan nilai panjang / lebar / sisi.");
                    }
                }
                break;
            case R.id.showLuas:
                sisi.setVisibility(View.GONE);
                break;
            case R.id.showKeliling:
                sisi.setVisibility(View.VISIBLE);
                break;
        }
    }

    private void alertPesan(String s) {
        AlertDialog dialog = new AlertDialog.Builder(this)
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
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Hasil Luas")
                .setMessage(String.format("%.2f",luasModel.getLuas()))
                .setCancelable(false)
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
        AlertDialog dialog = new AlertDialog.Builder(this)
                .setTitle("Hasil Keliling")
                .setMessage(String.format("%.2f",kelilingModel.getKeliling()))
                .setCancelable(false)
                .setNegativeButton("OK", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                }).create();
        dialog.show();
    }

    @Override
    public void tampilDetail(ModelDetail model) {
        try {
            deskripsi.setText(model.getJson().getString("deskripsi"));
            websifat.setText(model.getJson().getString("sifat"));
            rLuas.setText("Luas : "+model.getJson().getString("luas"));
            rKeliling.setText("Keliling : "+model.getJson().getString("keliling"));
            ket.setText("Ket : "+model.getJson().getString("ket"));
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
}
