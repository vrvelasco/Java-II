package velasco.v;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.LinkedList;
import java.util.List;
import java.util.StringJoiner;

public class DatabaseHandler {
    
    private DatabasePath path;
    private Connection conn;

    public DatabaseHandler(DatabasePath path) throws Exception 
    {
        // Store the path
        this.path = path;
        
        // Connect to the database
        connect();
        
        // Initialize the database
        init();
    }

    protected void connect() throws Exception 
    {
        // Driver
        String driver
            = "org.apache.derby.jdbc.EmbeddedDriver";
        Class.forName(driver);

        // Connection
        String connectionUrl
            = String.format("jdbc:derby:%s;user=;password=;create=true", path.toAbsolutePath());

        conn = DriverManager.getConnection(connectionUrl);
    }

    protected void init() throws Exception 
    {
        if (!path.existedAtStartup())
        {
            StringJoiner sj
                = new StringJoiner(",", "create table people (", ")");
            sj.add(" id                bigint ");
            sj.add(" first_name             varchar(100) ");
            sj.add(" last_name            varchar(100) ");
            
            try (
                Statement stmt = conn.createStatement();
            ) {
                stmt.execute(sj.toString());
            }
        }
    }

    public List<Database> findPerson() throws Exception 
    {

        // PreparedStatement
        StringBuilder sp = new StringBuilder();
        sp.append(" select \n");
        sp.append("    id  \n");
        sp.append("   ,first_name   \n");
        sp.append("   ,last_name    \n");
        sp.append(" from \n");
        sp.append("   people \n");

        try (
            PreparedStatement stmt
                = conn.prepareStatement(sp.toString());

            ResultSet rs
                = stmt.executeQuery();
        ) {
            // Loop over results
            List<Database> dbPeople = new LinkedList<>();
            while (rs.next()) {
                Database p = new Database();
                p.setId(rs.getLong(1));
                p.setFirstName(rs.getString(2));
                p.setLastName(rs.getString(3));
                dbPeople.add(p);
            }
            return dbPeople;
        }
    }
    
    public long insert(Database newPerson) throws Exception 
    {
       if (newPerson.getId() != 0) 
       {
    	   // PreparedStatement
        StringBuilder sp = new StringBuilder();
        sp.append(" insert into people ( \n");
        sp.append("    id       \n");
        sp.append("   ,first_name     \n");
        sp.append("   ,last_name    \n");
        sp.append(" ) \n");
        sp.append(" values ( \n");
        sp.append("    ?        \n");
        sp.append("   ,?     \n");
        sp.append("   ,?    \n");
        sp.append(" ) \n");

        try ( PreparedStatement stmt = conn.prepareStatement(sp.toString()); ) 
        {
            stmt.setLong(1, newPerson.getId());
            stmt.setString(2, newPerson.getFirstName());
            stmt.setString(3, newPerson.getLastName());
            stmt.executeUpdate(); 
        }
       }
        return newPerson.getId();        
    }

    public int updateName(long id, String name) throws Exception 
    {
    	int updateCount = 0;
    	String[] newName = name.split(" "); // Get updated name
    	
        // PreparedStatement
        StringBuilder sp = new StringBuilder();
        sp.append(" update             \n");
        sp.append("   people            \n");
        sp.append(" set                \n");
        sp.append("    first_name = ?        \n");
        sp.append("    ,last_name = ?        \n");
        sp.append(" where              \n");
        sp.append("   id = ?           \n");
        sp.append(" \n");

        try (
            PreparedStatement stmt
                = conn.prepareStatement(sp.toString());
        ) {
            stmt.setString(1, newName[0]);
            
            if (newName.length == 2) {
            stmt.setString(2, newName.length == 2 ? newName[1] : ""); 
            } else {
            	stmt.setNull(2, java.sql.Types.VARCHAR);
            }
            
            stmt.setLong(3, id);
            
            updateCount = stmt.executeUpdate();
        }
        
        return updateCount;
    }

    public int delete(long id) throws Exception 
    {
        // PreparedStatement
        StringBuilder sp = new StringBuilder();
        sp.append(" delete from        \n");
        sp.append("   people            \n");
        sp.append(" where              \n");
        sp.append("   id = ?           \n");
        sp.append(" \n");

        try (
            PreparedStatement stmt
                = conn.prepareStatement(sp.toString());
        ) {
            stmt.setLong(1, id);
            
            return stmt.executeUpdate();
        }
    }
}
