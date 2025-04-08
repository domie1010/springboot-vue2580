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

import com.entity.ChuangweiBingliEntity;

import com.service.ChuangweiBingliService;
import com.entity.view.ChuangweiBingliView;
import com.service.BingliService;
import com.entity.BingliEntity;
import com.service.ChuangweiService;
import com.entity.ChuangweiEntity;
import com.service.YishengService;
import com.service.HushiService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 患者住院房屋
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chuangweiBingli")
public class ChuangweiBingliController {
    private static final Logger logger = LoggerFactory.getLogger(ChuangweiBingliController.class);

    @Autowired
    private ChuangweiBingliService chuangweiBingliService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private BingliService bingliService;
    @Autowired
    private ChuangweiService chuangweiService;
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
        PageUtils page = chuangweiBingliService.queryPage(params);

        //字典表数据转换
        List<ChuangweiBingliView> list =(List<ChuangweiBingliView>)page.getList();
        for(ChuangweiBingliView c:list){
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
        ChuangweiBingliEntity chuangweiBingli = chuangweiBingliService.selectById(id);
        if(chuangweiBingli !=null){
            //entity转view
            ChuangweiBingliView view = new ChuangweiBingliView();
            BeanUtils.copyProperties( chuangweiBingli , view );//把实体数据重构到view中

            //级联表
            BingliEntity bingli = bingliService.selectById(chuangweiBingli.getBingliId());
            if(bingli != null){
                BeanUtils.copyProperties( bingli , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setBingliId(bingli.getId());
            }
            //级联表
            ChuangweiEntity chuangwei = chuangweiService.selectById(chuangweiBingli.getChuangweiId());
            if(chuangwei != null){
                BeanUtils.copyProperties( chuangwei , view ,new String[]{ "id", "createDate"});//把级联的数据添加到view中,并排除id和创建时间字段
                view.setChuangweiId(chuangwei.getId());
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
    public R save(@RequestBody ChuangweiBingliEntity chuangweiBingli, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chuangweiBingli:{}",this.getClass().getName(),chuangweiBingli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<ChuangweiBingliEntity> queryWrapper = new EntityWrapper<ChuangweiBingliEntity>()
            .eq("bingli_id", chuangweiBingli.getBingliId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuangweiBingliEntity chuangweiBingliEntity = chuangweiBingliService.selectOne(queryWrapper);
        if(chuangweiBingliEntity==null){


            chuangweiBingli.setChuangweiBingliYesnoTypes(2);
            chuangweiBingli.setCreateTime(new Date());
            chuangweiBingliService.insert(chuangweiBingli);

            ChuangweiEntity chuangweiEntity = chuangweiService.selectById(chuangweiBingli.getChuangweiId());
            chuangweiEntity.setChuangweiYesnoTypes(2);
            chuangweiService.updateById(chuangweiEntity);
            return R.ok();
        }else {
            return R.error(511,"该患者已经住院");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChuangweiBingliEntity chuangweiBingli, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chuangweiBingli:{}",this.getClass().getName(),chuangweiBingli.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<ChuangweiBingliEntity> queryWrapper = new EntityWrapper<ChuangweiBingliEntity>()
            .notIn("id",chuangweiBingli.getId())
            .andNew()
            .eq("bingli_id", chuangweiBingli.getBingliId())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChuangweiBingliEntity chuangweiBingliEntity = chuangweiBingliService.selectOne(queryWrapper);
        if(chuangweiBingliEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      chuangweiBingli.set
            //  }

            ChuangweiBingliEntity oldChuangweiBingliEntity = chuangweiBingliService.selectById(chuangweiBingli.getId());
            Integer oldChuangweiBingliYesnoTypes = oldChuangweiBingliEntity.getChuangweiBingliYesnoTypes();


            Integer newChuangweiBingliYesnoTypes = chuangweiBingli.getChuangweiBingliYesnoTypes();

            if(oldChuangweiBingliYesnoTypes == 1  && newChuangweiBingliYesnoTypes ==1){//原先为不在住,现在是不在住

            }else if(oldChuangweiBingliYesnoTypes == 1  && newChuangweiBingliYesnoTypes ==2){//原先为不在住,现在是在住

                ChuangweiEntity oldCchuangweiEntity = chuangweiService.selectById(oldChuangweiBingliEntity.getChuangweiId());
                if(oldCchuangweiEntity != null){
                    oldCchuangweiEntity.setChuangweiYesnoTypes(1);
                }
                chuangweiService.updateById(oldCchuangweiEntity);

                ChuangweiEntity newChuangweiEntity = chuangweiService.selectById(chuangweiBingli.getChuangweiId());
                if(newChuangweiEntity != null){
                    newChuangweiEntity.setChuangweiYesnoTypes(2);
                }
                chuangweiService.updateById(newChuangweiEntity);
            }else if(oldChuangweiBingliYesnoTypes == 2  && newChuangweiBingliYesnoTypes ==1){//原先为在住,现在是不在住
                ChuangweiEntity newChuangweiEntity = chuangweiService.selectById(chuangweiBingli.getChuangweiId());
                if(newChuangweiEntity != null){
                    newChuangweiEntity.setChuangweiYesnoTypes(1);
                }
                chuangweiService.updateById(newChuangweiEntity);
            }else if(oldChuangweiBingliYesnoTypes == 2  && newChuangweiBingliYesnoTypes ==2){//原先为在住,现在是在住
                ChuangweiEntity oldCchuangweiEntity = chuangweiService.selectById(oldChuangweiBingliEntity.getChuangweiId());
                if(oldCchuangweiEntity != null){
                    oldCchuangweiEntity.setChuangweiYesnoTypes(1);
                }
                chuangweiService.updateById(oldCchuangweiEntity);

                ChuangweiEntity newChuangweiEntity = chuangweiService.selectById(chuangweiBingli.getChuangweiId());
                if(newChuangweiEntity != null){
                    newChuangweiEntity.setChuangweiYesnoTypes(2);
                }
                chuangweiService.updateById(newChuangweiEntity);
            }

//            ChuangweiEntity chuangweiEntity = chuangweiService.selectById(chuangweiBingli.getChuangweiId());
//            chuangweiEntity.setChuangweiYesnoTypes(2);

            chuangweiBingliService.updateById(chuangweiBingli);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"该患者已经住院");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        chuangweiBingliService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }






}

