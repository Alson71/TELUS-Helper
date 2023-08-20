import java.awt.*;
import java.awt.event.*;
import java.util.*;
import javax.swing.*;
import java.io.*;
import java.math.*;


public class TELUSHelper extends JFrame implements ActionListener{

    public final double [] task = new double[22];
    static public double total;
    
    public BigDecimal totalRound;
    static File file;
    static public int [] number = new int[22];


    JLabel label1 = new JLabel(),label2 = new JLabel();
    JLabel [] time = new JLabel[22];
    JLabel [] moreTime = new JLabel[10];
    
    JTextField [] field = new JTextField[22];

    JButton [] button = new JButton[22];
    JButton[] negativeButton = new JButton[22];
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

        if(!b){
            file = new File(System.getProperty("user.home") + File.separator +"OneDrive/Desktop/telus.txt");
        }

    }


    public TELUSHelper() {

        setLayout(null);
        setTitle("TELUS Helper Program");
        setSize(1002,500);
        int increment = 0;

        task[0] = 0.087;
        task[1] = 0.193;
        task[2] = 0.257;
        task[3] = 0.286;
        task[4] = 0.290;
        task[5] = 0.386;
        task[6] = 0.515;
        task[7] = 0.579;
        task[8] = 0.772;
        task[9] = 0.869;
        task[10] = 0.965;
        task[11] = 1.029;
        task[12] = 1.158;
        task[13] = 1.287;
        task[14] = 1.351;
        task[15] = 1.544;
        task[16] = 1.737;
        task[17] = 1.801;
        task[18] = 1.930;
        task[19]= 2.059;
        task[20] = 2.316;
        task[21] = 2.573;


        label1.setText("Earnings:");
        label1.setBounds(425,40,300,40);
        label1.setFont(new Font("Times New Roman",Font.BOLD,30));

        totalRound(total);
        label2.setText("$" + totalRound);
        label2.setBounds(425,120,350,60);
        label2.setFont(new Font("Times New Roman",Font.BOLD,40));



        for(int i = 0; i<button.length; i++){

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



        time[0] = new JLabel("27s");
        time[0].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[0].setBounds(10,350,45,30);
        time[1] = new JLabel("1m");
        time[1].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[1].setBounds(55,350,45,30);
        time[2] = new JLabel("1m");
        time[2].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[2].setBounds(100,325,45,30);
        moreTime[0] = new JLabel("20s");
        moreTime[0].setFont(new Font("Times New Roman",Font.BOLD,20));
        moreTime[0].setBounds(100,350,45,30);
        time[3] = new JLabel("1m");
        time[3].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[3].setBounds(145,325,45,30);
        moreTime[1] = new JLabel("29s");
        moreTime[1].setFont(new Font("Times New Roman",Font.BOLD,20));
        moreTime[1].setBounds(145,350,45,30);
        time[4] = new JLabel("1m");
        time[4].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[4].setBounds(190,325,45,30);
        moreTime[2] = new JLabel("30s");
        moreTime[2].setFont(new Font("Times New Roman",Font.BOLD,20));
        moreTime[2].setBounds(190,350,45,30);
        time[5] = new JLabel("2m");
        time[5].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[5].setBounds(235,350,45,30);
        time[6] = new JLabel("2m");
        time[6].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[6].setBounds(280,325,45,30);
        moreTime[3] = new JLabel("40s");
        moreTime[3].setFont(new Font("Times New Roman",Font.BOLD,20));
        moreTime[3].setBounds(280,350,45,30);
        time[7] = new JLabel("3m");
        time[7].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[7].setBounds(325,350,45,30);
        time[8] = new JLabel("4m");
        time[8].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[8].setBounds(370,350,45,30);
        time[9] = new JLabel("4m");
        time[9].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[9].setBounds(415,325,45,30);
        moreTime[4] = new JLabel("30s");
        moreTime[4].setFont(new Font("Times New Roman",Font.BOLD,20));
        moreTime[4].setBounds(415,350,45,30);
        time[10] = new JLabel("5m");
        time[10].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[10].setBounds(460,350,45,30);
        time[11] = new JLabel("5m");
        time[11].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[11].setBounds(505,325,45,30);
        moreTime[5] = new JLabel("20s");
        moreTime[5].setFont(new Font("Times New Roman",Font.BOLD,20));
        moreTime[5].setBounds(505,350,45,30);
        time[12] = new JLabel("6m");
        time[12].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[12].setBounds(550,350,45,30);
        time[13] = new JLabel("6m");
        time[13].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[13].setBounds(595,325,45,30);
        moreTime[6] = new JLabel("40s");
        moreTime[6].setFont(new Font("Times New Roman",Font.BOLD,20));
        moreTime[6].setBounds(595,350,45,30);
        time[14] = new JLabel("7m");
        time[14].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[14].setBounds(640,350,45,30);
        time[15] = new JLabel("8m");
        time[15].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[15].setBounds(685,350,45,30);
        time[16] = new JLabel("9m");
        time[16].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[16].setBounds(730,350,45,30);
        time[17] = new JLabel("9m");
        time[17].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[17].setBounds(775,325,45,30);
        moreTime[7] = new JLabel("20s");
        moreTime[7].setFont(new Font("Times New Roman",Font.BOLD,20));
        moreTime[7].setBounds(775,350,45,30);
        time[18] = new JLabel("10m");
        time[18].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[18].setBounds(815,350,45,30);
        time[19] = new JLabel("10m");
        time[19].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[19].setBounds(860,325,45,30);
        moreTime[8] = new JLabel("40s");
        moreTime[8].setFont(new Font("Times New Roman",Font.BOLD,20));
        moreTime[8].setBounds(865,350,45,30);
        time[20] = new JLabel("12m");
        time[20].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[20].setBounds(905,350,45,30);
        time[21] = new JLabel("13m");
        time[21].setFont(new Font("Times New Roman",Font.BOLD,20));
        time[21].setBounds(950,325,45,30);
        moreTime[9] = new JLabel("20s");
        moreTime[9].setFont(new Font("Times New Roman",Font.BOLD,20));
        moreTime[9].setBounds(955,350,45,30);



        clear = new JButton("Clear");
        clear.setBounds(430,200,100,50);
        clear.setFont(new Font("Times New Roman",Font.BOLD,25));
        clear.addActionListener(this);

        add(label1);
        add(label2);
        add(clear);

        for (JLabel jLabel : time) add(jLabel);
        for (JLabel jLabel : moreTime) add(jLabel);

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

    public static void loadData() throws IOException{

        if(file.length() != 0) {
            Scanner scanner = new Scanner(file);
            String s = scanner.next();
            String [] array = s.split("#");

            for(int i = 0; i < number.length; i++){
                number[i] = Integer.parseInt(array[i]);
            }

            total = Double.parseDouble(array[22]);

        }
    }

    public static void saveData() throws IOException{
        PrintWriter writer = new PrintWriter(file);
        
        for (int j : number) 
            writer.print(j + "#");
        
        writer.print(total);
        writer.close();

    }

    public void totalRound(double total){
        totalRound = new BigDecimal(total);
        totalRound = totalRound.setScale(3,RoundingMode.HALF_UP);
        label2.setText("$" + totalRound);
    }

    public void actionPerformed(ActionEvent e){

        if(e.getSource() == clear && total != 0){

            int pane = JOptionPane.showConfirmDialog(this,"Are you sure you want to clear?","Clear",JOptionPane.YES_NO_OPTION);

            if(pane == 0) {

                Arrays.fill(number, 0);
                for(int i = 0; i < field.length; i++){
                    field[i].setText(String.valueOf(number[i]));
                }

                total = 0;
                totalRound(total);

            }

        }

        for(int i = 0; i<number.length; i++){

            if(e.getSource() == button[i]){
                number[i]++;
                total+=task[i];
            }
            else if(e.getSource() == negativeButton[i] && number[i] != 0){
                number[i]--;
                total-=task[i];
            }

            field[i].setText(String.valueOf(number[i]));
            totalRound(total);

        }
    }
    public static void main(String[] args) throws IOException  {
        createFile();
        loadData();
        new TELUSHelper();

    }
}
