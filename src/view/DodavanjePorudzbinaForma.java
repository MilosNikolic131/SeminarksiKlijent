/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import domen.Dusek;
import domen.Narucen;
import domen.Porudzbina;
import java.util.ArrayList;
import javax.swing.JOptionPane;
import logika.KontrolerK;
import modeli.ModelTabeleDusek;

/**
 *
 * @author Master
 */
public class DodavanjePorudzbinaForma extends javax.swing.JDialog {

    KlijentForma forma;
    Porudzbina p;
    boolean signal;
    /**
     * Creates new form DodavanjePorudzbinaForma
     */
    public DodavanjePorudzbinaForma(KlijentForma forma) {
        initComponents();
        this.forma = forma;
        srediFormu();
        signal = false;
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblStavke = new javax.swing.JTable();
        btnSacuvaj = new javax.swing.JButton();
        btnObrisi = new javax.swing.JButton();
        btnDodaj = new javax.swing.JButton();
        txtImePrezime = new javax.swing.JTextField();
        txtAdresa = new javax.swing.JTextField();
        txtNapomena = new javax.swing.JTextField();
        jToggleButton1 = new javax.swing.JToggleButton();
        lblStatus = new javax.swing.JLabel();

        setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

        jLabel1.setText("Ime i prezime:");

        jLabel2.setText("Adresa:");

        jLabel3.setText("Napomena:");

        jLabel5.setText("Stavke:");

        tblStavke.setModel(new javax.swing.table.DefaultTableModel(
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
        jScrollPane1.setViewportView(tblStavke);

        btnSacuvaj.setText("Sacuvaj porudzbinu");
        btnSacuvaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnSacuvajActionPerformed(evt);
            }
        });

        btnObrisi.setText("Obrisi stavku");
        btnObrisi.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnObrisiActionPerformed(evt);
            }
        });

        btnDodaj.setText("Dodaj stavku");
        btnDodaj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnDodajActionPerformed(evt);
            }
        });

        jToggleButton1.setText("Obradi porudzbinu");
        jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jToggleButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jScrollPane1)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtImePrezime, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel3)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(txtNapomena, javax.swing.GroupLayout.PREFERRED_SIZE, 281, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5)
                            .addGroup(layout.createSequentialGroup()
                                .addComponent(btnDodaj)
                                .addGap(18, 18, 18)
                                .addComponent(btnObrisi)
                                .addGap(18, 18, 18)
                                .addComponent(btnSacuvaj)
                                .addGap(18, 18, 18)
                                .addComponent(jToggleButton1))
                            .addComponent(lblStatus))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(txtImePrezime, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(txtAdresa, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel3)
                    .addComponent(txtNapomena, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addComponent(jLabel5)
                .addGap(18, 18, 18)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 200, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(btnSacuvaj)
                    .addComponent(btnObrisi)
                    .addComponent(btnDodaj)
                    .addComponent(jToggleButton1))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(lblStatus)
                .addContainerGap(57, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnDodajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnDodajActionPerformed
        new StavkeForma(this).setVisible(true);
    }//GEN-LAST:event_btnDodajActionPerformed

    private void btnObrisiActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnObrisiActionPerformed
        ModelTabeleDusek mtd = (ModelTabeleDusek) tblStavke.getModel();
        int red = tblStavke.getSelectedRow();
        if (red != -1) {
            mtd.obrisi(red);
        }

    }//GEN-LAST:event_btnObrisiActionPerformed

    private void btnSacuvajActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnSacuvajActionPerformed
        String ime = txtImePrezime.getText();
        String adresa = txtAdresa.getText();
        String napomena = txtNapomena.getText();
        ModelTabeleDusek mtd = (ModelTabeleDusek) tblStavke.getModel();
        double ukupno = mtd.vratiUkupno();
        int id = KontrolerK.getInstance().vratiIDPorudzbine();
        p = new Porudzbina(id, ime, adresa, napomena, ukupno);
        ModelTabeleDusek mtg = (ModelTabeleDusek) tblStavke.getModel();
        boolean validiran = KontrolerK.getInstance().validirajPorudzbinu(p, mtg);
        if (!validiran) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti porudzbinu");
            return;
        }
        if (p != null) {
            JOptionPane.showMessageDialog(this, "Sistem je zapamtio porudzbinu");
            lblStatus.setText("Uspesno zapamcena porudzbina!");
            signal = true;
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da zapamti porudzbinu");
            return;
        }


    }//GEN-LAST:event_btnSacuvajActionPerformed

    private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jToggleButton1ActionPerformed
        ModelTabeleDusek mtd = (ModelTabeleDusek) tblStavke.getModel();
        if (p == null || mtd.getLista().isEmpty() || signal == false) {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da obradi porudzbinu");
            return;
        }
        boolean signal = KontrolerK.getInstance().sacuvajPorudzbinu(p);
        if (signal) {
            JOptionPane.showMessageDialog(this, "Sistem je obradio porudzbinu");
            this.signal = false;
        } else {
            JOptionPane.showMessageDialog(this, "Sistem ne moze da obradi porudzbinu");
            return;
        }
        ArrayList<Dusek> lista = mtd.getLista();
        System.out.println(lista + "");
        sacuvajStavke(lista, p.getPorudzbinaID());
    }//GEN-LAST:event_jToggleButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
