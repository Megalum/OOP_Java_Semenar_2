package service;
import data.User;

public interface DataService {
    void create(User user, String fileName);
    User read(String fileName);
}
