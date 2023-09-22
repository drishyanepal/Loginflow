package com.example.loginflow.data

import android.util.Log
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import com.example.loginflow.data.rules.Validator
import com.example.loginflow.navigation.Router
import com.example.loginflow.navigation.Screen
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuth.AuthStateListener

class SignupViewModel : ViewModel() {
    var registrationUIState = mutableStateOf(RegistrationUIState())
    val allValidationsPassed = mutableStateOf(false)
    val circularProgressBar = mutableStateOf(false)

    fun onEvent(event: SignupUIEvent) {
        when (event) {
            is SignupUIEvent.FirstNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    firstName = event.firstName
                )
                validateDataWithRules()
            }

            is SignupUIEvent.LastNameChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    lastName = event.lastName
                )
                validateDataWithRules()

            }

            is SignupUIEvent.EmailChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    email = event.email
                )
                validateDataWithRules()
            }

            is SignupUIEvent.PasswordChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    password = event.password
                )
                validateDataWithRules()
            }

            is SignupUIEvent.CheckBoxChanged -> {
                registrationUIState.value = registrationUIState.value.copy(
                    checkboxTick = event.checkBoxStatus
                )
                validateDataWithRules()
            }

            is SignupUIEvent.RegisterButtonClicked -> {
                circularProgressBar.value = true
                signUp()
            }


        }
    }

    private fun signUp() {
        createUserInFirebase(
            email = registrationUIState.value.email,
            password = registrationUIState.value.password
        )
    }

    private fun validateDataWithRules() {
        val fNameResult = Validator.validateFirstName(registrationUIState.value.firstName)
        val lNameResult = Validator.validateLastName(registrationUIState.value.lastName)
        val emailResult = Validator.validateEmail(registrationUIState.value.email)
        val passwordResult = Validator.validatePassword(registrationUIState.value.password)
        val checkBoxResult = Validator.validateCheckBox(registrationUIState.value.checkboxTick)

        registrationUIState.value = registrationUIState.value.copy(
            fNameNoError = fNameResult.status,
            lNameNoError = lNameResult.status,
            emailNoError = emailResult.status,
            passwordNoError = passwordResult.status,
            checkboxNoError = checkBoxResult.status
        )

        allValidationsPassed.value =
            fNameResult.status && lNameResult.status && emailResult.status &&
                    passwordResult.status && checkBoxResult.status

    }

    private fun createUserInFirebase(email: String, password: String) {
        FirebaseAuth.getInstance()
            .createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    circularProgressBar.value = false
                    Router.navigateTo(Screen.HomeScreen)
                }
            }
            .addOnFailureListener {
                Log.d("FFFFFFFFFFFFFFF", "FAILED")
            }
    }

    fun logOut() {
        val firebaseAuth = FirebaseAuth.getInstance()
        Log.d("USERRRRRRRRR", firebaseAuth.currentUser.toString())
        firebaseAuth.signOut()

        val authStateListener = AuthStateListener {
            if (it.currentUser == null) {
                Router.navigateTo(Screen.SignUpScreen)
            } else {
            }
        }
        firebaseAuth.addAuthStateListener(authStateListener)
    }

}