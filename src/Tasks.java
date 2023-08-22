import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.math.*;
import java.util.*;
import javax.swing.*;

public class Tasks extends JFrame implements ActionListener {
    public final double[] task = new double[69];
    public static double total;
    public BigDecimal totalRound;
    public static int[] number = new int[69];
    JLabel label1 = new JLabel();
    JLabel label2 = new JLabel();
    JLabel titleLabel;
    JTextField[] field = new JTextField[69];
    JButton[] button = new JButton[69];
    JButton back;
    JButton[] negativeButton = new JButton[69];
    JButton clear;
    JLabel[] time = new JLabel[69];
    JLabel[] moreTime = new JLabel[38];

    public void createTimeLabels() {
        time[0] = new JLabel("10s");
        time[0].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[0].setBounds(10, 350, 45, 30);
        time[1] = new JLabel("12s");
        time[1].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[1].setBounds(55, 350, 45, 30);
        time[2] = new JLabel("14s");
        time[2].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[2].setBounds(100, 350, 45, 30);
        time[3] = new JLabel("20s");
        time[3].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[3].setBounds(145, 350, 45, 30);
        time[4] = new JLabel("24s");
        time[4].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[4].setBounds(190, 350, 45, 30);
        time[5] = new JLabel("25s");
        time[5].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[5].setBounds(235, 350, 45, 30);
        time[6] = new JLabel("27s");
        time[6].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[6].setBounds(280, 350, 45, 30);
        time[7] = new JLabel("30s");
        time[7].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[7].setBounds(325, 350, 45, 30);
        time[8] = new JLabel("36s");
        time[8].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[8].setBounds(370, 350, 45, 30);
        time[9] = new JLabel("40s");
        time[9].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[9].setBounds(415, 350, 45, 30);
        time[10] = new JLabel("45s");
        time[10].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[10].setBounds(460, 350, 45, 30);
        time[11] = new JLabel("50s");
        time[11].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[11].setBounds(505, 350, 45, 30);
        time[12] = new JLabel("1m");
        time[12].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[12].setBounds(550, 350, 45, 30);
        time[13] = new JLabel("1m");
        time[13].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[13].setBounds(595, 325, 45, 30);
        moreTime[0] = new JLabel("10s");
        moreTime[0].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[0].setBounds(595, 350, 45, 30);
        time[14] = new JLabel("1m");
        time[14].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[14].setBounds(640, 325, 45, 30);
        moreTime[1] = new JLabel("15s");
        moreTime[1].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[1].setBounds(640, 350, 45, 30);
        time[15] = new JLabel("1m");
        time[15].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[15].setBounds(685, 325, 45, 30);
        moreTime[2] = new JLabel("20s");
        moreTime[2].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[2].setBounds(685, 350, 45, 30);
        time[16] = new JLabel("1m");
        time[16].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[16].setBounds(730, 325, 45, 30);
        moreTime[3] = new JLabel("29s");
        moreTime[3].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[3].setBounds(730, 350, 45, 30);
        time[17] = new JLabel("1m");
        time[17].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[17].setBounds(775, 325, 45, 30);
        moreTime[4] = new JLabel("30s");
        moreTime[4].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[4].setBounds(775, 350, 45, 30);
        time[18] = new JLabel("1m");
        time[18].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[18].setBounds(815, 325, 45, 30);
        moreTime[5] = new JLabel("40s");
        moreTime[5].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[5].setBounds(815, 350, 45, 30);
        time[19] = new JLabel("1m");
        time[19].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[19].setBounds(860, 325, 45, 30);
        moreTime[6] = new JLabel("50s");
        moreTime[6].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[6].setBounds(860, 350, 45, 30);
        time[20] = new JLabel("2m");
        time[20].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[20].setBounds(905, 350, 45, 30);
        time[21] = new JLabel("2m");
        time[21].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[21].setBounds(950, 325, 45, 30);
        moreTime[7] = new JLabel("5s");
        moreTime[7].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[7].setBounds(955, 350, 45, 30);

        //Second row
        time[22] = new JLabel("2m");
        time[22].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[22].setBounds(10, 465, 45, 30);
        moreTime[8] = new JLabel("10s");
        moreTime[8].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[8].setBounds(10, 490, 45, 30);
        time[23] = new JLabel("2m");
        time[23].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[23].setBounds(55, 465, 45, 30);
        moreTime[9] = new JLabel("15s");
        moreTime[9].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[9].setBounds(55, 490, 45, 30);
        time[24] = new JLabel("2m");
        time[24].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[24].setBounds(100, 465, 45, 30);
        moreTime[10] = new JLabel("20s");
        moreTime[10].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[10].setBounds(100, 490, 45, 30);
        time[25] = new JLabel("2m");
        time[25].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[25].setBounds(145, 465, 45, 30);
        moreTime[11] = new JLabel("30s");
        moreTime[11].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[11].setBounds(145, 490, 45, 30);
        time[26] = new JLabel("2m");
        time[26].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[26].setBounds(190, 465, 45, 30);
        moreTime[12] = new JLabel("40s");
        moreTime[12].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[12].setBounds(190, 490, 45, 30);
        time[27] = new JLabel("2m");
        time[27].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[27].setBounds(235, 465, 45, 30);
        moreTime[13] = new JLabel("45s");
        moreTime[13].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[13].setBounds(235, 490, 45, 30);
        time[28] = new JLabel("2m");
        time[28].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[28].setBounds(280, 465, 45, 30);
        moreTime[14] = new JLabel("55s");
        moreTime[14].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[14].setBounds(280, 490, 45, 30);
        time[29] = new JLabel("3m");
        time[29].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[29].setBounds(325, 490, 45, 30);
        time[30] = new JLabel("3m");
        time[30].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[30].setBounds(370, 465, 45, 30);
        moreTime[15] = new JLabel("10s");
        moreTime[15].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[15].setBounds(370, 490, 45, 30);
        time[31] = new JLabel("3m");
        time[31].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[31].setBounds(415, 465, 45, 30);
        moreTime[16] = new JLabel("20s");
        moreTime[16].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[16].setBounds(415, 490, 45, 30);
        time[32] = new JLabel("3m");
        time[32].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[32].setBounds(460, 465, 45, 30);
        moreTime[17] = new JLabel("30s");
        moreTime[17].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[17].setBounds(460, 490, 45, 30);
        time[33] = new JLabel("3m");
        time[33].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[33].setBounds(505, 465, 45, 30);
        moreTime[18] = new JLabel("40s");
        moreTime[18].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[18].setBounds(505, 490, 45, 30);
        time[34] = new JLabel("3m");
        time[34].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[34].setBounds(550, 465, 45, 30);
        moreTime[19] = new JLabel("45s");
        moreTime[19].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[19].setBounds(550, 490, 45, 30);
        time[35] = new JLabel("4m");
        time[35].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[35].setBounds(595, 490, 45, 30);
        time[36] = new JLabel("4m");
        time[36].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[36].setBounds(640, 465, 45, 30);
        moreTime[20] = new JLabel("10s");
        moreTime[20].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[20].setBounds(640, 490, 45, 30);
        time[37] = new JLabel("4m");
        time[37].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[37].setBounds(685, 465, 45, 30);
        moreTime[21] = new JLabel("15s");
        moreTime[21].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[21].setBounds(685, 490, 45, 30);
        time[38] = new JLabel("4m");
        time[38].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[38].setBounds(730, 465, 45, 30);
        moreTime[22] = new JLabel("30s");
        moreTime[22].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[22].setBounds(730, 490, 45, 30);
        time[39] = new JLabel("5m");
        time[39].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[39].setBounds(775, 490, 45, 30);
        time[40] = new JLabel("5m");
        time[40].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[40].setBounds(820, 465, 45, 30);
        moreTime[23] = new JLabel("15s");
        moreTime[23].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[23].setBounds(820, 490, 45, 30);
        time[41] = new JLabel("5m");
        time[41].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[41].setBounds(865, 465, 45, 30);
        moreTime[24] = new JLabel("20s");
        moreTime[24].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[24].setBounds(865, 490, 45, 30);
        time[42] = new JLabel("5m");
        time[42].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[42].setBounds(910, 465, 45, 30);
        moreTime[25] = new JLabel("30s");
        moreTime[25].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[25].setBounds(910, 490, 45, 30);
        time[43] = new JLabel("5m");
        time[43].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[43].setBounds(955, 465, 45, 30);
        moreTime[26] = new JLabel("45s");
        moreTime[26].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[26].setBounds(955, 490, 45, 30);

        //Third row
        time[44] = new JLabel("6m");
        time[44].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[44].setBounds(10, 630, 45, 30);
        time[45] = new JLabel("6m");
        time[45].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[45].setBounds(55, 605, 45, 30);
        moreTime[27] = new JLabel("15s");
        moreTime[27].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[27].setBounds(55, 630, 45, 30);
        time[46] = new JLabel("6m");
        time[46].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[46].setBounds(100, 605, 45, 30);
        moreTime[28] = new JLabel("30s");
        moreTime[28].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[28].setBounds(100, 630, 45, 30);
        time[47] = new JLabel("6m");
        time[47].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[47].setBounds(145, 605, 45, 30);
        moreTime[29] = new JLabel("40s");
        moreTime[29].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[29].setBounds(145, 630, 45, 30);
        time[48] = new JLabel("6m");
        time[48].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[48].setBounds(190, 605, 45, 30);
        moreTime[30] = new JLabel("45s");
        moreTime[30].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[30].setBounds(190, 630, 45, 30);
        time[49] = new JLabel("7m");
        time[49].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[49].setBounds(235, 630, 45, 30);
        time[50] = new JLabel("7m");
        time[50].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[50].setBounds(280, 605, 45, 30);
        moreTime[31] = new JLabel("15s");
        moreTime[31].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[31].setBounds(280, 630, 45, 30);
        time[51] = new JLabel("7m");
        time[51].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[51].setBounds(325, 605, 45, 30);
        moreTime[32] = new JLabel("30s");
        moreTime[32].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[32].setBounds(325, 630, 45, 30);
        time[52] = new JLabel("8m");
        time[52].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[52].setBounds(370, 630, 45, 30);
        time[53] = new JLabel("9m");
        time[53].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[53].setBounds(415, 630, 45, 30);
        time[54] = new JLabel("9m");
        time[54].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[54].setBounds(460, 605, 45, 30);
        moreTime[33] = new JLabel("20s");
        moreTime[33].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[33].setBounds(460, 630, 45, 30);
        time[55] = new JLabel("10m");
        time[55].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[55].setBounds(500, 630, 45, 30);
        time[56] = new JLabel("10m");
        time[56].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[56].setBounds(545, 605, 45, 30);
        moreTime[34] = new JLabel("40s");
        moreTime[34].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[34].setBounds(545, 630, 45, 30);
        time[57] = new JLabel("10m");
        time[57].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[57].setBounds(590, 605, 45, 30);
        moreTime[35] = new JLabel("50s");
        moreTime[35].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[35].setBounds(590, 630, 45, 30);
        time[58] = new JLabel("11m");
        time[58].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[58].setBounds(635, 630, 45, 30);
        time[59] = new JLabel("12m");
        time[59].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[59].setBounds(680, 630, 45, 30);
        time[60] = new JLabel("13m");
        time[60].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[60].setBounds(725, 630, 45, 30);
        time[61] = new JLabel("13m");
        time[61].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[61].setBounds(770, 605, 45, 30);
        moreTime[36] = new JLabel("20s");
        moreTime[36].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[36].setBounds(770, 630, 45, 30);
        time[62] = new JLabel("14m");
        time[62].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[62].setBounds(815, 630, 45, 30);
        time[63] = new JLabel("15m");
        time[63].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[63].setBounds(860, 630, 45, 30);
        time[64] = new JLabel("16m");
        time[64].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[64].setBounds(905, 630, 45, 30);
        time[65] = new JLabel("16m");
        time[65].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[65].setBounds(945, 605, 45, 30);
        moreTime[37] = new JLabel("40s");
        moreTime[37].setFont(new Font("Times New Roman", Font.BOLD, 20));
        moreTime[37].setBounds(950, 630, 45, 30);

        //Fourth row
        time[66] = new JLabel("17m");
        time[66].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[66].setBounds(3, 770, 45, 30);
        time[67] = new JLabel("19m");
        time[67].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[67].setBounds(48, 770, 45, 30);
        time[68] = new JLabel("20m");
        time[68].setFont(new Font("Times New Roman", Font.BOLD, 20));
        time[68].setBounds(93, 770, 45, 30);
    }

