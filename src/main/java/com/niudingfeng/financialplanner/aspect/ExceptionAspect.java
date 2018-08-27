package com.niudingfeng.financialplanner.aspect;

import com.niudingfeng.financialplanner.exception.FileUploadTypeException;
import com.niudingfeng.financialplanner.exception.TokenException;
import com.niudingfeng.financialplanner.response.Response;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.converter.HttpMessageNotReadableException;
import org.springframework.validation.BindException;
import org.springframework.web.HttpMediaTypeNotSupportedException;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.multipart.MultipartException;


/**
 * Title: 全局异常处理切面 Description: 利用 @ControllerAdvice + @ExceptionHandler
 * 组合处理Controller层RuntimeException异常
 *
 * @author lin
 * @created 2018年8月22日 下午4:29:07
 */


@ControllerAdvice   // 控制器增强
@ResponseBody
public class ExceptionAspect {


    /**
     * Log4j日志处理(@author: lin)
     */

    private static final Logger log = LoggerFactory.getLogger(ExceptionAspect.class);


    /**
     * 400 - Bad Request
     */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler(HttpMessageNotReadableException.class)
    public Response handleHttpMessageNotReadableException(
            HttpMessageNotReadableException e) {
        log.error("could_not_read_json...", e);
        return new Response().failure("could_not_read_json");
    }

    /**
     * 400 - Bad Request
     * <p>
     * 400 - Bad Request
     * <p>
     * 405 - Method Not Allowed。HttpRequestMethodNotSupportedException
     * 是ServletException的子类,需要Servlet API支持
     * <p>
     * 415 - Unsupported Media Type。HttpMediaTypeNotSupportedException
     * 是ServletException的子类,需要Servlet API支持
     * <p>
     * 500 - Internal Server Error
     * <p>
     * 500 - Internal Server Error
     */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({MethodArgumentNotValidException.class})
    public Response handleValidationException(MethodArgumentNotValidException e) {
        log.error("parameter_validation_exception...", e);
        return new Response().failure("parameter_validation_exception");
    }

    /**
     * 400 - Bad Request
     */

    @ResponseStatus(HttpStatus.BAD_REQUEST)
    @ExceptionHandler({BindException.class})
    public Response beanPropertyBindingException(BindException e) {
        log.error("parameter_validation_exception...", e);
        return new Response().failure(e.getBindingResult().getAllErrors().get(0).getDefaultMessage());
    }


    /**
     * 405 - Method Not Allowed。HttpRequestMethodNotSupportedException
     * 是ServletException的子类,需要Servlet API支持
     */

    @ResponseStatus(HttpStatus.METHOD_NOT_ALLOWED)
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    public Response handleHttpRequestMethodNotSupportedException(
            HttpRequestMethodNotSupportedException e) {
        log.error("request_method_not_supported...", e);
        return new Response().failure("request_method_not_supported");
    }


    /**
     * 415 - Unsupported Media Type。HttpMediaTypeNotSupportedException
     * 是ServletException的子类,需要Servlet API支持
     */

    @ResponseStatus(HttpStatus.UNSUPPORTED_MEDIA_TYPE)
    @ExceptionHandler({HttpMediaTypeNotSupportedException.class})
    public Response handleHttpMediaTypeNotSupportedException(Exception e) {
        log.error("content_type_not_supported...", e);
        return new Response().failure("content_type_not_supported");
    }


    /**
     * 500 - Internal Server Error
     */

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(TokenException.class)
    public Response handleTokenException(Exception e) {
        log.error("Token is invaild...", e);
        return new Response().failure("Token is invaild");
    }

    /**
     *上传文件过大异常处理器
     */
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    @ExceptionHandler(MultipartException.class)
    public Response handleMultipartException(MultipartException e) {
        log.error("上传文件过大...", e);
        return new Response().failure("上传文件过大");
    }
    /**
     *上传文件类型不是图片格式类型
     */
    @ResponseStatus(HttpStatus.PAYLOAD_TOO_LARGE)
    @ExceptionHandler(FileUploadTypeException.class)
    public Response handleMultipartException(FileUploadTypeException e) {
        log.error("文件类型不是图片类型",e);
        return new Response().failure(e.getMsg());
    }

    /**
     * 500 - Internal Server Error
     */

    @ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
    @ExceptionHandler(Exception.class)
    public Response handleException(Exception e) {
        log.error("Internal Server Error...", e);
        return new Response().failure("Internal Server Error");
    }


}

