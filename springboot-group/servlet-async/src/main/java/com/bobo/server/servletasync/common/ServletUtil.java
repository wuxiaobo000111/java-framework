package com.bobo.server.servletasync.common;

import com.alibaba.fastjson.JSON;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.AsyncContext;
import javax.servlet.http.HttpServletResponse;
import java.util.Map;

/**
 * @create 2019-03-06 23:00
 **/
public class ServletUtil {

   private static Logger logger  =LoggerFactory.getLogger(ServletUtil.class);

   public static void doResponse(AsyncContext asyncContext, Object result, String uri, Map<String, String[]> map) {
       HttpServletResponse resp = (HttpServletResponse) asyncContext.getResponse();
       try {
           if (result instanceof String) {
               write(resp, (String) result);
           } else {
               write(resp, JSON.toJSONString(result));
           }
       } catch (Throwable e) {
           //程序内部错误
           resp.setStatus(HttpServletResponse.SC_INTERNAL_SERVER_ERROR);
           try {
               logger.error("doResponse write failed. uri : {},  params : {}", uri, JSON.toJSONString(map), e);
           } catch (Exception ex) {
           }
       } finally {
           try {
               asyncContext.complete();
           }catch (Exception e){
               logger.error("doResponse asyncContext.complete failed. uri : {},  params : {}", uri, JSON.toJSONString(map), e);
           }
       }
   }

    private static void write(HttpServletResponse resp, String result) {
        try {
            resp.setHeader("Content-Type", "application/json;;charset=utf-8");
            resp.getWriter().write(result);
            resp.getWriter().flush();
        } catch (Exception e) {
            logger.error("Writer write failed.", e);
        } finally {
            try {
                resp.getWriter().close();
            } catch (Exception e) {
            }
        }
    }
}
