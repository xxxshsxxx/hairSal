package manager;

import db.DBConnectionProvider;
import model.Apointment;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class ApointmentManager {
    private Connection connection;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public ApointmentManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }

    public void add(Apointment apointment) {
        String query = "INSERT INTO apointment(`name`,`surname`,`email`,`date`,`time`,`phone`,`service_id`,`master_id`,`notes`)" +
                "VALUES (?, ?, ?, ?, ?, ?, ?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, apointment.getName());
            preparedStatement.setString(2, apointment.getSurname());
            preparedStatement.setString(3, apointment.getEmail());
            preparedStatement.setString(4, sdf.format(apointment.getDate()));
            preparedStatement.setString(5, apointment.getTime());
            preparedStatement.setString(6, apointment.getPhone());
            preparedStatement.setInt(7, apointment.getServiceId());
            preparedStatement.setInt(8, apointment.getMasterId());
            preparedStatement.setString(9, apointment.getNotes());

            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error during create statement:" + e);
        }
    }

    public List<Apointment> getAllApointments() {
        String query = "SELECT * FROM apointment";
        List<Apointment> apointments = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Apointment apointment = getApointmentFromResultSet(resultSet);
                apointments.add(apointment);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return apointments;
    }

    private Apointment getApointmentFromResultSet(ResultSet resultSet) throws SQLException, ParseException {
        return Apointment.builder()
                .id(resultSet.getInt(1))
                .name(resultSet.getString(2))
                .surname(resultSet.getString(3))
                .email(resultSet.getString(4))
                .date(resultSet.getDate(5))
                .time(resultSet.getString(6))
                .createdDate(resultSet.getDate(7))
                .phone(resultSet.getString(8))
                .serviceId(resultSet.getInt(9))
                .masterId(resultSet.getInt(10))
                .notes(resultSet.getString(11))
                .build();
    }
}
