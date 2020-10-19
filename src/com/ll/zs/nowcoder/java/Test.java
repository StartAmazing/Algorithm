package com.ll.zs.nowcoder.java;

public class Test {
//    public static Test t1 = new Test();
//    {
//        System.out.println("blockA");
//    }
//    static {
//        System.out.println("blockB");
//    }

//    public static class A{
//        static{
//            System.out.println("Static A!");
//        }
//        public A(){
//            System.out.println("A的构造方法");
//        }
//        {
//            System.out.println("A!");
//
//        }
//
//        public void f(){
//            System.out.println("A的方法！");
//        }
//    }
//
//    public static class B extends A{
//        static{
//            System.out.println("static B!");
//        }
//        {
//            System.out.println("B");
//        }
//        public B(){
//            System.out.println("B的构造方法");
//        }
//
//        public void f(){
//            System.out.println("B的方法！");
//        }
//    }

    public static void main(String[] args) {
        //Test t2 = new Test();
//        HashMap<String, String> hashMap = new HashMap<>();
//        hashMap.put(null,null);
//        hashMap.put(null,null);
//        hashMap.put(null,null);
//        hashMap.put("1",null);
//        System.out.println(hashMap.size());
//
//        HashSet<Integer> hashSet = new HashSet<>();
//        hashSet.add(null);
//        hashSet.add(null);
//        hashSet.add(10);
//        System.out.println(hashSet.size());
//
//        HashTable<String,String> hashTable = new HashTable<>();
////        hashTable.add(null,null);     //会抛出异常
//        hashTable.add("null",null);
////        hashTable.add(null,null);
////        hashTable.add(null,"hello world");
//        System.out.println(hashTable.getSize());

//        byte a = 10,b = 3;
//        final byte c = 4 , d = 5;
//        final byte e = c + d;
//        byte f = c + d;
//        byte h = c + a;  //错误
//        System.out.println(a+c);
//        System.out.println(c+d);

        byte x = 127;
        byte y = 1;
////        byte z = ((byte)x + y); //错误
//        byte z = (byte)((byte)x + y);
//        System.out.println(z);  // -128

//        short s1 = 1;
//        s1 = (short)(s1 + 1);
////        s1 = s1 + 1;    //错误
//
//        s1 += 1;    //正确
//        System.out.println(s1);

//        A a = new B();
////        a.f();    --->调用的是B类中f()

//        String s = "123";
//        String ss = "123";
//
//        System.out.println(s==ss);      //true
//        System.out.println(s.equals(ss));   //true
//
//        int a = 1;
//        byte b = 1;
//        float c = 1.0f;
//        String sss = "1";
//        System.out.println(a == b);   //true
//        System.out.println(a == c);     //true
//        System.out.println(sss.equals(a));  //false
//
//        String s1 = new String("123");
//        String s2 = new String("123");
//        System.out.println(s1 == s2);   //false
//        System.out.println(s1.equals(s2));  //true
//        System.out.println(s1 == s);    // false
//        System.out.println(s1.equals(s));   //true
//        char[] arr = {'1','2','3'};
//        String s3 = new String(arr);
//        System.out.println(s3 == s);    //false
//        System.out.println(s3.equals(s));   //true

        String s = "123";
        String s1 = new String("123");

        System.out.println(s == s1);    //false
        System.out.println(s.equals(s1)); //true
        System.out.println(s.hashCode() == s1.hashCode());  //true
    }


}

interface A{

    public static int a = 100;
//    static final a1;    //错误
//    protected static int b =10;     //错误
    default void hello(){}; //一定要有函数体
    abstract void hello1();      //没有函数体

//    private int c = 1;  //错误
    public int b = 3;
//    default  int d = 1; //错误
}

abstract class B{
    public static void f(){}
//    public abstract static  void m(){}    //错误
    public void a(){};
    void b(){};
    protected void c(){};
    private void d(){};

    public static int x = 100;
    int b = 12;
    protected int c = 1;
    private int d = 10;

    public B(){}
//    public abstract B(){}   //错误
//    abstract static void ff(){} //错误
//    abstract native void ff1(){}    //错误
//    abstract synchronized void ff2(){}  //错误

}
