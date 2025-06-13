import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class Dashboard extends JFrame implements ActionListener{

    JLabel iimage1;
    private String PIN;
    JButton deposit,withdraw,fastCash,MiniStatement,pinChange,enquiry,logOut,exit;

    public void button(JButton b , int x, int y){
        b.setFont(new Font("Arial",Font.BOLD,20));
        if(b==enquiry){
            b.setFont(new Font("Arial",Font.BOLD,18));
        }
        b.setBackground(new Color(50,50,50));
        b.setForeground(Color.white);
        b.setBounds(x,y,180,35);
        b.addActionListener(this);
        iimage1.add(b);
    }
    public Dashboard(String PIN){
        super("Bank Management System");
        this.PIN=PIN;

        //BackGround
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("images/ATM.jpg"));
        Image image1 = icon1.getImage().getScaledInstance(510,638,Image.SCALE_DEFAULT);
        ImageIcon iicon1 = new ImageIcon(image1);
        iimage1=new JLabel(iicon1);
        iimage1.setBounds(0,0,510,638);
        add(iimage1);

        //Logo
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("images/Logo.png"));
        Image image2= icon2.getImage().getScaledInstance(75,75,Image.SCALE_DEFAULT);
        ImageIcon iicon2 = new ImageIcon(image2);
        JLabel iimage2 = new JLabel(iicon2);
        iimage2.setBounds(220,20,75,75);
        iimage1.add(iimage2);

        JLabel heading = new JLabel("Please Select your Transaction:");
        heading.setFont(new Font("Raleway",Font.BOLD,24));
        heading.setForeground(Color.WHITE);
        heading.setBounds(50,100,400,40);
        iimage1.add(heading);

        deposit = new JButton("Deposit");
        button(deposit,40, 220);

        withdraw = new JButton("Withdraw");
        button(withdraw,260,220);
       
        fastCash = new JButton("Fast Cash");
        button(fastCash,40, 280);

        MiniStatement = new JButton("MINI Statement");
        button(MiniStatement, 260, 280);

        enquiry = new JButton("Balance Enquiry");
        button(enquiry, 40, 340);

        pinChange = new JButton("PIN Change");
        button(pinChange,260, 340);

        logOut= new JButton("Log Out");
        button (logOut,40,400);

        exit = new JButton("Exit");
        button(exit, 260,400);

        ImageIcon icon = new ImageIcon("src/images/icon.png");
        setIconImage(icon.getImage());
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(510,638);
        setLocation(400,50);
        setVisible(true);
    }
    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if(e.getSource()==deposit){
                new Deposit(PIN);
                setVisible(false);
            }else if (e.getSource()==withdraw){
                new Withdraw(PIN);
                setVisible(false);
            } else if (e.getSource()==fastCash){
                new FastCash(PIN);
                setVisible(false);
            }else if (e.getSource()==MiniStatement){
                new MiniStatement(PIN);
                setVisible(false);
            }else if (e.getSource()==enquiry){
                new BalanceInquiry(PIN);
                setVisible(false);
            }else if (e.getSource()==pinChange){
                new PinChange(PIN);
                setVisible(false);
            }else if (e.getSource()==logOut){
                new Login();
                setVisible(false);
            }else if (e.getSource()==exit){
                System.exit(0);
            }
        }catch(Exception E){
            E.getStackTrace();
        }
    }
  
}
