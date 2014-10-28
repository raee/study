package as.test.rae.log;

import android.test.AndroidTestCase;
import android.util.Log;

import com.rae.log.LogConfig;
import com.rae.log.Logger;
import com.rae.log.LoggerManager;

public class TestLog extends AndroidTestCase {

	public void testConfig() {
		LogConfig config = new LogConfig();
		config.enableFile(true);

		Logger log = LoggerManager.getLogger(config, "TestLog");
		log.v("这是一条V信息！");
		log.d("这是一条D信息");
		log.i("这是一条I信息");
		log.w("这是一条W信息");
		log.e("这是一条E信息");

	}
}
