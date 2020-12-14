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

public class FernLike extends Plant {
    int _DisputesSize;
    String _LeafStructure;
    LocalDate _LastSporeEruptionTime;
    int _SporeEruptionFrequency;
    public FernLike(){}
    public FernLike(Scanner in)
    {
        super(in);
        System.out.printf("Введите строение листа");
        this._LeafStructure=in.nextLine();
        System.out.printf("Введите время созревания спор (дней)");
        this._SporeEruptionFrequency=Integer.parseInt(in.nextLine());
        System.out.printf("Введите размер спор");
        this._DisputesSize=Integer.parseInt(in.nextLine());
        this._LastSporeEruptionTime=LocalDate.now();
    }
    public FernLike(String Title,String SoilType, String PotType,String FertilizerType,double Wetness,int Temperature, int Light,int WateringFrequency, int ReplantFrequency,int DisputesSize,int TimeOfSporesGrowth,String LeafStructure,int Age)
    {
        super(Title,SoilType,PotType,FertilizerType,Wetness,Temperature,Light,WateringFrequency,ReplantFrequency,Age);
        this._DisputesSize=DisputesSize;
        this._SporeEruptionFrequency=TimeOfSporesGrowth;
        this._LeafStructure=LeafStructure;
        this._LastSporeEruptionTime=LocalDate.now();
    }
    public void SporeEruption()
    {
            if (LocalDate.now().getDayOfMonth() - this._LastSporeEruptionTime.getDayOfMonth() > this._SporeEruptionFrequency) {
                System.out.println(String.format("Растение растение %s выпустило споры", this._Title));
                this._LastSporeEruptionTime = LocalDate.now();
            } else {
                int d = this._SporeEruptionFrequency - (LocalDate.now().getDayOfMonth() - this._LastSporeEruptionTime.getDayOfMonth());
                System.out.println(String.format("Время выпускать споры растению %s еще не пришло, минимум через %d дней", this._Title, d));
            }

    }
    @Override
    public String toString()
    {
        String str = super.toString();
        str+=String.format("Тип листьев : %s\n Время созревания спор : %s дней\n Размер спор : %s мм\n Последнее время выпуска спор : %s\n",_LeafStructure,_SporeEruptionFrequency,_DisputesSize,_LastSporeEruptionTime);
        return str;
    }

    public int get_DisputesSize() {
        return _DisputesSize;
    }

    public int get_SporeEruptionFrequency() {
        return _SporeEruptionFrequency;
    }

    public LocalDate get_LastSporeEruptionTime() {
        return _LastSporeEruptionTime;
    }

    public String get_LeafStructure() {
        return _LeafStructure;
    }
}
