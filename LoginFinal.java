
import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;


class Lgf extends JFrame implements ActionListener 

{
   
    JLabel userLabel = new JLabel("USERNAME:");
    JLabel welcome = new JLabel("WELCOME TO CHANDANSITA'S");
    JLabel intro = new JLabel("Please provide us with your details!");
    JTextField userTextField = new JTextField();
    JButton loginButton = new JButton();
    String name = "";
    boolean p;
    static String s;

    Lgf() 
    {
        this.setExtendedState(MAXIMIZED_BOTH);
        this.setVisible(true);
        this.setLayout(null);
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setResizable(true);
        this.setTitle("ChandanSita's Login Portal");
        ImageIcon FAVICON = new ImageIcon("E:/SEM#3/OOPS/Book Stuff/Swing/favicon_io/icondis.png");
        this.setIconImage(FAVICON.getImage());
        this.getContentPane().setBackground(Color.pink);
        
        setLocationAndSize();
        addComponents();
        addActionEvent();
        miscellaneous();
    }


    public void setLocationAndSize() 
    {
        userLabel.setBounds(520, 250, 300, 50);
        userLabel.setFont(new Font("ROMALIKA", Font.ITALIC, 60));
        welcome.setBounds(250, 80, 1200, 80);
        welcome.setFont(new Font("ROMALIKA", Font.BOLD, 100));
        userTextField.setBounds(850, 250, 300, 50);
        loginButton.setBounds(310, 350, 1000, 500);
        loginButton.setFocusable(false);
    }

    public void addComponents() 
    
    {
        // Lgf
        this.add(userLabel);
        this.add(welcome);
        this.add(userTextField);
        this.add(loginButton);
        this.add(intro);
    }

    public void addActionEvent() 
    {
        loginButton.addActionListener(this);
    }

    public void miscellaneous() 
    {

        ImageIcon lg = new ImageIcon("E:/SEM#3/OOPS/Book Stuff/Swing/Food Icons/n1.png");
        loginButton.setIcon(lg);
        loginButton.setBorder(BorderFactory.createLineBorder(Color.black, 10, true));

    }

    static File f;

    @Override
    public void actionPerformed(ActionEvent e)

    {
        if (e.getSource() == loginButton)
        {
            name = userTextField.getText();
            System.out.println(name);
            s = name;
            if (name.isEmpty())
            {
                JOptionPane.showMessageDialog(this, "The name seems to be empty!", "Invalid Name Input",
                        JOptionPane.ERROR_MESSAGE);
            }

            else
            {
                String fname = name + ".txt";
                f = new File(fname);

                if (f.exists())
                
                {
                    JOptionPane.showMessageDialog(this,
                            "The user " + name + " is already registered in our Database, Welcome!", "User Found!",
                            JOptionPane.INFORMATION_MESSAGE);
                    
                            p = false;
                }

                else
                {
                    JOptionPane.showMessageDialog(this, "The user " + name + " is a new Customer, Welcome!",
                            "Creating Entry...", JOptionPane.PLAIN_MESSAGE);
                    p = true;

                    try
                    {

                        BufferedWriter bw = new BufferedWriter(new FileWriter(f));
                        bw.write(""); // true to append, false or nothing to rewrite
                        bw.close();
                    }
                    catch (IOException exc)
                    {
                        System.out.println("Error!");
                    }
                }

                dispose();
                new Loading();
            }
        }
    }
}

public class LoginFinal
{
    public static void main(String[] args)
    {
        new Lgf();
    }
}
