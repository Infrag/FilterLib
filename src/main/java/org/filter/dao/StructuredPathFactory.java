/*
 * Project: FilterLib
 * Copyright: ASSECO CE (c) 2011
 * $Workfile: $
 * Author: Ondrej Bozek
 * Created: Jul 24, 2013
 *
 * Version: $Revision: $
 *
 * Last revision date: $Date: $
 * Last revision by: $Author: $
 *
 * $Log: $
 */
package org.filter.dao;

import java.util.List;
import javax.persistence.criteria.Path;

/**
 *
 * @author Ondrej.Bozek
 */
public class StructuredPathFactory
{

    public static final String FILTER_PATH_SEPARATOR = "_";

    /**
     * method navigates from starting point using provided path
     *
     * @param relativePath
     * @param startingPoint
     * @return constructed Path object
     */
    public static StructuredPath navigate(String relativePath, Path startingPoint)
    {
        return new StructuredPathImpl(startingPoint).navigate(relativePath);
    }

    /**
     * method navigates from starting point using provided path with specified
     * separator
     *
     * @param relativePath
     * @param separator
     * @param startingPoint
     * @return
     */
    public static StructuredPath navigate(String relativePath, String separator, Path startingPoint)
    {
        return new StructuredPathImpl(startingPoint).navigate(relativePath, separator);
    }

    /**
     * method navigates from starting point using provided levels
     *
     * @param relativePath
     * @param startingPoint
     * @return
     */
    public static StructuredPath navigate(List<String> levels, Path startingPoint)
    {
        return new StructuredPathImpl(startingPoint).navigate(levels);
    }
}
