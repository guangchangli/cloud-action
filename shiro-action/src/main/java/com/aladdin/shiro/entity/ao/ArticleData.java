package com.aladdin.shiro.entity.ao;

import lombok.*;

/**
 * @author lgc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Builder
public class ArticleData {
    private String title;
    private String category;
    private String content;
    private String author_acc;
    private String author_name;
    private String create_time;
    private String last_edit_time;
}