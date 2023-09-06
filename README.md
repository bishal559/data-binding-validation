# data-binding-validation
The Data Binding Validator streamlines form field validation within the data binding framework, simplifying the process for rapid validation.


## Key Features
- **Minimum/Maximum Length Validation:** Easily enforce character limits for text fields.
- **Field Type Validation:** Validate inputs based on specific field types, such as email, credit card, URL, CPF, and more.
- **Multi-Language Support:** Pre-defined error messages available in English, Portuguese, and Spanish.
- **Custom Error Messages:** Tailor error messages for individual fields as needed.
- **UI Component Compatibility:** Compatible with TextInputLayout and EditText for seamless integration.


## Sample
https://github.com/bishal559/data-binding-validation/assets/65449966/bc44f602-fac9-400a-9a8f-520aaaca8138


## Usage Instructions:

To enable Data Binding for the use of this library, follow these steps:

1. Open your main module's `build.gradle` file.

2. Inside the `android` block, add the following code:

   ```gradle
   android {
       // ...
       
       dataBinding {
           enabled = true
       }
   }
   ```

3. Sync your project with Gradle to apply the changes.

Enabling Data Binding allows you to harness the power of this library's data binding capabilities within your Android application.


Setting Up Validations Directly in Layouts:

You can configure validations for input fields directly during layout creation. The library comes with pre-configured error messages in multiple languages, eliminating the need for additional developer input. Here are the available validation types:

**Validate Characters Length:**

To set character length validation, use `validateMinLength` or `validateMaxLength` attributes within your EditText element. You can configure a minimum or maximum character length as follows:

```xml
<com.google.android.material.textfield.TextInputEditText
    android:id="@+id/editText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:validateMinLength="5" <!-- Minimum character length -->
    app:validateMaxLength="10" <!-- Maximum character length -->
    />
```

By adding these attributes, you enforce character length constraints on the input field, and the library will handle validation and error messages for you.

**Validate Empty Characters:**

Adding `validateEmpty`, you can validate if the `EditText` is empty:


```xml
<com.google.android.material.textfield.TextInputEditText
    android:id="@+id/editText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:validateEmpty="@{true}"
    />
```
**Validate Date Patterns:**
To validate date patterns with an EditText using the library, you can use the `validateDate` attribute and specify the accepted date pattern directly in your layout XML file. Here's an example:

```xml
<com.google.android.material.textfield.TextInputEditText
    android:id="@+id/editText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:validateDate="dd/MM/yyyy" <!-- Specify the accepted date pattern -->
    />
```

By adding the `app:validateDate="dd/MM/yyyy"` attribute, you set a validation rule for the EditText to accept dates in the "dd/MM/yyyy" format. The library will handle the validation and ensure that the input matches the specified date pattern. If the input doesn't match the pattern, appropriate error messages will be displayed.

**Validate Regex:**
To validate an EditText using a custom regular expression pattern, you can use the `validateRegex` attribute directly in your layout XML file. Here's an example:

```xml
<com.google.android.material.textfield.TextInputEditText
    android:id="@+id/editText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:validateRegex="[0-9]{4}-[0-9]{2}-[0-9]{2}" <!-- Specify the custom regular expression pattern -->
    />
```

In this example, we've added the `app:validateRegex="[0-9]{4}-[0-9]{2}-[0-9]{2}"` attribute, which sets a validation rule for the EditText using a regular expression pattern. The library will validate the input against the specified regular expression. If the input does not match the pattern, appropriate error messages will be displayed.

You can customize the regular expression pattern within the `app:validateRegex` attribute to match your specific validation requirements.


**Validate Input Types:**
Certainly, you can validate various types of input using the library, including email, URL, username, credit card numbers, CPF (Brazilian individual taxpayer registry number), CEP (Brazilian postal code), and more. Here's an example of how you can use these validation types:

```xml
<com.google.android.material.textfield.TextInputEditText
    android:id="@+id/emailEditText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:validateEmail="true" <!-- Validate email input -->
    />

<com.google.android.material.textfield.TextInputEditText
    android:id="@+id/urlEditText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:validateURL="true" <!-- Validate URL input -->
    />

<com.google.android.material.textfield.TextInputEditText
    android:id="@+id/usernameEditText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:validateUsername="true" <!-- Validate username input -->
    />

<com.google.android.material.textfield.TextInputEditText
    android:id="@+id/creditCardEditText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:validateCreditCard="true" <!-- Validate credit card input -->
    />

<com.google.android.material.textfield.TextInputEditText
    android:id="@+id/cpfEditText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:validateCPF="true" <!-- Validate CPF input -->
    />

<com.google.android.material.textfield.TextInputEditText
    android:id="@+id/cepEditText"
    android:layout_width="wrap_content"
    android:layout_height="wrap_content"
    app:validateCEP="true" <!-- Validate CEP input -->
    />
```

