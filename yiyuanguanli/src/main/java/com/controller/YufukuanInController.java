package com.controller;


import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
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

import com.entity.YufukuanInEntity;

import com.service.YufukuanInService;
import com.entity.view.YufukuanInView;
import com.service.YufukuanService;
import com.entity.YufukuanEntity;
import com.service.YishengService;
import com.service.HushiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 预付款缴费
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yufukuanIn")
public class YufukuanInController {
    private static final Logger logger = LoggerFactory.getLogger(YufukuanInController.class);

    @Autowired
    private YufukuanInService yufukuanInService;


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
        PageUtils page = yufukuanInService.queryPage(params);

        //字典表数据转换
        List<YufukuanInView> list =(List<YufukuanInView>)page.getList();
        for(YufukuanInView c:list){
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
        YufukuanInEntity yufukuanIn = yufukuanInService.selectById(id);
        if(yufukuanIn !=null){
            //entity转view
            YufukuanInView view = new YufukuanInView();
            BeanUtils.copyProperties( yufukuanIn , view );//把实体数据重构到view中

            //级联表
            YufukuanEntity yufukuan = yufukuanService.selectById(yufukuanIn.getYufukuanId());
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
    public R save(@RequestBody YufukuanInEntity yufukuanIn, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yufukuanIn:{}",this.getClass().getName(),yufukuanIn.toString());

        YufukuanEntity yufukuanEntity = yufukuanService.selectById(yufukuanIn.getYufukuanId());
        if(yufukuanEntity != null ){
            yufukuanEntity.setYufukuanMoney(yufukuanEntity.getYufukuanMoney()+yufukuanIn.getYufukuanInMoney());
            yufukuanService.updateById(yufukuanEntity);
        }
        yufukuanIn.setInsertTime(new Date());
        yufukuanIn.setCreateTime(new Date());
        yufukuanInService.insert(yufukuanIn);
        return R.ok();

    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YufukuanInEntity yufukuanIn, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yufukuanIn:{}",this.getClass().getName(),yufukuanIn.toString());

        YufukuanInEntity oldYufukuanInEntity = yufukuanInService.selectById(yufukuanIn.getId());
        YufukuanEntity oldYufukuanEntity = yufukuanService.selectById(oldYufukuanInEntity.getYufukuanId());
        if(oldYufukuanEntity != null ){
            oldYufukuanEntity.setYufukuanMoney(oldYufukuanEntity.getYufukuanMoney()-oldYufukuanInEntity.getYufukuanInMoney());
            yufukuanService.updateById(oldYufukuanEntity);
        }

        YufukuanEntity yufukuanEntity = yufukuanService.selectById(yufukuanIn.getYufukuanId());
        if(yufukuanEntity != null ){
            yufukuanEntity.setYufukuanMoney(yufukuanEntity.getYufukuanMoney()+yufukuanIn.getYufukuanInMoney());
            yufukuanService.updateById(yufukuanEntity);
        }
        yufukuanInService.updateById(yufukuanIn);//根据id更新
        return R.ok();

    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yufukuanInService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

