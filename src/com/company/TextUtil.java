package com.company;


import java.io.*;

public class TextUtil {

    public void toWrite(Network network, String path) {
        try(FileWriter writer = new FileWriter(path, false)) {
            String text = network.toString();
            writer.write(text);
            writer.flush();
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }
    public void toRead(String path) {
        try(FileReader reader = new FileReader(path)) {
            // читаем посимвольно
            int c;
            while((c=reader.read())!=-1){
                System.out.print((char)c);
            }
        }
        catch(IOException ex){
            System.out.println(ex.getMessage());
        }
    }

}
