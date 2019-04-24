package remijan.m.class2.lecture;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class DataPath {
    private Path path;
    private Boolean existedAtStartup;
    
    public DataPath() {
        path = Paths.get("./names");
        existedAtStartup = Files.exists(path);
    }
    
    public Path toAbsolutePath() {
        return path.toAbsolutePath();
    }
    
    public Boolean existedAtStartup() {
        return existedAtStartup;
    }
}
