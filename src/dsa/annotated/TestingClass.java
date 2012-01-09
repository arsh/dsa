package dsa.annotated;
import java.lang.reflect.Method;

/**
 * This is the class I use to build the test cases. This will basically call all the method which name starts with "test". This class also enables assertions programatically.
 * 
 * @author asantana
 * 
 */
public class TestingClass {
	static {
		ClassLoader.getSystemClassLoader().setDefaultAssertionStatus(true);
	}

	public void runAllTest() {
		Method[] methods = this.getClass().getDeclaredMethods();
		for (Method m : methods) {
			if (m.getName().startsWith("test")) {
				try {
					m.invoke(this);
					System.out.println(m.getName() + "():" + "succeeded.");
				} catch (Exception ex) {
					System.out.println(m.getName() + "():" + "failed.");
					ex.getCause().printStackTrace();
				}
			}
		}

	}
}
