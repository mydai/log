package log;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @ClassName SecondController
 * @Description
 * @Author shenshuiyuan
 * @Date 2018/11/23 17:22
 * @Version 1.0
 **/
@RestController
public class SecondController {

    private static Logger logger = LoggerFactory.getLogger(SecondController.class);

    @RequestMapping(value = "secondtest")
    public String changeLogLevel() {
        logger.info("这是SecondController的Info啊");
        logger.error("这是SecondController的error啊");
        logger.debug("这是SecondController的debug啊");
        logger.trace("这是SecondController的trace啊");
        logger.warn("这是SecondController的warn啊");
        return "success";
    }
}
