package by.bsuir.semenchik.view.action;

import by.bsuir.semenchik.logic.dao.impl.Catalog;
import by.bsuir.semenchik.logic.dao.impl.UserList;
import by.bsuir.semenchik.logic.entity.Admin;
import by.bsuir.semenchik.logic.entity.Book;
import by.bsuir.semenchik.logic.entity.User;

public class Runner {

    public static void main(String args[]) {

        Catalog catalog = Catalog.getInstance();
        UserList users = UserList.getInstance();

        Book book1 = new Book("first", "Richard", "paper");
        Book book2 = new Book("second", "Janie", "e-book");
        Book book3 = new Book("first", "Richard", "e-book");
        Book book4 = new Book("forth", "John", "e-book");

        Admin admin = new Admin("admin", "admin", "admin", "some@mail.ru");
  //      User user = new User("user1", "user1", "user1", "polya_131@mail.ru");

        admin.addBook(book1);
        admin.addBook(book2);
        admin.addBook(book3);

        User user = new User("user1", "user1", "user1", "polya_131@mail.ru");

        admin.addBook(book4);

        System.out.println(admin.showCatalog());
        System.out.println(user.searchBookByTitle("second").toString());

        admin.removeBook(admin.searchBookByTitle("second"));
        System.out.println(user.getBookInfo(user.searchBookByTitle("second1")));

    }

}
