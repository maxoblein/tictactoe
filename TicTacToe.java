import java.util.*;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
public class TicTacToe implements ActionListener{
    
    Random random = new Random();
    JFrame frame = new JFrame();
    JPanel title_panel = new JPanel();
    JPanel buttonPanel = new JPanel();
    JLabel textfield = new JLabel();
    JButton[] buttons = new JButton[9];
    boolean player1Turn;

    TicTacToe(){


        //set up the frame 
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(800,800);
        frame.getContentPane().setBackground(new Color(50,50,50));
        frame.setLayout(new BorderLayout());
        frame.setVisible(true);

        //create and setup textfield for top of game
        textfield.setBackground(new Color(25,25,25));
        textfield.setForeground(new Color(25,255,0));
        textfield.setFont(new Font("Arial", Font.BOLD,75));
        textfield.setHorizontalAlignment(JLabel.CENTER);
        textfield.setText("Tic-Tac-Toe");
        textfield.setOpaque(true);

        //setup title panel to add textfield to
        title_panel.setLayout(new BorderLayout());
        title_panel.setBounds(0,0,800,100);

        //setup button panel to add our buttons to
        buttonPanel.setLayout(new GridLayout(3,3));
        buttonPanel.setBackground(new Color(150,150,150));

        //setup the buttons
        for (int i = 0; i < buttons.length; i++) {
            buttons[i] = new JButton();
            buttonPanel.add(buttons[i]);
            buttons[i].setFont(new Font("MV Boli",Font.BOLD,120));
            buttons[i].setFocusable(false);
            buttons[i].addActionListener(this);
            
        }


        //add everything to the frame
        title_panel.add(textfield);
        frame.add(title_panel,BorderLayout.NORTH);
        frame.add(buttonPanel);

        FirstTurn();

    }

    @Override
    public void actionPerformed(ActionEvent e) {
        
        for (int i = 0; i < buttons.length; i++) {
            //check which button is pressed
            if(e.getSource()==buttons[i]){
                //check whos turn
                if(player1Turn){
                    //check button hasnt already been assigned
                    if (buttons[i].getText()==""){
                        //assign button to player x
                        buttons[i].setForeground(new Color(255,0,0));
                        buttons[i].setText("X");
                        player1Turn = false;
                        textfield.setText("O's turn");
                        check();;
                    }
                }
                else{
                    if (buttons[i].getText()==""){
                        //assign button to player y
                        buttons[i].setForeground(new Color(0,0,255));
                        buttons[i].setText("O");
                        player1Turn = true;
                        textfield.setText("X's turn");
                        check();
                    }
                }

            }


        }
        
    }

    public void FirstTurn(){
        try {
            Thread.sleep(2000);
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        //setup a ranom number to determine who starts
        if (random.nextInt(2) ==0){
            player1Turn = true;
            textfield.setText("X's Turn");
        }
        else{
            player1Turn = false;
            textfield.setText("O's Turn");
        }

    }

    public void check(){
        //check x win conditions

        //check o win conditions
    }

    public void xWins(int a, int b, int c){

    }

    public void oWins(int a, int b, int c){

    }


    

}
