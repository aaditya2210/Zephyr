package com.example.voltify;

public class DataClass2 {

    private String dataTitle;
    private String dataDesc;
    private String dataLang;
    private String dataImage;
    private String key;
    private String lng;
    private String ltd;

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getDataTitle() {
        return dataTitle;
    }

    public String getDataDesc() {
        return dataDesc;
    }

    public String getDataLang() {
        return dataLang;
    }

    public String getDataImage() {
        return dataImage;
    }
    public String getLtd() {
        return ltd;
    }
    public String getLng() {
        return lng;
    }

    public DataClass2(String dataTitle, String dataDesc, String dataLang, String dataImage, String lng, String ltd) {
        this.dataTitle = dataTitle;
        this.dataDesc = dataDesc;
        this.dataLang = dataLang;
        this.dataImage = dataImage;
        this.lng = lng;
        this.ltd = ltd;
    }
    public DataClass2(){

    }
}

