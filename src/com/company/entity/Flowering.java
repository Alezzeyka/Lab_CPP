package com.company.entity;

import java.time.LocalDateTime;
import java.util.Scanner;

public class Flowering extends Plant{
    String _FlowerColor;
    int _FlowerSize;
    public Flowering()
    {

    }
    public Flowering(Scanner in)
    {
        super(in);
        int x=0;
        System.out.printf("Введите размер цветка");
        this._FlowerSize=Integer.parseInt(in.nextLine());
        System.out.printf("Введите цвет цветка");
        this._FlowerColor=in.nextLine();

        in.nextLine();
    }
    public Flowering(String Title,String SoilType, String PotType,String FertilizerType,double Wetness,int Temperature, int Light,int WateringFrequency, int ReplantFrequency,String FlowerColor,String FlowerShape,String FloweringTime, int FlowerSize, int Age)
    {
        super();
        this._FlowerColor=FlowerColor;
        this._FlowerSize=FlowerSize;
    }

    @Override
    public String toString()
    {
        String str = super.toString();
        str+=String.format("цвет цветка :%s\n Форма цветка :%s\n размер цветка :%s\n Время расцветания :%s\n ",_FlowerColor,_FlowerSize);
        return str;
    }

    public int get_FlowerSize() {
        return _FlowerSize;
    }

    public String get_FlowerColor() {
        return _FlowerColor;
    }
}
