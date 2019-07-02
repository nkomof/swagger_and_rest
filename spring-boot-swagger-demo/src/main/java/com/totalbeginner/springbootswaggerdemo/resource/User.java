package com.totalbeginner.springbootswaggerdemo.resource;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@EqualsAndHashCode
@Builder
public class User {
	@Getter @Setter
	private String userName;
	@Getter @Setter
	private Long salary;
}
