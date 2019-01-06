package by.bsuir.semenchik.logic.dao.impl;

import by.bsuir.semenchik.logic.dao.DAO;
import by.bsuir.semenchik.logic.entity.User;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class UserList implements DAO<User> {

    private static UserList ourInstance = new UserList();
    private List<User> users = new ArrayList<User>();
    private String fileName = "C:\\all you need is\\to study\\vt\\lab2\\src\\by\\bsuir\\semenchik\\data\\users.txt";

    public static UserList getInstance() {
        return ourInstance;
    }

    private UserList() {
    }

    private User getByName(String name) {
        for (User user : users) {
            if (user.name == name) {
                return user;
            }
        }
        return null;
    }

    @Override
    public User get(String name) {
        return getByName(name);
    //    return Optional.ofNullable(getByName(name));
    }

    @Override
    public List<User> getAll() {
        return users;
    }

    @Override
    public void save(User user) {
        if (user != null) {
            users.add(user);
            update();
        }
    }

    @Override
    public void update() {
        try (FileWriter writer = new FileWriter(fileName, false)) {
            for (User user : getAll()) {
                writer.write(user.toString());
                writer.append("\r\n");
            }
            writer.flush();
        } catch (IOException ex) {
            System.out.println(ex.getMessage());
        }
    }

    @Override
    public void delete(User user) {
        if (user != null) {
            users.remove(user);
            update();
        }
    }
}
