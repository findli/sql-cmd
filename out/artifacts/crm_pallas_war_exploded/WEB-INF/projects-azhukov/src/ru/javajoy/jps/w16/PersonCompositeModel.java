package ru.javajoy.jps.w16;

import javax.swing.*;
import java.io.Serializable;
import java.util.List;

/**
 * Created by Artem Zhukov on 2/4/15.
 */
public class PersonCompositeModel implements Serializable {
    private DefaultListModel<String> friendListModel;
    private DefaultListModel<String> personListModel;

    public PersonCompositeModel(List<String> friendList) {
        friendListModel = new DefaultListModel<>();
        personListModel = new DefaultListModel<>();
        addFriends(friendList);
    }

    public void addFriends(List<String> friendList) {
      addData(friendListModel, friendList);
    }

    public void addPersons(List<String> personList) {
      addData(personListModel, personList);
    }

    public void addData(DefaultListModel<String> model, List<String> data) {
        for (String element : data) {
            model.addElement(element);
        }
    }

    public void addFriend(String friend) {
        friendListModel.addElement(friend);
    }

   public void addPerson(String person) {
        personListModel.addElement(person);
    }

    public void removePerson(int selectedIndex) {
        personListModel.remove(selectedIndex);
    }

    public void removeFriend(int selectedIndex) {
        friendListModel.remove(selectedIndex);
    }

    public DefaultListModel<String> getFriendListModel() {
        return friendListModel;
    }

    public DefaultListModel<String> getPersonListModel() {
        return personListModel;
    }

    public String getPersonAt(int selectedIndex) {
        return personListModel.elementAt(selectedIndex);
    }
    public String getFriendAt(int selectedIndex) {
        return friendListModel.getElementAt(selectedIndex);
    }


}
