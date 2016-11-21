package praktikum14;

import java.io.Serializable;

import static praktikum14.ShoeShop.serializeClients;

/**
 * The client class for clients of shoe shop.
 * Created by Rando on 20.11.2016.
 */
class Client implements Serializable{
    private String name;
    private int age;
    private int shoeNumber;

    Client(String name, int age, int shoeNumber) {
        this.name = name;
        this.age = age;
        this.shoeNumber = shoeNumber;
    }

    String getName() {
        return name;
    }

    void setName(String name) {
        this.name = name;
        serializeClients();
    }

    int getAge() {
        return age;
    }

    void setAge(int age) {
        this.age = age;
        serializeClients();
    }

    int getShoeNumber() {
        return shoeNumber;
    }

    void setShoeNumber(int shoeNumber) {
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
