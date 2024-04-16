import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        SystemManagment sample = new SystemManagment();
        Scanner input = new Scanner(System.in);

        System.out.println("Welcome to Student Management System");
        while (true){
            System.out.println();
            System.out.println("1. Add");
            System.out.println("2. Delete");
            System.out.println("3. Show student info");
            System.out.println("4. Show all students info");
            System.out.println("5. Exit");


            int choice = input.nextInt();
            input.nextLine();

            switch (choice){
                case 1:{
                    sample.add();
                }
                break;
                case 2:{
                    sample.showNameAndId();
                    System.out.print("Enter student ID to delete: ");
                    int del = input.nextInt();
                    sample.delete(del);
                }
                break;
                case 3:{
                    System.out.print("Enter student Id to show its info: ");
                    short info = input.nextShort();
                    sample.showStudentInfo(info);
                }
                break;
                case 4:{
                    sample.display();
                }
                break;
                case 5:{
                    sample.exit();
                    return;
                }
                default:{
                    System.out.println("Invalid input!");
                }
            }

        }

    }
}