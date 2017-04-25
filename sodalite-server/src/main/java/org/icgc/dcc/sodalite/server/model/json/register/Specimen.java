
package org.icgc.dcc.sodalite.server.model.json.register;

import java.util.HashMap;
import java.util.Map;
import com.fasterxml.jackson.annotation.JsonAnyGetter;
import com.fasterxml.jackson.annotation.JsonAnySetter;
import com.fasterxml.jackson.annotation.JsonCreator;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.fasterxml.jackson.annotation.JsonValue;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({
    "specimenSubmitterId",
    "specimenClass",
    "specimenType",
    "sample"
})
public class Specimen {

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("specimenSubmitterId")
    private String specimenSubmitterId;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("specimenClass")
    private Specimen.SpecimenClass specimenClass;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("specimenType")
    private Specimen.SpecimenType specimenType;
    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sample")
    private Sample sample;
    @JsonIgnore
    private Map<String, Object> additionalProperties = new HashMap<String, Object>();

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("specimenSubmitterId")
    public String getSpecimenSubmitterId() {
        return specimenSubmitterId;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("specimenSubmitterId")
    public void setSpecimenSubmitterId(String specimenSubmitterId) {
        this.specimenSubmitterId = specimenSubmitterId;
    }

    public Specimen withSpecimenSubmitterId(String specimenSubmitterId) {
        this.specimenSubmitterId = specimenSubmitterId;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("specimenClass")
    public Specimen.SpecimenClass getSpecimenClass() {
        return specimenClass;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("specimenClass")
    public void setSpecimenClass(Specimen.SpecimenClass specimenClass) {
        this.specimenClass = specimenClass;
    }

    public Specimen withSpecimenClass(Specimen.SpecimenClass specimenClass) {
        this.specimenClass = specimenClass;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("specimenType")
    public Specimen.SpecimenType getSpecimenType() {
        return specimenType;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("specimenType")
    public void setSpecimenType(Specimen.SpecimenType specimenType) {
        this.specimenType = specimenType;
    }

    public Specimen withSpecimenType(Specimen.SpecimenType specimenType) {
        this.specimenType = specimenType;
        return this;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sample")
    public Sample getSample() {
        return sample;
    }

    /**
     * 
     * (Required)
     * 
     */
    @JsonProperty("sample")
    public void setSample(Sample sample) {
        this.sample = sample;
    }

    public Specimen withSample(Sample sample) {
        this.sample = sample;
        return this;
    }

    @Override
    public String toString() {
        return ToStringBuilder.reflectionToString(this);
    }

    @JsonAnyGetter
    public Map<String, Object> getAdditionalProperties() {
        return this.additionalProperties;
    }

    @JsonAnySetter
    public void setAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
    }

    public Specimen withAdditionalProperty(String name, Object value) {
        this.additionalProperties.put(name, value);
        return this;
    }

    public enum SpecimenClass {

        NORMAL("Normal"),
        TUMOUR("Tumour"),
        ADJACENT_NORMAL("Adjacent normal");
        private final String value;
        private final static Map<String, Specimen.SpecimenClass> CONSTANTS = new HashMap<String, Specimen.SpecimenClass>();

        static {
            for (Specimen.SpecimenClass c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private SpecimenClass(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Specimen.SpecimenClass fromValue(String value) {
            Specimen.SpecimenClass constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

    public enum SpecimenType {

        NORMAL_SOLID_TISSUE("Normal - solid tissue"),
        NORMAL_BLOOD_DERIVED("Normal - blood derived"),
        NORMAL_BONE_MARROW("Normal - bone marrow"),
        NORMAL_TISSUE_ADJACENT_TO_PRIMARY("Normal - tissue adjacent to primary"),
        NORMAL_BUCCAL_CELL("Normal - buccal cell"),
        NORMAL_EBV_IMMORTALIZED("Normal - EBV immortalized"),
        NORMAL_LYMPH_NODE("Normal - lymph node"),
        NORMAL_OTHER("Normal - other"),
        PRIMARY_TUMOUR_SOLID_TISSUE("Primary tumour - solid tissue"),
        PRIMARY_TUMOUR_BLOOD_DERIVED_PERIPHERAL_BLOOD("Primary tumour - blood derived (peripheral blood)"),
        PRIMARY_TUMOUR_BLOOD_DERIVED_BONE_MARROW("Primary tumour - blood derived (bone marrow)"),
        PRIMARY_TUMOUR_ADDITIONAL_NEW_PRIMARY("Primary tumour - additional new primary"),
        PRIMARY_TUMOUR_OTHER("Primary tumour - other"),
        RECURRENT_TUMOUR_SOLID_TISSUE("Recurrent tumour - solid tissue"),
        RECURRENT_TUMOUR_BLOOD_DERIVED_PERIPHERAL_BLOOD("Recurrent tumour - blood derived (peripheral blood)"),
        RECURRENT_TUMOUR_BLOOD_DERIVED_BONE_MARROW("Recurrent tumour - blood derived (bone marrow)"),
        RECURRENT_TUMOUR_OTHER("Recurrent tumour - other"),
        METASTATIC_TUMOUR_NOS("Metastatic tumour - NOS"),
        METASTATIC_TUMOUR_LYMPH_NODE("Metastatic tumour - lymph node"),
        METASTATIC_TUMOUR_METASTASIS_LOCAL_TO_LYMPH_NODE("Metastatic tumour - metastasis local to lymph node"),
        METASTATIC_TUMOUR_METASTASIS_TO_DISTANT_LOCATION("Metastatic tumour - metastasis to distant location"),
        METASTATIC_TUMOUR_ADDITIONAL_METASTATIC("Metastatic tumour - additional metastatic"),
        XENOGRAFT_DERIVED_FROM_PRIMARY_TUMOUR("Xenograft - derived from primary tumour"),
        XENOGRAFT_DERIVED_FROM_TUMOUR_CELL_LINE("Xenograft - derived from tumour cell line"),
        CELL_LINE_DERIVED_FROM_TUMOUR("Cell line - derived from tumour"),
        PRIMARY_TUMOUR_LYMPH_NODE("Primary tumour - lymph node"),
        METASTATIC_TUMOUR_OTHER("Metastatic tumour - other"),
        CELL_LINE_DERIVED_FROM_XENOGRAFT_TUMOUR("Cell line - derived from xenograft tumour");
        private final String value;
        private final static Map<String, Specimen.SpecimenType> CONSTANTS = new HashMap<String, Specimen.SpecimenType>();

        static {
            for (Specimen.SpecimenType c: values()) {
                CONSTANTS.put(c.value, c);
            }
        }

        private SpecimenType(String value) {
            this.value = value;
        }

        @Override
        public String toString() {
            return this.value;
        }

        @JsonValue
        public String value() {
            return this.value;
        }

        @JsonCreator
        public static Specimen.SpecimenType fromValue(String value) {
            Specimen.SpecimenType constant = CONSTANTS.get(value);
            if (constant == null) {
                throw new IllegalArgumentException(value);
            } else {
                return constant;
            }
        }

    }

}
