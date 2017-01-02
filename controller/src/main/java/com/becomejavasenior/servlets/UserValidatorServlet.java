package com.becomejavasenior.servlets;

import com.becomejavasenior.Entity.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

@WebServlet(name = "UserValidatorServlet", urlPatterns = "/user-validator")
public class UserValidatorServlet extends HttpServlet {
    private static final Map<String, User> users = getUsers();

    /**
     * Creates valid users
     * <p>
     * This User Map could be users returned from a database
     * or a simple select with the user.name
     *
     * @return a Map of valid users
     */
    private static Map<String, User> getUsers() {
        Map<String, User> users = new HashMap<String, User>();

        User userOne = new User("user1", "password1");
        User userTwo = new User("user2", "password2");

        users.put(userOne.getName(), userOne);
        users.put(userTwo.getName(), userTwo);

        return users;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        RequestDispatcher rd;
        String name = request.getParameter("name");
        String password = request.getParameter("password");

        User user = validateLogin(name, password);

        if (user == null) {
            rd = request.getRequestDispatcher("/loginError.jsp");
        } else {
            HttpSession session = request.getSession();
            session.setAttribute("user", user);
            rd = request.getRequestDispatcher("/loginSuccess.jsp");
        }

        rd.forward(request, response);
    }

    private User validateLogin(String name, String password) {
        // All parameters must be valid
        if (name == null || password == null) {
            return null;
        }

        // Get a user by key
        User user = users.get(name);

        if (user == null) {
            return null;
        }

        // Check if the password is valid
        if (!user.getPassword().equals(password.trim())) {
            return null;
        }

        return user;
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
