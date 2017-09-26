import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;


public class MainFrame extends Frame {
    private Label lab= new Label("33333");
    private Button btnadd= new Button("add");
    private Button btnsub= new Button("sub");
    private Button btn1= new Button("exit");
    private Timer  t1;
    private int count=0,labX=50,labY=50;
    private boolean flag=true;
    public MainFrame (){
        init();
    }
    private void init(){
        this.setBounds(300,300,500,400);
        this.setLayout(null);
        this.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        this.add(btnadd);
        btnadd.setBounds(140,200,80,50);
        this.add(lab);
        lab.setBounds(labX,labY,80,50);
        btnadd.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             MainFrame.this.setTitle(Integer.toString(++count));
             lab.setText(Integer.toString(count));
             t1.start();
            }
        });
        btnsub.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
             MainFrame.this.setTitle(Integer.toString(--count));
             lab.setText(Integer.toString(count));
            }
        });
        this.add(btnsub);
        btnsub.setBounds(220,200,80,50);
        this.add(btn1);
        btn1.setBounds(300,200,80,50);
        btn1.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.exit(0);
            }
        });
        t1=new Timer(200, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
               // labX+=15;
                //lab.setLocation(labX,labY);
                if(flag){
                    labX+=5;
                    lab.setLocation(labX,labY);
                    if(labX>MainFrame.this.getWidth()){
                        flag=false;
                    }
                }else if(!flag){
                    labX-=5;
                    lab.setLocation(labX,labY);
                    if(labX<0){
                        flag=true;
                    }
                }
            }
        });

    }
}
