
package cryptoTrader.gui;

import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;


/**
 * @author Daiying Erica Zhu
 *
 */
public class ErrorMessageUI extends JFrame {
	

		public ErrorMessageUI(ArrayList<String> error) {
			
			// Set window title, size, location
			super("Error");
			
			String message = null;
		
			if (error.size()>1) {
				message = message + "'s trades have failed.";
			}
			else {
				message = message + "'s trade has failed.";
			}
			
			this.setSize(200, 150);
			this.setDefaultCloseOperation(3);
			this.setLocationRelativeTo(null);
			this.setAlwaysOnTop(true);
			this.setResizable(false);
			FlowLayout layout = new FlowLayout(FlowLayout.CENTER);
			this.setLayout(layout);
			
			// set input field and button
			JLabel errMessage = new JLabel(message, SwingConstants.CENTER);
			errMessage.setPreferredSize(new Dimension(200, 30));
			this.add(errMessage);
			
			JButton confirmButton = new JButton("OK");
			confirmButton.setSize(100, 30);
			this.add(confirmButton);
			
			confirmButton.addActionListener(new ActionListener() {
				@Override
				public void actionPerformed(ActionEvent e) {
					ErrorMessageUI.this.dispose();
				}
			});
			this.setVisible(true);
		}
	}
