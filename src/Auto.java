import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import java.io.*;
import java.math.*;
import java.util.Arrays;

public class Auto extends JFrame implements ActionListener{

    public final double [] tasks = new double[18];

    public double total;
    public static int [] number = new int[18];


    JLabel label1,label2 = new JLabel(),titleLabel;
    JLabel [] time = new JLabel[18],moreTime = new JLabel[18];

    public BigDecimal totalRound;

    JButton [] button = new JButton[18];
    JButton [] negativeButton = new JButton[18];

    JButton back,clear;
    JTextField [] field = new JTextField[18];

    public void createTimeLabels() {
        //First row
        time[0] = new JLabel("1m");
        time[0].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[0].setBounds(10, 325, 45, 30);
        moreTime[0] = new JLabel("30s");
        moreTime[0].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[0].setBounds(10, 350, 45, 30);
        time[1] = new JLabel("1m");
        time[1].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[1].setBounds(55, 325, 45, 30);
        moreTime[1] = new JLabel("40s");
        moreTime[1].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[1].setBounds(55, 350, 45, 30);
        time[2] = new JLabel("1m");
        time[2].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[2].setBounds(100, 325, 45, 30);
        moreTime[2] = new JLabel("55s");
        moreTime[2].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[2].setBounds(100, 350, 45, 30);
        time[3] = new JLabel("3m");
        time[3].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[3].setBounds(145, 325, 45, 30);
        moreTime[3] = new JLabel("10s");
        moreTime[3].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[3].setBounds(145, 350, 45, 30);
        time[4] = new JLabel("3m");
        time[4].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[4].setBounds(190, 325, 45, 30);
        moreTime[4] = new JLabel("25s");
        moreTime[4].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[4].setBounds(190, 350, 45, 30);
        time[5] = new JLabel("3m");
        time[5].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[5].setBounds(235, 325, 45, 30);
        moreTime[5] = new JLabel("40s");
        moreTime[5].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[5].setBounds(235, 350, 45, 30);
        time[6] = new JLabel("4m");
        time[6].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[6].setBounds(280, 325, 45, 30);
        moreTime[6] = new JLabel("55s");
        moreTime[6].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[6].setBounds(280, 350, 45, 30);
        time[7] = new JLabel("5m");
        time[7].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[7].setBounds(325, 325, 45, 30);
        moreTime[7] = new JLabel("25s");
        moreTime[7].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[7].setBounds(325, 350, 45, 30);
        time[8] = new JLabel("6m");
        time[8].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[8].setBounds(370, 325, 45, 30);
        moreTime[8] = new JLabel("10s");
        moreTime[8].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[8].setBounds(370, 350, 45, 30);
        time[9] = new JLabel("7m");
        time[9].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[9].setBounds(415, 325, 45, 30);
        moreTime[9] = new JLabel("55s");
        moreTime[9].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[9].setBounds(415, 350, 45, 30);
        time[10] = new JLabel("9m");
        time[10].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[10].setBounds(460, 325, 45, 30);
        moreTime[10] = new JLabel("10s");
        moreTime[10].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[10].setBounds(460, 350, 45, 30);
        time[11] = new JLabel("9m");
        time[11].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[11].setBounds(505, 325, 45, 30);
        moreTime[11] = new JLabel("55s");
        moreTime[11].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[11].setBounds(505, 350, 45, 30);
        time[12] = new JLabel("10m");
        time[12].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[12].setBounds(545, 325, 45, 30);
        moreTime[12] = new JLabel("10s");
        moreTime[12].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[12].setBounds(550, 350, 45, 30);
        time[13] = new JLabel("11m");
        time[13].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[13].setBounds(590, 325, 45, 30);
        moreTime[13] = new JLabel("25s");
        moreTime[13].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[13].setBounds(595, 350, 45, 30);
        time[14] = new JLabel("12m");
        time[14].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[14].setBounds(635, 325, 45, 30);
        moreTime[14] = new JLabel("10s");
        moreTime[14].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[14].setBounds(640, 350, 45, 30);
        time[15] = new JLabel("12m");
        time[15].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[15].setBounds(680, 325, 45, 30);
        moreTime[15] = new JLabel("40s");
        moreTime[15].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[15].setBounds(685, 350, 45, 30);
        time[16] = new JLabel("13m");
        time[16].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[16].setBounds(725, 325, 45, 30);
        moreTime[16] = new JLabel("55s");
        moreTime[16].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[16].setBounds(730, 350, 45, 30);
        time[17] = new JLabel("15m");
        time[17].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[17].setBounds(770, 325, 45, 30);
        moreTime[17] = new JLabel("10s");
        moreTime[17].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[17].setBounds(775, 350, 45, 30);

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
                TELUSHelper.total = total;
                TELUSHelper.client[2] = false;
                TELUSHelper.saveData();
                dispose();
                new TELUSHelper();
            }
            catch(IOException n){
                n.printStackTrace();
            }
        }
    }

    public Auto(){

        total = TELUSHelper.total;
        totalRound(total);

        setLayout(null);
        setTitle("Autocomplete");
        setSize(824,500);
        int increment = 0;
        getContentPane().setBackground(new Color(0x866AEE));

        tasks[0] = 0.276;
        tasks[1] = 0.307;
        tasks[2] = 0.353;
        tasks[3] = 0.583;
        tasks[4] = 0.629;
        tasks[5] = 0.675;
        tasks[6] = 0.905;
        tasks[7] = 0.997;
        tasks[8] = 1.135;
        tasks[9] = 1.457;
        tasks[10] = 1.687;
        tasks[11] = 1.825;
        tasks[12] = 1.871;
        tasks[13] = 2.101;
        tasks[14] = 2.239;
        tasks[15] = 2.331;
        tasks[16] = 2.561;
        tasks[17] = 2.791;

        titleLabel = new JLabel("Autocomplete");
        titleLabel.setBounds(345,0,300,40);
        titleLabel.setFont(new Font("Times New Roman",Font.BOLD,20));
        titleLabel.setForeground(new Color(0xDE0D33));

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

        for(int i = 0; i<18; i++){

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
                    TELUSHelper.total = total;
                    TELUSHelper.client[2] = true;
                    TELUSHelper.saveData();
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
