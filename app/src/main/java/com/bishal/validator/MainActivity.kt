package com.bishal.validator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.core.widget.addTextChangedListener
import com.bishal.validationlib.Validator
import com.bishal.validator.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var validator : Validator
    private lateinit var dataBindings: ActivityMainBinding
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
}