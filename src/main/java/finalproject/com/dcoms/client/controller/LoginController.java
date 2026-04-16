/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.client.controller;

import finalproject.com.dcoms.client.view.LoginFrame;
import finalproject.com.dcoms.remote.HRMService;

/**
 *
 * @author zaku
 */
public class LoginController {
    private HRMService service;
    private LoginFrame loginScreen;
    private String username;
    private String password;

    public LoginController(HRMService service) {
        this.service = service;
        // this.loginScreen = loginScreen;
    }

    public void login(String username, String password) {
        System.out.println("DEBUG: tryna login wit:" + username + password);

        // try {
        // if (service.getUserByUsername(username) != null) {
        // System.out.println("DEBUG: found something!");
        // }
        // } catch (Exception e) {
        // System.out.println("Failed to load user: " + e.getMessage());
        // }
        try {
            if (service.login(username, password) != null) {
                System.out.println("yipeee login is cool");
            } else {
                System.out.println("login is wrong??");
            }
        } catch (Exception e) {
            System.out.println(e + "error while logging in");
        }

    }

}
