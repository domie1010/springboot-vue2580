package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;

import com.entity.YufukuanInEntity;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.StringUtil;
import java.lang.reflect.InvocationTargetException;

import com.service.DictionaryService;
import org.apache.commons.lang3.StringUtils;
import com.annotation.IgnoreAuth;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import com.baomidou.mybatisplus.mapper.EntityWrapper;
import com.baomidou.mybatisplus.mapper.Wrapper;

import com.entity.XiaofeiEntity;

import com.service.XiaofeiService;
import com.entity.view.XiaofeiView;
import com.service.YufukuanService;
import com.entity.YufukuanEntity;
import com.service.YishengService;
import com.service.HushiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 消费
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/xiaofei")
public class XiaofeiController {
    private static final Logger logger = LoggerFactory.getLogger(XiaofeiController.class);

    @Autowired
    private XiaofeiService xiaofeiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private YufukuanService yufukuanService;
    @Autowired
    private YishengService yishengService;
    @Autowired
    private HushiService hushiService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        else if("医生".equals(role))
            params.put("yishengId",request.getSession().getAttribute("userId"));
        else if("护士".equals(role))
            params.put("hushiId",request.getSession().getAttribute("userId"));
        params.put("orderBy","id");
        PageUtils page = xiaofeiService.queryPage(params);

        //字典表数据转换
        List<XiaofeiView> list =(List<XiaofeiView>)page.getList();
        for(XiaofeiView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        XiaofeiEntity xiaofei = xiaofeiService.selectById(id);
        if(xiaofei !=null){
            //entity转view
            XiaofeiView view = new XiaofeiView();
            BeanUtils.copyProperties( xiaofei , view );//把实体数据重构到view中

            //级联表
            YufukuanEntity yufukuan = yufukuanService.selectById(xiaofei.getYufukuanId());
            if(yufukuan != null){
                BeanUtils.copyProperties( yufukuan , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setYufukuanId(yufukuan.getId());
            }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody XiaofeiEntity xiaofei, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,xiaofei:{}",this.getClass().getName(),xiaofei.toString());

        YufukuanEntity yufukuanEntity = yufukuanService.selectById(xiaofei.getYufukuanId());
        if(yufukuanEntity != null ){
            double b = yufukuanEntity.getYufukuanMoney() - xiaofei.getXiaofeiMoney();
            if(b<0){
                return R.error(511,"消费金额大于预付款余额");
            }
            yufukuanEntity.setYufukuanMoney(b);
            yufukuanService.updateById(yufukuanEntity);
        }

            xiaofei.setInsertTime(new Date());
            xiaofei.setCreateTime(new Date());
            xiaofeiService.insert(xiaofei);
            return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody XiaofeiEntity xiaofei, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,xiaofei:{}",this.getClass().getName(),xiaofei.toString());


        XiaofeiEntity oldXiaofeiEntity = xiaofeiService.selectById(xiaofei.getId());
        YufukuanEntity oldYufukuanEntity = yufukuanService.selectById(oldXiaofeiEntity.getYufukuanId());
        if(oldYufukuanEntity != null ){
            oldYufukuanEntity.setYufukuanMoney(oldYufukuanEntity.getYufukuanMoney()+oldXiaofeiEntity.getXiaofeiMoney());
            yufukuanService.updateById(oldYufukuanEntity);
        }

        YufukuanEntity yufukuanEntity = yufukuanService.selectById(xiaofei.getYufukuanId());
        if(yufukuanEntity != null ){
            double v = yufukuanEntity.getYufukuanMoney() - xiaofei.getXiaofeiMoney();
            if(v<0){
                return R.error(511,"消费金额大于预付款余额");
            }
            yufukuanEntity.setYufukuanMoney(v);
            yufukuanService.updateById(yufukuanEntity);
        }

            xiaofeiService.updateById(xiaofei);//根据id更新
            return R.ok();
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        xiaofeiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

