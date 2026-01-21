package com.prem.jdbc.controller;

import com.prem.jdbc.UserMainApp;
import com.prem.jdbc.model.User;
import com.prem.jdbc.service.UserService;
import com.prem.jdbc.service.UserServiceImpl;

import java.util.List;
import java.util.Scanner;

//this is user controller . this is for learning purpose
public class UserController {

    public static void main(String[] args) {

        UserService userService = new UserServiceImpl();
        UserMainApp form = new UserMainApp();
        Scanner sc = new Scanner(System.in);
        String decision = "";
        do {
            System.out.println("Enter save|update|delete|list|get");
            String choice = sc.next();
            switch (choice) {
                case "save":
                    User user = form.getUserInfo("save");
                    int saved = userService.saveUserInfo(user);
                    if (saved > 0) {
                        System.out.println("user info saved successfully!!!");
                    } else {
                        System.out.println("Error while saving in DB!!!");
                    }
                    break;
                case "update":
                    User updateUser = form.getUserInfo("update");
                    int updated = userService.updateUserInfo(updateUser);
                    if (updated > 0) {
                        System.out.println("user info updated successfully!!!");
                    } else {
                        System.out.println("Error while updating in DB!!!");
                    }
                    break;

                case "delete":
                    System.out.println("Enter id to delete: ");
                    int id = sc.nextInt();
                    int deleted = userService.deleteUserInfo(id);
                    if (deleted > 0) {
                        System.out.println("user info deleted successfully!!!");
                    } else {
                        System.out.println("Error while deleting in DB!!!");
                    }
                    break;
                case "list":
                    List<User> users = userService.listUser();
                    for (User u : users) {
                        form.displayUserInfo(u);
                    }
                    break;
                case "get":
                    System.out.println("Enter id to get: ");
                    int userId = sc.nextInt();
                    User usr = userService.getUserById(userId);
                    form.displayUserInfo(usr);
                    break;
                default:
                    System.out.println("Wrong Selection!!!");
                    break;
            }
            System.out.println("do you want to continue, press yes|no");
            decision = sc.next();
        } while (decision.equalsIgnoreCase("Yes"));
        System.out.println("See you!!!Bye.");
    }


}
