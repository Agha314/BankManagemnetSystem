
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import javax.swing.*;
public class Login extends JFrame implements ActionListener{
    

    JLabel label1, label2, label3;
    JTextField tField2;
    private JPasswordField pField3;
    JButton b1,b2,b3;
    Login(){
        super("Bank Management System");

     
        //logo
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("images/Logo2.png"));
        Image image1=icon1.getImage().getScaledInstance(130,130,Image.SCALE_DEFAULT);
        ImageIcon iicon1= new ImageIcon(image1);
        JLabel ShowImage1= new JLabel(iicon1);
        ShowImage1.setBounds(210, 10, 130, 130);
        add(ShowImage1);

        //Welcome text
        label1= new JLabel("WELCOME TO MY BANK");
        label1.setForeground(Color.WHITE);
        label1.setFont(new Font("AvantGrade",Font.BOLD,25));
        label1.setBounds(130, 160, 350, 35);
        add(label1);

        //CARD Number
        label2 = new JLabel("Card Number: ");
        label2.setForeground(Color.WHITE);
        label2.setFont(new Font("Ralway", Font.BOLD, 18));
        label2.setBounds(135, 210, 150, 25);
        add(label2);

        tField2 = new JTextField(16);
        tField2.setForeground(Color.BLACK);
        tField2.setFont(new Font("Arial", Font.BOLD, 15));
        tField2.setBounds(280,210,180,20);
        add(tField2);
        
        //PIN
        label3= new JLabel("PIN :");
        label3.setForeground(Color.WHITE);
        label3.setFont(new Font("Ralway", Font.BOLD, 18));
        label3.setBounds(135, 250,150,20);
        add(label3);

        pField3 = new JPasswordField("16");
        pField3.setText("");
        pField3.setForeground(Color.BLACK);
        pField3.setFont(new Font("Arial", Font.BOLD, 14));
        pField3.setBounds(230, 250,230,20);
        add(pField3);
       
        //Buttons
        b1 = new JButton("SIGN IN");
        b1.setForeground(Color.WHITE);
        b1.setBackground(new Color(50,50,50));
        b1.setFont(new Font("Arial", Font.BOLD,14));
        b1.setBounds(135, 300, 140,25);
        b1.addActionListener(this);
        add(b1);

        b2 = new JButton("CLEAR");
        b2.setForeground(Color.WHITE);
        b2.setBackground(new Color(50,50,50));
        b2.setFont(new Font("Arial", Font.BOLD, 14));
        b2.setBounds(320, 300, 140, 25);
        b2.addActionListener(this);
        add(b2);

        b3 = new JButton("SIGN UP");
        b3.setForeground(Color.WHITE);
        b3.setBackground(new Color(50,50,50));
        b3.setFont(new Font("Arial", Font.BOLD, 14));
        b3.setBounds(135,350, 320,25 );
        b3.addActionListener(this);
        add(b3);

        //Side Icon
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("images/Cash.png"));
        Image image2=icon2.getImage().getScaledInstance(75,50,Image.SCALE_DEFAULT);
        ImageIcon iicon2= new ImageIcon(image2);
        JLabel ShowImage2= new JLabel(iicon2);
        ShowImage2.setBounds(360, 400, 75,50);
        add(ShowImage2);

        //Background
        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("images/background.png"));
        Image image3=icon3.getImage().getScaledInstance(512,768,Image.SCALE_DEFAULT);
        ImageIcon iicon3= new ImageIcon(image3);
        JLabel ShowImage3= new JLabel(iicon3);
        ShowImage3.setBounds(0, 0, 512,768);
        add(ShowImage3);


        ImageIcon icon = new ImageIcon("src/images/icon.png");
        setIconImage(icon.getImage());
        setLayout(null);
        setSize(512,768);
        setLocation(400, 50);
        setVisible(true);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
    }

    @Override
    public void actionPerformed(ActionEvent e){
        try{
            if (e.getSource()==b1){
                connection con = new connection();
                String cardNo = tField2.getText();
                String PIN = pField3.getText();
                String q = "select * from login where card_no = '"+cardNo+"' and Pin = '"+PIN+"'";
                ResultSet resultSet = con.statement.executeQuery(q);
                if(resultSet.next()){
                    setVisible(false);
                    new Dashboard(PIN);
                }else {
                    JOptionPane.showMessageDialog(null, "Invalid Card Number or PIN");
                }
            }else if(e.getSource()==b2){
                   tField2.setText("");
                   pField3.setText(""); 
            }else if(e.getSource()==b3){
                new SignUp();
                setVisible(false);
            }

        }catch(Exception E){
        }
    }

}