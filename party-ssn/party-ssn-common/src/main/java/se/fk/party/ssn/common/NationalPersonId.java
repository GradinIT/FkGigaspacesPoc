package se.fk.party.ssn.common;

import java.io.Serializable;

public abstract class NationalPersonId implements Serializable {
    public abstract String getId();
    public abstract Boolean isValid();
}
