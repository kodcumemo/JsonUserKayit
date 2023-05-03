package com.odev.KursOdevi.controller;

import com.odev.KursOdevi.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
public class Register {
    ArrayList<User> users = new ArrayList<>();

    public Register() { // deneme veritabanım
        users.add(new User(1, "Nur", "Efsan", "ne@gmail.com", "1111"));
        users.add(new User(6, "Aziz", "Taha", "at@gmail.com", "2222"));
        users.add(new User(11, "Fadime", "Perili", "fp@gmail.com", "3333"));
        users.add(new User(2, "Duygu", "limon", "dl@gmail.com", "1111"));
        users.add(new User(9, "d", "de", "d@gmail.com", "4444"));

        users.add(new User(8, "b", "be", "b@gmail.com", "1111"));
        users.add(new User(3, "c", "ce", "c@gmail.com", "3333"));
        users.add(new User(4, "a", "aa", "a@gmail.com", "2222"));
    }

    @PostMapping("/user")       // yeni üye ekleniyor  // register id numarası otomatik artıyor
    private String user(@RequestBody User user) {
        for (User u: users) {
            if(user.getEmail().equals(u.getEmail())) {
                return "Bu email zaten kayıtlı";
            }
        }

        int id = users.get(0).getId();
        for (int i = 0; i < users.size(); i++) {
            for (int j = 0; j < users.size(); j++) {

                if (id < users.get(j).getId()) {

                    id = users.get(j).getId();
                }
            }
        }
        id++;
        user.setId(id);
        boolean varmi = false;
        for (int i = 0; i < users.size(); i++) {
            if (user.getId() == users.get(i).getId()) {
                varmi = true;
                break;
            }
        }
        if (varmi) {
            return "Bu Kullanıcı Kayıtlı";
        }

        users.add(user);
        return "Kaydedildi";
    }

    @GetMapping("/user")    // listenin tamamı burada yayınlanıyor.
    public ArrayList<User> reg() {
        return users;
    }


    @PostMapping("/login")  // email ve şifre ile giriş yapılıyor
    public User login(@RequestBody User user) {
        User usr = null;
        for (var u : users) {
            if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
                usr = u;
                break;
            } else {
                usr = null;
            }
        }

        if (usr != null) {
            return usr;
        } else {
            System.out.println(users.contains(user));
           // System.out.println(usr.getId() + " " + usr.getEmail() + " " + usr.getPassword());
            return null;
        }
    }

}
/*
 @PostMapping("/login")
    public User login(@RequestBody User user) {
        User usr = null;
        for (var u : users) {
            if (u.getEmail().equals(user.getEmail()) && u.getPassword().equals(user.getPassword())) {
                usr = u;
                break;
            } else {
                usr = null;
            }
        }

        if (usr != null) {
            return usr;
        } else {
            System.out.println(users.contains(user));
           // System.out.println(usr.getId() + " " + usr.getEmail() + " " + usr.getPassword());
            return null;
        }
    }
 */

