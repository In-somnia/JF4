package ConPoolTest;

import ConnectionPool.ConnectionPool;
import org.junit.Test;

import static junit.framework.TestCase.assertNotNull;

public class ConnectionPoolTest {
    private ConnectionPool cp = new ConnectionPool();
    @Test
            public void takeConnection() throws Exception
    {
        assertNotNull(cp.takeConnection());
    }
}
