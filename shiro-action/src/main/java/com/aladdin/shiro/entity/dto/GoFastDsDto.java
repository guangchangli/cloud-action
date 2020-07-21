package com.aladdin.shiro.entity.dto;

import lombok.*;

import java.io.Serializable;

/**
 * go fast_dfs resp
 * @author lgc
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder
@EqualsAndHashCode
public class GoFastDsDto implements Serializable {

    private static final long serialVersionUID = 3751540319798880271L;
    private String domain;
    private String md5;
    private Long mtime;
    private String path;
    private Integer retcode;
    private String retmsg;
    private String scene;
    private String scenes;
    private Long size;
    private String src;
    private String url;
    //todo Gson serial
}
