package ui;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import java.util.EventListener;
import java.awt.Color;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.plaf.DimensionUIResource;

public class UI extends UIWindows {
    public JFrame window;
    public Container content = new Container();
    public JPanel titleNamePanel, buttonPanel;
    public JLabel titleNameLabel;
    public JLabel errormessage;
    public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    public Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
    public Font textboxFont = new Font("Times New Roman", Font.PLAIN, 30);
    public Font errormessageFont = new Font("Times New Roman", Font.PLAIN, 10);

    public String[] playerNames = { "Spieler 1", "Spieler 2", "Spieler 3", "Spieler 4", "Spieler 5", "Spieler 6" };
    public final String[] placeholders = { "Spieler 1", "Spieler 2", "Spieler 3", "Spieler 4", "Spieler 5", "Spieler 6" };

    public UI() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setAlwaysOnTop(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setResizable(false);
        content = window.getContentPane();
        menu();
    }

    public void menu() {
        if (content.getComponentCount() > 0)
            content.removeAll();

        // ------------------- TITLE -----------------------
        titleNamePanel = new JPanel();
        titleNamePanel.setBounds(100,50,600,110);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("SMA Planspiel");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        titleNamePanel.add(titleNameLabel);
        content.add(titleNamePanel);


        // ------------------- Buttons -----------------------

        buttonPanel = new JPanel();
        buttonPanel.setBounds(300,270,200,300);
        buttonPanel.setBackground(Color.black);
        
        JButton[] buttons = new JButton[4];
        buttons[0] = createButton(BUTTON.STARTGAME);
        buttons[1] = createButton(BUTTON.SETTINGS);
        buttons[2] = createButton(BUTTON.ABOUTUS);
        buttons[3] = createButton(BUTTON.EXIT);
                
        for (JButton button : buttons) {
            buttonPanel.add(button);
        }
        content.add(buttonPanel);
        
        window.setVisible(true);
    }

    private void clear_ui() {
        titleNamePanel.removeAll();
        buttonPanel.removeAll();
        content.removeAll();
    }
    
    public void ui_choosePlayers() {
        
        clear_ui();

        // ------------------- TITLE --------------------------------------------------------------------------------------------
        titleNamePanel.setBounds(100,50,600,110);
        titleNamePanel.setBackground(Color.black);
        titleNameLabel = new JLabel("Spielerwahl");
        titleNameLabel.setForeground(Color.white);
        titleNameLabel.setFont(titleFont);
        
        titleNamePanel.add(titleNameLabel);
        content.add(titleNamePanel);

        
        
        // ------------------- Textfelder --------------------------------------------------------------------------------------------

        buttonPanel = new JPanel();

        buttonPanel.setBounds(100,220,600,150);
        buttonPanel.setBackground(Color.black);

        
        for (String playerName : playerNames) {
            JTextField textField = new JTextField(playerName);
            
            textField.setPreferredSize(new Dimension(225, 40));
            textField.setHorizontalAlignment(JTextField.CENTER);
            textField.setFont(textboxFont);

            textField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (textField.getText().equals(playerName))
                        textField.setText("");                     
                }

                @Override
                public void focusLost(FocusEvent e) {
                    if (textField.getText().equals(""))
                        textField.setText(playerName);   
                }
            });

            textField.setBackground(Color.black);
            textField.setForeground(Color.white);
            buttonPanel.add(textField);
        }
        content.add(buttonPanel);

        // ------------------- Spielen-Knopf --------------------------------------------------------------------------------------------

        JPanel continuePanel = new JPanel();
        continuePanel.setBounds(300,380,200,110);
        continuePanel.setBackground(Color.black);

        continuePanel.add(createButton(BUTTON.CONTINUE_TO_GAME));
        content.add(continuePanel);

        // ------------------- Errormessage --------------------------------------------------------------------------------------------

        errormessage = new JLabel();
        errormessage.setBounds(370, 500, 100, 50);
        errormessage.setVisible(false);
        errormessage.setFont(errormessageFont);
        errormessage.setBackground(Color.white);
        errormessage.setForeground(Color.red);
        errormessage.setText("FEHLERMELDUNG");
        content.add(errormessage);

        
        window.repaint();
        window.setVisible(true);

    }

    public void ui_game() {

    }

    public void ui_settings() {

    }

    public void ui_aboutus() {

    }
    
    private JButton createButton(BUTTON buttonType) {
        JButton button = new JButton(buttonType.getName());
        button.setBackground(Color.black);
        button.setForeground(Color.white);
        button.setFont(buttonFont);

        button.setFocusPainted(false);
        switch (buttonType) {
            case STARTGAME:
                button.addActionListener(e -> ui_choosePlayers());
                break;
            case SETTINGS:
                button.addActionListener(e -> ui_settings());
                break;
            case ABOUTUS:
                button.addActionListener(e -> ui_aboutus());
                break;
            case EXIT:
                //window.dispatchEvent(new WindowEvent(window, WindowEvent.WINDOW_CLOSING));
                break;
            case ANSWER:
                break;
            case CONTINUE_TO_GAME:
                button.setPreferredSize(new DimensionUIResource(200, 100));
                button.addActionListener(e -> {
                    if (playerNamesValid()) 
                        errormessage.setVisible(true);
                    else
                        errormessage.setVisible(true);
                });
                break;
            case SCENARIO_DARKNET:
                break;
            case SCENARIO_SUPPLIER:
                break;
            default:
                break;
        }
        return button;
    }

    private boolean playerNamesValid() {
        for (String playerName : playerNames) 
            if(playerName.length() < 1)
                return false;
        
        return true;
    }
}