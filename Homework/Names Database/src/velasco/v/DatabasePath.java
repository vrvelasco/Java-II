package velasco.v;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DatabasePath {
    private Path path;
    private Boolean existedAtStartup;
    
    public DatabasePath() {
        path = Paths.get("./NAMES_DB");
        existedAtStartup = Files.exists(path);
    }
    
    public Path toAbsolutePath() {
        return path.toAbsolutePath();
    }
    
    public Boolean existedAtStartup() {
        return existedAtStartup;
    }
}
