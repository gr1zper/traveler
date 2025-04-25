package org.app.model.search.criteria.range;

import org.app.infra.util.Checks;

/**
 * Pagination parameters for data retrieval operations
 * @author azubkov
 */
public class RangeCriteria {

    private final int page;
    private final int rowCount;

    public RangeCriteria(final int page, final int rowCount) {
        Checks.checkParameter(page >= 0, "Incorrect page index: " + page);
        Checks.checkParameter(rowCount >= 0, "Incorrect row count: " + rowCount);

        this.page = page;
        this.rowCount = rowCount;
    }

    public int getPage() {
        return page;
    }

    public int getRowCount() {
        return rowCount;
    }

}
