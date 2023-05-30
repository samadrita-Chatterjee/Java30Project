/*
 * 13. Create a Java program that connects to a PostgreSQL database and executes a
batch update. The program should read the input data from a file and insert it into the
database using JDBC batch updates.
 * 
 */


package in.ineuron.test;

import java.sql.BatchUpdateException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Arrays;


public class BatchUpdateOperation {

    private final static String url = "jdbc:postgresql://localhost:5433/new_db";
    private final static String user = "postgres";
    private final static String password = "root123";

    public static void main(String[] args) {
        parameterizedBatchUpdate();
    }

    public static void printSQLException(SQLException ex) {
        for (Throwable e: ex) {
            if (e instanceof SQLException) {
                e.printStackTrace(System.err);
                System.err.println("SQLState: " + ((SQLException) e).getSQLState());
                System.err.println("Error Code: " + ((SQLException) e).getErrorCode());
                System.err.println("Message: " + e.getMessage());
                Throwable t = ex.getCause();
                while (t != null) {
                    System.out.println("Cause: " + t);
                    t = t.getCause();
                }
            }
        }
    }

    private static void parameterizedBatchUpdate() {

        String UPDATE_USERS_SQL = "update student set name = ? where id = ?;";

        try (Connection connection = DriverManager.getConnection(url, user, password);
            // Step 2:Create a statement using connection object
            PreparedStatement preparedStatement = connection.prepareStatement(UPDATE_USERS_SQL)) {
            connection.setAutoCommit(false);

            preparedStatement.setString(1, "A");
            preparedStatement.setInt(2, 1);
            preparedStatement.addBatch();

            preparedStatement.setString(1, "B");
            preparedStatement.setInt(2, 2);
            preparedStatement.addBatch();

            preparedStatement.setString(1, "C");
            preparedStatement.setInt(2, 3);
            preparedStatement.addBatch();

            preparedStatement.setString(1, "D");
            preparedStatement.setInt(2, 4);
            preparedStatement.addBatch();

            int[] updateCounts = preparedStatement.executeBatch();
            System.out.println(Arrays.toString(updateCounts));
            connection.commit();
            connection.setAutoCommit(true);
        } catch (BatchUpdateException batchUpdateException) {
            printBatchUpdateException(batchUpdateException);
        } catch (SQLException e) {
            printSQLException(e);
        }
    }

    public static void printBatchUpdateException(BatchUpdateException b) {

        System.err.println("----BatchUpdateException----");
        System.err.println("SQLState:  " + b.getSQLState());
        System.err.println("Message:  " + b.getMessage());
        System.err.println("Vendor:  " + b.getErrorCode());
        System.err.print("Update counts:  ");
        int[] updateCounts = b.getUpdateCounts();

        for (int i = 0; i < updateCounts.length; i++) {
            System.err.print(updateCounts[i] + "   ");
        }
    }
}