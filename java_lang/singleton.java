/*
 * singleton pattern says that - define a class that has only one instance and provides a global point of access to it
 * a class must ensure that only a single instance should be created and single object can be used by all other classes
 * 
 * two types of singleton design pattern - 
 * early initialization: creation of instance at load time
 * lazy initialization: creation of instance when required
 *
 * Advantage: saves memory as object is not created at each request
 *
 * Uses: mostly used in multi-threaded and database applications. It is used in logging, caching, thread pools, configuration settings etc.
 *
 * components: a static member, private constructor & static factory method
 */

public class Singleton {
    private static Singleton obj;
    private Singleton(){

    }

    public static Singleton getObj() {
        if(obj == null) {
            synchronized(Singleton.class) {
                if(obj == null) {
                    obj = new Singleton();
                }
            }
        }
        return obj;
    }
}
