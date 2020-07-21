package com.aladdin.shiro.entity.dto;

import com.aladdin.shiro.entity.auto.Perms;
import lombok.*;

import java.util.List;

/**
 * @author lgc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class RoleDto {
    private int id;
    private String name;
    private List<Perms> permsList;
}
