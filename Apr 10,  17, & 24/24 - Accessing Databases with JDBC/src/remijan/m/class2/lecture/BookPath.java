package remijan.m.class2.lecture;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class BookPath {
    private Path path;
    private Boolean existedAtStartup;
    
    public BookPath() {
        path = Paths.get("./book_db");
        existedAtStartup = Files.exists(path);
    }
    
    public Path toAbsolutePath() {
        return path.toAbsolutePath();
    }
    
    public Boolean existedAtStartup() {
        return existedAtStartup;
    }
}
