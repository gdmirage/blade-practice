package com.blade.practice.designpattern.adapter.classdiagramexample;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/25 12:51
 */
public class OuterUser implements IOuterUser {
    @Override
    public Map getUserBaseInfo() {
        HashMap baseInfoMap = new HashMap(4);
        baseInfoMap.put("userName", "xiao ming");
        baseInfoMap.put("mobileNumber", "mobile number is 123456");
        return baseInfoMap;
    }

    @Override
    public Map getUserOfficeInfo() {
        HashMap officeInfoMap = new HashMap(4);
        officeInfoMap.put("jobPosition", "leader");
        officeInfoMap.put("officeTelNumber", "office number is 888888");
        return officeInfoMap;
    }

    @Override
    public Map getUserHomeInfo() {
        HashMap homeInfoMap = new HashMap(4);
        homeInfoMap.put("homeTelNumber", "home number is 777777");
        homeInfoMap.put("homeAddress", "home address is china");
        return homeInfoMap;
    }
}
