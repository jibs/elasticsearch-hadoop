/*
 * Copyright 2013 the original author or authors.
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
package org.elasticsearch.hadoop.serialization;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.elasticsearch.hadoop.cfg.ConfigurationOptions;
import org.elasticsearch.hadoop.cfg.Settings;
import org.elasticsearch.hadoop.util.StringUtils;

public abstract class SerializationUtils {

    public static void setValueWriterIfNotSet(Settings settings, Class<? extends ValueWriter<?>> clazz, Log log) {

        if (!StringUtils.hasText(settings.getSerializerValueWriterClassName())) {
            settings.setProperty(ConfigurationOptions.ES_SERIALIZATION_WRITER_CLASS, clazz.getName());
        }

        Log logger = (log != null ? log : LogFactory.getLog(clazz));

        logger.info(String.format("Using pre-defined serializer [%s] instead of default", settings.getSerializerValueWriterClassName()));
    }
}
