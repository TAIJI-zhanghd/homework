package com;
/**
 * 测试 运行 不在springboot入口下的包
 */
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class PackageController {

	@RequestMapping("/p")
	public String pack() {
		return "Pack";
	}
}
