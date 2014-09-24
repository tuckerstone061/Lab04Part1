/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chatsystem;

/**
 *
 * @author sstoneman1
 */
public class ChatSystem {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args)
    {
        ChatView theView = new ChatView();
        ChatModel theModel = new ChatModel();
        ChatController theControl = new ChatController(theView, theModel);
    }
    
}


	