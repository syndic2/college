package tugasprakw7;
import java.util.*;
import javax.swing.JOptionPane;

public class Frame extends javax.swing.JFrame {
    ArrayList<user> usr= new ArrayList<>(); 
    user tempuser;
    boolean addUsr= true;
    public Frame() {
        initComponents();
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        inputUser = new javax.swing.JTextField();
        addUser = new javax.swing.JButton();
        panelChat1 = new tugasprakw7.PanelChat();
        panelChat2 = new tugasprakw7.PanelChat();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
        getContentPane().setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());
        getContentPane().add(inputUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(20, 10, 90, -1));

        addUser.setText("Add");
        addUser.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addUserActionPerformed(evt);
            }
        });
        getContentPane().add(addUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(130, 10, 60, -1));
        getContentPane().add(panelChat1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 40, 450, 460));
        getContentPane().add(panelChat2, new org.netbeans.lib.awtextra.AbsoluteConstraints(460, 40, 460, 460));

        pack();
    }// </editor-fold>//GEN-END:initComponents
    
    private void addUserActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addUserActionPerformed
        tempuser= new user();
        tempuser.setNama(inputUser.getText());
        
        for(int i= 0;i<usr.size();i++) {
            if(tempuser.getNama().equals(usr.get(i).getNama())) {
                addUsr= false;
                JOptionPane.showMessageDialog(null, "Username already used!");
            }
        }
        if(addUsr==true) {
            usr.add(tempuser);
            panelChat1.modelUser.addElement(tempuser);
            panelChat2.modelUser.addElement(tempuser);
            for(user ob: usr) {
                if(!ob.equals(tempuser)) {
                   ob.getnoFriend().add(tempuser);
                }
            }
            for(int i= 0;i<usr.size()-1;i++) {
                if(!usr.get(i).equals(tempuser)) {
                    tempuser.getnoFriend().add(usr.get(i));
                }
            }
        }
        addUsr= true;
    }//GEN-LAST:event_addUserActionPerformed
    
    public static void main(String args[]) {
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new Frame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton addUser;
    private javax.swing.JTextField inputUser;
    private tugasprakw7.PanelChat panelChat1;
    private tugasprakw7.PanelChat panelChat2;
    // End of variables declaration//GEN-END:variables
}
