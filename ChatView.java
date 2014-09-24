
package chatsystem;

import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.*;

public class ChatView  {

private final JButton sendButton;
private final JButton exitButton;
private final JTextField sendText;
private final JTextArea displayArea;
private final JFrame frame;
        
    public ChatView() {
        
        frame = new JFrame("Demo");
        
        /** anonymous inner class to handle window closing events */
        frame.addWindowListener(new WindowAdapter() {
                @Override
                public void windowClosing(WindowEvent evt) {
                        System.exit(0);
                }
        } );

            /**
             * a panel used for placing components
             */
            JPanel p = new JPanel();

        Border etched = BorderFactory.createEtchedBorder();
        Border titled = BorderFactory.createTitledBorder(etched, "Enter Your Message Here ...");
        p.setBorder(titled);

        /**
         * set up all the components
         */
        sendText = new JTextField(30);
        sendButton = new JButton("Send");
        exitButton = new JButton("Exit");

        /**
         * register the listeners for the different button clicks
         */

        /**
         * add the components to the panel
         */
        p.add(sendText);
        p.add(sendButton);
        p.add(exitButton);

        /**
         * add the panel to the "south" end of the container
         */
        frame.getContentPane().add(p,"South");

        /**
         * add the text area for displaying output. Associate
         * a scrollbar with this text area. Note we add the scrollpane
         * to the container, not the text area
         */
        displayArea = new JTextArea(15,40);
        displayArea.setEditable(false);
        displayArea.setFont(new Font("SansSerif", Font.PLAIN, 16));

        JScrollPane scrollPane = new JScrollPane(displayArea);
        frame.getContentPane().add(scrollPane,"Center");

        /**
         * set the title and size of the frame
         */
        frame.pack();

        frame.setVisible(true);
		sendText.requestFocus();
	}
    public void displayText() {
            String message = sendText.getText().trim();
            StringBuilder buffer = new StringBuilder(message.length());

            // now reverse it
            for (int i = 0; i < message.length(); i++)
                buffer.append(message.charAt(i));

            displayArea.append(buffer.toString() + "\n");

            sendText.setText("");
            sendText.requestFocus();
        }
 
    
    public void addSendListener(ActionListener sendlisten)
    {
        this.sendButton.addActionListener(sendlisten);
    }
    public void addExitListener(ActionListener exitlisten)
    {
        this.exitButton.addActionListener(exitlisten);
    }
}