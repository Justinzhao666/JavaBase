package top.zhaohaoren.枚举类;

/**
 * JDK的枚举类
 *
 *
 *
 *
 *
 *
 * Created by zhaohaoren on 2017/9/5.
 */

/** 基本的枚举类，有几个变量代表里面有内置了几个对象 **/
enum JDKEnum1 {
    MON,TUE,WED
}

/** 枚举中使用私有构造函数，使得枚举类内置对象有自己的值 **/
enum JDKEnum2{
    Mon("1"),TUE("2"),WED("3");  /// 必须要加上封号！前面那种可以不加

    private String name;

    // 枚举类可以有构造器，但必须为私有的，因为枚举本身就是固定的有限个对象，所以不能让他new对象出来
    private JDKEnum2(String name){
        this.name = name;
    }
}

/** 枚举中使用抽象方法 **/
enum JDKEnum3{
    MON("1"){
        @Override
        public void show() {
            System.out.println(super.name);
        }
    },TUE("2"){
        @Override
        public void show() {
            System.out.println(super.name);
        }
    },WED("3"){
        @Override
        public void show() {
            System.out.println(super.name);
        }
    };

    private String name;

    private JDKEnum3(String name){
        this.name = name;
    }

    public abstract void show();

}
