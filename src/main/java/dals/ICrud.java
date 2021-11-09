package dals;

import domains.Book;

import java.util.ArrayList;

public interface ICrud<T> {
    public ArrayList<T> getListBook();

    public boolean deleteById(int id);

    public boolean add(T obj);

    public boolean update(T obj);
}
