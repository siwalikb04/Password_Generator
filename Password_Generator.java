import java .awt.*;
import java.awt.datatransfer.Clipboard;
import java.awt.datatransfer.StringSelection;
import java.awt.event.*;
//import java.util.Arrays;
import java.util.*;
import javax.swing.*;

/* Needed if Lambda Function is not Implemented 
 * import javax.swing.event.ChangeEvent;
 * import javax.swing.event.ChangeListener;
 */



class Password_Generator{
    static int sliderValue;
    static String radioButtonOption;
    public static void main(String...args){
        JFrame jf = new JFrame();
        jf.setSize(800,600);
        jf.setLocationRelativeTo(null);
        jf.setDefaultCloseOperation(1);
        jf.setTitle("Password Generator");
        ImageIcon imageIcon1 = new ImageIcon("C:/Users/siwal/Downloads/icons8-password-100.png","Password Generator Icon");
        jf.setIconImage(imageIcon1.getImage());

        GridLayout layout = new GridLayout(4, 1);
        JPanel mainPanel=new JPanel(layout);

        JPanel panel1 =new JPanel(new GridLayout(2,1));
        JPanel subPanel1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel2 = new JPanel(new GridLayout(2,1));
        JPanel subPanel2= new JPanel(new FlowLayout(FlowLayout.CENTER));
        //subPanel2.setLayout(new BoxLayout(subPanel2,BoxLayout.X_AXIS));
        //subPanel2.add(Box.createHorizontalGlue());
        JPanel panel3 =new JPanel(new GridLayout(3,1));
        JPanel subPanel3_1 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel subPanel3_2 = new JPanel(new FlowLayout(FlowLayout.CENTER));
        JPanel panel4 =new JPanel(new GridLayout(2,1));
        JPanel subPanel4=new JPanel(new FlowLayout(FlowLayout.CENTER));

        JLabel label1 =new JLabel("Adjust the length of your Password you want to generate", SwingConstants.CENTER);
        JLabel label2= new JLabel("Choose the strength of the password to be generated",SwingConstants.CENTER);
        JLabel label3= new JLabel("PASSWORD: ",SwingConstants.CENTER);
        JLabel label4= new JLabel("*Click Generate to Generate your Password*   *Reset to reset the entire module*",SwingConstants.CENTER);


        JSlider slider = new JSlider(JSlider.HORIZONTAL, 8,24,10);
        slider.setMinorTickSpacing(1);
        slider.setMajorTickSpacing(2);
        slider.setPaintLabels(true);
        slider.setPaintTicks(true);
        slider.setForeground(Color.getHSBColor(0.4f, 0.4f, .4f));
        panel1.add(label1);
        subPanel1.add(slider);
        panel1.add(subPanel1);

        JRadioButton r1=new JRadioButton("Normal");
        JRadioButton r2=new JRadioButton("Strong");
        JRadioButton r3=new JRadioButton("Stronger");
        JRadioButton r4=new JRadioButton("Unbeatable");
        ///r1.setBounds(75,50,100,30);
        //r2.setBounds(85, 50, 100, 30);
        r1.setFocusPainted(false);
        r2.setFocusPainted(false);
        r3.setFocusPainted(false);
        r4.setFocusPainted(false);

        ButtonGroup bg = new ButtonGroup();
        bg.add(r1);
        bg.add(r2);
        bg.add(r3);
        bg.add(r4);
        panel2.add(label2);
        subPanel2.add(r1);
        //subPanel2.add(Box.createRigidArea(new Dimension(30, 0)));
        subPanel2.add(r2);
        //subPanel2.add(Box.createRigidArea(new Dimension(30, 0)));
        subPanel2.add(r3);
        //subPanel2.add(Box.createRigidArea(new Dimension(30, 0)));
        subPanel2.add(r4);
        //subPanel2.add(Box.createRigidArea(new Dimension(30, 0)));
        //subPanel2.add(Box.createHorizontalGlue());
        panel2.add(subPanel2);

        JTextField t = new JTextField("Password To be GENERATED",24);
        t.setHorizontalAlignment(JTextField.CENTER);
        t.setMargin(new Insets(10, 200, 10, 200));
        ImageIcon imageIcon2 = new ImageIcon("C:/Users/siwal/Downloads/icons8-copy-96.png","COPY PASSWORD");
        ImageIcon copyButtonImageIcon = new ImageIcon(imageIcon2.getImage().getScaledInstance(30, 30, Image.SCALE_SMOOTH));
        JButton copyButton = new JButton(copyButtonImageIcon);
        copyButton.setSize(90, 90);
        copyButton.setFocusPainted(false);
        copyButton.setVisible(false);
        panel3.add(label3);
        subPanel3_1.add(t);
        panel3.add(subPanel3_1);
        subPanel3_2.setSize(90, 90);
        subPanel3_2.add(copyButton);
        panel3.add(subPanel3_2);



        JButton gButton = new JButton();
        JButton rButton = new JButton("RESET");
        gButton.setText("GENERATE");
        gButton.setMargin(new Insets(10, 20, 10, 20));
        gButton.setFont(new Font("Arial", Font.BOLD, 16));
        gButton.setForeground(Color.GREEN);
        gButton.setBackground(Color.white);
        gButton.setFocusPainted(false);
        rButton.setFont(new Font("Arial", Font.BOLD, 16));
        rButton.setMargin(new Insets(10, 20, 10, 20));        
        rButton.setForeground(Color.white);
        rButton.setBackground(Color.RED);
        rButton.setFocusPainted(false);
        subPanel4.add(gButton);
        subPanel4.add(rButton);
        panel4.add(label4);
        panel4.add(subPanel4);

        mainPanel.add(panel1);
        mainPanel.add(panel2);
        mainPanel.add(panel3);
        mainPanel.add(panel4);
        jf.add(mainPanel);
        
        // slider.addChangeListener(new ChangeListener() {
        //     @Override
        //     public void stateChanged(ChangeEvent e){
        //         JSlider source = (JSlider) e.getSource();
        //         if(!source.getValueIsAdjusting()){
        //             sliderValue = source.getValue();
        //         }
        //     }
        // });

        
        slider.addChangeListener(e->{
            JSlider source = (JSlider) e.getSource();
            sliderValue=source.getValue();
        });

        r1.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e){
                radioButtonOption="normal";
            }
        });
        r2.addActionListener(e->{
            radioButtonOption="strong";
        });
        r3.addActionListener(e->{
            radioButtonOption="strongest";
        });
        r4.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e){
                radioButtonOption="unbeatable";
            }
        });

        gButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e){
            System.out.println("Generate Button Clicked\n");
            t.setText((sliderValue>=8)?generatePassword(sliderValue):generatePassword(10));
            copyButton.setVisible(true);
           } 
        });

        rButton.addActionListener(e->{
                System.out.println("Reset Button Clicked");
                bg.clearSelection();
                slider.setValue(10);
                t.setText(generatePassword(0));
                radioButtonOption=null;
                copyButton.setVisible(false);
        });

        copyButton.addActionListener(e->{
            if(!t.getText().equals("Please select STRENGTH...")){
                StringSelection stringSelection = new StringSelection(t.getText());
                Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
                clipboard.setContents(stringSelection, null);
                JOptionPane.showMessageDialog(jf, "Password Copied Successfully");
                System.out.println("Password Copied...!");
            }
            else
                JOptionPane.showMessageDialog(jf, "Please generate a password before copying. Click the 'Generate' button to create a password, before you copy it");
        });

        jf.setVisible(true);
    }
    static String Arr[][] = {
        { "a", "b", "c", "d", "e","f","g","h","i","j","k","l","m","n","o","p","q","r","s","t","u","v","w","x","y","z"},
        { "1", "2", "3", "4","5","6","7","8","9","0" },
        { "A", "B", "C", "D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z" },
        { "!", "@", "#", "$","%","^","&","*","(",")","-","=","+","<",">",",",".",";",":","/","?","\\","|","{","}","[","]","~","`","_"} };
    static String passArrF[];
    static String generatePassword(int n){
        if(n!=0)
            passArrF=new String[n];
        else
            return "RESET SUCCESSFUL";
        Arrays.fill(passArrF, "-1");
        String choice=(radioButtonOption==null)?"No Choice":radioButtonOption;
        switch (choice) {
            case "normal":
                normal(n);
                return displayPassword(passArrF);
            case "strong":
                // increase the value of rand1 for each row, use conditional statement, and it'll be done
                strong(n);
                return displayPassword(passArrF);
            case "strongest":
                strongest(n);
                return displayPassword(passArrF);
            case "unbeatable":
                unbeatable(n);
                return displayPassword(passArrF);
            default:
                System.out.println("\n\nCHOICE DOESN'T EXISTS\nPlease Try Again");
                //strengthPassword(n);
                break;
        }
        return "Please select STRENGTH...";
    }
    static String displayPassword(String arr[]){
        String s="";
        for (String i: arr)
            s+=i;
        return s;
    }
    static void normal(int n){
	    int j = 0;
        for (int i = 0; i < n; i++) {
            int rand1 = (int) ((Math.random() * 4));
            int rand2 = 0;
            do {
                rand2 = (int) ((Math.random() * n));
            } while (!(passArrF[rand2].equals("-1")));
            passArrF[rand2] = Arr[j][rand1];
            if (++j == 4)
                j = 0;
        }
    }
    static void strong(int n){
        int j = 0,rand1=0;
        for (int i = 0; i < n; i++) {
            if(j==0)
                rand1 = (int) ((Math.random() * 13));
            else if(j==1)
                rand1 = (int) ((Math.random() * 7));
            else if(j==2)
                rand1 = (int) ((Math.random() * 13));
            else
                rand1 = (int) ((Math.random() * 17));
            int rand2 = 0;
            do {
                rand2 = (int) ((Math.random() * n));
            } while (!(passArrF[rand2].equals("-1")));
            passArrF[rand2] = Arr[j][rand1];
            if (++j == 4)
            j = 0;
        }
    }
    static void strongest(int n){
        int j = 0,rand1=0;
        for (int i = 0; i < n; i++) {
            if(j==0)
                rand1 = (int) ((Math.random() * 26));
            else if(j==1)
                rand1 = (int) ((Math.random() * 10));
            else if(j==2)
                rand1 = (int) ((Math.random() * 26));
            else 
                rand1 = (int) ((Math.random() * 30));
            int rand2 = 0;
            do {
                    rand2 = (int) ((Math.random() * n));
            } while (!(passArrF[rand2].equals("-1")));
            passArrF[rand2] = Arr[j][rand1];
            if (++j == 4)
                j = 0;
        }
    }
    static void unbeatable(int n){
        int rand1;
        for(int i=0;i<n;i++){
            do{
                if(i%4==0)
                    rand1=(int)((Math.random()*26));
                else if(i%4==1)
                    rand1=(int)((Math.random()*10));
                else if(i%4==2)
                    rand1=(int)((Math.random()*26));
                else 
                    rand1=(int)((Math.random()*30));
            }while(Arrays.asList(passArrF).contains(Arr[i%4][rand1]));
            int rand2;
            do{
                rand2=(int)(Math.random()*n);
            }while(!(passArrF[rand2].equals("-1")));
            passArrF[rand2]=Arr[i%4][rand1];
        }
    }
}
