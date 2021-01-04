package com.company;

import com.company.Dao.DAOFactory;
import com.company.Dao.IMyDAO;
import com.company.Dao.TypeDAO;
import com.company.entity.*;

import java.util.Arrays;
import java.util.Comparator;
import java.util.*;

public class LabHandler {
    public void Lab2(){ }
    public void Lab3(){ }
    public void Lab4(Scanner scanner,Random random){

        IMyDAO dao = DAOFactory.getDAOInstance(TypeDAO.MySQL);

        Sort sort1 = new Sort("Sort1",1);
        Sort sort2 = new Sort("Sort2",2);
        Sort sort3 = new Sort("Sort3",3);

        Soil soil1 = new Soil("Soil1",1);
        Soil soil2 = new Soil("Soil2",2);
        Soil soil3 = new Soil("Soil3",3);

        Family family1 = new Family("Family1",1);
        Family family2 = new Family("Family2",2);
        Family family3 = new Family("Family3",3);

        PotType PotType1 = new PotType("PotType1",1);
        PotType PotType2 = new PotType("PotType2",2);
        PotType PotType3 = new PotType("potType3",3);

        Fertilizer Fertilizer1 = new Fertilizer("Fertilizer1",1);
        Fertilizer Fertilizer2 = new Fertilizer("Fertilizer2",2);
        Fertilizer Fertilizer3 = new Fertilizer("Fertilizer3",3);

        InflorescenceType IT1 = new InflorescenceType("IT1",1);
        InflorescenceType IT2 = new InflorescenceType("IT2",2);
        InflorescenceType IT3 = new InflorescenceType("IT3",3);

        LeafStructure LS1 = new LeafStructure("LS1",1);
        LeafStructure LS2 = new LeafStructure("LS2",2);
        LeafStructure LS3 = new LeafStructure("LS3",3);

        dao.addFamily(family1);dao.addFamily(family2);dao.addFamily(family3);

        dao.addFertilizer(Fertilizer1);dao.addFertilizer(Fertilizer2);dao.addFertilizer(Fertilizer3);

        dao.addInflorescenceType(IT1);dao.addInflorescenceType(IT2);dao.addInflorescenceType(IT3);

        dao.addLeafStructure(LS1);dao.addLeafStructure(LS2);dao.addLeafStructure(LS3);

        dao.addPotType(PotType1);dao.addPotType(PotType2);dao.addPotType(PotType3);

        dao.addSoil(soil1);dao.addSoil(soil2);dao.addSoil(soil3);

        dao.addSort(sort1);dao.addSort(sort2);dao.addSort(sort3);

        Plant plant1 = new Plant("Plant1",soil1,PotType1,Fertilizer1,sort1,family1,random);
        Plant plant2 = new Plant("Plant2",soil2,PotType2,Fertilizer2,sort2,family2,random);
        Plant plant3 = new Plant("Plant3",soil3,PotType3,Fertilizer3,sort3,family3,random);

        dao.addPlant(plant1);dao.addPlant(plant2);dao.addPlant(plant3);

        System.out.printf("All plants in DB\n");
        LinkedList<Plant> list = dao.getPlant();
        System.out.printf("%10S|%10S|%10S|%10S|%10S|%10S|%10S|%10S\n","Id","Title","Age","Family","Fert.","Pot","Soil","Sort");
        for(Plant p :list)
        {
            System.out.printf("%10S|%10S|%10S|%10S|%10S|%10S|%10S|%10S\n",
                    p.get_Id(),p.get_Title(),p.get_Age(),p.get_Family_Id(),p.get_FertilizerType_Id(),p.get_PotType_Id(),p.get_SoilType_Id(),p.get_Sort_Id());
        }
        System.out.printf("All sorts in DB\n");
        LinkedList<Sort> list1 = dao.GetAllSort();
        System.out.printf("%10S|%10S\n","Id","Title");
        for(Sort s :list1)
        {
            System.out.printf("%10S|%10S\n",
                    s.get_Id(),s.get_Title());
        }
        System.out.printf("Insert id of deleting plant\n");
        int id=Integer.parseInt(scanner.nextLine());
        System.out.printf("Deleting plant with id %d\n",id);
        dao.deletePlant(id);
        System.out.printf("All remaining plants in DB\n");
        LinkedList<Plant> list2 = dao.getPlant();
        System.out.printf("%10S|%10S|%10S|%10S|%10S|%10S|%10S|%10S\n","Id","Title","Age","Family","Fert.","Pot","Soil","Sort");
        for(Plant p :list2)
        {
            System.out.printf("%10S|%10S|%10S|%10S|%10S|%10S|%10S|%10S\n",
                    p.get_Id(),p.get_Title(),p.get_Age(),p.get_Family_Id(),p.get_FertilizerType_Id(),p.get_PotType_Id(),p.get_SoilType_Id(),p.get_Sort_Id());
        }
        System.out.printf("Deleting sort with id 3\n");
        dao.deletePlant(3);
        System.out.printf("All remaining sorts in DB\n");
        LinkedList<Sort> list3 = dao.GetAllSort();
        System.out.printf("%10S|%10S\n","Id","Title");
        for(Sort s :list3)
        {
            System.out.printf("%10S|%10S\n",
                    s.get_Id(),s.get_Title());
        }
        System.out.printf("Updating Sort with id 2, please insert new sort title\n");
        String x=scanner.nextLine();
        dao.updateSort(2,x);
        System.out.printf("All remaining sorts in DB\n");
        list3 = dao.GetAllSort();
        System.out.printf("%10S|%10S\n","Id","Title");
        for(Sort s :list3)
        {
            System.out.printf("%10S|%10S\n",
                    s.get_Id(),s.get_Title());
        }
    }
    public void Lab5(){}
    }
