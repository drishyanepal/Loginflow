package com.example.loginflow.data

data class RegistrationUIState(
    var firstName: String = "",
    var lastName: String = "",
    var email: String = "",
    var password: String = "",
    var checkboxTick: Boolean = false,

    var fNameNoError: Boolean = false,
    var lNameNoError: Boolean = false,
    var emailNoError: Boolean = false,
    var passwordNoError: Boolean = false,
    var checkboxNoError: Boolean = false
)
