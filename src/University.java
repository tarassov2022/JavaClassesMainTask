import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class University {
    static ArrayList<Student>students=new ArrayList<>();
// Создаем метод создания начального списка объектов с помощью конструктора класса Student с параметрами
    public  ArrayList<Student> MakeStudentsList() {
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
    // Создаем метод ввода новых обьектов в список с помощью конструктора класса Student (без параметров) и сеттеров

    public ArrayList<Student> InputStudentsToList()  {
        try {
        Student student=new Student();
        Scanner scanner = new Scanner(System.in);

        System.out.println("Фамилия:");
        student.setFirstName(scanner.next());
        System.out.println("Имя:");
        student.setSecondName(scanner.next());
        System.out.println("Отчество:");
        student.setPatronymic(scanner.next());

        System.out.println("ДР(дд.мм.гггг):");
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd.MM.yyyy");
        BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
        Calendar dateOfBirth= new GregorianCalendar();
        dateOfBirth.setTime(simpleDateFormat.parse(bufferedReader.readLine()));
        student.setBirthDate(dateOfBirth);

        System.out.println("Адрес:");
        student.setAddress(scanner.next());
        System.out.println("Телефон:");
        student.setTelephone(scanner.next());
        System.out.println("Факультет (Мехмат,ФПМ,Физфак):");
        student.setFaculty(scanner.next());
        System.out.println("Курс (цифра):");
        student.setCourse(scanner.nextInt());
        System.out.println("Группа (цифра):");
        student.setGroup(scanner.nextInt());
        students.add(student);


    } catch (IOException | ParseException | InputMismatchException e){
            Student.idGenerator--;
            System.out.println("Введенное значение недопустимо!");
        }
        return students;
    }
    // Создаем методы для формирования  данных ввиде списка объектов согласно заданным критериям поиска
    public ArrayList<Student> findStudentsByFaculty(String faculty) {
        ArrayList<Student> studentsOfFacultyList = new ArrayList();
         for (Student student : students) {
            if (student.getFaculty().equals(faculty)) {
                studentsOfFacultyList.add(new Student(student.getID(), student.getFirstName(), student.getSecondName(), student.getPatronymic(), student.getFaculty()));

            }
        }
        return studentsOfFacultyList;
    }
    public ArrayList<Student> findStudentsByCourseAndFaculty(String faculty, int course ) {
        ArrayList<Student> studentsOfCourseAndFacultyList = new ArrayList();
        for (Student student : students) {
            if ((student.getCourse()==course)&(student.getFaculty().equals(faculty))) {
                studentsOfCourseAndFacultyList.add(new Student(student.getID(), student.getFirstName(), student.getSecondName(), student.getPatronymic(), student.getFaculty(), student.getCourse()));

            }
        }
        return studentsOfCourseAndFacultyList;
    }
    public ArrayList<Student> findStudentsByCourseByFacultyAndByGroup(String faculty, int course, int group ) {
        ArrayList<Student> studentsOfGroupOfCourseAndOfFacultyList = new ArrayList();
        for (Student student : students) {
            if ((student.getCourse()==course)&(student.getFaculty().equals(faculty))&(student.getGroup()==group)) {
                studentsOfGroupOfCourseAndOfFacultyList.add(new Student(student.getID(), student.getFirstName(), student.getSecondName(), student.getPatronymic(), student.getFaculty(), student.getCourse(), student.getGroup()));

            }
        }
        return studentsOfGroupOfCourseAndOfFacultyList;
    }
    public ArrayList<Student> findStudentsByBirthDate(Calendar dateOfBirth) {
        ArrayList<Student> studentsBornAfterTheDateList = new ArrayList();
        for (Student student : students) {
            if (dateOfBirth.get(Calendar.YEAR)<student.getBirthDate().get(Calendar.YEAR)) {
                studentsBornAfterTheDateList.add(new Student(student.getID(), student.getFirstName(), student.getSecondName(), student.getPatronymic(), student.getBirthDate()));

            }
        }
        return studentsBornAfterTheDateList;
    }

}
