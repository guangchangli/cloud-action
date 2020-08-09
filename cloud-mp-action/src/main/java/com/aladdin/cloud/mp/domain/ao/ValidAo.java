package com.aladdin.cloud.mp.domain.ao;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

/**
 * @author lgc
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class ValidAo {
    @NotBlank(message = "name 不能为空")
    private String name;

    @NotBlank
    @Email(message = "{valid.mail}")
    private String email;

    @NotNull
    @Min(18)
    @Max(120)
    private int age;

    @NotBlank
    @Length()
    private String address;


}
