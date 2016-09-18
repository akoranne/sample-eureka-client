package com.sngular.demo.consumer;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@Accessors(chain=true)
public class User {

	private String id;
	private String userName;
	private String email;
}
