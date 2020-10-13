import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zxp
 * @date 2020-10-12 19:40
 */
@Slf4j
public class Test01 {

    @Test
    public void  test01(){
        BigDecimal number=new BigDecimal("1000");
//        number.setScale(2, BigDecimal.ROUND_UP);
        log.info(number.multiply(new BigDecimal(0.3)).toString());
    }
}
