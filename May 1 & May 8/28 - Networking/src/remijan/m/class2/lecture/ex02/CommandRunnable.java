package remijan.m.class2.lecture.ex02;

import java.net.Socket;

public class CommandRunnable implements Runnable {

    private CommandSocket socket;

    public CommandRunnable(Socket socket) {
        this.socket = new CommandSocket(socket);
    }

    @Override
    public void run() {

        System.out.printf("SERVER: %s: %s: Handling client%n",
             Thread.currentThread().getName(), socket.getRemoteSocketAddress());

        CommandFactory factory
            = new CommandFactory(socket);

        while (true) {
            factory.getCommand().handle();
        }
    }
}
