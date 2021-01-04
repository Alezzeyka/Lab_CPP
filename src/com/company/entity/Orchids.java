package com.company.entity;

import java.util.Scanner;

public class Orchids extends Flowering {
    int _InflorescenceType_Id;
    public Orchids()
    {

    }
    public Orchids(Scanner in)
    {
        super(in);
        System.out.printf("Введите тип соцветия");

        System.out.printf("Введите сколько света нужно получать корням");
    }
    public Orchids(String Title,String SoilType, String PotType,String FertilizerType,double Wetness,int Temperature, int Light,int WateringFrequency, int ReplantFrequency,String FlowerColor,String FlowerShape,String FloweringTime, int FlowerSize, String InflorescenceType, int RootLightning,int Age)
    {

    }
@Override
public String toString()
{
    String str = super.toString();
    str+=String.format("Тип соцветия : %s\n Количество света для корней : %s\n");
    return str;
}

    public int get_InflorescenceType_Id() {
        return _InflorescenceType_Id;
    }
}
