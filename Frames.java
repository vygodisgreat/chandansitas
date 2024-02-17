import javax.swing.*;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;

class alpha extends JFrame implements ActionListener
{
    JButton J1;

    //  need this for all the buttns


    JLabel L1;
    String Order[] = new String[1000];
    // static int Value[] = new int[10];
    // for (int alpha=0; alph<10; alpha++)
    // {
    //     Value[alpha]=0;
    // }
    int i=0;
    alpha()
    {
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);

        L1 = new JLabel("Pasta");
        L1.setBounds(100, 250, 100, 50);
        L1.setVisible(false);
        ImageIcon I1 = new ImageIcon("E:/SEM#3/OOPS/Book Stuff/Swing/Food Icons/noodles.png");
        J1 = new JButton();
        J1.setBounds(100, 100, 100, 100);
        this.add(J1);
        this.add(L1);
        J1.addActionListener(this);
        J1.setText("Cake");
        J1.setFocusable(false);
        J1.setIcon(I1);
        J1.setHorizontalTextPosition(JButton.CENTER);
        J1.setVerticalTextPosition(JButton.BOTTOM);
        J1.setFont(new Font("Comic Sans", Font.BOLD, 25));
        J1.setForeground(Color.DARK_GRAY);
        J1.setBackground(Color.LIGHT_GRAY);
        J1.setBorder(BorderFactory.createRaisedSoftBevelBorder());
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==J1)
        {
            
            System.out.println("bruh");
            Order[this.i++] = "Cake";
            L1.setVisible(true);
        }
    }
}

public class Frames
{
    public static void main(String[] args)
    {
        new alpha();
        // System.out.println((int)MAXIMIZED_BOTH);
    }    
}
