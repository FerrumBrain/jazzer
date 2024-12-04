/*
 * Copyright 2024 Code Intelligence GmbH
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.example;

import com.code_intelligence.jazzer.api.FuzzerSecurityIssueLow;
import com.code_intelligence.jazzer.junit.FuzzTest;
import com.code_intelligence.jazzer.mutation.annotation.NotNull;

public class SwitchOnStringsFuzzer {
  static SwitchCoverageHelper cov = new SwitchCoverageHelper(4);

  @FuzzTest
  public void test(@NotNull String data) {
    if (cov.allBranchesCovered()) {
      throw new FuzzerSecurityIssueLow("All cases visited");
    }
    switch (data) {
      case "The Road goes ever on and on":
        cov.coverCase(0);
        break;
      case "Out from the door where it began.":
        cov.coverCase(1);
        break;
      case "Now far ahead the Road has gone,":
        cov.coverCase(2);
        break;
      case "Let others follow it who can!":
        cov.coverCase(3);
        break;
    }
  }
}
