package org.filter.dao.defaultprocessors;

import org.filter.dao.CustomProcessor;
import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Marked field is processed very naively like fulltext, its just little bit
 * extended comparison Details can be seen in very simple implementation -
 * NaiveFullTextProcessor
 *
 * @author Ondrej.Bozek
 */
@Target({ElementType.TYPE, ElementType.ANNOTATION_TYPE, ElementType.FIELD})
@Retention(RetentionPolicy.RUNTIME)
@CustomProcessor(NaiveFullTextProcessor.class)
public @interface NaiveFullText
{
}
