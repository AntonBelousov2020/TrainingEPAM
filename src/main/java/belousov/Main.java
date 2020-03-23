package belousov;

import belousov.task2.Stack;
import belousov.task3.MyClassLoaderWork;

public class Main {
    public static void main(String[] args) {
        Stack stack = new Stack();
        stack.stackOwerFlow();

        MyClassLoaderWork myClassLoaderWork = new MyClassLoaderWork();
        myClassLoaderWork.myClassLoaderWork();
    }
}
