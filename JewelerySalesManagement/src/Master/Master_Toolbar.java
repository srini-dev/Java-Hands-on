/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Master;

//For shadow
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import javax.swing.border.LineBorder;

import javax.swing.*;

/**
 *
 * @author Vicky
 */
public class Master_Toolbar extends javax.swing.JPanel {

    //attrib for shadow starts************************************************
    protected int strokeSize = 1;
    protected Color shadowColor = Color.black;
    protected boolean shady = true;
    protected boolean highQuality = true;
    protected Dimension arcs = new Dimension(20, 20);
    protected int shadowGap = 5;
    protected int shadowOffset = 4;
    protected int shadowAlpha = 150;
//attrib for shadow stops************************************************


    /**
     * Creates new form Master_Toolbar
     */
    public Master_Toolbar() {
        setOpaque(false);
        initComponents();

        System.out.println("Done.........");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton7 = new javax.swing.JButton();
        jRadioButton1 = new javax.swing.JRadioButton();
        jPanel7 = new javax.swing.JPanel();
        Bankbtn = new javax.swing.JButton();
        ExamRbtn = new javax.swing.JButton();

        jButton7.setText("jButton7");

        jRadioButton1.setText("jRadioButton1");

        setMaximumSize(new java.awt.Dimension(1300, 125));
        setMinimumSize(new java.awt.Dimension(1300, 125));
        setPreferredSize(new java.awt.Dimension(1300, 125));

        jPanel7.setBackground(new java.awt.Color(204, 204, 204));
        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Add/ Edit/Delete", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        Bankbtn.setFont(new java.awt.Font("Times New Roman", 1, 14));
        Bankbtn.setText("Bank");
        Bankbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                BankbtnActionPerformed(evt);
            }
        });

        ExamRbtn.setFont(new java.awt.Font("Lucida Sans", 1, 14));
        ExamRbtn.setText("Target Amount");
        ExamRbtn.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ExamRbtnActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(Bankbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(ExamRbtn, javax.swing.GroupLayout.PREFERRED_SIZE, 159, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(33, Short.MAX_VALUE))
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addGroup(jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(ExamRbtn, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE)
                    .addComponent(Bankbtn, javax.swing.GroupLayout.DEFAULT_SIZE, 64, Short.MAX_VALUE))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(22, 22, 22)
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(888, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(13, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents

    private void ExamRbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ExamRbtnActionPerformed
        // TODO add your handling code here:
       if(evt.getSource()==ExamRbtn)
        {
         JPanel   p2helper = new Master.Bank();
             setMainPanel(p2helper);
        }
    }//GEN-LAST:event_ExamRbtnActionPerformed

    private void BankbtnActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_BankbtnActionPerformed
        // TODO add your handling code here:
        Admin.Forms.MainMenu.PanelInfo.removeAll();
        Admin.Forms.MainMenu.PanelInfo.repaint();
        JPanel Phelp=new Bank();
        setMainPanel(Phelp);
}//GEN-LAST:event_BankbtnActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton Bankbtn;
    private javax.swing.JButton ExamRbtn;
    private javax.swing.JButton jButton7;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JRadioButton jRadioButton1;
    // End of variables declaration//GEN-END:variables
public static void setMainPanel(JPanel subPanel) {
    
   JPanel PanelsecoundMenu=  Admin.Forms.MainMenu.PanelInfo;
        PanelsecoundMenu.removeAll();
        PanelsecoundMenu.add(subPanel);
        PanelsecoundMenu.validate();
        PanelsecoundMenu.repaint();

}

 //fun for creating shadow Starts**************************************************************
    @Override
    protected void paintComponent(Graphics g) {
        super.paintComponent(g);
        int width = getWidth();
        int height = getHeight();
        int shadowGap = this.shadowGap;
        Color shadowColorA = new Color(shadowColor.getRed(),
	shadowColor.getGreen(), shadowColor.getBlue(), shadowAlpha);
        Graphics2D graphics = (Graphics2D) g;

        //Sets antialiasing if HQ.
        if (highQuality) {
            graphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING,
			RenderingHints.VALUE_ANTIALIAS_ON);
        }

        //Draws shadow borders if any.
        if (shady) {
            graphics.setColor(shadowColorA);
            graphics.fillRoundRect(
                    shadowOffset,// X position
                    shadowOffset,// Y position
                    width - strokeSize - shadowOffset, // width
                    height - strokeSize - shadowOffset, // height
                    arcs.width, arcs.height);// arc Dimension
        } else {
            shadowGap = 1;
        }

        //Draws the rounded opaque panel with borders.
        graphics.setColor(getBackground());
        graphics.fillRoundRect(0, 0, width - shadowGap, height - shadowGap, arcs.width, arcs.height);
        graphics.setColor(getForeground());
        graphics.setStroke(new BasicStroke(strokeSize));
        graphics.drawRoundRect(0, 0, width - shadowGap,
		height - shadowGap, arcs.width, arcs.height);

        //Sets strokes to default, is better.
        graphics.setStroke(new BasicStroke());
    }
    //fun for creating shadow Stops**************************************************************
}