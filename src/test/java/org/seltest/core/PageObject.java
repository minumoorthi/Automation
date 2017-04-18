package org.seltest.core;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


/**
 * Super class for all Page Object <br/>
 * All Page Object Should implement this interface
 * 
 * @author adityas
 */
public class PageObject {
	/**
	 * An Element Class Instance which should be used to interact with the
	 * WebElements
	 */
	protected final Element element = new Element();
	/**
	 * A Browser Class Instance which should be used to interact with browsers
	 */
	protected final Browser browser = new Browser();
	
	protected final Logger log = LoggerFactory.getLogger(PageObject.class);


}
