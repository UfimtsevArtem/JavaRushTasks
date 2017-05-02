package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;
import java.net.Socket;

/**
 * Created by User on 21.04.2017.
 */
public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress(){
        ConsoleHelper.writeMessage ("Input server address ");
        return ConsoleHelper.readString ();
    }
    protected int getServerPort(){
        ConsoleHelper.writeMessage ("Input server port ");
        return ConsoleHelper.readInt ();
    }
    protected String getUserName(){
        ConsoleHelper.writeMessage("Input your name ");
        return ConsoleHelper.readString();
    }
    protected boolean shouldSendTextFromConsole(){
        return true;
    }
    protected SocketThread getSocketThread(){
        SocketThread socketThread = new SocketThread();
        return socketThread;
    }
    protected void sendTextMessage(String text){
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Message not a text");
            clientConnected = false;
        }
    }
    public void run()
    {
        SocketThread socketThread = getSocketThread ( );
        socketThread.setDaemon (true);
        socketThread.start ( );
        synchronized (this)
        {
            try
            {
                this.wait ( );
            }
            catch (InterruptedException e)
            {
                ConsoleHelper.writeMessage ("Connection was interrupted. " + e.getMessage ( ));
                System.exit (1);
            }
        }
        if (clientConnected)
        {
            ConsoleHelper.writeMessage ("Connection is true. To exit input command ‘exit’.");
        }
        else
        {
            ConsoleHelper.writeMessage ("Error on work time client.");
        }
        while (clientConnected)
        {
            String text = ConsoleHelper.readString ( );
            if (text.equals ("exit"))
            {
                return;
            }
            if (shouldSendTextFromConsole ( ))
            {
                sendTextMessage (text);
            }
        }
    }

    public static void main(String[] args) {
        Client client = new Client();
        client.run();
    }
    public class SocketThread extends Thread{
        protected void processIncomingMessage(String message)
        {
            ConsoleHelper.writeMessage (message);
        }

        protected void informAboutAddingNewUser(String userName)
        {
            ConsoleHelper.writeMessage (userName + " added to chat");
        }

        protected void informAboutDeletingNewUser(String userName)
        {
            ConsoleHelper.writeMessage (userName + " leave the chat");
        }
        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;
            synchronized (Client.this) {
                Client.this.notify();
            }
        }
        protected void clientHandshake() throws IOException, ClassNotFoundException{
            Message message;
            while (true) {
                message = connection.receive();
                if(message.getType() == MessageType.NAME_REQUEST){
                    connection.send(new Message(MessageType.USER_NAME, getUserName()));
                }
                else if(message.getType() == MessageType.NAME_ACCEPTED){
                    notifyConnectionStatusChanged(true);
                    return;
                }
                else {
                    throw new IOException("Unexpected MessageType");
                }
            }
        }
        protected void clientMainLoop() throws IOException, ClassNotFoundException{
            while (true) {
                Message message = connection.receive();
                if(message.getType() == MessageType.TEXT){
                    processIncomingMessage(message.getData());
                }else if(message.getType() == MessageType.USER_ADDED){
                    informAboutAddingNewUser(message.getData());
                }else if(message.getType() == MessageType.USER_REMOVED){
                    informAboutDeletingNewUser(message.getData());
                }else{
                    throw  new IOException("Unexpected MessageType");
                }
            }
        }
        public void run(){
            String address = getServerAddress();
            int port = getServerPort();
            try {
                Socket socket = new Socket(address, port);
                connection = new Connection(socket);
                clientHandshake();
                clientMainLoop();
            } catch (IOException | ClassNotFoundException e) {
                notifyConnectionStatusChanged(false);
            }
        }
    }
}

