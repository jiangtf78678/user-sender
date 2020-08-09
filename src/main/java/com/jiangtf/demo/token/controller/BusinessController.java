//package com.jiangtf.demo.token.controller;
//
//
//import com.alibaba.fastjson.JSONObject;
//import com.jiangtf.demo.entity.ResultVo;
//import com.jiangtf.demo.token.seriveApi.TokenServiceImpl;
//import com.jiangtf.demo.token.service.TokenService;
//import com.jiangtf.demo.utils.AutoIdempotent;
//import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.RestController;
//import tk.mybatis.mapper.util.StringUtil;
//
//import javax.annotation.Resource;
//
//@RestController
//public class BusinessController {
//
//
////    @Resource
////    private TokenService tokenService;
//
//    @Resource
//    private TokenServiceImpl tokenServiceimpl;
//
//
//    public String getToken(){
//        String token=tokenServiceimpl.createToken();
//        if (!StringUtil.isEmpty(token)){
//            ResultVo resultVo=new ResultVo();
//
//            resultVo.setCode("001");
//            resultVo.setMessage("success");
//            resultVo.setData(token);
//            return JSONObject.toJSONString(resultVo);
//        }
//        return "null-string";
//    }
//
//    @AutoIdempotent
//    @PostMapping("/test/Idempotentce")
//    public String testIdempotentce(){
//          return null;
//    }
//}
