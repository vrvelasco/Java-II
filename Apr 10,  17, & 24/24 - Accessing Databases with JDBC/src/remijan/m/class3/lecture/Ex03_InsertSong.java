package remijan.m.class3.lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ex03_InsertSong {

    public static void main(String[] args) throws Exception {
        // Get connection to the database.
        ConnectionHandler connectionHandler
            = new ConnectionHandler();
        Connection conn
            = connectionHandler.getConnection();


        // NOTE
        // Do the query 1st in SquirrelSQL, then copy & paste it into your code.
        StringBuilder sp = new StringBuilder();
        sp.append(" insert into song ( ");
        sp.append("      id         ");
        sp.append("     ,artist   ");
        sp.append("     ,title   ");
        sp.append("     ,minutes       ");
        sp.append(" ) values ( ");
        sp.append("      ?");
        sp.append("     ,?");
        sp.append("     ,?");
        sp.append("     ,?");
        sp.append(" ) ");


        // Use a try-with-resources statement so that
        // the PreparedStatement and the ResultSet
        // objects are closed automatically for you so
        // your application does not have a resource leak
        try (
            // A PreparedStatement is the object used
            // which represents the database SQL statement
            PreparedStatement stmt
                = conn.prepareStatement(sp.toString());
        ) {
            // Fly Me to the Moon
            {
                System.out.printf("Insert data for Fly Me to the Moon%n");
                // id
                stmt.setLong(1, System.currentTimeMillis());
                // artist
                stmt.setString(2, "Louis Armstrong");
                // title
                stmt.setString(3, "what a wonderful world");
                // minutes
                stmt.setDouble(4, 3.2);

                // execute
                int count
                    = stmt.executeUpdate();

                System.out.printf(" +- Inserted %d record%n", count);
            }

            // My Way
            {
                System.out.printf("Insert data for My Way%n");
                // id
                stmt.setLong(1, System.currentTimeMillis());
                // artist
                stmt.setString(2, "Frank Sinatra");
                // title
                stmt.setString(3, "My Way");
                // minutes
                stmt.setDouble(4, 4.4);

                // execute
                int count
                    = stmt.executeUpdate();

                System.out.printf(" +- Inserted %d record%n", count);
            }

            // Strangers in the Night
            {
                System.out.printf("Insert data for Strangers in the Night%n");
                // id
                stmt.setLong(1, System.currentTimeMillis());
                // artist
                stmt.setString(2, "Frank Sinatra");
                // title
                stmt.setString(3, "Strangers in the Night");
                // minutes
                stmt.setDouble(4, 3.9);

                // execute
                int count
                    = stmt.executeUpdate();

                System.out.printf(" +- Inserted %d record%n", count);
            }
        }

        // You are done with the application so close
        // your database connection
        conn.close();

        System.out.printf("%nGood-bye!%n");
    }
}
