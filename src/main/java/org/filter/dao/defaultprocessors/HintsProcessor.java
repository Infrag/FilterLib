package org.filter.dao.defaultprocessors;

import org.filter.dao.Hint;
import org.filter.dao.ProcessorContext;
import java.util.List;

/**
 *
 * @author Ondrej.Bozek
 */
public class HintsProcessor implements ClassProcessor<List<Hint>>
{
    
    @Override
    public void processCustomField(List<Hint> value, ProcessorContext<Object> processorContext)
    {
        if (value != null && !value.isEmpty()) {
            processorContext.getHints().addAll(value);
        }
    }
}
