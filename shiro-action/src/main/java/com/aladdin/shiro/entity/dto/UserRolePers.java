package com.aladdin.shiro.entity.dto;

import lombok.*;

import java.util.List;

/**
 * @author lgc
 */
@AllArgsConstructor
@NoArgsConstructor
@Data
@Builder
@EqualsAndHashCode
public class UserRolePers {
    private Long id;
    private String userName;
    private List<RoleDto> roles;
}
