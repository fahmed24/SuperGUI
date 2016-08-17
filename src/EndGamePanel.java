
import java.io.FileReader;
import java.io.FileWriter;
import javax.swing.JPanel;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/*
fahad ahmed, reta yousif
cs 245
project 1.0
*/

public class EndGamePanel extends javax.swing.JPanel {

	/**
	 * Creates new form EndGamePanel
	 */
	private JPanel menu;
	private FileWriter out;
	private FileReader in;
	private int scores[] = new int[5];

	public EndGamePanel(JPanel menu, FileReader in, FileWriter out) {
		initComponents();
		setBounds(0,0,600,400);
		this.menu = menu;
		this.in = in;
		this.out = out;
	}
	public void setScore(int score) {
		jLabel3.setText(String.valueOf(score));
		//This is where we want to compare highscores 

	}
	public void read() {
		
	}
	public void write() {
		
	}
	/**
	 * This method is called from within the constructor to initialize the
	 * form. WARNING: Do NOT modify this code. The content of this method is
	 * always regenerated by the Form Editor.
	 */
	@SuppressWarnings("unchecked")
        // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
        private void initComponents() {

                jLabel1 = new javax.swing.JLabel();
                jLabel2 = new javax.swing.JLabel();
                jLabel3 = new javax.swing.JLabel();
                jButtonEnd = new javax.swing.JButton();

                setBackground(new java.awt.Color(0, 0, 0));
                setPreferredSize(new java.awt.Dimension(600, 400));

                jLabel1.setFont(new java.awt.Font("Lucida Grande", 0, 36)); // NOI18N
                jLabel1.setForeground(new java.awt.Color(255, 255, 255));
                jLabel1.setText("Game Over");

                jLabel2.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                jLabel2.setForeground(new java.awt.Color(255, 255, 255));
                jLabel2.setText("Score: ");

                jLabel3.setFont(new java.awt.Font("Lucida Grande", 0, 24)); // NOI18N
                jLabel3.setForeground(new java.awt.Color(255, 255, 255));
                jLabel3.setText("0");

                jButtonEnd.setText("End");
                jButtonEnd.addActionListener(new java.awt.event.ActionListener() {
                        public void actionPerformed(java.awt.event.ActionEvent evt) {
                                jButtonEndActionPerformed(evt);
                        }
                });

                javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
                this.setLayout(layout);
                layout.setHorizontalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addContainerGap(205, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel2)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                .addComponent(jLabel3)
                                                .addGap(246, 246, 246))
                                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                                .addComponent(jLabel1)
                                                .addGap(202, 202, 202))))
                        .addGroup(layout.createSequentialGroup()
                                .addGap(49, 49, 49)
                                .addComponent(jButtonEnd)
                                .addGap(0, 0, Short.MAX_VALUE))
                );
                layout.setVerticalGroup(
                        layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(65, 65, 65)
                                .addComponent(jLabel1)
                                .addGap(42, 42, 42)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabel2)
                                        .addComponent(jLabel3))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 136, Short.MAX_VALUE)
                                .addComponent(jButtonEnd, javax.swing.GroupLayout.PREFERRED_SIZE, 40, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(44, 44, 44))
                );
        }// </editor-fold>//GEN-END:initComponents

        private void jButtonEndActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButtonEndActionPerformed
                // TODO add your handling code here:
		this.setVisible(false);
		menu.setVisible(true);
        }//GEN-LAST:event_jButtonEndActionPerformed


        // Variables declaration - do not modify//GEN-BEGIN:variables
        private javax.swing.JButton jButtonEnd;
        private javax.swing.JLabel jLabel1;
        private javax.swing.JLabel jLabel2;
        private javax.swing.JLabel jLabel3;
        // End of variables declaration//GEN-END:variables
}
