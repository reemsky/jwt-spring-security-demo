package org.zerhusen.rest;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;

public abstract class LogEnabledClass {
	protected Logger log = LogManager.getLogger(this.getClass().getName());
}
