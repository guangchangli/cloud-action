package com.aladdin.cloud.mp.domain.ao;

import lombok.*;

import javax.validation.constraints.NotBlank;

/**
 * @author lgc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class InnerValidListAo {
    @NotBlank(message = "lName required")
    private String lName;
}