//    public static void main(String args[]) {
//        /* Set the Nimbus look and feel */
//        //<editor-fold defaultstate="collapsed" desc=" Look and feel setting code (optional) ">
//        /* If Nimbus (introduced in Java SE 6) is not available, stay with the default look and feel.
//         * For details see http://download.oracle.com/javase/tutorial/uiswing/lookandfeel/plaf.html 
//         */
//        try {
//            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
//                if ("Nimbus".equals(info.getName())) {
//                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
//                    break;
//                }
//            }
//        } catch (ClassNotFoundException ex) {
//            java.util.logging.Logger.getLogger(DodavanjePorudzbinaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (InstantiationException ex) {
//            java.util.logging.Logger.getLogger(DodavanjePorudzbinaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (IllegalAccessException ex) {
//            java.util.logging.Logger.getLogger(DodavanjePorudzbinaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
//            java.util.logging.Logger.getLogger(DodavanjePorudzbinaForma.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
//        }
//        //</editor-fold>
//
//        /* Create and display the dialog */
//        java.awt.EventQueue.invokeLater(new Runnable() {
//            public void run() {
//                DodavanjePorudzbinaForma dialog = new DodavanjePorudzbinaForma(new javax.swing.JFrame(), true);
//                dialog.addWindowListener(new java.awt.event.WindowAdapter() {
//                    @Override
//                    public void windowClosing(java.awt.event.WindowEvent e) {
//                        System.exit(0);
//                    }
//                });
//                dialog.setVisible(true);
//            }
//        });
//    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnDodaj;
    private javax.swing.JButton btnObrisi;
    private javax.swing.JButton btnSacuvaj;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JToggleButton jToggleButton1;
    private javax.swing.JLabel lblStatus;
    private javax.swing.JTable tblStavke;
    private javax.swing.JTextField txtAdresa;
    private javax.swing.JTextField txtImePrezime;
    private javax.swing.JTextField txtNapomena;
    // End of variables declaration//GEN-END:variables

    void dodaj(Dusek d, int kolicina) {
        ModelTabeleDusek mtd = (ModelTabeleDusek) tblStavke.getModel();
        if(d.getNazivDuseka().equals("") || d.getNazivDuseka().equals(" ")){
            return;
        }
        while (kolicina > 0) {
            mtd.dodaj(d);
            kolicina--;
        }

    }

    private void srediFormu() {
        ModelTabeleDusek mtd = new ModelTabeleDusek();
        tblStavke.setModel(mtd);
    }

    private void sacuvajStavke(ArrayList<Dusek> lista, int id) {
        ArrayList<Dusek> proslo = new ArrayList<>();
        System.out.println("DOBIO SAM " + lista);
        boolean flag = false;
        int count = 0;
        for (Dusek dusek : lista) {
            System.out.println("OBRADJUJEM DUSEK: " + dusek);
            for (Dusek dusek1 : proslo) {
                if (dusek.equals(dusek1)) {
                    System.out.println(dusek1 + " VEC PROSAO ");
                    flag = true;
                    break;
                } else {
                    flag = false;
                }

            }
            if (!flag) {
                count = prebroj(dusek);
                System.out.println(dusek + " " + id + " " + " " + count);
                sacuvajStavku(dusek, count, id);
                proslo.add(dusek);
            }

        }
    }

    private int prebroj(Dusek d) {
        ModelTabeleDusek mtd = (ModelTabeleDusek) tblStavke.getModel();
        ArrayList<Dusek> lista = mtd.getLista();
        int k = 0;
        for (Dusek dusek : lista) {
            if (dusek.equals(d)) {
                k++;
            }
        }
        return k;
    }

    private void sacuvajStavku(Dusek dusek, int count, int id) {
        Narucen n = new Narucen(count, dusek.getDusekID(), id);
        boolean signal = KontrolerK.getInstance().sacuvajStavku(n);
        if (signal) {

        }
    }

}
