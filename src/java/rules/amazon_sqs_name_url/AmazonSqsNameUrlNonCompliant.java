/*
 * Copyright Amazon.com, Inc. or its affiliates. All Rights Reserved.
 * SPDX-License-Identifier: Apache-2.0
 */

package rules.amazon_sqs_name_url;

import com.amazonaws.services.sqs.model.Message;
import stubs.sqsMetricsClient;

import java.util.concurrent.Callable;

// {fact rule=amazon-sqs-name-url@v1.0 defects=1}
public abstract class AmazonSqsNameUrlNonCompliant implements Callable<Message> {

    public void non_compliant() {
        final String queueName = "queueName";
        // Noncompliant: queue name passed to SQS instead of queue URL.
        sqsMetricsClient.changeMessageVisibility(queueName, "ReceiptHandle", "VisibilityTimeout");
    }
}
// {/fact}