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
 * @ClassName LunboController
 * @Description 轮播图模块控制层
 */
@Controller
public class LunboController extends BaseController{

    @Autowired
    private LunboService lunboService;




    //前台-轮播图列表页
    @RequestMapping("/lunboManaQian")
    public ModelAndView lunboManaQian(Lunbo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lunboManaQian");
        mav.addObject("actionName","lunboManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-轮播图图片列表页
    @RequestMapping("/lunboManaQiantp")
    public ModelAndView lunboManaQiantp(Lunbo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lunboManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-轮播图管理列表页
    @RequestMapping("/lunboMana")
    public ModelAndView lunboMana(Lunbo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lunboMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-轮播图查看列表页
    @RequestMapping("/lunboChakan")
    public ModelAndView lunboChakan(Lunbo req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("lunboChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-轮播图按id列排序列表页
    @RequestMapping("/lunboManaQianSort")
    public ModelAndView lunboManaQianSort(Lunbo  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("lunboManaQian");
        mav.addObject("actionName","lunboManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-轮播图详情页
    @GetMapping("/lunboDetailQian/{id}")
    @ResponseBody
    public ModelAndView lunboDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("lunboDetailQian");
        Lunbo info= lunboService.findById(id);
        mav.addObject("lunbo", info);

        return mav;
    }

    //后台-轮播图详情页
    @GetMapping("/lunboDetail/{id}")
    @ResponseBody
    public ModelAndView lunboDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("lunboDetail");
        Lunbo info= lunboService.findById(id);
        mav.addObject("lunbo", info);
        return mav;
    }

    //获取所有轮播图数据接口
    @RequestMapping("/lunboAll")
    @ResponseBody
    public ApiResponse<Lunbo> lunboAll(){
        List<Lunbo> lunboList=lunboService.findAll();
        return ApiResponse.success(lunboList);
    }

    //根据条件（字符类型模糊匹配查询）获取轮播图数据接口
    @RequestMapping("/lunboSearch")
    @ResponseBody
    public ApiResponse<Lunbo> lunboSearch(Lunbo req){
        List<Lunbo> lunboList=lunboService.find(req);
        return ApiResponse.success(lunboList);
    }

    //根据条件（字符类型完全匹配查询）获取轮播图数据接口
    @RequestMapping("/lunboSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Lunbo> lunboSearchByEqualTo(Lunbo req){
        List<Lunbo> lunboList=lunboService.findByEqualTo(req);
        return ApiResponse.success(lunboList);
    }

    //轮播图添加或修改接口
    @PostMapping("/lunboAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> lunboAddOrUpdate(@RequestBody Lunbo req, HttpSession session, Boolean isUPdateSession){



        int result = lunboService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //后台-轮播图添加接口
    @PostMapping("/lunboAdd")
    @ResponseBody
    public ApiResponse<Integer> lunboAdd(@RequestBody Lunbo req, HttpSession session, Boolean isUPdateSession){



        int result = lunboService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //前台-轮播图添加接口
    @PostMapping("/lunboAddQian")
    @ResponseBody
    public ApiResponse<Integer> lunboAddQian(@RequestBody Lunbo req, HttpSession session, Boolean isUPdateSession){



        int result = lunboService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //轮播图修改单独一个字段接口
    @PostMapping("/lunboSet")
    @ResponseBody
    public ApiResponse<Integer> lunboSet(Lunbo req){
        int result = lunboService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //轮播图删除接口
    @RequestMapping("/lunboDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> lunboDel(@PathVariable Integer id){
        int result = lunboService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-轮播图修改页
    @RequestMapping("/lunboGet/{id}")
    @ResponseBody
    public ModelAndView lunboGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("lunboSet");
        Lunbo info = lunboService.findById(id);
        mav.addObject("lunbo", info);
        return mav;
    }

    //根据字段分组获取轮播图表count统计数据接口
    @RequestMapping("/lunbo/selectCountGroup/{columnName}")
    @ResponseBody
    public ApiResponse selectCountGroup(@PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        List<Map<String, Object>> result = lunboService.selectCountGroup(params);
        return ApiResponse.success(result);
        }

    //根据字段分组获取轮播图表按另一字段sum求和数据接口
    @RequestMapping("/lunbo/selectSumGroup/{xColumnName}/{yColumnName}")
    @ResponseBody
    public ApiResponse selectSumGroup(@PathVariable("xColumnName") String xColumnName,@PathVariable("yColumnName") String yColumnName){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        List<Map<String, Object>> result = lunboService.selectSumGroup(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取轮播图表count统计数据接口
    @RequestMapping("/lunbo/selectCountGroupByDate/{columnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectCountGroupByDate(@PathVariable("columnName") String columnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = lunboService.selectCountGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取轮播图表按另一字段sum求和数据接口
    @RequestMapping("/lunbo/selectSumGroupByDate/{xColumnName}/{yColumnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectSumGroupByDate(@PathVariable("xColumnName") String xColumnName, @PathVariable("yColumnName") String yColumnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = lunboService.selectSumGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取轮播图表count统计数据接口
    @RequestMapping("/lunbo/selectCountGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}")
    @ResponseBody
    public ApiResponse selectCountGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        List<Map<String, Object>> result = lunboService.selectCountGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取轮播图表按另一字段sum求和数据接口
    @RequestMapping("/lunbo/selectSumGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}/{columnName}")
    @ResponseBody
    public ApiResponse selectSumGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn, @PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        params.put("column", columnName);
        List<Map<String, Object>> result = lunboService.selectSumGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //轮播图数据导出Excel接口
    @RequestMapping("/lunboExportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Lunbo> lunboList = lunboService.findAll();

        String[] headerCellList = {"id", "标题","图片"};
        //excel表头为上面定义的字段注释
        Workbook wb = ExcelUtil.createWorkbook("轮播图表", headerCellList, lunboList, Lunbo.class);
        //注释掉上面一行，解开下面这一行则表示excel表头为字段名称
//        Workbook wb=ExcelUtil.createWorkbook("轮播图表",null,lunboList,Lunbo.class);

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=lunboExport.xlsx");

        // 输出Excel文件到响应流
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
    }







    //轮播图模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Lunbo req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Lunbo> pageWrap=new PageWrap<Lunbo>();
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
        PageData<Lunbo> pageInfo= lunboService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
    }

    //轮播图完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Lunbo req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Lunbo> pageWrap=new PageWrap<Lunbo>();
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
        PageData<Lunbo> pageInfo= lunboService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);

        return mav;
        }
}
