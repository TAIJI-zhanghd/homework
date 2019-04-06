package com.zhd.bean;
/**
 * user实体
 */
import java.util.Date;

import javax.validation.constraints.Max;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;

import org.hibernate.validator.constraints.Email;
import org.hibernate.validator.constraints.NotEmpty;
import org.springframework.format.annotation.DateTimeFormat;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
public class User {

	@NotEmpty
//	@Pattern(regexp = "[\\u4E00-\\u9FA0]")  //只能是中文
	private String name;
	@NotEmpty
	private String pwd;
	@NotNull
	@Max(100)
	@Min(1)
	private Integer age;
	@Past //验证是否在当前时间之后
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date birth;
	@NotNull
	private boolean gender;
	@Email
	private String email;
}
