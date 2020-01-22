package manager;

import db.DBConnectionProvider;
import model.Gallery;

import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

public class GalleryManager {
    private Connection connection;
    private SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");

    public GalleryManager() {
        connection = DBConnectionProvider.getInstance().getConnection();
    }


    public void add(Gallery gallery) {
        String query = "INSERT INTO gallery(`pic_url`,`date`,`description`) VALUES (?, ?, ?)";

        try {
            PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setString(1, gallery.getPicUrl());
            preparedStatement.setString(2, sdf.format(gallery.getDate()));
            preparedStatement.setString(3, gallery.getDescription());
            preparedStatement.executeUpdate();
        } catch (SQLException e) {
            System.out.println("error during create statement:" + e);
        }
    }

    public List<Gallery> getAllPic() {
        String query = "SELECT * FROM gallery";
        List<Gallery> galleries = new ArrayList<>();
        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(query);
            while (resultSet.next()) {
                Gallery gallery = getGalleryFromResultSet(resultSet);
                galleries.add(gallery);
            }
        } catch (SQLException | ParseException e) {
            e.printStackTrace();
        }
        return galleries;
    }

    private Gallery getGalleryFromResultSet(ResultSet resultSet) throws SQLException, ParseException {
        return Gallery.builder()
                .id(resultSet.getInt(1))
                .picUrl(resultSet.getString(2))
                .date(sdf.parse(resultSet.getString(3)))
                .description(resultSet.getString(4))
                .build();
    }


}
