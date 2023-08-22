import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.net.URL;
import java.util.Arrays;
import java.util.Scanner;
import java.math.*;

public class Main extends JFrame implements ActionListener {
    static double total;
    static File file;
    public URL url = getClass().getResource("telusIcon.jpg");

    public BigDecimal totalRound;

    static boolean [] client = new boolean[4];

    ImageIcon telus;

    JLabel label,telusLabel,current;

    JButton [] buttons = new JButton[4];
    JButton clear;

    static public void createFile() {
        boolean b = true;
        try{
            file = new File(System.getProperty("user.home") + File.separator +"/Desktop/telus.txt");
            PrintWriter writer = new PrintWriter(file);
            writer.print("");
            writer.close();
        }
        catch(Exception e){
            b = false;
        }

        if(!b)
            file = new File(System.getProperty("user.home") + File.separator +"OneDrive/Desktop/telus.txt");
    }

    public static void loadData() throws IOException{

        if(file.length() != 0) {
            Scanner scanner = new Scanner(file);
            String s;
            String [] [] array = new String[5][2];

            for(int i = 0; i < 5; i++){
                s = scanner.nextLine();
                array[i] = s.split("#");
            }

            for(int i = 0; i < array[0].length; i++)
                Tasks.number[i] = Integer.parseInt(array[0][i]);

            for(int i = 0; i < array[1].length; i++)
                Search.number[i] = Integer.parseInt(array[1][i]);

            for(int i = 0; i < array[2].length; i++)
                Auto.number[i] = Integer.parseInt(array[2][i]);

            for(int i = 0; i < array[3].length; i++)
                Address.number[i] = Integer.parseInt(array[3][i]);


            for(int i = 0; i < array[4].length; i++)
                client[i] = Boolean.parseBoolean(array[4][i]);

            total = Double.parseDouble(scanner.nextLine());
        }

        else{
            JOptionPane.showMessageDialog(null,"Update 1.1:\n- All tasks are included.\n- Different menus\n- Added colors" );
            Arrays.fill(client, false);
        }

    }

    public static void saveData() throws IOException{
        PrintWriter writer = new PrintWriter(file);

        for (int j : Tasks.number) {
            writer.print(j + "#");
        }
        writer.println();
        for (int j : Search.number) {
            writer.print(j + "#");
        }
        writer.println();
        for (int j : Auto.number) {
            writer.print(j + "#");
        }
        writer.println();
        for (int j : Address.number) {
            writer.print(j + "#");
        }
        writer.println();
        for (boolean b : client) {
            writer.print(b + "#");
        }

        writer.println();
        writer.print(total);
        writer.close();

    }

    public void totalRound(double total){
        totalRound = new BigDecimal(total);
        totalRound = totalRound.setScale(3,RoundingMode.HALF_UP);
        current.setText("Current Earnings: $" + totalRound);
    }

    public Main(){

        setLayout(null);
        setTitle("TELUS Helper Program");
        setSize(800,550);
        getContentPane().setBackground(new Color(0x3DE0EF));

        telus = new ImageIcon(url);
        Image img = telus.getImage();
        Image newImg = img.getScaledInstance(200, 200,  java.awt.Image.SCALE_SMOOTH);
        telus = new ImageIcon(newImg);
        telusLabel = new JLabel(telus);
        telusLabel.setBounds(310,20,165,125);

        clear = new JButton("Clear All");
        clear.setBounds(300,400,170,50);
        clear.setFont(new Font("Times New Roman",Font.BOLD,15));
        clear.addActionListener(this);

        current = new JLabel();
        totalRound(total);
        current.setBounds(280,450,300,60);
        current.setFont(new Font("Times New Roman",Font.BOLD,20));

        label = new JLabel("Data Analyst Earnings Assistant");
        label.setBounds(255,150,300,40);
        label.setFont(new Font("Times New Roman",Font.BOLD,20));

        buttons[0] = new JButton("Most Tasks");
        buttons[0].setBounds(200,240,170,50);
        buttons[0].setFont(new Font("Times New Roman",Font.BOLD,15));

        buttons[1] = new JButton("Search 2.0");
        buttons[1].setBounds(410,240,170,50);
        buttons[1].setFont(new Font("Times New Roman",Font.BOLD,15));

        buttons[2] = new JButton("Autocomplete");
        buttons[2].setBounds(200,300,170,50);
        buttons[2].setFont(new Font("Times New Roman",Font.BOLD,15));

        buttons[3] = new JButton("Address Verification");
        buttons[3].setBounds(410,300,170,50);
        buttons[3].setFont(new Font("Times New Roman",Font.BOLD,15));

        for(JButton button : buttons){
            button.addActionListener(this);
            add(button);
        }

        add(label);
        add(telusLabel);
        add(current);
        add(clear);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent w){
                try {
                    saveData();
                }
                catch(Exception e){
                    System.out.println("Didn't load properly");
                }
            }
        });

        setLocationRelativeTo(null);
        setResizable(false);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);

    }
    public void actionPerformed(ActionEvent e){

            if(e.getSource() != clear) dispose();

            if(e.getSource() == buttons[0]) new Tasks();
           else if(e.getSource() == buttons[1]) new Search();
           else if(e.getSource() == buttons[2]) new Auto();
           else if(e.getSource() == buttons[3]) new Address();

           else if(e.getSource() == clear && total != 0){
                int pane = JOptionPane.showConfirmDialog(this,"Are you sure you want to clear all data?","Clear",JOptionPane.YES_NO_OPTION);

                if(pane == 0) {
                    Arrays.fill(Tasks.number, 0);
                    Arrays.fill(Search.number, 0);
                    Arrays.fill(Auto.number, 0);
                    Arrays.fill(Address.number, 0);

                    total = 0;
                    totalRound(total);
                }


            }
    }


    public static void main(String[] args) throws IOException{
        createFile();
        loadData();
        if(!client[0] && !client[1] && !client[2] && !client[3]) new Main();
        else if(client[0]) new Tasks();
        else if(client[1]) new Search();
        else if(client[2]) new Auto();
        else new Address();

    }

}
