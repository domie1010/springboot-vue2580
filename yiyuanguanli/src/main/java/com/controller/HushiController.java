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

import com.entity.HushiEntity;

import com.service.HushiService;
import com.entity.view.HushiView;
import com.service.YishengService;
import com.utils.PageUtils;
import com.utils.R;

/**
 * 护士
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/hushi")
public class HushiController {
    private static final Logger logger = LoggerFactory.getLogger(HushiController.class);

    @Autowired
    private HushiService hushiService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;



    //级联表service
    @Autowired
    private YishengService yishengService;


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
        PageUtils page = hushiService.queryPage(params);

        //字典表数据转换
        List<HushiView> list =(List<HushiView>)page.getList();
        for(HushiView c:list){
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
        HushiEntity hushi = hushiService.selectById(id);
        if(hushi !=null){
            //entity转view
            HushiView view = new HushiView();
            BeanUtils.copyProperties( hushi , view );//把实体数据重构到view中

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
    public R save(@RequestBody HushiEntity hushi, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,hushi:{}",this.getClass().getName(),hushi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        Wrapper<HushiEntity> queryWrapper = new EntityWrapper<HushiEntity>()
            .eq("username", hushi.getUsername())
            .or()
            .eq("hushi_phone", hushi.getHushiPhone())
            .or()
            .eq("hushi_id_number", hushi.getHushiIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HushiEntity hushiEntity = hushiService.selectOne(queryWrapper);
        if(hushiEntity==null){
            hushi.setCreateTime(new Date());
            hushi.setPassword("123456");
            hushiService.insert(hushi);
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody HushiEntity hushi, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,hushi:{}",this.getClass().getName(),hushi.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(StringUtil.isEmpty(role))
            return R.error(511,"权限为空");
        //根据字段查询是否有相同数据
        Wrapper<HushiEntity> queryWrapper = new EntityWrapper<HushiEntity>()
            .notIn("id",hushi.getId())
            .andNew()
            .eq("username", hushi.getUsername())
            .or()
            .eq("hushi_phone", hushi.getHushiPhone())
            .or()
            .eq("hushi_id_number", hushi.getHushiIdNumber())
            ;
        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        HushiEntity hushiEntity = hushiService.selectOne(queryWrapper);
        if("".equals(hushi.getHushiPhoto()) || "null".equals(hushi.getHushiPhoto())){
                hushi.setHushiPhoto(null);
        }
        if(hushiEntity==null){
            //  String role = String.valueOf(request.getSession().getAttribute("role"));
            //  if("".equals(role)){
            //      hushi.set
            //  }
            hushiService.updateById(hushi);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"账户或者身份证号或者手机号已经被使用");
        }
    }



    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        hushiService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }

    /**
    * 登录
    */
    @IgnoreAuth
    @RequestMapping(value = "/login")
    public R login(String username, String password, String captcha, HttpServletRequest request) {
        HushiEntity hushi = hushiService.selectOne(new EntityWrapper<HushiEntity>().eq("username", username));
        if(hushi==null || !hushi.getPassword().equals(password))
            return R.error("账号或密码不正确");
        //  // 获取监听器中的字典表
        // ServletContext servletContext = ContextLoader.getCurrentWebApplicationContext().getServletContext();
        // Map<String, Map<Integer, String>> dictionaryMap= (Map<String, Map<Integer, String>>) servletContext.getAttribute("dictionaryMap");
        // Map<Integer, String> role_types = dictionaryMap.get("role_types");
        // role_types.get(yonghu.getRoleTypes());
        String token = tokenService.generateToken(hushi.getId(),username, "hushi", "护士");
        R r = R.ok();
        r.put("token", token);
        r.put("role","护士");
        r.put("username",hushi.getHushiName());
        r.put("tableName","hushi");
        r.put("userId",hushi.getId());
        return r;
    }

    /**
    * 注册
    */
    @IgnoreAuth
    @PostMapping(value = "/register")
    public R register(@RequestBody HushiEntity hushi){
    //    	ValidatorUtils.validateEntity(user);
        if(hushiService.selectOne(new EntityWrapper<HushiEntity>().eq("username", hushi.getUsername()).orNew().eq("hushi_phone",hushi.getHushiPhone()).orNew().eq("hushi_id_number",hushi.getHushiIdNumber())) !=null)
            return R.error("账户已存在或手机号或身份证号已经被使用");
        hushi.setCreateTime(new Date());
        hushiService.insert(hushi);
        return R.ok();
    }

    /**
     * 重置密码
     */
    @GetMapping(value = "/resetPassword")
    public R resetPassword(Integer  id){
        HushiEntity hushi = new HushiEntity();
        hushi.setPassword("123456");
        hushi.setId(id);
        hushiService.updateById(hushi);
        return R.ok();
    }

    /**
    * 获取用户的session用户信息
    */
    @RequestMapping("/session")
    public R getCurrHushi(HttpServletRequest request){
        Integer id = (Integer)request.getSession().getAttribute("userId");
        HushiEntity hushi = hushiService.selectById(id);
        if(hushi !=null){
            //entity转view
            HushiView view = new HushiView();
            BeanUtils.copyProperties( hushi , view );//把实体数据重构到view中

            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }
    }


    /**
    * 退出
    */
    @GetMapping(value = "logout")
    public R logout(HttpServletRequest request) {
        request.getSession().invalidate();
        return R.ok("退出成功");
    }






}

