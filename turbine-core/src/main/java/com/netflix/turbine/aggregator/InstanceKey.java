/**
 * Copyright 2014 Netflix, Inc.
 * 
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 * 
 * http://www.apache.org/licenses/LICENSE-2.0
 * 
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.netflix.turbine.aggregator;

public final class InstanceKey implements GroupKey {
    final String key;

    public static InstanceKey create(Number id) {
        return new InstanceKey(id.toString());
    }

    public static InstanceKey create(String id) {
        return new InstanceKey(id);
    }

    private InstanceKey(String key) {
        if (key == null) {
            throw new NullPointerException("InstanceKey can not have null key");
        }
        this.key = key;
    }

    public String getKey() {
        return key;
    }

    @Override
    public String toString() {
        return "InstanceKey=>" + key;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((key == null) ? 0 : key.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        InstanceKey other = (InstanceKey) obj;
        if (key == null) {
            if (other.key != null)
                return false;
        } else if (!key.equals(other.key))
            return false;
        return true;
    }

}