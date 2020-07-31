package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {
    Scanner scan = new Scanner(System.in);
    Network myNet = new Network();
    NodeComputers node = new NodeComputers(1, 3);// TODO: delete
    Computer comp1 = new Computer(1,1); // TODO: delete
    Computer comp2 = new Computer(2,2);// TODO: delete
    Computer comp3 = new Computer(3,3);// TODO: delete

    public void start() throws IOException, ClassNotFoundException {
        try {
            int number;

            do {

                System.out.println("Введите число: \nдля добавление узла - 1, \nдля удаление узла - 2, " +
                        "\nдля добавления Компьютера - 3, \nдля удаления компьютера - 4, " +
                        "\nдля просмотра структуры сети в расширенном виде - 5, " +
                        "\nдля чтения структуры из файла - 6");
                while (!scan.hasNextInt()) {
                    System.out.println("неправильно введенно значение");
                    scan.next();
                }
                number = scan.nextInt();
            } while (number < 0 && number > 6);
            switch (number) {
                case 1:
                    addNode();
                    break;
                case 2:
                    removeNode();
                    break;
                case 3:
                    addComputer();
                    break;
                case 4:
                    removeComputer();
                    break;
                case 5:
                    showStructure();
                    break;
                case 6:
                    toReadStructure();
                    break;
//                case 7:
//                    node.addElement(comp1); // TODO: delete
//                    node.addElement(comp2); // TODO: delete
//                    node.addElement(comp3); // TODO: delete
//                    myNet.addElement(node); // TODO: delete
//                    toWriteStructure();
//                    break;
                default:
                    break;
            }
            number = 0;
            start();
        }catch (InputMismatchException e){
            System.out.println("неправильно введенно значение");
        }
        catch (Throwable e ){
            System.out.println(e);
        }

    }

    public void addNode() throws IOException, ClassNotFoundException {
        try{
            if(!myNet.isEmpty()){
                System.out.println(myNet.toString());
            }
            System.out.println("Задайте размер очереди: ");
            int sizeQueue = scan.nextInt();
            System.out.println("Задайте уникальный номер для Узла: ");
            int idNode = scan.nextInt();
            NodeComputers newNode = new NodeComputers(idNode, sizeQueue);
            myNet.addElement(newNode);
            toWriteStructure();
            toReadStructure();
        }
        catch (Throwable err) {
            System.out.println(err);
        }
    }
    public void removeNode() throws IOException, ClassNotFoundException {
        try{
            if(myNet.isEmpty()){
                throw new Error("Сеть не содержит узлов");
            }
            System.out.println(myNet.toString());
            System.out.println("Чтобы удалить узел, укажите его уникальный номер: ");
            int idNode = scan.nextInt();
            NodeComputers found = myNet.findById(idNode);
            if(found == null ) {
                throw new Error("узел по уникальному номеру не найден");
            }
            myNet.removeElement(found);
            toWriteStructure();
            toReadStructure();

        }
        catch (Throwable err) {
            System.out.println(err);
        }
    }
    public void addComputer() throws IOException, ClassNotFoundException {
        try{
            if(myNet.isEmpty()){
                throw new Error("Сеть не содержит узлов, создайте узел");
            }
            System.out.println(myNet.toString());
            System.out.println("Введите уникальный номер узла, в который будет занесен компьютер: ");
            int idNode = scan.nextInt();
            NodeComputers found = myNet.findById(idNode);
            if(found != null) {
                System.out.println("Задайте уникальный номер для компьютера: ");
                int idComp = scan.nextInt();
                System.out.println("Задайте размер памяти для компьютера: ");
                int memoryComp = scan.nextInt();
                Computer newComp = new Computer(idComp, memoryComp);
                found.addElement(newComp);
                toWriteStructure();
                showStructure();

            }
            else{
                System.out.println("Данный узел не найден ");
            }
        }catch (Throwable err){
            System.out.println(err);
        }
    }
    public void removeComputer() throws IOException, ClassNotFoundException {
        try {
            if(myNet.isEmpty()){
                throw new Error("Сеть не содержит узлов");
            }
            System.out.println(myNet.toString());
            System.out.println("Введите уникальный номер узла, в который будет удален из очереди компьютер: ");
            int idNode = scan.nextInt();
            NodeComputers found = myNet.findById(idNode);
            if(found != null) {
                found.removeElement();
                System.out.println("Компьютер удален из очереди");
                System.out.println(found.toString());
                toWriteStructure();
            }
            else{
                System.out.println("Данный узел не найден");
            }
        }catch(Throwable err){
            System.out.println(err);
        }

    }
    public void showStructure() {
        if(!myNet.isEmpty()){
            System.out.println(myNet.toString());
        }
    }
    public void toWriteStructure() {
        if(!myNet.isEmpty()){
            TextUtil util = new TextUtil();
            String path = "companyStructure.txt";
            util.toWrite(myNet, path);
        }
    }
    public void toReadStructure() {
        TextUtil util = new TextUtil();
        String path = "companyStructure.txt";
        util.toRead(path);
    }
}
