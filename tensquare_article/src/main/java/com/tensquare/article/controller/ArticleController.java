package com.tensquare.article.controller;

import com.tensquare.article.pojo.Article;
import com.tensquare.article.service.ArticleService;
import com.tensquare.entity.Result;
import com.tensquare.entity.StatusCode;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.*;

/**
 * 文章操作
 */
@CrossOrigin //跨域处理
@RestController
@RequestMapping("/article")
@Slf4j
public class ArticleController {
    @Autowired
    private ArticleService articleService;


    @RequestMapping(method = RequestMethod.GET)
    public Result findAll() {
        List list = articleService.findAll();
        return new Result(true, StatusCode.OK, "查询成功", list);
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result findById(@PathVariable String id) {
        Article Article = articleService.findById(id);
        return new Result(true, StatusCode.OK, "查询成功", Article);
    }

    //新增标签数据接口
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Article article) {
        articleService.add(article);
        return new Result(true, StatusCode.OK, "添加成功");
    }

    //修改标签数据接口
    @RequestMapping(value = "{id}", method = RequestMethod.PUT)
    public Result update(@PathVariable String id, @RequestBody Article article) {
        article.setId(id);
        articleService.update(article);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    //删除文章数据接口
    @RequestMapping(value = "{id}", method = RequestMethod.DELETE)
    public Result delete(@PathVariable String id) {
        articleService.delete(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    //test异常处理
    @RequestMapping(value = "/testQuanjuException/{id}", method = RequestMethod.GET)
    public Result testQuanjuException(@PathVariable String id) {
        articleService.testHandleException();
        return new Result(true, StatusCode.OK, "删除成功");
    }

    //test异常处理
    @RequestMapping(value = "/testControllerException/{id}", method = RequestMethod.GET)
    public Result testControllerException(@PathVariable String id) {
        if (id.equals("1")) {
            throw new NullPointerException();
        }
        if (id.equals("3")) {
            throw new RuntimeException();
        }
        return new Result(true, StatusCode.OK, "删除成功");
    }

    @RequestMapping(value="/exception", method = RequestMethod.GET)
    public Result exception() throws Exception {
        throw new Exception("22测试统一异常处理");
    }



}
