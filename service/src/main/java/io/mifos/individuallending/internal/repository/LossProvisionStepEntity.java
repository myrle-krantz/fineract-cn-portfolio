/*
 * Copyright 2017 Kuelap, Inc.
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *    http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package io.mifos.individuallending.internal.repository;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Myrle Krantz
 */
@SuppressWarnings("unused")
@Entity
@Table(name = "bastet_p_arrears_config")
public class LossProvisionStepEntity {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  @Column(name = "id")
  private Long id;

  @Column(name = "product_id", nullable = false)
  private Long productId;

  @Column(name = "days_late", nullable = false)
  private Integer daysLate;

  @Column(name = "percent_provision", nullable = false)
  private BigDecimal percentProvision;

  public Long getId() {
    return id;
  }

  public void setId(Long id) {
    this.id = id;
  }

  public Long getProductId() {
    return productId;
  }

  public void setProductId(Long productId) {
    this.productId = productId;
  }

  public Integer getDaysLate() {
    return daysLate;
  }

  public void setDaysLate(Integer daysLate) {
    this.daysLate = daysLate;
  }

  public BigDecimal getPercentProvision() {
    return percentProvision;
  }

  public void setPercentProvision(BigDecimal percentProvision) {
    this.percentProvision = percentProvision;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    LossProvisionStepEntity that = (LossProvisionStepEntity) o;
    return Objects.equals(productId, that.productId) &&
        Objects.equals(daysLate, that.daysLate);
  }

  @Override
  public int hashCode() {
    return Objects.hash(productId, daysLate);
  }
}