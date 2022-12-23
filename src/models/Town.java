package models;

public class Town {
    private String Title;
    private float NumberOfGuys;
    private String Country;

    public void setTitle(String title) {
        Title = title;
    }

    public void setNumberOfGuys(float numberOfGuys) {
        NumberOfGuys = numberOfGuys;
    }

    public void setCountry(String country) {
        Country = country;
    }

    public String getTitle() {
        return Title;
    }

    public float getNumberOfGuys() {
        return NumberOfGuys;
    }

    public String getCountry() {
        return Country;
    }

    public Town(String title, float numberOfGuys, String country) {
        Title = title;
        NumberOfGuys = numberOfGuys;
        Country = country;
    }
}