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
public class KelilingTrapesiumFragment extends Fragment implements View.OnClickListener, MainView {
    @BindView(R.id.ab)
    EditText ab;
    @BindView(R.id.cd)
    EditText cd;
    @BindView(R.id.bc)
    EditText bc;
    @BindView(R.id.da)
    EditText da;
    @BindView(R.id.hitung)
    Button hitung;

    Presenter presenter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.keliling_trapesium, container, false);
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
        if (ab.getText().length() > 0
                && bc.getText().length() > 0
                && cd.getText().length() > 0
                && da.getText().length() > 0){
            double nilai1 = Double.parseDouble(ab.getText().toString());
            double nilai2 = Double.parseDouble(bc.getText().toString());
            double nilai3 = Double.parseDouble(cd.getText().toString());
            double nilai4 = Double.parseDouble(da.getText().toString());
            presenter.hitungKeliling(nilai1, nilai2, nilai3, nilai4);
        }else{
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

    }

    @Override
    public void tampilkanKeliling(KelilingModel kelilingModel) {
        AlertDialog dialog = new AlertDialog.Builder(getActivity())
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
}
