package com.lupawktu.contekan.BangunDatar.Lingkaran;

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
 * Created by Mind on 5/13/2017.
 */

public class LingkaranActivity extends AppCompatActivity implements View.OnClickListener, MainView, ViewDetail {
    @BindView(R.id.jarijari)
    EditText jarijari;
    @BindView(R.id.luas)
    Button luas;
    @BindView(R.id.keliling)
    Button keliling;

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

    DetailPresenter detailPresenter = new DetailPresenter(this);

    Presenter presenter;
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lingkaran);
        ButterKnife.bind(this);

        String namafile = "lingkaran.json";
        detailPresenter.loadData(namafile);
        presenter = new Presenter(this);
        luas.setOnClickListener(this);
        keliling.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.luas :
                if(jarijari.getText().length() > 0) {
                    double r = Double.parseDouble(jarijari.getText().toString());
                    presenter.hitungLuas(r);
                } else {
                    alertPesan("Semua inputan harus diisi.");
                }
                break;
            case R.id.keliling :
                if(jarijari.getText().length() > 0) {
                    double r = Double.parseDouble(jarijari.getText().toString());
                    presenter.hitungKeliling(r);
                } else {
                    alertPesan("Semua inputan harus diisi.");
                }
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
                })
                .create();
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
                })
                .create();
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
