package com.company;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

public class BytesUtil {
    public static byte[] toByteArray(Object obj) throws IOException {
        byte[] bytes = null;
        ByteArrayOutputStream byteStream = null;
        ObjectOutputStream objStream = null;
        try {
            byteStream = new ByteArrayOutputStream();
            objStream = new ObjectOutputStream(byteStream);
            objStream.writeObject(obj);
            objStream.flush();
            bytes = byteStream.toByteArray();
        } finally {
            if (objStream != null) {
                objStream.close();
            }
            if (byteStream != null) {
                byteStream.close();
            }
        }
        return bytes;
    }
    public static Object toObject(byte[] bytes) throws IOException, ClassNotFoundException {
        Object obj = null;
        ByteArrayInputStream byteStream = null;
        ObjectInputStream objStream = null;
        try {
            byteStream = new ByteArrayInputStream(bytes);
            objStream = new ObjectInputStream(byteStream);
            obj = objStream.readObject();
        } finally {
            if (byteStream != null) {
                byteStream.close();
            }
            if (objStream != null) {
                objStream.close();
            }
        }
        return obj;
    }
    public static String toString(byte[] bytes) {
        return new String(bytes);
    }
}
