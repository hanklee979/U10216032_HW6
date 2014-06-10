import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


class BallControl extends JApplet {
	
	public static void main(String[] args){
	
	    JFrame frame = new JFrame();	
		
		Ball ball = new Ball();
		JButton jbtSuspend = new JButton("Suspend");
		JButton jbtResume = new JButton("Resume");
		JScrollBar jsbDelay = new JScrollBar();		
	    JPanel panel = new JPanel();
    
	
	}
	
	
	


  public BallControl() {
    // Group buttons in a panel
	    panel.add(jbtSuspend);
        panel.add(jbtResume);	


    // Add ball and buttons to the panel
    ball.setBorder(new javax.swing.border.LineBorder(Color.red));
    jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
    ball.setDelay(jsbDelay.getMaximum());
    setLayout(new BorderLayout());
    add(jsbDelay, BorderLayout.NORTH);
    add(ball, BorderLayout.CENTER);
    add(panel, BorderLayout.SOUTH);

    // Register listeners
    jbtSuspend.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ball.suspend();
      }
    });
    jbtResume.addActionListener(new ActionListener() {
      public void actionPerformed(ActionEvent e) {
        ball.resume();
      }
    });
    jsbDelay.addAdjustmentListener(new AdjustmentListener() {
      public void adjustmentValueChanged(AdjustmentEvent e) {
        ball.setDelay(jsbDelay.getMaximum() - e.getValue());
      }
    });
  }
}

