package com.company;


import java.io.*;
import java.util.Scanner;

public class TextUtil {

    public void toWrite(Network network, String path) {
        try(FileWriter writer = new FileWriter(path, false)) {
            String text = network.toSaveString();
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public Network toRead(File file, Network network) throws FileNotFoundException {
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
                network.addElement(node);
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
        return network;
    }

}
