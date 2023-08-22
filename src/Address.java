import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.math.*;
public class Address extends JFrame implements ActionListener {
    public final double [] tasks = new double[2];

    public double total;
    public static int [] number = new int[2];


    JLabel label1,label2 = new JLabel(),titleLabel;
    JLabel [] time = new JLabel[2],moreTime = new JLabel[2];

    public BigDecimal totalRound;

    JButton [] button = new JButton[2];
    JButton [] negativeButton = new JButton[2];

    JButton back,clear;
    JTextField [] field = new JTextField[18];

    public void createTimeLabels() {
        //First row

        time[0] = new JLabel("2m");
        time[0].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[0].setBounds(365, 325, 45, 30);
        moreTime[0] = new JLabel("15s");
        moreTime[0].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[0].setBounds(365, 350, 45, 30);
        time[1] = new JLabel("3m");
        time[1].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[1].setBounds(410, 325, 45, 30);
        moreTime[1] = new JLabel("30s");
        moreTime[1].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[1].setBounds(410, 350, 45, 30);

    }
    public void totalRound(double total){
        totalRound = new BigDecimal(total);
        totalRound = totalRound.setScale(3,RoundingMode.HALF_UP);
        label2.setText("$" + totalRound);
    }



    public void actionPerformed(ActionEvent e){
        double tempTotal = 0;
        for(int i = 0; i < number.length; i++) tempTotal += (number[i] * tasks[i]);

        if(e.getSource() == clear && tempTotal != 0){
            int pane = JOptionPane.showConfirmDialog(this,"Are you sure you want to clear?","Clear",JOptionPane.YES_NO_OPTION);

            if(pane == 0) {

                for(int i = 0; i < number.length; i++) total -= (number[i] * tasks[i]);

                Arrays.fill(number, 0);
                for(int i = 0; i < field.length; i++){
                    field[i].setText(String.valueOf(number[i]));

                }

                totalRound(total);

            }

        }

        for(int i = 0; i<number.length; i++){

            if(e.getSource() == button[i]){
                number[i]++;
                total+=tasks[i];
            }
            else if(e.getSource() == negativeButton[i] && number[i] != 0){
                number[i]--;
                total-=tasks[i];
            }

            field[i].setText(String.valueOf(number[i]));
            totalRound(total);

        }

        if(e.getSource() == back){
            try{
                Main.total = total;
                Main.client[3] = false;
                Main.saveData();
                dispose();
                new Main();
            }
            catch(IOException n){
                n.printStackTrace();
            }
        }
    }

    public Address(){

        total = Main.total;
        totalRound(total);

        setLayout(null);
        setTitle("Address Verification");
        setSize(824,500);
        int increment = 355;
        getContentPane().setBackground(new Color(0x6072FD));

        tasks[0] = 0.450;
        tasks[1] = 0.700;


        titleLabel = new JLabel("Address Verification");
        titleLabel.setBounds(315,0,300,40);
        titleLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        titleLabel.setForeground(new Color(0x004650));

        label1 = new JLabel("Earnings:");
        label1.setBounds(345,70,300,40);
        label1.setFont(new Font("Times New Roman",Font.BOLD,30));


        label2.setBounds(345,120,350,60);
        label2.setFont(new Font("Times New Roman",Font.BOLD,40));

        back = new JButton("Back to Menu");
        back.setBounds(30,10,130,40);
        back.setFont(new Font("Times New Roman",Font.BOLD,15));
        back.setBackground(new Color(0xE3D52B));
        back.addActionListener(this);

        clear = new JButton("Clear");
        clear.setBounds(350,200,100,50);
        clear.setFont(new Font("Times New Roman",Font.BOLD,25));
        clear.addActionListener(this);

        for(int i = 0; i<2; i++){

            totalRound(total);

            button[i] = new JButton("+");
            button[i].setFont(new Font("Times New Roman",Font.BOLD,20));
            button[i].setBounds(increment,375,45,30);
            button[i].addActionListener(this);
            add(button[i]);

            negativeButton[i] = new JButton("-");
            negativeButton[i].setBounds(increment,433,45,30);
            negativeButton[i].setFont(new Font("Times New Roman",Font.BOLD,25));
            negativeButton[i].addActionListener(this);
            add(negativeButton[i]);

            field[i] = new JTextField(16);
            field[i].setHorizontalAlignment(SwingConstants.CENTER);
            field[i].setBounds(increment,405,45,30);
            field[i].setFont(new Font("Times New Roman",Font.BOLD,25));
            field[i].setEditable(false);
            field[i].setText(String.valueOf(number[i]));
            add(field[i]);

            increment+=45;
        }

        add(label1);
        add(label2);
        add(back);
        add(clear);
        add(titleLabel);

        createTimeLabels();
        for(JLabel label : time) add(label);
        for(JLabel label : moreTime) add(label);

        addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent w){
                try {
                    Main.total = total;
                    Main.client[3] = true;
                    Main.saveData();
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



}
