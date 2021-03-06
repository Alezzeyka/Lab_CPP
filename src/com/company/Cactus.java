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

public class Cactus extends Flowering {
    int _QuillLength;
    public Cactus(){}
    public Cactus(Scanner in)
    {
        super(in);
        System.out.printf("Введите длинну иголок");
        this._QuillLength=Integer.parseInt(in.nextLine());
    }
    public Cactus(String Title,String SoilType, String PotType,String FertilizerType,double Wetness,int Temperature, int Light,int WateringFrequency, int ReplantFrequency,String FlowerColor,String FlowerShape,String FloweringTime, int FlowerSize, int QuillLength, int Age)
    {
        super(Title,SoilType,PotType,FertilizerType,Wetness,Temperature,Light,WateringFrequency,ReplantFrequency,FlowerColor,FlowerShape,FloweringTime,FlowerSize,Age);
        this._QuillLength=QuillLength;
    }
    @Override
    public String toString()
    {
        String str = super.toString();
        str+=String.format("Длинна колючек : %1s мм\n",this._QuillLength);
        return str;
    }

    public int get_QuillLength() {
        return _QuillLength;
    }
}
