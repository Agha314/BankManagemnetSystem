import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.util.Random;
import javax.swing.*;
import javax.swing.JOptionPane;
import com.toedter.calendar.JDateChooser;

public class SignUp extends JFrame implements ActionListener{

    String label[]={"Name :","Father,s Name :","Date Of Birth :","Gender :","Email Address :","Marital Status :","Address :","City :","Province :"};
    int counter = 0;
    int y= 140;
    JTextField name,fName,email, address, city, province;
    JDateChooser DOB;
    JRadioButton r1,r2, ms1,ms2;
    JButton next,SignIn;
    Random ran = new Random();
    long fourDigits = (ran.nextLong()% 9000L)+1000L;
    private final String formNo = ""+Math.abs(fourDigits);

    
    public SignUp(){
        super("Bank Management System");
       

        // Logo
        ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("images/Logo1.png"));
        Image image1 = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
        ImageIcon iicon1 = new ImageIcon(image1);
        JLabel showImage1 = new JLabel(iicon1);
        showImage1.setBounds(35,20,100,100);
        add(showImage1);

        JLabel Pname = new JLabel("Form Number: "+ formNo);
        Pname.setForeground(Color.WHITE);
        Pname.setFont(new Font("Arial", Font.BOLD, 30));
        Pname.setBounds(150,20,300,40);
        add(Pname);

        JLabel details = new JLabel("(Personal Details)");
        details.setForeground(Color.WHITE);
        details.setFont(new Font("Arial", Font.BOLD,20));
        details.setBounds(210, 60, 180,30);
        add(details);

        while(counter <= 8){
            JLabel l = new JLabel(label[counter]);
            l.setForeground(Color.WHITE);
            l.setFont(new Font("Arial", Font.BOLD,16));
            l.setBounds(110, y, 150,20);
            add(l);
            y+=40;
            counter++;
        }

        name = new JTextField(25);
        name.setForeground(Color.BLACK);
        name.setFont(new Font("Arial", Font.BOLD,16));
        name.setBounds(200, 140, 250,20);
        add(name);

        fName =new JTextField(25);
        fName.setForeground(Color.BLACK);
        fName.setFont(new Font("Arial",Font.BOLD,16));
        fName.setBounds(240, 180,210,20);
        add(fName);

        DOB =new JDateChooser();
        DOB.setForeground(new Color(105,105,105));
        DOB.setFont(new Font("Arial",Font.BOLD,16));
        DOB.setBounds(230,220,220,20);
        add(DOB);

        r1 = new JRadioButton("Male");
        r1.setForeground(Color.BLACK);
        r1.setFont(new Font("Arial",Font.BOLD,13));
        r1.setBounds(240,260,100,20);
        add(r1);
        r2 = new JRadioButton("Female");
        r2.setForeground(Color.BLACK);
        r2.setFont(new Font("Arial",Font.BOLD,13));
        r2.setBounds(350,260,100,20);
        add(r2);
        ButtonGroup Bgroup = new ButtonGroup();
        Bgroup.add(r1);
        Bgroup.add(r2);

        email = new JTextField(25);
        email.setForeground(Color.BLACK);
        email.setFont(new Font("Arial", Font.BOLD,16));
        email.setBounds(240, 300, 210,20);
        add(email);

        ms1 = new JRadioButton("Married");
        ms1.setForeground(Color.BLACK);
        ms1.setFont(new Font("Arial",Font.BOLD,13));
        ms1.setBounds(240,340,100,20);
        add(ms1);
        ms2 = new JRadioButton("Unmarried");
        ms2.setForeground(Color.BLACK);
        ms2.setFont(new Font("Arial",Font.BOLD,13));
        ms2.setBounds(350,340,100,20);
        add(ms2);
        ButtonGroup Bgroup2 = new ButtonGroup();
        Bgroup2.add(ms1);
        Bgroup2.add(ms2);

        address = new JTextField(25);
        address.setForeground(Color.BLACK);
        address.setFont(new Font("Arial", Font.BOLD,16));
        address.setBounds(200, 380, 250,20);
        add(address);

        city = new JTextField(25);
        city.setForeground(Color.BLACK);
        city.setFont(new Font("Arial", Font.BOLD,16));
        city.setBounds(170, 420, 280,20);
        add(city);

        province = new JTextField(25);
        province.setForeground(Color.BLACK);
        province.setFont(new Font("Arial", Font.BOLD,16));
        province.setBounds(210, 460, 240,20);
        add(province);

        next = new JButton("Next");
        button(next, 300, 500);
        SignIn = new JButton("Sign In instead");
        button(SignIn, 110, 500);        

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
        setDefaultCloseOperation(EXIT_ON_CLOSE);
        setVisible(true);
    }

    public void button(JButton b, int x, int y){
        b.setFont(new Font("Arial",Font.BOLD,16));
        b.setBackground(new Color(50,50,50));
        b.setForeground(Color.white);
        b.setBounds(x,y,150,20);
        b.addActionListener(this);
        add(b);
    }
    
    @Override
    public void actionPerformed(ActionEvent e){

        try{
            if(e.getSource()==next){
                String FormNo = formNo;
                String Name = name.getText();
                String Fname= fName.getText();
                String Email = email.getText();
                String Address = address.getText();
                String City = city.getText();
                String Province = province.getText();
                String BirthDate = ((JTextField) DOB.getDateEditor().getUiComponent()).getText();
                String Gender = null;
                if (r1.isSelected()){
                    Gender = "Male";
                } else if (r2.isSelected()){
                    Gender = "Female";
                }
                String M_status = null;
                if (ms1.isSelected()){
                    M_status = "Married";
                }else if (ms2.isSelected()){
                    M_status = "Unmarried";
                }
                
                    if (name.getText().equals("")){
                        JOptionPane.showMessageDialog(null,"Please Fill All The Fields");
                    }else {
                        connection con1 = new connection();
                        String q = "insert into signup values('"+FormNo+"','"+Name+"','"+Fname+"','"+BirthDate+"','"+Gender+"','"+Email+"','"+M_status+"','"+Address+"','"+City+"','"+Province+"')";
                        con1.statement.executeUpdate(q);

                        new SignUp2(formNo);
                        setVisible(false);
                    }

                
            } else if (e.getSource()==SignIn){
                new Login();
                setVisible(false);
            }
           
        }catch(Exception E){
            E.printStackTrace();

        }
    } 
    
}
