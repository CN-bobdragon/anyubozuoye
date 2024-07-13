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
 * @ClassName UsersController
 * @Description 用户模块控制层
 */
@Controller
public class UsersController extends BaseController{

    @Autowired
    private UsersService usersService;

    @Autowired
    private BanjiService banjiService;



    //前台-用户列表页
    @RequestMapping("/usersManaQian")
    public ModelAndView usersManaQian(Users req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("usersManaQian");
        mav.addObject("actionName","usersManaQian");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-用户图片列表页
    @RequestMapping("/usersManaQiantp")
    public ModelAndView usersManaQiantp(Users req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("usersManaQiantp");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-用户管理列表页
    @RequestMapping("/usersMana")
    public ModelAndView usersMana(Users req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("usersMana");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //后台-用户查看列表页
    @RequestMapping("/usersChakan")
    public ModelAndView usersChakan(Users req, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("usersChakan");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-用户按id列排序列表页
    @RequestMapping("/usersManaQianSort")
    public ModelAndView usersManaQianSort(Users  req, @RequestParam(defaultValue = "1", value = "pageNo") int pageNo) {
        ModelAndView mav = new ModelAndView("usersManaQian");
        mav.addObject("actionName","usersManaQianSort");
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-用户详情页
    @GetMapping("/usersDetailQian/{id}")
    @ResponseBody
    public ModelAndView usersDetailQian(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("usersDetailQian");
        Users info= usersService.findById(id);
        mav.addObject("users", info);

        return mav;
    }

    //后台-用户详情页
    @GetMapping("/usersDetail/{id}")
    @ResponseBody
    public ModelAndView usersDetail(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("usersDetail");
        Users info= usersService.findById(id);
        mav.addObject("users", info);
        return mav;
    }

    //获取所有用户数据接口
    @RequestMapping("/usersAll")
    @ResponseBody
    public ApiResponse<Users> usersAll(){
        List<Users> usersList=usersService.findAll();
        return ApiResponse.success(usersList);
    }

    //根据条件（字符类型模糊匹配查询）获取用户数据接口
    @RequestMapping("/usersSearch")
    @ResponseBody
    public ApiResponse<Users> usersSearch(Users req){
        List<Users> usersList=usersService.find(req);
        return ApiResponse.success(usersList);
    }

    //根据条件（字符类型完全匹配查询）获取用户数据接口
    @RequestMapping("/usersSearchByEqualTo")
    @ResponseBody
    public ApiResponse<Users> usersSearchByEqualTo(Users req){
        List<Users> usersList=usersService.findByEqualTo(req);
        return ApiResponse.success(usersList);
    }

    //用户添加或修改接口
    @PostMapping("/usersAddOrUpdate")
    @ResponseBody
    public ApiResponse<Integer> usersAddOrUpdate(@RequestBody Users req, HttpSession session, Boolean isUPdateSession){
        //判断用户名是否已存在
        if ((null == req.getId() || req.getId() == 0) && null != req.getLoginname() && !req.getLoginname().equals("")) {
            Users instance = new Users();
            instance.setLoginname(req.getLoginname());
            instance = usersService.findOne(instance);
            if (null != instance) {
                return ApiResponse.failed("用户" + req.getLoginname() + "已存在");
            }
        }
        if (null != req.getLoginpw() && !req.getLoginpw().equals("")) {
            req.setLoginpw(encode.myencode(req.getLoginpw()));
        } else {
            req.setLoginpw(null);
        }



        int result = usersService.saveOrUpdate(req);

        //用户修改资料时更新session里的用户信息
        if (null != isUPdateSession && isUPdateSession) {
            session.setAttribute("user", usersService.findById(result));
        }

        return ApiResponse.success("提交成功！", result);
    }

    //后台-用户添加接口
    @PostMapping("/usersAdd")
    @ResponseBody
    public ApiResponse<Integer> usersAdd(@RequestBody Users req, HttpSession session, Boolean isUPdateSession){
        //判断用户名是否已存在
        if ((null == req.getId() || req.getId() == 0) && null != req.getLoginname() && !req.getLoginname().equals("")) {
            Users instance = new Users();
            instance.setLoginname(req.getLoginname());
            instance = usersService.findOne(instance);
            if (null != instance) {
                return ApiResponse.failed("用户" + req.getLoginname() + "已存在");
            }
        }
        if (null != req.getLoginpw() && !req.getLoginpw().equals("")) {
            req.setLoginpw(encode.myencode(req.getLoginpw()));
        } else {
            req.setLoginpw(null);
        }



        int result = usersService.saveOrUpdate(req);

        //用户修改资料时更新session里的用户信息
        if (null != isUPdateSession && isUPdateSession) {
            session.setAttribute("user", usersService.findById(result));
        }

        return ApiResponse.success("提交成功！", result);
    }

    //前台-用户添加接口
    @PostMapping("/usersAddQian")
    @ResponseBody
    public ApiResponse<Integer> usersAddQian(@RequestBody Users req, HttpSession session, Boolean isUPdateSession){
        //判断用户名是否已存在
        if ((null == req.getId() || req.getId() == 0) && null != req.getLoginname() && !req.getLoginname().equals("")) {
            Users instance = new Users();
            instance.setLoginname(req.getLoginname());
            instance = usersService.findOne(instance);
            if (null != instance) {
                return ApiResponse.failed("用户" + req.getLoginname() + "已存在");
            }
        }
        if (null != req.getLoginpw() && !req.getLoginpw().equals("")) {
            req.setLoginpw(encode.myencode(req.getLoginpw()));
        } else {
            req.setLoginpw(null);
        }



        int result = usersService.saveOrUpdate(req);

        //用户修改资料时更新session里的用户信息
        if (null != isUPdateSession && isUPdateSession) {
            session.setAttribute("user", usersService.findById(result));
        }

        return ApiResponse.success("提交成功！", result);
    }

    //用户修改单独一个字段接口
    @PostMapping("/usersSet")
    @ResponseBody
    public ApiResponse<Integer> usersSet(Users req){
        int result = usersService.saveOrUpdate(req);
        return ApiResponse.success(result);
    }



    //用户删除接口
    @RequestMapping("/usersDel/{id}")
    @ResponseBody
    public ApiResponse<Integer> usersDel(@PathVariable Integer id){
        int result = usersService.deleteById(id);
        return ApiResponse.success(result);
    }

    //后台-用户修改页
    @RequestMapping("/usersGet/{id}")
    @ResponseBody
    public ModelAndView usersGet(@PathVariable Integer id){
        ModelAndView mav = new ModelAndView("usersSet");
        Users info = usersService.findById(id);
        mav.addObject("users", info);
        return mav;
    }

    //根据字段分组获取用户表count统计数据接口
    @RequestMapping("/users/selectCountGroup/{columnName}")
    @ResponseBody
    public ApiResponse selectCountGroup(@PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        List<Map<String, Object>> result = usersService.selectCountGroup(params);
        return ApiResponse.success(result);
        }

    //根据字段分组获取用户表按另一字段sum求和数据接口
    @RequestMapping("/users/selectSumGroup/{xColumnName}/{yColumnName}")
    @ResponseBody
    public ApiResponse selectSumGroup(@PathVariable("xColumnName") String xColumnName,@PathVariable("yColumnName") String yColumnName){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        List<Map<String, Object>> result = usersService.selectSumGroup(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取用户表count统计数据接口
    @RequestMapping("/users/selectCountGroupByDate/{columnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectCountGroupByDate(@PathVariable("columnName") String columnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("column", columnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = usersService.selectCountGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据日期或时间分组获取用户表按另一字段sum求和数据接口
    @RequestMapping("/users/selectSumGroupByDate/{xColumnName}/{yColumnName}/{dateType}")
    @ResponseBody
    public ApiResponse selectSumGroupByDate(@PathVariable("xColumnName") String xColumnName, @PathVariable("yColumnName") String yColumnName, @PathVariable("dateType") String dateType){
        Map<String, Object> params = new HashMap<>();
        params.put("xColumn", xColumnName);
        params.put("yColumn", yColumnName);
        params.put("dateType", dateType);
        List<Map<String, Object>> result = usersService.selectSumGroupByDate(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取用户表count统计数据接口
    @RequestMapping("/users/selectCountGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}")
    @ResponseBody
    public ApiResponse selectCountGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        List<Map<String, Object>> result = usersService.selectCountGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //根据父表列分组关联父表获取用户表按另一字段sum求和数据接口
    @RequestMapping("/users/selectSumGroupByFatherId/{fatherTableName}/{fatherTableId}/{fatherTableColumn}/{columnName}")
    @ResponseBody
    public ApiResponse selectSumGroupByFatherId(@PathVariable("fatherTableName") String fatherTableName, @PathVariable("fatherTableId") String fatherTableId, @PathVariable("fatherTableColumn") String fatherTableColumn, @PathVariable("columnName") String columnName){
        Map<String, Object> params = new HashMap<>();
        params.put("fatherTableName", fatherTableName);
        params.put("fatherTableId", fatherTableId);
        params.put("fatherTableColumn", fatherTableColumn);
        params.put("column", columnName);
        List<Map<String, Object>> result = usersService.selectSumGroupByFatherId(params);
        return ApiResponse.success(result);
    }

    //用户数据导出Excel接口
    @RequestMapping("/usersExportExcel")
    public void exportExcel(HttpServletResponse response) throws IOException {
        List<Users> usersList = usersService.findAll();

        String[] headerCellList = {"id", "用户名称","密码","类型","类型名称","姓名","性别","年龄","地址","电话","班级id","审核"};
        //excel表头为上面定义的字段注释
        Workbook wb = ExcelUtil.createWorkbook("用户表", headerCellList, usersList, Users.class);
        //注释掉上面一行，解开下面这一行则表示excel表头为字段名称
//        Workbook wb=ExcelUtil.createWorkbook("用户表",null,usersList,Users.class);

        // 设置响应头
        response.setContentType("application/vnd.openxmlformats-officedocument.spreadsheetml.sheet");
        response.setHeader("Content-Disposition", "attachment; filename=usersExport.xlsx");

        // 输出Excel文件到响应流
        OutputStream outputStream = response.getOutputStream();
        wb.write(outputStream);
        outputStream.flush();
    }

    //用户重置密码接口
    @RequestMapping("/usersResetPw")
    @ResponseBody
    public ApiResponse<String> usersResetPw(Users req) {
//        if (null == req || null == req.getLoginname() || req.getLoginname().equals("") || null == req.getXingming() || req.getXingming().equals("") || null == req.getDianhua() || req.getDianhua().equals("")) {
//            return ApiResponse.failed("请确认您的用户名、姓名和电话是否正确！");
//        }
        Users info = usersService.findOneByEqualTo(req);
        if (null == info || info.getId() == 0) {
            return ApiResponse.failed("请确认您的用户名、姓名和电话是否正确！");
        }
        info.setLoginpw(encode.myencode("000000"));
        usersService.saveOrUpdate(info);
        return ApiResponse.success("您的密码已被重置为<strong style='color: red;'>000000</strong>，如需修改，请登陆个人中心操作!");
    }




    //前台-班级添加用户页面
    @GetMapping("/banjiusersAddQian/{banjiid}")
    @ResponseBody
    public ModelAndView banjiusersAddQian(@PathVariable Integer banjiid){
        ModelAndView mav = getBanjiUsersAddModelAndView(banjiid,"banjiusersAddQian");
        return mav;
    }

    //后台-班级添加用户页面
    @GetMapping("/banjiusersAdd/{banjiid}")
    @ResponseBody
    public ModelAndView banjiusersAdd(@PathVariable Integer banjiid){
        ModelAndView mav = getBanjiUsersAddModelAndView(banjiid,"banjiusersAdd");
        return mav;
    }

    //后台-班级用户查看页面
    @RequestMapping("/banjiusersGetBybanjiid/{banjiid}")
    @ResponseBody
    public ModelAndView banjiusersGetBybanjiid(Users req, @PathVariable Integer banjiid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("banjiusersChakan");
        req.setBanjiid(banjiid);
        return getModelAndView(req, pageNo, mav, "id");
    }

    //前台-班级用户查看页面
    @RequestMapping("/banjiusersGetBybanjiidQian/{banjiid}")
    @ResponseBody
    public ModelAndView banjiusersGetBybanjiidQian(Users req, @PathVariable Integer banjiid, @RequestParam(defaultValue = "1",value = "pageNo")int pageNo){
        ModelAndView mav = new ModelAndView("usersManaQian");
            mav.addObject("actionName","usersManaQian");
        req.setBanjiid(banjiid);
        return getModelAndView(req, pageNo, mav, "id");
    }


    //班级用户数据封装
    private ModelAndView getBanjiUsersAddModelAndView(Integer banjiid, String viewName) {
        ModelAndView mav = new ModelAndView(viewName);
        Banji banji=banjiService.findById(banjiid);
        mav.addObject("banji", banji);

        return mav;
    }


    //用户模糊匹配查询分页数据封装
    private ModelAndView getModelAndView(Users req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Users> pageWrap=new PageWrap<Users>();
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
        PageData<Users> pageInfo= usersService.findPage(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Banji> banjiList=banjiService.findAll();
        mav.addObject("banjiList", banjiList);

        return mav;
    }

    //用户完全匹配查询分页数据封装
    private ModelAndView getModelAndViewByEqualTo(Users req, int pageNo, ModelAndView mav, String sortProperty) {
        PageWrap<Users> pageWrap=new PageWrap<Users>();
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
        PageData<Users> pageInfo= usersService.findPageByEqualTo(pageWrap);
        mav.addObject("pageInfo", pageInfo);


        mav.addObject("req", req);
        List<Banji> banjiList=banjiService.findAll();
        mav.addObject("banjiList", banjiList);

        return mav;
        }
}
