package com.aladdin.shiro.entity.auto;

import lombok.*;

/**
 * @author lgc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class Role {
    private int id;
    private String name;
}
