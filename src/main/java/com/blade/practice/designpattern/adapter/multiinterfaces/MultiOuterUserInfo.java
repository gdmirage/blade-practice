package com.blade.practice.designpattern.adapter.multiinterfaces;

import com.blade.practice.designpattern.adapter.classdiagramexample.IUserInfo;
import com.blade.practice.designpattern.adapter.classdiagramexample.UserInfo;

import java.util.Map;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/27 17:13
 */
public class MultiOuterUserInfo implements IUserInfo {

    private IOuterBaseInfo outerBaseInfo = null;
    private IOuterUserHomeInfo outerUserHomeInfo = null;
    private IOuterUserOfficeInfo outerUserOfficeInfo = null;

    private Map baseInfo = null;
    private Map homeInfo = null;
    private Map officeInfo = null;

    public MultiOuterUserInfo(IOuterBaseInfo outerBaseInfo, IOuterUserHomeInfo outerUserHomeInfo,
                              IOuterUserOfficeInfo outerUserOfficeInfo) {
        this.outerBaseInfo = outerBaseInfo;
        this.outerUserHomeInfo = outerUserHomeInfo;
        this.outerUserOfficeInfo = outerUserOfficeInfo;

        this.baseInfo = outerBaseInfo.getUserBaseInfo();
        this.homeInfo = outerUserHomeInfo.getUserHomeInfo();
        this.officeInfo = outerUserOfficeInfo.getUserOfficeInfo();
    }

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
