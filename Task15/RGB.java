import java.awt.*;
import java.awt.event.*;
import javax.swing.*;
import javax.swing.border.BevelBorder;


public class RGB extends JFrame implements ActionListener{
    JButton redBtn;
    JButton greenBtn;
    JButton blueBtn;
    JFrame window;
    JPanel panel;
    boolean red = true;
    boolean blue;
    boolean green;
    int firstTime = 0;
    Graphics2D g2;

   public RGB(){
        this.window = new JFrame();

        this.redBtn = new JButton("RED");
        redBtn.addActionListener(this);

        this.blueBtn = new JButton("BLUE");
        blueBtn.addActionListener(this);

        this.greenBtn = new JButton("GREEN");
        greenBtn.addActionListener(this);

        this.panel = new JPanel(){
            @Override
            public void paintComponent(Graphics g){
                super.paintComponent(g);
                 g2= (Graphics2D)g;
                if(firstTime == 0){
                    g2.setColor(Color.RED);
                    g2.fillOval(200, 200, 50, 50);
                    firstTime = 1;
                }
                if(red == true){
                    g2.setColor(Color.RED);
                    g2.fillOval(200, 200, 50, 50);
                }
                if(blue == true){
                    g2.setColor(Color.BLUE);
                    g2.fillOval(200, 200, 50, 50);
                }
                if(green == true){
                    g2.setColor(Color.GREEN);
                    g2.fillOval(200, 200, 50, 50);
                }
            }
        };
        panel.add(blueBtn);
        panel.add(greenBtn);
        panel.add(redBtn);
        panel.setVisible(true);

        window.setSize(400,400);
        window.add(panel);
        window.setVisible(true);
   }

    @Override
    public void actionPerformed(ActionEvent e){
        if(e.getSource() == redBtn){
            red = true;
            blue = false;
            green = false;
            panel.repaint();
        } 
        if(e.getSource() == blueBtn){
            blue = true;
            red = false;
            green = false;
            panel.repaint();
        } 
        if(e.getSource() == greenBtn){
            green = true;
            red = false;
            blue = false;
            panel.repaint();
        } 
    }

    public static void main(String[] args){
        RGB rgb = new RGB();
    }
}

