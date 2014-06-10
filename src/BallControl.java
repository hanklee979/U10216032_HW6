import javax.swing.*;
import java.awt.event.*;
import java.awt.*;


public class BallControl extends JPanel{

	private Ball ball = new Ball();
	private JButton jbtSuspend = new JButton("Suspend");
	private JButton jbtResume = new JButton("Resume");	
	private JScrollBar jsbDelay = new JScrollBar();	
	
	public BallControl(){
		JPanel panel = new JPanel();
		panel.add(jbtSuspend);
		panel.add(jbtResume);
		
		ball.setBorder(new javax.swing.border.LineBorder(Color.red));
		jsbDelay.setOrientation(JScrollBar.HORIZONTAL);
		ball.setDelay(jsbDelay.getMaximum());
		setLayout(new BorderLayout());
		
		add(jsbDelay, BorderLayout.NORTH);
		add(ball, BorderLayout.CENTER);
		add(panel, BorderLayout.SOUTH);
		
		jbtSuspend.addActionListener(new ActionListener(){
			@Override
			public void actionProformed(ActionEvent e){
				ball.suspend();
			}
		});
		
		jbtResume.addActionListener(new ActionListener(){
			@Override
			public void actionProformed(ActionEvent e){
				ball.resume();
			}
		});
		
		jsbDelay.addAdjustmentListener(new ActionListener(){
			@Override
			public void addAdjustmentValueChanged(AdjustmentEvent e){
				ball.setDelay(jsbDelay.getMaximum() - e.getValue());
			}
		});
					
	}
}
