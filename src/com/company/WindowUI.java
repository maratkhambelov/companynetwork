package com.company;

import javax.swing.*;
import javax.swing.filechooser.FileNameExtensionFilter;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;
import java.awt.event.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;


public class WindowUI extends JFrame {
    Network myNet = new Network();
    int idxIdTable = 0;
    int idxAmountComputers = 1;
    int idxMemoryJTable1 = 2;
    int LIMIT_TEXTFIELD = 5000;
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
        jBtnOpenFile = new JButton();
        jBtnSaveFile = new JButton();

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
        jBtnOpenFile.setText("Открыть");
        jBtnSaveFile.setText("Сохранить");

        jBtnAddNode.addActionListener(e -> jBtnAddNodeActionPerformed(e));
        jBtnRmvNode.addActionListener(e -> jBtnRmvNodeActionPerformed(e));
        jBtnAddComp.addActionListener(e -> jBtnAddCompActionPerformed(e));
        jBtnRmvComp.addActionListener(e -> jBtnRmvCompActionPerformed(e));
        jBtnOpenFile.addActionListener(e -> jBtnOpenFileActionPerformed(e));
        jBtnSaveFile.addActionListener(e -> jBtnSaveFileActionPerformed(e));
        jBtnSaveFile.setEnabled(false);


