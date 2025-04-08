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

import com.entity.YufukuanEntity;

import com.service.YufukuanService;
import com.entity.view.YufukuanView;
import com.service.BingliService;
import com.entity.BingliEntity;
import com.service.YishengService;
import com.service.HushiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 预付款账户
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/yufukuan")
public class YufukuanController {
    private static final Logger logger = LoggerFactory.getLogger(YufukuanController.class);

    @Autowired
    private YufukuanService yufukuanService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private BingliService bingliService;
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
        PageUtils page = yufukuanService.queryPage(params);

        //字典表数据转换
        List<YufukuanView> list =(List<YufukuanView>)page.getList();
        for(YufukuanView c:list){
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
        YufukuanEntity yufukuan = yufukuanService.selectById(id);
        if(yufukuan !=null){
            //entity转view
            YufukuanView view = new YufukuanView();
            BeanUtils.copyProperties( yufukuan , view );//把实体数据重构到view中

            //级联表
            BingliEntity bingli = bingliService.selectById(yufukuan.getBingliId());
            if(bingli != null){
                BeanUtils.copyProperties( bingli , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setBingliId(bingli.getId());
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
    public R save(@RequestBody YufukuanEntity yufukuan, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,yufukuan:{}",this.getClass().getName(),yufukuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<YufukuanEntity> queryWrapper = new EntityWrapper<YufukuanEntity>()
            .eq("bingli_id", yufukuan.getBingliId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YufukuanEntity yufukuanEntity = yufukuanService.selectOne(queryWrapper);
        if(yufukuanEntity==null){
            yufukuan.setInsertTime(new Date());
            yufukuan.setCreateTime(new Date());
            yufukuanService.insert(yufukuan);
            return R.ok();
        }else {
            return R.error(511,"该患者已经有预付款账户");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody YufukuanEntity yufukuan, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,yufukuan:{}",this.getClass().getName(),yufukuan.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<YufukuanEntity> queryWrapper = new EntityWrapper<YufukuanEntity>()
            .notIn("id",yufukuan.getId())
            .andNew()
            .eq("bingli_id", yufukuan.getBingliId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        YufukuanEntity yufukuanEntity = yufukuanService.selectOne(queryWrapper);
        if(yufukuanEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      yufukuan.set
            //  }
            yufukuanService.updateById(yufukuan);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该患者已经有预付款账户");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        yufukuanService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

