package com.todo.util.ncrypt;

import junit.framework.TestCase;

/**
 *
 * @author caoxin
 */
public class KeyGenTest extends TestCase {
    
    public KeyGenTest(String testName) {
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

    public void testInit() {
        KeyGen.init();
        KeyGen.generateBlowfishKey();
        KeyGen.getEncryptedRSAKeyPair();
    }
}
