package com.aladdin.shiro.entity.auto;

import lombok.*;

/**
 * @author lgc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class Perms {
    private int id;
    private String name;
    private String url;
}
