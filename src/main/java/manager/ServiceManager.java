package manager;

import db.DBConnectionProvider;
import model.Service;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class ServiceManager {
    private Connection connection;

    public ServiceManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void add(Service service) {
        String query = "INSERT INTO service(`name`,`price`,`description`,`pic_url`) VALUES (?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, service.getName());
            preparedStatement.setDouble(2, service.getPrice());
            preparedStatement.setString(3, service.getDescription());
            preparedStatement.setString(4, service.getImagePath());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error during create statement:" + e);
        }
    }

    public List<Service> getAllService() {
        String query = "SELECT * FROM service";
        List<Service> services = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Service service = getServiceFromResultSet(resultSet);
                services.add(service);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return services;
    }

    private Service getServiceFromResultSet(ResultSet resultSet) throws SQLException, ParseException {
        return Service.builder()
                .id(resultSet.getInt(1))
                .name(resultSet.getString(2))
                .price(resultSet.getDouble(3))
                .description(resultSet.getString(4))
                .imagePath(resultSet.getString(5))
                .build();
    }

}
