package tugasprakw7;
import java.util.*;
import javax.swing.DefaultComboBoxModel;
import javax.swing.DefaultListModel;

public class PanelChat extends javax.swing.JPanel {
    DefaultListModel<user> modelUser;
    DefaultListModel<user> modelAddFriend;
    DefaultComboBoxModel<user> modelPending;
    DefaultComboBoxModel<user> modelReceiver;
    public PanelChat() {
        initComponents();
        modelUser= new DefaultListModel<>();
        modelAddFriend= new DefaultListModel<>();
        modelPending= new DefaultComboBoxModel<>();
        modelReceiver= new DefaultComboBoxModel<>();
        listUser.setModel(modelUser);
        listAddFriend.setModel(modelAddFriend);
        listPendingReq.setModel(modelPending);
        listReceiver.setModel(modelReceiver);   
    }
    
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        listUser = new javax.swing.JList();
        labelUser = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        listReceiver = new javax.swing.JComboBox();
        jScrollPane2 = new javax.swing.JScrollPane();
        screenChat = new javax.swing.JTextArea();
        sendMess = new javax.swing.JTextField();
        jButton1 = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        addFriend = new javax.swing.JButton();
        jScrollPane3 = new javax.swing.JScrollPane();
        listAddFriend = new javax.swing.JList();
        jLabel3 = new javax.swing.JLabel();
        listPendingReq = new javax.swing.JComboBox();
        acceptFriend = new javax.swing.JButton();
        ignoreFriend = new javax.swing.JButton();

        setLayout(new org.netbeans.lib.awtextra.AbsoluteLayout());

        listUser.addListSelectionListener(new javax.swing.event.ListSelectionListener() {
            public void valueChanged(javax.swing.event.ListSelectionEvent evt) {
                listUserValueChanged(evt);
            }
        });
        jScrollPane1.setViewportView(listUser);

        add(jScrollPane1, new org.netbeans.lib.awtextra.AbsoluteConstraints(10, 10, 150, 220));
        add(labelUser, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 20, 60, 20));

        jLabel1.setText("Select Receiver: ");
        add(jLabel1, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 50, -1, -1));

        add(listReceiver, new org.netbeans.lib.awtextra.AbsoluteConstraints(270, 50, 118, -1));

        screenChat.setColumns(20);
        screenChat.setRows(5);
        jScrollPane2.setViewportView(screenChat);

        add(jScrollPane2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 80, 260, 130));
        add(sendMess, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 220, 170, 20));

        jButton1.setText("Send");
        add(jButton1, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 220, 80, -1));

        jLabel2.setText("Add Friend");
        add(jLabel2, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 260, -1, -1));

        addFriend.setText("Add");
        addFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                addFriendActionPerformed(evt);
            }
        });
        add(addFriend, new org.netbeans.lib.awtextra.AbsoluteConstraints(240, 260, -1, -1));

        jScrollPane3.setViewportView(listAddFriend);

        add(jScrollPane3, new org.netbeans.lib.awtextra.AbsoluteConstraints(170, 300, 160, -1));

        jLabel3.setText("Pending Request");
        add(jLabel3, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 260, -1, 22));

        add(listPendingReq, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 290, 80, -1));

        acceptFriend.setText("Accept");
        acceptFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                acceptFriendActionPerformed(evt);
            }
        });
        add(acceptFriend, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 330, -1, -1));

        ignoreFriend.setText("Ignore");
        ignoreFriend.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                ignoreFriendActionPerformed(evt);
            }
        });
        add(ignoreFriend, new org.netbeans.lib.awtextra.AbsoluteConstraints(350, 370, -1, -1));
    }// </editor-fold>//GEN-END:initComponents
    
    private void listUserValueChanged(javax.swing.event.ListSelectionEvent evt) {//GEN-FIRST:event_listUserValueChanged
        labelUser.setText(listUser.getSelectedValue().toString());
        modelAddFriend.removeAllElements();
        modelPending.removeAllElements();
        modelReceiver.removeAllElements();
        user active = (user)(listUser.getSelectedValue());
        for (int i = 0; i<active.getnoFriend().size();i++) {
            modelAddFriend.addElement((user)active.getnoFriend().get(i));
        }
        for (Object ob: active.getIncoming()) {
            modelPending.addElement((user)ob);
        }
        for (Object ob: active.getFriend()) {
            modelReceiver.addElement((user)ob);
        }
    }//GEN-LAST:event_listUserValueChanged
    
    private void addFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_addFriendActionPerformed
        user yangAdd= (user)listUser.getSelectedValue();
        user yangDiAdd= (user)listAddFriend.getSelectedValue();
        yangAdd.getOutgoing().add(yangDiAdd);
        yangDiAdd.getIncoming().add(yangAdd);
        yangAdd.getnoFriend().remove(yangDiAdd);
        yangDiAdd.getnoFriend().remove(yangAdd);
        modelAddFriend.removeAllElements();
        for (int i = 0;i<yangAdd.getnoFriend().size();i++) {
            modelAddFriend.addElement((user)yangAdd.getnoFriend().get(i));
        }
    }//GEN-LAST:event_addFriendActionPerformed
    
    private void acceptFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_acceptFriendActionPerformed
        user yangAcc = (user)listUser.getSelectedValue();
        user yangDiAcc = (user)listPendingReq.getSelectedItem();
        yangAcc.getIncoming().remove(yangDiAcc);
        yangAcc.getFriend().add(yangDiAcc);
        yangDiAcc.getOutgoing().remove(yangAcc);
        yangDiAcc.getFriend().add(yangAcc);
        modelPending.removeAllElements();
        for (Object ob: yangAcc.getIncoming()) {
            modelPending.addElement((user)ob);
        }
        modelReceiver.removeAllElements();
        for (Object ob: yangAcc.getFriend()) {
            modelReceiver.addElement((user)ob);
        }
    }//GEN-LAST:event_acceptFriendActionPerformed
        
    private void ignoreFriendActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_ignoreFriendActionPerformed
        user yangIgnore= (user)listUser.getSelectedValue();
        user yangDiIgnore= (user)listPendingReq.getSelectedItem();
        yangIgnore.getIncoming().remove(yangDiIgnore);
        yangIgnore.getnoFriend().add(yangDiIgnore);
        yangDiIgnore.getOutgoing().remove(yangIgnore);
        yangDiIgnore.getnoFriend().add(yangIgnore);
        modelPending.removeAllElements();
        for (Object ob: yangIgnore.getIncoming()) {
            modelPending.addElement((user)ob);
        }
        modelReceiver.removeAllElements();
        for (Object ob: yangDiIgnore.getFriend()) {
            modelReceiver.addElement((user)ob);
        }
    }//GEN-LAST:event_ignoreFriendActionPerformed
    
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton acceptFriend;
    private javax.swing.JButton addFriend;
    private javax.swing.JButton ignoreFriend;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JScrollPane jScrollPane3;
    private javax.swing.JLabel labelUser;
    private javax.swing.JList listAddFriend;
    private javax.swing.JComboBox listPendingReq;
    private javax.swing.JComboBox listReceiver;
    private javax.swing.JList listUser;
    private javax.swing.JTextArea screenChat;
    private javax.swing.JTextField sendMess;
    // End of variables declaration//GEN-END:variables
}
