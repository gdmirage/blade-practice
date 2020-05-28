package com.blade.practice.designpattern.observer.classdiagramexample;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/29 8:55
 */
public class Spy extends Thread {

    private HanFeiZi hanFeiZi;
    private LiSi liSi;
    private String type;

    public Spy(HanFeiZi hanFeiZi, LiSi liSi, String type) {
        this.hanFeiZi = hanFeiZi;
        this.liSi = liSi;
        this.type = type;
    }

    @Override
    public void run() {
        while (true) {
//            try {
//                Thread.sleep(500);
//            } catch (InterruptedException e) {
//                e.printStackTrace();
//            }
            if (this.type.equals("breakfast")) {
                if(this.hanFeiZi.isHaveBreakfast()) {
                    this.liSi.update("韩非子正在吃饭");
                    this.hanFeiZi.setHaveBreakfast(false);
                }else {
                    if(this.hanFeiZi.isHaveFun()) {
                        this.liSi.update("韩非子正在娱乐");
                        this.hanFeiZi.setHaveFun(false);
                    }
                }
            }
        }
    }
}
