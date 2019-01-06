package by.bsuir.semenchik.logic.entity;

import by.bsuir.semenchik.logic.dao.impl.Catalog;

public class Admin extends User {

    public Admin(String login, String password, String name, String email){
        super(login, password, name, email);
        role = "admin";
    }

    public void addBook(Book book){
        Catalog.getInstance().save(book);
    }

    public void removeBook(Book book){
        Catalog.getInstance().delete(book);
    }

}
