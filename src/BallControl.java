import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

class BallControl extends JApplet {
	
	public static void main(String[] args){
			
		BallControl frame = new BallControl();
		
		Ball ball = new Ball();
		JButton jbtSuspend = new JButton("Suspend");
		JButton jbtResume = new JButton("Resume");
		JScrollBar jsbDelay = new JScrollBar();		
	    JPanel panel = new JPanel();
    
	    panel.add(jbtSuspend);
        panel.add(jbtResume);		
        
        ball.setBorder(new javax.swing.border.LineBorder(Color.red));
        jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
        
        ball.setDelay(jsbDelay.getMaximum());
        
		frame.setVisible(true); 	
		
	    jsbDelay.add(panel, BorderLayout.NORTH);		
	    ball.add(panel, BorderLayout.CENTER);
    	panel.add(panel, BorderLayout.SOUTH); 		

	}
	
	public BallControl(){
	    
		setLayout(new BorderLayout());    	
	    
       
    	
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
	
	
