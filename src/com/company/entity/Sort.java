package com.company.entity;

import java.util.Scanner;

public class Sort {
    String _Title;
    int _Id;
    public Sort(){}
    public Sort(int i){
        _Title="Title"+1;
    }
    public Sort(String title,int id){
        this._Title=title;
        this._Id=id;
    }
    public Sort(Scanner s) {
        System.out.printf("Input Sort Title");
        _Title=s.nextLine();
        System.out.printf("Input Sort Id");
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
