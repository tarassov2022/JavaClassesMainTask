import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Main {
    static String typeDataInConsole;
    static int typeCourseInConsole;
    static int typeGroupInConsole;



    public static void main(String[] args)  {
         University university= new University();

        for (Student student : university.MakeStudentsList()) {

                System.out.println(student.toString(Student.PrintFormat.F5));
        }
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Если хотите добавить студентов, Y: ");
            typeDataInConsole = scanner.next();
            if(typeDataInConsole.equals("Y")){
                for (Student student : university.InputStudentsToList()) {

                    System.out.println(student.toString(Student.PrintFormat.F5));
                }
            }

        } while (typeDataInConsole.equals("Y"));
        try{
        System.out.println("Введите название факультета (Мехмат,ФПМ,Физфак)");
        typeDataInConsole = scanner.next();
        System.out.println("Список  факультета "+ typeDataInConsole +":");
        for (Student student:university.findStudentsByFaculty(typeDataInConsole)){
            System.out.println(student.toString(Student.PrintFormat.F2));
        }

        System.out.println("Введите название факультета (Мехмат,ФПМ,Физфак):");
        typeDataInConsole = scanner.next();
        System.out.println("Введите курс (цифра):");
        typeCourseInConsole = scanner.nextInt();
        System.out.println("Список "+ typeCourseInConsole +" курса"+" факультета "+ typeDataInConsole);
        for (Student student:university.findStudentsByCourseAndFaculty(typeDataInConsole, typeCourseInConsole)){
            System.out.println(student.toString(Student.PrintFormat.F3));
        }

        System.out.println("Введите название факультета (Мехмат,ФПМ,Физфак):");
        typeDataInConsole = scanner.next();
        System.out.println("Введите курс (цифра):");
        typeCourseInConsole = scanner.nextInt();
        System.out.println("Введите группу (цифра):");
        typeGroupInConsole = scanner.nextInt();
        System.out.println("Список "+ typeGroupInConsole + " группы "+ typeCourseInConsole +" курса"+" факультета "+ typeDataInConsole);
        for (Student student:university.findStudentsByCourseByFacultyAndByGroup(typeDataInConsole, typeCourseInConsole, typeGroupInConsole)){
            System.out.println(student.toString(Student.PrintFormat.F1));
        }


        System.out.println("Введите год (гггг):");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("yyyy");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Calendar dateOfBirth=new GregorianCalendar();
        dateOfBirth.setTime(simpleDateFormat.parse(bufferedReader.readLine()));

        System.out.println("Студенты родившиеся после "+dateOfBirth.get(Calendar.YEAR)+" года");
        for (Student student:university.findStudentsByBirthDate(dateOfBirth)){
            System.out.println(student.toString(Student.PrintFormat.F4));
        }


    }catch (InputMismatchException  | IOException | ParseException e){
            System.out.println("Введенное значение недопустимо!");
        }
        scanner.close();

    }




}
