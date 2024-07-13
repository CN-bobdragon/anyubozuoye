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
 * @ClassName BaomingController
 * @Description 报名模块控制层
 */
@Controller
public class BaomingController extends BaseController{

    @Autowired
    private BaomingService baomingService;

    @Autowired
    private HuodongService huodongService;
    @Autowired
    private UsersService usersService;



    //前台-报名列表页
    @RequestMapping("/baomingManaQian")
    public ModelAndView baomingManaQian(Baoming req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("baomingManaQian");
        mav.addObject("actionName","baomingManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-报名图片列表页
    @RequestMapping("/baomingManaQiantp")
    public ModelAndView baomingManaQiantp(Baoming req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("baomingManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-报名管理列表页
    @RequestMapping("/baomingMana")
    public ModelAndView baomingMana(Baoming req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("baomingMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-报名查看列表页
    @RequestMapping("/baomingChakan")
    public ModelAndView baomingChakan(Baoming req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("baomingChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-报名按id列排序列表页
    @RequestMapping("/baomingManaQianSort")
    public ModelAndView baomingManaQianSort(Baoming  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("baomingManaQian");
        mav.addObject("actionName","baomingManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-报名详情页
    @GetMapping("/baomingDetailQian/{id}")
    @ResponseBody
    public ModelAndView baomingDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("baomingDetailQian");
        Baoming info= baomingService.findById(id);
        mav.addObject("baoming", info);

        return mav;
    }

    //后台-报名详情页
    @GetMapping("/baomingDetail/{id}")
    @ResponseBody
    public ModelAndView baomingDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("baomingDetail");
        Baoming info= baomingService.findById(id);
        mav.addObject("baoming", info);
        return mav;
    }

    //获取所有报名数据接口
    @RequestMapping("/baomingAll")
    @ResponseBody
    public ApiResponse<Baoming> baomingAll(){
        List<Baoming> baomingList=baomingService.findAll();
        return ApiResponse.success(baomingList);
    }

    //根据条件（字符类型模糊匹配查询）获取报名数据接口
    @RequestMapping("/baomingSearch")
    @ResponseBody
    public ApiResponse<Baoming> baomingSearch(Baoming req){
        List<Baoming> baomingList=baomingService.find(req);
        return ApiResponse.success(baomingList);
    }

    //根据条件（字符类型完全匹配查询）获取报名数据接口
    @RequestMapping("/baomingSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Baoming> baomingSearchByEqualTo(Baoming req){
        List<Baoming> baomingList=baomingService.findByEqualTo(req);
        return ApiResponse.success(baomingList);
    }

    //报名添加或修改接口
    @PostMapping("/baomingAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> baomingAddOrUpdate(@RequestBody Baoming req, HttpSession session, Boolean isUPdateSession){



        int result = baomingService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //后台-报名添加接口
    @PostMapping("/baomingAdd")
    @ResponseBody
    public ApiResponse<Integer> baomingAdd(@RequestBody Baoming req, HttpSession session, Boolean isUPdateSession){



        int result = baomingService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //前台-报名添加接口
    @PostMapping("/baomingAddQian")
    @ResponseBody
    public ApiResponse<Integer> baomingAddQian(@RequestBody Baoming req, HttpSession session, Boolean isUPdateSession){



        int result = baomingService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //报名修改单独一个字段接口
    @PostMapping("/baomingSet")
    @ResponseBody
    public ApiResponse<Integer> baomingSet(Baoming req){
        int result = baomingService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //报名删除接口
    @RequestMapping("/baomingDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> baomingDel(@PathVariable Integer id){
        int result = baomingService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-报名修改页
    @RequestMapping("/baomingGet/{id}")
    @ResponseBody
    public ModelAndView baomingGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("baomingSet");
        Baoming info = baomingService.findById(id);
        mav.addObject("baoming", info);
        return mav;
    }

    //根据字段分组获取报名表count统计数据接口
    @RequestMapping("/baoming/selectCountGroup/{columnName}")
    @ResponseBody
    public ApiResponse selectCountGroup(@PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        List<Map<String, Object>> result = baomingService.selectCountGroup(params);
        return ApiResponse.success(result);
        }

    //根据字段分组获取报名表按另一字段sum求和数据接口
    @RequestMapping("/baoming/selectSumGroup/{xColumnName}/{yColumnName}")
    @ResponseBody
    public ApiResponse selectSumGroup(@PathVariable("xColumnName") String xColumnName,@PathVariable("yColumnName") String yColumnName){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        List<Map<String, Object>> result = baomingService.selectSumGroup(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取报名表count统计数据接口
    @RequestMapping("/baoming/selectCountGroupByDate/{columnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectCountGroupByDate(@PathVariable("columnName") String columnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = baomingService.selectCountGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取报名表按另一字段sum求和数据接口
    @RequestMapping("/baoming/selectSumGroupByDate/{xColumnName}/{yColumnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectSumGroupByDate(@PathVariable("xColumnName") String xColumnName, @PathVariable("yColumnName") String yColumnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = baomingService.selectSumGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取报名表count统计数据接口
    @RequestMapping("/baoming/selectCountGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}")
    @ResponseBody
    public ApiResponse selectCountGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        List<Map<String, Object>> result = baomingService.selectCountGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取报名表按另一字段sum求和数据接口
    @RequestMapping("/baoming/selectSumGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}/{columnName}")
    @ResponseBody
    public ApiResponse selectSumGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn, @PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        params.put("column", columnName);
        List<Map<String, Object>> result = baomingService.selectSumGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //报名数据导出Excel接口
    @RequestMapping("/baomingExportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Baoming> baomingList = baomingService.findAll();

        String[] headerCellList = {"id", "活动id","申请原因","时间","用户id"};
        //excel表头为上面定义的字段注释
        Workbook wb = ExcelUtil.createWorkbook("报名表", headerCellList, baomingList, Baoming.class);
        //注释掉上面一行，解开下面这一行则表示excel表头为字段名称
//        Workbook wb=ExcelUtil.createWorkbook("报名表",null,baomingList,Baoming.class);

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=baomingExport.xlsx");

        // 输出Excel文件到响应流
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
    }



    //后台-我的报名查看页面
    @RequestMapping("/baomingChakanMy")
    public ModelAndView baomingChakanMy(Baoming req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("baomingChakanMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //后台-我的报名管理列表页面
    @RequestMapping("/baomingManaMy")
    public ModelAndView baomingManaMy(Baoming req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("baomingManaMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //前台-我的报名管理列表页面
    @RequestMapping("/baomingManaMyQian")
    public ModelAndView baomingManaMyQian(Baoming req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("baomingManaMyQian");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }


    //前台-活动添加报名页面
    @GetMapping("/huodongbaomingAddQian/{huodongid}")
    @ResponseBody
    public ModelAndView huodongbaomingAddQian(@PathVariable Integer huodongid){
        ModelAndView mav = getHuodongBaomingAddModelAndView(huodongid,"huodongbaomingAddQian");
        return mav;
    }

    //后台-活动添加报名页面
    @GetMapping("/huodongbaomingAdd/{huodongid}")
    @ResponseBody
    public ModelAndView huodongbaomingAdd(@PathVariable Integer huodongid){
        ModelAndView mav = getHuodongBaomingAddModelAndView(huodongid,"huodongbaomingAdd");
        return mav;
    }

    //后台-活动报名查看页面
    @RequestMapping("/huodongbaomingGetByhuodongid/{huodongid}")
    @ResponseBody
    public ModelAndView huodongbaomingGetByhuodongid(Baoming req, @PathVariable Integer huodongid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("huodongbaomingChakan");
        req.setHuodongid(huodongid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-活动报名查看页面
    @RequestMapping("/huodongbaomingGetByhuodongidQian/{huodongid}")
    @ResponseBody
    public ModelAndView huodongbaomingGetByhuodongidQian(Baoming req, @PathVariable Integer huodongid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("baomingManaQian");
            mav.addObject("actionName","baomingManaQian");
        req.setHuodongid(huodongid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //活动报名数据封装
    private ModelAndView getHuodongBaomingAddModelAndView(Integer huodongid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Huodong huodong=huodongService.findById(huodongid);
        mav.addObject("huodong", huodong);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }
    //前台-用户添加报名页面
    @GetMapping("/usersbaomingAddQian/{usersid}")
    @ResponseBody
    public ModelAndView usersbaomingAddQian(@PathVariable Integer usersid){
        ModelAndView mav = getUsersBaomingAddModelAndView(usersid,"usersbaomingAddQian");
        return mav;
    }

    //后台-用户添加报名页面
    @GetMapping("/usersbaomingAdd/{usersid}")
    @ResponseBody
    public ModelAndView usersbaomingAdd(@PathVariable Integer usersid){
        ModelAndView mav = getUsersBaomingAddModelAndView(usersid,"usersbaomingAdd");
        return mav;
    }

    //后台-用户报名查看页面
    @RequestMapping("/usersbaomingGetByusersid/{usersid}")
    @ResponseBody
    public ModelAndView usersbaomingGetByusersid(Baoming req, @PathVariable Integer usersid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("usersbaomingChakan");
        req.setUsersid(usersid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-用户报名查看页面
    @RequestMapping("/usersbaomingGetByusersidQian/{usersid}")
    @ResponseBody
    public ModelAndView usersbaomingGetByusersidQian(Baoming req, @PathVariable Integer usersid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("baomingManaQian");
            mav.addObject("actionName","baomingManaQian");
        req.setUsersid(usersid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //用户报名数据封装
    private ModelAndView getUsersBaomingAddModelAndView(Integer usersid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Users users=usersService.findById(usersid);
        mav.addObject("users", users);
        List<Huodong> huodongList=huodongService.findAll();
        mav.addObject("huodongList", huodongList);

        return mav;
    }


    //报名模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Baoming req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Baoming> pageWrap=new PageWrap<Baoming>();
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
        PageData<Baoming> pageInfo= baomingService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Huodong> huodongList=huodongService.findAll();
        mav.addObject("huodongList", huodongList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }

    //报名完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Baoming req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Baoming> pageWrap=new PageWrap<Baoming>();
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
        PageData<Baoming> pageInfo= baomingService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Huodong> huodongList=huodongService.findAll();
        mav.addObject("huodongList", huodongList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
        }
}
