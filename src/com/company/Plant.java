package com.company;

import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Comparator;
import java.lang.Comparable;

 public class Plant implements Comparable<Plant>{
    String _Title;
    String _SoilType;
    String _PotType;
    String _FertilizerType;
    double _Wetness;
    int _Age;
    int _Temperature;
    int _Light;
    int _WateringFrequency;
    int _ReplantFrequency;
    LocalDate _LastTransferDate;
    LocalDate _LastWateringDate;
    public Plant()
    {
    }
    public Plant(Scanner in)
    {
       System.out.printf("Введите название растения");
      this._Title=in.nextLine();
       System.out.printf("Введите тип почвы");
      this._SoilType=in.nextLine();
       System.out.printf("Введите тип горшка");
      this._PotType=in.nextLine();
       System.out.printf("введите тип удобрения");
      this._FertilizerType=in.nextLine();
       System.out.printf("Введите относительную влажность");
      this._Wetness=Double.parseDouble(in.nextLine());
       System.out.printf("Введите возрасть растения");
      this._Age=Integer.parseInt(in.nextLine());
       System.out.printf("Введите температуру");
      this._Temperature=Integer.parseInt(in.nextLine());
       System.out.printf("Введите частоту полива (дней)");
      this._WateringFrequency=Integer.parseInt(in.nextLine());
       System.out.printf("Введите Частоту пересадки (лет/год/года)");
      this._ReplantFrequency=Integer.parseInt(in.nextLine());
        System.out.printf("Введите возраст");
        this._Age=Integer.parseInt(in.nextLine());
        System.out.printf("Введите колличество получаемого света");
        this._Light=Integer.parseInt(in.nextLine());
       this._LastWateringDate=LocalDate.now();
       this._LastTransferDate=LocalDate.now();
       System.out.printf("Данные по растению %s внесены",this._Title);
       in.nextLine();
    }
    public Plant(String Title,String SoilType, String PotType,String FertilizerType,double Wetness,int Temperature, int Light,int WateringFrequency, int ReplantFrequency,int Age)
    {
       this._Title= Title;
       this._SoilType=SoilType;
       this._PotType=PotType;
       this._FertilizerType=FertilizerType;
       this._Wetness=Wetness;
       this._Temperature=Temperature;
       this._Light=Light;
       this._WateringFrequency=WateringFrequency;
       this._ReplantFrequency=ReplantFrequency;
       this._Age=Age;
       this._LastWateringDate=LocalDate.now();
       this._LastTransferDate=LocalDate.now();
    }
    @Override
    public String toString()
    {
        String str = String.format("Название : %s\n Тип почвы : %s\n Тип горшка: %s\n Тип удобрения : %s\n Относительная влажность : %s \n Возраст : %s\n температура : %s\n Освещенность : %s Люменов\n Дата последней пересадки : %s\n Дата последнего полива : %s\n Частота полива : %s дней\n Частота пересадки : %s лет/года\n",_Title,_SoilType,_PotType,_FertilizerType,_Wetness,_Age,_Temperature,_Light,_LastTransferDate,_LastWateringDate,_WateringFrequency,_ReplantFrequency);
        return(str);
    }
    public void water()
    {
      if(LocalDate.now().getDayOfMonth()-this._LastWateringDate.getDayOfMonth()>this._WateringFrequency)
      {
         System.out.println(String.format("Вы полили растение %s",this._Title));
         this._LastWateringDate=LocalDate.now();
      }
      else
      {
         int d = this._WateringFrequency-(LocalDate.now().getDayOfMonth()-this._LastWateringDate.getDayOfMonth());
         System.out.println(String.format("Время поливать растение %s еще не пришло, полейте его минимум через %d дней",this._Title,d));
      }
    }
    public void RePlant()
    {
       if(LocalDate.now().getYear()-this._LastTransferDate.getYear()>this._ReplantFrequency)
       {
          System.out.println(String.format("Вы пересадили растение %s",this._Title));
          this._LastWateringDate=LocalDate.now();
       }
       else
       {
          System.out.println(String.format("Время пересаживать растение %s еще не пришло",this._Title));
       }
    }
    public int compareTo(Plant p){
        return _Age-p.get_Age();
    }
    public LocalDate get_LastTransferDate() {
       return _LastTransferDate;
    }

    public LocalDate get_LastWateringDate() {
       return _LastWateringDate;
    }

    public double get_Wetness() {
       return _Wetness;
    }

    public int get_Age() {
       return _Age;
    }

    public int get_Light() {
       return _Light;
    }

    public int get_Temperature() {
       return _Temperature;
    }

    public String get_FertilizerType() {
       return _FertilizerType;
    }

    public String get_PotType() {
       return _PotType;
    }

    public String get_SoilType() {
       return _SoilType;
    }

    public String get_Title() {
       return _Title;
    }

    public int get_ReplantFrequency() {
       return _ReplantFrequency;
    }

    public int get_WateringFrequency() {
       return _WateringFrequency;
    }
 }
