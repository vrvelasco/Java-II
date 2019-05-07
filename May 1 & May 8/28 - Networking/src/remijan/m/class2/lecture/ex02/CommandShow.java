package remijan.m.class2.lecture.ex02;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.Scanner;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class CommandShow implements Command {

    protected CommandSocket socket;
    protected Path file;

    public CommandShow(CommandSocket socket) {
        this.socket = socket;
    }

    public void setFile(String file) {
        this.file = (file != null) ? Paths.get(file) : null;
    }


    @Override
    public void handle() {
        try {
            if (file == null) {
                socket.sendEnd("ERROR: The [file] parameter is missing. Execute `help` for more information%n");
            }
            else
            if (!Files.exists(file)) {
                socket.sendEnd("ERROR: Path does not exist: \"%s\"\n", file.toAbsolutePath());
            }
            else
            if (Files.isDirectory(file)) {
                socket.sendEnd("ERROR: Path is not a file: \"%s\"\n", file.toRealPath());
            } else {
                socket.send("SHOW: \"%s\"\n", file.toRealPath());
                Scanner input = new Scanner(file);
                while (input.hasNext()) {
                    socket.send(input.nextLine()+"\n");
                }
                socket.sendEnd("");
                input.close();
            }
        } catch (Throwable e) {
            socket.sendEnd("ERROR: %s%n", e.getMessage());
        }
    }
}
