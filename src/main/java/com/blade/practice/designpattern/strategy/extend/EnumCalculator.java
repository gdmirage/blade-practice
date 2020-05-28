package com.blade.practice.designpattern.strategy.extend;

/**
 * TODO:
 *
 * @author Blade
 * @date 2019/3/28 14:21
 */
public enum EnumCalculator {
    ADD("+") {
        public int exec(int a, int b) {
            return a + b;
        }
    },
    SUB("-") {
        public int exec(int a, int b) {
            return a - b;
        }
    };

    String value = "";
    private EnumCalculator(String value) {
        this.value = value;
    }

    public String getValue() {
        return this.value;
    }

    public abstract int exec(int a, int b);
}
