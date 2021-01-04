package com.company.entity;

import java.util.Scanner;

public class Family {
    String _Title;
    int _Id;
    public Family(){}
    public Family(int i){
        _Title="Title"+1;
    }
    public Family(String title,int id){
        this._Title=title;
        this._Id=id;
    }
    public Family(Scanner s) {
        System.out.printf("Input Family Title");
        _Title=s.nextLine();
        System.out.printf("Input Family Id");
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
