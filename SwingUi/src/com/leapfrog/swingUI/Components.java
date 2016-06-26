/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.leapfrog.swingUI;

import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.ScrollPaneConstants;

/**
 *
 * @author chira
 */
public class Components {

    private JFrame frame;
    private JTextArea display;
    private JPanel controlPanel;

    public Components() {
        prepareGUI();
    }

    public static void main(String[] args) {
        Components components = new Components();
        components.show();
    }

    private void prepareGUI() {

        frame = new JFrame("My First App");
        frame.setSize(500, 500);

        frame.setLayout(new FlowLayout());

        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent windowEvent) {
                System.exit(0);
            }
        });
        controlPanel = new JPanel();
        controlPanel.setLayout(new FlowLayout());
        frame.add(controlPanel);
        frame.setVisible(true);

    }

    public void show() {

         display = new JTextArea(15, 15);
        JScrollPane scroll = new JScrollPane(display);
        
        JButton okayButton = new JButton("Print");
        JButton exitButton = new JButton("Exit");

        okayButton.setActionCommand("Ok");
        exitButton.setActionCommand("Exit");

        
        okayButton.addActionListener(new ButtonClickListener());
        exitButton.addActionListener(new ButtonClickListener());

        controlPanel.add(scroll);
        

        controlPanel.add(okayButton);
        controlPanel.add(exitButton);
        frame.setVisible(true);

    }

    private class ButtonClickListener implements ActionListener {

        public void actionPerformed(ActionEvent e) {
            String command = e.getActionCommand();
            if (command.equals("Ok")) {
                System.out.println(display.getText());
            } else if (command.equals("Exit")) {
                System.out.println("Exit Button Clicked");
                System.exit(0);
            }

        }

    }

}
