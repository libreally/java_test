package exception;

/**
 * 非法的年龄异常
 *
 * 自定义异常通常用于那些满足语法但是不满足业务场景的地方。
 * 自定义异常需要满足以下几点:
 * 1:类名要做到见名知义
 * 2:需要继承自Exception(直接或间接继承均可)
 * 3:提供超类异常提供的所有构造器
 */
public class IllegalAgeException extends Exception{
    public IllegalAgeException() {
    }

    public IllegalAgeException(String message) {
        super(message);
    }

    public IllegalAgeException(String message, Throwable cause) {
        super(message, cause);
    }

    public IllegalAgeException(Throwable cause) {
        super(cause);
    }

    public IllegalAgeException(String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
    }
}
