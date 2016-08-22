import java.awt.Color;
import java.util.Calendar;
/*
fahad ahmed, reta yousif
cs 245
project 1.0
*/

import java.util.GregorianCalendar;
import java.util.Random;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class PlayGame extends javax.swing.JPanel {

	/**
	 * Creates new form PlayGame
	 */
	
	private String list[] = {"ABSTRACT", "CEMETARY", "NURSE", "PHARMACY", "CLIMBING"};
	private String word;
	private int score = 100;
	private int count = 0;
	public ColorGame colorGame;
	private EndGamePanel endGamePanel;
	private Random randNum;

	public PlayGame(JFrame hangMan, JPanel menu, ColorGame colorGame) {
		initComponents();
		setBounds(0,0,600,400);
		this.colorGame = colorGame;	
		
		//Create EndGamePanel 
		//endGamePanel = new EndGamePanel(menu);
		//Reference to hangMan JFrame
		//hangMan.getContentPane().add(endGamePanel);
		//Hide EndGamePanel for now
		//endGamePanel.setVisible(false);
		//Random number generator	
		randNum = new Random();
		
		//Calendar
		dateTime();
	}
	public int getScore() {
		return score;
	}
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
	public void resetGame() {
		word = list[randNum.nextInt(5)];
		generateLines();
		//Reset image
		jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hangman0.jpg")));
		//Reset score and count and display score
		score = 100;
		count = 0;
		jLabelScoreValue.setText(String.valueOf(score));
		//Reset letter buttons
		jButton1.setEnabled(true);
		jButton2.setEnabled(true);
		jButton3.setEnabled(true);
		jButton4.setEnabled(true);
		jButton5.setEnabled(true);
		jButton6.setEnabled(true);
		jButton7.setEnabled(true);
		jButton8.setEnabled(true);
		jButton9.setEnabled(true);
		jButton10.setEnabled(true);
		jButton11.setEnabled(true);
		jButton12.setEnabled(true);
		jButton13.setEnabled(true);
		jButton14.setEnabled(true);
		jButton15.setEnabled(true);
		jButton16.setEnabled(true);
		jButton17.setEnabled(true);
		jButton18.setEnabled(true);
		jButton19.setEnabled(true);
		jButton20.setEnabled(true);
		jButton21.setEnabled(true);
		jButton22.setEnabled(true);
		jButton23.setEnabled(true);
		jButton24.setEnabled(true);
		jButton25.setEnabled(true);
		jButton26.setEnabled(true);
	}
	public void generateLines() {
		if (word.length() < 8) {
			jLabel8.setVisible(false);
			jLabel10.setVisible(false);
			jLabel11.setVisible(false);
		} else if (word.length() > 5) {
			jLabel8.setVisible(true);
			jLabel10.setVisible(true);
			jLabel11.setVisible(true);
		} 
		//Set all labels to blank
		jLabel4.setText("");
		jLabel12.setText("");
		jLabel9.setText("");
		jLabel5.setText("");
		jLabel6.setText("");
		jLabel8.setText("");
		jLabel10.setText("");
		jLabel11.setText("");
	}
	public void checkLetterInWord(char letter) {
		boolean letterFound = false;
		for (int i = 0; i < word.length(); i++) {
			if (letter == word.charAt(i)) {
				setText(i);	
				letterFound = true;
			}
		}
		//If we reach this point, the letter was not in the word.
		//Decrement score and update hangman image.
		//updateScoreAndImage();
		if (score < 50 || count == word.length()) {
			//Show endGame panel
			endGamePanel();
		} else if (letterFound == false)
			updateScoreAndImage();

	}
	public void updateScoreAndImage() {
		score -= 10;
		jLabelScoreValue.setText(String.valueOf(score));
		switch (score) {
			case 100: {
				jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hangman0.jpg")));
				break;
			}
			case 90: {
				jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hangman1.jpg")));
				break;
			}
			case 80: {
				jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hangman2.jpg")));
				break;
			}
			case 70: {
				jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hangman3.jpg")));
				break;
			}
			case 60: {
				jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hangman4.jpg")));
				break;
			}
			case 50: {
				jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hangman5.jpg")));
				break;
			}
			case 40: {
				jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hangman6.jpg")));
			}
		}
	}
	public void endGamePanel() {
			//Set this PlayGame panel to not visibile
			this.setVisible(false);
			colorGame.setVisible(true);
			colorGame.setHangManScore(score);
	}
	public void setText(int wordIndex) {
		switch (wordIndex) {
			case 0: {
				jLabel4.setText(String.valueOf(word.charAt(wordIndex)));
				count++;
				break;
			}
			case 1: {
				jLabel12.setText(String.valueOf(word.charAt(wordIndex)));
				count++;
				break;
			}
			case 2: {
				jLabel9.setText(String.valueOf(word.charAt(wordIndex)));
				count++;
				break;
			} 
			case 3: {
				jLabel5.setText(String.valueOf(word.charAt(wordIndex)));
				count++;
				break;
			}
			case 4: {
				jLabel6.setText(String.valueOf(word.charAt(wordIndex)));
				count++;
				break;
			}
			case 5: {
				jLabel8.setText(String.valueOf(word.charAt(wordIndex)));
				count++;
				break;
			}
			case 6: {
				jLabel10.setText(String.valueOf(word.charAt(wordIndex)));
				count++;
				break;
			}
			case 7: {
				jLabel11.setText(String.valueOf(word.charAt(wordIndex)));
				count++;
				break;
			}
		}
	}

	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel7 = new javax.swing.JLabel();
                jLabel1 = new javax.swing.JLabel();
                jLabelImage = new javax.swing.JLabel();
                jButton2 = new javax.swing.JButton();
                jButton1 = new javax.swing.JButton();
                jButton3 = new javax.swing.JButton();
                jButton4 = new javax.swing.JButton();
                jButton5 = new javax.swing.JButton();
                jButton6 = new javax.swing.JButton();
                jButton7 = new javax.swing.JButton();
                jButton8 = new javax.swing.JButton();
                jButton9 = new javax.swing.JButton();
                jButton10 = new javax.swing.JButton();
                jButton11 = new javax.swing.JButton();
                jButton12 = new javax.swing.JButton();
                jButton13 = new javax.swing.JButton();
                jButton14 = new javax.swing.JButton();
                jButton15 = new javax.swing.JButton();
                jButton16 = new javax.swing.JButton();
                jButton17 = new javax.swing.JButton();
                jButton18 = new javax.swing.JButton();
                jButton19 = new javax.swing.JButton();
                jButton20 = new javax.swing.JButton();
                jButton21 = new javax.swing.JButton();
                jButton23 = new javax.swing.JButton();
                jButton24 = new javax.swing.JButton();
                jButton22 = new javax.swing.JButton();
                jButton25 = new javax.swing.JButton();
                jButton26 = new javax.swing.JButton();
                jLabel4 = new javax.swing.JLabel();
                jLabel5 = new javax.swing.JLabel();
                jLabel6 = new javax.swing.JLabel();
                jLabel8 = new javax.swing.JLabel();
                jLabel9 = new javax.swing.JLabel();
                jLabel10 = new javax.swing.JLabel();
                jLabel11 = new javax.swing.JLabel();
                jLabel12 = new javax.swing.JLabel();
                jLabelScore = new javax.swing.JLabel();
                jLabelScoreValue = new javax.swing.JLabel();
                jButtonSkip = new javax.swing.JButton();
                jLabelDate = new javax.swing.JLabel();

                jLabel7.setIcon(new javax.swing.ImageIcon(getClass().getResource("/letter.png"))); // NOI18N
                jLabel7.setText("jLabel4");

                setBackground(new java.awt.Color(0, 0, 0));
                setPreferredSize(new java.awt.Dimension(600, 400));

                jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                jLabel1.setText("HangMan");

                jLabelImage.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Hangman0.jpg"))); // NOI18N
                jLabelImage.setText("jLabel3");

                jButton2.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton2.setText("B");
                jButton2.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton2ActionPerformed(evt);
                        }
                });

                jButton1.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton1.setText("A");
                jButton1.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton1ActionPerformed(evt);
                        }
                });

                jButton3.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton3.setText("C");
                jButton3.setActionCommand("");
                jButton3.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton3ActionPerformed(evt);
                        }
                });

                jButton4.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton4.setText("D");
                jButton4.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton4ActionPerformed(evt);
                        }
                });

                jButton5.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton5.setText("E");
                jButton5.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton5ActionPerformed(evt);
                        }
                });

                jButton6.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton6.setText("F");
                jButton6.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton6ActionPerformed(evt);
                        }
                });

                jButton7.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton7.setText("G");
                jButton7.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton7ActionPerformed(evt);
                        }
                });

                jButton8.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton8.setText("H");
                jButton8.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton8ActionPerformed(evt);
                        }
                });

                jButton9.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton9.setText("I");
                jButton9.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton9ActionPerformed(evt);
                        }
                });

                jButton10.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton10.setText("J");
                jButton10.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton10ActionPerformed(evt);
                        }
                });

                jButton11.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton11.setText("K");
                jButton11.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton11ActionPerformed(evt);
                        }
                });

                jButton12.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton12.setText("L");
                jButton12.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton12ActionPerformed(evt);
                        }
                });

                jButton13.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton13.setText("M");
                jButton13.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton13ActionPerformed(evt);
                        }
                });

                jButton14.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton14.setText("N");
                jButton14.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton14ActionPerformed(evt);
                        }
                });

                jButton15.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton15.setText("O");
                jButton15.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton15ActionPerformed(evt);
                        }
                });

                jButton16.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton16.setText("P");
                jButton16.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton16ActionPerformed(evt);
                        }
                });

                jButton17.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton17.setText("Q");
                jButton17.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton17ActionPerformed(evt);
                        }
                });

                jButton18.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton18.setText("R");
                jButton18.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton18ActionPerformed(evt);
                        }
                });

                jButton19.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton19.setText("S");
                jButton19.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton19ActionPerformed(evt);
                        }
                });

                jButton20.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton20.setText("T");
                jButton20.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton20ActionPerformed(evt);
                        }
                });

                jButton21.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton21.setText("U");
                jButton21.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton21ActionPerformed(evt);
                        }
                });

                jButton23.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton23.setText("W");
                jButton23.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton23ActionPerformed(evt);
                        }
                });

                jButton24.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton24.setText("X");
                jButton24.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton24ActionPerformed(evt);
                        }
                });

                jButton22.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton22.setText("V");
                jButton22.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton22ActionPerformed(evt);
                        }
                });

                jButton25.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton25.setText("Y");
                jButton25.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton25ActionPerformed(evt);
                        }
                });

                jButton26.setFont(new java.awt.Font("Lucida Grande", 0, 10)); // NOI18N
                jButton26.setText("Z");
                jButton26.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButton26ActionPerformed(evt);
                        }
                });

                jLabel4.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                jLabel4.setForeground(new java.awt.Color(255, 255, 255));
                jLabel4.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel4.setIcon(new javax.swing.ImageIcon(getClass().getResource("/letter.png"))); // NOI18N
                jLabel4.setText("H");
                jLabel4.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                jLabel5.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                jLabel5.setForeground(new java.awt.Color(255, 255, 255));
                jLabel5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/letter.png"))); // NOI18N
                jLabel5.setText("Y");
                jLabel5.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                jLabel6.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                jLabel6.setForeground(new java.awt.Color(255, 255, 255));
                jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/letter.png"))); // NOI18N
                jLabel6.setText("U");
                jLabel6.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                jLabel8.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                jLabel8.setForeground(new java.awt.Color(255, 255, 255));
                jLabel8.setIcon(new javax.swing.ImageIcon(getClass().getResource("/letter.png"))); // NOI18N
                jLabel8.setText("Y");
                jLabel8.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                jLabel9.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                jLabel9.setForeground(new java.awt.Color(255, 255, 255));
                jLabel9.setIcon(new javax.swing.ImageIcon(getClass().getResource("/letter.png"))); // NOI18N
                jLabel9.setText("T");
                jLabel9.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                jLabel10.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                jLabel10.setForeground(new java.awt.Color(255, 255, 255));
                jLabel10.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel10.setIcon(new javax.swing.ImageIcon(getClass().getResource("/letter.png"))); // NOI18N
                jLabel10.setText("Y");
                jLabel10.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                jLabel11.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                jLabel11.setForeground(new java.awt.Color(255, 255, 255));
                jLabel11.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel11.setIcon(new javax.swing.ImageIcon(getClass().getResource("/letter.png"))); // NOI18N
                jLabel11.setText("G");
                jLabel11.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                jLabel12.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                jLabel12.setForeground(new java.awt.Color(255, 255, 255));
                jLabel12.setHorizontalAlignment(javax.swing.SwingConstants.CENTER);
                jLabel12.setIcon(new javax.swing.ImageIcon(getClass().getResource("/letter.png"))); // NOI18N
                jLabel12.setText("S");
                jLabel12.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);

                jLabelScore.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
                jLabelScore.setForeground(new java.awt.Color(255, 255, 255));
                jLabelScore.setText("Score: ");

                jLabelScoreValue.setFont(new java.awt.Font("Lucida Grande", 0, 18)); // NOI18N
                jLabelScoreValue.setForeground(new java.awt.Color(255, 255, 255));
                jLabelScoreValue.setText("100");

                jButtonSkip.setFont(new java.awt.Font("Lucida Grande", 0, 12)); // NOI18N
                jButtonSkip.setText("Skip");
                jButtonSkip.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonSkipActionPerformed(evt);
                        }
                });

                jLabelDate.setFont(new java.awt.Font("Lucida Grande", 0, 14)); // NOI18N
                jLabelDate.setForeground(new java.awt.Color(255, 255, 255));

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addGap(0, 0, Short.MAX_VALUE)
                                                .addComponent(jLabel4)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel12)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel9, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel5, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel8, javax.swing.GroupLayout.PREFERRED_SIZE, 50, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel10)
                                                .addGap(5, 5, 5)
                                                .addComponent(jLabel11)
                                                .addGap(76, 76, 76))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jLabel1)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jLabelScore)
                                                                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                                        .addGap(54, 54, 54)
                                                                        .addComponent(jLabelScoreValue))))
                                                .addGap(120, 120, 120)
                                                .addComponent(jLabelImage, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addComponent(jButtonSkip, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 81, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabelDate, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, 145, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addContainerGap())))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(23, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(24, 24, 24))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jLabelScore)
                                                        .addComponent(jLabelScoreValue)))
                                        .addComponent(jLabelImage)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelDate, javax.swing.GroupLayout.PREFERRED_SIZE, 27, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                .addComponent(jButtonSkip)))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jLabel9)
                                                .addComponent(jLabel5)
                                                .addComponent(jLabel6)
                                                .addComponent(jLabel8))
                                        .addComponent(jLabel4)
                                        .addComponent(jLabel11)
                                        .addComponent(jLabel12)
                                        .addComponent(jLabel10))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton3, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton4, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton5, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton6, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton7, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton8, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton9, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton10, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton11, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton12, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton13, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jButton15, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton16, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton17, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton18, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton19, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton20, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton21, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton22, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton23, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton24, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton25, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton26, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jButton14, javax.swing.GroupLayout.PREFERRED_SIZE, 35, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addContainerGap(44, Short.MAX_VALUE))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('B');
		jButton2.setEnabled(false);
        }//GEN-LAST:event_jButton2ActionPerformed

        private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('A');
		jButton1.setEnabled(false);
        }//GEN-LAST:event_jButton1ActionPerformed

        private void jButton3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton3ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('C');
		jButton3.setEnabled(false);
        }//GEN-LAST:event_jButton3ActionPerformed

        private void jButton4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton4ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('D');
		jButton4.setEnabled(false);
        }//GEN-LAST:event_jButton4ActionPerformed

        private void jButton5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton5ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('E');
		jButton5.setEnabled(false);
        }//GEN-LAST:event_jButton5ActionPerformed

        private void jButton6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton6ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('F');
		jButton6.setEnabled(false);
        }//GEN-LAST:event_jButton6ActionPerformed

        private void jButton7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton7ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('G');
		jButton7.setEnabled(false);
        }//GEN-LAST:event_jButton7ActionPerformed

        private void jButton8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton8ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('H');
		jButton8.setEnabled(false);
        }//GEN-LAST:event_jButton8ActionPerformed

        private void jButton9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton9ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('I');
		jButton9.setEnabled(false);
        }//GEN-LAST:event_jButton9ActionPerformed

        private void jButton10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton10ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('J');
		jButton10.setEnabled(false);
        }//GEN-LAST:event_jButton10ActionPerformed

        private void jButton11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton11ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('K');
		jButton11.setEnabled(false);
        }//GEN-LAST:event_jButton11ActionPerformed

        private void jButton12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton12ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('L');
		jButton12.setEnabled(false);
        }//GEN-LAST:event_jButton12ActionPerformed

        private void jButton13ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton13ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('M');
		jButton13.setEnabled(false);
        }//GEN-LAST:event_jButton13ActionPerformed

        private void jButton14ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton14ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('N');
		jButton14.setEnabled(false);
        }//GEN-LAST:event_jButton14ActionPerformed

        private void jButton15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton15ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('O');
		jButton15.setEnabled(false);
        }//GEN-LAST:event_jButton15ActionPerformed

        private void jButton16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton16ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('P');
		jButton16.setEnabled(false);
        }//GEN-LAST:event_jButton16ActionPerformed

        private void jButton17ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton17ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('Q');
		jButton17.setEnabled(false);
        }//GEN-LAST:event_jButton17ActionPerformed

        private void jButton18ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton18ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('R');
		jButton18.setEnabled(false);
        }//GEN-LAST:event_jButton18ActionPerformed

        private void jButton19ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton19ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('S');
		jButton19.setEnabled(false);
        }//GEN-LAST:event_jButton19ActionPerformed

        private void jButton20ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton20ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('T');
		jButton20.setEnabled(false);
        }//GEN-LAST:event_jButton20ActionPerformed

        private void jButton21ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton21ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('U');
		jButton21.setEnabled(false);
        }//GEN-LAST:event_jButton21ActionPerformed

        private void jButton23ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton23ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('W');
		jButton23.setEnabled(false);
        }//GEN-LAST:event_jButton23ActionPerformed

        private void jButton24ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton24ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('X');
		jButton24.setEnabled(false);
        }//GEN-LAST:event_jButton24ActionPerformed

        private void jButton22ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton22ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('V');
		jButton22.setEnabled(false);
        }//GEN-LAST:event_jButton22ActionPerformed

        private void jButton25ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton25ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('Y');
		jButton25.setEnabled(false);
        }//GEN-LAST:event_jButton25ActionPerformed

        private void jButton26ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton26ActionPerformed
                // TODO add your handling code here:
		checkLetterInWord('Z');
		jButton26.setEnabled(false);
        }//GEN-LAST:event_jButton26ActionPerformed

        private void jButtonSkipActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonSkipActionPerformed
                // TODO add your handling code here:
		score = 0;
		endGamePanel();
		//colorGame.setVisible(true);

        }//GEN-LAST:event_jButtonSkipActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButton1;
        private javax.swing.JButton jButton10;
        private javax.swing.JButton jButton11;
        private javax.swing.JButton jButton12;
        private javax.swing.JButton jButton13;
        private javax.swing.JButton jButton14;
        private javax.swing.JButton jButton15;
        private javax.swing.JButton jButton16;
        private javax.swing.JButton jButton17;
        private javax.swing.JButton jButton18;
        private javax.swing.JButton jButton19;
        private javax.swing.JButton jButton2;
        private javax.swing.JButton jButton20;
        private javax.swing.JButton jButton21;
        private javax.swing.JButton jButton22;
        private javax.swing.JButton jButton23;
        private javax.swing.JButton jButton24;
        private javax.swing.JButton jButton25;
        private javax.swing.JButton jButton26;
        private javax.swing.JButton jButton3;
        private javax.swing.JButton jButton4;
        private javax.swing.JButton jButton5;
        private javax.swing.JButton jButton6;
        private javax.swing.JButton jButton7;
        private javax.swing.JButton jButton8;
        private javax.swing.JButton jButton9;
        private javax.swing.JButton jButtonSkip;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel10;
        private javax.swing.JLabel jLabel11;
        private javax.swing.JLabel jLabel12;
        private javax.swing.JLabel jLabel4;
        private javax.swing.JLabel jLabel5;
        private javax.swing.JLabel jLabel6;
        private javax.swing.JLabel jLabel7;
        private javax.swing.JLabel jLabel8;
        private javax.swing.JLabel jLabel9;
        private javax.swing.JLabel jLabelDate;
        private javax.swing.JLabel jLabelImage;
        private javax.swing.JLabel jLabelScore;
        private javax.swing.JLabel jLabelScoreValue;
        // End of variables declaration//GEN-END:variables
}
