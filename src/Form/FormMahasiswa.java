/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Form;

import com.sun.glass.events.MouseEvent;
import java.io.File;
import java.io.FileWriter;
import java.sql.ResultSet;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableColumn;
import javax.swing.table.TableModel;
import net.sf.jasperreports.engine.JasperCompileManager;
import net.sf.jasperreports.engine.JasperFillManager;
import net.sf.jasperreports.engine.JasperPrint;
import net.sf.jasperreports.engine.JasperReport;
import net.sf.jasperreports.engine.design.JasperDesign;
import net.sf.jasperreports.engine.xml.JRXmlLoader;
import net.sf.jasperreports.view.JasperViewer;
/**
 *
 * @author Reza Fajri
 */
public class FormMahasiswa extends javax.swing.JFrame {

    /**
     * Creates new form Mahasiswa
     */
    public FormMahasiswa() {
        initComponents();
        LebarKolom();
        TampilData();
    }
    
    JasperReport jasperReport;
    JasperDesign jasperDesign;
    JasperPrint jasperPrint;
    Map<String,Object> param = new HashMap<String,Object>();
    
    private void LebarKolom(){
        TableColumn kolom;
        tbl_mhs.getColumnModel().getColumn(0).setPreferredWidth(20);
        tbl_mhs.getColumnModel().getColumn(3).setPreferredWidth(100);
        tbl_mhs.getColumnModel().getColumn(1).setPreferredWidth(20);
        tbl_mhs.getColumnModel().getColumn(0).setPreferredWidth(100);
        tbl_mhs.getColumnModel().getColumn(0).setPreferredWidth(10);
        tbl_mhs.getColumnModel().getColumn(3).setPreferredWidth(50);
    }
    
