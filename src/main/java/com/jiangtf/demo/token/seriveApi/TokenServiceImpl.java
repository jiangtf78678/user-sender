//package com.jiangtf.demo.token.seriveApi;
//
//import com.jiangtf.demo.token.service.TokenService;
//import com.jiangtf.demo.utils.KeyUtil;
//import com.jiangtf.demo.utils.RediesService;
//import org.apache.commons.lang3.RandomUtils;
//import org.springframework.beans.factory.annotation.Autowired;
//import tk.mybatis.mapper.util.StringUtil;
//
//import javax.servlet.http.HttpServletRequest;
//import java.util.Random;
//
//public class TokenServiceImpl  implements TokenService {
//
//    public static   final  String TOKEN_PREFIX="redis";
//    public static   final  String TOKEN_NAME="redis";
//
//    @Autowired
//    private RediesService rediesService;
//
//
//    /**
//     * @Author jiangtf
//     * @Description 创建token
//     * @Date 16:14 2020/6/2
//     * @Param []
//     * @return java.lang.String
//     **/
//    @Override
//    public String createToken() {
//        String str= KeyUtil.generatorUUID();
//        StringBuilder token=new StringBuilder();
//        try{
//            token.append(TOKEN_PREFIX).append(str);
//            rediesService.setEx(token.toString(),token.toString(),10000L);
//            boolean notEmpty= StringUtil.isNotEmpty(token.toString());
//            if (notEmpty){
//                return  token.toString();
//            }
//        }catch (Exception e){
//            e.printStackTrace();
//        }
//        return null;
//    }
//
//
//     /**
//      * @Author jiangtf
//      * @Description 校验token
//      * @Date 16:27 2020/6/2
//      * @Param [request]
//      * @return boolean
//      **/
//    @Override
//    public boolean checkToken(HttpServletRequest request) throws Exception {
//
//        String token=request.getHeader(TOKEN_NAME);
//        if ("".equals(token)||token==null){//header中不存在toekn
//            token=request.getParameter(TOKEN_NAME);
//            if ("".equals(token)||token==null){
////                throw new ServiceExp
//            }
//        }
//
//     if (!rediesService.exists(token)){
//         //toekn不存在
////         throw  new
//     }
//     boolean remove =rediesService.remove(token);
//
//     if (!remove){
////         throw new
//     }
//
//        return true;
//    }
//}
