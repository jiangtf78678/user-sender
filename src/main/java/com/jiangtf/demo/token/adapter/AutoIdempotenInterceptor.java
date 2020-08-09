//package com.jiangtf.demo.token.adapter;
//
//
//import com.jiangtf.demo.token.service.TokenService;
//import com.jiangtf.demo.utils.AutoIdempotent;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Component;
//import org.springframework.web.method.HandlerMethod;
//import org.springframework.web.servlet.HandlerInterceptor;
//import org.springframework.web.servlet.ModelAndView;
//
//import javax.servlet.http.HttpServletRequest;
//import javax.servlet.http.HttpServletResponse;
//import java.io.PrintWriter;
//import java.lang.reflect.Method;
//
//
///**
// * @Author jiangtf
// * @Description 拦截器
// * @Date 16:36 2020/6/2
// * @Param
// * @return
// **/
//@Component
//public class AutoIdempotenInterceptor implements HandlerInterceptor {
//
//    @Autowired
//    private TokenService tokenService;
//
//
//     /**
//      * @Author jiangtf
//      * @Description 预处理
//      * @Date 16:39 2020/6/2
//      * @Param [request, response, handler]
//      * @return boolean
//      **/
//    @Override
//    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
//       if(!(handler instanceof HandlerMethod)){
//           return  true;
//       }
//       HandlerMethod handlerMethod= (HandlerMethod) handler;
//        Method method =handlerMethod.getMethod();
//
//        //被API标记的扫描
//           AutoIdempotent methodAnnotation= method.getAnnotation(AutoIdempotent.class);
//
//           if (methodAnnotation!=null){
//               try{
//                   //幂等性校验，校验成功则放行，校验失败则返回友好提示
//                   return tokenService.checkToken(request);
//
//
//               }catch (Exception e){
////
////
////
//               }
//           }
//        return true;
//    }
//
//    @Override
//    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
//
//    }
//
//    @Override
//    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
//
//    }
//
//
//    private  void writeReturnJson(HttpServletResponse response ,String json)throws  Exception{
//        PrintWriter writer=null;
//
//        response.setCharacterEncoding("UTF-8");
//        response.setContentType("text/html;charset=utf-8");
//
//        try{
//            writer=response.getWriter();
//            writer.println(json);
//        }catch (Exception e){
//
//        }finally {
//            if (writer!=null){
//                writer.close();
//            }
//        }
//    }
//}
