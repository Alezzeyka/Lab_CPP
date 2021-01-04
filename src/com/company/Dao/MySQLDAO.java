package com.company.Dao;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.*;
import java.util.LinkedList;
import java.util.Scanner;

import javax.swing.JOptionPane;

import com.company.entity.*;

public class MySQLDAO implements IMyDAO {
    private static Connection con = null;
    private static String add_Plant ="INSERT INTO Plants(Title,Family_Id,Sort_Id,FertilizerType_Id,SoilType_Id,PotType_Id,PlantType) VALUES (?,?,?,?,?,?,?)";
    private static String add_Orchid ="INSERT INTO Plants(Title,Family_Id,Sort_Id,FertilizerType_Id,SoilType_Id,PotType_Id,FlowerColor,FlowerSize,InflorescenceType_Id,PlantType) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static String add_Flowering ="INSERT INTO Plants(Title,Family_Id,Sort_Id,FertilizerType_Id,SoilType_Id,PotType_Id,FlowerColor,FlowerSize,PlantType) VALUES (?,?,?,?,?,?,?,?,?)";
    private static String add_Cactus ="INSERT INTO Plants(Title,Family_Id,Sort_Id,FertilizerType_Id,SoilType_Id,PotType_Id,FlowerColor,FlowerSize,QuillLength,PlantType) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static String add_FernLike ="INSERT INTO Plants(Title,Family_Id,Sort_Id,FertilizerType_Id,SoilType_Id,PotType_Id,DisputesSize,Leaf_Structure_Id,PlantType) VALUES (?,?,?,?,?,?,?,?,?)";
    private static String add_Fern ="INSERT INTO Plants(Title,Family_Id,Sort_Id,FertilizerType_Id,SoilType_Id,PotType_Id,DisputesSize,Leaf_Structure_Id,RootStockSize,PlantType) VALUES (?,?,?,?,?,?,?,?,?,?)";
    private static String add_Family ="INSERT INTO Family(Title) VALUES (?)";
    private static String add_Fertilizer ="INSERT INTO Fertilizer(Title) VALUES (?)";
    private static String add_Sort ="INSERT INTO Sort(Title) VALUES (?)";
    private static String add_Soil ="INSERT INTO Soil(Title) VALUES (?)";
    private static String add_PotType ="INSERT INTO PotType(Title) VALUES (?)";
    private static String add_LeafStructure ="INSERT INTO LeafStructure(Title) VALUES (?)";
    private static String add_InflorescenceType ="INSERT INTO InflorescenceType(Title) VALUES (?)";
    private static String getPlant = "SELECT * FROM PLANTS WHERE PlantType='Plant'";
    private static String getFlowering = "SELECT * FROM PLANTS WHERE PlantType='Flowering'";
    private static String getOrchids = "SELECT * FROM PLANTS WHERE PlantType='Orchid'";
    private static String getCactus = "SELECT * FROM PLANTS WHERE PlantType='Cactus'";
    private static String getFernLike = "SELECT * FROM PLANTS WHERE PlantType='FernLike'";
    private static String getFern = "SELECT * FROM PLANTS WHERE PlantType='Fern'";
    private static String getAll_Family = "SELECT * FROM Family";
    private static String getAll_Sort = "SELECT * FROM Sort";
    private static String getAll_Fertilizer = "SELECT * FROM Fertilizer";
    private static String getAll_Soil = "SELECT * FROM Soil";
    private static String getAll_PotType = "SELECT * FROM PotType";
    private static String getAll_InflorescenceType = "SELECT * FROM InflorescenceType";
    private static String getAll_LeafStructure = "SELECT * FROM LeafStructure";
    private static String search_SortName = "SELECT * FROM Sort where Title = ?";
    private static String search_PlantName = "SELECT * FROM Plants where Title =?";
    private static String search_FamilyName = "SELECT * FROM Family where Title = ?";
    private static String search_SoilName = "SELECT * FROM Sort Soil Title = ?";
    private static String search_FertilizerName = "SELECT * FROM Fertilizer where Title = ?";
    private static String search_PotTypeName = "SELECT * FROM Sort PotType Title = ?";
    private static String search_InflorescenceTypeName = "SELECT * FROM InflorescenceType where Title = ?";
    private static String search_LeafStructureName = "SELECT * FROM LeafStructure where Title = ?";
    private static String search_SortId = "SELECT * FROM Sort where id = ?";
    private static String search_FamilyId = "SELECT * FROM Family where id = ?";
    private static String search_SoilId = "SELECT * FROM Sort Soil id = ?";
    private static String search_FertilizerId = "SELECT * FROM Fertilizer where id = ?";
    private static String search_PotTypeId = "SELECT * FROM Sort PotType id = ?";
    private static String search_InflorescenceTypeId = "SELECT * FROM InflorescenceType where id = ?";
    private static String search_LeafStructureId = "SELECT * FROM LeafStructure where id = ?";
    private static String search_PlantId = "SELECT * FROM Plants WHERE Title = ?";
    private static String delete_Plant = "DELETE FROM Plants WHERE Id = ? AND PlantType = 'Plant'";
    private static String delete_flowering = "DELETE FROM Plants WHERE Id = ? AND PlantType = 'Flowering'";
    private static String delete_orchid = "DELETE FROM Plants WHERE Id = ? AND PlantType = 'Orchid'";
    private static String delete_cactus = "DELETE FROM Plants WHERE Id = ? AND PlantType = 'Cactus'";
    private static String delete_fernLike = "DELETE FROM Plants WHERE Id = ? AND PlantType = 'fernLike'";
    private static String delete_fern = "DELETE FROM Plants WHERE Id = ? AND PlantType = 'Fern'";
    private static String delete_Family = "DELETE FROM Family WHERE Id = ?";
    private static String delete_Fertilizer = "DELETE FROM Fertilizer WHERE Id = ?";
    private static String delete_Soil = "DELETE FROM Soil WHERE Id = ?";
    private static String delete_Sort = "DELETE FROM Sort WHERE Id = ?";
    private static String delete_PotType = "DELETE FROM PotType WHERE Id = ?";
    private static String delete_InflorescenceType = "DELETE FROM InflorescenceType WHERE Id = ?";
    private static String delete_LeafStructure = "DELETE FROM LeafStructure WHERE Id = ?";
    private static String update_PlantName = "UPDATE Plants SET Title=? WHERE Id = ? AND PlantType = 'Plant'";
    private static String update_FloweringName = "UPDATE Plants SET Title=? WHERE Id = ? AND PlantType = 'Flowering'";
    private static String update_OrchidName = "UPDATE Plants SET Title=? WHERE Id = ? AND PlantType = 'Orchid'";
    private static String update_FernName = "UPDATE Plants SET Title=? WHERE Id = ? AND PlantType = 'Fern'";
    private static String update_FernLikeName = "UPDATE Plants SET Title=? WHERE Id = ? AND PlantType = 'FernLike'";
    private static String update_CactusName = "UPDATE Plants SET Title=? WHERE Id = ? AND PlantType = 'Cactus'";
    private static String update_Sort = "UPDATE Sort SET Title=? WHERE Id = ?";
    private static String update_Soil = "UPDATE Soil SET Title=? WHERE Id = ?";
    private static String update_Family = "UPDATE Family SET Title=? WHERE Id = ?";
    private static String update_Fertilizer = "UPDATE Fertilizer SET Title=? WHERE Id = ?";
    private static String update_LeafStructure = "UPDATE LeafStructure SET Title=? WHERE Id = ?";
    private static String update_InflorescenceType = "UPDATE InflorescenceType SET Title=? WHERE Id = ?";
    private static String update_PotType = "UPDATE PotType SET Title=? WHERE Id = ?";
    MySQLDAO(){
        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
        }catch (ClassNotFoundException e) {
            JOptionPane.showMessageDialog(null, "No connection to Driver");
        }
        try {

            con = DriverManager.getConnection("jdbc:mysql://localhost:3306/lab4_cpp?useUnicode=true&serverTimezone=UTC", "root", "124512ф");
        }  catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No connection to DataBase");
            System.err.format("SQL State: %s\n%s", e.getSQLState(), e.getMessage());
        }   catch (Exception e) {
                e.printStackTrace();
            }
    }
    @Override
    public LinkedList<Sort> search_SortName(String _Title) {
        LinkedList<Sort> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_SortName);
            ps.setString(1,_Title);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Sort a = new Sort();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<Sort> search_SortId(int id) {
        LinkedList<Sort> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_SortId);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Sort a = new Sort();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<Soil> search_SoilName(String _Title) {
        LinkedList<Soil> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_SoilName);
            ps.setString(1,_Title);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Soil a = new Soil();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<Soil> search_SoilId(int id) {
        LinkedList<Soil> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_SoilId);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Soil a = new Soil();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<PotType> search_PotTypeName(String _Title) {
        LinkedList<PotType> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_PotTypeName);
            ps.setString(1,_Title);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PotType a = new PotType();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<PotType> search_PotTypeId(int id) {
        LinkedList<PotType> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_PotTypeId);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                PotType a = new PotType();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<Plant> search_PlantName(String _Title) {
        LinkedList<Plant> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_PlantName);
            ps.setString(1,_Title);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Plant a = new Plant();
                a.set_Id(rs.getInt("id"));
                a.set_Age(rs.getInt("Title"));
                a.set_FertilizerType_Id(rs.getInt("FertilizerType_Id"));
                a.set_PotType_Id(rs.getInt("PotType_Id"));
                a.set_SoilType_Id(rs.getInt("SoilType_Id"));
                a.set_Title(rs.getString("Title"));
                a.set_Sort_Id(rs.getInt("Sort_Id"));
                a.set_Family_Id(rs.getInt("Family_Id"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<Plant> search_PlantId(int id) {
        LinkedList<Plant> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_PlantId);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Plant a = new Plant();
                a.set_Id(rs.getInt("id"));
                a.set_Age(rs.getInt("Title"));
                a.set_FertilizerType_Id(rs.getInt("FertilizerType_Id"));
                a.set_PotType_Id(rs.getInt("PotType_Id"));
                a.set_SoilType_Id(rs.getInt("SoilType_Id"));
                a.set_Title(rs.getString("Title"));
                a.set_Sort_Id(rs.getInt("Sort_Id"));
                a.set_Family_Id(rs.getInt("Family_Id"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<LeafStructure> search_LeafStructureName(String _Title) {
        LinkedList<LeafStructure> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_LeafStructureName);
            ps.setString(1,_Title);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                LeafStructure a = new LeafStructure();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<LeafStructure> search_LeafStructureId(int id) {
        LinkedList<LeafStructure> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_LeafStructureId);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                LeafStructure a = new LeafStructure();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<InflorescenceType> search_InflorescenceTypeName(String _Title) {
        LinkedList<InflorescenceType> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_InflorescenceTypeName);
            ps.setString(1,_Title);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                InflorescenceType a = new InflorescenceType();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<InflorescenceType> search_InflorescenceTypeId(int id) {
        LinkedList<InflorescenceType> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_InflorescenceTypeId);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                InflorescenceType a = new InflorescenceType();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<Fertilizer> search_FertilizerName(String _Title) {
        LinkedList<Fertilizer> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_FertilizerName);
            ps.setString(1,_Title);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Fertilizer a = new Fertilizer();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<Fertilizer> search_FertilizerId(int id) {
        LinkedList<Fertilizer> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_FertilizerId);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Fertilizer a = new Fertilizer();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<Family> search_FamilyName(String _Title) {
        LinkedList<Family> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_FamilyName);
            ps.setString(1,_Title);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Family a = new Family();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<Family> search_FamilyId(int id) {
        LinkedList<Family> list = new LinkedList<>();
        try {
            PreparedStatement ps = con.prepareStatement(search_FamilyId);
            ps.setInt(1,id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()){
                Family a = new Family();
                a.set_Id(rs.getInt("id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<Plant> search_OrchidName(String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_OrchidId(int id) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_FloweringName(String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_FloweringId(int id) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_FernLikeName(String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_FernLikeId(int id) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_FernName(String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_FernId(int id) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_CactusName(String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> search_CactusId(int id) {
        return null;
    }

    @Override
    public LinkedList<Sort> updateSort(int id, String _Title) {
        try {
            PreparedStatement ps = con.prepareStatement(update_Sort);
            ps.setString(1,_Title);
            ps.setInt(2,id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return GetAllSort();
    }

    @Override
    public LinkedList<Soil> updateSoil(int id, String _Title) {
        try {
            PreparedStatement ps = con.prepareStatement(update_Soil);
            ps.setString(1,_Title);
            ps.setInt(2,id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return GetAllSoil();
    }

    @Override
    public LinkedList<PotType> updatePotType(int id, String _Title) {
        try {
            PreparedStatement ps = con.prepareStatement(update_PotType);
            ps.setString(1,_Title);
            ps.setInt(2,id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return GetAllPotType();
    }

    @Override
    public LinkedList<LeafStructure> updateLeafStructure(int id, String _Title) {
        try {
            PreparedStatement ps = con.prepareStatement(update_LeafStructure);
            ps.setString(1,_Title);
            ps.setInt(2,id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return GetAllLeafStructure();
    }

    @Override
    public LinkedList<InflorescenceType> updateInflorescenceType(int id, String _Title) {
        try {
            PreparedStatement ps = con.prepareStatement(update_InflorescenceType);
            ps.setString(1,_Title);
            ps.setInt(2,id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return GetAllInflorescenceType();
    }

    @Override
    public LinkedList<Fertilizer> updateFertilizer(int id, String _Title) {
        try {
            PreparedStatement ps = con.prepareStatement(update_Fertilizer);
            ps.setString(1,_Title);
            ps.setInt(2,id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return GetAllFertilizer();
    }

    @Override
    public LinkedList<Family> updateFamily(int id, String _Title) {
        try {
            PreparedStatement ps = con.prepareStatement(update_Family);
            ps.setString(1,_Title);
            ps.setInt(2,id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return GetAllFamily();
    }

    @Override
    public LinkedList<Plant> updatePlantTitle(int id, String _Title) {
        try {
            PreparedStatement ps = con.prepareStatement(update_PlantName);
            ps.setString(1,_Title);
            ps.setInt(2,id);
            ps.executeUpdate();
            ps.close();

        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return getPlant();
    }

    @Override
    public LinkedList<Plant> updateOrchidsTitle(int id, String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> updateFloweringTitle(int id, String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> updateFernTitle(int id, String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> updateFernLikeTitle(int id, String _Title) {
        return null;
    }

    @Override
    public LinkedList<Plant> updateCactusTitle(int id, String _Title) {
        return null;
    }

    @Override
    public void deleteSort(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(delete_Sort);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteSoil(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(delete_Soil);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deletePotTye(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(delete_PotType);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteLeafStructure(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(delete_LeafStructure);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteInflorescenceType(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(delete_InflorescenceType);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteFertilizer(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(delete_Fertilizer);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteFamily(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(delete_Family);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deletePlant(int id) {
        try {
            PreparedStatement ps = con.prepareStatement(delete_Plant);
            ps.setInt(1,id);
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void deleteOrchid(int id) {

    }

    @Override
    public void deleteFlowering(int id) {

    }

    @Override
    public void deleteFernLike(int id) {

    }

    @Override
    public void deleteFern(int id) {

    }

    @Override
    public void deleteCactus(int id) {

    }

    @Override
    public void addSort(Sort _Sort) {
        try {
            PreparedStatement ps = con.prepareStatement(add_Sort);
            ps.setString(1,_Sort.get_Title());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addSoil(Soil _Soil) {
        try {
            PreparedStatement ps = con.prepareStatement(add_Soil);
            ps.setString(1,_Soil.get_Title());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addPotType(PotType _PotType) {
        try {
            PreparedStatement ps = con.prepareStatement(add_PotType);
            ps.setString(1,_PotType.get_Title());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //"INSERT INTO Plants(Title,Family_Id,Sort_Id,FertilizerType_Id,SoilType_Id,PotType_Id,PlantType) VALUES (?,?,?,?,?,?,?)";
    @Override
    public void addPlant(Plant _Plant) {
        try {
            PreparedStatement ps = con.prepareStatement(add_Plant);
            ps.setString(1,_Plant.get_Title());
            ps.setInt(2,_Plant.get_Family_Id());
            ps.setInt(3,_Plant.get_Sort_Id());
            ps.setInt(4,_Plant.get_FertilizerType_Id());
            ps.setInt(5,_Plant.get_SoilType_Id());
            ps.setInt(6,_Plant.get_PotType_Id());
            ps.setString(7,"Plant");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addLeafStructure(LeafStructure _LeafStructure) {
        try {
            PreparedStatement ps = con.prepareStatement(add_LeafStructure);
            ps.setString(1,_LeafStructure.get_Title());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addInflorescenceType(InflorescenceType _InflorescenceType) {
        try {
            PreparedStatement ps = con.prepareStatement(add_InflorescenceType);
            ps.setString(1,_InflorescenceType.get_Title());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addFertilizer(Fertilizer _Fertilizer) {
        try {
            PreparedStatement ps = con.prepareStatement(add_Fertilizer);
            ps.setString(1,_Fertilizer.get_Title());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public void addFamily(Family _Family) {
        try {
            PreparedStatement ps = con.prepareStatement(add_Family);
            ps.setString(1,_Family.get_Title());
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //"INSERT INTO Plants(Title,Family_Id,Sort_Id,FertilizerType_Id,SoilType_Id,PotType_Id,FlowerColor,FlowerSize,PlantType) VALUES (?,?,?,?,?,?,?,?,?)";
    @Override
    public void addPlant(Flowering _Flowering) {
        try {
            PreparedStatement ps = con.prepareStatement(add_Flowering);
            ps.setString(1,_Flowering.get_Title());
            ps.setInt(2,_Flowering.get_Family_Id());
            ps.setInt(3,_Flowering.get_Sort_Id());
            ps.setInt(4,_Flowering.get_FertilizerType_Id());
            ps.setInt(5,_Flowering.get_SoilType_Id());
            ps.setInt(6,_Flowering.get_PotType_Id());
            ps.setString(7,_Flowering.get_FlowerColor());
            ps.setInt(8,_Flowering.get_FlowerSize());
            ps.setString(9,"Flowering");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //"INSERT INTO Plants(Title,Family_Id,Sort_Id,FertilizerType_Id,SoilType_Id,PotType_Id,DisputesSize,Leaf_Structure_Id,PlantType) VALUES (?,?,?,?,?,?,?,?,?)";
    @Override
    public void addPlant(FernLike _FernLike) {
        try {
            PreparedStatement ps = con.prepareStatement(add_FernLike);
            ps.setString(1,_FernLike.get_Title());
            ps.setInt(2,_FernLike.get_Family_Id());
            ps.setInt(3,_FernLike.get_Sort_Id());
            ps.setInt(4,_FernLike.get_FertilizerType_Id());
            ps.setInt(5,_FernLike.get_SoilType_Id());
            ps.setInt(6,_FernLike.get_PotType_Id());
            ps.setInt(7,_FernLike.get_DisputesSize());
            ps.setInt(8,_FernLike.get_LeafStructure_Id());
            ps.setString(9,"FernLike");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //"INSERT INTO Plants(Title,Family_Id,Sort_Id,FertilizerType_Id,SoilType_Id,PotType_Id,FlowerColor,FlowerSize,InflorescenceType_Id,PlantType) VALUES (?,?,?,?,?,?,?,?,?,?)";
    @Override
    public void addPlant(Orchids _Orchid) {
        try {
            PreparedStatement ps = con.prepareStatement(add_Orchid);
            ps.setString(1,_Orchid.get_Title());
            ps.setInt(2,_Orchid.get_Family_Id());
            ps.setInt(3,_Orchid.get_Sort_Id());
            ps.setInt(4,_Orchid.get_FertilizerType_Id());
            ps.setInt(5,_Orchid.get_SoilType_Id());
            ps.setInt(6,_Orchid.get_PotType_Id());
            ps.setString(7,_Orchid.get_FlowerColor());
            ps.setInt(8,_Orchid.get_FlowerSize());
            ps.setInt(9,_Orchid.get_InflorescenceType_Id());
            ps.setString(10,"Orchid");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //"INSERT INTO Plants(Title,Family_Id,Sort_Id,FertilizerType_Id,SoilType_Id,PotType_Id,FlowerColor,FlowerSize,QuillLength,PlantType) VALUES (?,?,?,?,?,?,?,?,?,?)";
    @Override
    public void addPlant(Cactus _Cactus) {
        try {
            PreparedStatement ps = con.prepareStatement(add_Cactus);
            ps.setString(1,_Cactus.get_Title());
            ps.setInt(2,_Cactus.get_Family_Id());
            ps.setInt(3,_Cactus.get_Sort_Id());
            ps.setInt(4,_Cactus.get_FertilizerType_Id());
            ps.setInt(5,_Cactus.get_SoilType_Id());
            ps.setInt(6,_Cactus.get_PotType_Id());
            ps.setString(7,_Cactus.get_FlowerColor());
            ps.setInt(8,_Cactus.get_FlowerSize());
            ps.setInt(9,_Cactus.get_QuillLength());
            ps.setString(10,"Plant");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    //"INSERT INTO Plants(Title,Family_Id,Sort_Id,FertilizerType_Id,SoilType_Id,PotType_Id,DisputesSize,Leaf_Structure_Id,RootStockSize,PlantType) VALUES (?,?,?,?,?,?,?,?,?,?)";
    @Override
    public void addPlant(Fern _Fern) {
        try {
            PreparedStatement ps = con.prepareStatement(add_Fern);
            ps.setString(1,_Fern.get_Title());
            ps.setInt(2,_Fern.get_Family_Id());
            ps.setInt(3,_Fern.get_Sort_Id());
            ps.setInt(4,_Fern.get_FertilizerType_Id());
            ps.setInt(5,_Fern.get_SoilType_Id());
            ps.setInt(6,_Fern.get_PotType_Id());
            ps.setInt(7,_Fern.get_DisputesSize());
            ps.setInt(8,_Fern.get_LeafStructure_Id());
            ps.setInt(9,_Fern.get_RootStockSize());
            ps.setString(10,"Fern");
            ps.executeUpdate();
            ps.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
    }

    @Override
    public LinkedList<Plant> getPlant() {
        LinkedList<Plant> list = new LinkedList<>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(getPlant);
            while (rs.next()){
                Plant a = new Plant();
                a.set_Id(rs.getInt("Id"));
                a.set_Family_Id(rs.getInt("Family_Id"));
                a.set_Sort_Id(rs.getInt("Sort_Id"));
                a.set_Title(rs.getString("Title"));
                a.set_SoilType_Id(rs.getInt("SoilType_Id"));
                a.set_PotType_Id(rs.getInt("PotType_Id"));
                a.set_FertilizerType_Id(rs.getInt("FertilizerType_Id"));
                list.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<Flowering> getFlowering() {
        return null;
    }

    @Override
    public LinkedList<FernLike> getFernLike() {
        return null;
    }

    @Override
    public LinkedList<Orchids> getOrchids() {
        return null;
    }

    @Override
    public LinkedList<Fern> getFern() {
        return null;
    }

    @Override
    public LinkedList<Cactus> getCactus() {
        return null;
    }
    @Override
    public LinkedList<Sort> GetAllSort() {
        LinkedList<Sort> list = new LinkedList<Sort>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(getAll_Sort);
            while (rs.next()){
                Sort a = new Sort();
                a.set_Id(rs.getInt("Id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public LinkedList<Soil> GetAllSoil() {
        LinkedList<Soil> list = new LinkedList<Soil>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(getAll_Soil);
            while (rs.next()){
                Soil a = new Soil();
                a.set_Id(rs.getInt("Id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public LinkedList<PotType> GetAllPotType() {
        LinkedList<PotType> list = new LinkedList<PotType>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(getAll_PotType);
            while (rs.next()){
                PotType a = new PotType();
                a.set_Id(rs.getInt("Id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public LinkedList<LeafStructure> GetAllLeafStructure() {
        LinkedList<LeafStructure> list = new LinkedList<LeafStructure>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(getAll_LeafStructure);
            while (rs.next()){
                LeafStructure a = new LeafStructure();
                a.set_Id(rs.getInt("Id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public LinkedList<InflorescenceType> GetAllInflorescenceType() {
        LinkedList<InflorescenceType> list = new LinkedList<InflorescenceType>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(getAll_InflorescenceType);
            while (rs.next()){
                InflorescenceType a = new InflorescenceType();
                a.set_Id(rs.getInt("Id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

    @Override
    public LinkedList<Fertilizer> GetAllFertilizer() {
        LinkedList<Fertilizer> list = new LinkedList<Fertilizer>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(getAll_Fertilizer);
            while (rs.next()){
                Fertilizer a = new Fertilizer();
                a.set_Id(rs.getInt("Id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }
        return list;
    }

    @Override
    public LinkedList<Family> GetAllFamily() {
        LinkedList<Family> list = new LinkedList<Family>();
        try {
            Statement st = con.createStatement();
            ResultSet rs = st.executeQuery(getAll_Family);
            while (rs.next()){
                Family a = new Family();
                a.set_Id(rs.getInt("Id"));
                a.set_Title(rs.getString("Title"));
                list.add(a);
            }
            rs.close();
            st.close();
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }

        return list;
    }

}
