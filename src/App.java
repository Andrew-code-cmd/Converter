import java.io.*;
import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.PrintWriter;
import java.text.DecimalFormat;

class MainFrame extends JFrame{
    MainFrame(){
        int w = 300, h = 200;
        setTitle("super converter");
        setBounds(100, 100, w, h);
        setDefaultCloseOperation(EXIT_ON_CLOSE);

        MainPanel panel = new MainPanel(w, h);
        add(panel);

        setResizable(false);
        setVisible(true);
    }
    
    public class MainPanel extends JPanel{

        MainPanel(int w, int h){

            setBounds(0, 0, w, h);
            setLayout(null);

            Font font = new Font("Calibri", Font.BOLD, 20);
            JLabel label = new JLabel("Конвертер валют");
            label.setFont(font);
            label.setVerticalAlignment(JLabel.TOP);
            label.setBounds(55, 10, 180, 100);
            add(label);

            JTextField rub = new JTextField(22);
            rub.setBounds(75, 45, 140, 20);
            add(rub);

            Font font2 = new Font("Calibri", Font.BOLD, 14);
            JLabel rublabel = new JLabel("рубли: ");
            rublabel.setFont(font2);
            rublabel.setBounds(10, 10, 200, 100);
            add(rublabel);

            JLabel dollabel = new JLabel("доллары: ");
            dollabel.setFont(font2);
            dollabel.setBounds(10, 40, 200, 100);
            add(dollabel);

            JTextField dol = new JTextField(22);
            dol.setBounds(75, 78, 140, 20);
            add(dol);

            JButton button = new JButton("конвертировать");
            button.setBounds(65, 110, 160, 30);
            button.addActionListener(new ActionListener(){
                public void actionPerformed(ActionEvent ae){
                    try{
                        FileOutputStream fileout = new FileOutputStream("C:\\Users\\user\\Desktop\\конвертер\\conv\\src\\учет.txt", true);
                        if(!rub.getText().equals("") && dol.getText().equals("")){
                            Double n = Double.parseDouble(rub.getText())/62.77;
                            String res = '\n'+new DecimalFormat("#0.00000").format(n);
                            dol.setText(res);

                            fileout.write(res.getBytes());
                            fileout.close();
                        }
                        else if(!dol.getText().equals("") && rub.getText().equals("")){
                            Double n = Double.parseDouble(dol.getText())*62.77;
                            String res ='\n'+new DecimalFormat("#0.00000").format(n);
                            rub.setText(res);

                            fileout.write(res.getBytes());
                            fileout.close();
                        }
                    }catch(Exception e){
                        JOptionPane.showMessageDialog(null, "Неправильный ввод данных");
                    }
                }
            });
            add(button);
        }
    }
}

public class App {
    public static void main(String[] args) throws Exception {
        new MainFrame();
    }
}
