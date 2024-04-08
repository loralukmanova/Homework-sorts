package homework;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.Image;
import java.awt.event.ActionListener;
import java.nio.file.Path;
import java.nio.file.Paths;

public class MainFrame extends javax.swing.JFrame{
    
    private Picture[] pictures=new Picture[5];

    
    public MainFrame() {
        initComponents();
        arrConstr();
        setTheImagesIn();
    }

    private void arrConstr(){
        Picture A = new Picture("Nebula1.png", 5);
        pictures[0] = A;
        Picture B = new Picture("Nebula2.png", 4);
        pictures[1] = B;
        Picture C = new Picture("Nebula3.png", 3);
        pictures[2] = C;
        Picture D = new Picture("Nebula4.png", 2);
        pictures[3] = D;
        Picture E = new Picture("Nebula5.png", 1);
        pictures[4] = E;
        
    }
    
    private void setTheImagesIn(){
        Path resourceDirectory = Paths.get("src","resources");
        String absolutePath = resourceDirectory.toFile().getAbsolutePath();
        for (int i = 0; i < 5; i++) {
            ImageIcon imgIcon = new ImageIcon(absolutePath+"/"+pictures[i].getName());
            JLabel img = new JLabel(); 
            img.setIcon(imgIcon);
            img.setSize(imgIcon.getIconWidth(), imgIcon.getIconHeight());
            int x=20;
            img.setBounds(x, 100, imgIcon.getIconWidth(), imgIcon.getIconHeight());
            jPanel2.add(img);
            x=x+imgIcon.getIconWidth();
            img.setVisible(true);
        }       
    }
    
    public void BubbleSort(Picture[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            for (int j = 0; j < list.length - i - 1; j++) {
                if (list[j].compareTo(list[j + 1]) > 0) {
                    Picture temp = list[j];
                    list[j] = list[j + 1];
                    list[j + 1] = temp;
                    jPanel2.removeAll();
                    setTheImagesIn();
                    jPanel2.repaint();
                }
            }
        }
    }
    
    public void SelectionSort(Picture[] list) {
        for (int i = 0; i < list.length - 1; i++) {
            Picture currentMin = list[i];
            int currentMinIndex = i;
            for (int j = i + 1; j < list.length; j++) {
                if (currentMin.compareTo(list[j]) > 0) {
                    currentMin = list[j];
                    currentMinIndex = j;
                }
            }
            if (currentMinIndex != i) {
                list[currentMinIndex] = list[i];
                list[i] = currentMin;
            }
           jPanel2.removeAll();
            setTheImagesIn();
            jPanel2.repaint();
        }
    }
    
    public void InsertionSort(Picture[] list) {
        for (int i = 1; i < list.length; i++) {
            Picture currentElement = list[i];
            int k;
            for (k = i - 1; k >= 0 && (list[k].compareTo(currentElement) > 0); k--) {
                list[k + 1] = list[k];
            }
            list[k + 1] = currentElement;
            jPanel2.removeAll();
            setTheImagesIn();
            jPanel2.repaint();
        }
    }
    
    public void MergeSort(Picture[] list) {
        if (list.length > 1) {
            Picture[] firstHalf = new Picture[list.length / 2];
            System.arraycopy(list, 0, firstHalf, 0, list.length / 2);
            MergeSort(firstHalf);
            int secondHalfLength = list.length - list.length / 2;
            Picture[] secondHalf = new Picture[secondHalfLength];
            System.arraycopy(list, list.length / 2, secondHalf, 0, secondHalfLength);
            MergeSort(secondHalf);
            merge(firstHalf, secondHalf, list);
        }
    }

    public void QuickSort(Picture[] list, int first, int last) {
        if (last > first) {
            int pivotIndex = partition(list, first, last);
            QuickSort(list, first, pivotIndex - 1);
            QuickSort(list, pivotIndex + 1, last);
        }

    }
    
    public void HeapSort(Picture[] list) {

        Heap heap = new Heap();

        for (int i = 0; i < list.length; i++) {
            heap.add(list[i]);
        }
        for (int i = list.length - 1; i >= 0; i--) {
            list[i] = heap.remove();
            jPanel2.removeAll();
            setTheImagesIn();
            jPanel2.repaint();
        }

    }
    
    public void merge(Picture[] list1, Picture[] list2, Picture[] temp) {
        int current1 = 0;
        int current2 = 0;
        int current3 = 0;

        while (current1 < list1.length && current2 < list2.length) {
            if (list1[current1].compareTo(list2[current2]) < 0) {
                temp[current3++] = list1[current1++];
            } else {
                temp[current3++] = list2[current2++];
            }
        }
        while (current1 < list1.length) {
            temp[current3++] = list1[current1++];
        }
        while (current2 < list2.length) {
            temp[current3++] = list2[current2++];
        }
        jPanel2.removeAll();
        setTheImagesIn();
        jPanel2.repaint();
    }

    private int partition(Picture[] list, int first, int last) {
        Picture pivot = list[first];
        int low = first + 1;
        int high = last;
        while (high > low) {
            while (low <= high && (list[low].compareTo(pivot)) <= 0) {
                low++;
            }
            while (low <= high && (list[high].compareTo(pivot)) > 0) {
                high--;
            }
            if (high > low) {
                Picture temp = list[high];
                list[high] = list[low];
                list[low] = temp;
                jPanel2.removeAll();
                setTheImagesIn();
                jPanel2.repaint();
            }
        }
        while (high > first && list[high].compareTo(pivot) >= 0) {
            high--;
        }
        if (pivot.compareTo(list[high]) > 0) {
            list[first] = list[high];
            list[high] = pivot;
            jPanel2.removeAll();
            setTheImagesIn();
            jPanel2.repaint();
            return high;

        } else {
            return first;
        }
    }
    
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jComboBox1 = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel<>(new String[] { "Bubble Sort", "Selection Sort", "Insertion Sort", "Quick Sort", "Merge Sort", "Heap Sort" }));
        jComboBox1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jComboBox1ActionPerformed(evt);
            }
        });

        jButton1.setText("Sort");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(159, 159, 159)
                .addComponent(jButton1)
                .addContainerGap(169, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jComboBox1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jButton1)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 225, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel2, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jComboBox1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jComboBox1ActionPerformed
        String sortType = jComboBox1.getSelectedItem().toString();
        if(sortType=="Bubble Sort"){
            BubbleSort(pictures);
        }
        if(sortType=="Selection Sort"){
            SelectionSort(pictures);
        }
        if(sortType=="Insertion Sort"){
            InsertionSort(pictures);
        }
        if(sortType=="Quick Sort"){
            QuickSort(pictures);
        }
        if(sortType=="Merge Sort"){
            MergeSort(pictures);
        }
        if(sortType=="Heap Sort"){
            HeapSort(pictures);
        }
    }//GEN-LAST:event_jComboBox1ActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        
    }//GEN-LAST:event_jButton1ActionPerformed

    /**
     * @param args the command line arguments
     */
    public static void main(String args[]) {
        
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
    private javax.swing.JButton jButton1;
    private javax.swing.JComboBox<String> jComboBox1;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    // End of variables declaration//GEN-END:variables
}
