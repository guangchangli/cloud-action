package com.aladdin.cloud.mp.domain.ao;

import lombok.*;
import org.hibernate.validator.constraints.Length;

import javax.validation.Valid;
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
    @NotBlank(message = "id required", groups = {GroupB.class})
    private String id;
    @NotBlank(message = "name required",groups = {GroupA.class})
    private String name;

    @NotBlank
    @Email(message = "{valid.mail}",groups = {GroupA.class})
    private String email;

    @NotNull(message = "age required",groups = {GroupA.class})
    @Min(18)
    @Max(120)
    private int age;

    @NotBlank(message = "address required",groups = {GroupA.class})
    @Length()
    private String address;

    @NotNull(message = "innerValidAo required",groups = {GroupA.class})
    @Valid
    private InnerValidAo innerValidAo;

    public interface GroupA {

    }

    public interface GroupB {

    }

}
