    package API;


    import com.google.gson.annotations.SerializedName;

    public class UserData {
        @SerializedName("userid")
        private int id;

        @SerializedName("idSchool")
        private int idSchool;
        @SerializedName("username")
        private String username;

        @SerializedName("password")
        private String password;
        @SerializedName("firstName")
        private String name;

        @SerializedName("lastName")
        private String lastname;

        @SerializedName("role")
        private String role;

        @SerializedName("description")
        private String description;

        @SerializedName("schoolid")
        private int schoolId;

        public UserData() {
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
        public String getLastname() {
            return lastname;
        }

        public void setLastname(String lastname) {
            this.lastname = lastname;
        }

        public int getSchoolId() {
            return schoolId;
        }

        public int getIdSchool() {
            return idSchool;
        }

        public void setIdSchool(int idSchool) {
            this.idSchool = idSchool;
        }

        public void setSchoolId(int schoolId) {
            this.schoolId = schoolId;
        }

        public String getRole() {
            return role;
        }

        public String getDescription() {
            return description;
        }

        public void setDescription(String description) {
            this.description = description;
        }
        @Override
        public String toString() {
            return "StudentData: [userid=" + id + ", username=" + username + "]" ;
        }
    }

