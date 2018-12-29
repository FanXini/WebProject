package concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes=AOPConfig.class)
public class Main {
	@Autowired
	private Performance JChou;
	@Test
	public void Test() {
		Encorable encorable=(Encorable)JChou;
		encorable.performEncore();
	}

}
