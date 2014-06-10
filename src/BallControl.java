import javax.swing.*;

import java.awt.event.*;
import java.awt.*;


class BallControl extends JApplet {
	
	public static void main(String[] args){
		
		Ball ball = new Ball();
		JButton jbtSuspend = new JButton("Suspend");
		JButton jbtResume = new JButton("Resume");
		JScrollBar jsbDelay = new JScrollBar();		
	    JPanel panel = new JPanel();
	    	    
	    
        jsbDelay.setOrientation(JScrollBar.HORIZONTAL);  
        ball.setBorder(new javax.swing.border.LineBorder(Color.red));
        ball.setDelay(jsbDelay.getMaximum());

        
        ball.add(panel, BorderLayout.CENTER);        
	    jsbDelay.add(panel, BorderLayout.NORTH);		
	    panel.add(jbtSuspend);
        panel.add(jbtResume);	
 		panel.setLayout(new BorderLayout());    
 		
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
	
	
