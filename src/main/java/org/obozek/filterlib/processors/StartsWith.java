package org.obozek.filterlib.processors;

import org.obozek.filterlib.CustomProcessor;
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
