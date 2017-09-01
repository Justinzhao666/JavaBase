/*
 * Copyright (c) 2017/8/31 by zhaohaoren
 * Welcome to visit my site:
 *  
 *  www.zhaohaoren.top
 *
 * @ Project: JavaCode
 * @ Lan: Java
 * @ author zhaohaoren
 * @ version 1.0 
 * ExceptionDem Create on 2017/8/31
 */
package top.zhaohaoren.exception;

/**
 * 异常
 * <p>
 * 最高父类 Throwable
 * 下一层: Error Exception
 * 下一层：RuntimeException 和非RuntimeException： 编译时异常，运行时异常
 * <p>
 * 两种处理方式：
 * 1.（捕获异常）自己处理 try-catch
 * 2.（抛出异常）交给上一级处理，没人接受最终会交给JVM ---我们编写代码的时候应该尽量使用这个，因为将自己当做类库开发者来想。 throw(s)
 *
 * 自己抛出异常： throw 和 throws
 *
 * 继承中的异常：
 * 1、子类重写父类的方法时候，子类方法必须抛出相同的异常或者父类异常的子类（不然交给父级处理，父级处理不了）。
 * 2、如果父类抛出多个异常，子类重写父类时候，只能抛相同异常或者父类的异常的子集（将来抛给父类，父类要能处理）。
 * 3、父类没有抛出异常，子类也不能抛出异常，只能自己捕获处理异常
 */
public class ExceptionDemo {
    public static void main(String[] args) {

        try {

            /** 这里面代码执行出现问题了会生成一个对应异常的对象，会被catch的ex接受  */

        } catch (ArithmeticException | ArrayIndexOutOfBoundsException ex) {

            /** jdk7 特性：处理多个异常 --- |或，可以将多个catch块整合在一起，但是实际中直接用Exception全部接受就ok了 */

        } catch (Exception ex) {
            /** 多个catch小的放在前面，大的放在后面，否则会报错：Python则不会，Python只会忽略不处理 */

            return;

        } finally {
            //finally的语句一定会执行（不管有没有异常）！

            /* 在以下4种特殊情况下，finally块不会被执行：
            1）在finally语句块中发生了异常。
            2）在前面的代码中用了System.exit()退出程序。
            3）程序所在的线程死亡。
            4）关闭CPU。
            */
            // 作用： 最好只用于释放资源，比如IO和数据库资源
        }


        testFinally();
    }

    //: throw 和 throws

    /**
     * throw ：后面接异常对象，在方法体中主动throw抛出异常
     *
     * throws ：后面接异常类型，方法体中只要有抛出异常自己不处理的，就一定要加上这个，相当于对方法申明：调用我这方法的时候必须处理异常
     **/
    public void throwException(Integer integer) throws Exception {

        if (integer > 10) {
            throw new Exception("数字不能大于10");
        }

    }


    // try catch中的 先执行return 后执行finally ，但是return的时候回先保存现场，finally的语句不会影响return的结果
    public static void testFinally() {
        try {
            Integer i = 10 / 0; // 当发生异常时候转到catch异常处理，不会执行return以及后面的内容
            return;
        } catch (Exception e) {
            System.out.println(e.getMessage());
            // catch会在自己真正的return之前检查是否有finally。如果有finally就会先去执行finally然后return！
            // ---先执行return保存现场！然后去执行finally，然后还原return现场返回。
            return;
        } finally {
            System.out.println("执行了finally");
            // 只要前面没有System.exit(0)退出虚拟机，其他都会执行该语句段

            // return; 不要在finally里面写return；因为他会将try或者catch的return给覆盖了！
        }

    }

}
