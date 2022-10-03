package com.fedag.rcrm.model;

import io.swagger.annotations.ApiModelProperty;
import io.swagger.v3.oas.annotations.media.Schema;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@MappedSuperclass
@Schema(name = "Basic user model", description = "Info about basic model of user")
public abstract class UserModel {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @ApiModelProperty(notes = "Provided user ID", required = true)
    @Schema(description = "User ID",
            example = "1")
    private Long id;

    @Column(name = "first_name")
    @ApiModelProperty(notes = "Provided user firstname", required = true)
    @Schema(description = "User name",
            maxLength = 255,
            minLength = 1,
            example = "someName")
    private String firstName;

    @Column(name = "lastname")
    @ApiModelProperty(notes = "Provided user lastname", required = true)
    @Schema(description = "User lastname",
            maxLength = 255,
            minLength = 1,
            example = "someLastname")
    private String lastname;

}
