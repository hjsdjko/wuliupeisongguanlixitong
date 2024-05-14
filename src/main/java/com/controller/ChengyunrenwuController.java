
package com.controller;

import java.io.File;
import java.math.BigDecimal;
import java.net.URL;
import java.text.SimpleDateFormat;
import com.alibaba.fastjson.JSONObject;
import java.util.*;
import org.springframework.beans.BeanUtils;
import javax.servlet.http.HttpServletRequest;
import org.springframework.web.context.ContextLoader;
import javax.servlet.ServletContext;
import com.service.TokenService;
import com.utils.*;
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
import com.entity.*;
import com.entity.view.*;
import com.service.*;
import com.utils.PageUtils;
import com.utils.R;
import com.alibaba.fastjson.*;

/**
 * 承运任务
 * 后端接口
 * @author
 * @email
*/
@RestController
@Controller
@RequestMapping("/chengyunrenwu")
public class ChengyunrenwuController {
    private static final Logger logger = LoggerFactory.getLogger(ChengyunrenwuController.class);

    @Autowired
    private ChengyunrenwuService chengyunrenwuService;


    @Autowired
    private TokenService tokenService;
    @Autowired
    private DictionaryService dictionaryService;

    //级联表service
    @Autowired
    private CheliangService cheliangService;

    @Autowired
    private YonghuService yonghuService;


    /**
    * 后端列表
    */
    @RequestMapping("/page")
    public R page(@RequestParam Map<String, Object> params, HttpServletRequest request){
        logger.debug("page方法:,,Controller:{},,params:{}",this.getClass().getName(),JSONObject.toJSONString(params));
        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永不会进入");
        else if("司机".equals(role))
            params.put("yonghuId",request.getSession().getAttribute("userId"));
        if(params.get("orderBy")==null || params.get("orderBy")==""){
            params.put("orderBy","id");
        }
        PageUtils page = chengyunrenwuService.queryPage(params);

        //字典表数据转换
        List<ChengyunrenwuView> list =(List<ChengyunrenwuView>)page.getList();
        for(ChengyunrenwuView c:list){
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(c, request);
        }
        return R.ok().put("data", page);
    }

    /**
    * 后端详情
    */
    @RequestMapping("/info/{id}")
    public R info(@PathVariable("id") Long id, HttpServletRequest request){
        logger.debug("info方法:,,Controller:{},,id:{}",this.getClass().getName(),id);
        ChengyunrenwuEntity chengyunrenwu = chengyunrenwuService.selectById(id);
        if(chengyunrenwu !=null){
            //entity转view
            ChengyunrenwuView view = new ChengyunrenwuView();
            BeanUtils.copyProperties( chengyunrenwu , view );//把实体数据重构到view中

                //级联表
                CheliangEntity cheliang = cheliangService.selectById(chengyunrenwu.getCheliangId());
                if(cheliang != null){
                    BeanUtils.copyProperties( cheliang , view ,new String[]{ "id", "createTime", "insertTime", "updateTime"});//把级联的数据添加到view中,并排除id和创建时间字段
                    view.setCheliangId(cheliang.getId());
                }
            //修改对应字典表字段
            dictionaryService.dictionaryConvert(view, request);
            return R.ok().put("data", view);
        }else {
            return R.error(511,"查不到数据");
        }

    }

