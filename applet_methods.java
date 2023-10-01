//<applet code = "applet_methods.class" height = "500" width = "500"></applet>

import java.awt.*;
import java.awt.event.*;
import java.applet.*;

public class applet_methods extends Applet{

    String msg = "hello";

    public void init(){
        msg = msg + "init";
        showStatus(msg);
    }
    
    public void start(){
        msg = msg + "start ";
        showStatus(msg);
    }
    
    public void stop(){
        msg = msg + "stop ";
        showStatus(msg);
    }
    
    public void destroy(){
        msg = msg + "destroy ";
        showStatus(msg);
    }
    public void paint(Graphics g){
        g.drawString(msg,50,50);
        g.drawRect(50,50,100,100);
        g.drawLine(50,50,150,150);
        g.drawLine(150,50,50,150);
    }
}