    private void TampilData(){
        DefaultTableModel model = new DefaultTableModel();
        model.addColumn("NIM");
        model.addColumn("Nama");
        model.addColumn("Jenis Kelamin");
        model.addColumn("Jurusan");
        model.addColumn("Angkatan");
        model.addColumn("Alamat");
        
        tbl_mhs.setModel(model);
        LebarKolom();
        
        
        try{
            Statement statement = (Statement)KoneksiDB.getConnection().createStatement();
            ResultSet rs = statement.executeQuery("Select * From tb_mhs natural join tb_jurusan");
                while(rs.next()){
                    model.addRow(new Object[]{
                        rs.getString("nim"),
                        rs.getString("nama_mahasiswa"),
                        rs.getString("jk_mhs"),
                        rs.getString("nama_jurusan"),
                        rs.getString("angkatan"),
                        rs.getString("alamat"),
                    });
                }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane,"Gagal menampilkan data");
        }
    }
    
    private void CariData(String key){
        DefaultTableModel table = new DefaultTableModel();
        table.addColumn("NIM");
        table.addColumn("Nama Mahasiswa");
        table.addColumn("Jenis Kelamin");
        table.addColumn("Nama Jurusan");
        table.addColumn("Angkatan");
        table.addColumn("Alamat");
        
        tbl_mhs.setModel(table);
        LebarKolom();
        try{
            Statement statement = (Statement)KoneksiDB.getConnection().createStatement();
            ResultSet query = statement.executeQuery("SELECT * FROM tb_mhs natural join tb_jurusan WHERE nim LIKE '%"+key+"%' OR nama_mahasiswa LIKE '%"+key+"%' OR jk_mhs LIKE '%"+key+"%' OR nama_jurusan LIKE '%"+key+"%' OR angkatan LIKE '%"+key+"%' OR alamat LIKE '%"+key+"%'");
            while(query.next()){
                table.addRow(new Object[]{
                    query.getString("nim"),
                    query.getString("nama_mahasiswa"),
                    query.getString("jk_mhs"),
                    query.getString("nama_jurusan"),
                    query.getString("angkatan"),
                    query.getString("alamat")
                });
            }
        }catch(Exception e){
            JOptionPane.showMessageDialog(rootPane, "Gagal Menampilkan Data!");
        }
    }
    
    public void cetakexcel(){
        FileWriter fileWriter;
        JFileChooser chooser = new JFileChooser();
        chooser.setCurrentDirectory(new File("[B]export_output/excel[/B]"));
        int retrival = chooser.showSaveDialog(null);
        if (retrival == JFileChooser.APPROVE_OPTION) {
            try{
                TableModel tModel = tbl_mhs.getModel();
                fileWriter = new FileWriter(new File(chooser.getSelectedFile() + ".xls"));           
            // write header
                for(int i = 0; i < tModel.getColumnCount(); i++){
                fileWriter.write(tModel.getColumnName(i).toUpperCase() + "\t");
            }
                fileWriter.write("\n");
            // write record
                for(int i=0; i < tModel.getRowCount(); i++) {
                for(int j=0; j < tModel.getColumnCount(); j++) {
                fileWriter.write(tModel.getValueAt(i,j).toString() + "\t");
            }
                fileWriter.write("\n");
            }
                fileWriter.close();
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, e);
            }
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

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        btn_home = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        btn_tambah = new javax.swing.JButton();
        btn_edit = new javax.swing.JButton();
        btn_hapus = new javax.swing.JButton();
        btn_refresh = new javax.swing.JButton();
        jLabel2 = new javax.swing.JLabel();
        txt_cari = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tbl_mhs = new javax.swing.JTable();
        btn_excel = new javax.swing.JButton();
        btn_pdf = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(153, 153, 153));

        jLabel1.setFont(new java.awt.Font("Trebuchet MS", 1, 36)); // NOI18N
        jLabel1.setText("Data Mahasiswa");

        btn_home.setText("HOME");
        btn_home.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_homeActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_home)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(158, 158, 158))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGap(21, 21, 21)
                        .addComponent(jLabel1))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(btn_home)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel2.setBackground(new java.awt.Color(204, 204, 204));

        btn_tambah.setText("TAMBAH");
        btn_tambah.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_tambahActionPerformed(evt);
            }
        });

        btn_edit.setText("EDIT");
        btn_edit.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_editActionPerformed(evt);
            }
        });

        btn_hapus.setText("HAPUS");
        btn_hapus.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_hapusActionPerformed(evt);
            }
        });

        btn_refresh.setText("REFRESH");
        btn_refresh.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_refreshActionPerformed(evt);
            }
        });

        jLabel2.setText("Cari");

        txt_cari.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                txt_cariActionPerformed(evt);
            }
        });
        txt_cari.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                txt_cariKeyReleased(evt);
            }
        });

        tbl_mhs.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null},
                {null, null, null, null}
            },
            new String [] {
                "Title 1", "Title 2", "Title 3", "Title 4"
            }
        ));
        tbl_mhs.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                tbl_mhsMouseClicked(evt);
            }
        });
        jScrollPane1.setViewportView(tbl_mhs);

        btn_excel.setText("EXCEL");
        btn_excel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_excelActionPerformed(evt);
            }
        });

        btn_pdf.setText("PDF");
        btn_pdf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btn_pdfActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(btn_tambah)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_edit)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_hapus)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_refresh)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(btn_excel)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(btn_pdf)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 30, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, 75, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(jPanel2Layout.createSequentialGroup()
                    .addContainerGap()
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 564, Short.MAX_VALUE)
                    .addContainerGap()))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btn_tambah)
                    .addComponent(btn_edit)
                    .addComponent(btn_hapus)
                    .addComponent(btn_refresh)
                    .addComponent(txt_cari, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel2)
                    .addComponent(btn_excel)
                    .addComponent(btn_pdf))
                .addContainerGap(356, Short.MAX_VALUE))
            .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                    .addContainerGap(50, Short.MAX_VALUE)
                    .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 329, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addContainerGap()))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(18, 18, 18)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
        setLocationRelativeTo(null);
    }// </editor-fold>//GEN-END:initComponents

    private void btn_tambahActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_tambahActionPerformed
        // TODO add your handling code here:
        FormTambahMahasiswa mhs = new FormTambahMahasiswa();
        mhs.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_tambahActionPerformed

    private void btn_editActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_editActionPerformed
        // TODO add your handling code here:
        FormTambahMahasiswa tambahmahasiswa = new FormTambahMahasiswa();
        tambahmahasiswa.setVisible(true);
        dispose();
        
        tambahmahasiswa.jLabel1.setText("Form Edit Mahasiswa");
        tambahmahasiswa.txt_nim.setEditable(false);
        tambahmahasiswa.txt_namamhs.requestFocus();
        tambahmahasiswa.txt_nim.setText((String) tbl_mhs.getValueAt(tbl_mhs.getSelectedRow(), 0));
        tambahmahasiswa.txt_namamhs.setText((String) tbl_mhs.getValueAt(tbl_mhs.getSelectedRow(), 1));
        String jk = String.valueOf(tbl_mhs.getValueAt(tbl_mhs.getSelectedRow(), 2));
        if ("Laki-Laki".equals(jk)){
            tambahmahasiswa.rd_lk.setSelected(true);
        }
        else if ("Perempuan".equals(jk)){
            tambahmahasiswa.rd_pl.setSelected(true);
        }
        String jr = String.valueOf(tbl_mhs.getValueAt(tbl_mhs.getSelectedRow(), 3));
        tambahmahasiswa.cmb_jurusan.setSelectedItem(jr);
       
