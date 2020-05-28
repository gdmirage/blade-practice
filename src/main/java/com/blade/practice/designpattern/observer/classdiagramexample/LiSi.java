package com.blade.practice.designpattern.observer.classdiagramexample;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/29 8:53
 */
public class LiSi implements ILiSi {
    @Override
    public void update(String context) {
        System.out.println("李斯: 观察到韩非子活动，开始向老板汇报....");
        this.reportToQinShiHuang(context);
        System.out.println("李斯: 汇报完毕...\n");
    }

    private void reportToQinShiHuang(String reportContext) {
        System.out.println("李斯: 报告秦老板！韩非子有活动了--->" + reportContext);
    }
}
