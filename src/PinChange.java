import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPasswordField;

//import java.awt.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
public class PinChange extends JFrame implements ActionListener {
    private String PIN;
    JPasswordField p1, p2;
    JLabel iimage1;
    JButton changeButton,back;

    PinChange(String PIN){
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

        JLabel label = new JLabel("Do You want to change the PIN?");
        label.setBounds(130, 130, 350, 30);
        label.setForeground(Color.WHITE);
        label.setFont(new Font("Arial", Font.BOLD, 20));
        iimage1.add(label);

        JLabel label2 = new JLabel("Enter 4 digit Pin.");
        label2.setFont(new Font("Arial", Font.BOLD,15));
        label2.setForeground(Color.WHITE);
        label2.setBounds(130, 180, 200, 25);
        iimage1.add(label2);

        JLabel label3 = new JLabel("New Pin:");
        label3.setForeground(Color.white);
        label3.setFont(new Font("Arial",Font.BOLD,18));
        label3.setBounds(130,230,250,25);
        iimage1.add(label3);

        p1 = new JPasswordField(20);
        p1.setBackground(new Color(50,50,50));
        p1.setForeground(Color.WHITE);
        p1.setFont(new Font("Arial",Font.BOLD,18));
        p1.setBounds(230,230,180,25);
        iimage1.add(p1);

        JLabel label4 = new JLabel("Re-Enter:");
        label4.setFont(new Font("Arial",Font.BOLD,18));
        label4.setForeground(Color.white);
        label4.setBounds(130,280,250,25);
        iimage1.add(label4);

        p2 = new JPasswordField(20);
        p2.setBackground(new Color(50,50,50));
        p2.setForeground(Color.WHITE);
        p2.setFont(new Font("Arial",Font.BOLD,18));
        p2.setBounds(230,280,180,25);
        iimage1.add(p2);

        changeButton=new JButton("Change PIN");
        changeButton.setFont(new Font("Arial",Font.BOLD,20));
        changeButton.setBackground(new Color(50,50,50));
        changeButton.setForeground(Color.white);
        changeButton.setBounds(330,400,150,30);
        changeButton.addActionListener(this);
        iimage1.add(changeButton);

        back=new JButton("Back");
        back.setFont(new Font("Arial",Font.BOLD,20));
        back.setBackground(new Color(50,50,50));
        back.setForeground(Color.white);
        back.setBounds(330,440,150,30);
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
            String password1 = p1.getText();
            String password2 = p2.getText();
            
            if (e.getSource()==changeButton){
                if (!password1.equals(password2)){
                    JOptionPane.showMessageDialog(null, "Please match both pins.");
                }else{
                    connection con = new connection();
                    String q1 = "Update bankAccount set Pin = '"+password1+"'";
                    String q2 = "Update login set Pin = '"+password1+"' ";
                    String q3 = "Update signuptwo set Pin = '"+password1+"'";
                    
                    con.statement.executeUpdate(q1);
                    con.statement.executeUpdate(q2);
                    con.statement.executeUpdate(q3);

                    JOptionPane.showMessageDialog(null,"PIN is changes Successfuly.");
                    setVisible(false);
                    new Dashboard(password1);
                }

            } else  if (e.getSource()==back){
                new Dashboard(PIN);
                setVisible(false); 
                }

        }
        catch(Exception E){
            E.printStackTrace();
        }
    }  
}
