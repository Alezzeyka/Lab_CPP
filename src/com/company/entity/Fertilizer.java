package com.company.entity;

import java.util.Scanner;

public class Fertilizer {
    String _Title;
    int _Id;
    public Fertilizer(){}
    public Fertilizer(int i){
        _Title="Title"+1;
    }
    public Fertilizer(String title,int id){
        this._Title=title;
        this._Id=id;
    }
    public Fertilizer(Scanner s) {
        System.out.printf("Input Fertilizer Title");
        _Title=s.nextLine();
        System.out.printf("Input Fertilizer Id");
        _Id=Integer.parseInt(s.nextLine());
    }

    public void set_Id(int _Id) {
        this._Id = _Id;
    }

    public void set_Title(String _Title) {
        this._Title = _Title;
    }

    public String get_Title() {
        return _Title;
    }

    public int get_Id() {
        return _Id;
    }
    @Override
    public String toString(){
        return _Id+" "+_Title+" ";
    }
}