By adding these attributes to your EditText elements, you enable specific input validations. The library will handle the validation and display appropriate error messages if the input does not meet the specified criteria for each validation type.




### Applying Validation ###

To apply validation using the library, follow these steps:

1. Instantiate the `Validator` class, passing your `ViewDataBinding` instance obtained from your layout binding as an argument.

Example:

```
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBindings.root)
        initialization()
    }

    private fun initialization(){
        validator = Validator(dataBindings)
        with(dataBindings){
            edName.addTextChangedListener {
                validator.validate(edName)
            }
            edEmail.addTextChangedListener {
                validator.validate(edEmail)
            }
            edUserName.addTextChangedListener {
                validator.validate(edUserName)
            }
            edUrl.addTextChangedListener {
                validator.validate(edUrl)
            }
            edCreditCard.addTextChangedListener {
                validator.validate(edCreditCard)
            }
            edCPF.addTextChangedListener {
                validator.validate(edCPF)
            }
            edDate.addTextChangedListener {
                validator.validate(edDate)
            }
            edRegex.addTextChangedListener {
                validator.validate(edRegex)
            }
            btnValidate.setOnClickListener {
                if(validator.validate()){
                    Toast.makeText(this@MainActivity,"Validation Success",Toast.LENGTH_LONG).show()
                }
            }
        }
    }
```

Alternatively, you can use `toValidate()` if you prefer using a listener to handle the validation response:

2. Implement the `ValidationListener` interface in your activity and override its methods `onValidationSuccess()` and `onValidationError()`.

Example:

```
override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        dataBindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(dataBindings.root)
        initialization()
    }

    private fun initialization(){
        validator = Validator(dataBindings)
        with(dataBindings){
            edName.addTextChangedListener {
                validator.validate(edName)
            }
            edEmail.addTextChangedListener {
                validator.validate(edEmail)
            }
            edUserName.addTextChangedListener {
                validator.validate(edUserName)
            }
            edUrl.addTextChangedListener {
                validator.validate(edUrl)
            }
            edCreditCard.addTextChangedListener {
                validator.validate(edCreditCard)
            }
            edCPF.addTextChangedListener {
                validator.validate(edCPF)
            }
            edDate.addTextChangedListener {
                validator.validate(edDate)
            }
            edRegex.addTextChangedListener {
                validator.validate(edRegex)
            }
            btnValidate.setOnClickListener {
                if(validator.validate()){
                    Toast.makeText(this@MainActivity,"Validation Success",Toast.LENGTH_LONG).show()
                }
            }
        }
    }

    override fun onValidationSuccess() {
        
    }

    override fun onValidationError() {
        
    }
```

By following these steps, you can easily apply validation to your forms and handle both success and error cases accordingly.



### Custom Error Messages ###

You can provide custom error messages for your validation rules by using the same validation rule name and appending `Message` at the end. For instance, you can use `validateTypeMessage`, `validateDateMessage`, `validateRegexMessage`, and so on. Here's an example:

```xml
<com.google.android.material.textfield.TextInputEditText
  android:id="@+id/date"
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  android:hint="Name"
  app:validateDate='@{"dd/MM/yyyy"}'
  app:validateDateMessage="@{@string/dateErrorMessage}" />
```

In this example, we've set a custom error message for the `validateDate` rule using `app:validateDateMessage`. You can customize error messages for other validation rules in a similar way.

### Validating Fields ###

To perform validation, you have several options:

- To validate all fields, call `validator.validate()`.
- To validate specific views, use `validator.validate(view)` or `validator.validate(viewsList)`.

This allows you to choose whether to validate the entire form or specific views based on your requirements.

### Validation Modes ###

The library supports two validation modes: field-by-field validation (default) and whole-form validation. By default, it is configured to validate each field individually. However, you can switch to whole-form validation mode by calling `validator.enableFormValidationMode();`. To return to the default field-by-field mode, use `validator.enableFieldValidationMode();`.

### Auto Dismiss Error Messages ###

By default, error messages are displayed, but they do not automatically disappear. However, you can enable auto-dismissal of error messages by adding the same validation rule name with `AutoDismiss` appended at the end. This attribute should take a boolean value.

Example:

```xml
<com.google.android.material.textfield.TextInputEditText
  android:id="@+id/date"
  android:layout_width="match_parent"
  android:layout_height="wrap_content"
  android:hint="Name"
  app:validateDate='@{"dd/MM/yyyy"}'
  app:validateDateMessage="@{@string/dateErrorMessage}"
  app:validateDateAutoDismiss="@{true}" />
```

In this example, we've added `app:validateDateAutoDismiss="@{true}"`, which enables the automatic dismissal of the error message for the `validateDate` rule when the validation criteria are met.


## License ##

```
Copyright 2017-present Bishal Adhikari

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

   [http://www.apache.org/licenses/LICENSE-2.0](http://www.apache.org/licenses/LICENSE-2.0)

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
