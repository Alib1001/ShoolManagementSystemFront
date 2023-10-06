package API;

import com.google.gson.annotations.SerializedName;

public class SchoolData {
    @SerializedName("id")
    private int id;
    @SerializedName("rating")
    private int rating;

    @SerializedName("name")
    private String name;

    @SerializedName("description")
    private String description;

    @SerializedName("focus")
    private String focus;

    @SerializedName("address")
    private String address;

    public String getImguri() {
        return imguri;
    }

    public void setImguri(String imguri) {
        this.imguri = imguri;
    }

    @SerializedName("imguri")
    private String imguri;

    public SchoolData() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }



    public int getRating() {
        return rating;
    }

    public void setRating(int rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFocus() {
        return focus;
    }

    public void setFocus(String focus) {
        this.focus = focus;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    @Override
    public String toString() {
        return "SchoolData: [id=" + id + ", rating=" + rating + ", schoolName=" + name + ", description=" + description + ", focus=" + focus + ", address=" + address + imguri + "]";
    }
}
