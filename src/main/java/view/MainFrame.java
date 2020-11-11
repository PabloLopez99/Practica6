/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package view;

import control.Stack;
import control.ImageHandler;
import java.awt.Dimension;
import java.awt.Toolkit;
import java.util.List;
import java.awt.datatransfer.DataFlavor;
import java.awt.dnd.DnDConstants;
import java.awt.dnd.DropTarget;
import java.awt.dnd.DropTargetDropEvent;
import java.awt.event.ItemEvent;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.ButtonGroup;
import javax.swing.JFileChooser;
import javax.swing.JOptionPane;
import javax.swing.filechooser.FileNameExtensionFilter;

/**
 *
 * @author pabloantoniolopezmartin
 */
public class MainFrame extends javax.swing.JFrame {

    /**
     * Creates new form MainFrame
     */
    private String language;
    private FileNameExtensionFilter filter;
    private JFileChooser fc;
    private static File fichero;
    private static Stack pila;
    private String exitDialogMessage;
    private String infoDialogMessage;
    private ButtonGroup buttonGroup;
    private Boolean resize=true;
    public MainFrame() {
        initComponents();
        initialConfig("Spanish");
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jFileChooser1 = new javax.swing.JFileChooser();
        lienzo1 = new view.Lienzo();
        startInfoLabel = new javax.swing.JLabel();
        jSlider1 = new javax.swing.JSlider();
        thresholdLabel = new javax.swing.JLabel();
        authorsLabel = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        fileMenu = new javax.swing.JMenu();
        newFileMenuItem = new javax.swing.JMenuItem();
        openFileMenuItem = new javax.swing.JMenuItem();
        saveFileMenuItem = new javax.swing.JMenuItem();
        jSeparator2 = new javax.swing.JPopupMenu.Separator();
        exitMenuItem = new javax.swing.JMenuItem();
        editMenu = new javax.swing.JMenu();
        undoMenuItem = new javax.swing.JMenuItem();
        redoMenuItem = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        thresholdCheckBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        helpMenu = new javax.swing.JMenu();
        configurationMenu = new javax.swing.JMenu();
        automaticResizeBoxMenuItem = new javax.swing.JCheckBoxMenuItem();
        languageMenu = new javax.swing.JMenu();
        spanishRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();
        englishRadioButtonMenuItem = new javax.swing.JRadioButtonMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        javax.swing.GroupLayout lienzo1Layout = new javax.swing.GroupLayout(lienzo1);
        lienzo1.setLayout(lienzo1Layout);
        lienzo1Layout.setHorizontalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 626, Short.MAX_VALUE)
            .addGroup(lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lienzo1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(startInfoLabel)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );
        lienzo1Layout.setVerticalGroup(
            lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 362, Short.MAX_VALUE)
            .addGroup(lienzo1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addGroup(lienzo1Layout.createSequentialGroup()
                    .addGap(0, 0, Short.MAX_VALUE)
                    .addComponent(startInfoLabel)
                    .addGap(0, 0, Short.MAX_VALUE)))
        );

        jSlider1.setMaximum(255);
        jSlider1.setToolTipText("");
        jSlider1.setValue(0);
        jSlider1.addChangeListener(new javax.swing.event.ChangeListener() {
            public void stateChanged(javax.swing.event.ChangeEvent evt) {
                jSlider1StateChanged(evt);
            }
        });

        thresholdLabel.setText("jLabel2");

        authorsLabel.setText("Azael Santana Henríquez y Pablo López Martín");

        fileMenu.setText("File");

        newFileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_N, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        newFileMenuItem.setText("New File");
        newFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                newFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(newFileMenuItem);

        openFileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_O, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        openFileMenuItem.setText("Open File");
        openFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                openFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(openFileMenuItem);

        saveFileMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_S, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        saveFileMenuItem.setText("Save File");
        saveFileMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                saveFileMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(saveFileMenuItem);
        fileMenu.add(jSeparator2);

        exitMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_ESCAPE, 0));
        exitMenuItem.setText("Exit");
        exitMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                exitMenuItemActionPerformed(evt);
            }
        });
        fileMenu.add(exitMenuItem);

        jMenuBar1.add(fileMenu);

        editMenu.setText("Edit");

        undoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        undoMenuItem.setText("Undo");
        undoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                undoMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(undoMenuItem);

        redoMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_Z, java.awt.event.InputEvent.SHIFT_DOWN_MASK | java.awt.event.InputEvent.CTRL_DOWN_MASK));
        redoMenuItem.setText("Redo");
        redoMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                redoMenuItemActionPerformed(evt);
            }
        });
        editMenu.add(redoMenuItem);
        editMenu.add(jSeparator1);

        thresholdCheckBoxMenuItem.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_T, java.awt.event.InputEvent.CTRL_DOWN_MASK));
        thresholdCheckBoxMenuItem.setSelected(true);
        thresholdCheckBoxMenuItem.setText("Threshold");
        thresholdCheckBoxMenuItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                thresholdCheckBoxMenuItemItemStateChanged(evt);
            }
        });
        editMenu.add(thresholdCheckBoxMenuItem);

        jMenuBar1.add(editMenu);

        helpMenu.setText("Ayuda");
        helpMenu.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                helpMenuMouseClicked(evt);
            }
        });
        jMenuBar1.add(helpMenu);

        configurationMenu.setText("Configuración");

        automaticResizeBoxMenuItem.setSelected(true);
        automaticResizeBoxMenuItem.setText("Redimensión automática");
        automaticResizeBoxMenuItem.addItemListener(new java.awt.event.ItemListener() {
            public void itemStateChanged(java.awt.event.ItemEvent evt) {
                automaticResizeBoxMenuItemItemStateChanged(evt);
            }
        });
        configurationMenu.add(automaticResizeBoxMenuItem);

        languageMenu.setText("Idioma");

        spanishRadioButtonMenuItem.setSelected(true);
        spanishRadioButtonMenuItem.setText("Español");
        spanishRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                spanishRadioButtonMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(spanishRadioButtonMenuItem);

        englishRadioButtonMenuItem.setSelected(true);
        englishRadioButtonMenuItem.setText("English");
        englishRadioButtonMenuItem.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                englishRadioButtonMenuItemActionPerformed(evt);
            }
        });
        languageMenu.add(englishRadioButtonMenuItem);

        configurationMenu.add(languageMenu);

        jMenuBar1.add(configurationMenu);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(34, 34, 34)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(thresholdLabel)
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addComponent(lienzo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(authorsLabel)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jSlider1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(12, 12, 12))
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                        .addComponent(thresholdLabel)
                        .addGap(18, 18, 18)))
                .addComponent(lienzo1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(authorsLabel))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents
    private void initialConfig(String language){
        fc = new JFileChooser();
        pila= new Stack();
        this.language=language;
        this.setSize(1034,768);
        
        setDropTarget();
        thresholdLabel.setText("0");
        jSlider1.setVisible(false);
        
        thresholdCheckBoxMenuItem.setSelected(false);
        thresholdCheckBoxMenuItem.setEnabled(false);
        saveFileMenuItem.setEnabled(false);

        setButtonGroupAndInitialLanguage(language);

    }
    
    private void setButtonGroupAndInitialLanguage(String language){
        buttonGroup= new ButtonGroup();
        buttonGroup.add(spanishRadioButtonMenuItem);
        buttonGroup.add(englishRadioButtonMenuItem);
        if(language.equals("Spanish")){
            spanishRadioButtonMenuItem.setSelected(rootPaneCheckingEnabled);
        }else{
           englishRadioButtonMenuItem.setSelected(rootPaneCheckingEnabled); 
        }
       
        setLanguage(language);
    }
    
    private void setLanguage(String language){
        if(language.equals("Spanish")){
            editMenu.setText("Editar");
            exitMenuItem.setText("Salir");
            fileMenu.setText("Archivo");
            helpMenu.setText("Ayuda");
            languageMenu.setText("Idioma");
            openFileMenuItem.setText("Abrir");
            redoMenuItem.setText("Rehacer");
            saveFileMenuItem.setText("Guardar");
            startInfoLabel.setText("Elija una imagen en Archivo -> Abrir Imagen, o arrastre su imagen aquí");
            thresholdCheckBoxMenuItem.setText("Umbralizado");
            undoMenuItem.setText("Deshacer");
            exitDialogMessage="¿Está seguro de que desea salir?";
            infoDialogMessage="Use la opción FILE para: resetear el espacio de trabajo (Nuevo), abrir una imagen (también puede arrastrarla) y guardar una imagen o salir. \nUse la opción EDIT para: realizar undo, redo y aplicar el umbralizado \nLas imágenes se redimensionan por defecto a la resolución: 1024x768 (puede desactivarlo en el menú Ajustes) \nEn el menu Ajustes podrá cambiar el idioma.";
            newFileMenuItem.setText("Nuevo");
            configurationMenu.setText("Configuración");
            automaticResizeBoxMenuItem.setText("Redimensión automática");
        }else if(language.equals("English")){
            editMenu.setText("Edit");
            exitMenuItem.setText("Exit");
            fileMenu.setText("File");
            helpMenu.setText("Help");
            languageMenu.setText("Language");
            openFileMenuItem.setText("Open");
            redoMenuItem.setText("Redo");
            saveFileMenuItem.setText("Save");
            startInfoLabel.setText("Choose an image in File -> Open Image, or drop an image here");
            thresholdCheckBoxMenuItem.setText("Threshold");
            undoMenuItem.setText("Undo");
            exitDialogMessage="Are you sure that you want to exit?";
            infoDialogMessage="Use the option FILE to: reset the workspace (New), to open an image (it also can be dropped) and to save the image or exit. \nUse the option EDIT: to undo, redo and apply threshold \nBy default, images are resized to 1024x768 (you can disable this in the Settings menu) \nIn the Settings menu you can change de language.";
            newFileMenuItem.setText("New");
            configurationMenu.setText("Settings");
            automaticResizeBoxMenuItem.setText("Automatic rescale");
        }
        
    }
    
    private void openFileActions(){
        startInfoLabel.setText("");
        saveFileMenuItem.setEnabled(true);
        thresholdCheckBoxMenuItem.setEnabled(true);
    }
    
    private void setFileChooser(){
        fc.setAcceptAllFileFilterUsed(false);
        filter = new FileNameExtensionFilter("Imágenes (png, jpg, jpeg, bmp)","png","jpg","jpeg","bmp");
        fc.addChoosableFileFilter(filter);
     
    }
    
    private void openFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_openFileMenuItemActionPerformed
        setFileChooser();
        int res = fc.showOpenDialog(null);
        if(res==JFileChooser.APPROVE_OPTION){
            File fichero = fc.getSelectedFile();
            this.fichero=fichero;
            Dimension dimension=ImageHandler.openImage(fichero,resize);
            if(dimension!=null){
                openFileActions();
            }
        
            lienzo1.repaint();
            sliderVisible(false);
            undoRedoEnable(false);
            thresholdCheckBoxMenuItem.setState(false);
            setBounds(0,0,dimension.width+50, dimension.height+100);//TODO
        }
    }//GEN-LAST:event_openFileMenuItemActionPerformed

    private void jSlider1StateChanged(javax.swing.event.ChangeEvent evt) {//GEN-FIRST:event_jSlider1StateChanged
        try {
            ImageHandler.applyThreshold(fichero,jSlider1.getValue(),resize);
            thresholdLabel.setText(Integer.toString(jSlider1.getValue()));
            pila.add(jSlider1.getValue());
            System.out.println(jSlider1.getValue());
        } catch (IOException ex) {
            Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
        }
        lienzo1.repaint();
    }//GEN-LAST:event_jSlider1StateChanged

    private void sliderVisible(boolean a){
        if(a){
            thresholdLabel.setVisible(true);
            jSlider1.setVisible(true); 
        }else{
            thresholdLabel.setVisible(false);
            jSlider1.setVisible(false); 
        }
    }
    
    private void undoRedoEnable(boolean a){
        if(a){
            undoMenuItem.setEnabled(true);
            redoMenuItem.setEnabled(true);
        }else{
            undoMenuItem.setEnabled(false);
            redoMenuItem.setEnabled(false);
        }
    }
    
    private void thresholdCheckBoxMenuItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_thresholdCheckBoxMenuItemItemStateChanged
        if(evt.getStateChange() == ItemEvent.SELECTED){
            try {
                String n= JOptionPane.showInputDialog("Introduzca el umbral [0-255]","0");
                int num;
                if(n.equals("")){n="0";}
                if(Integer.parseInt(n)>255){num=255;
                }else if(Integer.parseInt(n)<0){num=0;
                }else{num=Integer.parseInt(n);}
                ImageHandler.applyThreshold(fichero,num,resize);
                jSlider1.setValue(num);
                sliderVisible(true);
                undoRedoEnable(true);
            } catch (java.lang.NumberFormatException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            } catch (IOException ex) {
                Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
            }
        }else if(evt.getStateChange() == ItemEvent.DESELECTED){
            sliderVisible(false);
            ImageHandler.openImage(fichero,resize);
            undoRedoEnable(false);
            lienzo1.repaint();
        }
    }//GEN-LAST:event_thresholdCheckBoxMenuItemItemStateChanged

    private void saveFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_saveFileMenuItemActionPerformed
       int res = fc.showSaveDialog(null);
        if(res==JFileChooser.APPROVE_OPTION){
           try {
               ImageHandler.saveImage(fc.getSelectedFile().getAbsolutePath());
           } catch (IOException ex) {
               Logger.getLogger(MainFrame.class.getName()).log(Level.SEVERE, null, ex);
           }
            lienzo1.repaint();
        }else if (res==JFileChooser.CANCEL_OPTION){
            
        }
    }//GEN-LAST:event_saveFileMenuItemActionPerformed

    private void undoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_undoMenuItemActionPerformed
       
        if(pila.getCounter()>=1){
            jSlider1.setValue(pila.undo());
            System.out.println(pila.undo());
            lienzo1.repaint();
        }
    }//GEN-LAST:event_undoMenuItemActionPerformed

    private void redoMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_redoMenuItemActionPerformed
        
        try{
            if(pila.getCounter()<pila.getSize()){
                jSlider1.setValue(pila.redo());
                lienzo1.repaint();
            }
        }catch(Exception e){
        }
    }//GEN-LAST:event_redoMenuItemActionPerformed

    private void exitMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_exitMenuItemActionPerformed
         int confirmed = JOptionPane.showConfirmDialog(null, 
        exitDialogMessage, "Exit",
        JOptionPane.YES_NO_OPTION);
        if(confirmed==JOptionPane.YES_OPTION){
            dispose();
        }
    }//GEN-LAST:event_exitMenuItemActionPerformed

    private void helpMenuMouseClicked(java.awt.event.MouseEvent evt) {//GEN-FIRST:event_helpMenuMouseClicked
       JOptionPane.showMessageDialog(this, infoDialogMessage,helpMenu.getText(),1);
     
     
    }//GEN-LAST:event_helpMenuMouseClicked

    private void englishRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_englishRadioButtonMenuItemActionPerformed
        setLanguage("English");
        language="English";
        if(Lienzo.getImage()!=null){
            startInfoLabel.setText("");
        }
    }//GEN-LAST:event_englishRadioButtonMenuItemActionPerformed

    private void spanishRadioButtonMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_spanishRadioButtonMenuItemActionPerformed
        setLanguage("Spanish");
        language="Spanish";
        if(Lienzo.getImage()!=null){
            startInfoLabel.setText("");
        }
        
    }//GEN-LAST:event_spanishRadioButtonMenuItemActionPerformed

    private void newFileMenuItemActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_newFileMenuItemActionPerformed
        
       initialConfig(language);
      
        Lienzo.removeImage();
        
        lienzo1.repaint();
    }//GEN-LAST:event_newFileMenuItemActionPerformed

    private void automaticResizeBoxMenuItemItemStateChanged(java.awt.event.ItemEvent evt) {//GEN-FIRST:event_automaticResizeBoxMenuItemItemStateChanged
          if(evt.getStateChange() == ItemEvent.SELECTED){
              resize=true;
          }else if(evt.getStateChange() == ItemEvent.DESELECTED){
              resize=false;
          }
    }//GEN-LAST:event_automaticResizeBoxMenuItemItemStateChanged
   
    private void setDropTarget() {
        lienzo1.setDropTarget(new DropTarget(){
            public synchronized void drop(DropTargetDropEvent evt){
                try{
                    evt.acceptDrop(DnDConstants.ACTION_COPY);
                    List<File> droppedFiles = (List<File>)
                        evt.getTransferable().getTransferData(DataFlavor.javaFileListFlavor);
                    for (File file: droppedFiles){
                        
                        fichero=file;
                        Dimension dimension=ImageHandler.openImage(file,resize);
                        if(dimension!=null){
                            openFileActions();
                        }
                        setBounds(0,0,dimension.width+50, dimension.height+100); //TODO
                       //TODO si no es una imagen que se siga mostrando el mensaje
                       
                        lienzo1.repaint();
                        sliderVisible(false);
                        undoRedoEnable(false);
                        thresholdCheckBoxMenuItem.setState(false);
                    }
                }catch(Exception e){
                    
                }
            }
        });
        
    }
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
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(MainFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        //</editor-fold>

        /* Create and display the form */
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new MainFrame().setVisible(true);
            }
        });
    }

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel authorsLabel;
    private javax.swing.JCheckBoxMenuItem automaticResizeBoxMenuItem;
    private javax.swing.JMenu configurationMenu;
    private javax.swing.JMenu editMenu;
    private javax.swing.JRadioButtonMenuItem englishRadioButtonMenuItem;
    private javax.swing.JMenuItem exitMenuItem;
    private javax.swing.JMenu fileMenu;
    private javax.swing.JMenu helpMenu;
    private javax.swing.JFileChooser jFileChooser1;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JPopupMenu.Separator jSeparator2;
    private javax.swing.JSlider jSlider1;
    private javax.swing.JMenu languageMenu;
    private view.Lienzo lienzo1;
    private javax.swing.JMenuItem newFileMenuItem;
    private javax.swing.JMenuItem openFileMenuItem;
    private javax.swing.JMenuItem redoMenuItem;
    private javax.swing.JMenuItem saveFileMenuItem;
    private javax.swing.JRadioButtonMenuItem spanishRadioButtonMenuItem;
    private javax.swing.JLabel startInfoLabel;
    private javax.swing.JCheckBoxMenuItem thresholdCheckBoxMenuItem;
    private javax.swing.JLabel thresholdLabel;
    private javax.swing.JMenuItem undoMenuItem;
    // End of variables declaration//GEN-END:variables

   
}
