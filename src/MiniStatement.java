import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.Image;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.sql.ResultSet;
public class MiniStatement extends JFrame implements ActionListener {
    private String PIN;
   
    JLabel iimage1;
    JButton back;
    MiniStatement(String PIN) {
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

        JLabel heading = new JLabel("PIN      DATE                  TYPE       AMOUNT" );
        heading.setBounds(90, 180, 350, 20);
        heading.setForeground(Color.WHITE);
        heading.setFont(new Font("Arial", Font.BOLD, 14));
        iimage1.add(heading);

        JLabel [] label = null;
        String [] values = null;
        try {

            connection con = new connection();
            ResultSet resultSet1 = con.statement.executeQuery("Select * from bankaccount where Pin = '"+PIN+"'");
            int rowCount = 0;
            while (resultSet1.next()) {
                rowCount++;
            }
            //resultSet.beforeFirst();
            label = new JLabel[rowCount];
            values =new String[rowCount];
            ResultSet resultSet2 = con.statement.executeQuery("Select * from bankaccount where Pin = '"+PIN+"'");

            int counter= 0;
            while (resultSet2.next()){
                values[counter] = ""+resultSet2.getString("Pin")+"     "+resultSet2.getString("Date")+"     "+resultSet2.getString("Type")+"            "+resultSet2.getString("Amount");
               counter++;
            }
        }catch (Exception E){
            E.printStackTrace();
            
        }
        
        int y = 200;
        for (int i=0; i<values.length; i++){
        label[i]= new JLabel();
        label[i].setText(i+1+"  "+values[i]);
        label[i].setBounds(80, y, 450, 20);
        label[i].setForeground(Color.WHITE);
        label[i].setFont(new Font("Arial", Font.BOLD, 10));
        iimage1.add(label[i]);
        y+=20;
       }

        back=new JButton("Back");
        back.setFont(new Font("Arial",Font.BOLD,20));
        back.setBackground(new Color(50,50,50));
        back.setForeground(Color.white);
        back.setBounds(280,500,170,25);
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
    public void actionPerformed(ActionEvent e) {
        try{
            if(e.getSource()==back){
                setVisible(false);
                new Dashboard(PIN);   

            }


        }catch(Exception E){
            E.printStackTrace();
        }
    }
}
