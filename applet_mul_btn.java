// <applet code = "applet_mul_btn.class" height = "500" width = "500"></applet>

import java.awt.*;
import java.awt.event.*;
import java.applet.*;
import java.util.*;

public class applet_mul_btn extends Applet implements ActionListener{

    String s;
    int c1;
    int c2;
    public void init(){
        Button b1 = new Button("btn1");
        Button b2 = new Button("btn2");
        Button b3 = new Button("btn3");
        Button b4 = new Button("btn4");

        this.add(b1);
        this.add(b2);
        this.add(b3);
        this.add(b4);

        b1.addActionListener(this);
        b2.addActionListener(this);
        b3.addActionListener(this);
        b4.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        s = e.getActionCommand();
        showStatus(s);
        if(s.equals("btn1")){
            showStatus(" counter 1 :: " + (++c1) + ", counter 2 ::" + c2);
        }
        else if(s.equals("btn2")){
            showStatus(" counter 1 :: " + c1 + ", counter 2 ::" + (++c2));
        }
        else if(s.equals("btn3")){
            c1 = 0;
            showStatus(" counter 1 :: " + c1 + ", counter 2 ::" + c2);
        }
        else if(s.equals("btn4")){
            c2 = 0;
            showStatus(" counter 1 :: " + c1 + ", counter 2 ::" + c2);
        }
    }
}