package com.prem.jdbc;

import com.prem.jdbc.model.User;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

//This is jdbc demo
public class UserMainApp {

    public User getUserInfo(String action) {
        Scanner sc = new Scanner(System.in);
        User user = new User();
        if(action.equalsIgnoreCase("update")){
            System.out.println("Enter id to update: ");
            int id = sc.nextInt();
            user.setId(id);
        }
        System.out.println("Enter username: ");
        String username = sc.next();
        System.out.println("Enter password: ");
        String password = sc.next();
        System.out.println("Enter address: ");
        String address = sc.nextLine();
        sc.nextLine();
        System.out.println("Enter date of birth: ");
        String date = sc.next();
        System.out.println("Enter mobile no: ");
        long mobileNo = sc.nextLong();
        System.out.println("Enter status: ");
        boolean status = sc.nextBoolean();

        user.setUsername(username);
        user.setAddress(address);
        user.setPassword(password);
        user.setMobileNo(mobileNo);
        user.setStatus(status);
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        try {
            Date dob = sdf.parse(date);
            user.setDateOfBirth(dob);
        } catch (ParseException e) {
            throw new RuntimeException(e);
        }
        return user;
    }

    public void displayUserInfo(User user) {
        System.out.println("User Id is: " + user.getId());
        System.out.println("User name is: " + user.getUsername());
        System.out.println("Password is: " + user.getPassword());
        System.out.println("Date of birth is: " + user.getDateOfBirth());
        System.out.println("Address is: " + user.getAddress());
        System.out.println("Mobile No is: " + user.getMobileNo());
        System.out.println("Status is: " + user.isStatus());
        System.out.println("=========================");
    }
}
