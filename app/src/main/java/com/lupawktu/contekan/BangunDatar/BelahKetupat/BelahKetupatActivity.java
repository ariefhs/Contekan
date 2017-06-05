package com.lupawktu.contekan.BangunDatar.BelahKetupat;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.lupawktu.contekan.BangunDatar.DetailPresenter;
import com.lupawktu.contekan.BangunDatar.ModelDetail;
import com.lupawktu.contekan.BangunDatar.ViewDetail;
import com.lupawktu.contekan.R;

import org.json.JSONException;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Mind on 5/14/2017.
 */

public class BelahKetupatActivity extends AppCompatActivity implements View.OnClickListener, ViewDetail {
    @BindView(R.id.showKeliling)
    Button keliling;
    @BindView(R.id.showLuas)
    Button luas;
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

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belah_ketupat);
        ButterKnife.bind(this);
        String namafile = "belah_ketupat.json";
        detailPresenter.loadData(namafile);
        getFragmentManager()
                .beginTransaction()
                .add(R.id.fragment, new LuasBelahKetupatFragment())
                .commit();
        keliling.setOnClickListener(this);
        luas.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.showLuas:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, new LuasBelahKetupatFragment())
                        .commit();
                break;
            case R.id.showKeliling:
                getFragmentManager()
                        .beginTransaction()
                        .replace(R.id.fragment, new KelilingBelahKetupatFragment())
                        .commit();
                break;
        }
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
