/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package Sales;
//For shadow
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.border.LineBorder;

import javax.swing.*;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;

/**
 *
 * @author Vicky
 */
public class SalesToolbar extends javax.swing.JPanel {

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
     * Creates new form SalesToolbar
     */
    public SalesToolbar()
    {
     
      //  private BufferedImage img;
        setOpaque(false);
        initComponents();
        stdpbtn3.setVisible(false);
        System.out.println("Done.........");
       
        //ImageIcon a=new ImageIcon("C:\\Users\\Vicky\\Documents\\NetBeansProjects\\SampleCollegeDemo\\src\\images\\logo_1129757_web.jpg");
      //  jButton16.setText("<Html><Center>"+"Curricular"+"<br>"+"Activities"+"</center></html>");
       // jButton16.setIcon(a);
    }
    
     

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jButton15 = new javax.swing.JButton();
        jPanel1 = new javax.swing.JPanel();
        jButton1 = new javax.swing.JButton();
        jButton2 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        stdpbtn5 = new javax.swing.JButton();
        stdpbtn3 = new javax.swing.JButton();

        jButton15.setText("jButton15");

        setBackground(java.awt.SystemColor.controlHighlight);
        setMaximumSize(new java.awt.Dimension(1000, 90));
        setMinimumSize(new java.awt.Dimension(1000, 90));
        setOpaque(false);
        setPreferredSize(new java.awt.Dimension(1300, 125));

        jPanel1.setBackground(new java.awt.Color(204, 204, 204));
        jPanel1.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "Add/Edit/Del", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N
        jPanel1.setPreferredSize(new java.awt.Dimension(770, 100));

        jButton1.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton1.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/student/gold_sale_2.png"))); // NOI18N
        jButton1.setText(" Gold_Sale");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        jButton2.setFont(new java.awt.Font("Times New Roman", 1, 14));
        jButton2.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/student/silver_sale.png"))); // NOI18N
        jButton2.setText("Silver_sale");
        jButton2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton2ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jButton1)
                .addGap(18, 18, 18)
                .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 194, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 63, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jButton2, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));
        jPanel2.setBorder(javax.swing.BorderFactory.createTitledBorder(javax.swing.BorderFactory.createLineBorder(new java.awt.Color(0, 0, 0)), "View/Search/Print", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Times New Roman", 1, 14))); // NOI18N

        stdpbtn5.setFont(new java.awt.Font("Lucida Sans", 1, 12));
        stdpbtn5.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/student/Detail.png"))); // NOI18N
        stdpbtn5.setText("Report");
        stdpbtn5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdpbtn5ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(stdpbtn5)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addComponent(stdpbtn5, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        stdpbtn3.setFont(new java.awt.Font("Lucida Sans", 1, 12));
        stdpbtn3.setIcon(new javax.swing.ImageIcon(getClass().getResource("/Logos/student/messg5.png"))); // NOI18N
        stdpbtn3.setText(" Messaging");
        stdpbtn3.setIconTextGap(0);
        stdpbtn3.setMaximumSize(new java.awt.Dimension(35, 10));
        stdpbtn3.setMinimumSize(new java.awt.Dimension(35, 10));
        stdpbtn3.setPreferredSize(new java.awt.Dimension(35, 10));
        stdpbtn3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                stdpbtn3ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, 407, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(stdpbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 193, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(503, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, 103, Short.MAX_VALUE)))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(24, 24, 24)
                        .addComponent(stdpbtn3, javax.swing.GroupLayout.PREFERRED_SIZE, 65, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap())
        );
    }// </editor-fold>//GEN-END:initComponents

    private void stdpbtn3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdpbtn3ActionPerformed

        
        
        Admin.Forms.MainMenu.PanelInfo.removeAll();
         Admin.Forms.MainMenu.PanelInfo.repaint();
           JPanel p2helper = new Messaging();
             setMainPanel(p2helper);
    }//GEN-LAST:event_stdpbtn3ActionPerformed

    private void stdpbtn5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_stdpbtn5ActionPerformed
        // TODO add your handling code here:
         Admin.Forms.MainMenu.PanelInfo.removeAll();
         Admin.Forms.MainMenu.PanelInfo.repaint();
           JPanel p2helper = new Sales_Report();
             setMainPanel(p2helper);
    }//GEN-LAST:event_stdpbtn5ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        // TODO add your handling code here:
        Admin.Forms.MainMenu.PanelInfo.removeAll();
         Admin.Forms.MainMenu.PanelInfo.repaint();
           JPanel p2helper;
        try {
            p2helper = new Gold_sale();
            setMainPanel(p2helper);
        } catch (IOException ex) {
            Logger.getLogger(SalesToolbar.class.getName()).log(Level.SEVERE, null, ex);
        }
             
    }//GEN-LAST:event_jButton1ActionPerformed

    private void jButton2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton2ActionPerformed
        // TODO add your handling code here:
         Admin.Forms.MainMenu.PanelInfo.removeAll();
         Admin.Forms.MainMenu.PanelInfo.repaint();
           JPanel p2helper;
        try {
            p2helper = new Silver_sale();
            setMainPanel(p2helper);
        } catch (IOException ex) {
            Logger.getLogger(SalesToolbar.class.getName()).log(Level.SEVERE, null, ex);
        }
             

    }//GEN-LAST:event_jButton2ActionPerformed

     public void setMainPanel(JPanel subPanel) {
    JPanel PanelInfo=  Admin.Forms.MainMenu.PanelInfo;
    PanelInfo.removeAll();
     PanelInfo.add(subPanel);
     PanelInfo.validate();
     PanelInfo.repaint();
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton jButton1;
    private javax.swing.JButton jButton15;
    private javax.swing.JButton jButton2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JButton stdpbtn3;
    private javax.swing.JButton stdpbtn5;
    // End of variables declaration//GEN-END:variables

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
    //fun for creating shadow Stops*************************************************************
}
