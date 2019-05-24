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
package org.crown.notice.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;
import liquibase.util.StringUtils;
import org.crown.common.annotations.Resources;
import org.crown.enums.AuthTypeEnum;
import org.crown.framework.responses.ApiResponses;
import org.crown.notice.entity.TBaseNotice;
import org.crown.notice.service.ITBaseNoticeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.http.MediaType;
import org.springframework.validation.annotation.Validated;

import io.swagger.annotations.Api;
import org.crown.framework.controller.SuperController;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;


/**
 * <p>
 * 通知公告表 前端控制器
 * </p>
 *
 * @author jobob
 */
@Api(tags = {"TBaseNotice"}, description = "通知公告表相关接口")
@RestController
@RequestMapping(value = "/notice/t-base-notice", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Validated
public class TBaseNoticeController extends SuperController {
        @Autowired
        private ITBaseNoticeService ITBaseNoticeService;


        @Resources(auth = AuthTypeEnum.AUTH)
        @ApiOperation("查询所有通知")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "title", value = "标题", paramType = "query"),
        })
        @GetMapping
        public ApiResponses<IPage<TBaseNotice>> page(@RequestParam(value = "title", required = false) String title) {
                return success(
                        ITBaseNoticeService.query()
//                                .select(TBaseNotice::getTitle)
                                .like(Objects.nonNull(title),TBaseNotice::getTitle,title)
                                .page(this.<TBaseNotice>getPage()));
        }

        @Resources(auth = AuthTypeEnum.AUTH)
        @ApiOperation("删除通知")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "ID", required = true, paramType = "path"),
        })
        @DeleteMapping("/{id}")
        public ApiResponses<Void> delNotice(@PathVariable("id") Integer id ){
                ITBaseNoticeService.removeById(id);
                return success();
        }

        @Resources(auth = AuthTypeEnum.AUTH)
        @ApiOperation("新增通知")
        @PostMapping
        public ApiResponses<Void> insertNotice(@RequestBody TBaseNotice tBaseNotice){
                System.out.println(tBaseNotice);
                ITBaseNoticeService.save(tBaseNotice);
                Map map=new HashMap<>();
                map.put("message","新增成功");
                map.put("status","200");
                return success();
        }

        @Resources(auth = AuthTypeEnum.AUTH)
        @ApiOperation("修改通知")
        @ApiImplicitParams({
                @ApiImplicitParam(name = "id", value = "通知ID", required = true, paramType = "path")
        })
        @PutMapping("/{id}")
        public ApiResponses<Void> update(@PathVariable("id") Integer id, @RequestBody TBaseNotice tBaseNotice) {
                tBaseNotice.setId(id);
                ITBaseNoticeService.updateById(tBaseNotice);
                return success();
        }



}
