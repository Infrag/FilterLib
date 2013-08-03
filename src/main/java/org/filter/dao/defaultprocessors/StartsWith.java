/*
 * Project: FilterLib
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Jul 18, 2013
 *
 * Version: $Revision: $
 *
 * Last revision date: $Date: $
 * Last revision by: $Author: $
 *
 * $Log: $
 */
package org.filter.dao.defaultprocessors;

import org.filter.dao.CustomProcessor;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

/**
 *
 * @author Ondrej.Bozek
 */
@Retention(RetentionPolicy.RUNTIME)
@CustomProcessor(StartsWithProcessor.class)
public @interface StartsWith
{
}
