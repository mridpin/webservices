package com.udemy.rest.webservicescourse.user;

import com.udemy.rest.webservicescourse.user.exceptions.UserIsNullException;
import com.udemy.rest.webservicescourse.user.exceptions.UserNotFoundException;
import java.util.ArrayList;
import java.util.Date;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;

@Component
public class UserRepository {
    private static List<User> users = new ArrayList<>();
    Integer userCount = 4;

    static {
      users.add(new User(1, "Lion El Johnson", new Date()));
      users.add(new User(3, "Fulgrim", new Date()));
      users.add(new User(4, "Perturabo", new Date()));
    }

    public List<User> findAll() {
      List<User> users = this.users;
      return users;
    }

  public User findById(Integer id) {
    for (User user : users) {
      if (user.getId() == id) {
        return user;
      }
    }
    throw new UserNotFoundException("User " + id + " not found");
  }

  public User createUser(User user) {
    try {
      user.setId(++userCount);
      users.add(user);
      return user;
    } catch (NullPointerException nullp) {
      throw new UserIsNullException("User cannot be empty");
    }
  }

  public User deleteById(Integer id) {
    Iterator<User> userIterator = users.iterator();
    while (userIterator.hasNext()) {
      User user = userIterator.next();
      if (user.getId().equals(id)) {
        userIterator.remove();
        return user;
      }
    }
    throw new UserNotFoundException("User " + id + " not found");
  }

}
