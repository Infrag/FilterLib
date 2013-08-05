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
