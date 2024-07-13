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
 * @ClassName HuodongController
 * @Description 活动模块控制层
 */
@Controller
public class HuodongController extends BaseController{

    @Autowired
    private HuodongService huodongService;

    @Autowired
    private UsersService usersService;



    //前台-活动列表页
    @RequestMapping("/huodongManaQian")
    public ModelAndView huodongManaQian(Huodong req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("huodongManaQian");
        mav.addObject("actionName","huodongManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-活动图片列表页
    @RequestMapping("/huodongManaQiantp")
    public ModelAndView huodongManaQiantp(Huodong req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("huodongManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-活动管理列表页
    @RequestMapping("/huodongMana")
    public ModelAndView huodongMana(Huodong req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("huodongMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-活动查看列表页
    @RequestMapping("/huodongChakan")
    public ModelAndView huodongChakan(Huodong req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("huodongChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-活动按id列排序列表页
    @RequestMapping("/huodongManaQianSort")
    public ModelAndView huodongManaQianSort(Huodong  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("huodongManaQian");
        mav.addObject("actionName","huodongManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-活动详情页
    @GetMapping("/huodongDetailQian/{id}")
    @ResponseBody
    public ModelAndView huodongDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("huodongDetailQian");
        Huodong info= huodongService.findById(id);
        mav.addObject("huodong", info);

        return mav;
    }

    //后台-活动详情页
    @GetMapping("/huodongDetail/{id}")
    @ResponseBody
    public ModelAndView huodongDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("huodongDetail");
        Huodong info= huodongService.findById(id);
        mav.addObject("huodong", info);
        return mav;
    }

    //获取所有活动数据接口
    @RequestMapping("/huodongAll")
    @ResponseBody
    public ApiResponse<Huodong> huodongAll(){
        List<Huodong> huodongList=huodongService.findAll();
        return ApiResponse.success(huodongList);
    }

    //根据条件（字符类型模糊匹配查询）获取活动数据接口
    @RequestMapping("/huodongSearch")
    @ResponseBody
    public ApiResponse<Huodong> huodongSearch(Huodong req){
        List<Huodong> huodongList=huodongService.find(req);
        return ApiResponse.success(huodongList);
    }

    //根据条件（字符类型完全匹配查询）获取活动数据接口
    @RequestMapping("/huodongSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Huodong> huodongSearchByEqualTo(Huodong req){
        List<Huodong> huodongList=huodongService.findByEqualTo(req);
        return ApiResponse.success(huodongList);
    }

    //活动添加或修改接口
    @PostMapping("/huodongAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> huodongAddOrUpdate(@RequestBody Huodong req, HttpSession session, Boolean isUPdateSession){



        int result = huodongService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //后台-活动添加接口
    @PostMapping("/huodongAdd")
    @ResponseBody
    public ApiResponse<Integer> huodongAdd(@RequestBody Huodong req, HttpSession session, Boolean isUPdateSession){



        int result = huodongService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //前台-活动添加接口
    @PostMapping("/huodongAddQian")
    @ResponseBody
    public ApiResponse<Integer> huodongAddQian(@RequestBody Huodong req, HttpSession session, Boolean isUPdateSession){



        int result = huodongService.saveOrUpdate(req);


        return ApiResponse.success("提交成功！", result);
    }

    //活动修改单独一个字段接口
    @PostMapping("/huodongSet")
    @ResponseBody
    public ApiResponse<Integer> huodongSet(Huodong req){
        int result = huodongService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //活动删除接口
    @RequestMapping("/huodongDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> huodongDel(@PathVariable Integer id){
        int result = huodongService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-活动修改页
    @RequestMapping("/huodongGet/{id}")
    @ResponseBody
    public ModelAndView huodongGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("huodongSet");
        Huodong info = huodongService.findById(id);
        mav.addObject("huodong", info);
        return mav;
    }

    //根据字段分组获取活动表count统计数据接口
    @RequestMapping("/huodong/selectCountGroup/{columnName}")
    @ResponseBody
    public ApiResponse selectCountGroup(@PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        List<Map<String, Object>> result = huodongService.selectCountGroup(params);
        return ApiResponse.success(result);
        }

    //根据字段分组获取活动表按另一字段sum求和数据接口
    @RequestMapping("/huodong/selectSumGroup/{xColumnName}/{yColumnName}")
    @ResponseBody
    public ApiResponse selectSumGroup(@PathVariable("xColumnName") String xColumnName,@PathVariable("yColumnName") String yColumnName){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        List<Map<String, Object>> result = huodongService.selectSumGroup(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取活动表count统计数据接口
    @RequestMapping("/huodong/selectCountGroupByDate/{columnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectCountGroupByDate(@PathVariable("columnName") String columnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = huodongService.selectCountGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取活动表按另一字段sum求和数据接口
    @RequestMapping("/huodong/selectSumGroupByDate/{xColumnName}/{yColumnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectSumGroupByDate(@PathVariable("xColumnName") String xColumnName, @PathVariable("yColumnName") String yColumnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = huodongService.selectSumGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取活动表count统计数据接口
    @RequestMapping("/huodong/selectCountGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}")
    @ResponseBody
    public ApiResponse selectCountGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        List<Map<String, Object>> result = huodongService.selectCountGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取活动表按另一字段sum求和数据接口
    @RequestMapping("/huodong/selectSumGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}/{columnName}")
    @ResponseBody
    public ApiResponse selectSumGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn, @PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        params.put("column", columnName);
        List<Map<String, Object>> result = huodongService.selectSumGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //活动数据导出Excel接口
    @RequestMapping("/huodongExportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Huodong> huodongList = huodongService.findAll();

        String[] headerCellList = {"id", "名称","图片","日常内容","用户id"};
        //excel表头为上面定义的字段注释
        Workbook wb = ExcelUtil.createWorkbook("活动表", headerCellList, huodongList, Huodong.class);
        //注释掉上面一行，解开下面这一行则表示excel表头为字段名称
//        Workbook wb=ExcelUtil.createWorkbook("活动表",null,huodongList,Huodong.class);

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=huodongExport.xlsx");

        // 输出Excel文件到响应流
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
    }



    //后台-我的活动查看页面
    @RequestMapping("/huodongChakanMy")
    public ModelAndView huodongChakanMy(Huodong req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("huodongChakanMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //后台-我的活动管理列表页面
    @RequestMapping("/huodongManaMy")
    public ModelAndView huodongManaMy(Huodong req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("huodongManaMy");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }

    //前台-我的活动管理列表页面
    @RequestMapping("/huodongManaMyQian")
    public ModelAndView huodongManaMyQian(Huodong req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo, HttpSession session){
        ModelAndView mav = new ModelAndView("huodongManaMyQian");
        Users users = (Users)session.getAttribute("user");
        if(null!=users) {
            req.setUsersid(users.getId());
            return getModelAndView(req, pageNo, mav, "id");
        }
        return mav;
    }


    //前台-用户添加活动页面
    @GetMapping("/usershuodongAddQian/{usersid}")
    @ResponseBody
    public ModelAndView usershuodongAddQian(@PathVariable Integer usersid){
        ModelAndView mav = getUsersHuodongAddModelAndView(usersid,"usershuodongAddQian");
        return mav;
    }

    //后台-用户添加活动页面
    @GetMapping("/usershuodongAdd/{usersid}")
    @ResponseBody
    public ModelAndView usershuodongAdd(@PathVariable Integer usersid){
        ModelAndView mav = getUsersHuodongAddModelAndView(usersid,"usershuodongAdd");
        return mav;
    }

    //后台-用户活动查看页面
    @RequestMapping("/usershuodongGetByusersid/{usersid}")
    @ResponseBody
    public ModelAndView usershuodongGetByusersid(Huodong req, @PathVariable Integer usersid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("usershuodongChakan");
        req.setUsersid(usersid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-用户活动查看页面
    @RequestMapping("/usershuodongGetByusersidQian/{usersid}")
    @ResponseBody
    public ModelAndView usershuodongGetByusersidQian(Huodong req, @PathVariable Integer usersid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("huodongManaQian");
            mav.addObject("actionName","huodongManaQian");
        req.setUsersid(usersid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //用户活动数据封装
    private ModelAndView getUsersHuodongAddModelAndView(Integer usersid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Users users=usersService.findById(usersid);
        mav.addObject("users", users);

        return mav;
    }


    //活动模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Huodong req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Huodong> pageWrap=new PageWrap<Huodong>();
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
        PageData<Huodong> pageInfo= huodongService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
    }

    //活动完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Huodong req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Huodong> pageWrap=new PageWrap<Huodong>();
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
        PageData<Huodong> pageInfo= huodongService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Users> usersList=usersService.findAll();
        mav.addObject("usersList", usersList);

        return mav;
        }
}
