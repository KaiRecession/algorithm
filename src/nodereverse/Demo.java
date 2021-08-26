package nodereverse;

public class Demo {

    int[] arrays = {1,2,3,4,5};
    public void test(int[] a,int i){
        int b = 0;
        if(i == a.length-1) {
            return;
        }
        test(a,i+1);
        b = a[i];
        a[i] = a[a.length-i-1];
        a[a.length-i-1] = b;

    }

    public static void main(String[] args) {
        Demo demo = new Demo();
       demo.test(demo.arrays,0);
        for (int array : demo.arrays) {
            System.out.println(array);
        }

        int[] a = {1, 2, 3, 4};
        int[] b = a;
        a[1] = 100;
        for (int i : a) {
            System.out.print(i);
        }

        System.out.println("");
        for (int i : b) {
            System.out.print(i);
        }

        System.out.println("");
        A aa = new A();
        A cc = new A();
        aa.i = 100;
        A bb = aa;
        cc.i = 200;
        aa = cc;
        System.out.println(aa.i);
        System.out.println(bb.i);
        System.out.println(cc.i);
    }
}

class A{
    int i;
}
