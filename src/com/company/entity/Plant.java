package com.company.entity;

import java.time.LocalDate;
import java.util.Random;
import java.util.Scanner;
import java.lang.Comparable;

 public class Plant implements Comparable<Plant>{
    String _Title;
    int _SoilType_Id;
    int _PotType_Id;
    int _FertilizerType_Id;
    int _Id;
    int _Age;
    int _Sort_Id;
    int _Family_Id;
    public Plant()
    {
    }

     public void set_Id(int _Id) {
         this._Id = _Id;
     }

     public void set_Age(int _Age) {
         this._Age = _Age;
     }

     public Plant(Scanner in) {
        System.out.printf("Введите название растения");
      this._Title=in.nextLine();
      System.out.printf("Данные по растению %s внесены",this._Title);
      in.nextLine();
    }
    public Plant(String Title,Soil Soil,PotType potType,Fertilizer fertilizer,Sort sort,Family family,Random r)
    {
       this._Title= Title;
       this._Family_Id=family.get_Id();
       this._FertilizerType_Id=fertilizer.get_Id();
       this._PotType_Id=potType.get_Id();
       this._SoilType_Id=Soil.get_Id();
       this._Sort_Id=sort.get_Id();
       this._Age= r.nextInt(10);
    }
    @Override
    public String toString()
    {
        String str = String.format("Название : %s\n Тип почвы : %s\n Тип горшка: %s\n Тип удобрения : %s\n  Возраст : %s\n",_Age);
        return(str);
    }

    public int compareTo(Plant p){
        return _Age-p.get_Age();
    }

    public int get_Age() {
       return _Age;
    }

    public String get_Title() {
       return _Title;
    }

     public int get_FertilizerType_Id() {
         return _FertilizerType_Id;
     }

     public int get_PotType_Id() {
         return _PotType_Id;
     }

     public int get_SoilType_Id() {
         return _SoilType_Id;
     }

     public int get_Id() { return _Id; }

     public void set_Title(String _Title) {
         this._Title = _Title;
     }
     public void set_FertilizerType_Id(int _FertilizerType_Id) {
         this._FertilizerType_Id = _FertilizerType_Id;
     }
     public void set_PotType_Id(int _PotType_Id) {
         this._PotType_Id = _PotType_Id;
     }
     public void set_SoilType_Id(int _SoilType_Id) {
         this._SoilType_Id = _SoilType_Id;
     }

     public void set_Family_Id(int _Family_Id) {
         this._Family_Id = _Family_Id;
     }

     public void set_Sort_Id(int _Sort_Id) {
         this._Sort_Id = _Sort_Id;
     }

     public int get_Family_Id() {
         return _Family_Id;
     }

     public int get_Sort_Id() {
         return _Sort_Id;
     }
 }
