package com.lupawktu.contekan.BangunDatar;

import org.json.JSONObject;

/**
 * Created by Mind on 5/21/2017.
 */

public class ModelDetail {
    private JSONObject json;
    public ModelDetail(JSONObject json){
        this.setJson(json);
    }

    public JSONObject getJson() {
        return json;
    }

    public void setJson(JSONObject json) {
        this.json = json;
    }
}
