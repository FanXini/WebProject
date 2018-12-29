package Redis;

import org.junit.runner.RunWith;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import config.RedisConfigByImportXml;
import config.RedisConfigByJavaBean;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=RedisConfigByJavaBean.class)
public class BaseConfig {
	

}
