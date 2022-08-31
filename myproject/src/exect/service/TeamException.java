package exect.service;

/**
 * 自定义异常类
 *1.先继承Exception类
 * 2.提供身份id
 *
 */
public class TeamException extends Exception {
    static final long serialVersionUID = -3387516993124229948L;
    public TeamException(String msg){
        super(msg);
    }
}
