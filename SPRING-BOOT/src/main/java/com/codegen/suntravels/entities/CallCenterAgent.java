package com.codegen.suntravels.entities;

import javax.persistence.*;

@Entity
@Table(name = "SM_CALL_CENTER_AGENT", schema = "SYS", catalog = "")
public class CallCenterAgent {

    @Id
    @GeneratedValue
    @Column(name = "CC_AGENT_ID")
    private Integer ccAgentID;

    @Column(name = "CC_AGENT_NAME")
    private String ccAgentName;

    public Integer getCcAgentID() {
        return ccAgentID;
    }

    public void setCcAgentID(Integer ccAgentID) {
        this.ccAgentID = ccAgentID;
    }

    public String getCcAgentName() {
        return ccAgentName;
    }

    public void setCcAgentName(String ccAgentName) {
        this.ccAgentName = ccAgentName;
    }

    @Override
    public String toString() {
        return "CallCenterAgent{" +
                "ccAgentID=" + ccAgentID +
                ", ccAgentName='" + ccAgentName + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        CallCenterAgent that = (CallCenterAgent) o;

        if (!ccAgentID.equals(that.ccAgentID)) return false;
        return ccAgentName.equals(that.ccAgentName);
    }

    @Override
    public int hashCode() {
        int result = ccAgentID.hashCode();
        result = 31 * result + ccAgentName.hashCode();
        return result;
    }
}
