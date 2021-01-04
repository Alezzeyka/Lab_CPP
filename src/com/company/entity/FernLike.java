package com.company.entity;

import java.time.LocalDate;
import java.util.Scanner;

public class FernLike extends Plant {
    int _DisputesSize;
    int _LeafStructure_Id;
    public FernLike(){}
    public FernLike(Scanner in)
    {
        super(in);

        System.out.printf("Введите размер спор");
        this._DisputesSize=Integer.parseInt(in.nextLine());

    }
    public FernLike(String Title,String SoilType, String PotType,String FertilizerType,double Wetness,int Temperature, int Light,int WateringFrequency, int ReplantFrequency,int DisputesSize,int TimeOfSporesGrowth,String LeafStructure,int Age)
    {
        super();
        this._DisputesSize=DisputesSize;
    }
    @Override
    public String toString()
    {
        String str = super.toString();
        str+=String.format("Тип листьев : %s\n Время созревания спор : %s дней\n Размер спор : %s мм\n Последнее время выпуска спор : %s\n");
        return str;
    }
    public int get_DisputesSize() {
        return _DisputesSize;
    }
    public int get_LeafStructure_Id() {
        return _LeafStructure_Id;
    }
}
