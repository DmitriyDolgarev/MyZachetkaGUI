package View;

import Data.*;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainWindow extends JFrame {
    private static Matician matician = new Matician();
    private static Phisicist phisicist = new Phisicist();
    private static Chemist chemist = new Chemist();
    private static Programmer programmer = new Programmer();
    private static Zachetka zachetka = new Zachetka();
    private JLabel mainLabel;
    private JButton jButton;
    private JButton jButtons;
    private JButton thbutton;
    public MainWindow()
    {
        setTitle("Моя зачетка");
        mainLabel=new JLabel("Главное меню");
        jButton=new JButton("Выбрать предмет");
        jButtons=new JButton("Добавить предмет");
        thbutton=new JButton("Показать общую информацию по всем предметам");

        JPanel jPanel=new JPanel();
        jPanel.add(mainLabel);
        jPanel.add(jButton);
        jPanel.add(jButtons);
        jPanel.add(thbutton);

        jPanel.setLayout(new BoxLayout(jPanel, BoxLayout.Y_AXIS));

        mainLabel.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButton.setAlignmentX(Component.CENTER_ALIGNMENT);
        jButtons.setAlignmentX(Component.CENTER_ALIGNMENT);
        thbutton.setAlignmentX(Component.CENTER_ALIGNMENT);

        add(jPanel);

        MyListener myListener=new MyListener(zachetka);
        jButton.addActionListener(myListener);
        jButtons.addActionListener(myListener);
        thbutton.addActionListener(myListener);

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setLocationByPlatform(true);
        pack();
        setResizable(false);
        setVisible(true);
    }
}
class MyListener implements ActionListener {
    private static Zachetka zachetka=new Zachetka();
    public MyListener(Zachetka zachetka1)
    {
        zachetka=zachetka1;
    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getActionCommand().equals("Выбрать предмет") && Adding.getInstance()==null)
        {
            Chosing chosing= Chosing.checkInstance(zachetka);
        }
        else if (e.getActionCommand().equals("Добавить предмет") && Chosing.getInstance()==null)
        {
            Adding adding= Adding.checkInstance(zachetka);
        }
        else if (e.getActionCommand().equals("Показать общую информацию по всем предметам"))
        {
            if (zachetka.getCountOfDisciplines()==0)
            {
                JOptionPane.showMessageDialog(null, "Прежде чем посмотреть информацию по всем предметам вам нужно иметь в зачетке хотя бы 1 предмет.", "Общая информация", JOptionPane.INFORMATION_MESSAGE);
            }
            else
            {
                GenInfo genInfo = GenInfo.checkInstance(zachetka);
            }
        }
    }
}
