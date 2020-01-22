package manager;

import db.DBConnectionProvider;
import model.Master;

import java.sql.*;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

public class MasterManager {
    private Connection connection;

    public MasterManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void add(Master master) {
        String query = "INSERT INTO master(`name`,`surname`,`pic_url`) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, master.getName());
            preparedStatement.setString(2, master.getSurname());
            preparedStatement.setString(3, master.getImagePath());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error during create statement:" + e);
        }
    }

    public List<Master> getAllMasters() {
        String query = "SELECT * FROM `master`";
        List<Master> masters = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Master master = getMasterFromResultSet(resultSet);
                masters.add(master);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return masters;
    }

    private Master getMasterFromResultSet(ResultSet resultSet) throws SQLException, ParseException {
        return Master.builder()
                .id(resultSet.getInt(1))
                .name(resultSet.getString(2))
                .surname(resultSet.getString(3))
                .imagePath(resultSet.getString(4))
                .build();
    }


}
