package com.company;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;


public class WindowUI extends JFrame {
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
        jLabelTitleNode = new  JLabel();
        jLabelTitleComp = new  JLabel();
        jLabelIdComp = new  JLabel();
        jLabelMemoryComp = new  JLabel();
        jLabelIdNode = new  JLabel();
        jLabelQueueSizeNode = new  JLabel();

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
        jBtnRmvNode.addActionListener(e -> jBtnRmvNodeActionPerformed(e));
        jBtnAddComp.addActionListener(e -> jBtnAddCompActionPerformed(e));
        jBtnRmvComp.addActionListener(e -> jBtnRmvCompActionPerformed(e));
        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.setModel(new DefaultTableModel(
                new Object [][] {
                },
                labelsJTable1
        ));
        jScrollPane3.setViewportView(jTable1);
        if (jTable1.getColumnModel().getColumnCount() > 0) {
            jTable1.getColumnModel().getColumn(0).setMaxWidth(100);
        }

        jTable2.setModel(new DefaultTableModel(
                new Object [][] {

                },
                labelsJTable2
        ));
        jScrollPane4.setViewportView(jTable2);

        jLabel1.setText("");
        jLabelTitleNode.setText("Узлы");
        jLabelTitleComp.setText("Компьютеры");
        jLabelIdComp.setText("Введите Id:");
        jLabelMemoryComp.setText("Введите объем памяти:");
        jLabelIdNode.setText("Введите Id:");
        jLabelQueueSizeNode.setText("Введите размер очереди:");

        GroupLayout layout = new GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addGap(55, 55, 55)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createSequentialGroup()
                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addComponent(jBtnAddNode)
                                                                .addGap(18, 18, 18)
                                                                .addComponent(jBtnRmvNode))
                                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 403, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                        .addGroup(layout.createSequentialGroup()
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jTxtFieldIdNode, javax.swing.GroupLayout.PREFERRED_SIZE, 201, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                        .addComponent(jLabelIdNode))
                                                                .addGap(18, 18, 18)
                                                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                        .addComponent(jLabelQueueSizeNode)
                                                                        .addComponent(jTxtFieldQueueSize, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE))))
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 101, Short.MAX_VALUE))
                                        .addGroup(layout.createSequentialGroup()
                                                .addComponent(jLabelTitleNode)
                                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitleComp)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jBtnAddComp)
                                                        .addGap(18, 18, 18)
                                                        .addComponent(jBtnRmvComp))
                                                .addGroup(layout.createSequentialGroup()
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                                                .addComponent(jTxtFieldIdComp, javax.swing.GroupLayout.PREFERRED_SIZE, 151, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                                .addComponent(jLabelIdComp))
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                                                .addComponent(jLabelMemoryComp, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                                                .addComponent(jTxtFieldMemoryComp)))
                                                .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE)))
                                .addGap(45, 45, 45))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(406, 406, 406))
        );
        layout.setVerticalGroup(
                layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(32, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(30, 30, 30)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelTitleComp)
                                        .addComponent(jLabelTitleNode))
                                .addGap(29, 29, 29)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jLabelIdComp)
                                        .addComponent(jLabelMemoryComp)
                                        .addComponent(jLabelIdNode)
                                        .addComponent(jLabelQueueSizeNode))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTxtFieldIdComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTxtFieldMemoryComp, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jTxtFieldIdNode, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                                .addComponent(jTxtFieldQueueSize, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jBtnAddComp)
                                                .addComponent(jBtnRmvComp))
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                                .addComponent(jBtnRmvNode)
                                                .addComponent(jBtnAddNode)))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 318, javax.swing.GroupLayout.PREFERRED_SIZE))
                                .addGap(48, 48, 48))
        );

        pack();
    }
    private void jBtnAddNodeActionPerformed(ActionEvent e){

        try{
            // извлекаем значения из textfield
            String idString = jTxtFieldIdNode.getText();
            int idInt = Integer.parseInt(idString);
            int queueSize = Integer.parseInt(jTxtFieldQueueSize.getText());

            // работаем с данными: добавляем узел в сеть
            myNet.addElement(new NodeComputers(idInt, queueSize));


            // обновляем таблицы
            jTable1.setModel(new DefaultTableModel(
                    myNet.getMainInfo(),
                    labelsJTable1
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
            jLabel1.setText("");

            // стираем старые значения textfield
            jTxtFieldIdNode.setText("");
            jTxtFieldQueueSize.setText("");
        } catch(NumberFormatException exc){
            jLabel1.setText("Вы ввели неверное значение. " +
                            "\nВведите только цифры");
        } catch(Throwable err){
            jLabel1.setText("Узел с таким id уже имеется в сети. " +
                            "\nВведите другой id для узла");
        }
    }
    private void jBtnRmvNodeActionPerformed(ActionEvent e){
        try{
            // находим выделенную строку и извлекаем оттуда id
            int row = jTable1.getSelectedRow();
            if(row == -1){
                throw new NullPointerException("Cписок узлов пуст");
            }

            int idSelectedNode = Integer.parseInt(jTable1.getValueAt(row, idxIdTable).toString());
            // находим нужный узел и удаляем компьютера из очереди
            NodeComputers foundNode = myNet.findById(idSelectedNode);
            myNet.removeElement(foundNode);

            // обновляем таблицу
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
        catch (NullPointerException exc){
            jLabel1.setText("Список пуст");
        }
        catch(Throwable err){
            String error = String.valueOf(err);
            jLabel1.setText(error);
        }
    }
    private void jBtnAddCompActionPerformed(ActionEvent e){
        try{
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
            jLabel1.setText("");
            // стираем старые значения textfield
            jTxtFieldIdComp.setText("");
            jTxtFieldMemoryComp.setText("");
        }
        catch (ArrayIndexOutOfBoundsException exc){
            jLabel1.setText("Очередь заполнена.");
        }
        catch(NumberFormatException exc){
            jLabel1.setText("Вы ввели неверное значение. " +
                    "\nВведите только цифры");
        }
        catch(Throwable err){
            jLabel1.setText("Компьютер с таким id уже имеется в узле. " +
                    "\nВведите другой id для компьютера");
//            String error = String.valueOf(err);
//            jLabel1.setText(error);
        }
    }
    private void jBtnRmvCompActionPerformed(ActionEvent e){

        try{
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
        catch (ArrayIndexOutOfBoundsException exc){
            jLabel1.setText("Очередь пуста");
        }
        catch(Throwable err){
            String error = String.valueOf(err);
            jLabel1.setText(error);
        }
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
    private JButton jBtnRmvNode;
    private JButton jBtnAddComp;
    private JButton jBtnRmvComp;
    
    private JTextField jTxtFieldIdNode;
    private JTextField jTxtFieldQueueSize;
    private JTextField jTxtFieldIdComp;
    private JTextField jTxtFieldMemoryComp;



    private JTable jTable1;
    private JTable jTable2;

    private JScrollPane jScrollPane3;
    private JScrollPane jScrollPane4;

    private JLabel jLabel1;
    private JLabel jLabelIdComp;
    private JLabel jLabelIdNode;
    private JLabel jLabelMemoryComp;
    private JLabel jLabelQueueSizeNode;
    private JLabel jLabelTitleComp;
    private JLabel jLabelTitleNode;

}
