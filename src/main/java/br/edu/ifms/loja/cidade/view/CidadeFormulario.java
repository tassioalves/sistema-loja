/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.cidade.view;

import br.edu.ifms.loja.cidade.datamodel.Cidade;
import br.edu.ifms.loja.uf.bo.UfBO;
import br.edu.ifms.loja.uf.datamodel.Uf;
import com.towel.combo.swing.ObjectComboBoxModel;
import java.util.List;

/**
 *
 * @author Tássio
 */
public class CidadeFormulario extends javax.swing.JPanel {

    private ObjectComboBoxModel<Uf> ufModel;
    private UfBO ufBO;

    /**
     * Creates new form CidadeFormulario
     */
    public CidadeFormulario() {
        initComponents();
        ufBO = new UfBO();
        ufModel = new ObjectComboBoxModel<Uf>();
        comboBoxUF.setModel(ufModel);
        carregarUfs();
    }

    public void carregarUfs() {
        List<Uf> ufs = ufBO.listarTodos();
        ufModel.setData(ufs);
        comboBoxUF.updateUI();
    }

    public void setSelectedUf(Uf uf) {
        ufModel.setSelectedObject(uf);
    }

    public Uf getUf() {
        return (Uf) comboBoxUF.getSelectedItem();
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
        campoNome = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        comboBoxUF = new javax.swing.JComboBox<>();

        jLabel1.setText("Nome:");

        jLabel2.setText("UF:");

        comboBoxUF.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(this);
        this.setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(campoNome))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jLabel2)
                        .addGap(18, 18, 18)
                        .addComponent(comboBoxUF, 0, 345, Short.MAX_VALUE)))
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(campoNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(comboBoxUF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(19, Short.MAX_VALUE))
        );
    }// </editor-fold>//GEN-END:initComponents


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JTextField campoNome;
    private javax.swing.JComboBox<String> comboBoxUF;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    // End of variables declaration//GEN-END:variables

    public javax.swing.JTextField getCampoNome() {
        return campoNome;
    }

    public void setCampoNome(javax.swing.JTextField campoNome) {
        this.campoNome = campoNome;
    }

    public javax.swing.JComboBox<String> getComboBoxUF() {
        return comboBoxUF;
    }

    public void setComboBoxUF(javax.swing.JComboBox<String> comboBoxUF) {
        this.comboBoxUF = comboBoxUF;
    }
}
