/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.chatServer.handler;

import com.practise.chatServer.dao.UsersDao;
import com.practise.chatServer.dao.impl.UserDaoImpl;
import com.practise.chatServer.entity.Client;
import com.practise.chatServer.entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author chira
 */
public class ClientListener extends Thread {

    private Socket socket;
    private ClientHandler handler;
    PrintStream pstream;
    BufferedReader reader;
    private Client client;

    private UsersDao userDAO = new UserDaoImpl();

    public ClientListener(Socket socket, ClientHandler handler) throws IOException {
        this.socket = socket;
        this.handler = handler;
        pstream = new PrintStream(socket.getOutputStream());
        reader = new BufferedReader(new InputStreamReader(socket.getInputStream()));
    }

    @Override
    public void run() {
        try {

            pstream.println("Welcome to The Chat Server-Chirag Awale");
            while (!doLogin()) {

                pstream.println("Invalid username/password");
            }

            doChat();

        } catch (IOException ioe) {

        }
    }

    private boolean doLogin() throws IOException {

        pstream.println("Enter your username:");
        String userName = reader.readLine();
        pstream.println("Enter your password:");
        String password = reader.readLine();
        User user = userDAO.login(userName, password);
        if (user != null) {
            client = new Client(socket, userName);
            handler.addClient(client);
            PrintStream output = new PrintStream(socket.getOutputStream());
            output.println("Welcome: " + userName);
            output.println("Type Help and Press Enter to Call Help menu");
            return true;
        }
        return false;

    }

    private void doChat() throws IOException {
        while (true) {
            pstream.print(">");
            String line = reader.readLine();

            try {
                handler.checkForCommand(client, client.getUserName() + " says >", line, reader);
            } catch (ClassNotFoundException | SQLException ex) {
                Logger.getLogger(ClientListener.class.getName()).log(Level.SEVERE, null, ex);

            }
        }
    }
}
