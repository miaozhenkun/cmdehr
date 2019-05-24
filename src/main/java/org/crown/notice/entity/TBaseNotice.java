/*
 * Copyright (c) 2018-2022 Caratacus, (caratacus@qq.com).
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of
 * this software and associated documentation files (the "Software"), to deal in
 * the Software without restriction, including without limitation the rights to
 * use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of
 * the Software, and to permit persons to whom the Software is furnished to do so,
 * subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all
 * copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
 * IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS
 * FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR
 * COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER
 * IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN
 * CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */
package org.crown.notice.entity;

import org.crown.framework.model.BaseModel;
import java.time.LocalDateTime;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;


/**
 * <p>
 * 通知公告表
 * </p>
 *
 * @author jobob
 */
@Data
@NoArgsConstructor
@EqualsAndHashCode(callSuper = false)
public class TBaseNotice extends BaseModel {

private static final long serialVersionUID=1L;

    @ApiModelProperty(notes = "标题")
private String title;
    @ApiModelProperty(notes = "内容")
private String content;
    @ApiModelProperty(notes = "类型（'01':文本）")
private String type;
    @ApiModelProperty(notes = "状态（'00':未发布',01':发布，'02':撤销）")
private String state;
    @ApiModelProperty(notes = "发布时间")
private LocalDateTime publishTime;
    @ApiModelProperty(notes = "创建人")
private Integer createUser;
    @ApiModelProperty(notes = "创建时间")
private LocalDateTime createTime;
    @ApiModelProperty(notes = "更新人")
private Integer updateUser;
    @ApiModelProperty(notes = "更新时间")
private LocalDateTime updateTime;
    @ApiModelProperty(notes = "是否置顶（'01':是，'02':否）")
private String istop;

}
