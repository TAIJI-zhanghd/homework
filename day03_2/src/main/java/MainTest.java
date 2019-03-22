import static org.mockito.Matchers.contains;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {

	
	public static void main(String[] args) {
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.zhd");
		context.refresh();
		context.registerShutdownHook();
		
		int count = context.getBeanDefinitionCount();
		System.out.println("bean的个数"+count);
		
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
			System.out.print(name+"----->");
			System.out.println(context.getBean(name));
		}
	}
}
