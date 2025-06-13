import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Random;
public class SignUp2 extends JFrame implements ActionListener{

    String label[]={"Religion: ","Occupation: ","Education: ","Income","Nationality","NIC:","Card Number:","PIN:","Any Criminal Record:","Senior Citizen:"};
    int counter = 0;
    int y= 130;
    String formNo;
    JComboBox<String> box1,box2,box3,box4;
    JTextField income,nic; 
    JRadioButton r1,r2,r3,r4;
    final Random  ran = new Random();
    long fourDigits = (ran.nextLong()% 9000L)+1000L;
    private String pin = ""+Math.abs(fourDigits);
    long num2 = (long)(ran.nextDouble()*100_000_000_000L) + 100_000_000_000L;
    String cardno = ""+Math.abs(num2);
    JButton next;
    
   public SignUp2(String formNo){
    super("Bank Management System");
    this.formNo=formNo;
    //Logo
    ImageIcon icon1 = new ImageIcon(ClassLoader.getSystemResource("images/Logo1.png"));
    Image image1 = icon1.getImage().getScaledInstance(100, 100, Image.SCALE_DEFAULT);
    ImageIcon iicon1 = new ImageIcon(image1);
    JLabel showImage1 = new JLabel(iicon1);
    showImage1.setBounds(35,20,100,100);
    add(showImage1);

    JLabel heading=new JLabel("Page No 2.");
    heading.setFont(new Font("Releway", Font.BOLD,30));
    heading.setForeground(Color.BLACK);
    heading.setBounds(185,20,300,40);
    add(heading);

    JLabel addInfo = new JLabel("(Additional Info)");
    addInfo.setFont(new Font("Arial",Font.BOLD,24));
    addInfo.setForeground(Color.BLACK);
    addInfo.setBounds(165,60,300,35);
    add(addInfo);

    
    JLabel formNumber = new JLabel("Form Number:");
    formNumber.setFont(new Font("Arial",Font.BOLD,12));
    formNumber.setBounds(420,10,150,20);
    add(formNumber);
    JLabel formNu = new JLabel(formNo);
    formNu.setFont(new Font("Arial",Font.BOLD,12));
    formNu.setBounds(420,30,150,20);
    add(formNu);

    while(counter <= 9){
        JLabel l = new JLabel(label[counter]);
        l.setFont(new Font("Arial", Font.BOLD,16));
        l.setForeground(Color.white);
        l.setBounds(70, y, 150,20);
        add(l);
        if (counter == 8 ){
            l.setBounds(70, y, 190,20);
            y+=30;
        }
        
        y+=30;
        counter++;
    }

    String religion[] ={"Muslim","Hindu","Christian","Sikh","Other"};
    box1 =new JComboBox<>(religion);
    box1.setFont(new Font("Arial", Font.BOLD, 14));
    box1.setBounds(190, 130,250,20);
    add(box1);

    String Occupation[] ={"Below Rank 10 employee","Below Rank 16 employee","Upper Rank Employee","Private Employee","Self-Business","Un-Employed"};
    box2= new JComboBox<>(Occupation);
    box2.setFont(new Font("Arial", Font.BOLD,14));
    box2.setBounds(190, 160,250,20);
    add(box2);

    String Education[] ={"phd Doctor","Master","Bechlor/Graduate","BA","Intermediate/O level","Metric/A level","Primary Pass","Other","Un-Educated"};
    box3= new JComboBox<>(Education);
    box3.setFont(new Font("Arial", Font.BOLD,14));
    box3.setBounds(190, 190,250,20);
    add(box3);

    income = new JTextField(20);
    income.setFont(new Font("Arial", Font.BOLD,16));
    income.setBounds(190,220,250,20);
    add(income);
    
    String nationality[] ={"Pakistani","Dual-Nationality","Other"};
    box4= new JComboBox<>(nationality);
    box4.setFont(new Font("Arial", Font.BOLD,14));
    box4.setBounds(190, 250,250,20);
    add(box4);

    nic = new JTextField(20);
    nic.setFont(new Font("Arial", Font.BOLD,16));
    nic.setBounds(190,280,250,20);
    add(nic);

    JLabel cardX = new JLabel("XXXXXXXXXXXXX");
    cardX.setForeground(Color.WHITE);
    cardX.setFont(new Font("Arial",Font.BOLD,16));
    cardX.setBounds(190, 310, 250, 20);
    add(cardX);

    JLabel pinX = new JLabel("XXXX");
    pinX.setForeground(Color.WHITE);
    pinX.setFont(new Font("Arial", Font.BOLD,16));
    pinX.setBounds(190,340,250,20);
    add(pinX);

    r1=new JRadioButton("Yes");
    r1.setFont(new Font("Arial", Font.BOLD,14));
    r1.setBounds(190,400,120,20);
    add(r1);
    r2=new JRadioButton("No");
    r2.setFont(new Font("Arial",Font.BOLD,14));
    r2.setBounds(320,400,120,20);
    add(r2);
    ButtonGroup bgroup = new ButtonGroup();
    bgroup.add(r1);
    bgroup.add(r2);

    r3=new JRadioButton("Yes");
    r3.setFont(new Font("Arial", Font.BOLD,14));
    r3.setBounds(200,430,110,20);
    add(r3);
    r4=new JRadioButton("No");
    r4.setFont(new Font("Arial",Font.BOLD,14));
    r4.setBounds(320,430,120,20);
    add(r4);
    ButtonGroup bgroup2 = new ButtonGroup();
    bgroup2.add(r3);
    bgroup2.add(r4);

    next = new JButton("Next");
    next.setForeground(Color.WHITE);
    next.setFont(new Font("Releway",Font.BOLD,16));
    next.setBackground(new Color(50,50,50));
    next.setBounds(340,470,100,25);
    next.addActionListener(this);
    add(next);

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
    setLocation(400,50);
    setDefaultCloseOperation(EXIT_ON_CLOSE);
    setVisible(true);
   }
   @Override
   public void actionPerformed(ActionEvent e){
    try{
        if(e.getSource()==next){
            String Religion = (String) box1.getSelectedItem();
            String Occupation = (String) box2.getSelectedItem();
            String Education= (String) box3.getSelectedItem();
            String Income = income.getText();
            String Nationality = (String) box4.getSelectedItem();
            String NIC = nic.getText();
            String Criminal_record = null;
            if (r1.isSelected()){
                Criminal_record="Yes";
            } else if (r2.isSelected()){
                Criminal_record="No";
            }
            String citizen= null;
            if (r3.isSelected()){
                citizen="Yes";
            } else if (r4.isSelected()){
                citizen = "No";
            }

            if (nic.getText().equals("")||!(NIC.length()==13)){
                JOptionPane.showMessageDialog(null, "Enter Valid CNIC. \nCNIC must be in 13 characters.");
                
            }else {
                connection con1 = new connection();
                String q1 = "insert into signuptwo values ('"+formNo+"','"+Religion+"','"+Occupation+"','"+Education+"','"+Income+"','"+Nationality+"','"+NIC+"','"+cardno+"','"+pin+"','"+Criminal_record+"','"+citizen+"')";
                String q2  = "insert into login values ('"+cardno+"','"+pin+"')";

                con1.statement.executeUpdate(q1);
                con1.statement.executeUpdate(q2);
                JOptionPane.showMessageDialog(null,"Card Number: "+cardno+"\nPin: "+pin);
                new Deposit(pin);
                setVisible(false);
            }

           
        }

    }catch(Exception E){
        E.printStackTrace();
    }
   }
}
