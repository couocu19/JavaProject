package managementsystem;

public class Studentinfo {
    private int sid;
    private String name;
    private int age;
    private float grade;

    public Studentinfo( int sid,String name, int age, float grade) {
        this.sid = sid;
        this.name = name;
        this.age = age;
        this.grade = grade;
    }

    public Studentinfo(){

    }
    public int getSId() {
        return sid;
    }

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public float getGrade() {
        return grade;
    }
}
