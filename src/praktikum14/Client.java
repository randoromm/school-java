package praktikum14;

import java.io.Serializable;

import static praktikum14.ShoeShop.serializeClients;

/**
 * The client class for clients of shoe shop.
 * Created by Rando on 20.11.2016.
 */
public class Client implements Serializable{
    String name;
    int age;
    int shoeNumber;

    public Client(String name, int age, int shoeNumber) {
        this.name = name;
        this.age = age;
        this.shoeNumber = shoeNumber;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
        serializeClients();
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
        serializeClients();
    }

    public int getShoeNumber() {
        return shoeNumber;
    }

    public void setShoeNumber(int shoeNumber) {
        this.shoeNumber = shoeNumber;
        serializeClients();
    }

    @Override
    public String toString() {
        return "Client{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", shoeNumber=" + shoeNumber +
                '}';
    }
}
