package remijan.m.class2.lecture;

import java.math.BigDecimal;
import java.sql.Connection;
import java.sql.Date;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class DataHandler {
    
    private dataPath path;
    private Connection conn;

    public DataHandler(dataPath path) throws Exception {
        // Store the path
        this.path = path;
        
        // Connect to the database
        connect();
        
        // Initialize the database
        init();
    }

    protected void connect() throws Exception {
        // Driver
        String driver
            = "org.apache.derby.jdbc.EmbeddedDriver";
        Class.forName(driver);

        // Connection
        String connectionUrl
            = String.format("jdbc:derby:%s;user=;password=;create=true", path.toAbsolutePath());

        System.out.printf("JDBC Url: %s\n", connectionUrl);
        conn = DriverManager.getConnection(connectionUrl);
    }

    protected void init() throws Exception {

        if (path.existedAtStartup()) {
            System.out.printf("Database already initialized%n");
        } else {
            StringJoiner sj
                = new StringJoiner(",", "create table names (", ")");
            sj.add(" id                integer ");
            sj.add(" first             varchar(100) ");
            sj.add(" last            varchar(100) ");
           // sj.add(" publication_date  date ");
           // sj.add(" price             decimal(5,2) ");
           // sj.add(" amz_bestseller    boolean ");

            try (
                Statement stmt = conn.createStatement();
            ) {
                stmt.execute(sj.toString());
                System.out.printf("Names table Created%n");
            }
        }
    }

    public List<Book> findBooks() throws Exception {

        // PreparedStatement
        StringBuilder sp = new StringBuilder();
        sp.append(" select \n");
        sp.append("    id  \n");
        sp.append("   ,first   \n");
        sp.append("   ,last    \n");
       // sp.append("   ,publication_date \n");
       // sp.append("   ,price             \n");
       // sp.append("   ,amz_bestseller \n");
        sp.append(" from \n");
        sp.append("   names \n");

        try (
            PreparedStatement stmt
                = conn.prepareStatement(sp.toString());

            ResultSet rs
                = stmt.executeQuery();
        ) {
            // Loop over results
            List<Names> names = new LinkedList<>();
            while (rs.next()) {
                Names n = new Names();
                n.setId(rs.getInt(1));
                n.setFirst(rs.getString(2));
                n.setLast(rs.getString(3));
               // n.setPublicationDate(rs.getDate(4));
               // n.setPrice(rs.getBigDecimal(5));
               // n.setBestSeller(rs.getBoolean(6));
                names.add(n);
            }
            return names;
        }
    }

    public int insert(Names newName) throws Exception {

        // PreparedStatement
        StringBuilder sp = new StringBuilder();
        sp.append(" insert into names ( \n");
        sp.append("    id       \n");
        sp.append("   ,title     \n");
        sp.append("   ,author    \n");
       // sp.append("   ,publication_date \n");
       // sp.append("   ,price             \n");
       // sp.append("   ,amz_bestseller    \n");
        sp.append(" ) \n");
        sp.append(" values ( \n");
        sp.append("    ?        \n");
        sp.append("   ,?     \n");
        sp.append("   ,?    \n");
       // sp.append("   ,?  \n");
       // sp.append("   ,?             \n");
       // sp.append("   ,?    \n");
        sp.append(" ) \n");

        try (
            PreparedStatement stmt
                = conn.prepareStatement(sp.toString());
        ) {
            stmt.setInt(1, newName.getId());
            stmt.setString(2, newName.getFirst());
            stmt.setString(3, newName.getLast());
           // stmt.setDate(4,
           //     new Date(newName.getPublicationDate().getTime()));
           // stmt.setBigDecimal(5, newName.getPrice());
           // stmt.setBoolean(6, newBook.getBestSeller());

            int insertCount = stmt.executeUpdate();
            return insertCount;
        }        
    }

    public int updatePrice(Integer id, BigDecimal price) throws Exception {

        // PreparedStatement
        StringBuilder sp = new StringBuilder();
        sp.append(" update             \n");
        sp.append("   books            \n");
        sp.append(" set                \n");
        sp.append("   price = ?        \n");
        sp.append(" where              \n");
        sp.append("   id = ?           \n");
        sp.append(" \n");

        try (
            PreparedStatement stmt
                = conn.prepareStatement(sp.toString());
        ) {
            stmt.setBigDecimal(1, price);
            stmt.setInt(2, id);

            int updateCount = stmt.executeUpdate();
            return updateCount;
        }
    }

    public int delete(Integer id) throws Exception {

        // PreparedStatement
        StringBuilder sp = new StringBuilder();
        sp.append(" delete from        \n");
        sp.append("   names            \n");
        sp.append(" where              \n");
        sp.append("   id = ?           \n");
        sp.append(" \n");

        try (
            PreparedStatement stmt
                = conn.prepareStatement(sp.toString());
        ) {
            stmt.setInt(1, id);

            int deleteCount = stmt.executeUpdate();
            return deleteCount;
        }
    }
}
