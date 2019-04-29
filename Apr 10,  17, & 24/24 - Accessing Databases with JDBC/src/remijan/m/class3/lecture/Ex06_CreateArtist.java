package remijan.m.class3.lecture;

import java.sql.PreparedStatement;

public class Ex06_CreateArtist {

    public static void main(String[] args) throws Exception {
        // Get connection to the database.
        ConnectionHandler connectionHandler
            = new ConnectionHandler();

        createArtistTable(connectionHandler);
        createAlbumTable(connectionHandler);

        // You are done with the application so close
        // your database connection
        connectionHandler.getConnection().close();

        System.out.printf("%nGood-bye!%n");
    }

    /**
     * Create the 'artist' table
     */
    protected static void createArtistTable(ConnectionHandler connectionHandler) throws Exception {
        // Use the StringBuilder class to create an SQL statement
        // that can be executed to create a table named 'artist'
        StringBuilder sp = new StringBuilder();
        sp.append(" create table artist ( ");
        sp.append("      id                bigint       not null ");
        sp.append("     ,artist            varchar(20)  not null ");
        sp.append("     ,constraint artist_pk primary key(id) ");
        sp.append(" ) ");

        // Use a try-with-resources statement so that
        // the PreparedStatement and the ResultSet
        // objects are closed automatically for you so
        // your application does not have a resource leak
        try (
            // A PreparedStatement is the object used
            // which represents the database SQL statement
            PreparedStatement stmt
                = connectionHandler.getConnection().prepareStatement(sp.toString());
        ) {
            // Execute statement to create table
            System.out.printf("Creating table 'artist'...");
            stmt.execute();
            System.out.printf("[DONE]%n");
        }
    }


    /**
     * Create the 'album' table
     */
    protected static void createAlbumTable(ConnectionHandler connectionHandler) throws Exception {
        // Use the StringBuilder class to create an SQL statement
        // that can be executed to create a table named 'artist'
        StringBuilder sp = new StringBuilder();
        sp.append(" create table album ( ");
        sp.append("      id                bigint       not null ");
        sp.append("     ,artist_ptr        bigint       not null ");
        sp.append("     ,title             varchar(30)  not null ");
        sp.append("     ,constraint album_pk primary key (id) ");
        sp.append("     ,constraint album_fk foreign key (artist_ptr) references artist (id) ");
        sp.append(" ) ");

        // Use a try-with-resources statement so that
        // the PreparedStatement and the ResultSet
        // objects are closed automatically for you so
        // your application does not have a resource leak
        try (
            // A PreparedStatement is the object used
            // which represents the database SQL statement
            PreparedStatement stmt
                = connectionHandler.getConnection().prepareStatement(sp.toString());
        ) {
            // Execute statement to create table
            System.out.printf("Creating table 'album'...");
            stmt.execute();
            System.out.printf("[DONE]%n");
        }
    }
}
