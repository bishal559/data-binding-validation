/*
 * Copyright (c) 2017-present Ilhasoft.
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

package com.bishal.validationlib.binding;

import android.widget.TextView;

import androidx.databinding.BindingAdapter;

import com.bishal.validationlib.R;
import com.bishal.validationlib.rule.ConfirmPasswordRule;
import com.bishal.validationlib.util.EditTextHandler;
import com.bishal.validationlib.util.ErrorMessageHelper;
import com.bishal.validationlib.util.ViewTagHelper;


/**
 * Created by bishal adhikari on 08/21/23.
 */
public class PasswordBindings {

    @BindingAdapter(value = {"validatePassword", "validatePasswordMessage", "validatePasswordAutoDismiss"}, requireAll = false)
    public static void bindingPassword(TextView view, TextView comparableView, String errorMessage, boolean autoDismiss) {
        if (autoDismiss) {
            EditTextHandler.disableErrorOnChanged(view);
        }

        String handledErrorMessage = ErrorMessageHelper.getStringOrDefault(view,
                errorMessage, R.string.error_message_not_equal_password);
        ViewTagHelper.appendValue(R.id.validator_rule, view,
                new ConfirmPasswordRule(view, comparableView, handledErrorMessage));
    }

}
