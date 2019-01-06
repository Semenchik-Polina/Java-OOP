package by.bsuir.semenchik.logic.entity;

import by.bsuir.semenchik.logic.dao.impl.Catalog;
import by.bsuir.semenchik.logic.dao.impl.UserList;

public class User {

    private String login;
    private String password;
    public String name;
    public String email;
    public String role = "";

    public String getLogin() {
        return login;
    }

    public String getPassword() {
        return password;
    }

    public User(String login, String password, String name, String email) {
        if (login != "" && password != "" && name != "") {
            this.login = login;
            this.password = password;
            this.name = name;
            this.email = email;
            UserList.getInstance().save(this);
        }
    }

    public Book searchBookByTitle(String title) {
        return Catalog.getInstance().get(title);
    }

    public String getBookInfo(Book book) {
        if (book != null) {
            return book.toString();
        } else {
            return "No result found";
        }
    }

    public String showCatalog() {
        return Catalog.getInstance().booksToString();
    }

    @Override
    public String toString() {
        StringBuilder builder = new StringBuilder();
        builder.append(login).append(" ");
        builder.append(password.hashCode()).append(" ");
        builder.append(name).append(" ");
        builder.append(role);
        return builder.toString();
    }
}
