package remijan.m.class2.lecture.ex02;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class CommandExit implements Command {

    protected CommandSocket socket;

    public CommandExit(CommandSocket socket) {
        this.socket = socket;
    }

    @Override
    public void handle() {
        socket.sendEnd("Good bye!%n");
        socket.close();
    }
}