/*
 * Copyright (C) 2011 The Android Open Source Project
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


package android.filterpacks.text;

import android.filterfw.core.Filter;
import android.filterfw.core.FilterEnvironment;
import android.filterfw.core.FilterParameter;
import android.filterfw.core.Frame;
import android.filterfw.core.FrameFormat;
import android.filterfw.core.KeyValueMap;
import android.filterfw.core.MutableFrameFormat;
import android.filterfw.core.ObjectFrame;

public class StringSource extends Filter {

    @FilterParameter(name = "stringValue", isOptional = false)
    private String mString;

    private FrameFormat mOutputFormat;

    public StringSource(String name) {
        super(name);
    }

    public String[] getInputNames() {
        return null;
    }

    public String[] getOutputNames() {
        return new String[] { "string" };
    }

    public boolean setInputFormat(int index, FrameFormat format) {
        return false;
    }

    public FrameFormat getFormatForOutput(int index) {
        mOutputFormat = new FrameFormat(FrameFormat.TYPE_OBJECT, FrameFormat.TARGET_JAVA);
        return mOutputFormat;
    }

    public int process(FilterEnvironment env) {
        Frame output = env.getFrameManager().newEmptyFrame(mOutputFormat);
        output.setObjectValue(mString);
        putOutput(0, output);
        return Filter.STATUS_FINISHED;
    }


}