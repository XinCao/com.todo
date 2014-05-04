package com.todo.util.ncrypt;

import static com.todo.util.ncrypt.KeyGen.logger;
import java.nio.ByteBuffer;
import junit.framework.TestCase;

/**
 *
 * @author caoxin
 */
public class CryptEngineTest extends TestCase {
    
    public CryptEngineTest(String testName) {
        super(testName);
    }
    
    @Override
    protected void setUp() throws Exception {
        super.setUp();
    }
    
    @Override
    protected void tearDown() throws Exception {
        super.tearDown();
    }

    public void testDecrypt() {
    }

    public void testEncrypt() {
        CryptEngine ce = new CryptEngine();
        String account = "caoxin";
        ByteBuffer bb = ByteBuffer.wrap(account.getBytes());
        bb.flip();
        int size = bb.limit() - 2;
        final int offset = bb.arrayOffset() + bb.position();
        ce.encrypt(bb.array(), offset, size);
        account = new String(bb.array());
        logger.info(account);
    }
}
