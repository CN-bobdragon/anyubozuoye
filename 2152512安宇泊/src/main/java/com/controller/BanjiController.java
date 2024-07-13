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
 * @ClassName BanjiController
 * @Description 班级模块控制层
 */
@Controller
public class BanjiController extends BaseController{

    @Autowired
    private BanjiService banjiService;




    //前台-班级列表页
    @RequestMapping("/banjiManaQian")
    public ModelAndView banjiManaQian(Banji req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("banjiManaQian");
        mav.addObject("actionName","banjiManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-班级图片列表页
    @RequestMapping("/banjiManaQiantp")
    public ModelAndView banjiManaQiantp(Banji req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("banjiManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-班级管理列表页
    @RequestMapping("/banjiMana")
    public ModelAndView banjiMana(Banji req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("banjiMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-班级查看列表页
    @RequestMapping("/banjiChakan")
    public ModelAndView banjiChakan(Banji req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("banjiChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-班级按id列排序列表页
    @RequestMapping("/banjiManaQianSort")
    public ModelAndView banjiManaQianSort(Banji  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("banjiManaQian");
        mav.addObject("actionName","banjiManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-班级详情页
    @GetMapping("/banjiDetailQian/{id}")
    @ResponseBody
    public ModelAndView banjiDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("banjiDetailQian");
        Banji info= banjiService.findById(id);
        mav.addObject("banji", info);

        return mav;
    }

    //后台-班级详情页
    @GetMapping("/banjiDetail/{id}")
    @ResponseBody
    public ModelAndView banjiDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("banjiDetail");
        Banji info= banjiService.findById(id);
        mav.addObject("banji", info);
        return mav;
    }

    //获取所有班级数据接口
    @RequestMapping("/banjiAll")
    @ResponseBody
    public ApiResponse<Banji> banjiAll(){
        List<Banji> banjiList=banjiService.findAll();
        return ApiResponse.success(banjiList);
    }

    //根据条件（字符类型模糊匹配查询）获取班级数据接口
    @RequestMapping("/banjiSearch")
    @ResponseBody
    public ApiResponse<Banji> banjiSearch(Banji req){
        List<Banji> banjiList=banjiService.find(req);
        return ApiResponse.success(banjiList);
    }

    //根据条件（字符类型完全匹配查询）获取班级数据接口
    @RequestMapping("/banjiSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Banji> banjiSearchByEqualTo(Banji req){
        List<Banji> banjiList=banjiService.findByEqualTo(req);
        return ApiResponse.success(banjiList);
    }

    //班级添加或修改接口
    @PostMapping("/banjiAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> banjiAddOrUpdate(@RequestBody Banji req, HttpSession session, Boolean isUPdateSession){



        int result = banjiService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //后台-班级添加接口
    @PostMapping("/banjiAdd")
    @ResponseBody
    public ApiResponse<Integer> banjiAdd(@RequestBody Banji req, HttpSession session, Boolean isUPdateSession){



        int result = banjiService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //前台-班级添加接口
    @PostMapping("/banjiAddQian")
    @ResponseBody
    public ApiResponse<Integer> banjiAddQian(@RequestBody Banji req, HttpSession session, Boolean isUPdateSession){



        int result = banjiService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //班级修改单独一个字段接口
    @PostMapping("/banjiSet")
    @ResponseBody
    public ApiResponse<Integer> banjiSet(Banji req){
        int result = banjiService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //班级删除接口
    @RequestMapping("/banjiDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> banjiDel(@PathVariable Integer id){
        int result = banjiService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-班级修改页
    @RequestMapping("/banjiGet/{id}")
    @ResponseBody
    public ModelAndView banjiGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("banjiSet");
        Banji info = banjiService.findById(id);
        mav.addObject("banji", info);
        return mav;
    }

    //根据字段分组获取班级表count统计数据接口
    @RequestMapping("/banji/selectCountGroup/{columnName}")
    @ResponseBody
    public ApiResponse selectCountGroup(@PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        List<Map<String, Object>> result = banjiService.selectCountGroup(params);
        return ApiResponse.success(result);
        }

    //根据字段分组获取班级表按另一字段sum求和数据接口
    @RequestMapping("/banji/selectSumGroup/{xColumnName}/{yColumnName}")
    @ResponseBody
    public ApiResponse selectSumGroup(@PathVariable("xColumnName") String xColumnName,@PathVariable("yColumnName") String yColumnName){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        List<Map<String, Object>> result = banjiService.selectSumGroup(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取班级表count统计数据接口
    @RequestMapping("/banji/selectCountGroupByDate/{columnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectCountGroupByDate(@PathVariable("columnName") String columnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = banjiService.selectCountGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取班级表按另一字段sum求和数据接口
    @RequestMapping("/banji/selectSumGroupByDate/{xColumnName}/{yColumnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectSumGroupByDate(@PathVariable("xColumnName") String xColumnName, @PathVariable("yColumnName") String yColumnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = banjiService.selectSumGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取班级表count统计数据接口
    @RequestMapping("/banji/selectCountGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}")
    @ResponseBody
    public ApiResponse selectCountGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        List<Map<String, Object>> result = banjiService.selectCountGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取班级表按另一字段sum求和数据接口
    @RequestMapping("/banji/selectSumGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}/{columnName}")
    @ResponseBody
    public ApiResponse selectSumGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn, @PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        params.put("column", columnName);
        List<Map<String, Object>> result = banjiService.selectSumGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //班级数据导出Excel接口
    @RequestMapping("/banjiExportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Banji> banjiList = banjiService.findAll();

        String[] headerCellList = {"id", "名称"};
        //excel表头为上面定义的字段注释
        Workbook wb = ExcelUtil.createWorkbook("班级表", headerCellList, banjiList, Banji.class);
        //注释掉上面一行，解开下面这一行则表示excel表头为字段名称
//        Workbook wb=ExcelUtil.createWorkbook("班级表",null,banjiList,Banji.class);

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=banjiExport.xlsx");

        // 输出Excel文件到响应流
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
    }







    //班级模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Banji req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Banji> pageWrap=new PageWrap<Banji>();
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
        PageData<Banji> pageInfo= banjiService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
    }

    //班级完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Banji req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Banji> pageWrap=new PageWrap<Banji>();
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
        PageData<Banji> pageInfo= banjiService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
        }
}
