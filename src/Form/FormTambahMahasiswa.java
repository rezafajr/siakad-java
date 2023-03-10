/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import com.mysql.jdbc.Statement;
import java.sql.ResultSet;
import javax.swing.JOptionPane;

/**
 *
 * @author Reza Fajri
 */
public class FormTambahMahasiswa extends javax.swing.JFrame {

    /**
     * Creates new form FormTambahJurusan
     */
    public FormTambahMahasiswa() {
        initComponents();
        isicombo();
    }
    
    public void isicombo(){
        try{
            Statement statement = (Statement)KoneksiDB.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("select * from tb_jurusan");
            while(rs.next()){
                cmb_jurusan.addItem(rs.getString("nama_jurusan"));
            }
            statement.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal mengambil data!!");
        }    
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        bg_jk = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        txt_alamat = new javax.swing.JTextField();
        txt_nim = new javax.swing.JTextField();
        btn_simpan = new javax.swing.JButton();
        btn_batal = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_view = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        rd_lk = new javax.swing.JRadioButton();
        rd_pl = new javax.swing.JRadioButton();
        jLabel5 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        cmb_jurusan = new javax.swing.JComboBox<>();
        txt_namamhs = new javax.swing.JTextField();
        jLabel7 = new javax.swing.JLabel();
        txt_angkatan = new javax.swing.JTextField();
        txt_id = new javax.swing.JTextField();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setBackground(new java.awt.Color(153, 153, 153));
        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 18)); // NOI18N
        jLabel1.setForeground(new java.awt.Color(255, 255, 255));
        jLabel1.setText("FORM TAMBAH MAHASISWA");

        jLabel2.setBackground(new java.awt.Color(153, 153, 153));
        jLabel2.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel2.setForeground(new java.awt.Color(255, 255, 255));
        jLabel2.setText("NIM");

        jLabel3.setBackground(new java.awt.Color(153, 153, 153));
        jLabel3.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel3.setForeground(new java.awt.Color(255, 255, 255));
        jLabel3.setText("Alamat");

        txt_nim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_nimActionPerformed(evt);
            }
        });

        btn_simpan.setText("Simpan");
        btn_simpan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_simpanActionPerformed(evt);
            }
        });

        btn_batal.setText("Batal");
        btn_batal.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_batalActionPerformed(evt);
            }
        });

        btn_edit.setText("Edit");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_view.setText("View");
        btn_view.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_viewActionPerformed(evt);
            }
        });

        jLabel4.setBackground(new java.awt.Color(153, 153, 153));
        jLabel4.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel4.setForeground(new java.awt.Color(255, 255, 255));
        jLabel4.setText("Nama Mahasiswa");

        bg_jk.add(rd_lk);
        rd_lk.setText("Laki - Laki");

        bg_jk.add(rd_pl);
        rd_pl.setText("Perempuan");
        rd_pl.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                rd_plActionPerformed(evt);
            }
        });

        jLabel5.setBackground(new java.awt.Color(153, 153, 153));
        jLabel5.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel5.setForeground(new java.awt.Color(255, 255, 255));
        jLabel5.setText("Jenis Kelamin");

        jLabel6.setBackground(new java.awt.Color(153, 153, 153));
        jLabel6.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel6.setForeground(new java.awt.Color(255, 255, 255));
        jLabel6.setText("Jurusan");

        cmb_jurusan.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "-- Pilih Jurusan --" }));
        cmb_jurusan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                cmb_jurusanActionPerformed(evt);
            }
        });

        jLabel7.setBackground(new java.awt.Color(153, 153, 153));
        jLabel7.setFont(new java.awt.Font("Trebuchet MS", 0, 12)); // NOI18N
        jLabel7.setForeground(new java.awt.Color(255, 255, 255));
        jLabel7.setText("Angkatan");

        txt_angkatan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_angkatanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(80, 80, 80)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel2)
                        .addGap(84, 84, 84)
                        .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(jLabel6))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addComponent(btn_simpan, javax.swing.GroupLayout.PREFERRED_SIZE, 84, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(16, 16, 16)
                        .addComponent(btn_batal, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btn_edit, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(20, 20, 20)
                        .addComponent(btn_view, javax.swing.GroupLayout.PREFERRED_SIZE, 80, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(7, 7, 7)
                                .addComponent(jLabel4))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(10, 10, 10)
                                .addComponent(jLabel5)))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(rd_lk)
                                .addGap(9, 9, 9)
                                .addComponent(rd_pl))
                            .addComponent(txt_namamhs, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(10, 10, 10)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel7)
                                .addGap(54, 54, 54))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel3)
                                .addGap(68, 68, 68)))
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addComponent(txt_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, 207, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(txt_angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, 110, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(cmb_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(txt_id)))
                        .addGap(69, 69, 69)))
                .addGap(10, 10, 10))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addComponent(jLabel1)
                .addGap(19, 19, 19)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txt_nim, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(11, 11, 11)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(txt_namamhs, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel5)
                    .addComponent(rd_lk)
                    .addComponent(rd_pl))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(cmb_jurusan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(txt_id, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(txt_angkatan, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txt_alamat, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(btn_simpan)
                    .addComponent(btn_batal)
                    .addComponent(btn_edit)
                    .addComponent(btn_view))
                .addContainerGap(49, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
        );

        setSize(new java.awt.Dimension(416, 364));
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void txt_nimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_nimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_nimActionPerformed

    private void btn_simpanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_simpanActionPerformed
        if(txt_nim.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "NIM Mahasiswa Tidak Boleh Kosong");
        }else if (txt_namamhs.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Nama Mahasiswa Tidak Boleh Kosong");
        }else if (txt_angkatan.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Angkatan Mahasiswa Tidak Boleh Kosong");
        }else if (txt_alamat.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null, "Alamat Mahasiswa Tidak Boleh Kosong");
        }else{
            if(rd_lk.isSelected() || rd_pl.isSelected()){
                String v_idjur = null;
                String v_namajur = String.valueOf(cmb_jurusan.getSelectedItem());
                String v_nim = String.valueOf(txt_nim.getText());
                String v_nama = String.valueOf(txt_namamhs.getText());
                String v_jk = null;
        
                if(rd_lk.isSelected()){
                    v_jk = "Laki-Laki";
                }else if (rd_pl.isSelected()){
                    v_jk = "Perempuan";
                }
        
        
                String v_angkatan = String.valueOf(txt_angkatan.getText());
                String v_alamat = String.valueOf(txt_alamat.getText());
                try{
                    java.sql.Statement statement = (java.sql.Statement)KoneksiDB.getConnection().createStatement();
                    ResultSet rs = statement.executeQuery("SELECT * FROM tb_jurusan WHERE nama_jurusan = '"+v_namajur+"' ");
                    while(rs.next()){
                        v_idjur = rs.getString("id_jurusan");
                        v_namajur = rs.getString("nama_jurusan");
                
//                  cmb_jurusan.setSelectedItem(v_namajur);   
                }
                rs.close();
                String v_jurusan = String.valueOf(v_idjur);
//                  txt_nim.setText(v_nama);
                statement.executeUpdate("INSERT INTO tb_mhs VALUES ('"+ v_nim +"','"+ v_nama +"','"+ v_jk +"','"+ v_jurusan +"','"+ v_angkatan +"','"+ v_alamat +"') ");    
                JOptionPane.showMessageDialog(null, "Berhasil Menambahkan");
                
                txt_nim.setText("");
                txt_namamhs.setText("");
                bg_jk.clearSelection();
                cmb_jurusan.setSelectedIndex(0);
                txt_id.setText("");;
                txt_angkatan.setText("");
                txt_alamat.setText("");
                txt_nim.requestFocus();
            
                }catch(Exception e){
                    JOptionPane.showMessageDialog(null, "Gagal Ambil Nilai ID Jurusan");
                }
            }else{
                JOptionPane.showMessageDialog(null, "Jenis Kelamin Tidak Boleh Kosong!");
            }
        
        }
    }//GEN-LAST:event_btn_simpanActionPerformed

    private void btn_batalActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_batalActionPerformed
        // TODO add your handling code here:
        txt_nim.setText("");
        txt_namamhs.setText("");
        bg_jk.clearSelection();
        cmb_jurusan.setSelectedIndex(0);
        txt_id.setText("");;
        txt_angkatan.setText("");
        txt_alamat.setText("");
        txt_nim.requestFocus();
    }//GEN-LAST:event_btn_batalActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        if(txt_nim.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"ID Jurusan Tidak Boleh Kosong");
        }
        else if(txt_namamhs.getText().trim().equals("")){
            JOptionPane.showMessageDialog(null,"Nama Jurusan Tidak Boleh Kosong");
        }
        else{
            String id = String.valueOf(txt_nim.getText());
            String nama_mhs = String.valueOf(txt_namamhs.getText());
            String v_jk = null;
        
                if(rd_lk.isSelected()){
                    v_jk = "Laki-Laki";
                }else if (rd_pl.isSelected()){
                    v_jk = "Perempuan";
                }
            String v_id = String.valueOf(txt_id.getText());
            String v_angkatan = String.valueOf(txt_angkatan.getText());
            String v_alamat = String.valueOf(txt_alamat.getText());
            try{
                java.sql.Statement statement = (java.sql.Statement)KoneksiDB.getConnection().createStatement();
                
                statement.executeUpdate("update tb_mhs set nama_mahasiswa = '"+ nama_mhs +"', jk_mhs = '"+ v_jk +"', id_jurusan = '"+ v_id +"', angkatan = '"+ v_angkatan +"', alamat = '"+ v_alamat +"'  where nim = '"+ id +"'");
                statement.close();
                JOptionPane.showMessageDialog(null,"Data berhasil di input");
                
                txt_nim.setText("");
                txt_namamhs.setText("");
                txt_id.setText("");
                txt_angkatan.setText("");
                txt_alamat.setText("");
                txt_nim.requestFocus();
                bg_jk.clearSelection();
                cmb_jurusan.setSelectedItem("--Pilih Jurusan--");
                txt_nim.requestFocus();
            }catch(Exception e){
                
            }
        }
    }//GEN-LAST:event_btn_editActionPerformed

    private void btn_viewActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_viewActionPerformed
        FormMahasiswa mahasiswa = new FormMahasiswa();
        mahasiswa.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_viewActionPerformed

    private void txt_angkatanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_angkatanActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_angkatanActionPerformed

    private void rd_plActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_rd_plActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_rd_plActionPerformed

    private void cmb_jurusanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_cmb_jurusanActionPerformed
        String v_idjur =  "";
        String v_namajur = String.valueOf(cmb_jurusan.getSelectedItem());
        
        try{
            Statement statement = (Statement)KoneksiDB.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("select * from tb_jurusan where "
                    + "nama_jurusan = '"+ v_namajur +"' ");
            while(rs.next()){
                v_idjur = rs.getString("id_jurusan");
                v_namajur = rs.getString("nama_jurusan");
                
                cmb_jurusan.setSelectedItem(v_namajur);
                txt_id.setText(v_idjur);
            }
            statement.close();
        }catch(Exception e){
            JOptionPane.showMessageDialog(null, "Gagal mengambil data!!");
        }
    }//GEN-LAST:event_cmb_jurusanActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        /* Set the Nimbus look and feel */
        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
         */
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Nimbus".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(FormTambahMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormTambahMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormTambahMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormTambahMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormTambahMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup bg_jk;
    private javax.swing.JButton btn_batal;
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_simpan;
    private javax.swing.JButton btn_view;
    public javax.swing.JComboBox<String> cmb_jurusan;
    public javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    public javax.swing.JRadioButton rd_lk;
    public javax.swing.JRadioButton rd_pl;
    public javax.swing.JTextField txt_alamat;
    public javax.swing.JTextField txt_angkatan;
    private javax.swing.JTextField txt_id;
    public javax.swing.JTextField txt_namamhs;
    public javax.swing.JTextField txt_nim;
    // End of variables declaration//GEN-END:variables
}
