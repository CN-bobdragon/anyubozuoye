package com.controller;

import com.entity.*;
import com.service.*;
import com.util.*;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.OutputStream;
import java.util.*;

/**
 * @ClassName DxController
 * @Description 介绍模块控制层
 */
@Controller
public class DxController extends BaseController{

    @Autowired
    private DxService dxService;




    //前台-介绍列表页
    @RequestMapping("/dxManaQian")
    public ModelAndView dxManaQian(Dx req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("dxManaQian");
        mav.addObject("actionName","dxManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-介绍图片列表页
    @RequestMapping("/dxManaQiantp")
    public ModelAndView dxManaQiantp(Dx req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("dxManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-介绍管理列表页
    @RequestMapping("/dxMana")
    public ModelAndView dxMana(Dx req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("dxMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-介绍查看列表页
    @RequestMapping("/dxChakan")
    public ModelAndView dxChakan(Dx req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("dxChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-介绍按id列排序列表页
    @RequestMapping("/dxManaQianSort")
    public ModelAndView dxManaQianSort(Dx  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("dxManaQian");
        mav.addObject("actionName","dxManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-介绍详情页
    @GetMapping("/dxDetailQian/{id}")
    @ResponseBody
    public ModelAndView dxDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("dxDetailQian");
        Dx info= dxService.findById(id);
        mav.addObject("dx", info);

        return mav;
    }

    //后台-介绍详情页
    @GetMapping("/dxDetail/{id}")
    @ResponseBody
    public ModelAndView dxDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("dxDetail");
        Dx info= dxService.findById(id);
        mav.addObject("dx", info);
        return mav;
    }

    //获取所有介绍数据接口
    @RequestMapping("/dxAll")
    @ResponseBody
    public ApiResponse<Dx> dxAll(){
        List<Dx> dxList=dxService.findAll();
        return ApiResponse.success(dxList);
    }

    //根据条件（字符类型模糊匹配查询）获取介绍数据接口
    @RequestMapping("/dxSearch")
    @ResponseBody
    public ApiResponse<Dx> dxSearch(Dx req){
        List<Dx> dxList=dxService.find(req);
        return ApiResponse.success(dxList);
    }

    //根据条件（字符类型完全匹配查询）获取介绍数据接口
    @RequestMapping("/dxSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Dx> dxSearchByEqualTo(Dx req){
        List<Dx> dxList=dxService.findByEqualTo(req);
        return ApiResponse.success(dxList);
    }

    //介绍添加或修改接口
    @PostMapping("/dxAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> dxAddOrUpdate(@RequestBody Dx req, HttpSession session, Boolean isUPdateSession){



        int result = dxService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //后台-介绍添加接口
    @PostMapping("/dxAdd")
    @ResponseBody
    public ApiResponse<Integer> dxAdd(@RequestBody Dx req, HttpSession session, Boolean isUPdateSession){



        int result = dxService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //前台-介绍添加接口
    @PostMapping("/dxAddQian")
    @ResponseBody
    public ApiResponse<Integer> dxAddQian(@RequestBody Dx req, HttpSession session, Boolean isUPdateSession){



        int result = dxService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //介绍修改单独一个字段接口
    @PostMapping("/dxSet")
    @ResponseBody
    public ApiResponse<Integer> dxSet(Dx req){
        int result = dxService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //介绍删除接口
    @RequestMapping("/dxDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> dxDel(@PathVariable Integer id){
        int result = dxService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-介绍修改页
    @RequestMapping("/dxGet/{id}")
    @ResponseBody
    public ModelAndView dxGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("dxSet");
        Dx info = dxService.findById(id);
        mav.addObject("dx", info);
        return mav;
    }

    //根据字段分组获取介绍表count统计数据接口
    @RequestMapping("/dx/selectCountGroup/{columnName}")
    @ResponseBody
    public ApiResponse selectCountGroup(@PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        List<Map<String, Object>> result = dxService.selectCountGroup(params);
        return ApiResponse.success(result);
        }

    //根据字段分组获取介绍表按另一字段sum求和数据接口
    @RequestMapping("/dx/selectSumGroup/{xColumnName}/{yColumnName}")
    @ResponseBody
    public ApiResponse selectSumGroup(@PathVariable("xColumnName") String xColumnName,@PathVariable("yColumnName") String yColumnName){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        List<Map<String, Object>> result = dxService.selectSumGroup(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取介绍表count统计数据接口
    @RequestMapping("/dx/selectCountGroupByDate/{columnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectCountGroupByDate(@PathVariable("columnName") String columnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = dxService.selectCountGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取介绍表按另一字段sum求和数据接口
    @RequestMapping("/dx/selectSumGroupByDate/{xColumnName}/{yColumnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectSumGroupByDate(@PathVariable("xColumnName") String xColumnName, @PathVariable("yColumnName") String yColumnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = dxService.selectSumGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取介绍表count统计数据接口
    @RequestMapping("/dx/selectCountGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}")
    @ResponseBody
    public ApiResponse selectCountGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        List<Map<String, Object>> result = dxService.selectCountGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取介绍表按另一字段sum求和数据接口
    @RequestMapping("/dx/selectSumGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}/{columnName}")
    @ResponseBody
    public ApiResponse selectSumGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn, @PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        params.put("column", columnName);
        List<Map<String, Object>> result = dxService.selectSumGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //介绍数据导出Excel接口
    @RequestMapping("/dxExportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Dx> dxList = dxService.findAll();

        String[] headerCellList = {"id", "类别","内容","时间"};
        //excel表头为上面定义的字段注释
        Workbook wb = ExcelUtil.createWorkbook("介绍表", headerCellList, dxList, Dx.class);
        //注释掉上面一行，解开下面这一行则表示excel表头为字段名称
//        Workbook wb=ExcelUtil.createWorkbook("介绍表",null,dxList,Dx.class);

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=dxExport.xlsx");

        // 输出Excel文件到响应流
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
    }







    //介绍模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Dx req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Dx> pageWrap=new PageWrap<Dx>();
        pageWrap.setModel(req);
        pageWrap.setPageNum(pageNo);
        //设置每页最多几条数据，默认为8条
        //pageWrap.setPageSize(8);
        PageWrap.SortData sortData=new PageWrap.SortData();
        sortData.setDirection("DESC");
        sortData.setProperty(sortProperty);
        List<PageWrap.SortData> sorts = new ArrayList<>();
        sorts.add(sortData);
        pageWrap.setSorts(sorts);
        PageData<Dx> pageInfo= dxService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
    }

    //介绍完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Dx req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Dx> pageWrap=new PageWrap<Dx>();
        pageWrap.setModel(req);
        pageWrap.setPageNum(pageNo);
        //设置每页最多几条数据，默认为8条
        //pageWrap.setPageSize(8);
        PageWrap.SortData sortData=new PageWrap.SortData();
        sortData.setDirection("DESC");
        sortData.setProperty(sortProperty);
        List<PageWrap.SortData> sorts = new ArrayList<>();
        sorts.add(sortData);
        pageWrap.setSorts(sorts);
        PageData<Dx> pageInfo= dxService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
        }
}
