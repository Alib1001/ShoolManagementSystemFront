package API;

import com.google.gson.annotations.SerializedName;

public class StudentData extends UserData {
    @SerializedName("user_id")
    private int id;

    @SerializedName("username")
    private String username;

    @SerializedName("password")
    private String password;
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

    @SerializedName("role")
    private String role;

    public StudentData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
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
        return "StudentData: [id=" + id + ", name=" + name + ", age=" + age + ", grade=" + grade + "]" ;
    }
}
