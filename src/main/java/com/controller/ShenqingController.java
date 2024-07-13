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
 * @ClassName ShenqingController
 * @Description 申请模块控制层
 */
@Controller
public class ShenqingController extends BaseController{

    @Autowired
    private ShenqingService shenqingService;

    @Autowired
    private XiaozuService xiaozuService;
    @Autowired
    private UsersService usersService;



    //前台-申请列表页
    @RequestMapping("/shenqingManaQian")
    public ModelAndView shenqingManaQian(Shenqing req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("shenqingManaQian");
        mav.addObject("actionName","shenqingManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-申请图片列表页
    @RequestMapping("/shenqingManaQiantp")
    public ModelAndView shenqingManaQiantp(Shenqing req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("shenqingManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-申请管理列表页
    @RequestMapping("/shenqingMana")
    public ModelAndView shenqingMana(Shenqing req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("shenqingMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-申请查看列表页
    @RequestMapping("/shenqingChakan")
    public ModelAndView shenqingChakan(Shenqing req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("shenqingChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-申请按id列排序列表页
    @RequestMapping("/shenqingManaQianSort")
    public ModelAndView shenqingManaQianSort(Shenqing  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("shenqingManaQian");
        mav.addObject("actionName","shenqingManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-申请详情页
    @GetMapping("/shenqingDetailQian/{id}")
    @ResponseBody
    public ModelAndView shenqingDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("shenqingDetailQian");
        Shenqing info= shenqingService.findById(id);
        mav.addObject("shenqing", info);

        return mav;
    }

    //后台-申请详情页
    @GetMapping("/shenqingDetail/{id}")
    @ResponseBody
    public ModelAndView shenqingDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("shenqingDetail");
        Shenqing info= shenqingService.findById(id);
        mav.addObject("shenqing", info);
        return mav;
    }

    //获取所有申请数据接口
    @RequestMapping("/shenqingAll")
    @ResponseBody
    public ApiResponse<Shenqing> shenqingAll(){
        List<Shenqing> shenqingList=shenqingService.findAll();
        return ApiResponse.success(shenqingList);
    }

    //根据条件（字符类型模糊匹配查询）获取申请数据接口
    @RequestMapping("/shenqingSearch")
    @ResponseBody
    public ApiResponse<Shenqing> shenqingSearch(Shenqing req){
        List<Shenqing> shenqingList=shenqingService.find(req);
        return ApiResponse.success(shenqingList);
    }

    //根据条件（字符类型完全匹配查询）获取申请数据接口
    @RequestMapping("/shenqingSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Shenqing> shenqingSearchByEqualTo(Shenqing req){
        List<Shenqing> shenqingList=shenqingService.findByEqualTo(req);
        return ApiResponse.success(shenqingList);
    }

    //申请添加或修改接口
    @PostMapping("/shenqingAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> shenqingAddOrUpdate(@RequestBody Shenqing req, HttpSession session, Boolean isUPdateSession){



        int result = shenqingService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //后台-申请添加接口
    @PostMapping("/shenqingAdd")
    @ResponseBody
    public ApiResponse<Integer> shenqingAdd(@RequestBody Shenqing req, HttpSession session, Boolean isUPdateSession){



        int result = shenqingService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //前台-申请添加接口
    @PostMapping("/shenqingAddQian")
    @ResponseBody
    public ApiResponse<Integer> shenqingAddQian(@RequestBody Shenqing req, HttpSession session, Boolean isUPdateSession){



        int result = shenqingService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //申请修改单独一个字段接口
    @PostMapping("/shenqingSet")
    @ResponseBody
    public ApiResponse<Integer> shenqingSet(Shenqing req){
        int result = shenqingService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //申请删除接口
    @RequestMapping("/shenqingDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> shenqingDel(@PathVariable Integer id){
        int result = shenqingService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-申请修改页
    @RequestMapping("/shenqingGet/{id}")
    @ResponseBody
    public ModelAndView shenqingGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("shenqingSet");
        Shenqing info = shenqingService.findById(id);
        mav.addObject("shenqing", info);
        return mav;
    }

    //根据字段分组获取申请表count统计数据接口
    @RequestMapping("/shenqing/selectCountGroup/{columnName}")
    @ResponseBody
    public ApiResponse selectCountGroup(@PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        List<Map<String, Object>> result = shenqingService.selectCountGroup(params);
        return ApiResponse.success(result);
        }

    //根据字段分组获取申请表按另一字段sum求和数据接口
    @RequestMapping("/shenqing/selectSumGroup/{xColumnName}/{yColumnName}")
    @ResponseBody
    public ApiResponse selectSumGroup(@PathVariable("xColumnName") String xColumnName,@PathVariable("yColumnName") String yColumnName){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        List<Map<String, Object>> result = shenqingService.selectSumGroup(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取申请表count统计数据接口
    @RequestMapping("/shenqing/selectCountGroupByDate/{columnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectCountGroupByDate(@PathVariable("columnName") String columnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = shenqingService.selectCountGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取申请表按另一字段sum求和数据接口
    @RequestMapping("/shenqing/selectSumGroupByDate/{xColumnName}/{yColumnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectSumGroupByDate(@PathVariable("xColumnName") String xColumnName, @PathVariable("yColumnName") String yColumnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = shenqingService.selectSumGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取申请表count统计数据接口
    @RequestMapping("/shenqing/selectCountGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}")
    @ResponseBody
    public ApiResponse selectCountGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        List<Map<String, Object>> result = shenqingService.selectCountGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取申请表按另一字段sum求和数据接口
    @RequestMapping("/shenqing/selectSumGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}/{columnName}")
    @ResponseBody
    public ApiResponse selectSumGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn, @PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        params.put("column", columnName);
        List<Map<String, Object>> result = shenqingService.selectSumGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //申请数据导出Excel接口
    @RequestMapping("/shenqingExportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Shenqing> shenqingList = shenqingService.findAll();

        String[] headerCellList = {"id", "小组id","内容","用户id","申请"};
        //excel表头为上面定义的字段注释
        Workbook wb = ExcelUtil.createWorkbook("申请表", headerCellList, shenqingList, Shenqing.class);
        //注释掉上面一行，解开下面这一行则表示excel表头为字段名称
//        Workbook wb=ExcelUtil.createWorkbook("申请表",null,shenqingList,Shenqing.class);

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=shenqingExport.xlsx");

        // 输出Excel文件到响应流
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
    }



    //后台-我的申请查看页面
    @RequestMapping("/shenqingChakanMy")
    public ModelAndView shenqingChakanMy(Shenqing req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("shenqingChakanMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //后台-我的申请管理列表页面
    @RequestMapping("/shenqingManaMy")
    public ModelAndView shenqingManaMy(Shenqing req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("shenqingManaMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //前台-我的申请管理列表页面
    @RequestMapping("/shenqingManaMyQian")
    public ModelAndView shenqingManaMyQian(Shenqing req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("shenqingManaMyQian");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }


    //前台-小组添加申请页面
    @GetMapping("/xiaozushenqingAddQian/{xiaozuid}")
    @ResponseBody
    public ModelAndView xiaozushenqingAddQian(@PathVariable Integer xiaozuid){
        ModelAndView mav = getXiaozuShenqingAddModelAndView(xiaozuid,"xiaozushenqingAddQian");
        return mav;
    }

    //后台-小组添加申请页面
    @GetMapping("/xiaozushenqingAdd/{xiaozuid}")
    @ResponseBody
    public ModelAndView xiaozushenqingAdd(@PathVariable Integer xiaozuid){
        ModelAndView mav = getXiaozuShenqingAddModelAndView(xiaozuid,"xiaozushenqingAdd");
        return mav;
    }

    //后台-小组申请查看页面
    @RequestMapping("/xiaozushenqingGetByxiaozuid/{xiaozuid}")
    @ResponseBody
    public ModelAndView xiaozushenqingGetByxiaozuid(Shenqing req, @PathVariable Integer xiaozuid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("xiaozushenqingChakan");
        req.setXiaozuid(xiaozuid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-小组申请查看页面
    @RequestMapping("/xiaozushenqingGetByxiaozuidQian/{xiaozuid}")
    @ResponseBody
    public ModelAndView xiaozushenqingGetByxiaozuidQian(Shenqing req, @PathVariable Integer xiaozuid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("shenqingManaQian");
            mav.addObject("actionName","shenqingManaQian");
        req.setXiaozuid(xiaozuid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //小组申请数据封装
    private ModelAndView getXiaozuShenqingAddModelAndView(Integer xiaozuid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Xiaozu xiaozu=xiaozuService.findById(xiaozuid);
        mav.addObject("xiaozu", xiaozu);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }
    //前台-用户添加申请页面
    @GetMapping("/usersshenqingAddQian/{usersid}")
    @ResponseBody
    public ModelAndView usersshenqingAddQian(@PathVariable Integer usersid){
        ModelAndView mav = getUsersShenqingAddModelAndView(usersid,"usersshenqingAddQian");
        return mav;
    }

    //后台-用户添加申请页面
    @GetMapping("/usersshenqingAdd/{usersid}")
    @ResponseBody
    public ModelAndView usersshenqingAdd(@PathVariable Integer usersid){
        ModelAndView mav = getUsersShenqingAddModelAndView(usersid,"usersshenqingAdd");
        return mav;
    }

    //后台-用户申请查看页面
    @RequestMapping("/usersshenqingGetByusersid/{usersid}")
    @ResponseBody
    public ModelAndView usersshenqingGetByusersid(Shenqing req, @PathVariable Integer usersid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("usersshenqingChakan");
        req.setUsersid(usersid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-用户申请查看页面
    @RequestMapping("/usersshenqingGetByusersidQian/{usersid}")
    @ResponseBody
    public ModelAndView usersshenqingGetByusersidQian(Shenqing req, @PathVariable Integer usersid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("shenqingManaQian");
            mav.addObject("actionName","shenqingManaQian");
        req.setUsersid(usersid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //用户申请数据封装
    private ModelAndView getUsersShenqingAddModelAndView(Integer usersid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Users users=usersService.findById(usersid);
        mav.addObject("users", users);
        List<Xiaozu> xiaozuList=xiaozuService.findAll();
        mav.addObject("xiaozuList", xiaozuList);

        return mav;
    }


    //申请模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Shenqing req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Shenqing> pageWrap=new PageWrap<Shenqing>();
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
        PageData<Shenqing> pageInfo= shenqingService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Xiaozu> xiaozuList=xiaozuService.findAll();
        mav.addObject("xiaozuList", xiaozuList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }

    //申请完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Shenqing req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Shenqing> pageWrap=new PageWrap<Shenqing>();
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
        PageData<Shenqing> pageInfo= shenqingService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Xiaozu> xiaozuList=xiaozuService.findAll();
        mav.addObject("xiaozuList", xiaozuList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
        }
}
