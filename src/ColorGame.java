
import java.awt.Color;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author fahadahmed
 */
public class ColorGame extends javax.swing.JPanel {

	/**
	 * Creates new form ColorGame
	 */
	private String colors[] = {"RED", "BLUE", "GREEN", "YELLOW", "PURPLE"};
	private Random random;
	private String text;
	private String fontColor;
	private int hangManScore = 0;
	private int score = 0;
	private int roundCount = 1;
	private EndGamePanel endGamePanel;
	private PlayGame playGame;

	public ColorGame(JPanel menu, JFrame hangMan, BufferedReader br, BufferedWriter bw) throws IOException {
		initComponents();
		setBounds(0,0,600,400);
		random = new Random();

		//Create EndGamePanel 
		endGamePanel = new EndGamePanel(hangMan, menu, br, bw);
		//Reference to hangMan JFrame
		hangMan.getContentPane().add(endGamePanel);
		//Hide EndGamePanel for now
		endGamePanel.setVisible(false);

		handleText();
		dateTime();
	}
	public void setHangManScore(int score) {
		this.hangManScore = score;
	}
	//Change the text and color
	public void dateTime() {
		Thread clock = new Thread() {
			public void run() {
				try {
					while(true) {
						Calendar cal = new GregorianCalendar();
						int day = cal.get(Calendar.DAY_OF_MONTH);
						int month = cal.get(Calendar.MONTH) + 1;
						int year = cal.get(Calendar.YEAR);
						
						int sec = cal.get(Calendar.SECOND);
						int min = cal.get(Calendar.MINUTE);
						int hr = cal.get(Calendar.HOUR);
						jLabelDate.setText(month + "/" + day + "/" + year + "  " + hr + ":" + min + ":" + sec);
						sleep(1000);
					}
				} catch (InterruptedException ex) {
					Logger.getLogger(PlayGame.class.getName()).log(Level.SEVERE, null, ex);
				}

			}
		};
		clock.start();
	}
	public void handleText() {
		
		if (roundCount >= 6) {
			roundCount = 1;
			try {
				endGamePanel();
			} catch (IOException ex) {
				Logger.getLogger(ColorGame.class.getName()).log(Level.SEVERE, null, ex);
			}
			score = 0;
		}

		text = colors[random.nextInt(5)];
		jLabelTextColor.setText(text);
		switch (random.nextInt(5)) {
			case 0: {
				fontColor = "RED";
				jLabelTextColor.setForeground(Color.red);
				break;
			}
			case 1: {
				fontColor = "BLUE";
				jLabelTextColor.setForeground(Color.blue);
				break;
			}
			case 2: {
				fontColor = "YELLOW";
				jLabelTextColor.setForeground(Color.yellow);
				break;
			}
			case 3: {
				fontColor = "GREEN";
				jLabelTextColor.setForeground(Color.green);
				break;
			}
			case 4: {
				fontColor = "PURPLE";
				jLabelTextColor.setForeground(Color.magenta);
				break;
			}
		}
	}
	public void checkColor(String color) {
		if (fontColor.equals(color))
			score += 100;
	}
	public void endGamePanel() throws IOException {
			//Set this PlayGame panel to not visibile
			this.setVisible(false);
			//Show the EndGamePanel
			endGamePanel.setVisible(true);
			//Set score
			endGamePanel.setScore(hangManScore + score);
	}
	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabelTextColor = new javax.swing.JLabel();
                jButtonRed = new javax.swing.JButton();
                jButtonGreen = new javax.swing.JButton();
                jButtonBlue = new javax.swing.JButton();
                jButtonPurple = new javax.swing.JButton();
                jButtonYellow = new javax.swing.JButton();
                jLabelDate = new javax.swing.JLabel();

                setBackground(new java.awt.Color(0, 0, 0));
                setPreferredSize(new java.awt.Dimension(600, 400));

