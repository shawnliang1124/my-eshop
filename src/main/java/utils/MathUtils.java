package utils;

import java.math.BigDecimal;

/**
 * Description :   .
 *
 * @author : Phoebe
 * @date : Created in 2021/5/18
 */
public class MathUtils {

    public static double result(Long a, Long b) {
        return new BigDecimal((float)a/b).setScale(2, BigDecimal.ROUND_HALF_UP).doubleValue();
    }

}
