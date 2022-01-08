import java.text.SimpleDateFormat;
import java.util.Calendar;

public class Student {
    static int idGenerator=1;

    //инкапсулируюсь
    private int id;
    private String fname;
    private String sname;
    private String patr;
    private Calendar birth;
    private String addr;
    private String tel;
    private String fac;
    private int course;
    private int gr;




//Конструкторы с параметрами
    public Student(int id, String fname,String sname,String patr,Calendar birth,String addr,String tel,
                   String fac,int course,int gr ) {


        this.id=idGenerator++;
        this.fname=fname;
        this.sname=sname;
        this.patr=patr;
        this.birth=birth;
        this.addr=addr;
        this.tel=tel;
        this.fac=fac;
        this.course=course;
        this.gr=gr;

    }

    public Student(int id,String fname,String sname,String patr, String fac ) {

        this.id=id;
        this.fname=fname;
        this.sname=sname;
        this.patr=patr;
        this.fac=fac;

    }
    public Student(int id,String fname,String sname,String patr, String fac,int course ) {

        this.id=id;
        this.fname=fname;
        this.sname=sname;
        this.patr=patr;
        this.fac=fac;
        this.course=course;

    }
    public Student(int id, String fname,String sname,String patr,Calendar birth ) {

        this.id=id;
        this.fname=fname;
        this.sname=sname;
        this.patr=patr;
        this.birth=birth;

    }
    public Student(int id,String fname,String sname,String patr, String fac,int course,int gr ) {

        this.id=id;
        this.fname=fname;
        this.sname=sname;
        this.patr=patr;
        this.fac=fac;
        this.course=course;
        this.gr=gr;

    }


    //Конструктор без параметров
    public Student(){
        id=idGenerator++;
    }
    public enum PrintFormat{
        F1, F2, F3,F4,F5
    }
    //Переопределяем метод для разных конструктров
    public String toString(PrintFormat format){
        SimpleDateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
        switch(format){
            case F1:
                return "ID: "+id+", "+fname+" "+sname+" "+patr+",  "+fac+" курс: "+course+" группа: "+gr;

            case F2:
                return "ID: "+id+" "+fname+" "+sname+" "+patr+",  "+fac;

            case F3:
                return  "ID: "+id+" "+fname+" "+sname+" "+patr+",  "+fac+" курс: "+course;
            case F4:
                return "ID: "+id+" "+fname+" "+sname+" "+patr+",  "+formatter.format(birth.getTime());

            default:
                return "ID: "+getID()+", "+getFname()+" "+getSname()+" "+getPatr()+", дата рождения:"+formatter.format(getBirth().getTime())+", "+getAddr()+", телефон: "+
                        getTel()+", "+getFac()+" курс: "+getCourse()+" группа: "+getGr();

        }

    }




    //определяем геттеры и сеттеры

    public int getID(){return id;}

    public String getFname() {
        return fname;
    }
    public String getSname() {
        return sname;
    }
    public String getPatr() {
        return patr;
    }
    public String getFac() {
        return fac;
    }
    public int getCourse() {
        return course;
    }
    public Calendar getBirth() {
        return birth;
    }
    public int getGr() {
        return gr;
    }
    public String getAddr() {
        return addr;
    }
    public String getTel() {
        return tel;
    }

    public void setFname(String fname) {this.fname = fname;}
    public void setSname(String sname) {
        this.sname = sname;
    }
    public void setPatr(String patr) {
        this.patr = patr;
    }
    public void setBirth(Calendar birth) {
        this.birth = birth;
    }
    public void setAddr(String addr) {
        this.addr = addr;
    }
    public void setTel(String tel) {
        this.tel = tel;
    }
    public void setFac(String fac) {
        this.fac = fac;
    }
    public void setCourse(int course) {
        this.course = course;
    }
    public void setGr(int gr) {
        this.gr = gr;
    }

}
