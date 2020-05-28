package com.blade.practice.designpattern.adapter.classdiagramexample;

import java.util.Map;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/25 13:11
 */
public class OuterUserInfo extends OuterUser implements IUserInfo {

    private Map baseInfo = super.getUserBaseInfo();
    private Map homeInfo = super.getUserHomeInfo();
    private Map officeInfo = super.getUserOfficeInfo();

    @Override
    public String getUserName() {
        String userName = (String)baseInfo.get("userName");
        System.out.println(userName);
        return userName;
    }

    @Override
    public String getHomeAddress() {
        String homeAddress = (String)homeInfo.get("homeAddress");
        System.out.println(homeAddress);
        return homeAddress;
    }

    @Override
    public String getMobileNumber() {
        String mobileNumber = (String)baseInfo.get("mobileNumber");
        System.out.println(mobileNumber);
        return mobileNumber;
    }

    @Override
    public String getOfficeTelNumber() {
        String officeTelNumber = (String)officeInfo.get("officeTelNumber");
        System.out.println(officeTelNumber);
        return officeTelNumber;
    }

    @Override
    public String getJobPosition() {
        String jobPosition = (String)officeInfo.get("jobPosition");
        System.out.println(jobPosition);
        return jobPosition;
    }

    @Override
    public String getHomeTelNumber() {
        String homeTelNumber = (String)homeInfo.get("homeTelNumber");
        System.out.println(homeTelNumber);
        return homeTelNumber;
    }
}