    public Tasks() {
        total = TELUSHelper.total;
        totalRound(total);

        setLayout(null);
        setTitle("Most Tasks");
        setSize(1002, 920);
        getContentPane().setBackground(new Color(1742498));

        int increment = 0;

        task[0] = 0.032;
        task[1] = 0.039;
        task[2] = 0.045;
        task[3] = 0.064;
        task[4] = 0.077;
        task[5] = 0.08;
        task[6] = 0.087;
        task[7] = 0.097;
        task[8] = 0.116;
        task[9] = 0.129;
        task[10] = 0.145;
        task[11] = 0.161;
        task[12] = 0.193;
        task[13] = 0.225;
        task[14] = 0.241;
        task[15] = 0.257;
        task[16] = 0.286;
        task[17] = 0.29;
        task[18] = 0.322;
        task[19] = 0.354;
        task[20] = 0.386;
        task[21] = 0.402;
        task[22] = 0.418;
        task[23] = 0.434;
        task[24] = 0.45;
        task[25] = 0.483;
        task[26] = 0.515;
        task[27] = 0.531;
        task[28] = 0.563;
        task[29] = 0.579;
        task[30] = 0.611;
        task[31] = 0.643;
        task[32] = 0.676;
        task[33] = 0.708;
        task[34] = 0.724;
        task[35] = 0.772;
        task[36] = 0.804;
        task[37] = 0.82;
        task[38] = 0.869;
        task[39] = 0.965;
        task[40] = 1.013;
        task[41] = 1.029;
        task[42] = 1.062;
        task[43] = 1.11;
        task[44] = 1.158;
        task[45] = 1.206;
        task[46] = 1.255;
        task[47] = 1.287;
        task[48] = 1.303;
        task[49] = 1.351;
        task[50] = 1.399;
        task[51] = 1.448;
        task[52] = 1.544;
        task[53] = 1.737;
        task[54] = 1.801;
        task[55] = 1.93;
        task[56] = 2.059;
        task[57] = 2.091;
        task[58] = 2.123;
        task[59] = 2.316;
        task[60] = 2.509;
        task[61] = 2.573;
        task[62] = 2.702;
        task[63] = 2.895;
        task[64] = 3.088;
        task[65] = 3.217;
        task[66] = 3.281;
        task[67] = 3.667;
        task[68] = 3.86;

        createTimeLabels();

        titleLabel = new JLabel("Most Tasks");
        titleLabel.setBounds(435, 0, 300, 40);
        titleLabel.setFont(new Font("Times New Roman", Font.BOLD, 20));
        titleLabel.setForeground(new Color(13391387));

        back = new JButton("Back to Menu");
        back.setBounds(50, 10, 130, 40);
        back.setFont(new Font("Times New Roman", Font.BOLD, 15));
        back.setBackground(new Color(14931243));
        back.addActionListener(this);

        label1.setText("Earnings:");
        label1.setBounds(425, 70, 300, 40);
        label1.setFont(new Font("Times New Roman", Font.BOLD, 30));

        totalRound(total);
        label2.setText("$" + totalRound);
        label2.setBounds(425, 120, 350, 60);
        label2.setFont(new Font("Times New Roman", Font.BOLD, 40));

        int i;
        for(i = 0; i < 22; ++i) {
            button[i] = new JButton("+");
            button[i].setFont(new Font("Times New Roman", Font.BOLD, 20));
            button[i].setBounds(increment, 375, 45, 30);
            button[i].addActionListener(this);
            add(button[i]);

            negativeButton[i] = new JButton("-");
            negativeButton[i].setBounds(increment, 433, 45, 30);
            negativeButton[i].setFont(new Font("Times New Roman", Font.BOLD, 25));
            negativeButton[i].addActionListener(this);
            add(negativeButton[i]);

            field[i] = new JTextField(16);
            field[i].setHorizontalAlignment(0);
            field[i].setBounds(increment, 405, 45, 30);
            field[i].setFont(new Font("Times New Roman", Font.BOLD, 25));
            field[i].setEditable(false);
            field[i].setText(String.valueOf(number[i]));
            add(field[i]);

            increment += 45;
        }

        increment = 0;
        for(i = 22; i < 44; ++i) {
            button[i] = new JButton("+");
            button[i].setFont(new Font("Times New Roman", Font.BOLD, 20));
            button[i].setBounds(increment, 515, 45, 30);
            button[i].addActionListener(this);
            add(button[i]);

            negativeButton[i] = new JButton("-");
            negativeButton[i].setBounds(increment, 573, 45, 30);
            negativeButton[i].setFont(new Font("Times New Roman", Font.BOLD, 25));
            negativeButton[i].addActionListener(this);
            add(negativeButton[i]);

            field[i] = new JTextField(16);
            field[i].setHorizontalAlignment(0);
            field[i].setBounds(increment, 545, 45, 30);
            field[i].setFont(new Font("Times New Roman", Font.BOLD, 25));
            field[i].setEditable(false);
            field[i].setText(String.valueOf(number[i]));
            add(field[i]);

            increment += 45;
        }

        increment = 0;
        for(i = 44; i < 66; ++i) {
            button[i] = new JButton("+");
            button[i].setFont(new Font("Times New Roman", Font.BOLD, 20));
            button[i].setBounds(increment, 655, 45, 30);
            button[i].addActionListener(this);
            add(button[i]);

            negativeButton[i] = new JButton("-");
            negativeButton[i].setBounds(increment, 713, 45, 30);
            negativeButton[i].setFont(new Font("Times New Roman", Font.BOLD, 25));
            negativeButton[i].addActionListener(this);
            add(negativeButton[i]);

            field[i] = new JTextField(16);
            field[i].setHorizontalAlignment(0);
            field[i].setBounds(increment, 685, 45, 30);
            field[i].setFont(new Font("Times New Roman", Font.BOLD, 25));
            field[i].setEditable(false);
            field[i].setText(String.valueOf(number[i]));
            add(field[i]);

            increment += 45;
        }

        increment = 0;

        for(i = 66; i < 69; ++i) {
            button[i] = new JButton("+");
            button[i].setFont(new Font("Times New Roman", Font.BOLD, 20));
            button[i].setBounds(increment, 795, 45, 30);
            button[i].addActionListener(this);
            add(button[i]);

            negativeButton[i] = new JButton("-");
            negativeButton[i].setBounds(increment, 853, 45, 30);
            negativeButton[i].setFont(new Font("Times New Roman", Font.BOLD, 25));
            negativeButton[i].addActionListener(this);
            add(negativeButton[i]);

            field[i] = new JTextField(16);
            field[i].setHorizontalAlignment(0);
            field[i].setBounds(increment, 825, 45, 30);
            field[i].setFont(new Font("Times New Roman", Font.BOLD, 25));
            field[i].setEditable(false);
            field[i].setText(String.valueOf(number[i]));
            add(field[i]);

            increment += 45;
        }

        clear = new JButton("Clear");
        clear.setBounds(430, 200, 100, 50);
        clear.setFont(new Font("Times New Roman", Font.BOLD, 25));
        clear.addActionListener(this);

        add(label1);
        add(label2);
        add(clear);
        add(back);
        add(titleLabel);


       for(JLabel label : time) add(label);
       for(JLabel label : moreTime) add(label);

       addWindowListener(new WindowAdapter(){
            public void windowClosing(WindowEvent w){
                try {
                    TELUSHelper.total = total;
                    TELUSHelper.client[0] = true;
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

    public void totalRound(double total) {
        totalRound = new BigDecimal(total);
        totalRound = totalRound.setScale(3, RoundingMode.HALF_UP);
        label2.setText("$" + totalRound);
    }

    public void actionPerformed(ActionEvent e){
        double tempTotal = 0;
        for(int i = 0; i < number.length; i++) tempTotal += (number[i] * task[i]);

        if(e.getSource() == clear && tempTotal != 0){
            int pane = JOptionPane.showConfirmDialog(this,"Are you sure you want to clear?","Clear",JOptionPane.YES_NO_OPTION);

            if(pane == 0) {

                for(int i = 0; i < number.length; i++) total -= (number[i] * task[i]);

                Arrays.fill(number, 0);
                for(int i = 0; i < field.length; i++)
                    field[i].setText(String.valueOf(number[i]));

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

        if(e.getSource() == back){
            try{
                TELUSHelper.total = total;
                TELUSHelper.client[0] = false;
                TELUSHelper.saveData();
                dispose();
                new TELUSHelper();
            }
            catch(IOException n){
                n.printStackTrace();
            }
        }
    }
}
