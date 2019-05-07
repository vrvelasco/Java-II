package remijan.m.class2.lecture.ex02;

import java.nio.file.DirectoryStream;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.text.DecimalFormat;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class CommandDir implements Command {

    protected CommandSocket socket;
    protected DecimalFormat formatter;
    protected Path directory;

    public CommandDir(CommandSocket socket) {
        this.socket = socket;
        this.formatter = new DecimalFormat("#,###");
    }

    @Override
    public void handle() {
        try {
            if (!Files.exists(directory)) {
                socket.sendEnd("ERROR: Path does not exist: \"%s\"\n", directory.toAbsolutePath());
            }
            else
            if (!Files.isDirectory(directory)) {
                socket.sendEnd("ERROR: Path is not a directory: \"%s\"\n", directory.toRealPath());
            }
            else {
                socket.send("Directory of \"%s\"%n", directory.toRealPath().toString());

                DirectoryStream<Path> stream
                    = Files.newDirectoryStream(directory, (entry) -> !entry.toFile().isHidden());

                for (Path path : stream) {
                    // d 100000000b hello.txt
                    socket.send("%s %20s %s%n"
                        , Files.isDirectory(path) ? "d" : " "
                        , Files.isDirectory(path) ? "" : formatter.format(Files.size(path))
                        , path.getFileName().toString()
                    );
                }
                socket.sendEnd("");
            }
        } catch (Throwable e) {
            socket.sendEnd("ERROR: %s%n", e.getMessage());
        }
    }

    void setDirectory(String directory) {
        this.directory = Paths.get(directory);
    }
}
