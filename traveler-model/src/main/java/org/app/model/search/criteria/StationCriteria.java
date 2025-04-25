package org.app.model.search.criteria;

import org.app.model.entity.transport.TransportType;

/**
 * Filtering criteria for search station operation
 * @author azubkov
 */
public class StationCriteria {

    /**
     * City's name
     */
    private String name;

    private TransportType transportType;

    /**
     * Station's address: street, zipCode, building number
     */
    private String address;

    /**
     * Returns filtering criteria to search stations that contains specified name parameter
     * @param name
     * @return
     */
    public static StationCriteria byName(String name) {
        return new StationCriteria(name);
    }

    public StationCriteria() {}

    public StationCriteria(final String name) {
        this.name = name;
    }

    public StationCriteria(TransportType transportType) {
        this.transportType = transportType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TransportType getTransportType() {
        return transportType;
    }

    public void setTransportType(TransportType transportType) {
        this.transportType = transportType;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

}
