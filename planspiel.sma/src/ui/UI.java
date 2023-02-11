package ui;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.event.WindowEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.FocusEvent;
import java.awt.Component;
import java.awt.event.FocusListener;
import java.awt.GridLayout;
import java.util.EventListener;
import java.util.List;
import java.awt.Color;

import javax.sql.rowset.spi.SyncResolver;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.plaf.DimensionUIResource;

import domain.Rolle;
import facade.gamecontroller;

public class UI {
    public JFrame window;
    public Container content = new Container();
    public JPanel titleNamePanel = new JPanel(); 
    public JPanel buttonPanel = new JPanel();
    public JLabel titleNameLabel;
    public JLabel errormessage;
    public Font titleFont = new Font("Times New Roman", Font.PLAIN, 90);
    public Font buttonFont = new Font("Times New Roman", Font.PLAIN, 30);
    public Font textboxFont = new Font("Times New Roman", Font.PLAIN, 20);
    public Font errormessageFont = new Font("Times New Roman", Font.PLAIN, 10);
    public Font lblFont = new Font("Times New Roman", Font.PLAIN, 20);
    private int currentColorValue = 255;

    private Timer timer;
    String[] playerNames = { "Spieler 1", "Spieler 2", "Spieler 3", "Spieler 4", "Spieler 5", "Spieler 6" };
    final String[] placeholders = { "Spieler 1", "Spieler 2", "Spieler 3", "Spieler 4", "Spieler 5", "Spieler 6" };
    final String[] scenarios = {"Daten wurden im Darknet veröffentlicht!",
    "Einer deiner Zulieferer wurde gehackt!",
    "Es wurden 30 Bitcoins entwendet!",
    "Gehackte Windkraftanlagen!",
    "Ein Mitarbeiter verliert einen vertaulichen USB-Stick"
    };
   

    private gamecontroller game = new gamecontroller();

    public UI() {
        window = new JFrame();
        window.setSize(800, 600);
        window.setAlwaysOnTop(true);
        window.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        window.getContentPane().setBackground(Color.black);
        window.setLayout(null);
        window.setResizable(false);
        content = window.getContentPane();

        game.createRoles();


        menu();
   
    }

    public void menu() {
        clear_ui();


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
    
    public void ui_setup() {
        
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

        buttonPanel.setBounds(100,220,600,175);
        buttonPanel.setBackground(Color.black);
        buttonPanel.setLayout(new GridLayout(0,2));

        List<Rolle> rollen = game.getRoles();
        rollen.forEach(role -> {
            JLabel lbl = new JLabel();
            lbl.setBackground(Color.black);
            lbl.setForeground(Color.white);
            lbl.setFont(lblFont);
            lbl.setText(role.getName());
            /*EmptyBorder border = new EmptyBorder(8,0,0,0);
            comboBox.setBorder(border);
            textField.setBorder(border);*/
            buttonPanel.add(lbl);
        
            JTextField textField = new JTextField("Dein Name");
            textField.setPreferredSize(new Dimension(50, 30));
            textField.setHorizontalAlignment(JTextField.CENTER);
            textField.setFont(textboxFont);
            textField.addFocusListener(new FocusListener() {
                @Override
                public void focusGained(FocusEvent e) {
                    if (textField.getText().equals("Dein Name"))
                        textField.setText("");                     
                }
    
                @Override
                public void focusLost(FocusEvent e) {
                    if (textField.getText().equals(""))
                        textField.setText("Dein Name");   
                }
            });
            textField.setBackground(Color.black);
            textField.setForeground(Color.white);
            textField.setPreferredSize(new Dimension(100, 50));
            buttonPanel.add(textField);
        });
        content.add(buttonPanel);

        // ------------------- Szenario-Auswahl --------------------------------------------------------------------------------------------

        JPanel scenarioPanel = new JPanel();
        scenarioPanel.setBounds(100,425,350,50);
        scenarioPanel.setBackground(Color.black);
        scenarioPanel.setLayout(new GridLayout(2,0));
        JLabel scenarioLabel = new JLabel();
        scenarioLabel.setFont(lblFont);
        scenarioLabel.setBackground(Color.black);
        scenarioLabel.setForeground(Color.white);
        scenarioLabel.setText("Wähle dein gewünschtes Szenario aus:");
        scenarioPanel.add(scenarioLabel);


        
        JComboBox scenarioComboBox = new JComboBox(scenarios);
        scenarioComboBox.setBackground(Color.black);
        scenarioComboBox.setForeground(Color.white);
        scenarioPanel.add(scenarioComboBox);
        content.add(scenarioPanel);

        // ------------------- Spielen-Knopf --------------------------------------------------------------------------------------------

        JPanel continuePanel = new JPanel();
        continuePanel.setBounds(500,420,200,110);
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
        darken();
        //clear_ui();

        //window.repaint();
        //window.setVisible(true);
    }

    private void darken() {
        timer = new Timer(250, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                currentColorValue -= 25;
                System.out.println(currentColorValue);
                if (currentColorValue < 0)
                    currentColorValue = 0;
                    changeAllComponents(content);
                    window.repaint();
                }
        });
        timer.start();
    }

    private void changeAllComponents(Component comp) {
        comp.setForeground(new Color(currentColorValue, currentColorValue, currentColorValue));   
        //((JComponent) comp).setBorder(new LineBorder(new Color(currentColorValue, currentColorValue, currentColorValue)));
        
        if (comp instanceof Container) {
            for (Component child : ((Container) comp).getComponents()) {
                changeAllComponents(child);
            }
        }
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
                button.addActionListener(e -> ui_setup());
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
                        ui_game();
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