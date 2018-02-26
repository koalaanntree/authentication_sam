package com.sam.async;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Author: huangxin
 * @Date: Created in 下午5:04 2018/2/26
 * @Description:
 */
@RestController
public class AsyncController {
    private Logger logger = LoggerFactory.getLogger(getClass());

    @RequestMapping("/order")
    public String order() throws InterruptedException {
        logger.info("主线程开始");
        Thread.sleep(1000);
        logger.info("主线程返回");
        return "success";
    }
}
