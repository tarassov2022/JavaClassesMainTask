import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Student {
    static int idGenerator=1;
    private int id;


    private String firstName;
    private String secondName;
    private String patronymic;
    private Calendar birthDate;
    private String address;
    private String telephone;
    private String faculty;
    private int course;
    private int group;


//Конструкторы с параметрами


    public Student( int id, String firstName, String secondName, String patronymic, Calendar birthDate, String address, String telephone,
                   String faculty, int course, int group) {


        this.id=idGenerator++;
        this.firstName =firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;
        this.address = address;
        this.telephone = telephone;
        this.faculty = faculty;
        this.course=course;
        this.group = group;

    }

    public Student(int id, String firstName, String secondName, String patronymic, String faculty) {

        this.id=id;
        this.firstName =firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.faculty = faculty;

    }
    public Student(int id, String firstName, String secondName, String patronymic, String faculty, int course ) {

        this.id=id;
        this.firstName =firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.faculty = faculty;
        this.course=course;

    }
    public Student(int id, String firstName, String secondName, String patronymic, Calendar birthDate) {

        this.id=id;
        this.firstName =firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.birthDate = birthDate;

    }
    public Student(int id, String firstName, String secondName, String patronymic, String faculty, int course, int group) {

        this.id=id;
        this.firstName =firstName;
        this.secondName = secondName;
        this.patronymic = patronymic;
        this.faculty = faculty;
        this.course=course;
        this.group = group;

    }

//Конструктор без параметров

    public Student(){
        id=idGenerator++;
    }

    public enum PrintFormat{
        F1, F2, F3,F4,F5
    }
    //Переопределяем метод для разных конструктров
    public String toString(PrintFormat printFormat){
        SimpleDateFormat simpleDateFormat = new SimpleDateFormat("dd-MM-yyyy");
        switch(printFormat){
            case F1:
                return "ID: "+id+", "+ firstName +" "+ secondName +" "+ patronymic +",  "+ faculty +" курс: "+course+" группа: "+ group;

            case F2:
                return "ID: "+id+" "+ firstName +" "+ secondName +" "+ patronymic +",  "+ faculty;

            case F3:
                return  "ID: "+id+" "+ firstName +" "+ secondName +" "+ patronymic +",  "+ faculty +" курс: "+course;
            case F4:
                return "ID: "+id+" "+ firstName +" "+ secondName +" "+ patronymic +",  "+simpleDateFormat.format(birthDate.getTime());

            default:
                return "ID: "+getID()+", "+ getFirstName()+" "+ getSecondName()+" "+ getPatronymic()+", дата рождения:"+simpleDateFormat.format(getBirthDate().getTime())+", "+ getAddress()+", телефон: "+
                        getTelephone()+", "+ getFaculty()+" курс: "+getCourse()+" группа: "+ getGroup();

        }

    }






    public int getID(){return id;}

    public String getFirstName() {
        return firstName;
    }
    public String getSecondName() {
        return secondName;
    }
    public String getPatronymic() {
        return patronymic;
    }
    public String getFaculty() {
        return faculty;
    }
    public int getCourse() {
        return course;
    }
    public Calendar getBirthDate() {
        return birthDate;
    }
    public int getGroup() {
        return group;
    }
    public String getAddress() {
        return address;
    }
    public String getTelephone() {
        return telephone;
    }

    public void setFirstName(String firstName) {this.firstName = firstName;}
    public void setSecondName(String secondName) {
        this.secondName = secondName;
    }
    public void setPatronymic(String patronymic) {
        this.patronymic = patronymic;
    }
    public void setBirthDate(Calendar birthDate) {
        this.birthDate = birthDate;
    }
    public void setAddress(String address) {
        this.address = address;
    }
    public void setTelephone(String telephone) {
        this.telephone = telephone;
    }
    public void setFaculty(String faculty) {
        this.faculty = faculty;
    }
    public void setCourse(int course) {
        this.course = course;
    }
    public void setGroup(int group) {
        this.group = group;
    }

}
