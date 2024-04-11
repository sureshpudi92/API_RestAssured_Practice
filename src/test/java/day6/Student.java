package day6;

public class Student {

    String name;
    String phone;
    String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String[] getCoursesArr() {
        return coursesArr;
    }

    public void setCoursesArr(String[] coursesArr) {
        this.coursesArr = coursesArr;
    }

    String[] coursesArr;

}
