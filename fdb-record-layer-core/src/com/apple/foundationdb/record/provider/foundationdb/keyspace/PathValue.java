/*
 * PathValue.java
 *
 * This source file is part of the FoundationDB open source project
 *
 * Copyright 2015-2018 Apple Inc. and the FoundationDB project authors
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.apple.foundationdb.record.provider.foundationdb.keyspace;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.Arrays;

/**
 * A class to represent the value stored at a particular element of a {@link KeySpacePath}. The <code>resolvedValue</code>
 * is the object that will appear in the {@link com.apple.foundationdb.tuple.Tuple} when {@link KeySpacePath#toTuple()}
 * is invoked. The <code>metadata</code> is left null by {@link KeySpaceDirectory} but other implementations may make use
 * of it (e.g. {@link DirectoryLayerDirectory}.
 */
class PathValue {
    @Nonnull
    private Object resolvedValue;
    @Nullable
    private byte[] metadata;

    PathValue(@Nonnull Object resolvedValue) {
        this(resolvedValue, null);
    }

    PathValue(@Nonnull Object resolvedValue, @Nullable byte[] metadata) {
        this.resolvedValue = resolvedValue;
        this.metadata = metadata == null ? null : Arrays.copyOf(metadata, metadata.length);
    }

    @Nonnull
    public Object getResolvedValue() {
        return resolvedValue;
    }

    @Nullable
    public byte[] getMetadata() {
        return metadata == null ? null : Arrays.copyOf(metadata, metadata.length);
    }
}