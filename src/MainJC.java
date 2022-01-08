import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.InputMismatchException;
import java.util.Scanner;

public class MainJC {
    static String type;
    static int type1;
    static int type2;



    public static void main(String[] args)  {
         GenList stds= new GenList();

        for (Student student : stds.MakeList()) {

                System.out.println(student.toString(Student.PrintFormat.F5));
        }
        Scanner scanner = new Scanner(System.in);

        do {
            System.out.println("Если хотите добавить студентов, Y: ");
            type = scanner.next();
            if(type.equals("Y")){
                for (Student student : stds.InpList()) {

                    System.out.println(student.toString(Student.PrintFormat.F5));
                }
            }

        } while (type.equals("Y"));
        try{
        System.out.println("Введите название факультета (Мехмат,ФПМ,Физфак)");
        type = scanner.next();
        System.out.println("Список  факультета "+type+":");
        for (Student student:stds.findStudentsByFac(type)){
            System.out.println(student.toString(Student.PrintFormat.F2));
        }

        System.out.println("Введите название факультета (Мехмат,ФПМ,Физфак):");
        type = scanner.next();
        System.out.println("Введите курс (цифра):");
        type1 = scanner.nextInt();
        System.out.println("Список "+type1+" курса"+" факультета "+type);
        for (Student student:stds.findStudentsByCourse(type,type1)){
            System.out.println(student.toString(Student.PrintFormat.F3));
        }

        System.out.println("Введите название факультета (Мехмат,ФПМ,Физфак):");
        type = scanner.next();
        System.out.println("Введите курс (цифра):");
        type1 = scanner.nextInt();
        System.out.println("Введите группу (цифра):");
        type2 = scanner.nextInt();
        System.out.println("Список "+type2+ " группы "+type1+" курса"+" факультета "+type);
        for (Student student:stds.findStudentsByGr(type,type1,type2)){
            System.out.println(student.toString(Student.PrintFormat.F1));
        }


        System.out.println("Введите год (гггг):");
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Calendar date=new GregorianCalendar();
        date.setTime(sdf.parse(br.readLine()));

        System.out.println("Студенты родившиеся после "+date.get(Calendar.YEAR)+" года");
        for (Student student:stds.findStudentsByBirth(date)){
            System.out.println(student.toString(Student.PrintFormat.F4));
        }


    }catch (InputMismatchException  | IOException | ParseException e){
            System.out.println("Введенное значение недопустимо!");
        }
        scanner.close();

    }




}
