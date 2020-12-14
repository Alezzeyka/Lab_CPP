package com.company;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Calendar;
import java.util.Date;
import java.util.Scanner;
import java.util.Comparator;

public class Orchids extends Flowering {
    String _InflorescenceType;
    int _RootLightning;
    public Orchids()
    {

    }
    public Orchids(Scanner in)
    {
        super(in);
        System.out.printf("Введите тип соцветия");
        this._InflorescenceType=in.nextLine();
        System.out.printf("Введите сколько света нужно получать корням");
        this._RootLightning=Integer.parseInt(in.nextLine());
    }
    public Orchids(String Title,String SoilType, String PotType,String FertilizerType,double Wetness,int Temperature, int Light,int WateringFrequency, int ReplantFrequency,String FlowerColor,String FlowerShape,String FloweringTime, int FlowerSize, String InflorescenceType, int RootLightning,int Age)
    {
        super(Title,SoilType,PotType,FertilizerType,Wetness,Temperature,Light,WateringFrequency,ReplantFrequency,FlowerColor,FlowerShape,FloweringTime,FlowerSize,Age);
        this._RootLightning=RootLightning;
        this._InflorescenceType=InflorescenceType;
    }
@Override
public String toString()
{
    String str = super.toString();
    str+=String.format("Тип соцветия : %s\n Количество света для корней : %s\n",this._InflorescenceType,this._RootLightning);
    return str;
}
    public String get_InflorescenceType() {
        return _InflorescenceType;
    }

    public int get_RootLightning() {
        return _RootLightning;
    }
}
