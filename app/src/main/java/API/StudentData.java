package API;

import com.google.gson.annotations.SerializedName;

public class StudentData {
    @SerializedName("id")
    private int id;
    @SerializedName("firstName")
    private String name;

    @SerializedName("lastName")
    private String lastname;
    @SerializedName("age")
    private int age;
    @SerializedName("grade")
    private String grade;

    @SerializedName("description")
    private String description;

    @SerializedName("school_id")
    private int schoolId;

    public StudentData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

    public int getSchoolId() {
        return schoolId;
    }

    public void setSchoolId(int schoolId) {
        this.schoolId = schoolId;
    }

    @Override
    public String toString() {
        return "StudentData: [id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + "]";
    }
}
