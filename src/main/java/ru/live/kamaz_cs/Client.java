package ru.live.kamaz_cs;

public class Client extends Human {

    public Client() {
        super();
    }

    public Client(String name, String surname, String sex, String cityOfResidence) {
        super(name, surname, sex, cityOfResidence);
    }

    @Override
    public String getName() {
        return super.getName();
    }

    @Override
    public void setName(String name) {
        super.setName(name);
    }

    @Override
    public String getSurname() {
        return super.getSurname();
    }

    @Override
    public void setSurname(String surname) {
        super.setSurname(surname);
    }

    @Override
    public String getSex() {
        return super.getSex();
    }

    @Override
    public void setSex(String sex) {
        super.setSex(sex);
    }

    @Override
    public String getCityOfResidence() {
        return super.getCityOfResidence();
    }

    @Override
    public void setCityOfResidence(String cityOfResidence) {
        super.setCityOfResidence(cityOfResidence);
    }
}
