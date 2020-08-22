package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseEvent;


public class WindowUI extends JFrame {
    //    JBtn testBtn;
    Network myNet = new Network();
    int idxIdTable = 0;
    int idxAmountComputers = 1;
    int idxMemoryJTable1 = 2;
    String[] labelsJTable1 = new String [] {
        "Id:", "Кол-во компьютеров:", "Объем памяти"
    };
    String[] labelsJTable2 = new String[] {
            "Инвентарный номер", "Объем памяти"
    };

    public WindowUI(){
        initComponents();
    }
    public void initComponents(){

        jBtnAddNode = new JButton();
        jBtnRmvNode = new JButton();
        jBtnAddComp = new JButton();
        jBtnRmvComp = new JButton();

        jTxtFieldIdNode = new JTextField();
        jTxtFieldQueueSize = new JTextField();
        jTxtFieldIdComp = new JTextField();
        jTxtFieldMemoryComp = new JTextField();
        jLabel1 = new JLabel();


        jTable1 = new JTable();
        jTable2 = new JTable();

        jScrollPane3 = new JScrollPane();
        jScrollPane4 = new JScrollPane();

        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

        jBtnAddNode.setText("Добавить узел");
        jBtnRmvNode.setText("Удалить узел");
        jBtnAddComp.setText("Добавить комп");
        jBtnRmvComp.setText("Удалить комп");

        jBtnAddNode.addActionListener(e -> jBtnAddNodeActionPerformed(e));
//        jBtnAddNode.addActionListener(new java.awt.event.ActionListener() {
//            public void actionPerformed(java.awt.event.ActionEvent evt) {
//                jBtnAddNodeActionPerformed(evt);
//            }
//        });
        jBtnRmvNode.addActionListener(e -> jBtnRmvNodeActionPerformed(e));
        jBtnAddComp.addActionListener(e -> jBtnAddCompActionPerformed(e));
        jBtnRmvComp.addActionListener(e -> jBtnRmvCompActionPerformed(e));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTxtFieldIdNode.addActionListener(evt -> jTxtFieldIdNodeActionPerformed(evt));
        jTable1.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                labelsJTable1
        ));
        jTable1.addMouseListener(new java.awt.event.MouseAdapter() {
            public void mouseClicked(java.awt.event.MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jTable2.setModel(new javax.swing.table.DefaultTableModel(
                new Object [][] {

                },
                labelsJTable2
        ));
        jScrollPane4.setViewportView(jTable2);

        jLabel1.setText("jLabel1");


        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGap(64, 64, 64)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 513, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addGap(42, 42, 42)
                                                .addComponent(jScrollPane4))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jBtnAddNode)
                                                                .addGap(54, 54, 54)
                                                                .addComponent(jBtnRmvNode)
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTxtFieldQueueSize, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jTxtFieldIdNode, javax.swing.GroupLayout.PREFERRED_SIZE, 348, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                                .addGap(59, 59, 59)
                                                .addComponent(jLabel1)
                                                .addGap(118, 118, 118)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jBtnAddComp)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jBtnRmvComp))
                                                        .addComponent(jTxtFieldIdComp, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTxtFieldMemoryComp, javax.swing.GroupLayout.PREFERRED_SIZE, 310, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(12, 12, 12)))
                                .addGap(53, 53, 53))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(layout.createSequentialGroup()
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jBtnRmvNode)
                                                        .addComponent(jBtnAddNode))
                                                .addGap(36, 36, 36))
                                        .addGroup(layout.createSequentialGroup()
                                                .addGap(21, 21, 21)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTxtFieldIdComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jLabel1)
                                                        .addComponent(jTxtFieldIdNode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(18, 18, 18)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jTxtFieldMemoryComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addComponent(jTxtFieldQueueSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                                .addGap(56, 56, 56)
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                        .addComponent(jBtnAddComp)
                                                        .addComponent(jBtnRmvComp))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 28, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(126, 126, 126))
        );
        pack();
    }
    private void jBtnAddNodeActionPerformed(ActionEvent e){

        // извлекаем значения из textfield
        String idString = jTxtFieldIdNode.getText();
        int idInt = Integer.parseInt(idString);
        int queueSize = Integer.parseInt(jTxtFieldQueueSize.getText());

        // работаем с данными: добавляем узел в сеть
        myNet.addElement(new NodeComputers(idInt, queueSize));


        // обновляем таблицы
        jTable1.setModel(new DefaultTableModel(
                myNet.getMainInfo(),
                new String [] {
                        "Id:", "Кол-во компьютеров:", "Объем памяти"
                }
        ));

        // выделяем актуальную строку в jTable1
        int idxNewRowSelected = this.getRowByValueAndCol(jTable1.getModel(), idString, idxIdTable);
        jTable1.setRowSelectionInterval(idxNewRowSelected,idxNewRowSelected);

        //находим текущий узел и показываем компьюьтеры этого узла
        NodeComputers foundNode = myNet.findById(idInt);
        jTable2.setModel(new DefaultTableModel(
                foundNode.toStringCircleAtTable(),
                labelsJTable2
        ));
        // стираем старые значения textfield
        jTxtFieldIdNode.setText("");
        jTxtFieldQueueSize.setText("");

    }
    private void jBtnRmvNodeActionPerformed(ActionEvent e){

        // находим выделенную строку и извлекаем оттуда id
        int row = jTable1.getSelectedRow();
        int idSelectedNode = Integer.parseInt(jTable1.getValueAt(row, idxIdTable).toString());

        // находим нужный узел и удаляем компьютера из очереди
        NodeComputers foundNode = myNet.findById(idSelectedNode);
        myNet.removeElement(foundNode);
        // обновляем таблицу 1
        if(myNet.isEmpty() != true) {
            jTable1.setModel(new DefaultTableModel(
                    myNet.getMainInfo(),
                    labelsJTable1
            ));
            // берем первую строку из таблицы и выводим ее компьютеры
            if(jTable1.getSelectedRow() == -1){
                jTable1.setRowSelectionInterval(0, 0);
                int idNewSelectedNode = Integer.parseInt(jTable1.getValueAt(0, 0).toString());
                NodeComputers foundNewNode = myNet.findById(idNewSelectedNode);
                jTable2.setModel(new DefaultTableModel(
                        foundNewNode.toStringCircleAtTable(),
                        labelsJTable2
                ));
            }
        }
        else {
            jTable1.setModel(new DefaultTableModel(
                    new Object [][] {},
                    labelsJTable1
            ));
        }
    }
    private void jBtnAddCompActionPerformed(ActionEvent e){
        // извлекаем значения из textfield
        int id = Integer.parseInt(jTxtFieldIdComp.getText());
        int memory = Integer.parseInt(jTxtFieldMemoryComp.getText());

        // находим выделенную строку и извлекаем оттуда id
        int row = jTable1.getSelectedRow();
        String idSelectedRowTableString = jTable1.getValueAt(row, 0).toString();
        int idSelectedRowTableInt = Integer.parseInt(idSelectedRowTableString);


        // работаем с данными
        NodeComputers selectedNode = myNet.findById(idSelectedRowTableInt);
        Computer newComp = new Computer(id, memory);
        selectedNode.addElement(newComp);

        // обновляем таблицы:
        // обновляем общее количество в памяти, кол-во компьютеров в первой таблице
        // обновляем таблицу 2
        jTable1.setValueAt(selectedNode.getMemory(), row, idxMemoryJTable1);
        jTable1.setValueAt(selectedNode.getAmountComputers(), row, idxAmountComputers);

        jTable2.setModel(new DefaultTableModel(
                selectedNode.toStringCircleAtTable(),
                labelsJTable2
        ));
        // стираем старые значения textfield
        jTxtFieldIdComp.setText("");
        jTxtFieldMemoryComp.setText("");
    }
    private void jBtnRmvCompActionPerformed(ActionEvent e){

        // находим выделенную строку и извлекаем оттуда id
        int row = jTable1.getSelectedRow();
        String idSelectedRowTableString = jTable1.getValueAt(row, idxIdTable).toString();
        int idSelectedRowTableInt = Integer.parseInt(idSelectedRowTableString);

        // работаем с данными
        NodeComputers foundNode = myNet.findById(idSelectedRowTableInt);
        foundNode.removeElement();


        // обновляем таблицы:
        jTable1.setModel(new DefaultTableModel(
                myNet.getMainInfo(),
                labelsJTable1
        ));
        jTable1.setRowSelectionInterval(row, row);

        jTable2.setModel(new DefaultTableModel(
                foundNode.toStringCircleAtTable(),
                labelsJTable2
        ));
    }

    private void jTable1MouseClicked(MouseEvent evt) {
        // определяем выделенную строку
        int row = jTable1.getSelectedRow();
        // находим нужный узел для того чтобы показать компьютеры в нем
        Object idClickedRowObject = jTable1.getValueAt(row, idxIdTable);
        int idClickedRowInt = Integer.parseInt(idClickedRowObject.toString());
        NodeComputers foundNode = myNet.findById(idClickedRowInt);
        // обновляем таблицу 2
        jTable2.setModel(new DefaultTableModel(
                foundNode.toStringCircleAtTable(),
                labelsJTable2
        ));
    }

    private void jTxtFieldIdNodeActionPerformed(ActionEvent evt) {
        System.out.println(evt);

    }

    public int getRowByValueAndCol(TableModel model, Object value, int idxCol) {
        for (int i = model.getRowCount() - 1; i >= 0; --i) {
            for (int j = model.getColumnCount() - 1; j >= 0; --j) {

                if (model.getValueAt(i, idxCol).equals(value)) {
                    // what if value is not unique?
                    return i;
                }
            }
        }
        return -1;
    }
    private JButton jBtnAddNode;
    JButton jBtnRmvNode;
    JButton jBtnAddComp;
    JButton jBtnRmvComp;
    JTextField jTxtFieldIdNode;
    JTextField jTxtFieldQueueSize;
    JTextField jTxtFieldIdComp;
    JTextField jTxtFieldMemoryComp;



    JTable jTable1;
    JTable jTable2;

    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;
    private JLabel jLabel1;
    public static void main(String args[]) {

    }
}
