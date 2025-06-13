import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
public class BalanceInquiry extends JFrame implements ActionListener {

   private String PIN;
   JLabel iimage1;
   JButton back;
 

    BalanceInquiry(String PIN){
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

        JLabel heading = new JLabel("Your Current balance in Account is ");
        heading.setBounds(70, 160, 350, 25);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Arial", Font.BOLD, 17));
        iimage1.add(heading);

        double balance = 0.00;
        try {
            connection con = new connection();
            ResultSet resultSet= con.statement.executeQuery("select * from bankaccount where Pin = '"+PIN+"'");
            while (resultSet.next()) {
                if (resultSet.getString("Type").equals("Deposit")){
                balance += Double.parseDouble(resultSet.getString("Amount"));
                } else {
                balance-= Double.parseDouble(resultSet.getString("Amount"));
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        JLabel l1 = new JLabel("Rs. "+ balance);
        l1.setBounds(70, 190, 350, 25);
        l1.setForeground(Color.WHITE);
        l1.setFont(new Font("Arial", Font.BOLD, 17));
        iimage1.add(l1);

       

        back=new JButton("Back");
        back.setFont(new Font("Arial",Font.BOLD,20));
        back.setBackground(new Color(50,50,50));
        back.setForeground(Color.white);
        back.setBounds(300,380,140,30);
        back.addActionListener(this);
        iimage1.add(back);


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
            if(e.getSource()==back){
                new Dashboard(PIN);
                setVisible(false);
            }

        }
        catch(Exception E){
            E.printStackTrace();
        }
    }
}
