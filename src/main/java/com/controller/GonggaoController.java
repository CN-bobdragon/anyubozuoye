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
 * @ClassName GonggaoController
 * @Description 公告模块控制层
 */
@Controller
public class GonggaoController extends BaseController{

    @Autowired
    private GonggaoService gonggaoService;




    //前台-公告列表页
    @RequestMapping("/gonggaoManaQian")
    public ModelAndView gonggaoManaQian(Gonggao req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("gonggaoManaQian");
        mav.addObject("actionName","gonggaoManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-公告图片列表页
    @RequestMapping("/gonggaoManaQiantp")
    public ModelAndView gonggaoManaQiantp(Gonggao req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("gonggaoManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-公告管理列表页
    @RequestMapping("/gonggaoMana")
    public ModelAndView gonggaoMana(Gonggao req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("gonggaoMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-公告查看列表页
    @RequestMapping("/gonggaoChakan")
    public ModelAndView gonggaoChakan(Gonggao req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("gonggaoChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-公告按id列排序列表页
    @RequestMapping("/gonggaoManaQianSort")
    public ModelAndView gonggaoManaQianSort(Gonggao  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("gonggaoManaQian");
        mav.addObject("actionName","gonggaoManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-公告详情页
    @GetMapping("/gonggaoDetailQian/{id}")
    @ResponseBody
    public ModelAndView gonggaoDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("gonggaoDetailQian");
        Gonggao info= gonggaoService.findById(id);
        mav.addObject("gonggao", info);

        return mav;
    }

    //后台-公告详情页
    @GetMapping("/gonggaoDetail/{id}")
    @ResponseBody
    public ModelAndView gonggaoDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("gonggaoDetail");
        Gonggao info= gonggaoService.findById(id);
        mav.addObject("gonggao", info);
        return mav;
    }

    //获取所有公告数据接口
    @RequestMapping("/gonggaoAll")
    @ResponseBody
    public ApiResponse<Gonggao> gonggaoAll(){
        List<Gonggao> gonggaoList=gonggaoService.findAll();
        return ApiResponse.success(gonggaoList);
    }

    //根据条件（字符类型模糊匹配查询）获取公告数据接口
    @RequestMapping("/gonggaoSearch")
    @ResponseBody
    public ApiResponse<Gonggao> gonggaoSearch(Gonggao req){
        List<Gonggao> gonggaoList=gonggaoService.find(req);
        return ApiResponse.success(gonggaoList);
    }

    //根据条件（字符类型完全匹配查询）获取公告数据接口
    @RequestMapping("/gonggaoSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Gonggao> gonggaoSearchByEqualTo(Gonggao req){
        List<Gonggao> gonggaoList=gonggaoService.findByEqualTo(req);
        return ApiResponse.success(gonggaoList);
    }

    //公告添加或修改接口
    @PostMapping("/gonggaoAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> gonggaoAddOrUpdate(@RequestBody Gonggao req, HttpSession session, Boolean isUPdateSession){



        int result = gonggaoService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //后台-公告添加接口
    @PostMapping("/gonggaoAdd")
    @ResponseBody
    public ApiResponse<Integer> gonggaoAdd(@RequestBody Gonggao req, HttpSession session, Boolean isUPdateSession){



        int result = gonggaoService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //前台-公告添加接口
    @PostMapping("/gonggaoAddQian")
    @ResponseBody
    public ApiResponse<Integer> gonggaoAddQian(@RequestBody Gonggao req, HttpSession session, Boolean isUPdateSession){



        int result = gonggaoService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //公告修改单独一个字段接口
    @PostMapping("/gonggaoSet")
    @ResponseBody
    public ApiResponse<Integer> gonggaoSet(Gonggao req){
        int result = gonggaoService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //公告删除接口
    @RequestMapping("/gonggaoDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> gonggaoDel(@PathVariable Integer id){
        int result = gonggaoService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-公告修改页
    @RequestMapping("/gonggaoGet/{id}")
    @ResponseBody
    public ModelAndView gonggaoGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("gonggaoSet");
        Gonggao info = gonggaoService.findById(id);
        mav.addObject("gonggao", info);
        return mav;
    }

    //根据字段分组获取公告表count统计数据接口
    @RequestMapping("/gonggao/selectCountGroup/{columnName}")
    @ResponseBody
    public ApiResponse selectCountGroup(@PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        List<Map<String, Object>> result = gonggaoService.selectCountGroup(params);
        return ApiResponse.success(result);
        }

    //根据字段分组获取公告表按另一字段sum求和数据接口
    @RequestMapping("/gonggao/selectSumGroup/{xColumnName}/{yColumnName}")
    @ResponseBody
    public ApiResponse selectSumGroup(@PathVariable("xColumnName") String xColumnName,@PathVariable("yColumnName") String yColumnName){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        List<Map<String, Object>> result = gonggaoService.selectSumGroup(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取公告表count统计数据接口
    @RequestMapping("/gonggao/selectCountGroupByDate/{columnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectCountGroupByDate(@PathVariable("columnName") String columnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = gonggaoService.selectCountGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取公告表按另一字段sum求和数据接口
    @RequestMapping("/gonggao/selectSumGroupByDate/{xColumnName}/{yColumnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectSumGroupByDate(@PathVariable("xColumnName") String xColumnName, @PathVariable("yColumnName") String yColumnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = gonggaoService.selectSumGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取公告表count统计数据接口
    @RequestMapping("/gonggao/selectCountGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}")
    @ResponseBody
    public ApiResponse selectCountGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        List<Map<String, Object>> result = gonggaoService.selectCountGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取公告表按另一字段sum求和数据接口
    @RequestMapping("/gonggao/selectSumGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}/{columnName}")
    @ResponseBody
    public ApiResponse selectSumGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn, @PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        params.put("column", columnName);
        List<Map<String, Object>> result = gonggaoService.selectSumGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //公告数据导出Excel接口
    @RequestMapping("/gonggaoExportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Gonggao> gonggaoList = gonggaoService.findAll();

        String[] headerCellList = {"id", "标题","内容","图片","时间"};
        //excel表头为上面定义的字段注释
        Workbook wb = ExcelUtil.createWorkbook("公告表", headerCellList, gonggaoList, Gonggao.class);
        //注释掉上面一行，解开下面这一行则表示excel表头为字段名称
//        Workbook wb=ExcelUtil.createWorkbook("公告表",null,gonggaoList,Gonggao.class);

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=gonggaoExport.xlsx");

        // 输出Excel文件到响应流
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
    }







    //公告模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Gonggao req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Gonggao> pageWrap=new PageWrap<Gonggao>();
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
        PageData<Gonggao> pageInfo= gonggaoService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
    }

    //公告完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Gonggao req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Gonggao> pageWrap=new PageWrap<Gonggao>();
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
        PageData<Gonggao> pageInfo= gonggaoService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
        }
}
