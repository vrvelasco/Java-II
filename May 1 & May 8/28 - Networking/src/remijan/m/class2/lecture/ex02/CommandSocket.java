package remijan.m.class2.lecture.ex02;

import java.net.Socket;
import java.net.SocketAddress;
import java.util.Formatter;
import java.util.Scanner;

/**
 *
 * @author Michael Remijan mjremijan@yahoo.com @mjremijan
 */
public class CommandSocket {

    protected Socket socket;
    protected Scanner fromClient;
    protected Formatter toClient;

    public CommandSocket(Socket socket) {
        try {
            this.socket = socket;
            this.fromClient = new Scanner(socket.getInputStream());
            this.toClient = new Formatter(socket.getOutputStream());
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }

    public CommandLine getCommandLine() {
        return new CommandLine(fromClient.nextLine());
    }

    public void send(String format, Object ... args) {
        toClient.format(format,args);
        toClient.flush();
    }

    public void sendEnd(String format, Object ... args) {
        send(format,args);
        toClient.format("-end-%n");
        toClient.flush();
    }

    public SocketAddress getRemoteSocketAddress() {
        return socket.getRemoteSocketAddress();
    }

    public void close() {
        try {
            socket.close();
        } catch (Exception ignore) {}
    }
}
