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
public interface StructuredPath extends Path
{

    /**
     * method navigates from starting point using provided path
     *
     * @param startingPoint
     * @return constructed Path object
     */
    public StructuredPath navigate(String relativePath);

    /**
     * method navigates from starting point using provided path with specified
     * separator
     *
     * @param relativePath
     * @param separator
     * @return
     */
    public StructuredPath navigate(String relativePath, String separator);

    /**
     * method navigates from starting point using provided levels
     *
     * @param relativePath
     * @param startingPoint
     * @return
     */
    public StructuredPath navigate(List<String> levels);

    /**
     * Method returns List with separate levels along this path from starting
     * point
     *
     * @return
     */
    public List<String> getPathLevels();

    /**
     * Method returns original wrapped path object
     *
     * @return
     */
    public Path getPath();
}
