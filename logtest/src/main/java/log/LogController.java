package log;

import ch.qos.logback.classic.Level;
import ch.qos.logback.classic.LoggerContext;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LogController {
    private static Logger logger = LoggerFactory.getLogger(LogController.class);

    /**
     * 修改项目日志输出级别
     * @param allLevel 全局日志级别
     * @param singleLevel 某个类日志级别
     * @param singlePath 需要单独设置日志输出级别的类的全限定名（例：log.SecondController）
     * @return
     */
    @RequestMapping(value = "changeLevel")
    public String changeLevel(String allLevel,String singleLevel,String singlePath) {
        LoggerContext loggerContext= (LoggerContext) LoggerFactory.getILoggerFactory();
        if(!StringUtils.isEmpty(allLevel)){
            //设置全局日志级别
            ch.qos.logback.classic.Logger logger=loggerContext.getLogger("root");
            logger.setLevel(Level.toLevel(allLevel));
        }

        if (!StringUtils.isEmpty(singleLevel)) {
            //设置某个类日志级别-可以实现定向日志级别调整
            ch.qos.logback.classic.Logger vLogger = loggerContext.getLogger(singlePath);
            if (vLogger!=null){
                vLogger.setLevel(Level.toLevel(singleLevel));
            }
        }
        return "success";
    }

    @RequestMapping(value = "test")
    public String changeLogLevel() {
        logger.info("这是LogController的Info啊");
        logger.error("这是LogController的error啊");
        logger.debug("这是LogController的debug啊");
        logger.trace("这是LogController的trace啊");
        logger.warn("这是LogController的warn啊");
        return "success";
    }
}