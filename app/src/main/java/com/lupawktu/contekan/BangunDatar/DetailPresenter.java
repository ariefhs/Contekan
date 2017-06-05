package com.lupawktu.contekan.BangunDatar;

import android.app.Activity;
import android.content.Context;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by Mind on 5/21/2017.
 */

public class DetailPresenter {
    private ViewDetail view;
    private ModelDetail model;
    Activity activity;
    public DetailPresenter(ViewDetail view){
        this.view = view;
    }

    public void loadData(String namafile) {
        try {
            model = new ModelDetail(new JSONObject(loadDataJSON(namafile)));
            view.tampilDetail(model);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

    private String loadDataJSON(String namafile) {
        String json = null;
        try {
            InputStream is = view.getAssets().open(namafile);
            int size = is.available();
            byte[] buffer = new byte[size];
            is.read(buffer);
            is.close();
            json = new String(buffer, "UTF-8");
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        return json;
    }
}
