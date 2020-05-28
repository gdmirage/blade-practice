package com.blade.practice.designpattern.adapter;

import com.blade.practice.designpattern.adapter.classdiagram.Adapter;
import com.blade.practice.designpattern.adapter.classdiagram.ConcreteTarget;
import com.blade.practice.designpattern.adapter.classdiagram.Target;
import com.blade.practice.designpattern.adapter.classdiagramexample.IUserInfo;
import com.blade.practice.designpattern.adapter.classdiagramexample.OuterUserInfo;
import com.blade.practice.designpattern.adapter.classdiagramexample.UserInfo;
import com.blade.practice.designpattern.adapter.multiinterfaces.MultiOuterUserInfo;
import com.blade.practice.designpattern.adapter.multiinterfaces.OuterBaseInfo;
import com.blade.practice.designpattern.adapter.multiinterfaces.OuterUserHomeInfo;
import com.blade.practice.designpattern.adapter.multiinterfaces.OuterUserOfficeInfo;

/**
 * TODO:
 * 适配器模式测试类
 * @author Blade
 * @date 2019/3/24 20:09
 */
public class AdapterTest {

    public static void main(String[] args) {
//        classDiagramTest();
//        classDiagramExampleTest();
        multiInterfacesTest();
    }

    /**
     * 适配器模式通用UML代码
     */
    private static void classDiagramTest() {
        // 原有的业务逻辑
        Target target = new ConcreteTarget();
        target.request();

        // 现在增加了适配器角色后的业务逻辑
        Target target1 = new Adapter();
        target1.request();
    }

    /**
     * 系统原来已经有UserInfo这个接口。后续需要调用别的系统的接口，所以，增加OuterUserInfo进行适配
     */
    private static void classDiagramExampleTest() {
        // 查看原来的系统中的用户
        IUserInfo userInfo = new UserInfo();
        userInfo.getUserName();

        IUserInfo userInfo1 = new OuterUserInfo();
        userInfo1.getUserName();
    }

    private static void multiInterfacesTest() {
        IUserInfo userInfo = new UserInfo();
        userInfo.getUserName();

        IUserInfo multi = new MultiOuterUserInfo(new OuterBaseInfo(), new OuterUserHomeInfo(),
                new OuterUserOfficeInfo());
        multi.getUserName();
    }
}
