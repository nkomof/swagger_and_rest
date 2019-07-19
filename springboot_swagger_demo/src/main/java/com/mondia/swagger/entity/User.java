package com.mondia.swagger.entity;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@EqualsAndHashCode
@AllArgsConstructor
@NoArgsConstructor
@Builder
@Getter @Setter
@Document
@ApiModel(description = "User")
public class User {

    @ApiModelProperty(dataType = "String", value = "Name of the user")
	private String userName;

    @ApiModelProperty(dataType = "Long", value = "Salary of the user")
	private Long salary;

    @Id
    @ApiModelProperty(dataType = "Integer", value = "Id of the user")
	private Integer id;
}
