import javax.swing.*;
import java.awt.event.ActionListener;
import java.sql.ResultSet;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
public class FastCash extends JFrame implements ActionListener{

    private String PIN;
    private JLabel iimage1;
    private JButton d1,d2,d3,w1,w2,w3,back;
    
    FastCash(String PIN){
        super("Bank Management System");
        this.PIN=PIN;
      
        //BACKGROUND IMAGE
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("images/ATM.jpg"));
        Image image1 = icon1.getImage().getScaledInstance(510, 653, Image.SCALE_DEFAULT);
        ImageIcon iicon1= new ImageIcon(image1);
        iimage1=new JLabel(iicon1);
        iimage1.setBounds(0,0,510, 653);
        add(iimage1);

        //LOGO
        ImageIcon icon2 = new ImageIcon(ClassLoader.getSystemResource("images/Logo.png"));
        Image image2 = icon2.getImage().getScaledInstance(75, 75, Image.SCALE_DEFAULT);
        ImageIcon iicon2 = new ImageIcon(image2);
        JLabel showImage2 = new JLabel(iicon2);
        showImage2.setBounds(220,20,75,75);
        iimage1.add(showImage2);

      
        JLabel heading = new JLabel("One click withdraw/deposit ");
        heading.setBounds(110, 150, 350, 30);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Arial", Font.BOLD, 22));
        iimage1.add(heading);

        d1=new JButton("Deposit 500");
        button(d1, 40, 220);
        w1 = new JButton("Withdraw 500");
        button(w1, 270, 220);
        d2=new JButton("Deposit 1000");
        button(d2, 40,280);
        w2 = new JButton("Withdraw 1000");
        button(w2,270,280);
        d3= new JButton("Deposit 10000");
        button(d3,40,340);
        w3 = new JButton("Withdraw 10000");
        button(w3,270,340);
        back = new JButton("Back");
        button(back, 270, 400);
       
        ImageIcon icon = new ImageIcon("src/images/icon.png");
        setIconImage(icon.getImage());
        setLayout(null);
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setSize(510, 653);
        setLocation(400, 50);
        setVisible(true);
    }
    public void button(JButton b, int x, int y){
        b.setFont(new Font("Arial",Font.BOLD,20));
        if(b==w3){
            b.setFont(new Font("Arial",Font.BOLD,18));
        }
        b.setBackground(new Color(50,50,50));
        b.setForeground(Color.white);
        b.setBounds(x,y,180,30);
        b.addActionListener(this);
        iimage1.add(b);
    }
    
  
    public void DepositMethod(String amount){
       
        try{
            connection con = new connection();
            con.statement.executeUpdate("insert into bankAccount values ('"+PIN+"','"+con.date()+"','Deposit','"+amount+"')");
            JOptionPane.showMessageDialog(null, "Amount Rs " + amount + " is successfully added.");
            new Dashboard(PIN);
            setVisible(false);
        }catch(Exception E){
            E.printStackTrace();
        }
           
    }
    public void WithdrawMethod(double amount){
        
                 try{
                 double balance=0.00;
                 connection con = new connection();
                 ResultSet resultSet = con.statement.executeQuery("select * from bankAccount where Pin = '"+PIN+"'");
                 while (resultSet.next()){
                    if (resultSet.getString("type").equals("Deposit")){
                        balance+=Double.parseDouble(resultSet.getString("Amount"));
                    }else{
                        balance-=Double.parseDouble(resultSet.getString("Amount"));
                    }
                 }
                 if (balance<amount){
                    JOptionPane.showMessageDialog(null, "Amount Rs "+amount+" is greater than the current balance.");
                    return;
                 }else{
                    con.statement.executeUpdate("insert into bankaccount values ('"+PIN+"','"+con.date()+"','Withdraw','"+amount+"')");
                    JOptionPane.showMessageDialog(null, "Amount Rs " + amount + " is successfully deducted.");
                    new Dashboard(PIN);
                    setVisible(false);

                 }
                }catch(Exception E){
                    E.printStackTrace();
                }
    }
    
    @Override
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==back){
                new Dashboard(PIN);
                setVisible(false);
            } else if (e.getSource()==d1){
                 DepositMethod("500.00");
            }else if (e.getSource()==d2){
                 DepositMethod("1000.00");
            }else if (e.getSource()==d3){
                 DepositMethod("10000.00");
            }else if (e.getSource()==w1){
                 WithdrawMethod(500.00);
            }else if (e.getSource()==w2){
                 WithdrawMethod(1000.00);
            } else if (e.getSource()==w3){
                 WithdrawMethod(10000.00);
            } 

        }catch(Exception E){
            E.printStackTrace();
        }
        
    }

}
