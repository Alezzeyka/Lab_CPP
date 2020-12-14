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

public class Flowering extends Plant{
    String _FlowerColor;
    String _FlowerShape;
    String _FloweringTime;
    int _FlowerSize;
    public Flowering()
    {

    }
    public Flowering(Scanner in)
    {
        super(in);
        int x=0;
        /*System.out.printf("Введите название растения");
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
        this._LastWateringDate=LocalDate.now();
        this._LastTransferDate=LocalDate.now();*/
        System.out.printf("Введите размер цветка");
        this._FlowerSize=Integer.parseInt(in.nextLine());
        System.out.printf("Введите форму цветка");
        this._FlowerShape=in.nextLine();
        System.out.printf("Введите цвет цветка");
        this._FlowerColor=in.nextLine();
        do
            {

                try {
                    System.out.printf("Выберите время цветения: 1 - Днем, 2- Ночью");
                    x = Integer.parseInt(in.nextLine());
                    if ((x!=1)&&(x!=2))
                    {
                        System.out.printf("Вы выбрали неправильный вариант, попробуйте снова");
                    }
                }
                catch (Exception ex)
                {
                    System.out.printf("Вы ввели не число");
                }
            }
        while ((x!=1)&&(x!=2));
        System.out.printf("Данные по растению %s внесены",this._Title);
        in.nextLine();
    }
    public Flowering(String Title,String SoilType, String PotType,String FertilizerType,double Wetness,int Temperature, int Light,int WateringFrequency, int ReplantFrequency,String FlowerColor,String FlowerShape,String FloweringTime, int FlowerSize, int Age)
    {
        super(Title,SoilType,PotType,FertilizerType,Wetness,Temperature,Light,WateringFrequency,ReplantFrequency,Age);
        /*this._Title= Title;
        this._SoilType=SoilType;
        this._PotType=PotType;
        this._FertilizerType=FertilizerType;
        this._Wetness=Wetness;
        this._Temperature=Temperature;
        this._Light=Light;
        this._WateringFrequency=WateringFrequency;
        this._ReplantFrequency=ReplantFrequency;
        this._LastWateringDate=LocalDate.now();
        this._LastTransferDate=LocalDate.now();*/
        this._FlowerColor=FlowerColor;
        this._FloweringTime=FloweringTime;
        this._FlowerShape=FlowerShape;
        this._FlowerSize=FlowerSize;
    }
    public void Bloom()
    {
        LocalDateTime now = LocalDateTime.now();
        if(_FloweringTime.equals("Ночью"))
        {

            if((now.getHour()<5)&&(now.getHour()>22))
            {
                System.out.println(String.format("Цветок %s расцвел",this._Title));
            }
            else
            {
                System.out.println(String.format("Сейчас не время расцветать у цветка %s",this._Title));
            }
        }
        else if(_FloweringTime.equals("Днем"))
        {
            if((now.getHour()>5)&&(now.getHour()<22))
            {
                System.out.println(String.format("Цветок %s расцвел",this._Title));
            }
            else
            {
                System.out.println(String.format("Сейчас не время расцветать у цветка %s",this._Title));
            }
        }
        else
        {
            System.out.println("Ошибка");
        }
    }
    @Override
    public String toString()
    {
        String str = super.toString();
        str+=String.format("цвет цветка :%s\n Форма цветка :%s\n размер цветка :%s\n Время расцветания :%s\n ",_FlowerColor,_FlowerShape,_FlowerSize,_FloweringTime);
        return str;
    }

    public int get_FlowerSize() {
        return _FlowerSize;
    }

    public String get_FlowerColor() {
        return _FlowerColor;
    }

    public String get_FloweringTime() {
        return _FloweringTime;
    }

    public String get_FlowerShape() {
        return _FlowerShape;
    }
}
