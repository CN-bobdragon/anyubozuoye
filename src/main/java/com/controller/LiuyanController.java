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
 * @ClassName LiuyanController
 * @Description 留言咨询模块控制层
 */
@Controller
public class LiuyanController extends BaseController{

    @Autowired
    private LiuyanService liuyanService;

    @Autowired
    private UsersService usersService;



    //前台-留言咨询列表页
    @RequestMapping("/liuyanManaQian")
    public ModelAndView liuyanManaQian(Liuyan req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("liuyanManaQian");
        mav.addObject("actionName","liuyanManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-留言咨询图片列表页
    @RequestMapping("/liuyanManaQiantp")
    public ModelAndView liuyanManaQiantp(Liuyan req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("liuyanManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-留言咨询管理列表页
    @RequestMapping("/liuyanMana")
    public ModelAndView liuyanMana(Liuyan req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("liuyanMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-留言咨询查看列表页
    @RequestMapping("/liuyanChakan")
    public ModelAndView liuyanChakan(Liuyan req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("liuyanChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-留言咨询按id列排序列表页
    @RequestMapping("/liuyanManaQianSort")
    public ModelAndView liuyanManaQianSort(Liuyan  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("liuyanManaQian");
        mav.addObject("actionName","liuyanManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-留言咨询详情页
    @GetMapping("/liuyanDetailQian/{id}")
    @ResponseBody
    public ModelAndView liuyanDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("liuyanDetailQian");
        Liuyan info= liuyanService.findById(id);
        mav.addObject("liuyan", info);

        return mav;
    }

    //后台-留言咨询详情页
    @GetMapping("/liuyanDetail/{id}")
    @ResponseBody
    public ModelAndView liuyanDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("liuyanDetail");
        Liuyan info= liuyanService.findById(id);
        mav.addObject("liuyan", info);
        return mav;
    }

    //获取所有留言咨询数据接口
    @RequestMapping("/liuyanAll")
    @ResponseBody
    public ApiResponse<Liuyan> liuyanAll(){
        List<Liuyan> liuyanList=liuyanService.findAll();
        return ApiResponse.success(liuyanList);
    }

    //根据条件（字符类型模糊匹配查询）获取留言咨询数据接口
    @RequestMapping("/liuyanSearch")
    @ResponseBody
    public ApiResponse<Liuyan> liuyanSearch(Liuyan req){
        List<Liuyan> liuyanList=liuyanService.find(req);
        return ApiResponse.success(liuyanList);
    }

    //根据条件（字符类型完全匹配查询）获取留言咨询数据接口
    @RequestMapping("/liuyanSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Liuyan> liuyanSearchByEqualTo(Liuyan req){
        List<Liuyan> liuyanList=liuyanService.findByEqualTo(req);
        return ApiResponse.success(liuyanList);
    }

    //留言咨询添加或修改接口
    @PostMapping("/liuyanAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> liuyanAddOrUpdate(@RequestBody Liuyan req, HttpSession session, Boolean isUPdateSession){



        int result = liuyanService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //后台-留言咨询添加接口
    @PostMapping("/liuyanAdd")
    @ResponseBody
    public ApiResponse<Integer> liuyanAdd(@RequestBody Liuyan req, HttpSession session, Boolean isUPdateSession){



        int result = liuyanService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //前台-留言咨询添加接口
    @PostMapping("/liuyanAddQian")
    @ResponseBody
    public ApiResponse<Integer> liuyanAddQian(@RequestBody Liuyan req, HttpSession session, Boolean isUPdateSession){



        int result = liuyanService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //留言咨询修改单独一个字段接口
    @PostMapping("/liuyanSet")
    @ResponseBody
    public ApiResponse<Integer> liuyanSet(Liuyan req){
        int result = liuyanService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //留言咨询删除接口
    @RequestMapping("/liuyanDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> liuyanDel(@PathVariable Integer id){
        int result = liuyanService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-留言咨询修改页
    @RequestMapping("/liuyanGet/{id}")
    @ResponseBody
    public ModelAndView liuyanGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("liuyanSet");
        Liuyan info = liuyanService.findById(id);
        mav.addObject("liuyan", info);
        return mav;
    }

    //根据字段分组获取留言咨询表count统计数据接口
    @RequestMapping("/liuyan/selectCountGroup/{columnName}")
    @ResponseBody
    public ApiResponse selectCountGroup(@PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        List<Map<String, Object>> result = liuyanService.selectCountGroup(params);
        return ApiResponse.success(result);
        }

    //根据字段分组获取留言咨询表按另一字段sum求和数据接口
    @RequestMapping("/liuyan/selectSumGroup/{xColumnName}/{yColumnName}")
    @ResponseBody
    public ApiResponse selectSumGroup(@PathVariable("xColumnName") String xColumnName,@PathVariable("yColumnName") String yColumnName){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        List<Map<String, Object>> result = liuyanService.selectSumGroup(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取留言咨询表count统计数据接口
    @RequestMapping("/liuyan/selectCountGroupByDate/{columnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectCountGroupByDate(@PathVariable("columnName") String columnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = liuyanService.selectCountGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取留言咨询表按另一字段sum求和数据接口
    @RequestMapping("/liuyan/selectSumGroupByDate/{xColumnName}/{yColumnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectSumGroupByDate(@PathVariable("xColumnName") String xColumnName, @PathVariable("yColumnName") String yColumnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = liuyanService.selectSumGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取留言咨询表count统计数据接口
    @RequestMapping("/liuyan/selectCountGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}")
    @ResponseBody
    public ApiResponse selectCountGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        List<Map<String, Object>> result = liuyanService.selectCountGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取留言咨询表按另一字段sum求和数据接口
    @RequestMapping("/liuyan/selectSumGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}/{columnName}")
    @ResponseBody
    public ApiResponse selectSumGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn, @PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        params.put("column", columnName);
        List<Map<String, Object>> result = liuyanService.selectSumGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //留言咨询数据导出Excel接口
    @RequestMapping("/liuyanExportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Liuyan> liuyanList = liuyanService.findAll();

        String[] headerCellList = {"id", "标题","内容","时间","用户id","回复"};
        //excel表头为上面定义的字段注释
        Workbook wb = ExcelUtil.createWorkbook("留言咨询表", headerCellList, liuyanList, Liuyan.class);
        //注释掉上面一行，解开下面这一行则表示excel表头为字段名称
//        Workbook wb=ExcelUtil.createWorkbook("留言咨询表",null,liuyanList,Liuyan.class);

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=liuyanExport.xlsx");

        // 输出Excel文件到响应流
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
    }



    //后台-我的留言咨询查看页面
    @RequestMapping("/liuyanChakanMy")
    public ModelAndView liuyanChakanMy(Liuyan req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("liuyanChakanMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //后台-我的留言咨询管理列表页面
    @RequestMapping("/liuyanManaMy")
    public ModelAndView liuyanManaMy(Liuyan req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("liuyanManaMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //前台-我的留言咨询管理列表页面
    @RequestMapping("/liuyanManaMyQian")
    public ModelAndView liuyanManaMyQian(Liuyan req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("liuyanManaMyQian");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }


    //前台-用户添加留言咨询页面
    @GetMapping("/usersliuyanAddQian/{usersid}")
    @ResponseBody
    public ModelAndView usersliuyanAddQian(@PathVariable Integer usersid){
        ModelAndView mav = getUsersLiuyanAddModelAndView(usersid,"usersliuyanAddQian");
        return mav;
    }

    //后台-用户添加留言咨询页面
    @GetMapping("/usersliuyanAdd/{usersid}")
    @ResponseBody
    public ModelAndView usersliuyanAdd(@PathVariable Integer usersid){
        ModelAndView mav = getUsersLiuyanAddModelAndView(usersid,"usersliuyanAdd");
        return mav;
    }

    //后台-用户留言咨询查看页面
    @RequestMapping("/usersliuyanGetByusersid/{usersid}")
    @ResponseBody
    public ModelAndView usersliuyanGetByusersid(Liuyan req, @PathVariable Integer usersid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("usersliuyanChakan");
        req.setUsersid(usersid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-用户留言咨询查看页面
    @RequestMapping("/usersliuyanGetByusersidQian/{usersid}")
    @ResponseBody
    public ModelAndView usersliuyanGetByusersidQian(Liuyan req, @PathVariable Integer usersid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("liuyanManaQian");
            mav.addObject("actionName","liuyanManaQian");
        req.setUsersid(usersid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //用户留言咨询数据封装
    private ModelAndView getUsersLiuyanAddModelAndView(Integer usersid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Users users=usersService.findById(usersid);
        mav.addObject("users", users);

        return mav;
    }


    //留言咨询模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Liuyan req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Liuyan> pageWrap=new PageWrap<Liuyan>();
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
        PageData<Liuyan> pageInfo= liuyanService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }

    //留言咨询完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Liuyan req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Liuyan> pageWrap=new PageWrap<Liuyan>();
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
        PageData<Liuyan> pageInfo= liuyanService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
        }
}