//        tambahmahasiswa.rd_lk.((tbl_jurusan.getSelectedRow(), 0) == "L") ? "checked='checked'" : "")."/> L".;
        tambahmahasiswa.txt_angkatan.setText((String) tbl_mhs.getValueAt(tbl_mhs.getSelectedRow(), 4));
        tambahmahasiswa.txt_alamat.setText((String) tbl_mhs.getValueAt(tbl_mhs.getSelectedRow(), 5));
        dispose();
    }//GEN-LAST:event_btn_editActionPerformed

    private void tbl_mhsMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_tbl_mhsMouseClicked
        // TODO add your handling code here:
    }//GEN-LAST:event_tbl_mhsMouseClicked

    private void btn_hapusActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_hapusActionPerformed
        if(tbl_mhs.getSelectionModel().isSelectionEmpty()){
             JOptionPane.showMessageDialog(null, "Silahkan pilih data yang ingin dihapus");
        }else{
            try{
                int jawab;
                if((jawab = JOptionPane.showConfirmDialog(null, "Ingin Menghapus Data?", "Konfirmasi", JOptionPane.YES_NO_OPTION)) == 0){
                    Statement statement = (Statement)KoneksiDB.getConnection().createStatement();
                    statement.executeUpdate("DELETE FROM tb_mhs WHERE nim = '"+tbl_mhs.getValueAt(tbl_mhs.getSelectedRow(), 0)+"' ");
                    statement.close();
                    JOptionPane.showMessageDialog(null, "Data Berhasil DiHapus");
                }
            
            }catch(Exception e){
                JOptionPane.showMessageDialog(null, "Data Gagal Dihapus");
            }
        }
    }//GEN-LAST:event_btn_hapusActionPerformed

    private void txt_cariActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_txt_cariActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_txt_cariActionPerformed

    private void txt_cariKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_txt_cariKeyReleased
        // TODO add your handling code here:
        String key = String.valueOf(txt_cari.getText());
        System.out.println(key);
        if(key != ""){
            CariData(key);
        }else{
            TampilData();
        }
    }//GEN-LAST:event_txt_cariKeyReleased

    private void btn_refreshActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_refreshActionPerformed
        // TODO add your handling code here:
        TampilData();
    }//GEN-LAST:event_btn_refreshActionPerformed

    private void btn_excelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_excelActionPerformed
        // TODO add your handling code here:
        cetakexcel();
    }//GEN-LAST:event_btn_excelActionPerformed

    private void btn_pdfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_pdfActionPerformed
        // TODO add your handling code here:
        try{
            File file = new File("src/Form/report_mhs.jrxml");
            jasperDesign = JRXmlLoader.load(file);
            param.clear();
            jasperReport = JasperCompileManager.compileReport(jasperDesign);
            jasperPrint = JasperFillManager.fillReport(jasperReport, param, KoneksiDB.getConnection());
            JasperViewer.viewReport(jasperPrint,false);
        }catch(Exception e){
            e.printStackTrace();
        }
    }//GEN-LAST:event_btn_pdfActionPerformed

    private void btn_homeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btn_homeActionPerformed
        // TODO add your handling code here:
        FormMaster home = new FormMaster();
        home.setVisible(true);
        dispose();
    }//GEN-LAST:event_btn_homeActionPerformed

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
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(FormMahasiswa.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new FormMahasiswa().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btn_edit;
    private javax.swing.JButton btn_excel;
    private javax.swing.JButton btn_hapus;
    private javax.swing.JButton btn_home;
    private javax.swing.JButton btn_pdf;
    private javax.swing.JButton btn_refresh;
    private javax.swing.JButton btn_tambah;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JTable tbl_mhs;
    private javax.swing.JTextField txt_cari;
    // End of variables declaration//GEN-END:variables
}
