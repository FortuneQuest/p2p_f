package cn.oc.domain;

import okhttp3.internal.http2.ErrorCode;

/**
 * Created with IntelliJ IDEA.
 *
 * @ClassName : BusinessException
 * @Author: oc
 * @Date: 2023/02/27/16:59
 * @Description:
 **/
public class BusinessException  extends RuntimeException{
    private static final long serialVersionUID = 5565760508056698922L;

    private ErrorCode errorCode;

    public BusinessException(ErrorCode errorCode){
        super();
        this.errorCode =errorCode;
    }

    public BusinessException (){
        super();
    }

    public BusinessException(String arg0 , Throwable arg1
            ,boolean arg2 , boolean arg3){
        super(arg0,arg1,arg2,arg3);
    }

    public BusinessException(ErrorCode errorCode,String arg0,
                             Throwable arg1,boolean arg2 ,boolean arg3){
        super(arg0,arg1,arg2,arg3);
        this.errorCode =errorCode;
    }

    public BusinessException(String arg0,Throwable arg1){
        super(arg0,arg1);
    }

    public BusinessException(ErrorCode errorCode,String arg0,Throwable arg1){
        super(arg0,arg1);
        this.errorCode=errorCode;
    }
    public  BusinessException(String arg0){
        super(arg0);
    }

    public BusinessException (ErrorCode errorCode ,String arg0){
        super(arg0);
       this.errorCode = errorCode;

    }

    public BusinessException (Throwable arg0){
        super(arg0);
    }

    public BusinessException (ErrorCode errorCode ,Throwable arg0){
        super(arg0);
        this.errorCode=errorCode;
    }

    public ErrorCode getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(ErrorCode errorCode) {
        this.errorCode = errorCode;
    }
}
