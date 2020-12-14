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

public class Fern  extends FernLike{
    String _RootStockSize;
    public Fern(){}
    public Fern(Scanner in)
    {
        super(in);
        System.out.println("Введите размер корневища");
        this._RootStockSize=in.nextLine();
    }
    public Fern(String Title,String SoilType, String PotType,String FertilizerType,double Wetness,int Temperature, int Light,int WateringFrequency, int ReplantFrequency,int DisputesSize,int TimeOfSporesGrowth,String LeafStructure,String RootStockSize,int Age)
    {
        super(Title,SoilType,PotType,FertilizerType,Wetness,Temperature,Light,WateringFrequency,ReplantFrequency,DisputesSize,TimeOfSporesGrowth,LeafStructure,Age);
        this._RootStockSize=RootStockSize;
    }

    public String get_RootStockSize() {
        return _RootStockSize;
    }
    @Override
    public String toString()
    {
        String str = super.toString();
        str+=String.format("Размер корневища : %s\n",_RootStockSize);
        return str;
    }
}
