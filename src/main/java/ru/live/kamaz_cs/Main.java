package ru.live.kamaz_cs;

import java.sql.SQLException;

public class Main {

    public static void main(String[] args) throws SQLException {

        TableOfClients tc = new TableOfClients();
        tc.start();

        tc.addClients(new Client("Roman", "Kryvobok", "male", "Odessa"));
        tc.addClients(new Client("Ivan", "Rudnik", "male", "Kiev"));
        tc.addClients(new Client("Olia", "Bukina", "famale", "Odessa"));
        tc.addClients(new Client("Kamila", "Reznichenko", "famale", "Poltava"));
        tc.addClients(new Client("Vladislav", "Bozhenko", "male", "Lviv"));

        tc.closeConnection();

        TableOfProducts tp = new TableOfProducts();
        tp.start();

        tp.addPhoneInTable(new Phone("Iphone", 956.56, "100 gramm", "XS"));
        tp.addPhoneInTable(new Phone("Sumsung", 563.48, "150 gramm", "Galaxy Note 10 Lite"));
        tp.addPhoneInTable(new Phone("Nokia", 256.00, "500 gramm", "1100"));
        tp.addPhoneInTable(new Phone("Huawei", 841.01, "50 gramm", "P Smart Z"));

        tp.addTableInTable(new Table("Computer desk", 564.20, "25 kg", "TRL-22", "Pine"));
        tp.addTableInTable(new Table("Work table", 1000.00, "125 kg", "JHF-1", "Oak"));
        tp.addTableInTable(new Table("Table for sex", 648.30, "50 kg", "KI-00", "Linden"));
        tp.addTableInTable(new Table("Teacher`s desk", 200.50, "35 kg", "OP-OO", "DSP"));

        tp.addClothesInTable(new Clothes("Shirt", 25.33, "150 gramm", "Versachi", "Cotton"));
        tp.addClothesInTable(new Clothes("Pants", 50.66, "10 gramm", "Goodini", "Cotton"));
        tp.addClothesInTable(new Clothes("Undershirt", 13.10, "50 gramm", "Turkey", "Synthetics"));
        tp.addClothesInTable(new Clothes("Gloves", 132.98, "10 gramm", "Vietnam", "Snsulated cotton"));

        tp.closeConnection();

        TableOfOrders to = new TableOfOrders();
        to.start();

        to.createOrderOfClient(1, 10005, 2);
        to.createOrderOfClient(1, 10000, 25);
        to.createOrderOfClient(1, 10007, 3);
        to.createOrderOfClient(2, 10007, 4);
        to.createOrderOfClient(5, 10011, 1);
        to.createOrderOfClient(5, 10004, 2);
        to.createOrderOfClient(2, 10008, 33);
        to.createOrderOfClient(2, 10009, 6);
        to.createOrderOfClient(3, 10010, 8);
        to.createOrderOfClient(1, 10007, 3);
        to.createOrderOfClient(3, 10002, 1);
        to.createOrderOfClient(2, 10002, 2);
        to.createOrderOfClient(4, 10000, 9);
        to.createOrderOfClient(4, 10000, 66);
        to.createOrderOfClient(2, 10001, 1);
        to.createOrderOfClient(4, 10001, 1);
        to.createOrderOfClient(5, 10003, 30);
        to.createOrderOfClient(5, 10007, 20);
        to.createOrderOfClient(2, 10006, 3);
        to.createOrderOfClient(3, 10005, 3);

        to.closeConnection();

    }

}
