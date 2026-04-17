/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package finalproject.com.dcoms.client.controller;

import finalproject.com.dcoms.client.ClientApp;
import finalproject.com.dcoms.client.model.User;
import finalproject.com.dcoms.client.view.LoginFrame;
import finalproject.com.dcoms.remote.HRMService;

/**
 *
 * @author zaku
 */
public class LoginController {
    private HRMService service;
    private ClientApp app;
    private LoginFrame loginScreen;
    private String username;
    private String password;

    public LoginController(HRMService service, ClientApp app) {
        this.service = service;
        this.app = app;
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
            String[] userDetails = service.login(username, password);
            if (userDetails != null) {
                System.out.println("yipeee login is cool");
                User user = new User(userDetails[0], userDetails[1], userDetails[2], userDetails[3], userDetails[4],
                        userDetails[5]);
                app.showEmployeeDashboard(user);

            } else {
                System.out.println("login is wrong??");
            }
        } catch (Exception e) {
            System.out.println(e + "error while logging in");
        }

    }

}
