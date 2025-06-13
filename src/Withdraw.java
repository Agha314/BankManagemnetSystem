import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
public class Withdraw extends JFrame implements ActionListener{


    private String PIN;
    JLabel iimage1;
    JTextField amount;
    JButton Withdraw,back;

    
    Withdraw(String PIN){
        super("Bank Management System");
        this.PIN=PIN;
        //BACKGROUND IMAGE
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("images/ATM.jpg"));
        Image image1 = icon1.getImage().getScaledInstance(510,638, Image.SCALE_DEFAULT);
        ImageIcon iicon1= new ImageIcon(image1);
        iimage1=new JLabel(iicon1);
        iimage1.setBounds(0,0,510,638);
        add(iimage1);

        //LOGO
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("images/Logo.png"));
        Image image2 = icon2.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        ImageIcon iicon2 = new ImageIcon(image2);
        JLabel showImage2 = new JLabel(iicon2);
        showImage2.setBounds(220,20,75,75);
        iimage1.add(showImage2);

        ImageIcon icon3 = new ImageIcon(ClassLoader.getSystemResource("images/Cash.png"));
        Image image3=icon3.getImage().getScaledInstance(80,45,Image.SCALE_DEFAULT);
        ImageIcon iicon3= new ImageIcon(image3);
        JLabel showImage3= new JLabel(iicon3);
        showImage3.setBounds(360, 350, 80, 45);
        iimage1.add(showImage3);

        JLabel heading = new JLabel("Enter Amont You Want to Withdraw :");
        heading.setBounds(110, 130, 350, 30);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Arial", Font.BOLD, 20));
        iimage1.add(heading);

        amount = new JTextField(20);
        amount.setFont(new Font("Arial", Font.BOLD, 14));
        amount.setForeground(Color.BLACK);
        amount.setBounds(150, 170, 250, 25);
        iimage1.add(amount);

        Withdraw=new JButton("Withdraw");
        button(Withdraw, 110, 220);
        back=new JButton("Back");
        button(back, 290, 220);

        ImageIcon icon = new ImageIcon("src/images/icon.png");
        setIconImage(icon.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(510,638);
        setLocation(400, 50);
        setVisible(true);
    }
    public void button(JButton b, int x, int y){
        b.setFont(new Font("Arial",Font.BOLD,20));
        b.setBackground(new Color(50,50,50));
        b.setForeground(Color.white);
        b.setBounds(x,y,160,30);
        b.addActionListener(this);
        iimage1.add(b);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==back)
            {
                 new Dashboard(PIN);
                 setVisible(false);
            } else if (e.getSource()==Withdraw)
                    {   
                             String textwithdrawl = amount.getText();
                             if (textwithdrawl.isEmpty()){
                                JOptionPane.showMessageDialog(null,"Enter Amount for withdraw.");
                             }else {
                                connection con = new connection();
                                ResultSet resultSet = con.statement.executeQuery("select * from BankAccount where Pin = '"+PIN+"'");
                                double balance = 0;
                                while (resultSet.next()){
                                    if(resultSet.getString("type").equals("Deposit")){
                                        balance += Double.parseDouble(resultSet.getString("Amount"));
                                    }else{
                                        balance -= Double.parseDouble(resultSet.getString("Amount"));
                                    }
                                    if (balance <Double.parseDouble(textwithdrawl)){
                                        JOptionPane.showMessageDialog(null, "Balance is less than Rs "+ Double.parseDouble(textwithdrawl));
                                    }else {
                                        String query = "insert into BankAccount values('"+PIN+"','"+con.date()+"','Withdraw','"+textwithdrawl+"')"; 
                                        con.statement.executeUpdate(query);
                                        JOptionPane.showMessageDialog(null, "Amount is Succesfully withdrawl.");
                                        setVisible(false);
                                        new Dashboard(PIN);
                                    }
                                }
                             }
                        
                    }  

        }catch(Exception E){
            E.printStackTrace();
        }   
    }
}
