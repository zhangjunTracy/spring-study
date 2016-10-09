package springweb.annotation;

import springweb.annotation.Sex.Gender;

public class Student {

    @StudentName("zhangsan")
    private String name;

    @Sex(getGender = Gender.MALE)
    private String gender;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

}
