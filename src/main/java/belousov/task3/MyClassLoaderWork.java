package belousov.task3;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class MyClassLoaderWork {

    /**
     * This method realise main logic. In this method calling methods load for compile class. Byte code located an other
     * directory compared with project directory
     */
    public void myClassLoaderWork() {
        MyClassLoader classLoader = new MyClassLoader("C:\\Users\\Anton\\Desktop\\myClasses\\");
        Class<?> clazz;
        try {
            clazz = classLoader.loadClass("TestClass");
            log.info("Loaded " + clazz.getName() + ".class");
            Object obj = clazz.newInstance();
            System.out.println(obj);
        } catch (ClassNotFoundException | IllegalAccessException | InstantiationException e) {
            log.error(e.getMessage());
        }
    }
}