        jTable1.addMouseListener(new MouseAdapter() {
            public void mouseClicked(MouseEvent evt) {
                jTable1MouseClicked(evt);
            }
        });
        jTable1.addKeyListener(new KeyListener() {

            @Override
            public void keyTyped(KeyEvent e) {

            }

            @Override
            public void keyPressed(KeyEvent e) {


            }

            @Override
            public void keyReleased(KeyEvent e) {
                if ((e.getKeyCode() == 38)||(e.getKeyCode() == 40) || (e.getKeyChar() == KeyEvent.VK_TAB)) {
                    jTableKeyPressed(e);
                }
            }
        });
        jTable1.setModel(new DefaultTableModel(
                new Object [][] {
                },
                labelsJTable1
        )
        );
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
                                                        .addComponent(jTxtFieldQueueSize, javax.swing.GroupLayout.PREFERRED_SIZE, 184, javax.swing.GroupLayout.PREFERRED_SIZE)))
                                        .addComponent(jLabelTitleNode))
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabelTitleComp)
                                        .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                                .addGroup(layout.createSequentialGroup()
                                                        .addComponent(jBtnOpenFile)
                                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                                        .addComponent(jBtnSaveFile))
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
                                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))))
                                .addGap(45, 45, 45))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jLabel1)
                                .addGap(260, 260, 300))
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
                                        .addComponent(jBtnRmvComp)
                                        .addComponent(jBtnAddComp)
                                        .addComponent(jBtnRmvNode)
                                        .addComponent(jBtnAddNode))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                                        .addComponent(jScrollPane4, javax.swing.GroupLayout.DEFAULT_SIZE, 276, Short.MAX_VALUE)
                                        .addComponent(jScrollPane3, javax.swing.GroupLayout.PREFERRED_SIZE, 0, Short.MAX_VALUE))
                                .addGap(18, 18, 18)
                                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                        .addComponent(jBtnOpenFile)
                                        .addComponent(jBtnSaveFile))
                                .addGap(43, 43, 43))
        );
        pack();
    }
    private void jBtnAddNodeActionPerformed(ActionEvent e){

        try{
            // извлекаем значения из textfield
            String idString = jTxtFieldIdNode.getText();
            int idInt = Integer.parseInt(idString);
            int queueSize = Integer.parseInt(jTxtFieldQueueSize.getText());
            // проверка на допустимые значения
            if((idInt < 0 || idInt >= LIMIT_TEXTFIELD)|| (queueSize < 0 || queueSize >= LIMIT_TEXTFIELD)){
                throw new IOException();
            }

            // работаем с данными: добавляем узел в сеть
            myNet.addElement(new NodeComputers(idInt, queueSize));


            // обновляем таблицы
            jTable1.setModel(new DefaultTableModel(
                    myNet.getMainInfo(),
                    labelsJTable1
            )
                             {public boolean isCellEditable(int row, int column) { return false;}}
            );

            // выделяем актуальную строку в jTable1
            int idxNewRowSelected = this.getRowByValueAndCol(jTable1.getModel(), idString, idxIdTable);
            jTable1.setRowSelectionInterval(idxNewRowSelected,idxNewRowSelected);

            //находим текущий узел и показываем компьюьтеры этого узла
            NodeComputers foundNode = myNet.findById(idInt);
            jTable2.setModel(new DefaultTableModel(
                    foundNode.toStringCircleAtTable(),
                    labelsJTable2
            )
                             {public boolean isCellEditable(int row, int column) { return false;}}
            );
            jLabel1.setText("");

            // стираем старые значения textfield
            jTxtFieldIdNode.setText("");
            jTxtFieldQueueSize.setText("");
            jBtnSaveFile.setEnabled(true);

        }
        catch (IOException exc){
            jLabel1.setText("Вы ввели значение в недопустимых пределах. " +
                        "\nВведите только цифры значения от 0 до " + LIMIT_TEXTFIELD);
        }
        catch(NumberFormatException exc){
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
                )
                         {public boolean isCellEditable(int row, int column) { return false;}}
                );
                // берем первую строку из таблицы и выводим ее компьютеры
                if(jTable1.getSelectedRow() == -1){
                    jTable1.setRowSelectionInterval(0, 0);
                    int idNewSelectedNode = Integer.parseInt(jTable1.getValueAt(0, 0).toString());
                    NodeComputers foundNewNode = myNet.findById(idNewSelectedNode);
                    jTable2.setModel(new DefaultTableModel(
                            foundNewNode.toStringCircleAtTable(),
                            labelsJTable2
                    )
                         {public boolean isCellEditable(int row, int column) { return false;}}
                    );
                }
            }
            else {
                jTable1.setModel(new DefaultTableModel(
                        new Object [][] {},
                        labelsJTable1
                ));
                jTable2.setModel(new DefaultTableModel(
                        new Object [][] {},
                        labelsJTable2
                ));
            }
            jLabel1.setText("");

            if(myNet.isEmpty()) {
                jBtnSaveFile.setEnabled(false);
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
            if((id < 0 || id >= LIMIT_TEXTFIELD)|| (memory < 0 || memory >= LIMIT_TEXTFIELD)){
                throw new IOException();
            }
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
            )
                 {public boolean isCellEditable(int row, int column) { return false;}}
            );
            jLabel1.setText("");
            // стираем старые значения textfield
            jTxtFieldIdComp.setText("");
            jTxtFieldMemoryComp.setText("");
        }
        catch (IOException exc){
            jLabel1.setText("Вы ввели неверное значение. " +
                    "\nВведите только цифры значения от 0 до " + LIMIT_TEXTFIELD);
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
                    "\nВведите другой id для компьютера" );
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
            )
                {public boolean isCellEditable(int row, int column) { return false;}}
            );
            jTable1.setRowSelectionInterval(row, row);

            jTable2.setModel(new DefaultTableModel(
                    foundNode.toStringCircleAtTable(),
                    labelsJTable2
            )
                 {public boolean isCellEditable(int row, int column) { return false;}}
            );
            jLabel1.setText("");
        }
        catch (ArrayIndexOutOfBoundsException exc){
            jLabel1.setText("Очередь пуста");
        }
        catch(Throwable err){
            String error = String.valueOf(err);
            jLabel1.setText(error);
        }
    }
    private void jBtnOpenFileActionPerformed(ActionEvent e){
        try{
            //создаем filechooser, фильтры
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt файл","txt");
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setDialogTitle("Открыть");

            //добавляем фильтры, локализуем
            fileChooser.setFileFilter(filter);
            setUpdateUI(fileChooser);

            //читаем структуру,воссоздаем структуру
            int response = fileChooser.showOpenDialog(null);
            if(response == JFileChooser.APPROVE_OPTION){
                String path = fileChooser.getSelectedFile().getAbsolutePath();
                myNet = getStructureFromFile(path);
            }

            //показываем прочитанную структуру
            jTable1.setModel(new DefaultTableModel(
                    myNet.getMainInfo(),
                    labelsJTable1
                             )
                             {public boolean isCellEditable(int row, int column) { return false;}}
            );
            jTable1.setRowSelectionInterval(0, 0);
            int idFirstRow = Integer.parseInt(jTable1.getValueAt(0, 0).toString());
            NodeComputers foundNode = myNet.findById(idFirstRow);
            jTable2.setModel(new DefaultTableModel(
                    foundNode.toStringCircleAtTable(),
                    labelsJTable2
                             )
                             {public boolean isCellEditable(int row, int column) { return false;}}
            );
            jLabel1.setText("");
            if(!myNet.isEmpty()) {
                jBtnSaveFile.setEnabled(true);
            }
        }
        catch(NullPointerException exc){
            jLabel1.setText("Не удалось сериализовать");
        }
        catch(Throwable err){
            String error = String.valueOf(err);
            jLabel1.setText("Не удалось сериализовать" + error);
        }
    }
    private void jBtnSaveFileActionPerformed(ActionEvent e){

        try{
            //создаем filechooser, фильтры
            FileNameExtensionFilter filter = new FileNameExtensionFilter("Txt файл","txt");
            JFileChooser fileChooser = new JFileChooser(".");
            fileChooser.setFileSelectionMode(JFileChooser.FILES_ONLY);
            fileChooser.setDialogTitle("Сохранить");

            //подключаем фильтры, локализуем
            fileChooser.addChoosableFileFilter(filter);
            setUpdateUI(fileChooser);

            int response = fileChooser.showSaveDialog(null);

            //записываем структуру
            if(response == JFileChooser.APPROVE_OPTION){
                File file = fileChooser.getSelectedFile();
                String path = file.getAbsolutePath();
                path += ".txt";
                writeStructure(path);
            }
            jLabel1.setText("");
        }
        catch(Throwable err){
            String error = String.valueOf(err);
            jLabel1.setText("Не удалось сохранить" + error);
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
        )
             {public boolean isCellEditable(int row, int column) { return false;}}
        );
    }
    private void jTableKeyPressed(KeyEvent evt) {
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
                         )
                         {public boolean isCellEditable(int row, int column) { return false;}}
        );
    }


    public int getRowByValueAndCol(TableModel model, Object value, int idxCol) {
        for (int i = model.getRowCount() - 1; i >= 0; --i) {
            for (int j = model.getColumnCount() - 1; j >= 0; --j) {

                if (model.getValueAt(i, idxCol).equals(value)) {
                    return i;
                }
            }
        }
        return -1;
    }

    public void writeStructure(String path) {
        if(!myNet.isEmpty()){
            try(FileWriter writer = new FileWriter(path, false)) {
                String text = myNet.toSaveString();
                writer.write(text);
                writer.flush();
            }
            catch(IOException ex){
                System.out.println(ex.getMessage());
            }
        }

    }
    public Network getStructureFromFile(String path) throws IOException {

        File file = new File(path);
        Network newNetwork = new Network();

        Scanner scanner = new Scanner(file);

        NodeComputers node = null;
        while(scanner.hasNext()){

            String[] tokens = scanner.nextLine().split(" ");
            String instance = tokens[0];
            if(instance.equals("Node")){
                int id = Integer.parseInt(tokens[1]);
                int size = Integer.parseInt(tokens[2]);
                int first = Integer.parseInt(tokens[3]);
                int last = Integer.parseInt(tokens[4]);
                int amountComps = Integer.parseInt(tokens[5]);
                int memory = Integer.parseInt(tokens[6]);

                node = new NodeComputers(id, size);
                node.setFirstLast(first, last);
                node.setAmountComputers(amountComps);
                node.setMemory(memory);
                newNetwork.addElement(node);
            }
            else if(instance.equals("Computer")) {
                int id = Integer.parseInt(tokens[1]);
                int memory = Integer.parseInt(tokens[2]);
                int idx = Integer.parseInt(tokens[3]);
                Computer computer = new Computer(id, memory);
                node.setDirectlyComp(idx, computer);
            }
            else{
                continue;
            }

        }
        return newNetwork;

    }

    private JButton jBtnAddNode;
    private JButton jBtnRmvNode;
    private JButton jBtnAddComp;
    private JButton jBtnRmvComp;
    private JButton jBtnOpenFile;
    private JButton jBtnSaveFile;

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

    // метод локализации
    public static void setUpdateUI(JFileChooser choose) {
        UIManager.put("FileChooser.openButtonText", "Открыть");
        UIManager.put("FileChooser.cancelButtonText", "Отмена");
        UIManager.put("FileChooser.lookInLabelText", "Смотреть в");
        UIManager.put("FileChooser.fileNameLabelText", "Имя файла");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Тип файла");

        UIManager.put("FileChooser.saveButtonText", "Сохранить");
        UIManager.put("FileChooser.saveButtonToolTipText", "Сохранить");
        UIManager.put("FileChooser.openButtonText", "Открыть");
        UIManager.put("FileChooser.openButtonToolTipText", "Открыть");
        UIManager.put("FileChooser.cancelButtonText", "Отмена");
        UIManager.put("FileChooser.cancelButtonToolTipText", "Отмена");

        UIManager.put("FileChooser.lookInLabelText", "Папка");
        UIManager.put("FileChooser.saveInLabelText", "Папка");
        UIManager.put("FileChooser.fileNameLabelText", "Имя файла");
        UIManager.put("FileChooser.filesOfTypeLabelText", "Тип файлов");
        UIManager.put("FileChooser.folderNameLabelText", "Путь директории");


        UIManager.put("FileChooser.upFolderToolTipText", "На один уровень вверх");
        UIManager.put("FileChooser.newFolderToolTipText", "Создание новой папки");
        UIManager.put("FileChooser.listViewButtonToolTipText", "Список");
        UIManager.put("FileChooser.detailsViewButtonToolTipText", "Таблица");
        UIManager.put("FileChooser.fileNameHeaderText", "Имя");
        UIManager.put("FileChooser.fileSizeHeaderText", "Размер");
        UIManager.put("FileChooser.fileTypeHeaderText", "Тип");
        UIManager.put("FileChooser.fileDateHeaderText", "Изменен");
        UIManager.put("FileChooser.fileAttrHeaderText", "Атрибуты");

        UIManager.put("FileChooser.acceptAllFileFilterText", "Все файлы");
        choose.updateUI();
    }
}


