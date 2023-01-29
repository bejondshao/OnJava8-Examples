// generics/GenericReadingAndWriting.java
// (c)2021 MindView LLC: see Copyright.txt
// We make no guarantees that this code is fit for any purpose.
// Visit http://OnJava8.com for more book information.

import java.util.ArrayList;
import java.util.List;

class AA {
    public void doSth() {
        System.out.println(this.getClass());
    }
}

class BB extends AA {
    public void doSth() {
        System.out.println("calling BB: " + this.getClass());
    }
}

class CC extends BB {
}

class CC2 extends BB {

}

public class GenericReadingAndWriting {

    public static void doSthInMain(AA a1) {
        a1.doSth();
    }

    public static void doListInMain(List<AA> a1List) {
        for (AA a1 : a1List) {
            a1.doSth();
        }
    }

    public static void doListWildcardExtendsInMain(List<? extends AA> a1List) {
        for (AA a1 : a1List) {
            a1.doSth();
        }
    }

    public static void doListWildcardSuperInMain(List<? super BB> list) {
        list.add(new BB());
        list.add(new CC());
        list.add(new CC2());
        // list.add(new AA()); // this is wrong. because AA can't be upcast to any super class of BB. AA could be an interface,
        // BB can implement many interfaces.
    }

    public static void test() {
        List<AA> listA1 = new ArrayList<>();
        listA1.add(new BB());
        List<? super CC> list1 = new ArrayList<AA>();
        list1.add(new CC());
        List<? extends AA> list2 = new ArrayList<>();
        AA a1 = list2.get(0);
    }

    public static void main(String[] args) {
        doSthInMain(new AA());
        doSthInMain(new BB()); // this is ok, because B1 can be upcast to A1

        List<AA> a1List = new ArrayList<>();
        List<BB> b1List = new ArrayList<>();
        doListInMain(a1List);
        // doListInMain(b1List); // this is not ok, because List<B1> is not List<A1>, they are totally different types
        doListWildcardExtendsInMain(a1List);
        doListWildcardExtendsInMain(b1List); // this is OK, because the wildcard makes it work when we try to read from the list,
        // then we upcast the value to A1

        List<AA> aaList = new ArrayList<>();
        doListWildcardSuperInMain(aaList);
        List<BB> bbList = new ArrayList<>();
        doListWildcardSuperInMain(bbList);
        List<? super BB> list = new ArrayList<>();
        doListWildcardSuperInMain(list);
    }
}
