package app.ipods.wechat.work.exceptions;

/**
 * Created by wangkun23 on 2018/6/11.
 */
public class OAuthException extends RuntimeException {
    /**
     * Default constructor
     *
     * @param message message explaining what went wrong
     * @param e       original exception
     */
    public OAuthException(String message, Exception e) {
        super(message, e);
    }

    /**
     * No-exception constructor. Used when there is no original exception
     *
     * @param message message explaining what went wrong
     */
    public OAuthException(String message) {
        super(message, null);
    }

    /**
     * Exception constructor. Used to simply wrap an exception.
     *
     * @param e original exception
     */
    public OAuthException(Exception e) {
        super(e);
    }
}
