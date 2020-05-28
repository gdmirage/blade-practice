package com.blade.practice.designpattern.adapter.multiinterfaces;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/27 16:49
 */
public class OuterUserOfficeInfo implements IOuterUserOfficeInfo {
    @Override
    public Map getUserOfficeInfo() {
        HashMap officeInfoMap = new HashMap(4);
        officeInfoMap.put("jobPosition", "leader");
        officeInfoMap.put("officeTelNumber", "office number is 888888");
        return officeInfoMap;
    }
}
