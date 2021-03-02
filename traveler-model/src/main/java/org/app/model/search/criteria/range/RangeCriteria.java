package org.app.model.search.criteria.range;

/**
 * Pagination parameters for data retrieval operations
 * @author azubkov
 */
public class RangeCriteria {

    private final int page;

    private final int rowCount;

    public RangeCriteria(final int page, final int rowCount) {
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
