package com.blade.practice.designpattern.proxy.advice;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/4/12 11:56
 */
public class ABeforeAdvice implements AIAdvice {
    @Override
    public void exec() {
        System.out.println("exec before advice");
    }
}
