import javax.annotation.processing.Filer;
import java.io.BufferedReader;
import java.io.FileReader;

public class Student {

    private String name;
    private String lastName;
    private byte age;
    private short id;
    private String phoneNumber;
    private double percentage;

    Student (String name, String lastName, byte age, short id, String phoneNumber, double percentage){
        this.name = name;
        this.lastName = lastName;
        this.age = age;
        this.id = id;
        this.phoneNumber = phoneNumber;
        this.percentage = percentage;
    }
    public String getName(){
        return name;
    }
    public String getLastName(){
        return lastName;
    }
    public byte getAge(){
        return age;
    }
    public short getId(){
        return id;
    }
    public String getPhoneNumber(){
        return phoneNumber;
    }
    public double getPercentage(){
        return percentage;
    }
}
