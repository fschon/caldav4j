package org.osaf.caldav4j.model.request;

import org.junit.Test;
import org.osaf.caldav4j.BaseTestCase;
import org.osaf.caldav4j.exceptions.DOMValidationException;
import org.osaf.caldav4j.util.XMLUtils;

import static org.junit.Assert.*;

public class ParamFilterTest extends BaseTestCase {
	
	/**
	 * Don't need setUp here
	 */
	@Override
	public void setUp() throws Exception {};
	
	
	@Test
        public void testSimpleConstructor() {
                ParamFilter p = new ParamFilter();
                try {
                        //This won't work because name will be null
                        p.validate();
                        fail("should fail if no name specified");
                } catch (DOMValidationException e) {
                        assertNotNull("Ok, doesn't accept null name", e);
                }
        }
	@Test
        public void testName() {
                ParamFilter p = new ParamFilter();
                p.setName("newname");
                assertEquals(p.getName(), "newname");
                try {
                        p.validate();
                        log.info(XMLUtils.prettyPrint(p));
                } catch (DOMValidationException e) {
                        fail("Should have a valid ParamFilter");
                }
                
                p.setDefined(false);
        }
	@Test
        public void testDefined() {
            ParamFilter p = new ParamFilter();
            p.setName("testDefined");
            assertEquals(p.getName(), "testDefined");
            p.setDefined(true);

            try {
                    p.validate();
                    log.info(XMLUtils.prettyPrint(p));
            } catch (DOMValidationException e) {
                    fail("Should have a valid ParamFilter");
            }
            
    }	
        @Test
        public void testTextMatch() {
            ParamFilter p = new ParamFilter();
            p.setName("testDefined");
            assertEquals(p.getName(), "testDefined");
            p.setTextMatch(new TextMatch(null,null,null,"testTextMatch"));
            try {
                    p.validate();
                    log.info(XMLUtils.prettyPrint(p));
            } catch (DOMValidationException e) {
                    fail("Should have a valid ParamFilter");
            }
            
    }
        
}