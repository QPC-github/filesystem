// Copyright 2011 Google Inc. All Rights Reserved.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//      http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.enterprise.adaptor.fs;

import com.google.enterprise.adaptor.DocId;
import com.google.enterprise.adaptor.DocIdEncoder;

import java.net.URI;
import java.net.URISyntaxException;

/**
 * Mock of {@link DocIdCodec}.
 */
class MockDocIdCodec implements DocIdEncoder {
  @Override
  public URI encodeDocId(DocId docId) {
    try {
      String id = docId.getUniqueId();
      return new URI("http", "localhost",
          id.startsWith("/") ? id : "/" + id, null);
    } catch (URISyntaxException ex) {
      throw new AssertionError();
    }
  }
}
