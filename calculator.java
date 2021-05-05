import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class calculator implements ActionListener {
    JFrame frame;
    JTextField tf;
    JButton[] numberButtons=new JButton[10];
    JButton[] funcButtons=new JButton[9];
    JButton add,sub,mult,div;
    JButton dec,equal,clr,del,neg;
    JPanel panel;
    Font f=new Font("Candara Light",Font.BOLD,30);
    double n1=0,n2=0,res=0;
    char op;

    public calculator() {
        frame=new JFrame("Simple Calculator");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(420,550);
        frame.setLayout(null);

        tf=new JTextField();
        tf.setBounds(50,25,300,50);
        tf.setFont(f);
        tf.setBackground(Color.WHITE);
        tf.setEditable(false);

        add=new JButton("+");
        sub=new JButton("-");
        mult=new JButton("*");
        div=new JButton("/");
        dec=new JButton(".");
        equal=new JButton("=");
        del=new JButton("Del");
        clr=new JButton("Clr");
        neg=new JButton("(-)");

        funcButtons[0]=add;
        funcButtons[1]=sub;
        funcButtons[2]=mult;
        funcButtons[3]=div;
        funcButtons[4]=dec;
        funcButtons[5]=equal;
        funcButtons[6]=del;
        funcButtons[7]=clr;
        funcButtons[8]=neg;

        for (int i = 0; i <9; i++) {
            funcButtons[i].addActionListener(this);
            funcButtons[i].setFont(f);
            funcButtons[i].setFocusable(false);


        }

        for (int i = 0; i <10 ; i++) {
            numberButtons[i]=new JButton(String.valueOf(i));
            numberButtons[i].addActionListener(this);
            numberButtons[i].setFont(f);
            numberButtons[i].setFocusable(false);

        }
        neg.setBounds(50,430,100,50);
        del.setBounds(150,430,100,50);
        clr.setBounds(250,430,100,50);

        panel=new JPanel();
        panel.setBounds(50,100,300,300);
        panel.setLayout(new GridLayout(4,4,10,10));
        panel.setBackground(Color.GRAY);
        panel.add(numberButtons[1]);
        panel.add(numberButtons[2]);
        panel.add(numberButtons[3]);
        panel.add(add);
        panel.add(numberButtons[4]);
        panel.add(numberButtons[5]);
        panel.add(numberButtons[6]);
        panel.add(sub);
        panel.add(numberButtons[7]);
        panel.add(numberButtons[8]);
        panel.add(numberButtons[9]);
        panel.add(mult);
        panel.add(dec);
        panel.add(numberButtons[0]);
        panel.add(equal);
        panel.add(div);








        frame.add(panel);
        frame.add(neg);
        frame.add(del);
        frame.add(clr);
        frame.add(tf);
        frame.setVisible(true);



    }

    public static void main(String[] args) {
          calculator cal=new calculator();
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        for (int i = 0; i <10 ; i++) {
            if(e.getSource()==numberButtons[i])
            {
                tf.setText(tf.getText().concat(String.valueOf(i)));
            }

        }
        if(e.getSource()==dec)
        {
            tf.setText(tf.getText().concat("."));
        }
        if(e.getSource()==add)
        {
            n1=Double.parseDouble(tf.getText());
            op='+';
            tf.setText("");
        }
        if(e.getSource()==sub)
        {
            n1=Double.parseDouble(tf.getText());
            op='-';
            tf.setText("");
        }
        if(e.getSource()==mult)
        {
            n1=Double.parseDouble(tf.getText());
            op='*';
            tf.setText("");
        }
        if(e.getSource()==div)
        {
            n1=Double.parseDouble(tf.getText());
            op='/';
            tf.setText("");
        }
        if(e.getSource()==equal)
        {
            n2=Double.parseDouble(tf.getText());
            switch (op)
            {
                case'+':
                    res=n1+n2;
                    break;
                case'-':
                    res=n1-n2;
                    break;
                case'*':
                    res=n1*n2;
                    break;
                case'/':
                    res=n1/n2;
                    break;

            }
            tf.setText(String.valueOf(res));
            n1=res;
        }
        if(e.getSource()==clr)
        {
          tf.setText("");
        }
        if(e.getSource()==del)
        {
            String s=tf.getText();
            tf.setText("");
            for (int i = 0; i <s.length()-1; i++) {
                tf.setText(tf.getText()+s.charAt(i));

            }
        }
        if(e.getSource()==neg)
        {
            double temp=Double.parseDouble(tf.getText());
            temp=temp*(-1);
            tf.setText(String.valueOf(temp));

            }
        }
    }


