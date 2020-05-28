package com.blade.practice.designpattern.adapter.multiinterfaces;

import java.util.HashMap;
import java.util.Map;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/27 16:12
 */
public class OuterUserHomeInfo implements IOuterUserHomeInfo {
    @Override
    public Map getUserHomeInfo() {
        HashMap homeInfoMap = new HashMap(4);
        homeInfoMap.put("homeTelNumber", "home number is 777777");
        homeInfoMap.put("homeAddress", "home address is china");
        return homeInfoMap;
    }
}
