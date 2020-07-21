package com.aladdin.shiro.entity.auto;

import com.baomidou.mybatisplus.annotation.TableName;
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
//@Accessors(chain = true)
@TableName("t_user")
public class User {
    private Long id;
    private String userName;
    private String password;
    private String salt;
}
