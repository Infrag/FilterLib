package org.filterlib.dao;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import javax.persistence.criteria.Expression;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Selection;
import javax.persistence.metamodel.Bindable;
import javax.persistence.metamodel.MapAttribute;
import javax.persistence.metamodel.PluralAttribute;
import javax.persistence.metamodel.SingularAttribute;
import org.apache.commons.lang.StringUtils;

/**
 *
 * @author Ondrej.Bozek
 */
public class StructuredPathImpl<X> implements StructuredPath<X>
{

    private List<String> pathLevels;
    private Path path;

    StructuredPathImpl(Path path)
    {
        this(path, new ArrayList<String>());
    }

    StructuredPathImpl(Path path, List<String> pathLevels)
    {
        this.path = path;
        this.pathLevels = pathLevels;
    }

    /**
     * method navigates from starting point using provided path
     *
     * @param startingPoint
     * @return constructed Path object
     */
    public StructuredPath navigate(String relativePath)
    {
        return navigate(relativePath, StructuredPathFactory.FILTER_PATH_SEPARATOR);
    }

    /**
     * method navigates from starting point using provided path with specified
     * separator
     *
     * @param relativePath
     * @param separator
     * @return
     */
    public StructuredPath navigate(String relativePath, String separator)
    {
        List<String> levels = Arrays.asList(StringUtils.split(relativePath, separator));
        return navigate(levels);
    }

    /**
     *
     * @param levels
     * @return
     */
    public StructuredPath navigate(List<String> levels)
    {
        for (String string : levels) {
            pathLevels.add(string);
            path = path.get(string);
        }
        return this;
    }

    public List<String> getPathLevels()
    {
        return pathLevels;
    }

    public Bindable getModel()
    {
        return path.getModel();
    }

    public Path getParentPath()
    {
        return path.getParentPath();
    }

    public Path get(SingularAttribute attribute)
    {
        return path.get(attribute);
    }

    public Expression get(PluralAttribute collection)
    {
        return path.get(collection);
    }

    public Expression get(MapAttribute map)
    {
        return path.get(map);
    }

    public Expression type()
    {
        return path.getParentPath();

    }

    public Path get(String attributeName)
    {
        return path.getParentPath();

    }

    public Predicate isNull()
    {
        return path.isNull();

    }

    public Predicate isNotNull()
    {
        return path.isNotNull();

    }

    public Predicate in(Object... values)
    {
        return path.in(values);

    }

    public Predicate in(Expression... values)
    {
        return path.in(values);

    }

    public Predicate in(Collection values)
    {
        return path.in(values);

    }

    public Predicate in(Expression values)
    {
        return path.in(values);

    }

    public Expression as(Class type)
    {
        return path.as(type);

    }

    public Selection alias(String name)
    {
        return path.alias(name);

    }

    public boolean isCompoundSelection()
    {
        return path.isCompoundSelection();

    }

    public List getCompoundSelectionItems()
    {
        return path.getCompoundSelectionItems();

    }

    public Class getJavaType()
    {
        return path.getJavaType();

    }

    public String getAlias()
    {
        return path.getAlias();
    }

    public Path getPath()
    {
        return path;
    }
}
