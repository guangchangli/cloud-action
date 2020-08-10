package com.aladdin.cloud.mp.domain.ao;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * @author lgc
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@EqualsAndHashCode
@Builder
public class InnerValidAo {

    @NotBlank(message = "name required")
    private String name;
}
