/*
 * Copyright (c) 2017 The Ontario Institute for Cancer Research. All rights reserved.
 *
 * This program and the accompanying materials are made available under the terms of the GNU Public License v3.0.
 * You should have received a copy of the GNU General Public License along with
 * this program. If not, see <http://www.gnu.org/licenses/>.
 *
 * THIS SOFTWARE IS PROVIDED BY THE COPYRIGHT HOLDERS AND CONTRIBUTORS "AS IS" AND ANY
 * EXPRESS OR IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 * OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED. IN NO EVENT
 * SHALL THE COPYRIGHT HOLDER OR CONTRIBUTORS BE LIABLE FOR ANY DIRECT, INDIRECT,
 * INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT NOT LIMITED
 * TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE, DATA, OR PROFITS;
 * OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY THEORY OF LIABILITY, WHETHER
 * IN CONTRACT, STRICT LIABILITY, OR TORT (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN
 * ANY WAY OUT OF THE USE OF THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
 *
 */

package org.icgc.dcc.sodalite.server.model.entity;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

import com.fasterxml.jackson.annotation.*;
import org.apache.commons.lang.builder.ToStringBuilder;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonPropertyOrder({ "donorId", "donorSubmitterId", "donorGender", "specimens"})
public class Donor implements Entity {

  @JsonProperty("donorId")
  private String donorId;

  @JsonProperty("donorSubmitterId")
  private String donorSubmitterId;

  @JsonProperty("donorGender")
  private DonorGender donorGender;

  @JsonProperty("specimens")
  private Collection<Specimen> specimens;

  @JsonIgnore
  private Map<String, Object> additionalProperties = new HashMap<String, Object>();

  @JsonProperty("donorId")
  public String getDonorId() {
    return donorId;
  }

  @JsonProperty("donorId")
  public void setDonorId(String donorId) {
    this.donorId = donorId;
  }

  public Donor withDonorId(String donorId) {
    this.donorId = donorId;
    return this;
  }

  @JsonProperty("donorSubmitterId")
  public String getDonorSubmitterId() {
    return donorSubmitterId;
  }

  @JsonProperty("donorSubmitterId")
  public void setDonorSubmitterId(String donorSubmitterId) {
    this.donorSubmitterId = donorSubmitterId;
  }

  public Donor withDonorSubmitterId(String donorSubmitterId) {
    this.donorSubmitterId = donorSubmitterId;
    return this;
  }

  @JsonProperty("donorGender")
  public DonorGender getDonorGender() {
    return donorGender;
  }

  @JsonProperty("donorGender")
  public void setDonorGender(DonorGender donorGender) {
    this.donorGender = donorGender;
  }

  public Donor withDonorGender(DonorGender donorGender) {
    this.donorGender = donorGender;
    return this;
  }

  @JsonProperty("specimens")
  public Collection<Specimen> getSpecimens() {
    return specimens;
  }

  public void addSpecimen(Specimen specimen) {
    specimens.add(specimen);
  }

  @JsonProperty("specimens")
  public void setSpecimens(Collection<Specimen> specimens) {
    this.specimens = specimens;
  }

  public Donor withSpecimens(Collection<Specimen> specimens) {
    this.specimens = specimens;
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

  public Donor withAdditionalProperty(String name, Object value) {
    this.additionalProperties.put(name, value);
    return this;
  }

  public enum DonorGender {

    MALE("male"), FEMALE("female"), UNSPECIFIED("unspecified");

    private final String value;
    private final static Map<String, DonorGender> CONSTANTS = new HashMap<String, DonorGender>();

    static {
      for (DonorGender c : DonorGender.values()) {
        CONSTANTS.put(c.value, c);
      }
    }

    DonorGender(String value) {
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
    public static DonorGender fromValue(String value) {
      DonorGender constant = CONSTANTS.get(value);
      if (constant == null) {
        throw new IllegalArgumentException(value);
      } else {
        return constant;
      }
    }

  }
}