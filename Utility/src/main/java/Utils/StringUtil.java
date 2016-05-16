package Utils;

/**
 * Created by allen7593 on 2016/5/10.
 */
public class StringUtil {
    public static boolean isEmpty(String arg){
        if (arg == null) {
            return true;
        }
        if (arg.trim().equalsIgnoreCase("")){
            return true;
        }
        return false;
    }
}
