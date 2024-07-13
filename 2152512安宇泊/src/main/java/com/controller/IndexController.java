package com.controller;

import com.entity.*;
import com.service.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.List;

/**
 * @ClassName IndexController
 * @Description 首页控制层
 */
@Controller
public class IndexController extends BaseController {

    @Autowired
    private BanjiService banjiService;
    @Autowired
    private BaomingService baomingService;
    @Autowired
    private DxService dxService;
    @Autowired
    private GonggaoService gonggaoService;
    @Autowired
    private HuodongService huodongService;
    @Autowired
    private LeixingService leixingService;
    @Autowired
    private LiuyanService liuyanService;
    @Autowired
    private LunboService lunboService;
    @Autowired
    private ShenqingService shenqingService;
    @Autowired
    private UsersService usersService;
    @Autowired
    private XiaozuService xiaozuService;


    //首页
    @RequestMapping("/index")
    public ModelAndView index(HttpServletRequest request) {
        ModelAndView mav = new ModelAndView("index");
        //取出所有业务表数据存储到session里方便前端页面随意调用
        HttpSession session = request.getSession();

        //班级表banji
        List<Banji> banjiList = banjiService.findAll();
        session.setAttribute("banjiList", banjiList);
        session.setAttribute("banjiListSize", banjiList.size());
        //报名表baoming
        List<Baoming> baomingList = baomingService.findAll();
        session.setAttribute("baomingList", baomingList);
        session.setAttribute("baomingListSize", baomingList.size());
        //介绍表dx
        List<Dx> dxList = dxService.findAll();
        session.setAttribute("dxList", dxList);
        session.setAttribute("dxListSize", dxList.size());
        //公告表gonggao
        List<Gonggao> gonggaoList = gonggaoService.findAll();
        session.setAttribute("gonggaoList", gonggaoList);
        session.setAttribute("gonggaoListSize", gonggaoList.size());
        //活动表huodong
        List<Huodong> huodongList = huodongService.findAll();
        session.setAttribute("huodongList", huodongList);
        session.setAttribute("huodongListSize", huodongList.size());
        //类型表leixing
        List<Leixing> leixingList = leixingService.findAll();
        session.setAttribute("leixingList", leixingList);
        session.setAttribute("leixingListSize", leixingList.size());
        //留言咨询表liuyan
        List<Liuyan> liuyanList = liuyanService.findAll();
        session.setAttribute("liuyanList", liuyanList);
        session.setAttribute("liuyanListSize", liuyanList.size());
        //轮播图表lunbo
        List<Lunbo> lunboList = lunboService.findAll();
        session.setAttribute("lunboList", lunboList);
        session.setAttribute("lunboListSize", lunboList.size());
        //申请表shenqing
        List<Shenqing> shenqingList = shenqingService.findAll();
        session.setAttribute("shenqingList", shenqingList);
        session.setAttribute("shenqingListSize", shenqingList.size());
        //用户表users
        List<Users> usersList = usersService.findAll();
        session.setAttribute("usersList", usersList);
        session.setAttribute("usersListSize", usersList.size());
        //小组表xiaozu
        List<Xiaozu> xiaozuList = xiaozuService.findAll();
        session.setAttribute("xiaozuList", xiaozuList);
        session.setAttribute("xiaozuListSize", xiaozuList.size());

        return mav;
    }
}
