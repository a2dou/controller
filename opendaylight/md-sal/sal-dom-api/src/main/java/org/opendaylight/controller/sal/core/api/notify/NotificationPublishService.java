/*
 * Copyright (c) 2013 Cisco Systems, Inc. and others.  All rights reserved.
 *
 * This program and the accompanying materials are made available under the
 * terms of the Eclipse Public License v1.0 which accompanies this distribution,
 * and is available at http://www.eclipse.org/legal/epl-v10.html
 */
package org.opendaylight.controller.sal.core.api.notify;

import org.opendaylight.controller.md.sal.dom.api.DOMService;
import org.opendaylight.yangtools.yang.data.api.CompositeNode;

/**
 * Notification Publishing Service
 *
 * The simplified process of the notification publishing is following:
 *
 * <ol>
 * <li> {@link org.opendaylight.controller.sal.core.api.Provider} invokes {@link #sendNotification(CompositeNode)}
 * <li> {@link org.opendaylight.controller.sal.core.api.Broker} finds {@link NotificationListener}s which subscribed for
 * the notification type.
 *
 * <li>For each subscriber {@link org.opendaylight.controller.sal.core.api.Broker} invokes
 * {@link NotificationListener#onNotification(CompositeNode)}
 * </ol>
 */
public interface NotificationPublishService extends NotificationService, DOMService {
    /**
     * Publishes a notification.
     *
     * Notification type is determined by the
     * {@link CompositeNode#getNodeType()} of the
     * <code>notification<code> parameter.
     *
     * @param notification
     *            Notification to publish
     */
    void publish(CompositeNode notification);
}
