package com.blade.practice.designpattern.adapter.multiinterfaces;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/27 15:35
 */
public class OuterBaseInfo implements IOuterBaseInfo {
    @Override
    public Map getUserBaseInfo() {
        HashMap baseInfoMap = new HashMap(4);
        baseInfoMap.put("userName", "xiao ming");
        baseInfoMap.put("mobileNumber", "mobile number is 123456");
        return baseInfoMap;
    }
}
