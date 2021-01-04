package com.company.Dao;

import com.company.entity.*;
import java.util.LinkedList;
import java.util.Scanner;

public class MyCollectionDAO implements IMyDAO {
    private static LinkedList<Plant> plants= new LinkedList<Plant>();
    private static LinkedList<Flowering> flowerings = new LinkedList<Flowering>();
    private static LinkedList<Fern> ferns = new LinkedList<Fern>();
    private static LinkedList<FernLike> fernLikes =new LinkedList<FernLike>();
    private static LinkedList<Cactus> cacti = new LinkedList<Cactus>();
    private static LinkedList<Orchids> orchids = new LinkedList<Orchids>();
    private static LinkedList<Fertilizer> fertilizers = new LinkedList<Fertilizer>();
    private static LinkedList<Family> families = new LinkedList<Family>();
    private static LinkedList<InflorescenceType> inflorescenceTypes = new LinkedList<InflorescenceType>();
    private static LinkedList<LeafStructure> leafStructures = new LinkedList<LeafStructure>();
    private static LinkedList<PotType> potTypes = new LinkedList<PotType>();
    private static LinkedList<Soil> soils = new LinkedList<Soil>();
    private static LinkedList<Sort> sorts = new LinkedList<Sort>();

    @Override
    public LinkedList<Cactus> getCactus() {
        return cacti;
    }

    @Override
    public LinkedList<Fern> getFern() {
        return null;
    }

    @Override
    public LinkedList<FernLike> getFernLike() {
        return null;
    }

    @Override
    public LinkedList<Flowering> getFlowering() {
        return null;
    }

    @Override
    public LinkedList<Plant> getPlant() {
        return null;
    }

    @Override
    public LinkedList<Orchids> getOrchids() {
        return orchids;
    }

    @Override
    public void addPlant(Fern _Fern) {
        ferns.add(_Fern);
    }

    @Override
    public void addFamily(Family _Family) {
        families.add(_Family);
    }

    @Override
    public void addFertilizer(Fertilizer _Fertilizer) {
        fertilizers.add(_Fertilizer);
    }

    @Override
    public void addInflorescenceType(InflorescenceType _InflorescenceType) {
        inflorescenceTypes.add(_InflorescenceType);
    }

    @Override
    public void addLeafStructure(LeafStructure _LeafStructure) {
        leafStructures.add(_LeafStructure);
    }

    @Override
    public void addPlant(Plant _Plant) {
        plants.add(_Plant);
    }

    @Override
    public void addPlant(Cactus _Cactus) {
        cacti.add(_Cactus);
    }

    @Override
    public void addPlant(Orchids _Orchid) {
        orchids.add(_Orchid);
    }

    @Override
    public void addPlant(FernLike _FernLike) {
        fernLikes.add(_FernLike);
    }

    @Override
    public void addPlant(Flowering _Flowering) {
        flowerings.add(_Flowering);
    }

    @Override
    public void addPotType(PotType _PotType) {
        potTypes.add(_PotType);
    }

    @Override
    public void addSoil(Soil _Soil) {
        soils.add(_Soil);
    }

    @Override
    public void addSort(Sort _Sort) {
        sorts.add(_Sort);
    }

    @Override
    public void deleteCactus(int id) {
        for(Cactus c:cacti)
            if(c.get_Id()==id)
                cacti.remove(c);
    }

    @Override
    public void deleteFern(int id) {
        for(Fern f:ferns)
            if(f.get_Id()==id)
                ferns.remove(f);
    }

    @Override
    public void deleteFernLike(int id) {
        for(FernLike f:fernLikes)
            if(f.get_Id()==id)
                fernLikes.remove(f);
    }

    @Override
    public void deleteFlowering(int id) {
        for(Flowering f:flowerings)
            if(f.get_Id()==id)
                flowerings.remove(f);
    }

    @Override
    public void deleteOrchid(int id) {
        for(Orchids o:orchids)
            if(o.get_Id()==id)
                orchids.remove(o);
    }

