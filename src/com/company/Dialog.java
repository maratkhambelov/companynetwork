package com.company;

import java.io.IOException;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Dialog {
    Scanner scan = new Scanner(System.in);
    Network myNet = new Network();
    public void start() throws IOException, ClassNotFoundException {
        try {
            int number;

            do {
                System.out.println("Выберите действие: Введите для добавление узла - 1, для удаление Узла - 2, " +
                        "для добавления Компьютера - 3, для удаления компьютера - 4, " +
                        "для просмотра структуры сети - 5");
                while (!scan.hasNextInt()) {
                    System.out.println("неправильно введенно значение");
                    scan.next(); // this is important!
                }
                number = scan.nextInt();
            } while (number < 0 && number > 5);
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
                    serializable();
                    break;
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
