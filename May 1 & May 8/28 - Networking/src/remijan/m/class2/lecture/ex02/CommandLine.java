package remijan.m.class2.lecture.ex02;

import java.util.Optional;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class CommandLine {
    protected String command;
    protected Optional<String> parameter;

    public CommandLine(String s) {
        s = s.trim();
        int idx = s.indexOf(" ");
        if (idx == -1) {
            command = s;
            parameter = Optional.empty();
        } else {
            command = s.substring(0, idx);
            parameter = Optional.of(s.substring(idx + 1).trim());
        }
    }

    public String getCommand() {
        return command;
    }

    public Optional<String> getParameter() {
        return parameter;
    }
}