    @Override
    public void deletePlant(int id) {
        for(Plant p:plants)
            if(p.get_Id()==id)
                plants.remove(p);
    }

    @Override
    public void deleteFamily(int id) {
        for(Family f:families)
            if(f.get_Id()==id)
                families.remove(f);
    }

    @Override
    public void deleteFertilizer(int id) {
        for(Fertilizer f:fertilizers)
            if(f.get_Id()==id)
                fertilizers.remove(f);
    }

    @Override
    public void deleteInflorescenceType(int id) {
        for(InflorescenceType i:inflorescenceTypes)
            if(i.get_Id()==id)
                inflorescenceTypes.remove(i);
    }

    @Override
    public void deleteLeafStructure(int id) {
        for(LeafStructure l:leafStructures)
            if(l.get_Id()==id)
                leafStructures.remove(l);
    }

    @Override
    public void deletePotTye(int id) {
        for(PotType p:potTypes)
            if(p.get_Id()==id)
                potTypes.remove(p);
    }

    @Override
    public void deleteSoil(int id) {
        for(Soil s:soils)
            if(s.get_Id()==id)
                soils.remove(s);
    }

    @Override
    public void deleteSort(int id) {
        for(Sort s:sorts)
            if(s.get_Id()==id)
                sorts.remove(s);
    }

    @Override
    public LinkedList<Family> updateFamily(int id, String _Title) {
        for(Family a: families)
            if(a.get_Id()==id){
                a.set_Title(_Title);
            }
        return families;
    }

    @Override
    public LinkedList<Fertilizer> updateFertilizer(int id, String _Title) {
        for(Fertilizer a: fertilizers)
            if(a.get_Id()==id){
                a.set_Title(_Title);
            }
        return fertilizers;
    }

    @Override
    public LinkedList<InflorescenceType> updateInflorescenceType(int id, String _Title) {
        for(InflorescenceType a: inflorescenceTypes)
            if(a.get_Id()==id){
                a.set_Title(_Title);
            }
        return inflorescenceTypes;
    }

    @Override
    public LinkedList<LeafStructure> updateLeafStructure(int id, String _Title) {
        for(LeafStructure a: leafStructures)
            if(a.get_Id()==id){
                a.set_Title(_Title);
            }
        return leafStructures;
    }


    @Override
    public LinkedList<PotType> updatePotType(int id, String _Title) {
        for(PotType a: potTypes)
            if(a.get_Id()==id){
                a.set_Title(_Title);
            }
        return potTypes;
    }

    @Override
    public LinkedList<Soil> updateSoil(int id, String _Title) {
        for(Soil a: soils)
            if(a.get_Id()==id){
                a.set_Title(_Title);
            }
        return soils;
    }

    @Override
    public LinkedList<Sort> updateSort(int id, String _Title) {
        for(Sort a: sorts)
            if(a.get_Id()==id){
                a.set_Title(_Title);
            }
        return sorts;
    }

    @Override
    public LinkedList<Plant> updatePlantTitle(int id, String _Title) {
        for(Plant a: plants)
            if(a.get_Id()==id){
                a.set_Title(_Title);
            }
        return plants;
    }

    @Override
    public LinkedList<Family> GetAllFamily() {
        return families;
    }

    @Override
    public LinkedList<Fertilizer> GetAllFertilizer() {
        return fertilizers;
    }

    @Override
    public LinkedList<InflorescenceType> GetAllInflorescenceType() {
        return inflorescenceTypes;
    }

    @Override
    public LinkedList<LeafStructure> GetAllLeafStructure() {
        return leafStructures;
    }

    @Override
    public LinkedList<PotType> GetAllPotType() {
        return potTypes;
    }

    @Override
    public LinkedList<Soil> GetAllSoil() {
        return soils;
    }

    @Override
    public LinkedList<Sort> GetAllSort() {
        return sorts;
    }

