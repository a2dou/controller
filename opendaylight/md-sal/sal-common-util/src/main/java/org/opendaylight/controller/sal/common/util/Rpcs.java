/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.sal.common.util;

import com.google.common.collect.ImmutableList;
import java.util.Collection;
import org.opendaylight.yangtools.concepts.Immutable;
import org.opendaylight.yangtools.yang.common.RpcError;
import org.opendaylight.yangtools.yang.common.RpcResult;

/**
 * Deprecated.
 *
 * @deprecated Use {@link org.opendaylight.yangtools.yang.common.RpcResultBuilder}
 */
@Deprecated
public final class Rpcs {
    private Rpcs() {
    }

    public static <T> RpcResult<T> getRpcResult(boolean successful) {
        return new RpcResultTO<>(successful, null, ImmutableList.of());
    }

    public static <T> RpcResult<T> getRpcResult(boolean successful, T result,
            Collection<RpcError> errors) {
        return new RpcResultTO<>(successful, result, errors);
    }

    public static <T> RpcResult<T> getRpcResult(boolean successful, Collection<RpcError> errors) {
        return new RpcResultTO<>(successful, null, errors);
    }

    private static class RpcResultTO<T> implements RpcResult<T>, Immutable {
        private final Collection<RpcError> errors;
        private final T result;
        private final boolean successful;

        RpcResultTO(boolean successful, T result, Collection<RpcError> errors) {
            this.successful = successful;
            this.result = result;
            this.errors = ImmutableList.copyOf(errors);
        }

        @Override
        public boolean isSuccessful() {
            return successful;
        }

        @Override
        public T getResult() {
            return result;
        }

        @Override
        public Collection<RpcError> getErrors() {
            return errors;
        }
    }
}
