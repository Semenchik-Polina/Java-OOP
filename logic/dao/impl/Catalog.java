package by.bsuir.semenchik.logic.dao.impl;

import by.bsuir.semenchik.logic.entity.Book;
import by.bsuir.semenchik.logic.dao.DAO;
import by.bsuir.semenchik.logic.entity.User;
import by.bsuir.semenchik.logic.mail.EmailSender;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Catalog implements DAO<Book> {

    private static Catalog ourInstance = new Catalog();
    private List<Book> books = new ArrayList<Book>();
    private String fileName = "C:\\all you need is\\to study\\vt\\lab2\\src\\by\\bsuir\\semenchik\\data\\books.txt";

    public static Catalog getInstance() {
        return ourInstance;
    }

    private Catalog() {
    }

    private Book getByTitle(String title) {
        for (Book book : books) {
            if (book.getTitle() == title) {
                return book;
            }
        }
        return null;
    }

    public String booksToString() {
        StringBuilder builder = new StringBuilder();
        for (Book book : books) {
            builder.append(book.toString()).append("\r\n");
        }
        return builder.toString();
    }

    private void sendMessage(Book book) {
        EmailSender emailSender = new EmailSender();
        for (User user : UserList.getInstance().getAll()) {
            if (user.role != "admin") {
                emailSender.sendMessage(user.email, book);
            }
        }
    }


    @Override
    public Book get(String title) {
        return getByTitle(title);
        //return Optional.ofNullable(getByTitle(title));
    }

    @Override
    public List<Book> getAll() {
        return books;
    }

    @Override
    public void save(Book book) {
        if (book != null) {
            books.add(book);
            update();
//            sendMessage(book);
        }
    }

    @Override
    public void update() {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (Book book : getAll()) {
                writer.write(book.toString());
                writer.append("\r\n");
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(Book book) {
        if (book != null) {
            books.remove(book);
            update();
        }
    }
}
