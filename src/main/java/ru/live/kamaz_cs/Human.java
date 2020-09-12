package ru.live.kamaz_cs;

public class Human {

    private String name;
    private String surname;
    private String sex;
    private String CityOfResidence;

    public Human() {
    }

    public Human(String name, String surname, String sex, String cityOfResidence) {
        this.name = name;
        this.surname = surname;
        this.sex = sex;
        CityOfResidence = cityOfResidence;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getSurname() {
        return surname;
    }

    public void setSurname(String surname) {
        this.surname = surname;
    }

    public String getSex() {
        return sex;
    }

    public void setSex(String sex) {
        this.sex = sex;
    }

    public String getCityOfResidence() {
        return CityOfResidence;
    }

    public void setCityOfResidence(String cityOfResidence) {
        CityOfResidence = cityOfResidence;
    }

}