    @Override
    public LinkedList<Family> search_FamilyId(int id) {
        LinkedList<Family> search = new LinkedList<Family>();
        for(Family a:families)
            if(a.get_Id()==id)
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<Family> search_FamilyName(String _Title) {
        LinkedList<Family> search = new LinkedList<Family>();
        for(Family a:families)
            if(a.get_Title().equals(_Title))
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<Fertilizer> search_FertilizerId(int id) {
        LinkedList<Fertilizer> search = new LinkedList<Fertilizer>();
        for(Fertilizer a:fertilizers)
            if(a.get_Id()==id)
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<Fertilizer> search_FertilizerName(String _Title) {
        LinkedList<Fertilizer> search = new LinkedList<Fertilizer>();
        for(Fertilizer a:fertilizers)
            if(a.get_Title().equals(_Title))
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<InflorescenceType> search_InflorescenceTypeId(int id) {
        LinkedList<InflorescenceType> search = new LinkedList<InflorescenceType>();
        for(InflorescenceType a:inflorescenceTypes)
            if(a.get_Id()==id)
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<InflorescenceType> search_InflorescenceTypeName(String _Title) {
        LinkedList<InflorescenceType> search = new LinkedList<InflorescenceType>();
        for(InflorescenceType a:inflorescenceTypes)
            if(a.get_Title().equals(_Title))
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<LeafStructure> search_LeafStructureId(int id) {
        LinkedList<LeafStructure> search = new LinkedList<LeafStructure>();
        for(LeafStructure a:leafStructures)
            if(a.get_Id()==id)
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<LeafStructure> search_LeafStructureName(String _Title) {
        LinkedList<LeafStructure> search = new LinkedList<LeafStructure>();
        for(LeafStructure a:leafStructures)
            if(a.get_Title().equals(_Title))
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<Plant> search_PlantId(int id) {
        LinkedList<Plant> search = new LinkedList<Plant>();
        for(Plant a:plants)
            if(a.get_Id()==id)
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<Plant> search_PlantName(String _Title) {
        LinkedList<Plant> search = new LinkedList<Plant>();
        for(Plant a:plants)
            if(a.get_Title().equals(_Title))
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<PotType> search_PotTypeId(int id) {
        LinkedList<PotType> search = new LinkedList<PotType>();
        for(PotType a:potTypes)
            if(a.get_Id()==id)
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<PotType> search_PotTypeName(String _Title) {
        LinkedList<PotType> search = new LinkedList<PotType>();
        for(PotType a:potTypes)
            if(a.get_Title().equals(_Title))
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<Soil> search_SoilId(int id) {
        LinkedList<Soil> search = new LinkedList<Soil>();
        for(Soil a:soils)
            if(a.get_Id()==id)
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<Soil> search_SoilName(String _Title) {
        LinkedList<Soil> search = new LinkedList<Soil>();
        for(Soil a:soils)
            if(a.get_Title().equals(_Title))
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<Sort> search_SortId(int id) {
        LinkedList<Sort> search = new LinkedList<Sort>();
        for(Sort a:sorts)
            if(a.get_Id()==id)
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<Sort> search_SortName(String _Title) {
        LinkedList<Sort> search = new LinkedList<Sort>();
        for(Sort a:sorts)
            if(a.get_Title().equals(_Title))
                search.add(a);
        if(search.size() == 0)
            return null;
        else
            return search;
    }

    @Override
    public LinkedList<Plant> search_CactusId(int id) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_CactusName(String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_FernId(int id) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_FernName(String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_FernLikeId(int id) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_FernLikeName(String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_FloweringId(int id) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_FloweringName(String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_OrchidId(int id) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_OrchidName(String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> updateCactusTitle(int id, String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> updateFernLikeTitle(int id, String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> updateFernTitle(int id, String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> updateFloweringTitle(int id, String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> updateOrchidsTitle(int id, String _Title) {
        return null;
    }
}
