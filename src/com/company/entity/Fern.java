package com.company.entity;

import java.util.Scanner;

public class Fern  extends FernLike{
    int _RootStockSize;
    public Fern(){}
    public Fern(Scanner in)
    {
        super(in);
        System.out.println("Введите размер корневища");
        this._RootStockSize=Integer.parseInt(in.nextLine());
    }
    public Fern(String Title,String SoilType, String PotType,String FertilizerType,double Wetness,int Temperature, int Light,int WateringFrequency, int ReplantFrequency,int DisputesSize,int TimeOfSporesGrowth,String LeafStructure,int RootStockSize,int Age)
    {
        super(Title,SoilType,PotType,FertilizerType,Wetness,Temperature,Light,WateringFrequency,ReplantFrequency,DisputesSize,TimeOfSporesGrowth,LeafStructure,Age);
        this._RootStockSize=RootStockSize;
    }

    public int get_RootStockSize() {
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