                jLabelTextColor.setFont(new java.awt.Font("Luminari", 0, 36)); // NOI18N
                jLabelTextColor.setForeground(new java.awt.Color(255, 255, 255));
                jLabelTextColor.setText("Color");

                jButtonRed.setBackground(new java.awt.Color(0, 0, 0));
                jButtonRed.setIcon(new javax.swing.ImageIcon(getClass().getResource("/redCircle.png"))); // NOI18N
                jButtonRed.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonRedActionPerformed(evt);
                        }
                });

                jButtonGreen.setBackground(new java.awt.Color(0, 0, 0));
                jButtonGreen.setIcon(new javax.swing.ImageIcon(getClass().getResource("/greenCircle.png"))); // NOI18N
                jButtonGreen.setBounds(new java.awt.Rectangle(0, 0, 97, 29));
                jButtonGreen.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonGreenActionPerformed(evt);
                        }
                });

                jButtonBlue.setIcon(new javax.swing.ImageIcon(getClass().getResource("/blueCircle.png"))); // NOI18N
                jButtonBlue.setBounds(new java.awt.Rectangle(0, 0, 97, 29));
                jButtonBlue.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonBlueActionPerformed(evt);
                        }
                });

                jButtonPurple.setIcon(new javax.swing.ImageIcon(getClass().getResource("/purpleCircle.png"))); // NOI18N
                jButtonPurple.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonPurpleActionPerformed(evt);
                        }
                });

                jButtonYellow.setIcon(new javax.swing.ImageIcon(getClass().getResource("/yellowCircle.png"))); // NOI18N
                jButtonYellow.setBounds(new java.awt.Rectangle(0, 0, 97, 29));
                jButtonYellow.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonYellowActionPerformed(evt);
                        }
                });

                jLabelDate.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
                jLabelDate.setForeground(new java.awt.Color(255, 255, 255));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(251, 251, 251)
                                .addComponent(jLabelTextColor)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(14, 14, 14))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(93, 93, 93)
                                                .addComponent(jButtonGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(58, 58, 58)
                                                .addComponent(jButtonPurple, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 44, Short.MAX_VALUE)
                                                .addComponent(jButtonBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addComponent(jButtonRed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(55, 55, 55)
                                                .addComponent(jButtonYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(65, 65, 65)))
                                .addGap(105, 105, 105))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(27, 27, 27)
                                                .addComponent(jLabelTextColor))
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap()
                                                .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 26, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(44, 44, 44)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonYellow, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonRed, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jButtonBlue, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonPurple, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButtonGreen, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(62, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void jButtonRedActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonRedActionPerformed
                // TODO add your handling code here:
		checkColor("RED");
		roundCount++;
		handleText();

        }//GEN-LAST:event_jButtonRedActionPerformed

        private void jButtonGreenActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonGreenActionPerformed
                // TODO add your handling code here:
		checkColor("GREEN");
		roundCount++;
		handleText();
        }//GEN-LAST:event_jButtonGreenActionPerformed

        private void jButtonPurpleActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonPurpleActionPerformed
                // TODO add your handling code here:
		checkColor("PURPLE");
		roundCount++;
		handleText();
        }//GEN-LAST:event_jButtonPurpleActionPerformed

        private void jButtonBlueActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonBlueActionPerformed
                // TODO add your handling code here:
		checkColor("BLUE");
		roundCount++;
		handleText();
        }//GEN-LAST:event_jButtonBlueActionPerformed

        private void jButtonYellowActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonYellowActionPerformed
                // TODO add your handling code here:
		checkColor("YELLOW");
		roundCount++;
		handleText();
        }//GEN-LAST:event_jButtonYellowActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButtonBlue;
        private javax.swing.JButton jButtonGreen;
        private javax.swing.JButton jButtonPurple;
        private javax.swing.JButton jButtonRed;
        private javax.swing.JButton jButtonYellow;
        private javax.swing.JLabel jLabelDate;
        private javax.swing.JLabel jLabelTextColor;
        // End of variables declaration//GEN-END:variables
}
