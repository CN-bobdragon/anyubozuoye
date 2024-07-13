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
 * @ClassName XiaozuController
 * @Description 小组模块控制层
 */
@Controller
public class XiaozuController extends BaseController{

    @Autowired
    private XiaozuService xiaozuService;

    @Autowired
    private HuodongService huodongService;
    @Autowired
    private UsersService usersService;



    //前台-小组列表页
    @RequestMapping("/xiaozuManaQian")
    public ModelAndView xiaozuManaQian(Xiaozu req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("xiaozuManaQian");
        mav.addObject("actionName","xiaozuManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-小组图片列表页
    @RequestMapping("/xiaozuManaQiantp")
    public ModelAndView xiaozuManaQiantp(Xiaozu req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("xiaozuManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-小组管理列表页
    @RequestMapping("/xiaozuMana")
    public ModelAndView xiaozuMana(Xiaozu req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("xiaozuMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-小组查看列表页
    @RequestMapping("/xiaozuChakan")
    public ModelAndView xiaozuChakan(Xiaozu req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("xiaozuChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-小组按id列排序列表页
    @RequestMapping("/xiaozuManaQianSort")
    public ModelAndView xiaozuManaQianSort(Xiaozu  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("xiaozuManaQian");
        mav.addObject("actionName","xiaozuManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-小组详情页
    @GetMapping("/xiaozuDetailQian/{id}")
    @ResponseBody
    public ModelAndView xiaozuDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("xiaozuDetailQian");
        Xiaozu info= xiaozuService.findById(id);
        mav.addObject("xiaozu", info);

        return mav;
    }

    //后台-小组详情页
    @GetMapping("/xiaozuDetail/{id}")
    @ResponseBody
    public ModelAndView xiaozuDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("xiaozuDetail");
        Xiaozu info= xiaozuService.findById(id);
        mav.addObject("xiaozu", info);
        return mav;
    }

    //获取所有小组数据接口
    @RequestMapping("/xiaozuAll")
    @ResponseBody
    public ApiResponse<Xiaozu> xiaozuAll(){
        List<Xiaozu> xiaozuList=xiaozuService.findAll();
        return ApiResponse.success(xiaozuList);
    }

    //根据条件（字符类型模糊匹配查询）获取小组数据接口
    @RequestMapping("/xiaozuSearch")
    @ResponseBody
    public ApiResponse<Xiaozu> xiaozuSearch(Xiaozu req){
        List<Xiaozu> xiaozuList=xiaozuService.find(req);
        return ApiResponse.success(xiaozuList);
    }

    //根据条件（字符类型完全匹配查询）获取小组数据接口
    @RequestMapping("/xiaozuSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Xiaozu> xiaozuSearchByEqualTo(Xiaozu req){
        List<Xiaozu> xiaozuList=xiaozuService.findByEqualTo(req);
        return ApiResponse.success(xiaozuList);
    }

    //小组添加或修改接口
    @PostMapping("/xiaozuAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> xiaozuAddOrUpdate(@RequestBody Xiaozu req, HttpSession session, Boolean isUPdateSession){



        int result = xiaozuService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //后台-小组添加接口
    @PostMapping("/xiaozuAdd")
    @ResponseBody
    public ApiResponse<Integer> xiaozuAdd(@RequestBody Xiaozu req, HttpSession session, Boolean isUPdateSession){



        int result = xiaozuService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //前台-小组添加接口
    @PostMapping("/xiaozuAddQian")
    @ResponseBody
    public ApiResponse<Integer> xiaozuAddQian(@RequestBody Xiaozu req, HttpSession session, Boolean isUPdateSession){



        int result = xiaozuService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //小组修改单独一个字段接口
    @PostMapping("/xiaozuSet")
    @ResponseBody
    public ApiResponse<Integer> xiaozuSet(Xiaozu req){
        int result = xiaozuService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //小组删除接口
    @RequestMapping("/xiaozuDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> xiaozuDel(@PathVariable Integer id){
        int result = xiaozuService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-小组修改页
    @RequestMapping("/xiaozuGet/{id}")
    @ResponseBody
    public ModelAndView xiaozuGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("xiaozuSet");
        Xiaozu info = xiaozuService.findById(id);
        mav.addObject("xiaozu", info);
        return mav;
    }

    //根据字段分组获取小组表count统计数据接口
    @RequestMapping("/xiaozu/selectCountGroup/{columnName}")
    @ResponseBody
    public ApiResponse selectCountGroup(@PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        List<Map<String, Object>> result = xiaozuService.selectCountGroup(params);
        return ApiResponse.success(result);
        }

    //根据字段分组获取小组表按另一字段sum求和数据接口
    @RequestMapping("/xiaozu/selectSumGroup/{xColumnName}/{yColumnName}")
    @ResponseBody
    public ApiResponse selectSumGroup(@PathVariable("xColumnName") String xColumnName,@PathVariable("yColumnName") String yColumnName){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        List<Map<String, Object>> result = xiaozuService.selectSumGroup(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取小组表count统计数据接口
    @RequestMapping("/xiaozu/selectCountGroupByDate/{columnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectCountGroupByDate(@PathVariable("columnName") String columnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = xiaozuService.selectCountGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取小组表按另一字段sum求和数据接口
    @RequestMapping("/xiaozu/selectSumGroupByDate/{xColumnName}/{yColumnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectSumGroupByDate(@PathVariable("xColumnName") String xColumnName, @PathVariable("yColumnName") String yColumnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = xiaozuService.selectSumGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取小组表count统计数据接口
    @RequestMapping("/xiaozu/selectCountGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}")
    @ResponseBody
    public ApiResponse selectCountGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        List<Map<String, Object>> result = xiaozuService.selectCountGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取小组表按另一字段sum求和数据接口
    @RequestMapping("/xiaozu/selectSumGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}/{columnName}")
    @ResponseBody
    public ApiResponse selectSumGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn, @PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        params.put("column", columnName);
        List<Map<String, Object>> result = xiaozuService.selectSumGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //小组数据导出Excel接口
    @RequestMapping("/xiaozuExportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Xiaozu> xiaozuList = xiaozuService.findAll();

        String[] headerCellList = {"id", "名称","图片","活动id","小组成绩","用户id"};
        //excel表头为上面定义的字段注释
        Workbook wb = ExcelUtil.createWorkbook("小组表", headerCellList, xiaozuList, Xiaozu.class);
        //注释掉上面一行，解开下面这一行则表示excel表头为字段名称
//        Workbook wb=ExcelUtil.createWorkbook("小组表",null,xiaozuList,Xiaozu.class);

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=xiaozuExport.xlsx");

        // 输出Excel文件到响应流
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
    }



    //后台-我的小组查看页面
    @RequestMapping("/xiaozuChakanMy")
    public ModelAndView xiaozuChakanMy(Xiaozu req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("xiaozuChakanMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //后台-我的小组管理列表页面
    @RequestMapping("/xiaozuManaMy")
    public ModelAndView xiaozuManaMy(Xiaozu req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("xiaozuManaMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //前台-我的小组管理列表页面
    @RequestMapping("/xiaozuManaMyQian")
    public ModelAndView xiaozuManaMyQian(Xiaozu req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("xiaozuManaMyQian");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }


    //前台-活动添加小组页面
    @GetMapping("/huodongxiaozuAddQian/{huodongid}")
    @ResponseBody
    public ModelAndView huodongxiaozuAddQian(@PathVariable Integer huodongid){
        ModelAndView mav = getHuodongXiaozuAddModelAndView(huodongid,"huodongxiaozuAddQian");
        return mav;
    }

    //后台-活动添加小组页面
    @GetMapping("/huodongxiaozuAdd/{huodongid}")
    @ResponseBody
    public ModelAndView huodongxiaozuAdd(@PathVariable Integer huodongid){
        ModelAndView mav = getHuodongXiaozuAddModelAndView(huodongid,"huodongxiaozuAdd");
        return mav;
    }

    //后台-活动小组查看页面
    @RequestMapping("/huodongxiaozuGetByhuodongid/{huodongid}")
    @ResponseBody
    public ModelAndView huodongxiaozuGetByhuodongid(Xiaozu req, @PathVariable Integer huodongid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("huodongxiaozuChakan");
        req.setHuodongid(huodongid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-活动小组查看页面
    @RequestMapping("/huodongxiaozuGetByhuodongidQian/{huodongid}")
    @ResponseBody
    public ModelAndView huodongxiaozuGetByhuodongidQian(Xiaozu req, @PathVariable Integer huodongid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("xiaozuManaQian");
            mav.addObject("actionName","xiaozuManaQian");
        req.setHuodongid(huodongid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //活动小组数据封装
    private ModelAndView getHuodongXiaozuAddModelAndView(Integer huodongid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Huodong huodong=huodongService.findById(huodongid);
        mav.addObject("huodong", huodong);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }
    //前台-用户添加小组页面
    @GetMapping("/usersxiaozuAddQian/{usersid}")
    @ResponseBody
    public ModelAndView usersxiaozuAddQian(@PathVariable Integer usersid){
        ModelAndView mav = getUsersXiaozuAddModelAndView(usersid,"usersxiaozuAddQian");
        return mav;
    }

    //后台-用户添加小组页面
    @GetMapping("/usersxiaozuAdd/{usersid}")
    @ResponseBody
    public ModelAndView usersxiaozuAdd(@PathVariable Integer usersid){
        ModelAndView mav = getUsersXiaozuAddModelAndView(usersid,"usersxiaozuAdd");
        return mav;
    }

    //后台-用户小组查看页面
    @RequestMapping("/usersxiaozuGetByusersid/{usersid}")
    @ResponseBody
    public ModelAndView usersxiaozuGetByusersid(Xiaozu req, @PathVariable Integer usersid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("usersxiaozuChakan");
        req.setUsersid(usersid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-用户小组查看页面
    @RequestMapping("/usersxiaozuGetByusersidQian/{usersid}")
    @ResponseBody
    public ModelAndView usersxiaozuGetByusersidQian(Xiaozu req, @PathVariable Integer usersid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("xiaozuManaQian");
            mav.addObject("actionName","xiaozuManaQian");
        req.setUsersid(usersid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //用户小组数据封装
    private ModelAndView getUsersXiaozuAddModelAndView(Integer usersid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Users users=usersService.findById(usersid);
        mav.addObject("users", users);
        List<Huodong> huodongList=huodongService.findAll();
        mav.addObject("huodongList", huodongList);

        return mav;
    }


    //小组模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Xiaozu req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Xiaozu> pageWrap=new PageWrap<Xiaozu>();
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
        PageData<Xiaozu> pageInfo= xiaozuService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Huodong> huodongList=huodongService.findAll();
        mav.addObject("huodongList", huodongList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }

    //小组完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Xiaozu req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Xiaozu> pageWrap=new PageWrap<Xiaozu>();
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
        PageData<Xiaozu> pageInfo= xiaozuService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Huodong> huodongList=huodongService.findAll();
        mav.addObject("huodongList", huodongList);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
        }
}
