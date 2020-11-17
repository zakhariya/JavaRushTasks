package com.javarush.task.task30.task3008.client;

import com.javarush.task.task30.task3008.Connection;
import com.javarush.task.task30.task3008.ConsoleHelper;
import com.javarush.task.task30.task3008.Message;
import com.javarush.task.task30.task3008.MessageType;

import java.io.IOException;

public class Client {
    protected Connection connection;
    private volatile boolean clientConnected = false;

    protected String getServerAddress() {
        ConsoleHelper.writeMessage("Введите адрес сервера");
        return ConsoleHelper.readString();
    }

    protected int getServerPort() {
        ConsoleHelper.writeMessage("Введите порт");
        return ConsoleHelper.readInt();
    }

    protected String getUserName() {
        ConsoleHelper.writeMessage("Введите свое имя");
        return ConsoleHelper.readString();
    }

    protected boolean shouldSendTextFromConsole() {
        return true;
    }

    protected SocketThread getSocketThread() {
        return new SocketThread();
    }

    protected void sendTextMessage(String text) {
        try {
            connection.send(new Message(MessageType.TEXT, text));
        } catch (IOException e) {
            ConsoleHelper.writeMessage("Ошибка " + e.getMessage());
            clientConnected = false;
        }
    }

    public void run() {
        SocketThread socketThread = getSocketThread();
        socketThread.setDaemon(true);
        socketThread.start();

        try {
            synchronized (this) {
                wait();
            }
        } catch (InterruptedException e) {
            ConsoleHelper.writeMessage("Произошла ошибка");
            return;
        }

        String message = clientConnected ? "Соединение установлено. Для выхода наберите команду 'exit'."
                : "Произошла ошибка во время работы клиента.";

        ConsoleHelper.writeMessage(message);

        while (clientConnected) {
            String s = ConsoleHelper.readString();

            if (s.equalsIgnoreCase("exit")) {
                break;
            }

            if (shouldSendTextFromConsole()) {
                sendTextMessage(s);
            }
        }
    }

    public static void main(String[] args) {
        new Client().run();
    }


    public class SocketThread extends Thread {

        protected void processIncomingMessage(String message) {
            ConsoleHelper.writeMessage(message);
        }

        protected void informAboutAddingNewUser(String userName) {
            ConsoleHelper.writeMessage("Учасник \"" + userName + "\" присоединился к чату.");
        }

        protected void informAboutDeletingNewUser(String userName) {
            ConsoleHelper.writeMessage("Учасник \"" + userName + "\" покинул чат.");
        }

        protected void notifyConnectionStatusChanged(boolean clientConnected) {
            Client.this.clientConnected = clientConnected;

            synchronized (Client.this) {
                Client.this.notify();
            }
        }

        @Override
        public void run() {

        }
    }
}
