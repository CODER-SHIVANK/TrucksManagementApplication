package org.example;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

public class TruckService {
    public void addTruck(Truck truck){
        String sql="insert into truck (name,model,capacity,driver_name) values (?,?,?,?)";
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, truck.getName());
            preparedStatement.setString(2, truck.getModel());
            preparedStatement.setInt(3, truck.getCapacity());
            preparedStatement.setString(4, truck.getDriverName());
            int update = preparedStatement.executeUpdate();
            System.out.println("Row Inserted: "+update);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public Truck getTruckById(int id){
        String sql="select * from truck where id = ?";
        Truck truck = new Truck();
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setInt(1, id);
            ResultSet resultSet = preparedStatement.executeQuery();
            if(resultSet.next()){
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriverName(resultSet.getString("driver_name"));
            }

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return truck;
    }
    public void updateTruck(Truck truck){
        String sql="update truck set name = ?, model = ?, capacity = ?, driver_name = ? where id= ?";
        try{
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(sql);
            preparedStatement.setString(1, truck.getName());
            preparedStatement.setString(2, truck.getModel());
            preparedStatement.setInt(3, truck.getCapacity());
            preparedStatement.setString(4, truck.getDriverName());
            preparedStatement.setInt(5, truck.getId());

            int update = preparedStatement.executeUpdate();
            System.out.println("row updated : "+update);

        } catch (Exception e) {
            System.out.println(e.getMessage());
        }
    }
    public List<Truck> getAllTrucks(){
        String sql="select * from truck";
        List<Truck>trucks = new ArrayList<Truck>();
        try{
            Connection connection = ConnectionDetails.getConnection();
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(sql);
            while (resultSet.next()){
                Truck truck = new Truck();
                truck.setId(resultSet.getInt("id"));
                truck.setName(resultSet.getString("name"));
                truck.setModel(resultSet.getString("model"));
                truck.setCapacity(resultSet.getInt("capacity"));
                truck.setDriverName(resultSet.getString("driver_name"));
                trucks.add(truck);
            }
        }
        catch (Exception e) {
            System.out.println(e.getMessage());
        }
        return trucks;
    }
    public void deleteTruck(int id)
    {
        String deleteQuery="delete from truck where id= ?";
        try {
            Connection connection = ConnectionDetails.getConnection();
            PreparedStatement preparedStatement = connection.prepareStatement(deleteQuery);
            preparedStatement.setInt(1,id);
            int update = preparedStatement.executeUpdate();
            System.out.println("Row Deleted : "+update);
        }
        catch (Exception e)
        {
            System.out.println(e.getMessage());
        }
    }
}
