package com.netcracker.entities;

import javax.xml.bind.annotation.*;


@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(propOrder = {"model", "brand", "serialNumber"})
public class Car {
    @XmlElement
    private String model;
    @XmlElement
    private String brand;
    @XmlAttribute
    private int ID;
    @XmlElement
    private int serialNumber;
    private static int id=0;

    /**
     * Конструктор
     * @param model модель машины
     * @param serialNumber серийный номер
     */
    public Car(String brand, String model, int serialNumber){
        setModel(model);
        setBrand(brand);
        setSerialNumber(serialNumber);
        id++;
        this.ID = id;
    }

    public Car(){}

    /**
     * Геттер ID
     * @return ID
     */
    public int getID(){ return ID; }

    /**
     * Сеттер для марки машины
     * @param brand марка машины
     */
    public void setBrand(String brand){ this.brand = brand; }

    /**
     * Геттер для марки машины
     * @return марка машины
     */
    public String getBrand(){return brand;}

    /**
     * Сеттер модели
     * @param model модель машины
     */
    public  void setModel(String model){ this.model = model; }

    /**
     * Геттер модели
     * @return модель машины
     */
    public String getModel(){return model;}

    /**
     * Сеттер серийного номера
     * @param serialNumber серийный номер
     */
    public void setSerialNumber(int serialNumber){this.serialNumber = serialNumber;}

    /**
     * Геттер серийного номера
     * @return серийный номер
     */
    public int getSerialNumber(){return serialNumber;}

    /**
     * @return информацию о машине
     */
    public String toString(){
        return "Class: " + this.getClass().getSimpleName() + ", Brand:"+getBrand() +", Model:"+getModel()+", ID:"+getID()+", serial number:"+getSerialNumber();
    }
}
