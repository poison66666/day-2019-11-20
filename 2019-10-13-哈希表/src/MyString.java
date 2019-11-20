import java.util.ArrayList;
import java.util.List;

public class MyString {
    //利用一个静态属性模拟常量池
    //常量池的作用 1.节省内存空间 2.保证常量池中不会出现重复对象
    private static List<MyString> constPool = new ArrayList<>();//常量池
    public static MyString literal(MyString s){
        int i = constPool.indexOf(s);
        if(i == -1){//未找到，将其引入池
            constPool.add(s);
            return s;
        }
        return constPool.get(i);//找到，直接返回
    }
    public MyString intern(){
        int i = constPool.indexOf(this);
        if(i == -1){
            constPool.add(this);
            return this;
        }
        return constPool.get(i);
    }

    public static void main(String[] args) {
        Integer i = 10000;
        Integer j = 10000;
        System.out.println(i == j);//false   -128----127为true，其余为false
        Integer k = 100;
        Integer l = 100;
        System.out.println(k == l);//true

        String s = "hello";
        String t = s.concat("world");
        String p = s + "world";//三个为各自不同的属性,各不相同
        System.out.println(s == t);
        System.out.println(s == p);
        System.out.println(p == t);

        StringBuilder sb = new StringBuilder();
        StringBuffer sb2 = new StringBuffer();
        for(int w = 0;w<10;w++){
            sb.append(w);
        }
        String r = sb.toString();
        System.out.println(sb);

        String a = "";
        for(int q = 0;q < 10;q++){
            a += String.valueOf(q);
        }
        System.out.println(a);
    }
}
