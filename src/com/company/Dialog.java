package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {
    Scanner scan = new Scanner(System.in);
    Network myNet = new Network();

    public  Dialog(){
        NodeComputers myNode1 = new NodeComputers(1, 4);
//        Computer myComp2 = new Computer(2, 256);
//        Computer myComp3 = new Computer(3, 512);
//        Computer myComp5 = new Computer(5, 128);
//        myNet.addElement(myNode1);
//        myNode1.addElement(myComp2);
//        myNode1.addElement(myComp3);
//        myNode1.addElement(myComp5);
    }
    public void start() throws IOException, ClassNotFoundException {

        while (true) {
            try{
                System.out.println("Выберите действие: Введите для добавление узла - 1, для удаление Узла - 2, " +
                        "для добавления Компьютера - 3, для удаления компьютера - 4, " +
                        "для просмотра структуры сети - 5 ");
                int answerAction = scan.nextInt();

                switch (answerAction) {
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
                        serializable();
                        break;
                }
                start();
            }catch (InputMismatchException e){
                System.out.println("неправильно введенно значение");
            }
            catch (Throwable err) {

                System.out.println(err);
            }
        }


//        System.out.println("Продолжить? Для продолжения нажмите любую клавишу, для выхода нажмите клавишу 'q': ");
//        String answerContinue = scan.nextLine();
//        System.out.println(answerContinue);
//        if(answerContinue != "q"){
//            start();
//        } else{
//            return;
//        }


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
            System.out.println(myNet.toString());
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
            serializable();
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
                serializable();
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
            }
            else{
                System.out.println("Данный узел не найден");
            }
        }catch(Throwable err){
            System.out.println(err);
        }

    }
    public void serializable() throws IOException, ClassNotFoundException {
        String path = "C:\\Users\\Ralina\\Desktop\\structureNet.ser";
        if(!myNet.isEmpty()) {
            myNet.writeNetwork(path);
            myNet.readNetwork(path);
        }
    }
}
