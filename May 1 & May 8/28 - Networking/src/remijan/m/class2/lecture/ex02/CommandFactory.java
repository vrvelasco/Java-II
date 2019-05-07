package remijan.m.class2.lecture.ex02;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class CommandFactory {

    protected CommandSocket socket;

    public CommandFactory(CommandSocket socket) {
        this.socket = socket;
    }

    public Command getCommand() {
        CommandLine commandLine = socket.getCommandLine();

        switch (commandLine.getCommand())
        {
            case "help":
                return new CommandHelp(socket);

            case "exit":
                return new CommandExit(socket);

            case "dir":
                CommandDir dir = new CommandDir(socket);
                dir.setDirectory(
                    commandLine.getParameter().orElse(".")
                );
                return dir;

            case "show":
                CommandShow show = new CommandShow(socket);
                show.setFile(
                    commandLine.getParameter().orElse(null)
                );
                return show;

            default:
                CommandHelp help = new CommandHelp(socket);
                help.setUnknown(commandLine.getCommand());
                return help;
        }
    }
}
