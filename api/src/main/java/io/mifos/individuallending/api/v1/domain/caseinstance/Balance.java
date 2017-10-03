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
package io.mifos.individuallending.api.v1.domain.caseinstance;

import java.math.BigDecimal;
import java.util.Objects;

/**
 * @author Myrle Krantz
 */
public class Balance {
  private String accountDesignator;
  private BigDecimal amount;

  public String getAccountDesignator() {
    return accountDesignator;
  }

  public void setAccountDesignator(String accountDesignator) {
    this.accountDesignator = accountDesignator;
  }

  public BigDecimal getAmount() {
    return amount;
  }

  public void setAmount(BigDecimal amount) {
    this.amount = amount;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Balance balance = (Balance) o;
    return Objects.equals(accountDesignator, balance.accountDesignator) &&
        Objects.equals(amount, balance.amount);
  }

  @Override
  public int hashCode() {
    return Objects.hash(accountDesignator, amount);
  }

  @Override
  public String toString() {
    return "Balance{" +
        "accountDesignator='" + accountDesignator + '\'' +
        ", amount=" + amount +
        '}';
  }
}
