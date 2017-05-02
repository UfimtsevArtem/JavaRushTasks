package com.javarush.task.task30.task3008;

import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * Created by User on 20.04.2017.
 */
public class Server {
    private static Map<String, Connection> connectionMap = new ConcurrentHashMap<>();

    public static void sendBroadcastMessage(Message message) {
        for (Map.Entry<String, Connection> entry : connectionMap.entrySet()) {
            Connection connection = entry.getValue();
            String name = entry.getKey();
            try {
                connection.send(message);
            } catch (IOException e) {
                ConsoleHelper.writeMessage("Error send message to " + connection.toString());
            }
        }
    }

    private static class Handler extends Thread {
        private Socket socket;

        public Handler(Socket socket) {
            this.socket = socket;
        }

        private String serverHandshake(Connection connection) throws IOException, ClassNotFoundException {
            String userName = null;
            Message receive = null;
            boolean isNewName = false;
            while (true) {
                connection.send(new Message(MessageType.NAME_REQUEST));
                receive = connection.receive();
                if (receive.getType() != MessageType.USER_NAME)
                    continue;
                if (receive.getData().isEmpty())
                    continue;
                userName = receive.getData();
                if (connectionMap.containsKey(userName))
                    continue;
                connectionMap.put(userName, connection);
                connection.send(new Message(MessageType.NAME_ACCEPTED));
                break;
            }
            return userName;
        }

        private void sendListOfUsers(Connection connection, String userName) throws IOException {
            for (Map.Entry<String, Connection> pair : connectionMap.entrySet()) {
                String name = pair.getKey();
                Connection connectionFromMap = pair.getValue();
                if (name.equals(userName))
                    continue;
                connection.send(new Message(MessageType.USER_ADDED, name));

            }
        }

        private void serverMainLoop(Connection connection, String userName) throws IOException, ClassNotFoundException {
            while (true) {
                Message receive = connection.receive();
                if (receive.getType() == MessageType.TEXT) {
                    receive = new Message(MessageType.TEXT, userName + ": " + receive.getData());
                    sendBroadcastMessage(receive);

                } else {
                    ConsoleHelper.writeMessage("Сообщение не является текстом.");
                }
            }
        }

        public void run() {
            ConsoleHelper.writeMessage("Established new connection with remote address " + socket.getRemoteSocketAddress());
            String newClientName = null;
            try {
                Connection connection = new Connection(socket);
                newClientName = serverHandshake(connection);
                sendBroadcastMessage(new Message(MessageType.USER_ADDED, newClientName));
                sendListOfUsers(connection, newClientName);
                serverMainLoop(connection, newClientName);
            } catch (IOException | ClassNotFoundException e) {
                ConsoleHelper.writeMessage("An error occurred while communicating with the remote address");
            } finally {
                if (newClientName != null) {
                    connectionMap.remove(newClientName);
                    sendBroadcastMessage(new Message(MessageType.USER_REMOVED, newClientName));
                    ConsoleHelper.writeMessage(String.format("Connection with remote address (%s) is closed.", socket.getRemoteSocketAddress()));
                }
            }

        }
    }
        public static void main(String[] args) {
            int port = ConsoleHelper.readInt();
            ServerSocket serverSocket = null;
            try {
                serverSocket = new ServerSocket(port);
                ConsoleHelper.writeMessage("Сервер создан.");
                while (true) {
                    Socket socket = serverSocket.accept();
                    new Handler(socket).start();
                }
            } catch (IOException e) {
                ConsoleHelper.writeMessage(e.getMessage());
            } finally {
                try {
                    if (serverSocket != null) {
                        serverSocket.close();
                    }
                } catch (IOException e) {
                    ConsoleHelper.writeMessage(e.getMessage());
                }
            }
        }
    }

