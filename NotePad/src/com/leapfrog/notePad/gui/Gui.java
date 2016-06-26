/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.notePad.gui;

import com.leapfrog.notePad.process.Rw;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

/**
 *
 * @author chira
 */
public class Gui extends JFrame {

    Rw rw = new Rw();
    JMenuBar menu;
    JTextArea textArea;
    JMenu file, help, edit;
    JMenuItem newFile, openFile, save, saveAs, exit, about, clear;
    JScrollPane scroll;
    JPanel panel;
    JOptionPane optionPane;
    JFileChooser fileChooser;
    int choice = 0;
    String path = "";
    String content = "";

    public Gui() {
        prepareGui();
    }

    public void prepareGui() {

        menu = new JMenuBar();
        setJMenuBar(menu);
        file = new JMenu("File");
        help = new JMenu("Help");
        edit = new JMenu("Edit");

        newFile = new JMenuItem("New");
        openFile = new JMenuItem("Open File");
        save = new JMenuItem("Save");
        saveAs = new JMenuItem("Save As");
        exit = new JMenuItem("Exit");
        about = new JMenuItem("About");
        clear = new JMenuItem("Clear");
        file.add(newFile);
        file.add(openFile);
        file.add(clear);
        file.add(save);
        file.add(saveAs);
        file.add(exit);

        edit.add(clear);

        help.add(about);

        menu.add(file);
        menu.add(edit);
        menu.add(help);
        textArea = new JTextArea(20, 40);
        scroll = new JScrollPane(textArea);
        addListeners();
        addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        setTitle("NotePad");
        setSize(500, 500);
        setLayout(new FlowLayout(FlowLayout.LEADING));
        Container container = getContentPane();
        container.add(scroll);
        setVisible(true);
    }

    public void addListeners() {
        exit.addActionListener(new Exit());
        clear.addActionListener(new Clear());
        saveAs.addActionListener(new SaveAs());
        save.addActionListener(new Save());
        openFile.addActionListener(new OpenFile());
        newFile.addActionListener(new NewFile());
        clear.addActionListener(new Clear());
        about.addActionListener(new About());

    }

    public class Exit implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (textArea.getText().equals("")) {
                int option = JOptionPane.showConfirmDialog(null, "Do you really want to exit??", "Exit", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    System.exit(0);
                }
            } else {
                int option = JOptionPane.showConfirmDialog(null, "Do you save before exit??", "Exit", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    SaveAs sa = new SaveAs();
                    sa.actionPerformed(e);

                } else if (option == JOptionPane.NO_OPTION) {

                    System.exit(0);
                }
            }
        }

    }

    public class Clear implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText("");
        }

    }

    public class SaveAs implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fileChooser = new JFileChooser();
            choice = fileChooser.showSaveDialog(saveAs);
            if (choice == fileChooser.APPROVE_OPTION) {
                path = fileChooser.getSelectedFile().getPath();
                rw.writer(path, textArea.getText());

            }

        }

    }

    public class Save implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fileChooser = new JFileChooser();
            if (path.equals("")) {
                choice = fileChooser.showSaveDialog(save);
                if (choice == fileChooser.APPROVE_OPTION) {
                    path = fileChooser.getSelectedFile().getPath();
                    rw.writer(path, textArea.getText());

                }
            } else {
                ;
                rw.writer(path, textArea.getText());
            }
        }

    }

    public class OpenFile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            fileChooser = new JFileChooser();
            if (textArea.getText().equals("")) {
                choice = fileChooser.showOpenDialog(openFile);
                path = fileChooser.getSelectedFile().getPath();
                textArea.setText(rw.reader(path));
            } else if (!textArea.getText().equals("") && !path.equals("")) {
                Boolean chck = rw.Check(path, textArea.getText());
                if (chck == true) {
                    choice = fileChooser.showOpenDialog(openFile);
                    path = fileChooser.getSelectedFile().getPath();
                    textArea.setText(rw.reader(path));
                } else if (chck == false) {
                    int option = JOptionPane.showConfirmDialog(null, "Do you save before opening file ??", "Open File", JOptionPane.YES_NO_OPTION);
                    if (option == JOptionPane.YES_OPTION) {
                        SaveAs sa = new SaveAs();
                        sa.actionPerformed(e);
                        choice = fileChooser.showOpenDialog(openFile);
                        path = fileChooser.getSelectedFile().getPath();
                        textArea.setText(rw.reader(path));
                    } else {
                        choice = fileChooser.showOpenDialog(openFile);
                        path = fileChooser.getSelectedFile().getPath();
                        textArea.setText(rw.reader(path));
                    }
                }

            } else if (!textArea.getText().equals("") && path.equals("")) {
                int option = JOptionPane.showConfirmDialog(null, "Do you save before opening file ??", "Open File", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    SaveAs sa = new SaveAs();
                    sa.actionPerformed(e);
                    choice = fileChooser.showOpenDialog(openFile);
                        path = fileChooser.getSelectedFile().getPath();
                        textArea.setText(rw.reader(path));
                } else {
                    choice = fileChooser.showOpenDialog(openFile);
                    path = fileChooser.getSelectedFile().getPath();
                    textArea.setText(rw.reader(path));
                }

            }

        }
    }

    public class NewFile implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            if (!textArea.getText().equals("")) {

                int option = JOptionPane.showConfirmDialog(null, "Do you save before creatin new file ??", "New File", JOptionPane.YES_NO_OPTION);
                if (option == JOptionPane.YES_OPTION) {
                    SaveAs sa = new SaveAs();
                    sa.actionPerformed(e);
                    textArea.setText(null);
                    path = "";

                } else if (option == JOptionPane.NO_OPTION) {
                    textArea.setText(null);
                    path = "";
                }
            }

        }
    }

    public class About implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            JOptionPane.showMessageDialog(null, "Credits To:" + "\t\n" + "Chirag Awale");
        }
    }

}
