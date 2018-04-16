package com.netcracker.injector;

import com.netcracker.annotation.AutoInjectable;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStream;
import java.lang.reflect.Field;
import java.util.Properties;

public class Injector {
    private Properties properties;

    public Injector(){
        properties = new Properties();
        InputStream fis = getClass().getClassLoader().getResourceAsStream("app.properties");

        try {
            if(fis!=null){
                properties.load(fis);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public Object inject(Object object){
        for(Field field : object.getClass().getDeclaredFields()){
            field.setAccessible(true); // Отмена проверок доступа
            if(field.isAnnotationPresent(AutoInjectable.class)){
                try {
                    field.set(object, Class.forName(properties.getProperty(field.getType().getName())).newInstance());
                } catch (IllegalAccessException e) {
                    e.printStackTrace();
                } catch (InstantiationException e) {
                    e.printStackTrace();
                } catch (ClassNotFoundException e) {
                    e.printStackTrace();
                }
            }
        }

        return object;
    }
}
