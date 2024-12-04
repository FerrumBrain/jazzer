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

import com.code_intelligence.jazzer.api.BugDetectors;
import com.code_intelligence.jazzer.api.FuzzedDataProvider;
import com.code_intelligence.jazzer.junit.FuzzTest;
import java.net.ConnectException;
import java.net.Socket;

public class JUnitSsrfAllowListFuzzer {

  @FuzzTest
  void fuzzTest(FuzzedDataProvider data) throws Exception {
    BugDetectors.allowNetworkConnections(
        (host, port) -> host.equals("localhost") && port.equals(62351));
    try (Socket s = new Socket("localhost", 62351)) {
      s.getInetAddress();
    } catch (ConnectException ignored) {
    }
  }
}