    /**
    * 后端保存
    */
    @RequestMapping("/save")
    public R save(@RequestBody ChengyunrenwuEntity chengyunrenwu, HttpServletRequest request){
        logger.debug("save方法:,,Controller:{},,chengyunrenwu:{}",this.getClass().getName(),chengyunrenwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
        if(false)
            return R.error(511,"永远不会进入");

        Wrapper<ChengyunrenwuEntity> queryWrapper = new EntityWrapper<ChengyunrenwuEntity>()
            .eq("cheliang_id", chengyunrenwu.getCheliangId())
            .eq("chengyunrenwu_uuid_number", chengyunrenwu.getChengyunrenwuUuidNumber())
            .eq("chengyunrenwu_chufadi", chengyunrenwu.getChengyunrenwuChufadi())
            .eq("chengyunrenwu_mudidi", chengyunrenwu.getChengyunrenwuMudidi())
            .eq("chengyunrenwu_types", chengyunrenwu.getChengyunrenwuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChengyunrenwuEntity chengyunrenwuEntity = chengyunrenwuService.selectOne(queryWrapper);
        if(chengyunrenwuEntity==null){
            chengyunrenwu.setCreateTime(new Date());
            chengyunrenwuService.insert(chengyunrenwu);
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 后端修改
    */
    @RequestMapping("/update")
    public R update(@RequestBody ChengyunrenwuEntity chengyunrenwu, HttpServletRequest request){
        logger.debug("update方法:,,Controller:{},,chengyunrenwu:{}",this.getClass().getName(),chengyunrenwu.toString());

        String role = String.valueOf(request.getSession().getAttribute("role"));
//        if(false)
//            return R.error(511,"永远不会进入");
        //根据字段查询是否有相同数据
        Wrapper<ChengyunrenwuEntity> queryWrapper = new EntityWrapper<ChengyunrenwuEntity>()
            .notIn("id",chengyunrenwu.getId())
            .andNew()
            .eq("cheliang_id", chengyunrenwu.getCheliangId())
            .eq("chengyunrenwu_uuid_number", chengyunrenwu.getChengyunrenwuUuidNumber())
            .eq("chengyunrenwu_chufadi", chengyunrenwu.getChengyunrenwuChufadi())
            .eq("chengyunrenwu_mudidi", chengyunrenwu.getChengyunrenwuMudidi())
            .eq("chengyunrenwu_types", chengyunrenwu.getChengyunrenwuTypes())
            ;

        logger.info("sql语句:"+queryWrapper.getSqlSegment());
        ChengyunrenwuEntity chengyunrenwuEntity = chengyunrenwuService.selectOne(queryWrapper);
        if(chengyunrenwuEntity==null){
            chengyunrenwuService.updateById(chengyunrenwu);//根据id更新
            return R.ok();
        }else {
            return R.error(511,"表中有相同数据");
        }
    }

    /**
    * 删除
    */
    @RequestMapping("/delete")
    public R delete(@RequestBody Integer[] ids){
        logger.debug("delete:,,Controller:{},,ids:{}",this.getClass().getName(),ids.toString());
        chengyunrenwuService.deleteBatchIds(Arrays.asList(ids));
        return R.ok();
    }


    /**
     * 批量上传
     */
    @RequestMapping("/batchInsert")
    public R save( String fileName){
        logger.debug("batchInsert方法:,,Controller:{},,fileName:{}",this.getClass().getName(),fileName);
        try {
            List<ChengyunrenwuEntity> chengyunrenwuList = new ArrayList<>();//上传的东西
            Map<String, List<String>> seachFields= new HashMap<>();//要查询的字段
            Date date = new Date();
            int lastIndexOf = fileName.lastIndexOf(".");
            if(lastIndexOf == -1){
                return R.error(511,"该文件没有后缀");
            }else{
                String suffix = fileName.substring(lastIndexOf);
                if(!".xls".equals(suffix)){
                    return R.error(511,"只支持后缀为xls的excel文件");
                }else{
                    URL resource = this.getClass().getClassLoader().getResource("static/upload/" + fileName);//获取文件路径
                    File file = new File(resource.getFile());
                    if(!file.exists()){
                        return R.error(511,"找不到上传文件，请联系管理员");
                    }else{
                        List<List<String>> dataList = PoiUtil.poiImport(file.getPath());//读取xls文件
                        dataList.remove(0);//删除第一行，因为第一行是提示
                        for(List<String> data:dataList){
                            //循环
                            ChengyunrenwuEntity chengyunrenwuEntity = new ChengyunrenwuEntity();
//                            chengyunrenwuEntity.setCheliangId(Integer.valueOf(data.get(0)));   //车辆 要改的
//                            chengyunrenwuEntity.setChengyunrenwuUuidNumber(data.get(0));                    //运单号 要改的
//                            chengyunrenwuEntity.setChengyunrenwuChufadi(data.get(0));                    //出发地 要改的
//                            chengyunrenwuEntity.setChengyunrenwuMudidi(data.get(0));                    //目的地 要改的
//                            chengyunrenwuEntity.setChengyunrenwuMoney(data.get(0));                    //成本 要改的
//                            chengyunrenwuEntity.setChengyunrenwuTypes(Integer.valueOf(data.get(0)));   //运单状态 要改的
//                            chengyunrenwuEntity.setChengyunrenwuContent("");//照片
//                            chengyunrenwuEntity.setCreateTime(date);//时间
                            chengyunrenwuList.add(chengyunrenwuEntity);


                            //把要查询是否重复的字段放入map中
                                //运单号
                                if(seachFields.containsKey("chengyunrenwuUuidNumber")){
                                    List<String> chengyunrenwuUuidNumber = seachFields.get("chengyunrenwuUuidNumber");
                                    chengyunrenwuUuidNumber.add(data.get(0));//要改的
                                }else{
                                    List<String> chengyunrenwuUuidNumber = new ArrayList<>();
                                    chengyunrenwuUuidNumber.add(data.get(0));//要改的
                                    seachFields.put("chengyunrenwuUuidNumber",chengyunrenwuUuidNumber);
                                }
                        }

                        //查询是否重复
                         //运单号
                        List<ChengyunrenwuEntity> chengyunrenwuEntities_chengyunrenwuUuidNumber = chengyunrenwuService.selectList(new EntityWrapper<ChengyunrenwuEntity>().in("chengyunrenwu_uuid_number", seachFields.get("chengyunrenwuUuidNumber")));
                        if(chengyunrenwuEntities_chengyunrenwuUuidNumber.size() >0 ){
                            ArrayList<String> repeatFields = new ArrayList<>();
                            for(ChengyunrenwuEntity s:chengyunrenwuEntities_chengyunrenwuUuidNumber){
                                repeatFields.add(s.getChengyunrenwuUuidNumber());
                            }
                            return R.error(511,"数据库的该表中的 [运单号] 字段已经存在 存在数据为:"+repeatFields.toString());
                        }
                        chengyunrenwuService.insertBatch(chengyunrenwuList);
                        return R.ok();
                    }
                }
            }
        }catch (Exception e){
            return R.error(511,"批量插入数据异常，请联系管理员");
        }
    }






}
