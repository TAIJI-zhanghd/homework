import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class MainTest {
	
	public static final Logger logger = LoggerFactory.getLogger(MainTest.class);

	
	public static void main(String[] args) {
		
		
		AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
		
		context.scan("com.zhd");
		context.refresh();
		context.registerShutdownHook();
		
		int count = context.getBeanDefinitionCount();
//		System.out.println("bean的个数"+count);
		logger.info("bean的个数"+count);
		
		String[] names = context.getBeanDefinitionNames();
		for (String name : names) {
//			System.out.print(name+"----->");
//			System.out.println(context.getBean(name));
			logger.info(name+"----->");
			logger.info((String) context.getBean(name));
		}
	}
}
