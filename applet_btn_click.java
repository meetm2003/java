//<applet code = "applet_btn_click.class" height = "500" width = "500"> </applet>
import java.util.*;
import java.applet.*;
import java.awt.*;
import java.awt.event.*;

public class applet_btn_click extends Applet implements ActionListener{

    int c1 = 0;
    int c2 = 0;
    String s;
    public void init(){
        Button b = new Button("B1");
        Button b1 = new Button("B2");
        this.add(b);
        this.add(b1);
        b.addActionListener(this);
        b1.addActionListener(this);
    }
    public void actionPerformed(ActionEvent e){
        s = e.getActionCommand();
        showStatus(s);
        if(s.equals("B1")){
            showStatus("Counter 1 "+ (++c1) + " ");
        }
        if(s.equals("B2")){
            showStatus("Counter 2 "+ (++c2));
        }
    } 
}