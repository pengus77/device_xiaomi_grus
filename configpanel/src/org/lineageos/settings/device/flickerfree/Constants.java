/*
 * Copyright (C) 2019 The MoKee Open Source Project
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

package org.lineageos.settings.device.flickerfree;

import java.util.HashMap;
import java.util.Map;

public class Constants {

    // Holds <preference_key> -> <proc_node> mapping
    protected static final Map<String, String> sBooleanNodePreferenceMap = new HashMap<>();
    protected static final Map<String, String> sIntNodePreferenceMap = new HashMap<>();

    // Holds <preference_key> -> <default_values> mapping
    protected static final Map<String, Object> sNodeDefaultMap = new HashMap<>();

    protected static final String[] sFlickerFreePrefKeys = {
        FlickerFreeConstants.FLICKER_FREE_KEY,
        FlickerFreeConstants.FLICKER_FREE_BRI_KEY,
        FlickerFreeConstants.FLICKER_FREE_EXP_KEY,
    };

    static {
        sBooleanNodePreferenceMap.put(
                FlickerFreeConstants.FLICKER_FREE_KEY,
                FlickerFreeConstants.FLICKER_FREE_NODE);

        sIntNodePreferenceMap.put(
                    FlickerFreeConstants.FLICKER_FREE_EXP_KEY,
                    FlickerFreeConstants.FLICKER_FREE_EXP_NODE);

        sIntNodePreferenceMap.put(
                FlickerFreeConstants.FLICKER_FREE_BRI_KEY,
                FlickerFreeConstants.FLICKER_FREE_BRI_NODE);

        sNodeDefaultMap.put(FlickerFreeConstants.FLICKER_FREE_KEY, false);
        sNodeDefaultMap.put(FlickerFreeConstants.FLICKER_FREE_BRI_KEY, 40);
        sNodeDefaultMap.put(FlickerFreeConstants.FLICKER_FREE_EXP_KEY, 255);
    }
}