package com.company;

import java.util.Arrays;
import java.util.Comparator;
import java.time.LocalDate;
import java.util.*;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Date;

public class LabHandler {
    public void Lab2(Scanner in,Random r)
    {
        Orchids Orchid1 = new Orchids("qwe",
                "qwe",
                "qwe",
                "qwe",
                23,
                23,
                23,
                23,
                23,
                "qwe",
                "qwe",
                "Днем",
                23,
                "qwe",
                343434,
                23);
        System.out.println(Orchid1.toString());
        Orchid1.Bloom();
        Orchid1.RePlant();
        Orchid1.water();
        Comparator<Orchids> OComp = new OrchidComparator();
        Comparator<Cactus> CComp = new CactusComparator();
        Plant[] Array = new Plant[10];
        Orchids[] Array1 = new Orchids[10];
        Cactus[] Array2 = new Cactus[10];
        for(int i =0;i<10;i++)
        {
            Array[i]=new Plant(
                    Orchid1.get_Title()+String.valueOf(i),
                    Orchid1.get_SoilType()+String.valueOf(i),
                    Orchid1.get_PotType()+String.valueOf(i),
                    Orchid1.get_FertilizerType()+String.valueOf(i),
                    Orchid1.get_Wetness()+i,
                    Orchid1.get_Temperature()+i,
                    Orchid1.get_Light()+i,
                    Orchid1.get_WateringFrequency()+i,
                    Orchid1.get_ReplantFrequency()+i,
                    Orchid1.get_Age()+ r.nextInt(50)
            );
        }
        for(int i =0;i<10;i++)
        {
            Array1[i]=new Orchids(
                    Orchid1.get_Title()+String.valueOf(i),
                    Orchid1.get_SoilType()+String.valueOf(i),
                    Orchid1.get_PotType()+String.valueOf(i),
                    Orchid1.get_FertilizerType()+String.valueOf(i),
                    Orchid1.get_Wetness()+i,
                    Orchid1.get_Temperature()+i,
                    Orchid1.get_Light()+i,
                    Orchid1.get_WateringFrequency()+i,
                    Orchid1.get_ReplantFrequency()+i,
                    Orchid1.get_FlowerColor()+String.valueOf(i),
                    Orchid1.get_FlowerShape()+String.valueOf(i),
                    Orchid1.get_FloweringTime(),
                    Orchid1.get_FlowerSize()+i,
                    Orchid1.get_InflorescenceType()+String.valueOf(i),
                    r.nextInt(100),
                    Orchid1.get_Age()+ r.nextInt(50));
        }
        for(int i =0;i<10;i++)
        {
            Array2[i]=new Cactus(
                    Orchid1.get_Title()+String.valueOf(i),
                    Orchid1.get_SoilType()+String.valueOf(i),
                    Orchid1.get_PotType()+String.valueOf(i),
                    Orchid1.get_FertilizerType()+String.valueOf(i),
                    Orchid1.get_Wetness()+i,
                    Orchid1.get_Temperature()+i,
                    Orchid1.get_Light()+i,
                    Orchid1.get_WateringFrequency()+i,
                    Orchid1.get_ReplantFrequency()+i,
                    Orchid1.get_FlowerColor()+String.valueOf(i),
                    Orchid1.get_FlowerShape()+String.valueOf(i),
                    Orchid1.get_FloweringTime(),
                    Orchid1.get_FlowerSize()+i,
                    r.nextInt(100),
                    Orchid1.get_Age()+ r.nextInt(50));
        }
        System.out.printf("####################################################\n\nPlants Before Sort\n\n%10s|%10s\n","Название","Возраст");
        for(int i =0;i<10;i++)
        {
            System.out.printf("%10s|%10s\n",Array[i].get_Title(),Array[i].get_Age());
        }
        Arrays.sort(Array);
        System.out.printf("####################################################\n\nPlants After sort\n\n%10s|%10s\n","Название","Возраст");
        for(int i =0;i<10;i++)
        {
            System.out.printf("%10s|%10s\n",Array[i].get_Title(),Array[i].get_Age());
        }
        System.out.printf("####################################################\n\nOrchids Before Sort\n\n%10s|%10s|%10s\n","Название","Кол. света","Возраст");
        for(int i =0;i<10;i++)
        {
            System.out.printf("%10s|%10s|%10s\n",Array1[i].get_Title(),Array1[i].get_RootLightning(),Array1[i].get_Age());
        }
        Arrays.sort(Array1,OComp);
        System.out.printf("####################################################\n\nOrchids After sort\n\n%10s|%10s|%10s\n","Название","Кол. света","Возраст");
        for(int i =0;i<10;i++)
        {
            System.out.printf("%10s|%10s|%10s\n",Array1[i].get_Title(),Array1[i].get_RootLightning(),Array1[i].get_Age());
        }
        System.out.printf("####################################################\n\nCactus Before Sort\n\n%10s|%10s|%10s\n","Название","Длинна колючек","Возраст");
        for(int i =0;i<10;i++)
        {
            System.out.printf("%10s|%10s|%10s\n",Array2[i].get_Title(),Array2[i].get_QuillLength(),Array2[i].get_Age());
        }
        Arrays.sort(Array2,CComp);
        System.out.printf("####################################################\n\nCactus After sort\n\n%10s|%10s|%10s\n","Название","Длинна колючек","Возраст");
        for(int i =0;i<10;i++)
        {
            System.out.printf("%10s|%10s|%10s\n",Array2[i].get_Title(),Array2[i].get_QuillLength(),Array2[i].get_Age());
        }
    }
        public void Lab3()
        {
        var Plants = new PlantList();
        Plant plant1 = new Plant("Plant1","SoilType1","PotType1","FertilizerType1",45,28,4000,2,2,12);
        Plant plant2 = new Plant("Plant2","SoilType2","PotType2","FertilizerType2",46,29,5000,3,3,13);
        Plant plant3 = new Plant("Plant3","SoilType3","PotType3","FertilizerType3",47,30,6000,4,4,14);
        Plants.add(plant1);
        Plants.add(plant2);
        Plants.add(plant3);
        for(var a:Plants)
            System.out.println(a);
        System.out.println();
        System.out.println("#######################################");
        var it = Plants.iterator();
        while (it.hasNext())
            System.out.println(it.next());
        System.out.println("#######################################");
        System.out.println(Plants.contains(plant3));
        Plants.remove(plant3);
        System.out.println(Plants.toString());
        System.out.println();
        System.out.println(Plants.contains(plant3));
        Plants.remove(plant2);
        System.out.println(Plants.toString());
        System.out.println();
        }
        public void Lab4()
        {

        }
        public void Lab5()
        {

        }
    }
