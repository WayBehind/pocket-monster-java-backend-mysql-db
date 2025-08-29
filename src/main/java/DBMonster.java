import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class DBMonster {
    // C
    public void addMonster(String name, int trainerId) {
        final String insert = "INSERT INTO monster (name, trainer_id) VALUES (?, ?)";

        try (Connection connection = HikariDBSource.getConnection()) {
            final PreparedStatement preparedStatement = connection.prepareStatement(insert);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, trainerId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // R
    public void printMonster(int id) {
        final String query = "SELECT * FROM monster WHERE id = ?";

        try (Connection connection = HikariDBSource.getConnection()) {
            final PreparedStatement preparedStatement = connection.prepareStatement(query);
            preparedStatement.setInt(1, id);
            final ResultSet resultSet = preparedStatement.executeQuery();
            while (resultSet.next()) {
                System.out.println("id: " + resultSet.getInt("id") +
                        " | name: " + resultSet.getString("name") +
                        " | trainer_id: " + resultSet.getInt("trainer_id"));
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // U
    public void updateMonster(String name, int trainerId) {
        final String update = "UPDATE monster SET name = ?, trainer_id = ?";

        try (Connection connection = HikariDBSource.getConnection()){
            final PreparedStatement preparedStatement = connection.prepareStatement(update);
            preparedStatement.setString(1, name);
            preparedStatement.setInt(2, trainerId);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    // D
    public void deleteMonster(int id) {
        final String delete = "DELETE FROM monster WHERE id = ?";

        try (Connection connection = HikariDBSource.getConnection()) {
            final PreparedStatement preparedStatement = connection.prepareStatement(delete);
            preparedStatement.setInt(1, id);
            preparedStatement.executeUpdate();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
