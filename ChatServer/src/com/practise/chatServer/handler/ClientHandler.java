/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.practise.chatServer.handler;

import com.practise.chatServer.dao.BlockDao;
import com.practise.chatServer.dao.UsersDao;
import com.practise.chatServer.dao.impl.BlockDaoImpl;
import com.practise.chatServer.dao.impl.UserDaoImpl;
import com.practise.chatServer.entity.BlockedUsersId;
import com.practise.chatServer.entity.Client;
import com.practise.chatServer.entity.User;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintStream;
import java.net.Socket;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author chira
 */
public class ClientHandler {

    UsersDao userDao;
    BlockDao blockDao = new BlockDaoImpl();
    private List<Client> clients = new ArrayList<>();

    public void addClient(Client c) {
        clients.add(c);
    }

    public Client getByUserName(String userName) {
        for (Client c : clients) {
            if (c.getUserName().equals(userName)) {
                return c;
            }
        }
        return null;
    }

    public Client getBySocket(Socket s) {
        for (Client c : clients) {
            if (c.getSocket().equals(s)) {
                return c;
            }
        }
        return null;
    }

    public List<Client> getClients() {
        return clients;
    }

    public void broadcastMessage(Client client, String msg) throws IOException {
        userDao = new UserDaoImpl();

        for (Client c : clients) {
            if (checkId(userDao.getId(client.getUserName()), client) == 0) {
                PrintStream output = new PrintStream(c.getSocket().getOutputStream());
                output.println(msg);
            }
        }
    }

    public int checkId(int id, Client client) {
        try {

            //blockDao = new BlockDaoImpl();
            for (BlockedUsersId bUID : blockDao.getAll(client.getUserName())) {
                if (id == bUID.getId()) {
                    return 1;
                }
            }

        } catch (ClassNotFoundException | SQLException e) {
        }
        return 0;
    }

    public void checkForCommand(Client client, String msg, String line, BufferedReader reader) throws IOException, ClassNotFoundException, SQLException {
        PrintStream output = new PrintStream(client.getSocket().getOutputStream());
        if (line.equalsIgnoreCase("block")) {

            output.println("Enter UserName to block");
            String toBlockUserName = reader.readLine();
            int result = blockDao.block(client.getUserName(), userDao.getId(toBlockUserName));
            if (result == 0) {
                output.println("Username not found to block");
            } else if (result == 1) {
                output.println(toBlockUserName + " blocked");
            };
        } else if (line.equalsIgnoreCase("unblock")) {

            output.println("Enter UserName to unblock");
            String toUnBlockUserName = reader.readLine();
            int result = blockDao.unblock(client.getUserName(), userDao.getId(toUnBlockUserName));
            if (result == 0) {
                output.println("Username not found to unblock");
            } else if (result == 1) {
                output.println(toUnBlockUserName +" unblocked");
            };
        } else if (line.equalsIgnoreCase("show blocked")) {

            for (BlockedUsersId bUid : blockDao.getAll(client.getUserName())) {
                for (User u : userDao.getAll()) {
                    if (bUid.getId() == u.getId()) {
                        output.println(u.getUserName());
                    }
                }
            }
        } else if (line.equalsIgnoreCase("help")) {
            output.println("Commands:- ");
            output.println("Block - to block ");
            output.println("Help - to Call help menu");
            output.println("Unblock - to unblock ");
            output.println("Show blocked - to display your blocked users ");
            output.println("Anything else to Send Messages to unblocked users");

        } else {

            broadcastMessage(client, client.getUserName() + " says >" + line);
        }
    }
}
