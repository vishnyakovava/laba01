package com.netcracker;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import java.io.*;

public class Converter {

    public void convertObjectToXml(Object list, String path) {
        try {
            File file = new File(path);
            // create jaxb context
            JAXBContext context = JAXBContext.newInstance(list.getClass());
            // create jaxb marshaller
            Marshaller marshaller = context.createMarshaller();
            // устанавливаем флаг для читабельного вывода XML в JAXB
            marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);
            marshaller.setProperty(Marshaller.JAXB_FRAGMENT, Boolean.TRUE);
            marshaller.setProperty("com.sun.xml.bind.xmlHeaders", "<?xml version=\"1.0\" encoding=\"UTF-8\"?>");
            // маршаллинг объекта в файл
            marshaller.marshal(list, file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
    }

    public Object fromXmlToObject(String filePath, Object list) {
        File file = new File(filePath);
        try {
            // создаем объект JAXBContext - точку входа для JAXB
            JAXBContext jaxbContext = JAXBContext.newInstance(list.getClass());
            Unmarshaller un = jaxbContext.createUnmarshaller();
            return (Object) un.unmarshal(file);
        } catch (JAXBException e) {
            e.printStackTrace();
        }
        return null;
    }
}
