package com.blade.practice.designpattern.adapter.classdiagramexample;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/25 12:27
 */
public class UserInfo implements IUserInfo {

    @Override
    public String getUserName() {
        System.out.println("user info get username");
        return null;
    }

    @Override
    public String getHomeAddress() {
        System.out.println("user info get home address");
        return null;
    }

    @Override
    public String getMobileNumber() {
        System.out.println("user info get mobile number");
        return null;
    }

    @Override
    public String getOfficeTelNumber() {
        System.out.println("user info get office tel number");
        return null;
    }

    @Override
    public String getJobPosition() {
        System.out.println("user info get job position");
        return null;
    }

    @Override
    public String getHomeTelNumber() {
        System.out.println("user info get home tel number");
        return null;
    }
}
