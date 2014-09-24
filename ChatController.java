/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsystem;

import java.awt.event.ActionListener;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

/**
 *
 * @author sstoneman1
 */
public class ChatController{

    private ChatView view;
    private ChatModel model;

    public ChatController(ChatView window, ChatModel mod) 
    {
        this.view = window;
        this.model = mod;
        
        this.view.addSendListener(new SubListener());
        this.view.addExitListener(new ExitListener());
    }
       
    class SubListener implements ActionListener {
        public void actionPerformed(ActionEvent evt)
        {
            view.displayText();
        }
    }
    
    class ExitListener implements ActionListener {
        public void actionPerformed(ActionEvent evt)
        {
            System.exit(0);
        }
    }
}

