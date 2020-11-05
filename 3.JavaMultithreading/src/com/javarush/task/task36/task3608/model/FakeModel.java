package com.javarush.task.task36.task3608.model;

import com.javarush.task.task36.task3608.bean.User;

import java.util.ArrayList;
import java.util.List;

public class FakeModel implements Model {
    private ModelData modelData = new ModelData();

    @Override
    public ModelData getModelData() {
        return modelData;
    }

    @Override
    public void loadUsers() {
        List<User> users = new ArrayList<>();

        users.add(new User());
        users.add(new User("Jban", 5, 22));
        users.add(new User("R", 2, 17));

        modelData.setUsers(users);
    }

    @Override
    public void loadDeletedUsers() throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void loadUserById(long userId) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void deleteUserById(long id) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }

    @Override
    public void changeUserData(String name, long id, int level) throws UnsupportedOperationException {
        throw new UnsupportedOperationException();
    }
}
