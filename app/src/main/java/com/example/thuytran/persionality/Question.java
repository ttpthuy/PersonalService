package com.example.thuytran.persionality;

import org.json.JSONException;
import org.json.JSONObject;

public class Question {
    private String idQs;
    private String idGrQs;
    private String qus;

    public Question(String idQs, String idGrQs, String qus) {
        this.idQs = idQs;
        this.idGrQs = idGrQs;
        this.qus = qus;
    }

    public String getIdQs() {
        return idQs;
    }

    public void setIdQs(String idQs) {
        this.idQs = idQs;
    }

    public String getIdGrQs() {
        return idGrQs;
    }

    public void setIdGrQs(String idGrQs) {
        this.idGrQs = idGrQs;
    }

    public String getQus() {
        return qus;
    }

    public void setQus(String qus) {
        this.qus = qus;
    }
    public Question(JSONObject jsonObject) throws JSONException {
        this.idQs = jsonObject.getString("idQs");
        this.idGrQs = jsonObject.getString("idGrQs");
        this.qus = jsonObject.getString("qus");
    }
}
