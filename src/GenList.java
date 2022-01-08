import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class GenList   {
    static ArrayList<Student>students=new ArrayList<>();
// Создаем метод создания начального массива объектов с помощью конструктора класса Student с параметрами
    public  ArrayList<Student> MakeList() {
    students.add(new Student(1,"Тарасов","Андрей","Дмитриевич",new GregorianCalendar(1990, 0 , 19),"Минск", "23454322", "Мехмат", 1, 1));
    students.add(new Student(2,"Петров","Алексей","Иванович",new GregorianCalendar(1991,2,4) ,"Пинск", "54321232", "Физфак", 1, 2));
    students.add(new Student( 3,"Иванов","Сергей","Платонович",new GregorianCalendar(1992,3,24) ,"Брест", "78654321", "ФПМ", 1, 2));
    students.add(new Student( 4,"Сидоров","Олег","Леонидович",new GregorianCalendar(1993,5,12) ,"Минск", "23476532", "Мехмат", 2, 1));
    students.add(new Student( 5,"Андреева","Ольга","Валерьевна",new GregorianCalendar(1993,6,17) ,"Минск", "2348832", "Мехмат", 2, 2));
    students.add(new Student(6, "Климова","Юлия","Александровна",new GregorianCalendar(1990,7,15) ,"Минск", "2348865", "ФПМ", 2, 1));
    students.add(new Student( 7,"Тушуев","Александр","Валерьевич",new GregorianCalendar(1991,0,23) ,"Пинск", "2365832", "Физфак", 1, 1));
    students.add(new Student( 8,"Демьянов","Сергей","Александрович",new GregorianCalendar(1995,5,21),"Брест", "2332832", "ФПМ", 1, 1));
    students.add(new Student(9, "Полозов","Иван","Иванович",new GregorianCalendar(1994,3,14) ,"Пинск", "8948832", "Физфак", 2, 2));
    students.add(new Student( 10,"Кузьмин","Игорь","Евгеньевич",new GregorianCalendar(1992,8,18) ,"Минск", "2348932", "Мехмат", 1, 1));
    students.add(new Student( 11,"Шафран","Карина","Сергеевна",new GregorianCalendar(1995,6,17) ,"Минск", "2349532", "ФПМ", 1, 2));
    students.add(new Student( 12,"Павлов","Ярослав","Валерьевич",new GregorianCalendar(1991,5,15) ,"Пинск", "2348899", "Мехмат", 2, 1));
    return students;
    }
    // Создаем метод ввода новых обьектов в массив с помощью конструктора класса Student (без параметров) и сеттеров

    public ArrayList<Student> InpList()  {
        try {
        Student student=new Student();
        Scanner sc = new Scanner(System.in);

        System.out.println("Фамилия:");
        student.setFname(sc.next());
        System.out.println("Имя:");
        student.setSname(sc.next());
        System.out.println("Отчество:");
        student.setPatr(sc.next());

        System.out.println("ДР(дд.мм.гггг):");
        SimpleDateFormat sdf = new SimpleDateFormat("dd.MM.yyyy");
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        Calendar date= new GregorianCalendar();
        date.setTime(sdf.parse(br.readLine()));
        student.setBirth(date);

        System.out.println("Адрес:");
        student.setAddr(sc.next());
        System.out.println("Телефон:");
        student.setTel(sc.next());
        System.out.println("Факультет (Мехмат,ФПМ,Физфак):");
        student.setFac(sc.next());
        System.out.println("Курс (цифра):");
        student.setCourse(sc.nextInt());
        System.out.println("Группа (цифра):");
        student.setGr(sc.nextInt());
        students.add(student);


    } catch (IOException | ParseException | InputMismatchException e){
            Student.idGenerator--;
            System.out.println("Введенное значение недопустимо!");
        }
        return students;
    }
    // Создаем методы для формирования списков данных ввиде массивов объектов согласно заданным критериям поиска
    public ArrayList<Student> findStudentsByFac(String fac) {
        ArrayList<Student> stList = new ArrayList();
         for (Student p : students) {
            if (p.getFac().equals(fac)) {
                stList.add(new Student(p.getID(), p.getFname(), p.getSname(), p.getPatr(), p.getFac()));

            }
        }
        return stList;
    }
    public ArrayList<Student> findStudentsByCourse(String fac,int course ) {
        ArrayList<Student> stList = new ArrayList();
        for (Student p : students) {
            if ((p.getCourse()==course)&(p.getFac().equals(fac))) {
                stList.add(new Student(p.getID(), p.getFname(), p.getSname(), p.getPatr(), p.getFac(), p.getCourse()));

            }
        }
        return stList;
    }
    public ArrayList<Student> findStudentsByGr(String fac,int course, int gr ) {
        ArrayList<Student> stList = new ArrayList();
        for (Student p : students) {
            if ((p.getCourse()==course)&(p.getFac().equals(fac))&(p.getGr()==gr)) {
                stList.add(new Student(p.getID(), p.getFname(), p.getSname(), p.getPatr(), p.getFac(), p.getCourse(), p.getGr()));

            }
        }
        return stList;
    }
    public ArrayList<Student> findStudentsByBirth(Calendar date) {
        ArrayList<Student> stList = new ArrayList();
        for (Student p : students) {
            if (date.get(Calendar.YEAR)<p.getBirth().get(Calendar.YEAR)) {
                stList.add(new Student(p.getID(), p.getFname(), p.getSname(), p.getPatr(), p.getBirth()));

            }
        }
        return stList;
    }

}
