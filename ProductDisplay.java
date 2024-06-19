import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class ProductDisplay {
    public static void main(String[] args) {
        String jdbcURL = "jdbc:sqlserver://localhost:1433;databaseName=product_1";
        String dbUser = "sa";
        String dbPassword = "abcd@1234";

        try {
            
            Connection connection = DriverManager.getConnection(jdbcURL, dbUser, dbPassword);
            System.out.println("Connected to the database.");

          
            Statement statement = connection.createStatement();

          
            String sql = "SELECT id, name, price_per_unit, active_for_sell FROM Product";
            ResultSet resultSet = statement.executeQuery(sql);

            
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                double pricePerUnit = resultSet.getDouble("price_per_unit");
                boolean activeForSell = resultSet.getBoolean("active_for_sell");

                System.out.printf("ID: %d, Name: %s, Price per Unit: %.2f, Active for Sell: %b%n",
                        id, name, pricePerUnit, activeForSell);
            }

           
            resultSet.close();
            statement.close();
            connection.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
