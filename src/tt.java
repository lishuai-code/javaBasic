import java.lang.reflect.Array;
import java.util.*;

public class tt {

    public static void main(String[] args) {

        Hungry hungry = Hungry.get();
        System.out.println(hungry);
        hungry= null;
        System.out.println(hungry);
    }


    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        double result = 0;
        ArrayList<Integer> numbers = new ArrayList<>();
        for (int i :
                nums1) {
            numbers.add(i);
        }
        for (int j :
                nums2) {
            numbers.add(j);
        }
        numbers.sort((Integer a, Integer b) -> a - b);

        int middle = numbers.size() / 2;
        if(numbers.size() / 2 == 0){
            result =  ( numbers.get(middle - 1) + numbers.get(middle) ) / 2;
            System.out.println();
        }
        else {
            result =  numbers.get(middle);
        }
        return result;
    }

}

//单例懒汉式：
class Lazy{
    //私有化类的构造器
    private Lazy() {
    }
    private static Lazy lazy = null;
    public static Lazy get(){
    if (lazy == null) {
        lazy = new Lazy();
    }
    return lazy;
    }
}

//懒汉式:存在线程安全问题，需要加上同步机制synchronized
 /*
 public class Single {
     private static Single instance=null;
     private Single() {}
     public static synchronized Single getInstance() {
         if(instance==null) {
             instance=new Single();
         }
         return instance;
     }
 }
 */

//懒汉式:存在线程安全问题，需要加上同步机制synchronized
 /*
 class Single {
     private static Single instance=null;
     private Single() {}
     public static Single getInstance() {
     if(instance==null) {
         synchronized(Single.class){
             if(instance==null) {  //如果这里不再加一次判断，第一个线程同步代码块执行完之后，第二个线程执行这里instance就会再一次被实例化
                 instance=new Single();
             }
         }
     }
         return instance;
     }
 }
 */

//1、单例类只能有一个实例。
//2、单例类必须自己创建自己的唯一实例。
//3、单例类必须给所有其他对象提供这一实例。
//单例饿汉式
class Hungry{

    //直接在这里创建类实例，只会创建一次，切避免这个实例被外部调用修改，加上private限制
    private static Hungry hungry = new Hungry();

    //私有化构造方法，好在内部控制创建实例的数目
    private Hungry(){}

    //由于是单例模式，不能被外部实例化，所以只能通过类方法来访问，也就是static修饰（public修饰，给外部访问权限）
    //由于方法已经被static修饰，所以里面的成员也必须要static修饰
    public static Hungry get(){
        return hungry;
    }


}
