package remijan.m.class3.lecture;

import java.sql.Connection;
import java.sql.PreparedStatement;

public class Ex07_InsertArtist {

    public static void main(String[] args) throws Exception {
        // Get connection to the database.
        ConnectionHandler connectionHandler
            = new ConnectionHandler();
        Connection conn
            = connectionHandler.getConnection();


        // NOTE
        // Do the query 1st in SquirrelSQL, then copy & paste it into your code.
        StringBuilder artistSql = new StringBuilder();
        artistSql.append(" insert into artist ( ");
        artistSql.append("      id         ");
        artistSql.append("     ,artist   ");
        artistSql.append(" ) values ( ");
        artistSql.append("      ?");
        artistSql.append("     ,?");
        artistSql.append(" ) ");

        StringBuilder albumSql = new StringBuilder();
        albumSql.append(" insert into album ( ");
        albumSql.append("      id         ");
        albumSql.append("     ,artist_ptr ");
        albumSql.append("     ,title      ");
        albumSql.append(" ) values ( ");
        albumSql.append("      ?");
        albumSql.append("     ,?");
        albumSql.append("     ,?");
        albumSql.append(" ) ");


        // Use a try-with-resources statement so that
        // the PreparedStatement and the ResultSet
        // objects are closed automatically for you so
        // your application does not have a resource leak
        try (
            // A PreparedStatement is the object used
            // which represents the database SQL statement
            PreparedStatement artistStmt
                = conn.prepareStatement(artistSql.toString());

            PreparedStatement albumStmt
                = conn.prepareStatement(albumSql.toString());
        ) {
            // Frank Sinatra
            Long sinatraId = System.currentTimeMillis();
            {
                System.out.printf("Insert artist Frank Sinatra%n");
                // id
                artistStmt.setLong(1, sinatraId);
                // artist
                artistStmt.setString(2, "Frank Sinatra");

                // execute
                int count
                    = artistStmt.executeUpdate();

                System.out.printf(" +- Inserted %d record%n", count);
            }

            // Where are You?
            {
                System.out.printf("Insert data Where are You?%n");
                // id
                albumStmt.setLong(1, System.currentTimeMillis());
                // artist_ptr
                albumStmt.setLong(2, sinatraId);
                // title
                albumStmt.setString(3, "Where are You?");

                // execute
                Thread.sleep(300);
                int count = albumStmt.executeUpdate();

                System.out.printf(" +- Inserted %d record%n", count);
            }

            // In the Wee Small Hours
            {
                System.out.printf("Insert data In the Wee Small Hours%n");
                // id
                albumStmt.setLong(1, System.currentTimeMillis());
                // artist_ptr
                albumStmt.setLong(2, sinatraId);
                // title
                albumStmt.setString(3, "In the Wee Small Hours");

                // execute
                Thread.sleep(300);
                int count = albumStmt.executeUpdate();

                System.out.printf(" +- Inserted %d record%n", count);
            }

            // Songs for Swingin' Lovers!
            {
                System.out.printf("Insert data Songs for Swingin' Lovers!%n");
                // id
                albumStmt.setLong(1, System.currentTimeMillis());
                // artist_ptr
                albumStmt.setLong(2, sinatraId);
                // title
                albumStmt.setString(3, "Songs for Swingin' Lovers!");

                // execute
                Thread.sleep(300);
                int count = albumStmt.executeUpdate();

                System.out.printf(" +- Inserted %d record%n", count);
            }

            // Come Fly with Me
            {
                System.out.printf("Insert data Come Fly with Me%n");
                // id
                albumStmt.setLong(1, System.currentTimeMillis());
                // artist_ptr
                albumStmt.setLong(2, sinatraId);
                // title
                albumStmt.setString(3, "Come Fly with Me");

                // execute
                Thread.sleep(300);
                int count = albumStmt.executeUpdate();

                System.out.printf(" +- Inserted %d record%n", count);
            }
        }

        // You are done with the application so close
        // your database connection
        conn.close();

        System.out.printf("%nGood-bye!%n");
    }
}
