import java.io.*;
import java.util.Scanner;
import java.util.LinkedList;

public class SystemManagment {
    int startID;
    Scanner input;
    LinkedList<Student> list = new LinkedList<>();

    // loads the existing info into the list
    // it gets the current idGiver as well
    SystemManagment(){
        input = new Scanner(System.in);

        try{
            FileReader fileReader = new FileReader("list.csv");
            BufferedReader bufferedReader = new BufferedReader(fileReader);

            String startId = bufferedReader.readLine();
            startID = (short) (Integer.parseInt(startId));

            String temp;
            while ((temp = bufferedReader.readLine()) != null){
                String[] info = temp.split(",");
                String name = info[0];
                String lastName = info[1];
                byte age = Byte.parseByte(info[2]);
                short id = Short.parseShort(info[3]);
                String phoneNumber = info[4];
                double percentage = Double.parseDouble(info[5]);
                Student st = new Student(name, lastName, age, id,phoneNumber, percentage);
                list.add(st);
            }
            bufferedReader.close();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
    // adds students to the list and to the file
    public void add(){
        System.out.print("name: ");
        String name = input.nextLine();

        System.out.print("last_name: ");
        String lastName = input.next();

        System.out.print("age: ");
        byte age = input.nextByte();

        short id = (short) startID++;

        System.out.print("phone_number: ");
        String phoneNumber = input.next();

        System.out.print("average number: ");
        double percentage = input.nextDouble();
        input.nextLine();

        short a = 1;
        Student temp = new Student(name, lastName, age, id, phoneNumber, percentage);
        list.add(temp);
        writeToFile(temp);
    }
    // works with (add) and writes the info of a single student
    private void writeToFile(Student student){
        try{
            FileWriter fileWriter = new FileWriter("list.csv", true);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            String out = student.getName() +","+ student.getLastName() +","+ student.getAge()  +"," + student.getId() +","+ student.getPhoneNumber() +","+ student.getPercentage()+ "\n";
            bufferedWriter.write(out);
            bufferedWriter.close();
        }catch (IOException e){
            e.printStackTrace();
        }

    }
    // display all students info
    public void display(){
        for (Student student: list){
            System.out.println("Name: " + student.getName());
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("Age: " + student.getAge());
            System.out.println("ID: " + student.getId());
            System.out.println("Phone Number: " + student.getPhoneNumber());
            System.out.println("Percentage: " + student.getPercentage());
            System.out.println("-----------------------------------------");
        }
    }
    // searches through the list and returns a Student or null
    private Student search(short id){
        for (Student student: list){
            if (student.getId() == id)
                return student;
        }
        return null;
    }
    // takes the returned Student from search and displays its info
    void showStudentInfo(short id){
        Student student = search(id);
        if (student != null){
            System.out.println("Name: " + student.getName());
            System.out.println("Last Name: " + student.getLastName());
            System.out.println("Age: " + student.getAge());
            System.out.println("ID: " + student.getId());
            System.out.println("Phone Number: " + student.getPhoneNumber());
            System.out.println("Percentage: " + student.getPercentage());
        }else{
            System.out.format("Student with the ID %d was not found!\n", id);
        }
    }
    // find the index of student to remove
    private int searchForDelete(int id){
        int i = 0;
        for (Student student: list){
            if (student.getId() == id)
                return i;
            i++;
        }
        return -1;
    }
    // deletes it
    public void delete(int id){
        int indexToDelete = searchForDelete(id);
        if (indexToDelete != -1){
            list.remove(indexToDelete);
        }else{
            System.out.println("Student not found!");
        }
    }
    // show the name and id for deleting
    public void showNameAndId(){
        for (Student student: list){
            System.out.println("Name: " + student.getName() + " ID: " + student.getId());
        }
    }
    // writes all info in the list to the file including the startID (ID setter)
    void exit(){
        try{
            FileWriter fileWriter = new FileWriter("list.csv");
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);

            bufferedWriter.write(startID + "\n");

            for(Student student: list){
                String temp = student.getName() +","+ student.getLastName() +","+ student.getAge()  +"," + student.getId() +","+ student.getPhoneNumber() +","+ student.getPercentage()+ "\n";
                bufferedWriter.write(temp);
            }
            bufferedWriter.close();

        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
