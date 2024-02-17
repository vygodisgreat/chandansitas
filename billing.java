import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.*;
import java.util.*;

class BillFrame extends JFrame implements ActionListener{
    JButton JB[] = new JButton[2];
    int ary[] = new int[2];
    JLabel J;
    BillFrame()
    {
        ImageIcon image=new ImageIcon("bill.jpg");
        this.setIconImage(image.getImage());
        this.setVisible(true);

        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        this.setLayout(null);

        this.setExtendedState(MAXIMIZED_BOTH);

        this.setTitle("ChandanSita's Online Portal");

        this.setResizable(false);

        ImageIcon FAVICON = new ImageIcon("E:/SEM#3/OOPS/Book Stuff/Swing/favicon_io/icondis.png");
        this.setIconImage(FAVICON.getImage());

        this.getContentPane().setBackground(new Color(0xFFAAAA));

        for (int i=0; i<2; i++)
        {
            JB[i] = new JButton();
            this.add(JB[i]);
            JB[i].setBounds(100+(i*700),600,200,100);
            JB[i].addActionListener(this);
            JB[i].setFocusable(false);
            JB[i].setHorizontalTextPosition(JButton.CENTER);
            JB[i].setVerticalTextPosition(JButton.BOTTOM);
            JB[i].setFont(new Font("ROMALIKA", Font.ITALIC, 25));
            JB[i].setForeground(Color.DARK_GRAY);
            JB[i].setBackground(Color.LIGHT_GRAY);
            JB[i].setBorder(BorderFactory.createRaisedSoftBevelBorder());
            ary[i]=0;
        }


        ImageIcon ic = new ImageIcon("C:\\Users\\User\\Desktop\\BILLA.png");
        JB[0].setBounds(50,200,700,550);
        JB[0].setIcon(ic);
        JB[0].setText("MAKE BILL");

        ImageIcon I1 = new ImageIcon("C:\\Users\\User\\Desktop\\love.png");
        JB[1].setIcon(I1);
        JB[1].setBounds(760,200,650,550);
        JB[1].setText("PRINT BILL");
        
        J=new JLabel("May we have the bill/check, please?");
        J.setVisible(true);
        J.setBounds(10,10,2000,50);
        J.setFont(new Font("Algerian", Font.PLAIN, 60));
        this.add(J);


    }
    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource()==JB[0]){
            ary[0]++;
            if ((ary[0]%2)==1)
            {
                JB[0].setBackground(Color.GREEN);
                JB[0].setText("BIL CREATED");
                Scanner sc = new Scanner(System.in);
                System.out.println("ENTER THE NUMBER OF ITEMS IN THE BILL");
                int z= sc.nextInt();
                float cost=0;
                int arr1[]=new int[z];
                int arr2[]=new int[z];
                float arr3[]=new float[z];
                String arr4[]=new String[z];
                for(int i=0;i<z;i++) {
                    int p=i+1;
                    System.out.println("ENTER THE SR CODE OF THE " +p+ " ITEM");
                    arr1[i] = sc.nextInt();
                    System.out.println("ENTER THE NAME OF THE " +p+ " ITEM");
                    arr4[i]=sc.next();
                    System.out.println("ENTER THE QUANTITY OF " +p+ " ITEM");
                    arr2[i] = sc.nextInt();
                    System.out.println("ENTER THE PRICE OF THE " +p+ " QUANTITY");
                    arr3[i] = sc.nextFloat();
                    cost=(float)(cost+(arr2[i]*arr3[i]));
                }
                sc.close();
                System.out.println("BILL ADDED");
                try{
                    PrintWriter writer1 =null;
                    writer1 = new PrintWriter(new File("bill.txt"));
                    writer1.println("|SR NUMBER |  NAME   | QUANTITY |   COST     | TOTAL PRICES |");
                    for(int i=0;i<z;i++) {
                        writer1.println("|     " + arr1[i] + "    |    "+arr4[i]+"   |   " + arr2[i] + "     |     " + arr3[i] + "     |     " + arr2[i] * arr3[i] + "    |     ");
                    }
                    writer1.println("______________________________________");
                    writer1.println("TOTAL BILL");
                    writer1.println(   cost   );
                    writer1.flush();
                    writer1.close();

                }
                catch (Exception e1){
                    System.out.println("error");
                }


            }
            else
            {
                JB[0].setBackground(Color.LIGHT_GRAY);

            }




        }
        if (e.getSource()==JB[1]){
            ary[1]++;
            if ((ary[1]%2)==1)
            {
                JB[1].setBackground(Color.GREEN);

                JB[1].setText("BILL PRINTED");
                try
                {

                    FileInputStream fis=new FileInputStream("bill.txt");
                    Scanner sc=new Scanner(fis);

                    while(sc.hasNextLine())
                    {
                        System.out.println(sc.nextLine());
                    }
                    sc.close();
                }
                catch(IOException e3)
                {
                    e3.printStackTrace();
                }
                finally {
                    System.out.println("THANK YOU");
                }
            }
            else
            {
                JB[1].setBackground(Color.LIGHT_GRAY);

            }

        }
    }
}
class firstPage extends JFrame implements ActionListener
{
    JLabel L;
    JButton B;
    firstPage()
    {

        ImageIcon LOGO = new ImageIcon("E:/SEM#3/OOPS/Book Stuff/Swing/favicon_io/logo.png");
        B = new JButton();
        this.add(B);
        B.setIcon(LOGO);
        B.addActionListener(this);
        B.setFocusable(false);
        B.setText("WAIT FOR THE BILL....");
        B.setHorizontalTextPosition(JButton.CENTER);
        B.setVerticalTextPosition(JButton.BOTTOM);
        B.setFont(new Font("ROMALIKA", Font.BOLD, 60));
        B.setForeground(Color.RED);
        B.setBackground(new Color(0x1E1EB7));
        B.setIconTextGap(100);

        this.setVisible(true);
        ImageIcon FAVICON = new ImageIcon("E:/SEM#3/OOPS/Book Stuff/Swing/favicon_io/icondis.png");
        this.setIconImage(FAVICON.getImage());
        this.getContentPane().setBackground(new Color(0xBB4141));
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setTitle("Loading...");
        this.setResizable(false);
    }

    @Override
    public void actionPerformed(ActionEvent e)
    {
        if (e.getSource()==B)
        {
            dispose();
            new BillFrame();
        }
    }
}

public class billing{
    public static void main(String args[])
    {
        new firstPage();
    }
}