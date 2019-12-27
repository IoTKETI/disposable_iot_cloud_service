package kr.re.keti.disposable.cloudservice.cloudserver.common;

import com.fasterxml.jackson.core.JsonParseException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.ResponseEntity;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.servlet.NoHandlerFoundException;

import java.sql.SQLException;

@RestControllerAdvice
public class GlobalExceptionHandler {

    Logger logger = LoggerFactory.getLogger(this.getClass());

    /**
     * URL not found 에러 공통 처리 (404)
     */
    @ExceptionHandler(NoHandlerFoundException.class)
    protected ResponseEntity<Response> NoHandlerFoundException(NoHandlerFoundException e) {
        this.setLogger(e);
        Response response = new Response(ResponseCode.NOT_FOUND.getDetailCode(), ResponseCode.NOT_FOUND.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(response, ResponseCode.NOT_FOUND.getHttpStatusCode());
    }


    /**
     * @Validate 으로 검증 error 발생시 발생 (400)
     */
    @ExceptionHandler(MethodArgumentNotValidException.class)
    protected ResponseEntity<Response> handleArgumentNotValidException(MethodArgumentNotValidException e) {
        this.setLogger(e);
        Response response = new Response(ResponseCode.INVALID_PARAMETER_TYPE.getDetailCode(), ResponseCode.INVALID_PARAMETER_TYPE.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(response, ResponseCode.INVALID_PARAMETER_TYPE.getHttpStatusCode());
    }


    /**
     * 지원하지 않은 HTTP method 호출 할 경우 발생 (405)
     */
    @ExceptionHandler(HttpRequestMethodNotSupportedException.class)
    protected ResponseEntity<Response>  handleHttpRequestMethodNotSupportedException(HttpRequestMethodNotSupportedException e) {
        this.setLogger(e);
        Response response = new Response(ResponseCode.METHOD_NOT_ALLOWED.getDetailCode(), ResponseCode.METHOD_NOT_ALLOWED.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(response, ResponseCode.METHOD_NOT_ALLOWED.getHttpStatusCode());
    }

    /**
     * Json Parsing 에러가 날 경우 (400)
     */
    @ExceptionHandler(JsonParseException.class)
    protected ResponseEntity<Response>  JsonParseExceptionException(JsonParseException e) {
        this.setLogger(e);
        Response response = new Response(ResponseCode.BAD_REQUEST.getDetailCode(), ResponseCode.BAD_REQUEST.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(response, ResponseCode.BAD_REQUEST.getHttpStatusCode());
    }

//    /**
//     * DB 중복 에러 (409)
//     */
//    @ExceptionHandler(DuplicateKeyException.class)
//    protected ResponseEntity<Response>  DuplicateKeyException(DuplicateKeyException e) {
//        this.setLogger(e);
//        Response response = new Response(ResponseCode.CONFLICT.getDetailCode(), ResponseCode.CONFLICT.getReasonPhrase(), e.getMessage());
//        return new ResponseEntity<>(response, ResponseCode.CONFLICT.getHttpStatusCode());
//    }
//
//    /**
//     * DB 요청 에러 (400)
//     */
//    @ExceptionHandler(DataIntegrityViolationException.class)
//    protected ResponseEntity<Response>  DataIntegrityViolationException(DataIntegrityViolationException e) {
//        this.setLogger(e);
//        Response response = new Response(ResponseCode.BAD_REQUEST.getDetailCode(), ResponseCode.BAD_REQUEST.getReasonPhrase(), e.getMessage());
//        return new ResponseEntity<>(response, ResponseCode.BAD_REQUEST.getHttpStatusCode());
//    }


    /**
     * DB Connection Error (500)
     */
    @ExceptionHandler(SQLException.class)
    protected ResponseEntity<Response>  handleDataIntegrityViolationException(SQLException e) {
        this.setLogger(e);
        Response response = new Response(ResponseCode.INTERNAL_SERVER_ERROR.getDetailCode(), ResponseCode.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(response, ResponseCode.INTERNAL_SERVER_ERROR.getHttpStatusCode());
    }


    /**
     * 그외 Error 발생 시 (500)
     */
    @ExceptionHandler(Exception.class)
    protected ResponseEntity<Response> handleException(Exception e) {
        this.setLogger(e);
        Response response = new Response(ResponseCode.INTERNAL_SERVER_ERROR.getDetailCode(), ResponseCode.INTERNAL_SERVER_ERROR.getReasonPhrase(), e.getMessage());
        return new ResponseEntity<>(response, ResponseCode.INTERNAL_SERVER_ERROR.getHttpStatusCode());
    }

    private void setLogger(Exception e) {
        logger.debug("error occurs : " + e.getMessage());
    }


}
