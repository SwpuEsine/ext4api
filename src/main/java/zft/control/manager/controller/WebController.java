package zft.control.manager.controller;

import zft.control.manager.objs.view.ResponseBase;
import org.apache.log4j.Logger;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletRequest;

public class WebController {
    protected static final Logger LOGGER = Logger.getLogger(WebController.class);

    @ExceptionHandler
    @ResponseBody
    public ResponseBase exp(HttpServletRequest request, Exception ex) {
        LOGGER.error(ex.getLocalizedMessage(), ex);
        return new ResponseBase("999999", ex.getLocalizedMessage());
    }
}
