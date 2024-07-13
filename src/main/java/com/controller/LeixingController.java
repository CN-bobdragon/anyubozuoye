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
 * @ClassName LeixingController
 * @Description 类型模块控制层
 */
@Controller
public class LeixingController extends BaseController{

    @Autowired
    private LeixingService leixingService;




    //前台-类型列表页
    @RequestMapping("/leixingManaQian")
    public ModelAndView leixingManaQian(Leixing req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("leixingManaQian");
        mav.addObject("actionName","leixingManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-类型图片列表页
    @RequestMapping("/leixingManaQiantp")
    public ModelAndView leixingManaQiantp(Leixing req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("leixingManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-类型管理列表页
    @RequestMapping("/leixingMana")
    public ModelAndView leixingMana(Leixing req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("leixingMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-类型查看列表页
    @RequestMapping("/leixingChakan")
    public ModelAndView leixingChakan(Leixing req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("leixingChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-类型按id列排序列表页
    @RequestMapping("/leixingManaQianSort")
    public ModelAndView leixingManaQianSort(Leixing  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("leixingManaQian");
        mav.addObject("actionName","leixingManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-类型详情页
    @GetMapping("/leixingDetailQian/{id}")
    @ResponseBody
    public ModelAndView leixingDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("leixingDetailQian");
        Leixing info= leixingService.findById(id);
        mav.addObject("leixing", info);

        return mav;
    }

    //后台-类型详情页
    @GetMapping("/leixingDetail/{id}")
    @ResponseBody
    public ModelAndView leixingDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("leixingDetail");
        Leixing info= leixingService.findById(id);
        mav.addObject("leixing", info);
        return mav;
    }

    //获取所有类型数据接口
    @RequestMapping("/leixingAll")
    @ResponseBody
    public ApiResponse<Leixing> leixingAll(){
        List<Leixing> leixingList=leixingService.findAll();
        return ApiResponse.success(leixingList);
    }

    //根据条件（字符类型模糊匹配查询）获取类型数据接口
    @RequestMapping("/leixingSearch")
    @ResponseBody
    public ApiResponse<Leixing> leixingSearch(Leixing req){
        List<Leixing> leixingList=leixingService.find(req);
        return ApiResponse.success(leixingList);
    }

    //根据条件（字符类型完全匹配查询）获取类型数据接口
    @RequestMapping("/leixingSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Leixing> leixingSearchByEqualTo(Leixing req){
        List<Leixing> leixingList=leixingService.findByEqualTo(req);
        return ApiResponse.success(leixingList);
    }

    //类型添加或修改接口
    @PostMapping("/leixingAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> leixingAddOrUpdate(@RequestBody Leixing req, HttpSession session, Boolean isUPdateSession){



        int result = leixingService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //后台-类型添加接口
    @PostMapping("/leixingAdd")
    @ResponseBody
    public ApiResponse<Integer> leixingAdd(@RequestBody Leixing req, HttpSession session, Boolean isUPdateSession){



        int result = leixingService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //前台-类型添加接口
    @PostMapping("/leixingAddQian")
    @ResponseBody
    public ApiResponse<Integer> leixingAddQian(@RequestBody Leixing req, HttpSession session, Boolean isUPdateSession){



        int result = leixingService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //类型修改单独一个字段接口
    @PostMapping("/leixingSet")
    @ResponseBody
    public ApiResponse<Integer> leixingSet(Leixing req){
        int result = leixingService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //类型删除接口
    @RequestMapping("/leixingDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> leixingDel(@PathVariable Integer id){
        int result = leixingService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-类型修改页
    @RequestMapping("/leixingGet/{id}")
    @ResponseBody
    public ModelAndView leixingGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("leixingSet");
        Leixing info = leixingService.findById(id);
        mav.addObject("leixing", info);
        return mav;
    }

    //根据字段分组获取类型表count统计数据接口
    @RequestMapping("/leixing/selectCountGroup/{columnName}")
    @ResponseBody
    public ApiResponse selectCountGroup(@PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        List<Map<String, Object>> result = leixingService.selectCountGroup(params);
        return ApiResponse.success(result);
        }

    //根据字段分组获取类型表按另一字段sum求和数据接口
    @RequestMapping("/leixing/selectSumGroup/{xColumnName}/{yColumnName}")
    @ResponseBody
    public ApiResponse selectSumGroup(@PathVariable("xColumnName") String xColumnName,@PathVariable("yColumnName") String yColumnName){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        List<Map<String, Object>> result = leixingService.selectSumGroup(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取类型表count统计数据接口
    @RequestMapping("/leixing/selectCountGroupByDate/{columnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectCountGroupByDate(@PathVariable("columnName") String columnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = leixingService.selectCountGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取类型表按另一字段sum求和数据接口
    @RequestMapping("/leixing/selectSumGroupByDate/{xColumnName}/{yColumnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectSumGroupByDate(@PathVariable("xColumnName") String xColumnName, @PathVariable("yColumnName") String yColumnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = leixingService.selectSumGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取类型表count统计数据接口
    @RequestMapping("/leixing/selectCountGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}")
    @ResponseBody
    public ApiResponse selectCountGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        List<Map<String, Object>> result = leixingService.selectCountGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取类型表按另一字段sum求和数据接口
    @RequestMapping("/leixing/selectSumGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}/{columnName}")
    @ResponseBody
    public ApiResponse selectSumGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn, @PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        params.put("column", columnName);
        List<Map<String, Object>> result = leixingService.selectSumGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //类型数据导出Excel接口
    @RequestMapping("/leixingExportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Leixing> leixingList = leixingService.findAll();

        String[] headerCellList = {"id", "名称"};
        //excel表头为上面定义的字段注释
        Workbook wb = ExcelUtil.createWorkbook("类型表", headerCellList, leixingList, Leixing.class);
        //注释掉上面一行，解开下面这一行则表示excel表头为字段名称
//        Workbook wb=ExcelUtil.createWorkbook("类型表",null,leixingList,Leixing.class);

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=leixingExport.xlsx");

        // 输出Excel文件到响应流
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
    }







    //类型模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Leixing req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Leixing> pageWrap=new PageWrap<Leixing>();
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
        PageData<Leixing> pageInfo= leixingService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
    }

    //类型完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Leixing req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Leixing> pageWrap=new PageWrap<Leixing>();
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
        PageData<Leixing> pageInfo= leixingService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
        }
}
