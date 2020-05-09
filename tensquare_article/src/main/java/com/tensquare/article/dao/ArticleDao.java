package com.tensquare.article.dao;

import com.baomidou.mybatisplus.mapper.BaseMapper;
import com.tensquare.article.pojo.Article;

//BaseMapper是mybatis自己封装好的常用接口,使用的是泛型T
public interface ArticleDao extends BaseMapper<Article> {
}
