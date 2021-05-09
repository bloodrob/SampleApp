package com.example.sampleapp;

public class cardViewModel {
    private String title;
    private String descrp;

    public cardViewModel(){

    }

    public cardViewModel(String title,String descrp){
        this.title = title;
        this.descrp = descrp;
    }

    public String getTitle(){
        return  title;
    }
    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescrp(){
        return descrp;
    }
    public void setDescrp(String descrp){
        this.descrp=descrp;
    }
}
