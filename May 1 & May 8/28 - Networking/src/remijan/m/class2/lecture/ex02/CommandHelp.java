package remijan.m.class2.lecture.ex02;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class CommandHelp implements Command {

    protected CommandSocket socket;
    protected String message;
    protected String unknown;

    public void setUnknown(String unknown) {
        this.unknown = unknown;
    }

    public CommandHelp(CommandSocket socket) {
        this.socket = socket;
        StringBuilder sp = new StringBuilder();
        sp.append("COMMANDS:\n");
        sp.append("  help         Show list of commands\n");
        sp.append("  dir  [path]  List contents of directory\n");
        sp.append("  show file    Show contents of file\n");
        sp.append("  exit         Exit the shell\n");
        sp.append("\n");
        message = sp.toString();
    }

    @Override
    public void handle() {
        if (unknown != null) {
            socket.send("Unknown command \"%s\"%n", unknown);
            unknown = null;
        }
        socket.sendEnd(message);
    }

}
