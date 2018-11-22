/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.edu.ifms.loja.app.layouts;

import java.awt.Component;
import java.util.Arrays;
import java.util.List;
import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JPanel;
import javax.swing.JRadioButton;
import javax.swing.JSlider;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.JTree;

/**
 *
 * @author Gustavo
 */
public class ControleDeFormulario {

    private ControleDeFormulario() {

    }

    private static List<Class> tiposDeCampos = Arrays.asList(
            JTextField.class,
            JTextArea.class,
            JComboBox.class,
            JCheckBox.class,
            JRadioButton.class,
            ButtonGroup.class,
            JSpinner.class,
            JSlider.class,
            JTree.class
    );

    /**
     * Percorre um JPanel que represente um formulário e habilita a edição dos
     * campos.
     *
     * @param formulario Um JPanel que represente um formulário
     */
    public static void habilitarCampos(JPanel formulario) {
        setEnable(formulario.getComponents(), 0, true);
    }

    /**
     * Percorre um JPanel que represente um formulário e desabilita a edição dos
     * campos.
     *
     * @param formulario Um JPanel que represente um formulário
     */
    public static void desabilitarCampos(JPanel formulario) {
        setEnable(formulario.getComponents(), 0, false);
    }

    /**
     * Método que varre um array de componentes e busca campos para serem
     * habilitados ou desabilitados. Este método é recursivo e pode habilitar e
     * desabilitar subcomponentes também.
     *
     * @param components 
     * Array com os componentes a serem analisados.
     * @param i
     * Índice no array do componente a ser testado.
     * @param estado
     * Indica se o componente vai ser habilitado ou desabilitado.
     * true: para habilitar campos.
     * false: para desabilitar campos.
     */
    private static void setEnable(Component[] components, int i, boolean estado) {
        if (components.length == i) {
            return;
        }
        if (eUmCampo(components[i])) {
            components[i].setEnabled(estado);
        }
        if (components[i] instanceof JPanel) {
            JPanel subFormulario = (JPanel) components[i];
            setEnable(subFormulario.getComponents(), 0, estado);
        }

        setEnable(components, ++i, estado);
    }

    private static void limparCampos(Component[] components, int i, boolean estado) {
        if (components.length == i) {
            return;
        }
        if (components[i] instanceof JTextField) {
           JTextField campo = (JTextField) components[i];
           campo.setText("");
           
        }
        if (components[i] instanceof JPanel) {
            JPanel subFormulario = (JPanel) components[i];
            setEnable(subFormulario.getComponents(), 0, estado);
        }
        setEnable(components, ++i, estado);
    }

    /**
     * Método que verifica se um determinado componente é um campo previsto para
     * ser controlado. Leia-se éUmCampo.
     *
     * @param c Componente a ser testado
     * @return true: se o componente é um campo previsto pra ser controlado.
     * false: se o componente é um componente qualquer.
     */
    private static boolean eUmCampo(Component c) {
        for (Class clazz : tiposDeCampos) {
            if (clazz.isInstance(c)) {
                return true;
            }
        }
        return false;
    }
}
